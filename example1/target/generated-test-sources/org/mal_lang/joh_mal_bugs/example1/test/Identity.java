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

public class Identity extends Asset {
  public TwoFactorAuthentication twoFactorAuthentication;

  public Disabled disabled;

  public AttemptAssume attemptAssume;

  public SuccessfulAssume successfulAssume;

  public AttemptAssumeAfter2FA attemptAssumeAfter2FA;

  public SuccessfulAssumeAfter2FA successfulAssumeAfter2FA;

  public Assume assume;

  public Set<Credentials> credentials = new HashSet<>();

  public Set<User> users = new HashSet<>();

  public Set<Identity> childId = new HashSet<>();

  public Set<Identity> parentId = new HashSet<>();

  public Set<Group> memberOf = new HashSet<>();

  public Set<System> highPrivManagedSystems = new HashSet<>();

  public Set<System> lowPrivManagedSystems = new HashSet<>();

  public Set<Application> execPrivApps = new HashSet<>();

  public Set<Application> highPrivApps = new HashSet<>();

  public Set<Application> lowPrivApps = new HashSet<>();

  public Set<Data> readPrivData = new HashSet<>();

  public Set<Data> writePrivData = new HashSet<>();

  public Set<Data> deletePrivData = new HashSet<>();

  public Set<Privileges> identityPrivileges = new HashSet<>();

  public Identity(String name, boolean isTwoFactorAuthenticationEnabled,
      boolean isDisabledEnabled) {
    super(name);
    assetClassName = "Identity";
    if (twoFactorAuthentication != null) {
      AttackStep.allAttackSteps.remove(twoFactorAuthentication.disable);
    }
    Defense.allDefenses.remove(twoFactorAuthentication);
    twoFactorAuthentication = new TwoFactorAuthentication(name, isTwoFactorAuthenticationEnabled);
    if (disabled != null) {
      AttackStep.allAttackSteps.remove(disabled.disable);
    }
    Defense.allDefenses.remove(disabled);
    disabled = new Disabled(name, isDisabledEnabled);
    AttackStep.allAttackSteps.remove(attemptAssume);
    attemptAssume = new AttemptAssume(name);
    AttackStep.allAttackSteps.remove(successfulAssume);
    successfulAssume = new SuccessfulAssume(name);
    AttackStep.allAttackSteps.remove(attemptAssumeAfter2FA);
    attemptAssumeAfter2FA = new AttemptAssumeAfter2FA(name);
    AttackStep.allAttackSteps.remove(successfulAssumeAfter2FA);
    successfulAssumeAfter2FA = new SuccessfulAssumeAfter2FA(name);
    AttackStep.allAttackSteps.remove(assume);
    assume = new Assume(name);
  }

  public Identity(String name) {
    super(name);
    assetClassName = "Identity";
    if (twoFactorAuthentication != null) {
      AttackStep.allAttackSteps.remove(twoFactorAuthentication.disable);
    }
    Defense.allDefenses.remove(twoFactorAuthentication);
    twoFactorAuthentication = new TwoFactorAuthentication(name, false);
    if (disabled != null) {
      AttackStep.allAttackSteps.remove(disabled.disable);
    }
    Defense.allDefenses.remove(disabled);
    disabled = new Disabled(name, false);
    AttackStep.allAttackSteps.remove(attemptAssume);
    attemptAssume = new AttemptAssume(name);
    AttackStep.allAttackSteps.remove(successfulAssume);
    successfulAssume = new SuccessfulAssume(name);
    AttackStep.allAttackSteps.remove(attemptAssumeAfter2FA);
    attemptAssumeAfter2FA = new AttemptAssumeAfter2FA(name);
    AttackStep.allAttackSteps.remove(successfulAssumeAfter2FA);
    successfulAssumeAfter2FA = new SuccessfulAssumeAfter2FA(name);
    AttackStep.allAttackSteps.remove(assume);
    assume = new Assume(name);
  }

  public Identity(boolean isTwoFactorAuthenticationEnabled, boolean isDisabledEnabled) {
    this("Anonymous", isTwoFactorAuthenticationEnabled, isDisabledEnabled);
  }

