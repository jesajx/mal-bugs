package org.mal_lang.joh_mal_bugs.example1.test;

import core.Asset;
import core.AttackStep;
import core.AttackStepMin;
import java.lang.Override;
import java.lang.String;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class SoftwareProduct extends Asset {
  public CompromiseApplication compromiseApplication;

  public ReadApplication readApplication;

  public ModifyApplication modifyApplication;

  public DenyApplication denyApplication;

  public Set<Vulnerability> softProductVulnerabilities = new HashSet<>();

  public Set<Application> softApplications = new HashSet<>();

  public Data originData = null;

  public SoftwareProduct(String name) {
    super(name);
    assetClassName = "SoftwareProduct";
    AttackStep.allAttackSteps.remove(compromiseApplication);
    compromiseApplication = new CompromiseApplication(name);
    AttackStep.allAttackSteps.remove(readApplication);
    readApplication = new ReadApplication(name);
    AttackStep.allAttackSteps.remove(modifyApplication);
    modifyApplication = new ModifyApplication(name);
    AttackStep.allAttackSteps.remove(denyApplication);
    denyApplication = new DenyApplication(name);
  }

  public SoftwareProduct() {
    this("Anonymous");
  }

  public void addSoftProductVulnerabilities(Vulnerability softProductVulnerabilities) {
    this.softProductVulnerabilities.add(softProductVulnerabilities);
    softProductVulnerabilities.softwareProduct = this;
  }

  public void addSoftApplications(Application softApplications) {
    this.softApplications.add(softApplications);
    softApplications.appSoftProduct = this;
  }

  public void addOriginData(Data originData) {
    this.originData = originData;
    originData.originSoftwareProduct = this;
  }

  @Override
  public String getAssociatedAssetClassName(String field) {
    if (field.equals("softProductVulnerabilities")) {
      return Vulnerability.class.getName();
    } else if (field.equals("softApplications")) {
      return Application.class.getName();
    } else if (field.equals("originData")) {
      return Data.class.getName();
    }
    return "";
  }

  @Override
  public Set<Asset> getAssociatedAssets(String field) {
    Set<Asset> assets = new HashSet<>();
    if (field.equals("softProductVulnerabilities")) {
      assets.addAll(softProductVulnerabilities);
    } else if (field.equals("softApplications")) {
      assets.addAll(softApplications);
    } else if (field.equals("originData")) {
      if (originData != null) {
        assets.add(originData);
      }
    }
    return assets;
  }

  @Override
  public Set<Asset> getAllAssociatedAssets() {
    Set<Asset> assets = new HashSet<>();
    assets.addAll(softProductVulnerabilities);
    assets.addAll(softApplications);
    if (originData != null) {
      assets.add(originData);
    }
    return assets;
  }

  @Override
  public HashMap<String, HashSet<Asset>> getFields() {
    var fields = super.getFields();
    fields.put("softProductVulnerabilities", new HashSet<Asset>());
    fields.get("softProductVulnerabilities").addAll(softProductVulnerabilities);
    fields.put("softApplications", new HashSet<Asset>());
    fields.get("softApplications").addAll(softApplications);
    fields.put("originData", new HashSet<Asset>());
    if (originData != null) {
      fields.get("originData").add(originData);
    }
    return fields;
  }

  public class CompromiseApplication extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenCompromiseApplication;

    private Set<AttackStep> _cacheParentCompromiseApplication;

    public CompromiseApplication(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenCompromiseApplication == null) {
        _cacheChildrenCompromiseApplication = new HashSet<>();
        for (Application _0 : softApplications) {
          _cacheChildrenCompromiseApplication.add(_0.attemptFullAccessAfterSoftProdVulnerability);
        }
      }
      for (AttackStep attackStep : _cacheChildrenCompromiseApplication) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepChildren() {
      var tmp = super.getAttackStepChildren();
      for (Application _1 : softApplications) {
        tmp.add(_1.attemptFullAccessAfterSoftProdVulnerability);
      }
      return tmp;
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentCompromiseApplication == null) {
        _cacheParentCompromiseApplication = new HashSet<>();
        for (Vulnerability _2 : softProductVulnerabilities) {
          if (_2 instanceof UnknownVulnerability) {
            _cacheParentCompromiseApplication.add(((org.mal_lang.joh_mal_bugs.example1.test.UnknownVulnerability) _2).codeExecution);
          }
        }
        for (Vulnerability _3 : softProductVulnerabilities) {
          if (_3 instanceof ManualHighImpactVulnerability) {
            _cacheParentCompromiseApplication.add(((org.mal_lang.joh_mal_bugs.example1.test.ManualHighImpactVulnerability) _3).impact);
          }
        }
        for (Vulnerability _4 : softProductVulnerabilities) {
          for (Exploit _5 : _4.exploits) {
            if (_5 instanceof HHHExploit) {
              _cacheParentCompromiseApplication.add(((org.mal_lang.joh_mal_bugs.example1.test.HHHExploit) _5).impact);
            }
          }
        }
        if (originData != null) {
          _cacheParentCompromiseApplication.add(originData.compromiseAppOrigin);
        }
      }
      for (AttackStep attackStep : _cacheParentCompromiseApplication) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepParents() {
      var tmp = super.getAttackStepParents();
      for (Vulnerability _6 : softProductVulnerabilities) {
        if (_6 instanceof UnknownVulnerability) {
          tmp.add(((org.mal_lang.joh_mal_bugs.example1.test.UnknownVulnerability) _6).codeExecution);
        }
      }
      for (Vulnerability _7 : softProductVulnerabilities) {
        if (_7 instanceof ManualHighImpactVulnerability) {
          tmp.add(((org.mal_lang.joh_mal_bugs.example1.test.ManualHighImpactVulnerability) _7).impact);
        }
      }
      for (Vulnerability _8 : softProductVulnerabilities) {
        for (Exploit _9 : _8.exploits) {
          if (_9 instanceof HHHExploit) {
            tmp.add(((org.mal_lang.joh_mal_bugs.example1.test.HHHExploit) _9).impact);
          }
        }
      }
      if (originData != null) {
        tmp.add(originData.compromiseAppOrigin);
      }
      return tmp;
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("SoftwareProduct.compromiseApplication");
    }
  }

  public class ReadApplication extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenReadApplication;

    private Set<AttackStep> _cacheParentReadApplication;

    public ReadApplication(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenReadApplication == null) {
        _cacheChildrenReadApplication = new HashSet<>();
        for (Application _0 : softApplications) {
          _cacheChildrenReadApplication.add(_0.attemptReadAfterSoftProdVulnerability);
        }
      }
      for (AttackStep attackStep : _cacheChildrenReadApplication) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepChildren() {
      var tmp = super.getAttackStepChildren();
      for (Application _1 : softApplications) {
        tmp.add(_1.attemptReadAfterSoftProdVulnerability);
      }
      return tmp;
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentReadApplication == null) {
        _cacheParentReadApplication = new HashSet<>();
        for (Vulnerability _2 : softProductVulnerabilities) {
          if (_2 instanceof UnknownVulnerability) {
            _cacheParentReadApplication.add(((org.mal_lang.joh_mal_bugs.example1.test.UnknownVulnerability) _2).read);
          }
        }
        for (Vulnerability _3 : softProductVulnerabilities) {
          if (_3 instanceof ManualLowImpactVulnerability) {
            _cacheParentReadApplication.add(((org.mal_lang.joh_mal_bugs.example1.test.ManualLowImpactVulnerability) _3).lowImpact);
          }
        }
        for (Vulnerability _4 : softProductVulnerabilities) {
          for (Exploit _5 : _4.exploits) {
            if (_5 instanceof AutomaticExploit) {
              _cacheParentReadApplication.add(((org.mal_lang.joh_mal_bugs.example1.test.AutomaticExploit) _5).readImpact);
            }
          }
        }
      }
      for (AttackStep attackStep : _cacheParentReadApplication) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepParents() {
      var tmp = super.getAttackStepParents();
      for (Vulnerability _6 : softProductVulnerabilities) {
        if (_6 instanceof UnknownVulnerability) {
          tmp.add(((org.mal_lang.joh_mal_bugs.example1.test.UnknownVulnerability) _6).read);
        }
      }
      for (Vulnerability _7 : softProductVulnerabilities) {
        if (_7 instanceof ManualLowImpactVulnerability) {
          tmp.add(((org.mal_lang.joh_mal_bugs.example1.test.ManualLowImpactVulnerability) _7).lowImpact);
        }
      }
      for (Vulnerability _8 : softProductVulnerabilities) {
        for (Exploit _9 : _8.exploits) {
          if (_9 instanceof AutomaticExploit) {
            tmp.add(((org.mal_lang.joh_mal_bugs.example1.test.AutomaticExploit) _9).readImpact);
          }
        }
      }
      return tmp;
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("SoftwareProduct.readApplication");
    }
  }

  public class ModifyApplication extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenModifyApplication;

    private Set<AttackStep> _cacheParentModifyApplication;

    public ModifyApplication(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenModifyApplication == null) {
        _cacheChildrenModifyApplication = new HashSet<>();
        for (Application _0 : softApplications) {
          _cacheChildrenModifyApplication.add(_0.attemptModifyAfterSoftProdVulnerability);
        }
      }
      for (AttackStep attackStep : _cacheChildrenModifyApplication) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepChildren() {
      var tmp = super.getAttackStepChildren();
      for (Application _1 : softApplications) {
        tmp.add(_1.attemptModifyAfterSoftProdVulnerability);
      }
      return tmp;
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentModifyApplication == null) {
        _cacheParentModifyApplication = new HashSet<>();
        for (Vulnerability _2 : softProductVulnerabilities) {
          if (_2 instanceof UnknownVulnerability) {
            _cacheParentModifyApplication.add(((org.mal_lang.joh_mal_bugs.example1.test.UnknownVulnerability) _2).modify);
          }
        }
        for (Vulnerability _3 : softProductVulnerabilities) {
          if (_3 instanceof ManualLowImpactVulnerability) {
            _cacheParentModifyApplication.add(((org.mal_lang.joh_mal_bugs.example1.test.ManualLowImpactVulnerability) _3).lowImpact);
          }
        }
        for (Vulnerability _4 : softProductVulnerabilities) {
          for (Exploit _5 : _4.exploits) {
            if (_5 instanceof AutomaticExploit) {
              _cacheParentModifyApplication.add(((org.mal_lang.joh_mal_bugs.example1.test.AutomaticExploit) _5).modifyImpact);
            }
          }
        }
      }
      for (AttackStep attackStep : _cacheParentModifyApplication) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepParents() {
      var tmp = super.getAttackStepParents();
      for (Vulnerability _6 : softProductVulnerabilities) {
        if (_6 instanceof UnknownVulnerability) {
          tmp.add(((org.mal_lang.joh_mal_bugs.example1.test.UnknownVulnerability) _6).modify);
        }
      }
      for (Vulnerability _7 : softProductVulnerabilities) {
        if (_7 instanceof ManualLowImpactVulnerability) {
          tmp.add(((org.mal_lang.joh_mal_bugs.example1.test.ManualLowImpactVulnerability) _7).lowImpact);
        }
      }
      for (Vulnerability _8 : softProductVulnerabilities) {
        for (Exploit _9 : _8.exploits) {
          if (_9 instanceof AutomaticExploit) {
            tmp.add(((org.mal_lang.joh_mal_bugs.example1.test.AutomaticExploit) _9).modifyImpact);
          }
        }
      }
      return tmp;
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("SoftwareProduct.modifyApplication");
    }
  }

  public class DenyApplication extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenDenyApplication;

    private Set<AttackStep> _cacheParentDenyApplication;

    public DenyApplication(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenDenyApplication == null) {
        _cacheChildrenDenyApplication = new HashSet<>();
        for (Application _0 : softApplications) {
          _cacheChildrenDenyApplication.add(_0.attemptDenyAfterSoftProdVulnerability);
        }
      }
      for (AttackStep attackStep : _cacheChildrenDenyApplication) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepChildren() {
      var tmp = super.getAttackStepChildren();
      for (Application _1 : softApplications) {
        tmp.add(_1.attemptDenyAfterSoftProdVulnerability);
      }
      return tmp;
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentDenyApplication == null) {
        _cacheParentDenyApplication = new HashSet<>();
        for (Vulnerability _2 : softProductVulnerabilities) {
          if (_2 instanceof UnknownVulnerability) {
            _cacheParentDenyApplication.add(((org.mal_lang.joh_mal_bugs.example1.test.UnknownVulnerability) _2).deny);
          }
        }
        for (Vulnerability _3 : softProductVulnerabilities) {
          if (_3 instanceof ManualLowImpactVulnerability) {
            _cacheParentDenyApplication.add(((org.mal_lang.joh_mal_bugs.example1.test.ManualLowImpactVulnerability) _3).lowImpact);
          }
        }
        for (Vulnerability _4 : softProductVulnerabilities) {
          for (Exploit _5 : _4.exploits) {
            if (_5 instanceof AutomaticExploit) {
              _cacheParentDenyApplication.add(((org.mal_lang.joh_mal_bugs.example1.test.AutomaticExploit) _5).denyImpact);
            }
          }
        }
      }
      for (AttackStep attackStep : _cacheParentDenyApplication) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepParents() {
      var tmp = super.getAttackStepParents();
      for (Vulnerability _6 : softProductVulnerabilities) {
        if (_6 instanceof UnknownVulnerability) {
          tmp.add(((org.mal_lang.joh_mal_bugs.example1.test.UnknownVulnerability) _6).deny);
        }
      }
      for (Vulnerability _7 : softProductVulnerabilities) {
        if (_7 instanceof ManualLowImpactVulnerability) {
          tmp.add(((org.mal_lang.joh_mal_bugs.example1.test.ManualLowImpactVulnerability) _7).lowImpact);
        }
      }
      for (Vulnerability _8 : softProductVulnerabilities) {
        for (Exploit _9 : _8.exploits) {
          if (_9 instanceof AutomaticExploit) {
            tmp.add(((org.mal_lang.joh_mal_bugs.example1.test.AutomaticExploit) _9).denyImpact);
          }
        }
      }
      return tmp;
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("SoftwareProduct.denyApplication");
    }
  }
}
