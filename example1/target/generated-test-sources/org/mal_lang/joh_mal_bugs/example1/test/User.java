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

public class User extends Asset {
  public NoPasswordReuse noPasswordReuse;

  public OneCredentialCompromised oneCredentialCompromised;

  public PasswordReuseCompromise passwordReuseCompromise;

  public AttemptSocialEngineering attemptSocialEngineering;

  public AttemptCredentialTheft attemptCredentialTheft;

  public CredentialTheft credentialTheft;

  public AttemptReverseTakeover attemptReverseTakeover;

  public ReverseTakeover reverseTakeover;

  public PhishUser phishUser;

  public AttemptSteal2FAtoken attemptSteal2FAtoken;

  public Steal2FAtoken steal2FAtoken;

  public Compromise compromise;

  public Set<Identity> userIds = new HashSet<>();

  public User(String name, boolean isNoPasswordReuseEnabled) {
    super(name);
    assetClassName = "User";
    if (noPasswordReuse != null) {
      AttackStep.allAttackSteps.remove(noPasswordReuse.disable);
    }
    Defense.allDefenses.remove(noPasswordReuse);
    noPasswordReuse = new NoPasswordReuse(name, isNoPasswordReuseEnabled);
    AttackStep.allAttackSteps.remove(oneCredentialCompromised);
    oneCredentialCompromised = new OneCredentialCompromised(name);
    AttackStep.allAttackSteps.remove(passwordReuseCompromise);
    passwordReuseCompromise = new PasswordReuseCompromise(name);
    AttackStep.allAttackSteps.remove(attemptSocialEngineering);
    attemptSocialEngineering = new AttemptSocialEngineering(name);
    AttackStep.allAttackSteps.remove(attemptCredentialTheft);
    attemptCredentialTheft = new AttemptCredentialTheft(name);
    AttackStep.allAttackSteps.remove(credentialTheft);
    credentialTheft = new CredentialTheft(name);
    AttackStep.allAttackSteps.remove(attemptReverseTakeover);
    attemptReverseTakeover = new AttemptReverseTakeover(name);
    AttackStep.allAttackSteps.remove(reverseTakeover);
    reverseTakeover = new ReverseTakeover(name);
    AttackStep.allAttackSteps.remove(phishUser);
    phishUser = new PhishUser(name);
    AttackStep.allAttackSteps.remove(attemptSteal2FAtoken);
    attemptSteal2FAtoken = new AttemptSteal2FAtoken(name);
    AttackStep.allAttackSteps.remove(steal2FAtoken);
    steal2FAtoken = new Steal2FAtoken(name);
    AttackStep.allAttackSteps.remove(compromise);
    compromise = new Compromise(name);
  }

  public User(String name) {
    super(name);
    assetClassName = "User";
    if (noPasswordReuse != null) {
      AttackStep.allAttackSteps.remove(noPasswordReuse.disable);
    }
    Defense.allDefenses.remove(noPasswordReuse);
    noPasswordReuse = new NoPasswordReuse(name, true);
    AttackStep.allAttackSteps.remove(oneCredentialCompromised);
    oneCredentialCompromised = new OneCredentialCompromised(name);
    AttackStep.allAttackSteps.remove(passwordReuseCompromise);
    passwordReuseCompromise = new PasswordReuseCompromise(name);
    AttackStep.allAttackSteps.remove(attemptSocialEngineering);
    attemptSocialEngineering = new AttemptSocialEngineering(name);
    AttackStep.allAttackSteps.remove(attemptCredentialTheft);
    attemptCredentialTheft = new AttemptCredentialTheft(name);
    AttackStep.allAttackSteps.remove(credentialTheft);
    credentialTheft = new CredentialTheft(name);
    AttackStep.allAttackSteps.remove(attemptReverseTakeover);
    attemptReverseTakeover = new AttemptReverseTakeover(name);
    AttackStep.allAttackSteps.remove(reverseTakeover);
    reverseTakeover = new ReverseTakeover(name);
    AttackStep.allAttackSteps.remove(phishUser);
    phishUser = new PhishUser(name);
    AttackStep.allAttackSteps.remove(attemptSteal2FAtoken);
    attemptSteal2FAtoken = new AttemptSteal2FAtoken(name);
    AttackStep.allAttackSteps.remove(steal2FAtoken);
    steal2FAtoken = new Steal2FAtoken(name);
    AttackStep.allAttackSteps.remove(compromise);
    compromise = new Compromise(name);
  }

  public User(boolean isNoPasswordReuseEnabled) {
    this("Anonymous", isNoPasswordReuseEnabled);
  }