  public Identity() {
    this("Anonymous");
  }

  public void addCredentials(Credentials credentials) {
    this.credentials.add(credentials);
    credentials.identities.add(this);
  }

  public void addUsers(User users) {
    this.users.add(users);
    users.userIds.add(this);
  }

  public void addChildId(Identity childId) {
    this.childId.add(childId);
    childId.parentId.add(this);
  }

  public void addParentId(Identity parentId) {
    this.parentId.add(parentId);
    parentId.childId.add(this);
  }

  public void addMemberOf(Group memberOf) {
    this.memberOf.add(memberOf);
    memberOf.groupIds.add(this);
  }

  public void addHighPrivManagedSystems(System highPrivManagedSystems) {
    this.highPrivManagedSystems.add(highPrivManagedSystems);
    highPrivManagedSystems.highPrivSysIds.add(this);
  }

  public void addLowPrivManagedSystems(System lowPrivManagedSystems) {
    this.lowPrivManagedSystems.add(lowPrivManagedSystems);
    lowPrivManagedSystems.lowPrivSysIds.add(this);
  }

  public void addExecPrivApps(Application execPrivApps) {
    this.execPrivApps.add(execPrivApps);
    execPrivApps.executionPrivIds.add(this);
  }

  public void addHighPrivApps(Application highPrivApps) {
    this.highPrivApps.add(highPrivApps);
    highPrivApps.highPrivAppIds.add(this);
  }

  public void addLowPrivApps(Application lowPrivApps) {
    this.lowPrivApps.add(lowPrivApps);
    lowPrivApps.lowPrivAppIds.add(this);
  }

  public void addReadPrivData(Data readPrivData) {
    this.readPrivData.add(readPrivData);
    readPrivData.readingIds.add(this);
  }

  public void addWritePrivData(Data writePrivData) {
    this.writePrivData.add(writePrivData);
    writePrivData.writingIds.add(this);
  }

  public void addDeletePrivData(Data deletePrivData) {
    this.deletePrivData.add(deletePrivData);
    deletePrivData.deletingIds.add(this);
  }

  public void addIdentityPrivileges(Privileges identityPrivileges) {
    this.identityPrivileges.add(identityPrivileges);
    identityPrivileges.privilegeIdentities.add(this);
  }

  @Override
  public String getAssociatedAssetClassName(String field) {
    if (field.equals("credentials")) {
      return Credentials.class.getName();
    } else if (field.equals("users")) {
      return User.class.getName();
    } else if (field.equals("childId")) {
      return Identity.class.getName();
    } else if (field.equals("parentId")) {
      return Identity.class.getName();
    } else if (field.equals("memberOf")) {
      return Group.class.getName();
    } else if (field.equals("highPrivManagedSystems")) {
      return System.class.getName();
    } else if (field.equals("lowPrivManagedSystems")) {
      return System.class.getName();
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
    } else if (field.equals("identityPrivileges")) {
      return Privileges.class.getName();
    }
    return "";
  }

  @Override
  public Set<Asset> getAssociatedAssets(String field) {
    Set<Asset> assets = new HashSet<>();
    if (field.equals("credentials")) {
      assets.addAll(credentials);
    } else if (field.equals("users")) {
      assets.addAll(users);
    } else if (field.equals("childId")) {
      assets.addAll(childId);
    } else if (field.equals("parentId")) {
      assets.addAll(parentId);
    } else if (field.equals("memberOf")) {
      assets.addAll(memberOf);
    } else if (field.equals("highPrivManagedSystems")) {
      assets.addAll(highPrivManagedSystems);
    } else if (field.equals("lowPrivManagedSystems")) {
      assets.addAll(lowPrivManagedSystems);
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
    } else if (field.equals("identityPrivileges")) {
      assets.addAll(identityPrivileges);
    }
    return assets;
  }

