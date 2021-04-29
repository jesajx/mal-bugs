package org.mal_lang.joh_mal_bugs.example1.test;

import core.*;
import org.junit.jupiter.api.AfterEach;

import java.util.HashSet;
import java.util.HashMap;

public class Base {
  @AfterEach
  public void deleteModel() {
    Asset.allAssets.clear();
    AttackStep.allAttackSteps.clear();
    Defense.allDefenses.clear();
  }

  public HashSet<AttackStep> attack(AttackStep... entryPoints) {
      var startSet = new HashSet<AttackStep>();
      var attacker = new Attacker();
      for (var step : entryPoints) {
          if (step == null) {
              throw new NullPointerException();
          }
          if (!AttackStep.allAttackSteps.contains(step)) {
              throw new RuntimeException("missing step " + step);
          }

          startSet.add(step);
          attacker.addAttackPoint(step);
      }
      attacker.attack();
      return startSet; // for convenience
  }
}
