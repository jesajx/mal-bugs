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

public class ConnectionRule extends Asset {
  public Disabled disabled;

  public Filtered filtered;

  public AttemptAccessNetworks attemptAccessNetworks;

  public AccessNetworks accessNetworks;

  public AttemptConnectToApplications attemptConnectToApplications;

  public ConnectToApplications connectToApplications;

  public AttemptTransmitResponse attemptTransmitResponse;

  public TransmitResponse transmitResponse;

  public AttemptTransmit attemptTransmit;

  public Transmit transmit;

  public AttemptDenialOfService attemptDenialOfService;

  public DenialOfService denialOfService;

  public AttemptEavesdropOnDataInTransit attemptEavesdropOnDataInTransit;

  public EavedropOnDataInTransit eavedropOnDataInTransit;

  public AttemptManInTheMiddleOnDataInTransit attemptManInTheMiddleOnDataInTransit;

  public MainInTheMiddleOnDataInTransit mainInTheMiddleOnDataInTransit;

  private Set<Application> _cacheserverApplicationsConnectionRule;

  private Set<Application> _cacheclientApplicationsConnectionRule;

  private Set<Application> _cacheallApplicationsConnectionRule;

  private Set<Application> _cachereverseclientApplicationConnectionsApplication;

  private Set<Application> _cachereverseserverApplicationConnectionsApplication;

  private Set<Application> _cachereverseallApplicationConnectionsApplication;

  private Set<Network> _cachereverseallowedApplicationConnectionsNetwork;

  private Set<Network> _cachereverseallowedNetworkConnectionsNetwork;

  private Set<Network> _cachereverseallNetConnectionsNetwork;

  public RoutingFirewall routingFirewalls = null;

  public Set<Application> applications = new HashSet<>();

  public Set<Application> inApplications = new HashSet<>();

  public Set<Application> outApplications = new HashSet<>();

  public Set<Network> networks = new HashSet<>();

  public Set<Network> outNetworks = new HashSet<>();

  public Set<Network> inNetworks = new HashSet<>();

  public Set<Network> diodeInNetworks = new HashSet<>();

  public ConnectionRule(String name, boolean isDisabledEnabled, boolean isFilteredEnabled) {
    super(name);
    assetClassName = "ConnectionRule";
    if (disabled != null) {
      AttackStep.allAttackSteps.remove(disabled.disable);
    }
    Defense.allDefenses.remove(disabled);
    disabled = new Disabled(name, isDisabledEnabled);
    if (filtered != null) {
      AttackStep.allAttackSteps.remove(filtered.disable);
    }
    Defense.allDefenses.remove(filtered);
    filtered = new Filtered(name, isFilteredEnabled);
    AttackStep.allAttackSteps.remove(attemptAccessNetworks);
    attemptAccessNetworks = new AttemptAccessNetworks(name);
    AttackStep.allAttackSteps.remove(accessNetworks);
    accessNetworks = new AccessNetworks(name);
    AttackStep.allAttackSteps.remove(attemptConnectToApplications);
    attemptConnectToApplications = new AttemptConnectToApplications(name);
    AttackStep.allAttackSteps.remove(connectToApplications);
    connectToApplications = new ConnectToApplications(name);
    AttackStep.allAttackSteps.remove(attemptTransmitResponse);
    attemptTransmitResponse = new AttemptTransmitResponse(name);
    AttackStep.allAttackSteps.remove(transmitResponse);
    transmitResponse = new TransmitResponse(name);
    AttackStep.allAttackSteps.remove(attemptTransmit);
    attemptTransmit = new AttemptTransmit(name);
    AttackStep.allAttackSteps.remove(transmit);
    transmit = new Transmit(name);
    AttackStep.allAttackSteps.remove(attemptDenialOfService);
    attemptDenialOfService = new AttemptDenialOfService(name);
    AttackStep.allAttackSteps.remove(denialOfService);
    denialOfService = new DenialOfService(name);
    AttackStep.allAttackSteps.remove(attemptEavesdropOnDataInTransit);
    attemptEavesdropOnDataInTransit = new AttemptEavesdropOnDataInTransit(name);
    AttackStep.allAttackSteps.remove(eavedropOnDataInTransit);
    eavedropOnDataInTransit = new EavedropOnDataInTransit(name);
    AttackStep.allAttackSteps.remove(attemptManInTheMiddleOnDataInTransit);
    attemptManInTheMiddleOnDataInTransit = new AttemptManInTheMiddleOnDataInTransit(name);
    AttackStep.allAttackSteps.remove(mainInTheMiddleOnDataInTransit);
    mainInTheMiddleOnDataInTransit = new MainInTheMiddleOnDataInTransit(name);
  }

