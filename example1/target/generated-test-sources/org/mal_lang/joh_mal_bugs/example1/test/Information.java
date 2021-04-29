package org.mal_lang.joh_mal_bugs.example1.test;

import core.Asset;
import core.AttackStep;
import core.AttackStepMin;
import java.lang.Override;
import java.lang.String;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Information extends Asset {
  public AttemptAccess attemptAccess;

  public Set<Data> containerData = new HashSet<>();

  public Information(String name) {
    super(name);
    assetClassName = "Information";
    AttackStep.allAttackSteps.remove(attemptAccess);
    attemptAccess = new AttemptAccess(name);
  }

  public Information() {
    this("Anonymous");
  }

  public void addContainerData(Data containerData) {
    this.containerData.add(containerData);
    containerData.information.add(this);
  }

  @Override
  public String getAssociatedAssetClassName(String field) {
    if (field.equals("containerData")) {
      return Data.class.getName();
    }
    return "";
  }

  @Override
  public Set<Asset> getAssociatedAssets(String field) {
    Set<Asset> assets = new HashSet<>();
    if (field.equals("containerData")) {
      assets.addAll(containerData);
    }
    return assets;
  }

  @Override
  public Set<Asset> getAllAssociatedAssets() {
    Set<Asset> assets = new HashSet<>();
    assets.addAll(containerData);
    return assets;
  }

  @Override
  public HashMap<String, HashSet<Asset>> getFields() {
    var fields = super.getFields();
    fields.put("containerData", new HashSet<Asset>());
    fields.get("containerData").addAll(containerData);
    return fields;
  }

  public class AttemptAccess extends AttackStepMin {
    private Set<AttackStep> _cacheParentAttemptAccess;

    public AttemptAccess(String name) {
      super(name);
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAttemptAccess == null) {
        _cacheParentAttemptAccess = new HashSet<>();
        for (Data _0 : containerData) {
          _cacheParentAttemptAccess.add(_0.readContainedInformation);
        }
      }
      for (AttackStep attackStep : _cacheParentAttemptAccess) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepParents() {
      var tmp = super.getAttackStepParents();
      for (Data _1 : containerData) {
        tmp.add(_1.readContainedInformation);
      }
      return tmp;
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Information.attemptAccess");
    }
  }
}
