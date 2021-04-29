package org.mal_lang.joh_mal_bugs.example1.test;

import core.Asset;
import core.AttackStep;
import core.AttackStepMax;
import core.AttackStepMin;
import core.Defense;
import java.lang.Boolean;
import java.lang.Override;
import java.lang.String;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Privileges extends Asset {
  public Disabled disabled;

  public AttemptAssume attemptAssume;

  public Assume assume;

  public Set<Identity> privilegeIdentities = new HashSet<>();

  public Set<Application> execPrivApps = new HashSet<>();

  public Set<Application> highPrivApps = new HashSet<>();

  public Set<Application> lowPrivApps = new HashSet<>();

  public Set<Data> readPrivData = new HashSet<>();

  public Set<Data> writePrivData = new HashSet<>();

  public Set<Data> deletePrivData = new HashSet<>();

  public Privileges(String name, boolean isDisabledEnabled) {
    super(name);
    assetClassName = "Privileges";
    if (disabled != null) {
      AttackStep.allAttackSteps.remove(disabled.disable);
    }
    Defense.allDefenses.remove(disabled);
    disabled = new Disabled(name, isDisabledEnabled);
    AttackStep.allAttackSteps.remove(attemptAssume);
    attemptAssume = new AttemptAssume(name);
    AttackStep.allAttackSteps.remove(assume);
    assume = new Assume(name);
  }

  public Privileges(String name) {
    super(name);
    assetClassName = "Privileges";
    if (disabled != null) {
      AttackStep.allAttackSteps.remove(disabled.disable);
    }
    Defense.allDefenses.remove(disabled);
    disabled = new Disabled(name, false);
    AttackStep.allAttackSteps.remove(attemptAssume);
    attemptAssume = new AttemptAssume(name);
    AttackStep.allAttackSteps.remove(assume);
    assume = new Assume(name);
  }

  public Privileges(boolean isDisabledEnabled) {
    this("Anonymous", isDisabledEnabled);
  }

  public Privileges() {
    this("Anonymous");
  }

  public void addPrivilegeIdentities(Identity privilegeIdentities) {
    this.privilegeIdentities.add(privilegeIdentities);
    privilegeIdentities.identityPrivileges.add(this);
  }

  public void addExecPrivApps(Application execPrivApps) {
    this.execPrivApps.add(execPrivApps);
    execPrivApps.executionPrivAppPriv.add(this);
  }

  public void addHighPrivApps(Application highPrivApps) {
    this.highPrivApps.add(highPrivApps);
    highPrivApps.highPrivAppPriv.add(this);
  }

  public void addLowPrivApps(Application lowPrivApps) {
    this.lowPrivApps.add(lowPrivApps);
    lowPrivApps.lowPrivAppPriv.add(this);
  }

  public void addReadPrivData(Data readPrivData) {
    this.readPrivData.add(readPrivData);
    readPrivData.readingPriv.add(this);
  }

  public void addWritePrivData(Data writePrivData) {
    this.writePrivData.add(writePrivData);
    writePrivData.writingPriv.add(this);
  }

  public void addDeletePrivData(Data deletePrivData) {
    this.deletePrivData.add(deletePrivData);
    deletePrivData.deletingPriv.add(this);
  }

  @Override
  public String getAssociatedAssetClassName(String field) {
    if (field.equals("privilegeIdentities")) {
      return Identity.class.getName();
    } else if (field.equals("execPrivApps")) {
      return Application.class.getName();
    } else if (field.equals("highPrivApps")) {
      return Application.class.getName();
    } else if (field.equals("lowPrivApps")) {
      return Application.class.getName();
    } else if (field.equals("readPrivData")) {
      return Data.class.getName();
    } else if (field.equals("writePrivData")) {
      return Data.class.getName();
    } else if (field.equals("deletePrivData")) {
      return Data.class.getName();
    }
    return "";
  }

  @Override
  public Set<Asset> getAssociatedAssets(String field) {
    Set<Asset> assets = new HashSet<>();
    if (field.equals("privilegeIdentities")) {
      assets.addAll(privilegeIdentities);
    } else if (field.equals("execPrivApps")) {
      assets.addAll(execPrivApps);
    } else if (field.equals("highPrivApps")) {
      assets.addAll(highPrivApps);
    } else if (field.equals("lowPrivApps")) {
      assets.addAll(lowPrivApps);
    } else if (field.equals("readPrivData")) {
      assets.addAll(readPrivData);
    } else if (field.equals("writePrivData")) {
      assets.addAll(writePrivData);
    } else if (field.equals("deletePrivData")) {
      assets.addAll(deletePrivData);
    }
    return assets;
  }

  @Override
  public Set<Asset> getAllAssociatedAssets() {
    Set<Asset> assets = new HashSet<>();
    assets.addAll(privilegeIdentities);
    assets.addAll(execPrivApps);
    assets.addAll(highPrivApps);
    assets.addAll(lowPrivApps);
    assets.addAll(readPrivData);
    assets.addAll(writePrivData);
    assets.addAll(deletePrivData);
    return assets;
  }

  @Override
  public HashMap<String, HashSet<Asset>> getFields() {
    var fields = super.getFields();
    fields.put("privilegeIdentities", new HashSet<Asset>());
    fields.get("privilegeIdentities").addAll(privilegeIdentities);
    fields.put("execPrivApps", new HashSet<Asset>());
    fields.get("execPrivApps").addAll(execPrivApps);
    fields.put("highPrivApps", new HashSet<Asset>());
    fields.get("highPrivApps").addAll(highPrivApps);
    fields.put("lowPrivApps", new HashSet<Asset>());
    fields.get("lowPrivApps").addAll(lowPrivApps);
    fields.put("readPrivData", new HashSet<Asset>());
    fields.get("readPrivData").addAll(readPrivData);
    fields.put("writePrivData", new HashSet<Asset>());
    fields.get("writePrivData").addAll(writePrivData);
    fields.put("deletePrivData", new HashSet<Asset>());
    fields.get("deletePrivData").addAll(deletePrivData);
    return fields;
  }

  public class Disabled extends Defense {
    public Disabled(String name) {
      this(name, false);
    }

    public Disabled(String name, Boolean isEnabled) {
      super(name);
      defaultValue = isEnabled;
      disable = new Disable(name);
    }

    public class Disable extends AttackStepMin {
      private Set<AttackStep> _cacheChildrenDisabled;

      public Disable(String name) {
        super(name);
      }

      @Override
      public void updateChildren(Set<AttackStep> attackSteps) {
        if (_cacheChildrenDisabled == null) {
          _cacheChildrenDisabled = new HashSet<>();
          _cacheChildrenDisabled.add(assume);
        }
        for (AttackStep attackStep : _cacheChildrenDisabled) {
          attackStep.updateTtc(this, ttc, attackSteps);
        }
      }

      @Override
      public Set<AttackStep> getAttackStepChildren() {
        var tmp = super.getAttackStepChildren();
        tmp.add(assume);
        return tmp;
      }

      @Override
      public String fullName() {
        return "Privileges.disabled";
      }
    }
  }

  public class AttemptAssume extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAttemptAssume;

    private Set<AttackStep> _cacheParentAttemptAssume;

    public AttemptAssume(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAttemptAssume == null) {
        _cacheChildrenAttemptAssume = new HashSet<>();
        _cacheChildrenAttemptAssume.add(assume);
      }
      for (AttackStep attackStep : _cacheChildrenAttemptAssume) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepChildren() {
      var tmp = super.getAttackStepChildren();
      tmp.add(assume);
      return tmp;
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAttemptAssume == null) {
        _cacheParentAttemptAssume = new HashSet<>();
        for (Identity _0 : privilegeIdentities) {
          _cacheParentAttemptAssume.add(_0.assume);
        }
      }
      for (AttackStep attackStep : _cacheParentAttemptAssume) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepParents() {
      var tmp = super.getAttackStepParents();
      for (Identity _1 : privilegeIdentities) {
        tmp.add(_1.assume);
      }
      return tmp;
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Privileges.attemptAssume");
    }
  }

  public class Assume extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenAssume;

    private Set<AttackStep> _cacheParentAssume;

    public Assume(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAssume == null) {
        _cacheChildrenAssume = new HashSet<>();
        for (Application _0 : execPrivApps) {
          _cacheChildrenAssume.add(_0.authenticate);
        }
        for (Application _1 : highPrivApps) {
          _cacheChildrenAssume.add(_1.authenticate);
        }
        for (Application _2 : lowPrivApps) {
          _cacheChildrenAssume.add(_2.specificAccessAuthenticate);
        }
        for (Data _3 : readPrivData) {
          _cacheChildrenAssume.add(_3.identityAttemptRead);
        }
        for (Data _4 : writePrivData) {
          _cacheChildrenAssume.add(_4.identityAttemptWrite);
        }
        for (Data _5 : deletePrivData) {
          _cacheChildrenAssume.add(_5.identityAttemptDelete);
        }
      }
      for (AttackStep attackStep : _cacheChildrenAssume) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepChildren() {
      var tmp = super.getAttackStepChildren();
      for (Application _6 : execPrivApps) {
        tmp.add(_6.authenticate);
      }
      for (Application _7 : highPrivApps) {
        tmp.add(_7.authenticate);
      }
      for (Application _8 : lowPrivApps) {
        tmp.add(_8.specificAccessAuthenticate);
      }
      for (Data _9 : readPrivData) {
        tmp.add(_9.identityAttemptRead);
      }
      for (Data _a : writePrivData) {
        tmp.add(_a.identityAttemptWrite);
      }
      for (Data _b : deletePrivData) {
        tmp.add(_b.identityAttemptDelete);
      }
      return tmp;
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAssume == null) {
        _cacheParentAssume = new HashSet<>();
        _cacheParentAssume.add(disabled.disable);
        _cacheParentAssume.add(attemptAssume);
      }
      for (AttackStep attackStep : _cacheParentAssume) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepParents() {
      var tmp = super.getAttackStepParents();
      tmp.add(disabled.disable);
      tmp.add(attemptAssume);
      return tmp;
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Privileges.assume");
    }
  }
}
