package org.mal_lang.joh_mal_bugs.example1.test;

import core.AttackStep;
import core.AttackStepMin;
import java.lang.Override;
import java.lang.String;
import java.util.HashSet;
import java.util.Set;

public class ChildAsset extends ParentAsset {
  public Meh meh;

  public ChildAsset(String name) {
    super(name);
    assetClassName = "ChildAsset";
    AttackStep.allAttackSteps.remove(attemptAbuse);
    attemptAbuse = new AttemptAbuse(name);
    AttackStep.allAttackSteps.remove(meh);
    meh = new Meh(name);
    AttackStep.allAttackSteps.remove(abuse);
    abuse = new Abuse(name);
  }

  public ChildAsset() {
    this("Anonymous");
  }

  public class AttemptAbuse extends ParentAsset.AttemptAbuse {
    private Set<AttackStep> _cacheChildrenAttemptAbuse;

    public AttemptAbuse(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAttemptAbuse == null) {
        _cacheChildrenAttemptAbuse = new HashSet<>();
        _cacheChildrenAttemptAbuse.add(meh);
      }
      for (AttackStep attackStep : _cacheChildrenAttemptAbuse) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepChildren() {
      var tmp = super.getAttackStepChildren();
      tmp.add(meh);
      return tmp;
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("ChildAsset.attemptAbuse");
    }
  }

  public class Meh extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenMeh;

    private Set<AttackStep> _cacheParentMeh;

    public Meh(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenMeh == null) {
        _cacheChildrenMeh = new HashSet<>();
        _cacheChildrenMeh.add(abuse);
      }
      for (AttackStep attackStep : _cacheChildrenMeh) {
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
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentMeh == null) {
        _cacheParentMeh = new HashSet<>();
        _cacheParentMeh.add(attemptAbuse);
      }
      for (AttackStep attackStep : _cacheParentMeh) {
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
      return ttcHashMap.get("ChildAsset.meh");
    }
  }

  public class Abuse extends ParentAsset.Abuse {
    private Set<AttackStep> _cacheParentAbuse;

    public Abuse(String name) {
      super(name);
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAbuse == null) {
        _cacheParentAbuse = new HashSet<>();
        _cacheParentAbuse.add(meh);
      }
      for (AttackStep attackStep : _cacheParentAbuse) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepParents() {
      var tmp = super.getAttackStepParents();
      tmp.add(meh);
      return tmp;
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("ChildAsset.abuse");
    }
  }
}