  public ConnectionRule(String name) {
    super(name);
    assetClassName = "ConnectionRule";
    if (disabled != null) {
      AttackStep.allAttackSteps.remove(disabled.disable);
    }
    Defense.allDefenses.remove(disabled);
    disabled = new Disabled(name, false);
    if (filtered != null) {
      AttackStep.allAttackSteps.remove(filtered.disable);
    }
    Defense.allDefenses.remove(filtered);
    filtered = new Filtered(name, false);
    AttackStep.allAttackSteps.remove(attemptAccessNetworks);
    attemptAccessNetworks = new AttemptAccessNetworks(name);
    AttackStep.allAttackSteps.remove(accessNetworks);
    accessNetworks = new AccessNetworks(name);
    AttackStep.allAttackSteps.remove(attemptConnectToApplications);
    attemptConnectToApplications = new AttemptConnectToApplications(name);
    AttackStep.allAttackSteps.remove(connectToApplications);
    connectToApplications = new ConnectToApplications(name);
    AttackStep.allAttackSteps.remove(attemptTransmitResponse);
    attemptTransmitResponse = new AttemptTransmitResponse(name);
    AttackStep.allAttackSteps.remove(transmitResponse);
    transmitResponse = new TransmitResponse(name);
    AttackStep.allAttackSteps.remove(attemptTransmit);
    attemptTransmit = new AttemptTransmit(name);
    AttackStep.allAttackSteps.remove(transmit);
    transmit = new Transmit(name);
    AttackStep.allAttackSteps.remove(attemptDenialOfService);
    attemptDenialOfService = new AttemptDenialOfService(name);
    AttackStep.allAttackSteps.remove(denialOfService);
    denialOfService = new DenialOfService(name);
    AttackStep.allAttackSteps.remove(attemptEavesdropOnDataInTransit);
    attemptEavesdropOnDataInTransit = new AttemptEavesdropOnDataInTransit(name);
    AttackStep.allAttackSteps.remove(eavedropOnDataInTransit);
    eavedropOnDataInTransit = new EavedropOnDataInTransit(name);
    AttackStep.allAttackSteps.remove(attemptManInTheMiddleOnDataInTransit);
    attemptManInTheMiddleOnDataInTransit = new AttemptManInTheMiddleOnDataInTransit(name);
    AttackStep.allAttackSteps.remove(mainInTheMiddleOnDataInTransit);
    mainInTheMiddleOnDataInTransit = new MainInTheMiddleOnDataInTransit(name);
  }

  public ConnectionRule(boolean isDisabledEnabled, boolean isFilteredEnabled) {
    this("Anonymous", isDisabledEnabled, isFilteredEnabled);
  }

  public ConnectionRule() {
    this("Anonymous");
  }

  protected Set<Application> _serverApplicationsConnectionRule() {
    if (_cacheserverApplicationsConnectionRule == null) {
      _cacheserverApplicationsConnectionRule = new HashSet<>();
      Set<Application> _4 = new HashSet<>();
      Set<Application> _5 = new HashSet<>();
      for (Application _6 : applications) {
        _4.add(_6);
      }
      for (Application _7 : inApplications) {
        _5.add(_7);
      }
      _4.addAll(_5);
      for (Application _8 : _4) {
        _cacheserverApplicationsConnectionRule.add(_8);
      }
    }
    return _cacheserverApplicationsConnectionRule;
  }

  protected Set<Application> _clientApplicationsConnectionRule() {
    if (_cacheclientApplicationsConnectionRule == null) {
      _cacheclientApplicationsConnectionRule = new HashSet<>();
      Set<Application> _9 = new HashSet<>();
      Set<Application> _a = new HashSet<>();
      for (Application _b : applications) {
        _9.add(_b);
      }
      for (Application _c : outApplications) {
        _a.add(_c);
      }
      _9.addAll(_a);
      for (Application _d : _9) {
        _cacheclientApplicationsConnectionRule.add(_d);
      }
    }
    return _cacheclientApplicationsConnectionRule;
  }

  protected Set<Application> _allApplicationsConnectionRule() {
    if (_cacheallApplicationsConnectionRule == null) {
      _cacheallApplicationsConnectionRule = new HashSet<>();
      Set<Application> _e = new HashSet<>();
      Set<Application> _f = new HashSet<>();
      Set<Application> _10 = new HashSet<>();
      Set<Application> _11 = new HashSet<>();
      for (Application _12 : applications) {
        _10.add(_12);
      }
      for (Application _13 : inApplications) {
        _11.add(_13);
      }
      _10.addAll(_11);
      for (Application _14 : _10) {
        _e.add(_14);
      }
      for (Application _15 : outApplications) {
        _f.add(_15);
      }
      _e.addAll(_f);
      for (Application _16 : _e) {
        _cacheallApplicationsConnectionRule.add(_16);
      }
    }
    return _cacheallApplicationsConnectionRule;
  }

  protected Set<Application> _reverseclientApplicationConnectionsApplication() {
    if (_cachereverseclientApplicationConnectionsApplication == null) {
      _cachereverseclientApplicationConnectionsApplication = new HashSet<>();
      Set<Application> _17 = new HashSet<>();
      Set<Application> _18 = new HashSet<>();
      for (Application _19 : outApplications) {
        _17.add(_19);
      }
      for (Application _1a : applications) {
        _18.add(_1a);
      }
      _17.addAll(_18);
      for (Application _1b : _17) {
        _cachereverseclientApplicationConnectionsApplication.add(_1b);
      }
    }
    return _cachereverseclientApplicationConnectionsApplication;
  }

  protected Set<Application> _reverseserverApplicationConnectionsApplication() {
    if (_cachereverseserverApplicationConnectionsApplication == null) {
      _cachereverseserverApplicationConnectionsApplication = new HashSet<>();
      Set<Application> _1c = new HashSet<>();
      Set<Application> _1d = new HashSet<>();
      for (Application _1e : inApplications) {
        _1c.add(_1e);
      }
      for (Application _1f : applications) {
        _1d.add(_1f);
      }
      _1c.addAll(_1d);
      for (Application _20 : _1c) {
        _cachereverseserverApplicationConnectionsApplication.add(_20);
      }
    }
    return _cachereverseserverApplicationConnectionsApplication;
  }