  public User() {
    this("Anonymous");
  }

  public void addUserIds(Identity userIds) {
    this.userIds.add(userIds);
    userIds.users.add(this);
  }

  @Override
  public String getAssociatedAssetClassName(String field) {
    if (field.equals("userIds")) {
      return Identity.class.getName();
    }
    return "";
  }

  @Override
  public Set<Asset> getAssociatedAssets(String field) {
    Set<Asset> assets = new HashSet<>();
    if (field.equals("userIds")) {
      assets.addAll(userIds);
    }
    return assets;
  }

  @Override
  public Set<Asset> getAllAssociatedAssets() {
    Set<Asset> assets = new HashSet<>();
    assets.addAll(userIds);
    return assets;
  }

  @Override
  public HashMap<String, HashSet<Asset>> getFields() {
    var fields = super.getFields();
    fields.put("userIds", new HashSet<Asset>());
    fields.get("userIds").addAll(userIds);
    return fields;
  }

  public class NoPasswordReuse extends Defense {
    public NoPasswordReuse(String name) {
      this(name, true);
    }

    public NoPasswordReuse(String name, Boolean isEnabled) {
      super(name);
      defaultValue = isEnabled;
      disable = new Disable(name);
    }

    public class Disable extends AttackStepMin {
      private Set<AttackStep> _cacheChildrenNoPasswordReuse;

      public Disable(String name) {
        super(name);
      }

      @Override
      public void updateChildren(Set<AttackStep> attackSteps) {
        if (_cacheChildrenNoPasswordReuse == null) {
          _cacheChildrenNoPasswordReuse = new HashSet<>();
          _cacheChildrenNoPasswordReuse.add(passwordReuseCompromise);
        }
        for (AttackStep attackStep : _cacheChildrenNoPasswordReuse) {
          attackStep.updateTtc(this, ttc, attackSteps);
        }
      }

      @Override
      public Set<AttackStep> getAttackStepChildren() {
        var tmp = super.getAttackStepChildren();
        tmp.add(passwordReuseCompromise);
        return tmp;
      }

      @Override
      public String fullName() {
        return "User.noPasswordReuse";
      }
    }
  }

  public class OneCredentialCompromised extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenOneCredentialCompromised;

    private Set<AttackStep> _cacheParentOneCredentialCompromised;

