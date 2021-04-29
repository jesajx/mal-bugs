package org.mal_lang.joh_mal_bugs.example1.test;

import core.Asset;
import core.AttackStep;
import core.AttackStepMin;
import java.lang.Override;
import java.lang.String;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Group extends Asset {
  public CompromiseGroup compromiseGroup;

  public Set<Identity> groupIds = new HashSet<>();

  public Set<Group> childGroups = new HashSet<>();

  public Set<Group> parentGroup = new HashSet<>();

  public Set<System> highPrivManagedSystems = new HashSet<>();

  public Set<System> lowPrivManagedSystems = new HashSet<>();

  public Set<Application> execPrivApps = new HashSet<>();

  public Set<Application> highPrivApps = new HashSet<>();

  public Set<Application> lowPrivApps = new HashSet<>();

  public Set<Data> readPrivData = new HashSet<>();

  public Set<Data> writePrivData = new HashSet<>();

  public Set<Data> deletePrivData = new HashSet<>();

  public Group(String name) {
    super(name);
    assetClassName = "Group";
    AttackStep.allAttackSteps.remove(compromiseGroup);
    compromiseGroup = new CompromiseGroup(name);
  }

  public Group() {
    this("Anonymous");
  }

  public void addGroupIds(Identity groupIds) {
    this.groupIds.add(groupIds);
    groupIds.memberOf.add(this);
  }

  public void addChildGroups(Group childGroups) {
    this.childGroups.add(childGroups);
    childGroups.parentGroup.add(this);
  }

  public void addParentGroup(Group parentGroup) {
    this.parentGroup.add(parentGroup);
    parentGroup.childGroups.add(this);
  }

  public void addHighPrivManagedSystems(System highPrivManagedSystems) {
    this.highPrivManagedSystems.add(highPrivManagedSystems);
    highPrivManagedSystems.highPrivSysGroups.add(this);
  }

  public void addLowPrivManagedSystems(System lowPrivManagedSystems) {
    this.lowPrivManagedSystems.add(lowPrivManagedSystems);
    lowPrivManagedSystems.lowPrivSysGroups.add(this);
  }

  public void addExecPrivApps(Application execPrivApps) {
    this.execPrivApps.add(execPrivApps);
    execPrivApps.executionPrivGroups.add(this);
  }

  public void addHighPrivApps(Application highPrivApps) {
    this.highPrivApps.add(highPrivApps);
    highPrivApps.highPrivAppGroups.add(this);
  }

  public void addLowPrivApps(Application lowPrivApps) {
    this.lowPrivApps.add(lowPrivApps);
    lowPrivApps.lowPrivAppGroups.add(this);
  }

  public void addReadPrivData(Data readPrivData) {
    this.readPrivData.add(readPrivData);
    readPrivData.readingGroups.add(this);
  }

  public void addWritePrivData(Data writePrivData) {
    this.writePrivData.add(writePrivData);
    writePrivData.writingGroups.add(this);
  }

  public void addDeletePrivData(Data deletePrivData) {
    this.deletePrivData.add(deletePrivData);
    deletePrivData.deletingGroups.add(this);
  }

  @Override
  public String getAssociatedAssetClassName(String field) {
    if (field.equals("groupIds")) {
      return Identity.class.getName();
    } else if (field.equals("childGroups")) {
      return Group.class.getName();
    } else if (field.equals("parentGroup")) {
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
    }
    return "";
  }

  @Override
  public Set<Asset> getAssociatedAssets(String field) {
    Set<Asset> assets = new HashSet<>();
    if (field.equals("groupIds")) {
      assets.addAll(groupIds);
    } else if (field.equals("childGroups")) {
      assets.addAll(childGroups);
    } else if (field.equals("parentGroup")) {
      assets.addAll(parentGroup);
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
    }
    return assets;
  }

  @Override
  public Set<Asset> getAllAssociatedAssets() {
    Set<Asset> assets = new HashSet<>();
    assets.addAll(groupIds);
    assets.addAll(childGroups);
    assets.addAll(parentGroup);
    assets.addAll(highPrivManagedSystems);
    assets.addAll(lowPrivManagedSystems);
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
    fields.put("groupIds", new HashSet<Asset>());
    fields.get("groupIds").addAll(groupIds);
    fields.put("childGroups", new HashSet<Asset>());
    fields.get("childGroups").addAll(childGroups);
    fields.put("parentGroup", new HashSet<Asset>());
    fields.get("parentGroup").addAll(parentGroup);
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
    return fields;
  }

  public class CompromiseGroup extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenCompromiseGroup;

    private Set<AttackStep> _cacheParentCompromiseGroup;

    public CompromiseGroup(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenCompromiseGroup == null) {
        _cacheChildrenCompromiseGroup = new HashSet<>();
        for (Group _0 : parentGroup) {
          _cacheChildrenCompromiseGroup.add(_0.compromiseGroup);
        }
        for (System _1 : lowPrivManagedSystems) {
          _cacheChildrenCompromiseGroup.add(_1.individualPrivilegeAuthenticate);
        }
        for (System _2 : highPrivManagedSystems) {
          _cacheChildrenCompromiseGroup.add(_2.allPrivilegeAuthenticate);
        }
        for (Application _3 : execPrivApps) {
          _cacheChildrenCompromiseGroup.add(_3.authenticate);
        }
        for (Application _4 : highPrivApps) {
          _cacheChildrenCompromiseGroup.add(_4.authenticate);
        }
        for (Application _5 : lowPrivApps) {
          _cacheChildrenCompromiseGroup.add(_5.specificAccessAuthenticate);
        }
        for (Data _6 : readPrivData) {
          _cacheChildrenCompromiseGroup.add(_6.identityAttemptRead);
        }
        for (Data _7 : writePrivData) {
          _cacheChildrenCompromiseGroup.add(_7.identityAttemptWrite);
        }
        for (Data _8 : deletePrivData) {
          _cacheChildrenCompromiseGroup.add(_8.identityAttemptDelete);
        }
      }
      for (AttackStep attackStep : _cacheChildrenCompromiseGroup) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepChildren() {
      var tmp = super.getAttackStepChildren();
      for (Group _9 : parentGroup) {
        tmp.add(_9.compromiseGroup);
      }
      for (System _a : lowPrivManagedSystems) {
        tmp.add(_a.individualPrivilegeAuthenticate);
      }
      for (System _b : highPrivManagedSystems) {
        tmp.add(_b.allPrivilegeAuthenticate);
      }
      for (Application _c : execPrivApps) {
        tmp.add(_c.authenticate);
      }
      for (Application _d : highPrivApps) {
        tmp.add(_d.authenticate);
      }
      for (Application _e : lowPrivApps) {
        tmp.add(_e.specificAccessAuthenticate);
      }
      for (Data _f : readPrivData) {
        tmp.add(_f.identityAttemptRead);
      }
      for (Data _10 : writePrivData) {
        tmp.add(_10.identityAttemptWrite);
      }
      for (Data _11 : deletePrivData) {
        tmp.add(_11.identityAttemptDelete);
      }
      return tmp;
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentCompromiseGroup == null) {
        _cacheParentCompromiseGroup = new HashSet<>();
        for (System _12 : highPrivManagedSystems) {
          _cacheParentCompromiseGroup.add(_12.fullAccess);
        }
        for (System _13 : lowPrivManagedSystems) {
          _cacheParentCompromiseGroup.add(_13.fullAccess);
        }
        for (Application _14 : execPrivApps) {
          _cacheParentCompromiseGroup.add(_14.fullAccess);
        }
        for (Identity _15 : groupIds) {
          _cacheParentCompromiseGroup.add(_15.assume);
        }
        for (Group _16 : childGroups) {
          _cacheParentCompromiseGroup.add(_16.compromiseGroup);
        }
      }
      for (AttackStep attackStep : _cacheParentCompromiseGroup) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepParents() {
      var tmp = super.getAttackStepParents();
      for (System _17 : highPrivManagedSystems) {
        tmp.add(_17.fullAccess);
      }
      for (System _18 : lowPrivManagedSystems) {
        tmp.add(_18.fullAccess);
      }
      for (Application _19 : execPrivApps) {
        tmp.add(_19.fullAccess);
      }
      for (Identity _1a : groupIds) {
        tmp.add(_1a.assume);
      }
      for (Group _1b : childGroups) {
        tmp.add(_1b.compromiseGroup);
      }
      return tmp;
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Group.compromiseGroup");
    }
  }
}