  protected Set<Application> _reverseallApplicationConnectionsApplication() {
    if (_cachereverseallApplicationConnectionsApplication == null) {
      _cachereverseallApplicationConnectionsApplication = new HashSet<>();
      Set<Application> _21 = new HashSet<>();
      Set<Application> _22 = new HashSet<>();
      for (Application _23 : inApplications) {
        _21.add(_23);
      }
      Set<Application> _24 = new HashSet<>();
      Set<Application> _25 = new HashSet<>();
      for (Application _26 : outApplications) {
        _24.add(_26);
      }
      for (Application _27 : applications) {
        _25.add(_27);
      }
      _24.addAll(_25);
      for (Application _28 : _24) {
        _22.add(_28);
      }
      _21.addAll(_22);
      for (Application _29 : _21) {
        _cachereverseallApplicationConnectionsApplication.add(_29);
      }
    }
    return _cachereverseallApplicationConnectionsApplication;
  }

  protected Set<Network> _reverseallowedApplicationConnectionsNetwork() {
    if (_cachereverseallowedApplicationConnectionsNetwork == null) {
      _cachereverseallowedApplicationConnectionsNetwork = new HashSet<>();
      Set<Network> _2a = new HashSet<>();
      Set<Network> _2b = new HashSet<>();
      for (Network _2c : outNetworks) {
        _2a.add(_2c);
      }
      for (Network _2d : networks) {
        _2b.add(_2d);
      }
      _2a.addAll(_2b);
      for (Network _2e : _2a) {
        _cachereverseallowedApplicationConnectionsNetwork.add(_2e);
      }
    }
    return _cachereverseallowedApplicationConnectionsNetwork;
  }

  protected Set<Network> _reverseallowedNetworkConnectionsNetwork() {
    if (_cachereverseallowedNetworkConnectionsNetwork == null) {
      _cachereverseallowedNetworkConnectionsNetwork = new HashSet<>();
      Set<Network> _2f = new HashSet<>();
      Set<Network> _30 = new HashSet<>();
      for (Network _31 : outNetworks) {
        _2f.add(_31);
      }
      for (Network _32 : networks) {
        _30.add(_32);
      }
      _2f.addAll(_30);
      for (Network _33 : _2f) {
        _cachereverseallowedNetworkConnectionsNetwork.add(_33);
      }
    }
    return _cachereverseallowedNetworkConnectionsNetwork;
  }

  protected Set<Network> _reverseallNetConnectionsNetwork() {
    if (_cachereverseallNetConnectionsNetwork == null) {
      _cachereverseallNetConnectionsNetwork = new HashSet<>();
      Set<Network> _34 = new HashSet<>();
      Set<Network> _35 = new HashSet<>();
      for (Network _36 : diodeInNetworks) {
        _34.add(_36);
      }
      Set<Network> _37 = new HashSet<>();
      Set<Network> _38 = new HashSet<>();
      for (Network _39 : outNetworks) {
        _37.add(_39);
      }
      Set<Network> _3a = new HashSet<>();
      Set<Network> _3b = new HashSet<>();
      for (Network _3c : inNetworks) {
        _3a.add(_3c);
      }
      for (Network _3d : networks) {
        _3b.add(_3d);
      }
      _3a.addAll(_3b);
      for (Network _3e : _3a) {
        _38.add(_3e);
      }
      _37.addAll(_38);
      for (Network _3f : _37) {
        _35.add(_3f);
      }
      _34.addAll(_35);
      for (Network _40 : _34) {
        _cachereverseallNetConnectionsNetwork.add(_40);
      }
    }
    return _cachereverseallNetConnectionsNetwork;
  }

  public void addRoutingFirewalls(RoutingFirewall routingFirewalls) {
    this.routingFirewalls = routingFirewalls;
    routingFirewalls.connectionRules.add(this);
  }

  public void addApplications(Application applications) {
    this.applications.add(applications);
    applications.appConnections.add(this);
  }

  public void addInApplications(Application inApplications) {
    this.inApplications.add(inApplications);
    inApplications.ingoingAppConnections.add(this);
  }

  public void addOutApplications(Application outApplications) {
    this.outApplications.add(outApplications);
    outApplications.outgoingAppConnections.add(this);
  }

  public void addNetworks(Network networks) {
    this.networks.add(networks);
    networks.netConnections.add(this);
  }

  public void addOutNetworks(Network outNetworks) {
    this.outNetworks.add(outNetworks);
    outNetworks.outgoingNetConnections.add(this);
  }

  public void addInNetworks(Network inNetworks) {
    this.inNetworks.add(inNetworks);
    inNetworks.ingoingNetConnections.add(this);
  }

  public void addDiodeInNetworks(Network diodeInNetworks) {
    this.diodeInNetworks.add(diodeInNetworks);
    diodeInNetworks.diodeIngoingNetConnections.add(this);
  }

  @Override
  public String getAssociatedAssetClassName(String field) {
    if (field.equals("routingFirewalls")) {
      return RoutingFirewall.class.getName();
    } else if (field.equals("applications")) {
      return Application.class.getName();
    } else if (field.equals("inApplications")) {
      return Application.class.getName();
    } else if (field.equals("outApplications")) {
      return Application.class.getName();
    } else if (field.equals("networks")) {
      return Network.class.getName();
    } else if (field.equals("outNetworks")) {
      return Network.class.getName();
    } else if (field.equals("inNetworks")) {
      return Network.class.getName();
    } else if (field.equals("diodeInNetworks")) {
      return Network.class.getName();
    }
    return "";
  }

