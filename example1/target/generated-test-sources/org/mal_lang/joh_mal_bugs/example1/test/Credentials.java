package org.mal_lang.joh_mal_bugs.example1.test;

import core.Asset;
import core.AttackStep;
import core.AttackStepMin;
import core.Defense;
import java.lang.Boolean;
import java.lang.Override;
import java.lang.String;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Credentials extends Information {
  public NotDisclosed notDisclosed;

  public UseLeakedCredentials useLeakedCredentials;

  public Use use;

  public CredentialTheft credentialTheft;

  public Set<Data> encryptedData = new HashSet<>();

  public Set<Identity> identities = new HashSet<>();

  public Credentials(String name, boolean isNotDisclosedEnabled) {
    super(name);
    assetClassName = "Credentials";
    if (notDisclosed != null) {
      AttackStep.allAttackSteps.remove(notDisclosed.disable);
    }
    Defense.allDefenses.remove(notDisclosed);
    notDisclosed = new NotDisclosed(name, isNotDisclosedEnabled);
    AttackStep.allAttackSteps.remove(useLeakedCredentials);
    useLeakedCredentials = new UseLeakedCredentials(name);
    AttackStep.allAttackSteps.remove(use);
    use = new Use(name);
    AttackStep.allAttackSteps.remove(attemptAccess);
    attemptAccess = new AttemptAccess(name);
    AttackStep.allAttackSteps.remove(credentialTheft);
    credentialTheft = new CredentialTheft(name);
  }

  public Credentials(String name) {
    super(name);
    assetClassName = "Credentials";
    if (notDisclosed != null) {
      AttackStep.allAttackSteps.remove(notDisclosed.disable);
    }
    Defense.allDefenses.remove(notDisclosed);
    notDisclosed = new NotDisclosed(name, true);
    AttackStep.allAttackSteps.remove(useLeakedCredentials);
    useLeakedCredentials = new UseLeakedCredentials(name);
    AttackStep.allAttackSteps.remove(use);
    use = new Use(name);
    AttackStep.allAttackSteps.remove(attemptAccess);
    attemptAccess = new AttemptAccess(name);
    AttackStep.allAttackSteps.remove(credentialTheft);
    credentialTheft = new CredentialTheft(name);
  }

  public Credentials(boolean isNotDisclosedEnabled) {
    this("Anonymous", isNotDisclosedEnabled);
  }

  public Credentials() {
    this("Anonymous");
  }

  public void addEncryptedData(Data encryptedData) {
    this.encryptedData.add(encryptedData);
    encryptedData.encryptCreds = this;
  }

  public void addIdentities(Identity identities) {
    this.identities.add(identities);
    identities.credentials.add(this);
  }

  @Override
  public String getAssociatedAssetClassName(String field) {
    if (field.equals("encryptedData")) {
      return Data.class.getName();
    } else if (field.equals("identities")) {
      return Identity.class.getName();
    }
    return "";
  }

  @Override
  public Set<Asset> getAssociatedAssets(String field) {
    Set<Asset> assets = new HashSet<>();
    if (field.equals("encryptedData")) {
      assets.addAll(encryptedData);
    } else if (field.equals("identities")) {
      assets.addAll(identities);
    }
    return assets;
  }

  @Override
  public Set<Asset> getAllAssociatedAssets() {
    Set<Asset> assets = new HashSet<>();
    assets.addAll(encryptedData);
    assets.addAll(identities);
    return assets;
  }

  @Override
  public HashMap<String, HashSet<Asset>> getFields() {
    var fields = super.getFields();
    fields.put("encryptedData", new HashSet<Asset>());
    fields.get("encryptedData").addAll(encryptedData);
    fields.put("identities", new HashSet<Asset>());
    fields.get("identities").addAll(identities);
    return fields;
  }

  public class NotDisclosed extends Defense {
    public NotDisclosed(String name) {
      this(name, true);
    }

    public NotDisclosed(String name, Boolean isEnabled) {
      super(name);
      defaultValue = isEnabled;
      disable = new Disable(name);
    }

    public class Disable extends AttackStepMin {
      private Set<AttackStep> _cacheChildrenNotDisclosed;

      public Disable(String name) {
        super(name);
      }

      @Override
      public void updateChildren(Set<AttackStep> attackSteps) {
        if (_cacheChildrenNotDisclosed == null) {
          _cacheChildrenNotDisclosed = new HashSet<>();
          _cacheChildrenNotDisclosed.add(useLeakedCredentials);
        }
        for (AttackStep attackStep : _cacheChildrenNotDisclosed) {
          attackStep.updateTtc(this, ttc, attackSteps);
        }
      }

      @Override
      public Set<AttackStep> getAttackStepChildren() {
        var tmp = super.getAttackStepChildren();
        tmp.add(useLeakedCredentials);
        return tmp;
      }

      @Override
      public String fullName() {
        return "Credentials.notDisclosed";
      }
    }
  }

  public class UseLeakedCredentials extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenUseLeakedCredentials;

    private Set<AttackStep> _cacheParentUseLeakedCredentials;

    public UseLeakedCredentials(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenUseLeakedCredentials == null) {
        _cacheChildrenUseLeakedCredentials = new HashSet<>();
        _cacheChildrenUseLeakedCredentials.add(use);
      }
      for (AttackStep attackStep : _cacheChildrenUseLeakedCredentials) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepChildren() {
      var tmp = super.getAttackStepChildren();
      tmp.add(use);
      return tmp;
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentUseLeakedCredentials == null) {
        _cacheParentUseLeakedCredentials = new HashSet<>();
        _cacheParentUseLeakedCredentials.add(notDisclosed.disable);
      }
      for (AttackStep attackStep : _cacheParentUseLeakedCredentials) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepParents() {
      var tmp = super.getAttackStepParents();
      tmp.add(notDisclosed.disable);
      return tmp;
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Credentials.useLeakedCredentials");
    }
  }

  public class Use extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenUse;

    private Set<AttackStep> _cacheParentUse;

    public Use(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenUse == null) {
        _cacheChildrenUse = new HashSet<>();
        for (Identity _0 : identities) {
          _cacheChildrenUse.add(_0.attemptAssume);
        }
        for (Data _1 : encryptedData) {
          _cacheChildrenUse.add(_1.accessDecryptedData);
        }
        for (Identity _2 : identities) {
          for (User _3 : _2.users) {
            _cacheChildrenUse.add(_3.attemptSteal2FAtoken);
          }
        }
        for (Identity _4 : identities) {
          for (User _5 : _4.users) {
            _cacheChildrenUse.add(_5.oneCredentialCompromised);
          }
        }
      }
      for (AttackStep attackStep : _cacheChildrenUse) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepChildren() {
      var tmp = super.getAttackStepChildren();
      for (Identity _6 : identities) {
        tmp.add(_6.attemptAssume);
      }
      for (Data _7 : encryptedData) {
        tmp.add(_7.accessDecryptedData);
      }
      for (Identity _8 : identities) {
        for (User _9 : _8.users) {
          tmp.add(_9.attemptSteal2FAtoken);
        }
      }
      for (Identity _a : identities) {
        for (User _b : _a.users) {
          tmp.add(_b.oneCredentialCompromised);
        }
      }
      return tmp;
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentUse == null) {
        _cacheParentUse = new HashSet<>();
        _cacheParentUse.add(useLeakedCredentials);
        _cacheParentUse.add(attemptAccess);
        _cacheParentUse.add(credentialTheft);
        for (Identity _c : identities) {
          for (User _d : _c.users) {
            _cacheParentUse.add(_d.passwordReuseCompromise);
          }
        }
      }
      for (AttackStep attackStep : _cacheParentUse) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepParents() {
      var tmp = super.getAttackStepParents();
      tmp.add(useLeakedCredentials);
      tmp.add(attemptAccess);
      tmp.add(credentialTheft);
      for (Identity _e : identities) {
        for (User _f : _e.users) {
          tmp.add(_f.passwordReuseCompromise);
        }
      }
      return tmp;
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Credentials.use");
    }
  }

  public class AttemptAccess extends Information.AttemptAccess {
    private Set<AttackStep> _cacheChildrenAttemptAccess;

    public AttemptAccess(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAttemptAccess == null) {
        _cacheChildrenAttemptAccess = new HashSet<>();
        _cacheChildrenAttemptAccess.add(use);
      }
      for (AttackStep attackStep : _cacheChildrenAttemptAccess) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepChildren() {
      var tmp = super.getAttackStepChildren();
      tmp.add(use);
      return tmp;
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Credentials.attemptAccess");
    }
  }

  public class CredentialTheft extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenCredentialTheft;

    private Set<AttackStep> _cacheParentCredentialTheft;

    public CredentialTheft(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenCredentialTheft == null) {
        _cacheChildrenCredentialTheft = new HashSet<>();
        _cacheChildrenCredentialTheft.add(use);
      }
      for (AttackStep attackStep : _cacheChildrenCredentialTheft) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepChildren() {
      var tmp = super.getAttackStepChildren();
      tmp.add(use);
      return tmp;
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentCredentialTheft == null) {
        _cacheParentCredentialTheft = new HashSet<>();
        for (Identity _0 : identities) {
          for (User _1 : _0.users) {
            _cacheParentCredentialTheft.add(_1.credentialTheft);
          }
        }
      }
      for (AttackStep attackStep : _cacheParentCredentialTheft) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepParents() {
      var tmp = super.getAttackStepParents();
      for (Identity _2 : identities) {
        for (User _3 : _2.users) {
          tmp.add(_3.credentialTheft);
        }
      }
      return tmp;
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Credentials.credentialTheft");
    }
  }
}
