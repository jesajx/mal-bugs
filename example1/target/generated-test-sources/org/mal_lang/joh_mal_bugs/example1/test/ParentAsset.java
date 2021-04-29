package org.mal_lang.joh_mal_bugs.example1.test;

import core.Asset;
import core.AttackStep;
import core.AttackStepMax;
import core.AttackStepMin;
import java.lang.Override;
import java.lang.String;
import java.util.HashSet;
import java.util.Set;

public abstract class ParentAsset extends Asset {
  public AttemptAbuse attemptAbuse;

  public Abuse abuse;

  public ParentAsset(String name) {
    super(name);
    assetClassName = "ParentAsset";
    AttackStep.allAttackSteps.remove(attemptAbuse);
    attemptAbuse = new AttemptAbuse(name);
    AttackStep.allAttackSteps.remove(abuse);
    abuse = new Abuse(name);
  }

  public ParentAsset() {
    this("Anonymous");
  }

  public class AttemptAbuse extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAttemptAbuse;

    public AttemptAbuse(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAttemptAbuse == null) {
        _cacheChildrenAttemptAbuse = new HashSet<>();
        _cacheChildrenAttemptAbuse.add(abuse);
      }
      for (AttackStep attackStep : _cacheChildrenAttemptAbuse) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepChildren() {
      var tmp = super.getAttackStepChildren();
      tmp.add(abuse);
      return tmp;
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("ParentAsset.attemptAbuse");
    }
  }

  public class Abuse extends AttackStepMax {
    private Set<AttackStep> _cacheParentAbuse;

    public Abuse(String name) {
      super(name);
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAbuse == null) {
        _cacheParentAbuse = new HashSet<>();
        _cacheParentAbuse.add(attemptAbuse);
      }
      for (AttackStep attackStep : _cacheParentAbuse) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepParents() {
      var tmp = super.getAttackStepParents();
      tmp.add(attemptAbuse);
      return tmp;
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("ParentAsset.abuse");
    }
  }
}