  @Override
  public Set<Asset> getAssociatedAssets(String field) {
    Set<Asset> assets = new HashSet<>();
    if (field.equals("routingFirewalls")) {
      if (routingFirewalls != null) {
        assets.add(routingFirewalls);
      }
    } else if (field.equals("applications")) {
      assets.addAll(applications);
    } else if (field.equals("inApplications")) {
      assets.addAll(inApplications);
    } else if (field.equals("outApplications")) {
      assets.addAll(outApplications);
    } else if (field.equals("networks")) {
      assets.addAll(networks);
    } else if (field.equals("outNetworks")) {
      assets.addAll(outNetworks);
    } else if (field.equals("inNetworks")) {
      assets.addAll(inNetworks);
    } else if (field.equals("diodeInNetworks")) {
      assets.addAll(diodeInNetworks);
    }
    return assets;
  }

  @Override
  public Set<Asset> getAllAssociatedAssets() {
    Set<Asset> assets = new HashSet<>();
    if (routingFirewalls != null) {
      assets.add(routingFirewalls);
    }
    assets.addAll(applications);
    assets.addAll(inApplications);
    assets.addAll(outApplications);
    assets.addAll(networks);
    assets.addAll(outNetworks);
    assets.addAll(inNetworks);
    assets.addAll(diodeInNetworks);
    return assets;
  }