  @Override
  public Set<Asset> getAllAssociatedAssets() {
    Set<Asset> assets = new HashSet<>();
    assets.addAll(credentials);
    assets.addAll(users);
    assets.addAll(childId);
    assets.addAll(parentId);
    assets.addAll(memberOf);
    assets.addAll(highPrivManagedSystems);
    assets.addAll(lowPrivManagedSystems);
    assets.addAll(execPrivApps);
    assets.addAll(highPrivApps);
    assets.addAll(lowPrivApps);
    assets.addAll(readPrivData);
    assets.addAll(writePrivData);
    assets.addAll(deletePrivData);
    assets.addAll(identityPrivileges);
    return assets;
  }

  @Override
  public HashMap<String, HashSet<Asset>> getFields() {
    var fields = super.getFields();
    fields.put("credentials", new HashSet<Asset>());
    fields.get("credentials").addAll(credentials);
    fields.put("users", new HashSet<Asset>());
    fields.get("users").addAll(users);
    fields.put("childId", new HashSet<Asset>());
    fields.get("childId").addAll(childId);
    fields.put("parentId", new HashSet<Asset>());
    fields.get("parentId").addAll(parentId);
    fields.put("memberOf", new HashSet<Asset>());
    fields.get("memberOf").addAll(memberOf);
    fields.put("highPrivManagedSystems", new HashSet<Asset>());
    fields.get("highPrivManagedSystems").addAll(highPrivManagedSystems);
    fields.put("lowPrivManagedSystems", new HashSet<Asset>());
    fields.get("lowPrivManagedSystems").addAll(lowPrivManagedSystems);
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
    fields.put("identityPrivileges", new HashSet<Asset>());
    fields.get("identityPrivileges").addAll(identityPrivileges);
    return fields;
  }

  public class TwoFactorAuthentication extends Defense {
    public TwoFactorAuthentication(String name) {
      this(name, false);
    }

    public TwoFactorAuthentication(String name, Boolean isEnabled) {
      super(name);
      defaultValue = isEnabled;
      disable = new Disable(name);
    }

    public class Disable extends AttackStepMin {
      private Set<AttackStep> _cacheChildrenTwoFactorAuthentication;

      public Disable(String name) {
        super(name);
      }

      @Override
      public void updateChildren(Set<AttackStep> attackSteps) {
        if (_cacheChildrenTwoFactorAuthentication == null) {
          _cacheChildrenTwoFactorAuthentication = new HashSet<>();
          _cacheChildrenTwoFactorAuthentication.add(successfulAssume);
        }
        for (AttackStep attackStep : _cacheChildrenTwoFactorAuthentication) {
          attackStep.updateTtc(this, ttc, attackSteps);
        }
      }

      @Override
      public Set<AttackStep> getAttackStepChildren() {
        var tmp = super.getAttackStepChildren();
        tmp.add(successfulAssume);
        return tmp;
      }

