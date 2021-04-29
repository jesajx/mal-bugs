package org.mal_lang.joh_mal_bugs.example1.test;

import core.Asset;
import core.AttackStep;
import core.AttackStepMin;
import java.lang.Override;
import java.lang.String;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class RoutingFirewall extends Application {
  public DenialOfService denialOfService;

  public Set<ConnectionRule> connectionRules = new HashSet<>();

  public Application managerApp = null;

  public RoutingFirewall(String name, boolean isDisabledEnabled) {
    super(name, isDisabledEnabled);
    assetClassName = "RoutingFirewall";
    AttackStep.allAttackSteps.remove(denialOfService);
    denialOfService = new DenialOfService(name);
    AttackStep.allAttackSteps.remove(fullAccess);
    fullAccess = new FullAccess(name);
  }

  public RoutingFirewall(String name) {
    super(name);
    assetClassName = "RoutingFirewall";
    AttackStep.allAttackSteps.remove(denialOfService);
    denialOfService = new DenialOfService(name);
    AttackStep.allAttackSteps.remove(fullAccess);
    fullAccess = new FullAccess(name);
  }

  public RoutingFirewall(boolean isDisabledEnabled) {
    this("Anonymous", isDisabledEnabled);
  }

  public RoutingFirewall() {
    this("Anonymous");
  }

  public void addConnectionRules(ConnectionRule connectionRules) {
    this.connectionRules.add(connectionRules);
    connectionRules.routingFirewalls = this;
  }

  public void addManagerApp(Application managerApp) {
    this.managerApp = managerApp;
    managerApp.managedRoutingFw.add(this);
  }

  @Override
  public String getAssociatedAssetClassName(String field) {
    if (field.equals("connectionRules")) {
      return ConnectionRule.class.getName();
    } else if (field.equals("managerApp")) {
      return Application.class.getName();
    }
    return "";
  }

  @Override
  public Set<Asset> getAssociatedAssets(String field) {
    Set<Asset> assets = new HashSet<>();
    if (field.equals("connectionRules")) {
      assets.addAll(connectionRules);
    } else if (field.equals("managerApp")) {
      if (managerApp != null) {
        assets.add(managerApp);
      }
    }
    return assets;
  }

  @Override
  public Set<Asset> getAllAssociatedAssets() {
    Set<Asset> assets = new HashSet<>();
    assets.addAll(connectionRules);
    if (managerApp != null) {
      assets.add(managerApp);
    }
    return assets;
  }

  @Override
  public HashMap<String, HashSet<Asset>> getFields() {
    var fields = super.getFields();
    fields.put("connectionRules", new HashSet<Asset>());
    fields.get("connectionRules").addAll(connectionRules);
    fields.put("managerApp", new HashSet<Asset>());
    if (managerApp != null) {
      fields.get("managerApp").add(managerApp);
    }
    return fields;
  }

  public class DenialOfService extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenDenialOfService;

    public DenialOfService(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenDenialOfService == null) {
        _cacheChildrenDenialOfService = new HashSet<>();
        for (ConnectionRule _0 : connectionRules) {
          _cacheChildrenDenialOfService.add(_0.attemptDenialOfService);
        }
      }
      for (AttackStep attackStep : _cacheChildrenDenialOfService) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepChildren() {
      var tmp = super.getAttackStepChildren();
      for (ConnectionRule _1 : connectionRules) {
        tmp.add(_1.attemptDenialOfService);
      }
      return tmp;
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("RoutingFirewall.denialOfService");
    }
  }

  public class FullAccess extends Application.FullAccess {
    private Set<AttackStep> _cacheChildrenFullAccess;

    private Set<AttackStep> _cacheParentFullAccess;

    public FullAccess(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      super.updateChildren(attackSteps);
      if (_cacheChildrenFullAccess == null) {
        _cacheChildrenFullAccess = new HashSet<>();
        Set<Network> _0 = new HashSet<>();
        Set<Network> _1 = new HashSet<>();
        Set<Network> _2 = new HashSet<>();
        Set<Network> _3 = new HashSet<>();
        Set<Network> _4 = new HashSet<>();
        Set<Network> _5 = new HashSet<>();
        for (ConnectionRule _6 : connectionRules) {
          for (Network _7 : _6.networks) {
            _4.add(_7);
          }
        }
        for (ConnectionRule _8 : connectionRules) {
          for (Network _9 : _8.outNetworks) {
            _5.add(_9);
          }
        }
        _4.addAll(_5);
        for (Network _a : _4) {
          _2.add(_a);
        }
        for (ConnectionRule _b : connectionRules) {
          for (Network _c : _b.inNetworks) {
            _3.add(_c);
          }
        }
        _2.addAll(_3);
        for (Network _d : _2) {
          _0.add(_d);
        }
        for (ConnectionRule _e : connectionRules) {
          for (Network _f : _e.diodeInNetworks) {
            _1.add(_f);
          }
        }
        _0.addAll(_1);
        for (Network _10 : _0) {
          _cacheChildrenFullAccess.add(_10.access);
        }
        for (ConnectionRule _11 : connectionRules) {
          for (Application _12 : _11.applications) {
            _cacheChildrenFullAccess.add(_12.networkConnect);
          }
        }
      }
      for (AttackStep attackStep : _cacheChildrenFullAccess) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepChildren() {
      var tmp = super.getAttackStepChildren();
      Set<Network> _13 = new HashSet<>();
      Set<Network> _14 = new HashSet<>();
      Set<Network> _15 = new HashSet<>();
      Set<Network> _16 = new HashSet<>();
      Set<Network> _17 = new HashSet<>();
      Set<Network> _18 = new HashSet<>();
      for (ConnectionRule _19 : connectionRules) {
        for (Network _1a : _19.networks) {
          _17.add(_1a);
        }
      }
      for (ConnectionRule _1b : connectionRules) {
        for (Network _1c : _1b.outNetworks) {
          _18.add(_1c);
        }
      }
      _17.addAll(_18);
      for (Network _1d : _17) {
        _15.add(_1d);
      }
      for (ConnectionRule _1e : connectionRules) {
        for (Network _1f : _1e.inNetworks) {
          _16.add(_1f);
        }
      }
      _15.addAll(_16);
      for (Network _20 : _15) {
        _13.add(_20);
      }
      for (ConnectionRule _21 : connectionRules) {
        for (Network _22 : _21.diodeInNetworks) {
          _14.add(_22);
        }
      }
      _13.addAll(_14);
      for (Network _23 : _13) {
        tmp.add(_23.access);
      }
      for (ConnectionRule _24 : connectionRules) {
        for (Application _25 : _24.applications) {
          tmp.add(_25.networkConnect);
        }
      }
      return tmp;
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentFullAccess == null) {
        _cacheParentFullAccess = new HashSet<>();
        if (managerApp != null) {
          _cacheParentFullAccess.add(managerApp.fullAccess);
        }
      }
      for (AttackStep attackStep : _cacheParentFullAccess) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepParents() {
      var tmp = super.getAttackStepParents();
      if (managerApp != null) {
        tmp.add(managerApp.fullAccess);
      }
      return tmp;
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("RoutingFirewall.fullAccess");
    }
  }
}