    public OneCredentialCompromised(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenOneCredentialCompromised == null) {
        _cacheChildrenOneCredentialCompromised = new HashSet<>();
        _cacheChildrenOneCredentialCompromised.add(passwordReuseCompromise);
      }
      for (AttackStep attackStep : _cacheChildrenOneCredentialCompromised) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepChildren() {
      var tmp = super.getAttackStepChildren();
      tmp.add(passwordReuseCompromise);
      return tmp;
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentOneCredentialCompromised == null) {
        _cacheParentOneCredentialCompromised = new HashSet<>();
        for (Identity _0 : userIds) {
          for (Credentials _1 : _0.credentials) {
            _cacheParentOneCredentialCompromised.add(_1.use);
          }
        }
      }
      for (AttackStep attackStep : _cacheParentOneCredentialCompromised) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepParents() {
      var tmp = super.getAttackStepParents();
      for (Identity _2 : userIds) {
        for (Credentials _3 : _2.credentials) {
          tmp.add(_3.use);
        }
      }
      return tmp;
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("User.oneCredentialCompromised");
    }
  }

  public class PasswordReuseCompromise extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenPasswordReuseCompromise;

    private Set<AttackStep> _cacheParentPasswordReuseCompromise;

    public PasswordReuseCompromise(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenPasswordReuseCompromise == null) {
        _cacheChildrenPasswordReuseCompromise = new HashSet<>();
        for (Identity _0 : userIds) {
          for (Credentials _1 : _0.credentials) {
            _cacheChildrenPasswordReuseCompromise.add(_1.use);
          }
        }
      }
      for (AttackStep attackStep : _cacheChildrenPasswordReuseCompromise) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepChildren() {
      var tmp = super.getAttackStepChildren();
      for (Identity _2 : userIds) {
        for (Credentials _3 : _2.credentials) {
          tmp.add(_3.use);
        }
      }
      return tmp;
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentPasswordReuseCompromise == null) {
        _cacheParentPasswordReuseCompromise = new HashSet<>();
        _cacheParentPasswordReuseCompromise.add(noPasswordReuse.disable);
        _cacheParentPasswordReuseCompromise.add(oneCredentialCompromised);
      }
      for (AttackStep attackStep : _cacheParentPasswordReuseCompromise) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepParents() {
      var tmp = super.getAttackStepParents();
      tmp.add(noPasswordReuse.disable);
      tmp.add(oneCredentialCompromised);
      return tmp;
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("User.passwordReuseCompromise");
    }
  }

  public class AttemptSocialEngineering extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAttemptSocialEngineering;

    public AttemptSocialEngineering(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAttemptSocialEngineering == null) {
        _cacheChildrenAttemptSocialEngineering = new HashSet<>();
        _cacheChildrenAttemptSocialEngineering.add(phishUser);
        _cacheChildrenAttemptSocialEngineering.add(steal2FAtoken);
      }
      for (AttackStep attackStep : _cacheChildrenAttemptSocialEngineering) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepChildren() {
      var tmp = super.getAttackStepChildren();
      tmp.add(phishUser);
      tmp.add(steal2FAtoken);
      return tmp;
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("User.attemptSocialEngineering");
    }
  }

  public class AttemptCredentialTheft extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAttemptCredentialTheft;

    private Set<AttackStep> _cacheParentAttemptCredentialTheft;

    public AttemptCredentialTheft(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAttemptCredentialTheft == null) {
        _cacheChildrenAttemptCredentialTheft = new HashSet<>();
        _cacheChildrenAttemptCredentialTheft.add(credentialTheft);
      }
      for (AttackStep attackStep : _cacheChildrenAttemptCredentialTheft) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepChildren() {
      var tmp = super.getAttackStepChildren();
      tmp.add(credentialTheft);
      return tmp;
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAttemptCredentialTheft == null) {
        _cacheParentAttemptCredentialTheft = new HashSet<>();
        _cacheParentAttemptCredentialTheft.add(phishUser);
      }
      for (AttackStep attackStep : _cacheParentAttemptCredentialTheft) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepParents() {
      var tmp = super.getAttackStepParents();
      tmp.add(phishUser);
      return tmp;
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("User.attemptCredentialTheft");
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
        for (Identity _0 : userIds) {
          for (Credentials _1 : _0.credentials) {
            _cacheChildrenCredentialTheft.add(_1.credentialTheft);
          }
        }
      }
      for (AttackStep attackStep : _cacheChildrenCredentialTheft) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepChildren() {
      var tmp = super.getAttackStepChildren();
      for (Identity _2 : userIds) {
        for (Credentials _3 : _2.credentials) {
          tmp.add(_3.credentialTheft);
        }
      }
      return tmp;
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentCredentialTheft == null) {
        _cacheParentCredentialTheft = new HashSet<>();
        _cacheParentCredentialTheft.add(attemptCredentialTheft);
      }
      for (AttackStep attackStep : _cacheParentCredentialTheft) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepParents() {
      var tmp = super.getAttackStepParents();
      tmp.add(attemptCredentialTheft);
      return tmp;
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("User.credentialTheft");
    }
  }

  public class AttemptReverseTakeover extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAttemptReverseTakeover;

    private Set<AttackStep> _cacheParentAttemptReverseTakeover;

    public AttemptReverseTakeover(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAttemptReverseTakeover == null) {
        _cacheChildrenAttemptReverseTakeover = new HashSet<>();
        _cacheChildrenAttemptReverseTakeover.add(reverseTakeover);
      }
      for (AttackStep attackStep : _cacheChildrenAttemptReverseTakeover) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepChildren() {
      var tmp = super.getAttackStepChildren();
      tmp.add(reverseTakeover);
      return tmp;
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAttemptReverseTakeover == null) {
        _cacheParentAttemptReverseTakeover = new HashSet<>();
        _cacheParentAttemptReverseTakeover.add(phishUser);
      }
      for (AttackStep attackStep : _cacheParentAttemptReverseTakeover) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepParents() {
      var tmp = super.getAttackStepParents();
      tmp.add(phishUser);
      return tmp;
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("User.attemptReverseTakeover");
    }
  }

  public class ReverseTakeover extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenReverseTakeover;

    private Set<AttackStep> _cacheParentReverseTakeover;

    public ReverseTakeover(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenReverseTakeover == null) {
        _cacheChildrenReverseTakeover = new HashSet<>();
        for (Identity _0 : userIds) {
          for (Application _1 : _0.execPrivApps) {
            _cacheChildrenReverseTakeover.add(_1.networkConnect);
          }
        }
      }
      for (AttackStep attackStep : _cacheChildrenReverseTakeover) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepChildren() {
      var tmp = super.getAttackStepChildren();
      for (Identity _2 : userIds) {
        for (Application _3 : _2.execPrivApps) {
          tmp.add(_3.networkConnect);
        }
      }
      return tmp;
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentReverseTakeover == null) {
        _cacheParentReverseTakeover = new HashSet<>();
        _cacheParentReverseTakeover.add(attemptReverseTakeover);
      }
      for (AttackStep attackStep : _cacheParentReverseTakeover) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepParents() {
      var tmp = super.getAttackStepParents();
      tmp.add(attemptReverseTakeover);
      return tmp;
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("User.reverseTakeover");
    }
  }

  public class PhishUser extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenPhishUser;

    private Set<AttackStep> _cacheParentPhishUser;

    public PhishUser(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenPhishUser == null) {
        _cacheChildrenPhishUser = new HashSet<>();
        _cacheChildrenPhishUser.add(attemptCredentialTheft);
        _cacheChildrenPhishUser.add(attemptReverseTakeover);
      }
      for (AttackStep attackStep : _cacheChildrenPhishUser) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepChildren() {
      var tmp = super.getAttackStepChildren();
      tmp.add(attemptCredentialTheft);
      tmp.add(attemptReverseTakeover);
      return tmp;
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentPhishUser == null) {
        _cacheParentPhishUser = new HashSet<>();
        _cacheParentPhishUser.add(attemptSocialEngineering);
      }
      for (AttackStep attackStep : _cacheParentPhishUser) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepParents() {
      var tmp = super.getAttackStepParents();
      tmp.add(attemptSocialEngineering);
      return tmp;
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("User.phishUser");
    }
  }

  public class AttemptSteal2FAtoken extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAttemptSteal2FAtoken;

    private Set<AttackStep> _cacheParentAttemptSteal2FAtoken;

    public AttemptSteal2FAtoken(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAttemptSteal2FAtoken == null) {
        _cacheChildrenAttemptSteal2FAtoken = new HashSet<>();
        _cacheChildrenAttemptSteal2FAtoken.add(steal2FAtoken);
      }
      for (AttackStep attackStep : _cacheChildrenAttemptSteal2FAtoken) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepChildren() {
      var tmp = super.getAttackStepChildren();
      tmp.add(steal2FAtoken);
      return tmp;
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAttemptSteal2FAtoken == null) {
        _cacheParentAttemptSteal2FAtoken = new HashSet<>();
        for (Identity _0 : userIds) {
          for (Credentials _1 : _0.credentials) {
            _cacheParentAttemptSteal2FAtoken.add(_1.use);
          }
        }
      }
      for (AttackStep attackStep : _cacheParentAttemptSteal2FAtoken) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepParents() {
      var tmp = super.getAttackStepParents();
      for (Identity _2 : userIds) {
        for (Credentials _3 : _2.credentials) {
          tmp.add(_3.use);
        }
      }
      return tmp;
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("User.attemptSteal2FAtoken");
    }
  }

  public class Steal2FAtoken extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenSteal2FAtoken;

    private Set<AttackStep> _cacheParentSteal2FAtoken;

    public Steal2FAtoken(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenSteal2FAtoken == null) {
        _cacheChildrenSteal2FAtoken = new HashSet<>();
        for (Identity _0 : userIds) {
          _cacheChildrenSteal2FAtoken.add(_0.attemptAssumeAfter2FA);
        }
      }
      for (AttackStep attackStep : _cacheChildrenSteal2FAtoken) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepChildren() {
      var tmp = super.getAttackStepChildren();
      for (Identity _1 : userIds) {
        tmp.add(_1.attemptAssumeAfter2FA);
      }
      return tmp;
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentSteal2FAtoken == null) {
        _cacheParentSteal2FAtoken = new HashSet<>();
        _cacheParentSteal2FAtoken.add(attemptSocialEngineering);
        _cacheParentSteal2FAtoken.add(attemptSteal2FAtoken);
      }
      for (AttackStep attackStep : _cacheParentSteal2FAtoken) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepParents() {
      var tmp = super.getAttackStepParents();
      tmp.add(attemptSocialEngineering);
      tmp.add(attemptSteal2FAtoken);
      return tmp;
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("User.steal2FAtoken");
    }
  }

  public class Compromise extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenCompromise;

    public Compromise(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenCompromise == null) {
        _cacheChildrenCompromise = new HashSet<>();
        for (Identity _0 : userIds) {
          _cacheChildrenCompromise.add(_0.attemptAssume);
        }
      }
      for (AttackStep attackStep : _cacheChildrenCompromise) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepChildren() {
      var tmp = super.getAttackStepChildren();
      for (Identity _1 : userIds) {
        tmp.add(_1.attemptAssume);
      }
      return tmp;
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("User.compromise");
    }
  }
}