      @Override
      public String fullName() {
        return "Identity.twoFactorAuthentication";
      }
    }
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
          _cacheChildrenDisabled.add(successfulAssume);
          _cacheChildrenDisabled.add(successfulAssumeAfter2FA);
        }
        for (AttackStep attackStep : _cacheChildrenDisabled) {
          attackStep.updateTtc(this, ttc, attackSteps);
        }
      }

      @Override
      public Set<AttackStep> getAttackStepChildren() {
        var tmp = super.getAttackStepChildren();
        tmp.add(successfulAssume);
        tmp.add(successfulAssumeAfter2FA);
        return tmp;
      }

      @Override
      public String fullName() {
        return "Identity.disabled";
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
        _cacheChildrenAttemptAssume.add(successfulAssume);
      }
      for (AttackStep attackStep : _cacheChildrenAttemptAssume) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepChildren() {
      var tmp = super.getAttackStepChildren();
      tmp.add(successfulAssume);
      return tmp;
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAttemptAssume == null) {
        _cacheParentAttemptAssume = new HashSet<>();
        for (Credentials _0 : credentials) {
          _cacheParentAttemptAssume.add(_0.use);
        }
        for (User _1 : users) {
          _cacheParentAttemptAssume.add(_1.compromise);
        }
      }
      for (AttackStep attackStep : _cacheParentAttemptAssume) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepParents() {
      var tmp = super.getAttackStepParents();
      for (Credentials _2 : credentials) {
        tmp.add(_2.use);
      }
      for (User _3 : users) {
        tmp.add(_3.compromise);
      }
      return tmp;
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Identity.attemptAssume");
    }
  }

  public class SuccessfulAssume extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenSuccessfulAssume;

    private Set<AttackStep> _cacheParentSuccessfulAssume;

    public SuccessfulAssume(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenSuccessfulAssume == null) {
        _cacheChildrenSuccessfulAssume = new HashSet<>();
        _cacheChildrenSuccessfulAssume.add(assume);
      }
      for (AttackStep attackStep : _cacheChildrenSuccessfulAssume) {
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
      if (_cacheParentSuccessfulAssume == null) {
        _cacheParentSuccessfulAssume = new HashSet<>();
        _cacheParentSuccessfulAssume.add(twoFactorAuthentication.disable);
        _cacheParentSuccessfulAssume.add(disabled.disable);
        _cacheParentSuccessfulAssume.add(attemptAssume);
      }
      for (AttackStep attackStep : _cacheParentSuccessfulAssume) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepParents() {
      var tmp = super.getAttackStepParents();
      tmp.add(twoFactorAuthentication.disable);
      tmp.add(disabled.disable);
      tmp.add(attemptAssume);
      return tmp;
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Identity.successfulAssume");
    }
  }

  public class AttemptAssumeAfter2FA extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAttemptAssumeAfter2FA;

    private Set<AttackStep> _cacheParentAttemptAssumeAfter2FA;

    public AttemptAssumeAfter2FA(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAttemptAssumeAfter2FA == null) {
        _cacheChildrenAttemptAssumeAfter2FA = new HashSet<>();
        _cacheChildrenAttemptAssumeAfter2FA.add(successfulAssumeAfter2FA);
      }
      for (AttackStep attackStep : _cacheChildrenAttemptAssumeAfter2FA) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepChildren() {
      var tmp = super.getAttackStepChildren();
      tmp.add(successfulAssumeAfter2FA);
      return tmp;
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAttemptAssumeAfter2FA == null) {
        _cacheParentAttemptAssumeAfter2FA = new HashSet<>();
        for (User _0 : users) {
          _cacheParentAttemptAssumeAfter2FA.add(_0.steal2FAtoken);
        }
      }
      for (AttackStep attackStep : _cacheParentAttemptAssumeAfter2FA) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepParents() {
      var tmp = super.getAttackStepParents();
      for (User _1 : users) {
        tmp.add(_1.steal2FAtoken);
      }
      return tmp;
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Identity.attemptAssumeAfter2FA");
    }
  }

  public class SuccessfulAssumeAfter2FA extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenSuccessfulAssumeAfter2FA;

    private Set<AttackStep> _cacheParentSuccessfulAssumeAfter2FA;

    public SuccessfulAssumeAfter2FA(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenSuccessfulAssumeAfter2FA == null) {
        _cacheChildrenSuccessfulAssumeAfter2FA = new HashSet<>();
        _cacheChildrenSuccessfulAssumeAfter2FA.add(assume);
      }
      for (AttackStep attackStep : _cacheChildrenSuccessfulAssumeAfter2FA) {
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
      if (_cacheParentSuccessfulAssumeAfter2FA == null) {
        _cacheParentSuccessfulAssumeAfter2FA = new HashSet<>();
        _cacheParentSuccessfulAssumeAfter2FA.add(disabled.disable);
        _cacheParentSuccessfulAssumeAfter2FA.add(attemptAssumeAfter2FA);
      }
      for (AttackStep attackStep : _cacheParentSuccessfulAssumeAfter2FA) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepParents() {
      var tmp = super.getAttackStepParents();
      tmp.add(disabled.disable);
      tmp.add(attemptAssumeAfter2FA);
      return tmp;
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Identity.successfulAssumeAfter2FA");
    }
  }

  public class Assume extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAssume;

    private Set<AttackStep> _cacheParentAssume;

    public Assume(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAssume == null) {
        _cacheChildrenAssume = new HashSet<>();
        for (Identity _0 : parentId) {
          _cacheChildrenAssume.add(_0.assume);
        }
        for (Group _1 : memberOf) {
          _cacheChildrenAssume.add(_1.compromiseGroup);
        }
        for (Privileges _2 : identityPrivileges) {
          _cacheChildrenAssume.add(_2.attemptAssume);
        }
        for (System _3 : lowPrivManagedSystems) {
          _cacheChildrenAssume.add(_3.individualPrivilegeAuthenticate);
        }
        for (System _4 : highPrivManagedSystems) {
          _cacheChildrenAssume.add(_4.allPrivilegeAuthenticate);
        }
        for (Application _5 : execPrivApps) {
          _cacheChildrenAssume.add(_5.authenticate);
        }
        for (Application _6 : highPrivApps) {
          _cacheChildrenAssume.add(_6.authenticate);
        }
        for (Application _7 : lowPrivApps) {
          _cacheChildrenAssume.add(_7.specificAccessAuthenticate);
        }
        for (Data _8 : readPrivData) {
          _cacheChildrenAssume.add(_8.identityAttemptRead);
        }
        for (Data _9 : writePrivData) {
          _cacheChildrenAssume.add(_9.identityAttemptWrite);
        }
        for (Data _a : deletePrivData) {
          _cacheChildrenAssume.add(_a.identityAttemptDelete);
        }
      }
      for (AttackStep attackStep : _cacheChildrenAssume) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepChildren() {
      var tmp = super.getAttackStepChildren();
      for (Identity _b : parentId) {
        tmp.add(_b.assume);
      }
      for (Group _c : memberOf) {
        tmp.add(_c.compromiseGroup);
      }
      for (Privileges _d : identityPrivileges) {
        tmp.add(_d.attemptAssume);
      }
      for (System _e : lowPrivManagedSystems) {
        tmp.add(_e.individualPrivilegeAuthenticate);
      }
      for (System _f : highPrivManagedSystems) {
        tmp.add(_f.allPrivilegeAuthenticate);
      }
      for (Application _10 : execPrivApps) {
        tmp.add(_10.authenticate);
      }
      for (Application _11 : highPrivApps) {
        tmp.add(_11.authenticate);
      }
      for (Application _12 : lowPrivApps) {
        tmp.add(_12.specificAccessAuthenticate);
      }
      for (Data _13 : readPrivData) {
        tmp.add(_13.identityAttemptRead);
      }
      for (Data _14 : writePrivData) {
        tmp.add(_14.identityAttemptWrite);
      }
      for (Data _15 : deletePrivData) {
        tmp.add(_15.identityAttemptDelete);
      }
      return tmp;
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAssume == null) {
        _cacheParentAssume = new HashSet<>();
        for (System _16 : highPrivManagedSystems) {
          _cacheParentAssume.add(_16.fullAccess);
        }
        for (System _17 : lowPrivManagedSystems) {
          _cacheParentAssume.add(_17.fullAccess);
        }
        for (Application _18 : execPrivApps) {
          _cacheParentAssume.add(_18.fullAccess);
        }
        _cacheParentAssume.add(successfulAssume);
        _cacheParentAssume.add(successfulAssumeAfter2FA);
        for (Identity _19 : childId) {
          _cacheParentAssume.add(_19.assume);
        }
      }
      for (AttackStep attackStep : _cacheParentAssume) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepParents() {
      var tmp = super.getAttackStepParents();
      for (System _1a : highPrivManagedSystems) {
        tmp.add(_1a.fullAccess);
      }
      for (System _1b : lowPrivManagedSystems) {
        tmp.add(_1b.fullAccess);
      }
      for (Application _1c : execPrivApps) {
        tmp.add(_1c.fullAccess);
      }
      tmp.add(successfulAssume);
      tmp.add(successfulAssumeAfter2FA);
      for (Identity _1d : childId) {
        tmp.add(_1d.assume);
      }
      return tmp;
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Identity.assume");
    }
  }
}