  @Override
  public HashMap<String, HashSet<Asset>> getFields() {
    var fields = super.getFields();
    fields.put("routingFirewalls", new HashSet<Asset>());
    if (routingFirewalls != null) {
      fields.get("routingFirewalls").add(routingFirewalls);
    }
    fields.put("applications", new HashSet<Asset>());
    fields.get("applications").addAll(applications);
    fields.put("inApplications", new HashSet<Asset>());
    fields.get("inApplications").addAll(inApplications);
    fields.put("outApplications", new HashSet<Asset>());
    fields.get("outApplications").addAll(outApplications);
    fields.put("networks", new HashSet<Asset>());
    fields.get("networks").addAll(networks);
    fields.put("outNetworks", new HashSet<Asset>());
    fields.get("outNetworks").addAll(outNetworks);
    fields.put("inNetworks", new HashSet<Asset>());
    fields.get("inNetworks").addAll(inNetworks);
    fields.put("diodeInNetworks", new HashSet<Asset>());
    fields.get("diodeInNetworks").addAll(diodeInNetworks);
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
          _cacheChildrenDisabled.add(accessNetworks);
          _cacheChildrenDisabled.add(connectToApplications);
          _cacheChildrenDisabled.add(transmit);
          _cacheChildrenDisabled.add(transmitResponse);
          _cacheChildrenDisabled.add(denialOfService);
          _cacheChildrenDisabled.add(eavedropOnDataInTransit);
          _cacheChildrenDisabled.add(mainInTheMiddleOnDataInTransit);
        }
        for (AttackStep attackStep : _cacheChildrenDisabled) {
          attackStep.updateTtc(this, ttc, attackSteps);
        }
      }

      @Override
      public Set<AttackStep> getAttackStepChildren() {
        var tmp = super.getAttackStepChildren();
        tmp.add(accessNetworks);
        tmp.add(connectToApplications);
        tmp.add(transmit);
        tmp.add(transmitResponse);
        tmp.add(denialOfService);
        tmp.add(eavedropOnDataInTransit);
        tmp.add(mainInTheMiddleOnDataInTransit);
        return tmp;
      }

      @Override
      public String fullName() {
        return "ConnectionRule.disabled";
      }
    }
  }

  public class Filtered extends Defense {
    public Filtered(String name) {
      this(name, false);
    }

    public Filtered(String name, Boolean isEnabled) {
      super(name);
      defaultValue = isEnabled;
      disable = new Disable(name);
    }

    public class Disable extends AttackStepMin {
      private Set<AttackStep> _cacheChildrenFiltered;

      public Disable(String name) {
        super(name);
      }

      @Override
      public void updateChildren(Set<AttackStep> attackSteps) {
        if (_cacheChildrenFiltered == null) {
          _cacheChildrenFiltered = new HashSet<>();
          _cacheChildrenFiltered.add(transmit);
          _cacheChildrenFiltered.add(transmitResponse);
        }
        for (AttackStep attackStep : _cacheChildrenFiltered) {
          attackStep.updateTtc(this, ttc, attackSteps);
        }
      }

      @Override
      public Set<AttackStep> getAttackStepChildren() {
        var tmp = super.getAttackStepChildren();
        tmp.add(transmit);
        tmp.add(transmitResponse);
        return tmp;
      }

      @Override
      public String fullName() {
        return "ConnectionRule.filtered";
      }
    }
  }

  public class AttemptAccessNetworks extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAttemptAccessNetworks;

    private Set<AttackStep> _cacheParentAttemptAccessNetworks;

    public AttemptAccessNetworks(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAttemptAccessNetworks == null) {
        _cacheChildrenAttemptAccessNetworks = new HashSet<>();
        _cacheChildrenAttemptAccessNetworks.add(accessNetworks);
      }
      for (AttackStep attackStep : _cacheChildrenAttemptAccessNetworks) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepChildren() {
      var tmp = super.getAttackStepChildren();
      tmp.add(accessNetworks);
      return tmp;
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAttemptAccessNetworks == null) {
        _cacheParentAttemptAccessNetworks = new HashSet<>();
        for (var _0 : _reverseallApplicationConnectionsApplication()) {
          _cacheParentAttemptAccessNetworks.add(_0.accessNetworkAndConnections);
        }
        for (var _1 : _reverseallowedNetworkConnectionsNetwork()) {
          _cacheParentAttemptAccessNetworks.add(_1.networkForwarding);
        }
      }
      for (AttackStep attackStep : _cacheParentAttemptAccessNetworks) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepParents() {
      var tmp = super.getAttackStepParents();
      for (var _2 : _reverseallApplicationConnectionsApplication()) {
        tmp.add(_2.accessNetworkAndConnections);
      }
      for (var _3 : _reverseallowedNetworkConnectionsNetwork()) {
        tmp.add(_3.networkForwarding);
      }
      return tmp;
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("ConnectionRule.attemptAccessNetworks");
    }
  }

  public class AccessNetworks extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenAccessNetworks;

    private Set<AttackStep> _cacheParentAccessNetworks;

    public AccessNetworks(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAccessNetworks == null) {
        _cacheChildrenAccessNetworks = new HashSet<>();
        Set<Network> _0 = new HashSet<>();
        Set<Network> _1 = new HashSet<>();
        Set<Network> _2 = new HashSet<>();
        Set<Network> _3 = new HashSet<>();
        for (Network _4 : networks) {
          _2.add(_4);
        }
        for (Network _5 : inNetworks) {
          _3.add(_5);
        }
        _2.addAll(_3);
        for (Network _6 : _2) {
          _0.add(_6);
        }
        for (Network _7 : diodeInNetworks) {
          _1.add(_7);
        }
        _0.addAll(_1);
        for (Network _8 : _0) {
          _cacheChildrenAccessNetworks.add(_8.access);
        }
      }
      for (AttackStep attackStep : _cacheChildrenAccessNetworks) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepChildren() {
      var tmp = super.getAttackStepChildren();
      Set<Network> _9 = new HashSet<>();
      Set<Network> _a = new HashSet<>();
      Set<Network> _b = new HashSet<>();
      Set<Network> _c = new HashSet<>();
      for (Network _d : networks) {
        _b.add(_d);
      }
      for (Network _e : inNetworks) {
        _c.add(_e);
      }
      _b.addAll(_c);
      for (Network _f : _b) {
        _9.add(_f);
      }
      for (Network _10 : diodeInNetworks) {
        _a.add(_10);
      }
      _9.addAll(_a);
      for (Network _11 : _9) {
        tmp.add(_11.access);
      }
      return tmp;
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAccessNetworks == null) {
        _cacheParentAccessNetworks = new HashSet<>();
        _cacheParentAccessNetworks.add(disabled.disable);
        _cacheParentAccessNetworks.add(attemptAccessNetworks);
      }
      for (AttackStep attackStep : _cacheParentAccessNetworks) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepParents() {
      var tmp = super.getAttackStepParents();
      tmp.add(disabled.disable);
      tmp.add(attemptAccessNetworks);
      return tmp;
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("ConnectionRule.accessNetworks");
    }
  }

  public class AttemptConnectToApplications extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAttemptConnectToApplications;

    private Set<AttackStep> _cacheParentAttemptConnectToApplications;

    public AttemptConnectToApplications(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAttemptConnectToApplications == null) {
        _cacheChildrenAttemptConnectToApplications = new HashSet<>();
        _cacheChildrenAttemptConnectToApplications.add(connectToApplications);
      }
      for (AttackStep attackStep : _cacheChildrenAttemptConnectToApplications) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepChildren() {
      var tmp = super.getAttackStepChildren();
      tmp.add(connectToApplications);
      return tmp;
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAttemptConnectToApplications == null) {
        _cacheParentAttemptConnectToApplications = new HashSet<>();
        for (var _0 : _reverseclientApplicationConnectionsApplication()) {
          _cacheParentAttemptConnectToApplications.add(_0.accessNetworkAndConnections);
        }
        for (var _1 : _reverseallowedApplicationConnectionsNetwork()) {
          _cacheParentAttemptConnectToApplications.add(_1.successfulAccess);
        }
        for (var _2 : _reverseallowedNetworkConnectionsNetwork()) {
          _cacheParentAttemptConnectToApplications.add(_2.networkForwarding);
        }
      }
      for (AttackStep attackStep : _cacheParentAttemptConnectToApplications) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepParents() {
      var tmp = super.getAttackStepParents();
      for (var _3 : _reverseclientApplicationConnectionsApplication()) {
        tmp.add(_3.accessNetworkAndConnections);
      }
      for (var _4 : _reverseallowedApplicationConnectionsNetwork()) {
        tmp.add(_4.successfulAccess);
      }
      for (var _5 : _reverseallowedNetworkConnectionsNetwork()) {
        tmp.add(_5.networkForwarding);
      }
      return tmp;
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("ConnectionRule.attemptConnectToApplications");
    }
  }

  public class ConnectToApplications extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenConnectToApplications;

    private Set<AttackStep> _cacheParentConnectToApplications;

    public ConnectToApplications(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenConnectToApplications == null) {
        _cacheChildrenConnectToApplications = new HashSet<>();
        for (var _0 : _serverApplicationsConnectionRule()) {
          _cacheChildrenConnectToApplications.add(_0.networkConnect);
        }
      }
      for (AttackStep attackStep : _cacheChildrenConnectToApplications) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepChildren() {
      var tmp = super.getAttackStepChildren();
      for (var _1 : _serverApplicationsConnectionRule()) {
        tmp.add(_1.networkConnect);
      }
      return tmp;
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentConnectToApplications == null) {
        _cacheParentConnectToApplications = new HashSet<>();
        _cacheParentConnectToApplications.add(disabled.disable);
        _cacheParentConnectToApplications.add(attemptConnectToApplications);
      }
      for (AttackStep attackStep : _cacheParentConnectToApplications) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepParents() {
      var tmp = super.getAttackStepParents();
      tmp.add(disabled.disable);
      tmp.add(attemptConnectToApplications);
      return tmp;
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("ConnectionRule.connectToApplications");
    }
  }

  public class AttemptTransmitResponse extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAttemptTransmitResponse;

    private Set<AttackStep> _cacheParentAttemptTransmitResponse;

    public AttemptTransmitResponse(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAttemptTransmitResponse == null) {
        _cacheChildrenAttemptTransmitResponse = new HashSet<>();
        _cacheChildrenAttemptTransmitResponse.add(transmitResponse);
      }
      for (AttackStep attackStep : _cacheChildrenAttemptTransmitResponse) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepChildren() {
      var tmp = super.getAttackStepChildren();
      tmp.add(transmitResponse);
      return tmp;
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAttemptTransmitResponse == null) {
        _cacheParentAttemptTransmitResponse = new HashSet<>();
        for (var _0 : _reverseserverApplicationConnectionsApplication()) {
          _cacheParentAttemptTransmitResponse.add(_0.accessNetworkAndConnections);
        }
        for (var _1 : _reverseallowedNetworkConnectionsNetwork()) {
          _cacheParentAttemptTransmitResponse.add(_1.networkForwarding);
        }
      }
      for (AttackStep attackStep : _cacheParentAttemptTransmitResponse) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepParents() {
      var tmp = super.getAttackStepParents();
      for (var _2 : _reverseserverApplicationConnectionsApplication()) {
        tmp.add(_2.accessNetworkAndConnections);
      }
      for (var _3 : _reverseallowedNetworkConnectionsNetwork()) {
        tmp.add(_3.networkForwarding);
      }
      return tmp;
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("ConnectionRule.attemptTransmitResponse");
    }
  }

  public class TransmitResponse extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenTransmitResponse;

    private Set<AttackStep> _cacheParentTransmitResponse;

    public TransmitResponse(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenTransmitResponse == null) {
        _cacheChildrenTransmitResponse = new HashSet<>();
        for (var _0 : _clientApplicationsConnectionRule()) {
          _cacheChildrenTransmitResponse.add(_0.networkRespondConnect);
        }
      }
      for (AttackStep attackStep : _cacheChildrenTransmitResponse) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepChildren() {
      var tmp = super.getAttackStepChildren();
      for (var _1 : _clientApplicationsConnectionRule()) {
        tmp.add(_1.networkRespondConnect);
      }
      return tmp;
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentTransmitResponse == null) {
        _cacheParentTransmitResponse = new HashSet<>();
        for (Application _2 : applications) {
          for (Vulnerability _3 : _2.vulnerabilities) {
            if (_3 instanceof UnknownVulnerability) {
              _cacheParentTransmitResponse.add(((org.mal_lang.joh_mal_bugs.example1.test.UnknownVulnerability) _3).requestForgery);
            }
          }
        }
        _cacheParentTransmitResponse.add(disabled.disable);
        _cacheParentTransmitResponse.add(filtered.disable);
        _cacheParentTransmitResponse.add(attemptTransmitResponse);
      }
      for (AttackStep attackStep : _cacheParentTransmitResponse) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepParents() {
      var tmp = super.getAttackStepParents();
      for (Application _4 : applications) {
        for (Vulnerability _5 : _4.vulnerabilities) {
          if (_5 instanceof UnknownVulnerability) {
            tmp.add(((org.mal_lang.joh_mal_bugs.example1.test.UnknownVulnerability) _5).requestForgery);
          }
        }
      }
      tmp.add(disabled.disable);
      tmp.add(filtered.disable);
      tmp.add(attemptTransmitResponse);
      return tmp;
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("ConnectionRule.transmitResponse");
    }
  }

  public class AttemptTransmit extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAttemptTransmit;

    private Set<AttackStep> _cacheParentAttemptTransmit;

    public AttemptTransmit(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAttemptTransmit == null) {
        _cacheChildrenAttemptTransmit = new HashSet<>();
        _cacheChildrenAttemptTransmit.add(transmit);
      }
      for (AttackStep attackStep : _cacheChildrenAttemptTransmit) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepChildren() {
      var tmp = super.getAttackStepChildren();
      tmp.add(transmit);
      return tmp;
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAttemptTransmit == null) {
        _cacheParentAttemptTransmit = new HashSet<>();
        for (var _0 : _reverseclientApplicationConnectionsApplication()) {
          _cacheParentAttemptTransmit.add(_0.accessNetworkAndConnections);
        }
        for (var _1 : _reverseallowedApplicationConnectionsNetwork()) {
          _cacheParentAttemptTransmit.add(_1.successfulAccess);
        }
      }
      for (AttackStep attackStep : _cacheParentAttemptTransmit) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepParents() {
      var tmp = super.getAttackStepParents();
      for (var _2 : _reverseclientApplicationConnectionsApplication()) {
        tmp.add(_2.accessNetworkAndConnections);
      }
      for (var _3 : _reverseallowedApplicationConnectionsNetwork()) {
        tmp.add(_3.successfulAccess);
      }
      return tmp;
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("ConnectionRule.attemptTransmit");
    }
  }

  public class Transmit extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenTransmit;

    private Set<AttackStep> _cacheParentTransmit;

    public Transmit(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenTransmit == null) {
        _cacheChildrenTransmit = new HashSet<>();
        for (var _0 : _clientApplicationsConnectionRule()) {
          _cacheChildrenTransmit.add(_0.networkRequestConnect);
        }
      }
      for (AttackStep attackStep : _cacheChildrenTransmit) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepChildren() {
      var tmp = super.getAttackStepChildren();
      for (var _1 : _clientApplicationsConnectionRule()) {
        tmp.add(_1.networkRequestConnect);
      }
      return tmp;
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentTransmit == null) {
        _cacheParentTransmit = new HashSet<>();
        for (Application _2 : applications) {
          for (Vulnerability _3 : _2.vulnerabilities) {
            if (_3 instanceof UnknownVulnerability) {
              _cacheParentTransmit.add(((org.mal_lang.joh_mal_bugs.example1.test.UnknownVulnerability) _3).requestForgery);
            }
          }
        }
        _cacheParentTransmit.add(disabled.disable);
        _cacheParentTransmit.add(filtered.disable);
        _cacheParentTransmit.add(attemptTransmit);
      }
      for (AttackStep attackStep : _cacheParentTransmit) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepParents() {
      var tmp = super.getAttackStepParents();
      for (Application _4 : applications) {
        for (Vulnerability _5 : _4.vulnerabilities) {
          if (_5 instanceof UnknownVulnerability) {
            tmp.add(((org.mal_lang.joh_mal_bugs.example1.test.UnknownVulnerability) _5).requestForgery);
          }
        }
      }
      tmp.add(disabled.disable);
      tmp.add(filtered.disable);
      tmp.add(attemptTransmit);
      return tmp;
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("ConnectionRule.transmit");
    }
  }

  public class AttemptDenialOfService extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAttemptDenialOfService;

    private Set<AttackStep> _cacheParentAttemptDenialOfService;

    public AttemptDenialOfService(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAttemptDenialOfService == null) {
        _cacheChildrenAttemptDenialOfService = new HashSet<>();
        _cacheChildrenAttemptDenialOfService.add(denialOfService);
      }
      for (AttackStep attackStep : _cacheChildrenAttemptDenialOfService) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepChildren() {
      var tmp = super.getAttackStepChildren();
      tmp.add(denialOfService);
      return tmp;
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAttemptDenialOfService == null) {
        _cacheParentAttemptDenialOfService = new HashSet<>();
        for (var _0 : _reverseallNetConnectionsNetwork()) {
          _cacheParentAttemptDenialOfService.add(_0.denialOfService);
        }
        if (routingFirewalls != null) {
          _cacheParentAttemptDenialOfService.add(routingFirewalls.denialOfService);
        }
      }
      for (AttackStep attackStep : _cacheParentAttemptDenialOfService) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepParents() {
      var tmp = super.getAttackStepParents();
      for (var _1 : _reverseallNetConnectionsNetwork()) {
        tmp.add(_1.denialOfService);
      }
      if (routingFirewalls != null) {
        tmp.add(routingFirewalls.denialOfService);
      }
      return tmp;
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("ConnectionRule.attemptDenialOfService");
    }
  }

  public class DenialOfService extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenDenialOfService;

    private Set<AttackStep> _cacheParentDenialOfService;

    public DenialOfService(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenDenialOfService == null) {
        _cacheChildrenDenialOfService = new HashSet<>();
        for (var _0 : _allApplicationsConnectionRule()) {
          _cacheChildrenDenialOfService.add(_0.denyFromConnectionRule);
        }
      }
      for (AttackStep attackStep : _cacheChildrenDenialOfService) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepChildren() {
      var tmp = super.getAttackStepChildren();
      for (var _1 : _allApplicationsConnectionRule()) {
        tmp.add(_1.denyFromConnectionRule);
      }
      return tmp;
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentDenialOfService == null) {
        _cacheParentDenialOfService = new HashSet<>();
        _cacheParentDenialOfService.add(disabled.disable);
        _cacheParentDenialOfService.add(attemptDenialOfService);
      }
      for (AttackStep attackStep : _cacheParentDenialOfService) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepParents() {
      var tmp = super.getAttackStepParents();
      tmp.add(disabled.disable);
      tmp.add(attemptDenialOfService);
      return tmp;
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("ConnectionRule.denialOfService");
    }
  }

  public class AttemptEavesdropOnDataInTransit extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAttemptEavesdropOnDataInTransit;

    private Set<AttackStep> _cacheParentAttemptEavesdropOnDataInTransit;

    public AttemptEavesdropOnDataInTransit(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAttemptEavesdropOnDataInTransit == null) {
        _cacheChildrenAttemptEavesdropOnDataInTransit = new HashSet<>();
        _cacheChildrenAttemptEavesdropOnDataInTransit.add(eavedropOnDataInTransit);
      }
      for (AttackStep attackStep : _cacheChildrenAttemptEavesdropOnDataInTransit) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepChildren() {
      var tmp = super.getAttackStepChildren();
      tmp.add(eavedropOnDataInTransit);
      return tmp;
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAttemptEavesdropOnDataInTransit == null) {
        _cacheParentAttemptEavesdropOnDataInTransit = new HashSet<>();
        for (var _0 : _reverseallowedApplicationConnectionsNetwork()) {
          _cacheParentAttemptEavesdropOnDataInTransit.add(_0.eavesdrop);
        }
        for (var _1 : _reverseallowedApplicationConnectionsNetwork()) {
          _cacheParentAttemptEavesdropOnDataInTransit.add(_1.bypassEavesdropProtection);
        }
        for (var _2 : _reverseallowedApplicationConnectionsNetwork()) {
          _cacheParentAttemptEavesdropOnDataInTransit.add(_2.eavesdropAfterPhysicalAccess);
        }
      }
      for (AttackStep attackStep : _cacheParentAttemptEavesdropOnDataInTransit) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepParents() {
      var tmp = super.getAttackStepParents();
      for (var _3 : _reverseallowedApplicationConnectionsNetwork()) {
        tmp.add(_3.eavesdrop);
      }
      for (var _4 : _reverseallowedApplicationConnectionsNetwork()) {
        tmp.add(_4.bypassEavesdropProtection);
      }
      for (var _5 : _reverseallowedApplicationConnectionsNetwork()) {
        tmp.add(_5.eavesdropAfterPhysicalAccess);
      }
      return tmp;
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("ConnectionRule.attemptEavesdropOnDataInTransit");
    }
  }

  public class EavedropOnDataInTransit extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenEavedropOnDataInTransit;

    private Set<AttackStep> _cacheParentEavedropOnDataInTransit;

    public EavedropOnDataInTransit(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenEavedropOnDataInTransit == null) {
        _cacheChildrenEavedropOnDataInTransit = new HashSet<>();
        for (var _0 : _allApplicationsConnectionRule()) {
          for (Data _1 : _0.transitData) {
            _cacheChildrenEavedropOnDataInTransit.add(_1.attemptEavesdrop);
          }
        }
      }
      for (AttackStep attackStep : _cacheChildrenEavedropOnDataInTransit) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepChildren() {
      var tmp = super.getAttackStepChildren();
      for (var _2 : _allApplicationsConnectionRule()) {
        for (Data _3 : _2.transitData) {
          tmp.add(_3.attemptEavesdrop);
        }
      }
      return tmp;
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentEavedropOnDataInTransit == null) {
        _cacheParentEavedropOnDataInTransit = new HashSet<>();
        _cacheParentEavedropOnDataInTransit.add(disabled.disable);
        _cacheParentEavedropOnDataInTransit.add(attemptEavesdropOnDataInTransit);
      }
      for (AttackStep attackStep : _cacheParentEavedropOnDataInTransit) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepParents() {
      var tmp = super.getAttackStepParents();
      tmp.add(disabled.disable);
      tmp.add(attemptEavesdropOnDataInTransit);
      return tmp;
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("ConnectionRule.eavedropOnDataInTransit");
    }
  }

  public class AttemptManInTheMiddleOnDataInTransit extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAttemptManInTheMiddleOnDataInTransit;

    private Set<AttackStep> _cacheParentAttemptManInTheMiddleOnDataInTransit;

    public AttemptManInTheMiddleOnDataInTransit(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAttemptManInTheMiddleOnDataInTransit == null) {
        _cacheChildrenAttemptManInTheMiddleOnDataInTransit = new HashSet<>();
        _cacheChildrenAttemptManInTheMiddleOnDataInTransit.add(mainInTheMiddleOnDataInTransit);
      }
      for (AttackStep attackStep : _cacheChildrenAttemptManInTheMiddleOnDataInTransit) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepChildren() {
      var tmp = super.getAttackStepChildren();
      tmp.add(mainInTheMiddleOnDataInTransit);
      return tmp;
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAttemptManInTheMiddleOnDataInTransit == null) {
        _cacheParentAttemptManInTheMiddleOnDataInTransit = new HashSet<>();
        for (var _0 : _reverseallowedApplicationConnectionsNetwork()) {
          _cacheParentAttemptManInTheMiddleOnDataInTransit.add(_0.manInTheMiddle);
        }
        for (var _1 : _reverseallowedApplicationConnectionsNetwork()) {
          _cacheParentAttemptManInTheMiddleOnDataInTransit.add(_1.bypassMitMProtection);
        }
      }
      for (AttackStep attackStep : _cacheParentAttemptManInTheMiddleOnDataInTransit) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepParents() {
      var tmp = super.getAttackStepParents();
      for (var _2 : _reverseallowedApplicationConnectionsNetwork()) {
        tmp.add(_2.manInTheMiddle);
      }
      for (var _3 : _reverseallowedApplicationConnectionsNetwork()) {
        tmp.add(_3.bypassMitMProtection);
      }
      return tmp;
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("ConnectionRule.attemptManInTheMiddleOnDataInTransit");
    }
  }

  public class MainInTheMiddleOnDataInTransit extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenMainInTheMiddleOnDataInTransit;

    private Set<AttackStep> _cacheParentMainInTheMiddleOnDataInTransit;

    public MainInTheMiddleOnDataInTransit(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenMainInTheMiddleOnDataInTransit == null) {
        _cacheChildrenMainInTheMiddleOnDataInTransit = new HashSet<>();
        for (var _0 : _allApplicationsConnectionRule()) {
          for (Data _1 : _0.transitData) {
            _cacheChildrenMainInTheMiddleOnDataInTransit.add(_1.attemptManInTheMiddle);
          }
        }
      }
      for (AttackStep attackStep : _cacheChildrenMainInTheMiddleOnDataInTransit) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepChildren() {
      var tmp = super.getAttackStepChildren();
      for (var _2 : _allApplicationsConnectionRule()) {
        for (Data _3 : _2.transitData) {
          tmp.add(_3.attemptManInTheMiddle);
        }
      }
      return tmp;
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentMainInTheMiddleOnDataInTransit == null) {
        _cacheParentMainInTheMiddleOnDataInTransit = new HashSet<>();
        _cacheParentMainInTheMiddleOnDataInTransit.add(disabled.disable);
        _cacheParentMainInTheMiddleOnDataInTransit.add(attemptManInTheMiddleOnDataInTransit);
      }
      for (AttackStep attackStep : _cacheParentMainInTheMiddleOnDataInTransit) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepParents() {
      var tmp = super.getAttackStepParents();
      tmp.add(disabled.disable);
      tmp.add(attemptManInTheMiddleOnDataInTransit);
      return tmp;
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("ConnectionRule.mainInTheMiddleOnDataInTransit");
    }
  }
}
