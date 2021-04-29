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

public class Network extends Asset {
  public PhysicalAccess physicalAccess;

  public NetworkAccessControl networkAccessControl;

  public BypassAccessControl bypassAccessControl;

  public AttemptAccess attemptAccess;

  public Access access;

  public SuccessfulAccess successfulAccess;

  public NetworkForwarding networkForwarding;

  public DenialOfService denialOfService;

  public AccessNetworkData accessNetworkData;

  public EavesdropDefense eavesdropDefense;

  public ManInTheMiddleDefense manInTheMiddleDefense;

  public Eavesdrop eavesdrop;

  public BypassEavesdropProtection bypassEavesdropProtection;

  public ManInTheMiddle manInTheMiddle;

  public BypassMitMProtection bypassMitMProtection;

  public EavesdropAfterPhysicalAccess eavesdropAfterPhysicalAccess;

  private Set<ConnectionRule> _cacheallowedApplicationConnectionsNetwork;

  private Set<ConnectionRule> _cacheallowedNetworkConnectionsNetwork;

  private Set<ConnectionRule> _cacheallNetConnectionsNetwork;

  private Set<Application> _cacheallowedApplicationConnectionsApplicationsNetwork;

  private Set<Application> _cacheallNetApplicationsNetwork;

  public Set<Application> applications = new HashSet<>();

  public Set<Application> clientApplications = new HashSet<>();

  public Set<ConnectionRule> netConnections = new HashSet<>();

  public Set<ConnectionRule> outgoingNetConnections = new HashSet<>();

  public Set<ConnectionRule> ingoingNetConnections = new HashSet<>();

  public Set<ConnectionRule> diodeIngoingNetConnections = new HashSet<>();

  public Set<Data> transitData = new HashSet<>();

  public Network(String name, boolean isNetworkAccessControlEnabled,
      boolean isEavesdropDefenseEnabled, boolean isManInTheMiddleDefenseEnabled) {
    super(name);
    assetClassName = "Network";
    AttackStep.allAttackSteps.remove(physicalAccess);
    physicalAccess = new PhysicalAccess(name);
    if (networkAccessControl != null) {
      AttackStep.allAttackSteps.remove(networkAccessControl.disable);
    }
    Defense.allDefenses.remove(networkAccessControl);
    networkAccessControl = new NetworkAccessControl(name, isNetworkAccessControlEnabled);
    AttackStep.allAttackSteps.remove(bypassAccessControl);
    bypassAccessControl = new BypassAccessControl(name);
    AttackStep.allAttackSteps.remove(attemptAccess);
    attemptAccess = new AttemptAccess(name);
    AttackStep.allAttackSteps.remove(access);
    access = new Access(name);
    AttackStep.allAttackSteps.remove(successfulAccess);
    successfulAccess = new SuccessfulAccess(name);
    AttackStep.allAttackSteps.remove(networkForwarding);
    networkForwarding = new NetworkForwarding(name);
    AttackStep.allAttackSteps.remove(denialOfService);
    denialOfService = new DenialOfService(name);
    AttackStep.allAttackSteps.remove(accessNetworkData);
    accessNetworkData = new AccessNetworkData(name);
    if (eavesdropDefense != null) {
      AttackStep.allAttackSteps.remove(eavesdropDefense.disable);
    }
    Defense.allDefenses.remove(eavesdropDefense);
    eavesdropDefense = new EavesdropDefense(name, isEavesdropDefenseEnabled);
    if (manInTheMiddleDefense != null) {
      AttackStep.allAttackSteps.remove(manInTheMiddleDefense.disable);
    }
    Defense.allDefenses.remove(manInTheMiddleDefense);
    manInTheMiddleDefense = new ManInTheMiddleDefense(name, isManInTheMiddleDefenseEnabled);
    AttackStep.allAttackSteps.remove(eavesdrop);
    eavesdrop = new Eavesdrop(name);
    AttackStep.allAttackSteps.remove(bypassEavesdropProtection);
    bypassEavesdropProtection = new BypassEavesdropProtection(name);
    AttackStep.allAttackSteps.remove(manInTheMiddle);
    manInTheMiddle = new ManInTheMiddle(name);
    AttackStep.allAttackSteps.remove(bypassMitMProtection);
    bypassMitMProtection = new BypassMitMProtection(name);
    AttackStep.allAttackSteps.remove(eavesdropAfterPhysicalAccess);
    eavesdropAfterPhysicalAccess = new EavesdropAfterPhysicalAccess(name);
  }

  public Network(String name) {
    super(name);
    assetClassName = "Network";
    AttackStep.allAttackSteps.remove(physicalAccess);
    physicalAccess = new PhysicalAccess(name);
    if (networkAccessControl != null) {
      AttackStep.allAttackSteps.remove(networkAccessControl.disable);
    }
    Defense.allDefenses.remove(networkAccessControl);
    networkAccessControl = new NetworkAccessControl(name, false);
    AttackStep.allAttackSteps.remove(bypassAccessControl);
    bypassAccessControl = new BypassAccessControl(name);
    AttackStep.allAttackSteps.remove(attemptAccess);
    attemptAccess = new AttemptAccess(name);
    AttackStep.allAttackSteps.remove(access);
    access = new Access(name);
    AttackStep.allAttackSteps.remove(successfulAccess);
    successfulAccess = new SuccessfulAccess(name);
    AttackStep.allAttackSteps.remove(networkForwarding);
    networkForwarding = new NetworkForwarding(name);
    AttackStep.allAttackSteps.remove(denialOfService);
    denialOfService = new DenialOfService(name);
    AttackStep.allAttackSteps.remove(accessNetworkData);
    accessNetworkData = new AccessNetworkData(name);
    if (eavesdropDefense != null) {
      AttackStep.allAttackSteps.remove(eavesdropDefense.disable);
    }
    Defense.allDefenses.remove(eavesdropDefense);
    eavesdropDefense = new EavesdropDefense(name, false);
    if (manInTheMiddleDefense != null) {
      AttackStep.allAttackSteps.remove(manInTheMiddleDefense.disable);
    }
    Defense.allDefenses.remove(manInTheMiddleDefense);
    manInTheMiddleDefense = new ManInTheMiddleDefense(name, false);
    AttackStep.allAttackSteps.remove(eavesdrop);
    eavesdrop = new Eavesdrop(name);
    AttackStep.allAttackSteps.remove(bypassEavesdropProtection);
    bypassEavesdropProtection = new BypassEavesdropProtection(name);
    AttackStep.allAttackSteps.remove(manInTheMiddle);
    manInTheMiddle = new ManInTheMiddle(name);
    AttackStep.allAttackSteps.remove(bypassMitMProtection);
    bypassMitMProtection = new BypassMitMProtection(name);
    AttackStep.allAttackSteps.remove(eavesdropAfterPhysicalAccess);
    eavesdropAfterPhysicalAccess = new EavesdropAfterPhysicalAccess(name);
  }

  public Network(boolean isNetworkAccessControlEnabled, boolean isEavesdropDefenseEnabled,
      boolean isManInTheMiddleDefenseEnabled) {
    this("Anonymous", isNetworkAccessControlEnabled, isEavesdropDefenseEnabled, isManInTheMiddleDefenseEnabled);
  }

  public Network() {
    this("Anonymous");
  }

  protected Set<ConnectionRule> _allowedApplicationConnectionsNetwork() {
    if (_cacheallowedApplicationConnectionsNetwork == null) {
      _cacheallowedApplicationConnectionsNetwork = new HashSet<>();
      Set<ConnectionRule> _8 = new HashSet<>();
      Set<ConnectionRule> _9 = new HashSet<>();
      for (ConnectionRule _a : netConnections) {
        _8.add(_a);
      }
      for (ConnectionRule _b : outgoingNetConnections) {
        _9.add(_b);
      }
      _8.addAll(_9);
      for (ConnectionRule _c : _8) {
        _cacheallowedApplicationConnectionsNetwork.add(_c);
      }
    }
    return _cacheallowedApplicationConnectionsNetwork;
  }

  protected Set<ConnectionRule> _allowedNetworkConnectionsNetwork() {
    if (_cacheallowedNetworkConnectionsNetwork == null) {
      _cacheallowedNetworkConnectionsNetwork = new HashSet<>();
      Set<ConnectionRule> _d = new HashSet<>();
      Set<ConnectionRule> _e = new HashSet<>();
      for (ConnectionRule _f : netConnections) {
        _d.add(_f);
      }
      for (ConnectionRule _10 : outgoingNetConnections) {
        _e.add(_10);
      }
      _d.addAll(_e);
      for (ConnectionRule _11 : _d) {
        _cacheallowedNetworkConnectionsNetwork.add(_11);
      }
    }
    return _cacheallowedNetworkConnectionsNetwork;
  }

  protected Set<ConnectionRule> _allNetConnectionsNetwork() {
    if (_cacheallNetConnectionsNetwork == null) {
      _cacheallNetConnectionsNetwork = new HashSet<>();
      Set<ConnectionRule> _12 = new HashSet<>();
      Set<ConnectionRule> _13 = new HashSet<>();
      Set<ConnectionRule> _14 = new HashSet<>();
      Set<ConnectionRule> _15 = new HashSet<>();
      Set<ConnectionRule> _16 = new HashSet<>();
      Set<ConnectionRule> _17 = new HashSet<>();
      for (ConnectionRule _18 : netConnections) {
        _16.add(_18);
      }
      for (ConnectionRule _19 : ingoingNetConnections) {
        _17.add(_19);
      }
      _16.addAll(_17);
      for (ConnectionRule _1a : _16) {
        _14.add(_1a);
      }
      for (ConnectionRule _1b : outgoingNetConnections) {
        _15.add(_1b);
      }
      _14.addAll(_15);
      for (ConnectionRule _1c : _14) {
        _12.add(_1c);
      }
      for (ConnectionRule _1d : diodeIngoingNetConnections) {
        _13.add(_1d);
      }
      _12.addAll(_13);
      for (ConnectionRule _1e : _12) {
        _cacheallNetConnectionsNetwork.add(_1e);
      }
    }
    return _cacheallNetConnectionsNetwork;
  }

  protected Set<Application> _allowedApplicationConnectionsApplicationsNetwork() {
    if (_cacheallowedApplicationConnectionsApplicationsNetwork == null) {
      _cacheallowedApplicationConnectionsApplicationsNetwork = new HashSet<>();
      Set<Application> _1f = new HashSet<>();
      Set<Application> _20 = new HashSet<>();
      Set<Application> _21 = new HashSet<>();
      Set<Application> _22 = new HashSet<>();
      for (ConnectionRule _23 : netConnections) {
        for (Application _24 : _23.applications) {
          _21.add(_24);
        }
      }
      for (ConnectionRule _25 : outgoingNetConnections) {
        for (Application _26 : _25.applications) {
          _22.add(_26);
        }
      }
      _21.addAll(_22);
      for (Application _27 : _21) {
        _1f.add(_27);
      }
      for (Application _28 : applications) {
        _20.add(_28);
      }
      _1f.addAll(_20);
      for (Application _29 : _1f) {
        _cacheallowedApplicationConnectionsApplicationsNetwork.add(_29);
      }
    }
    return _cacheallowedApplicationConnectionsApplicationsNetwork;
  }

  protected Set<Application> _allNetApplicationsNetwork() {
    if (_cacheallNetApplicationsNetwork == null) {
      _cacheallNetApplicationsNetwork = new HashSet<>();
      Set<Application> _2a = new HashSet<>();
      Set<Application> _2b = new HashSet<>();
      for (Application _2c : clientApplications) {
        _2a.add(_2c);
      }
      for (Application _2d : applications) {
        _2b.add(_2d);
      }
      _2a.addAll(_2b);
      for (Application _2e : _2a) {
        _cacheallNetApplicationsNetwork.add(_2e);
      }
    }
    return _cacheallNetApplicationsNetwork;
  }

  public void addApplications(Application applications) {
    this.applications.add(applications);
    applications.networks.add(this);
  }

  public void addClientApplications(Application clientApplications) {
    this.clientApplications.add(clientApplications);
    clientApplications.clientAccessNetworks.add(this);
  }

  public void addNetConnections(ConnectionRule netConnections) {
    this.netConnections.add(netConnections);
    netConnections.networks.add(this);
  }

  public void addOutgoingNetConnections(ConnectionRule outgoingNetConnections) {
    this.outgoingNetConnections.add(outgoingNetConnections);
    outgoingNetConnections.outNetworks.add(this);
  }

  public void addIngoingNetConnections(ConnectionRule ingoingNetConnections) {
    this.ingoingNetConnections.add(ingoingNetConnections);
    ingoingNetConnections.inNetworks.add(this);
  }

  public void addDiodeIngoingNetConnections(ConnectionRule diodeIngoingNetConnections) {
    this.diodeIngoingNetConnections.add(diodeIngoingNetConnections);
    diodeIngoingNetConnections.diodeInNetworks.add(this);
  }

  public void addTransitData(Data transitData) {
    this.transitData.add(transitData);
    transitData.transitNetwork.add(this);
  }

  @Override
  public String getAssociatedAssetClassName(String field) {
    if (field.equals("applications")) {
      return Application.class.getName();
    } else if (field.equals("clientApplications")) {
      return Application.class.getName();
    } else if (field.equals("netConnections")) {
      return ConnectionRule.class.getName();
    } else if (field.equals("outgoingNetConnections")) {
      return ConnectionRule.class.getName();
    } else if (field.equals("ingoingNetConnections")) {
      return ConnectionRule.class.getName();
    } else if (field.equals("diodeIngoingNetConnections")) {
      return ConnectionRule.class.getName();
    } else if (field.equals("transitData")) {
      return Data.class.getName();
    }
    return "";
  }

  @Override
  public Set<Asset> getAssociatedAssets(String field) {
    Set<Asset> assets = new HashSet<>();
    if (field.equals("applications")) {
      assets.addAll(applications);
    } else if (field.equals("clientApplications")) {
      assets.addAll(clientApplications);
    } else if (field.equals("netConnections")) {
      assets.addAll(netConnections);
    } else if (field.equals("outgoingNetConnections")) {
      assets.addAll(outgoingNetConnections);
    } else if (field.equals("ingoingNetConnections")) {
      assets.addAll(ingoingNetConnections);
    } else if (field.equals("diodeIngoingNetConnections")) {
      assets.addAll(diodeIngoingNetConnections);
    } else if (field.equals("transitData")) {
      assets.addAll(transitData);
    }
    return assets;
  }

  @Override
  public Set<Asset> getAllAssociatedAssets() {
    Set<Asset> assets = new HashSet<>();
    assets.addAll(applications);
    assets.addAll(clientApplications);
    assets.addAll(netConnections);
    assets.addAll(outgoingNetConnections);
    assets.addAll(ingoingNetConnections);
    assets.addAll(diodeIngoingNetConnections);
    assets.addAll(transitData);
    return assets;
  }

  @Override
  public HashMap<String, HashSet<Asset>> getFields() {
    var fields = super.getFields();
    fields.put("applications", new HashSet<Asset>());
    fields.get("applications").addAll(applications);
    fields.put("clientApplications", new HashSet<Asset>());
    fields.get("clientApplications").addAll(clientApplications);
    fields.put("netConnections", new HashSet<Asset>());
    fields.get("netConnections").addAll(netConnections);
    fields.put("outgoingNetConnections", new HashSet<Asset>());
    fields.get("outgoingNetConnections").addAll(outgoingNetConnections);
    fields.put("ingoingNetConnections", new HashSet<Asset>());
    fields.get("ingoingNetConnections").addAll(ingoingNetConnections);
    fields.put("diodeIngoingNetConnections", new HashSet<Asset>());
    fields.get("diodeIngoingNetConnections").addAll(diodeIngoingNetConnections);
    fields.put("transitData", new HashSet<Asset>());
    fields.get("transitData").addAll(transitData);
    return fields;
  }

  public class PhysicalAccess extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenPhysicalAccess;

    public PhysicalAccess(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenPhysicalAccess == null) {
        _cacheChildrenPhysicalAccess = new HashSet<>();
        _cacheChildrenPhysicalAccess.add(denialOfService);
        _cacheChildrenPhysicalAccess.add(eavesdropAfterPhysicalAccess);
        _cacheChildrenPhysicalAccess.add(attemptAccess);
        _cacheChildrenPhysicalAccess.add(bypassAccessControl);
      }
      for (AttackStep attackStep : _cacheChildrenPhysicalAccess) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepChildren() {
      var tmp = super.getAttackStepChildren();
      tmp.add(denialOfService);
      tmp.add(eavesdropAfterPhysicalAccess);
      tmp.add(attemptAccess);
      tmp.add(bypassAccessControl);
      return tmp;
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Network.physicalAccess");
    }
  }

  public class NetworkAccessControl extends Defense {
    public NetworkAccessControl(String name) {
      this(name, false);
    }

    public NetworkAccessControl(String name, Boolean isEnabled) {
      super(name);
      defaultValue = isEnabled;
      disable = new Disable(name);
    }

    public class Disable extends AttackStepMin {
      private Set<AttackStep> _cacheChildrenNetworkAccessControl;

      public Disable(String name) {
        super(name);
      }

      @Override
      public void updateChildren(Set<AttackStep> attackSteps) {
        if (_cacheChildrenNetworkAccessControl == null) {
          _cacheChildrenNetworkAccessControl = new HashSet<>();
          _cacheChildrenNetworkAccessControl.add(eavesdropAfterPhysicalAccess);
          _cacheChildrenNetworkAccessControl.add(attemptAccess);
        }
        for (AttackStep attackStep : _cacheChildrenNetworkAccessControl) {
          attackStep.updateTtc(this, ttc, attackSteps);
        }
      }

      @Override
      public Set<AttackStep> getAttackStepChildren() {
        var tmp = super.getAttackStepChildren();
        tmp.add(eavesdropAfterPhysicalAccess);
        tmp.add(attemptAccess);
        return tmp;
      }

      @Override
      public String fullName() {
        return "Network.networkAccessControl";
      }
    }
  }

  public class BypassAccessControl extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenBypassAccessControl;

    private Set<AttackStep> _cacheParentBypassAccessControl;

    public BypassAccessControl(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenBypassAccessControl == null) {
        _cacheChildrenBypassAccessControl = new HashSet<>();
        _cacheChildrenBypassAccessControl.add(successfulAccess);
      }
      for (AttackStep attackStep : _cacheChildrenBypassAccessControl) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepChildren() {
      var tmp = super.getAttackStepChildren();
      tmp.add(successfulAccess);
      return tmp;
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentBypassAccessControl == null) {
        _cacheParentBypassAccessControl = new HashSet<>();
        _cacheParentBypassAccessControl.add(physicalAccess);
      }
      for (AttackStep attackStep : _cacheParentBypassAccessControl) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepParents() {
      var tmp = super.getAttackStepParents();
      tmp.add(physicalAccess);
      return tmp;
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Network.bypassAccessControl");
    }
  }

  public class AttemptAccess extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenAttemptAccess;

    private Set<AttackStep> _cacheParentAttemptAccess;

    public AttemptAccess(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAttemptAccess == null) {
        _cacheChildrenAttemptAccess = new HashSet<>();
        _cacheChildrenAttemptAccess.add(access);
      }
      for (AttackStep attackStep : _cacheChildrenAttemptAccess) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepChildren() {
      var tmp = super.getAttackStepChildren();
      tmp.add(access);
      return tmp;
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAttemptAccess == null) {
        _cacheParentAttemptAccess = new HashSet<>();
        _cacheParentAttemptAccess.add(physicalAccess);
        _cacheParentAttemptAccess.add(networkAccessControl.disable);
      }
      for (AttackStep attackStep : _cacheParentAttemptAccess) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepParents() {
      var tmp = super.getAttackStepParents();
      tmp.add(physicalAccess);
      tmp.add(networkAccessControl.disable);
      return tmp;
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Network.attemptAccess");
    }
  }

  public class Access extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAccess;

    private Set<AttackStep> _cacheParentAccess;

    public Access(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAccess == null) {
        _cacheChildrenAccess = new HashSet<>();
        _cacheChildrenAccess.add(successfulAccess);
      }
      for (AttackStep attackStep : _cacheChildrenAccess) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepChildren() {
      var tmp = super.getAttackStepChildren();
      tmp.add(successfulAccess);
      return tmp;
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAccess == null) {
        _cacheParentAccess = new HashSet<>();
        for (Application _0 : applications) {
          _cacheParentAccess.add(_0.accessNetworkAndConnections);
        }
        for (Application _1 : clientApplications) {
          _cacheParentAccess.add(_1.accessNetworkAndConnections);
        }
        _cacheParentAccess.add(attemptAccess);
        Set<RoutingFirewall> _2 = new HashSet<>();
        Set<RoutingFirewall> _3 = new HashSet<>();
        for (ConnectionRule _4 : diodeIngoingNetConnections) {
          if (_4.routingFirewalls != null) {
            _2.add(_4.routingFirewalls);
          }
        }
        Set<RoutingFirewall> _5 = new HashSet<>();
        Set<RoutingFirewall> _6 = new HashSet<>();
        for (ConnectionRule _7 : ingoingNetConnections) {
          if (_7.routingFirewalls != null) {
            _5.add(_7.routingFirewalls);
          }
        }
        Set<RoutingFirewall> _8 = new HashSet<>();
        Set<RoutingFirewall> _9 = new HashSet<>();
        for (ConnectionRule _a : outgoingNetConnections) {
          if (_a.routingFirewalls != null) {
            _8.add(_a.routingFirewalls);
          }
        }
        for (ConnectionRule _b : netConnections) {
          if (_b.routingFirewalls != null) {
            _9.add(_b.routingFirewalls);
          }
        }
        _8.addAll(_9);
        for (RoutingFirewall _c : _8) {
          _6.add(_c);
        }
        _5.addAll(_6);
        for (RoutingFirewall _d : _5) {
          _3.add(_d);
        }
        _2.addAll(_3);
        for (RoutingFirewall _e : _2) {
          _cacheParentAccess.add(_e.fullAccess);
        }
        Set<ConnectionRule> _f = new HashSet<>();
        Set<ConnectionRule> _10 = new HashSet<>();
        for (ConnectionRule _11 : diodeIngoingNetConnections) {
          _f.add(_11);
        }
        Set<ConnectionRule> _12 = new HashSet<>();
        Set<ConnectionRule> _13 = new HashSet<>();
        for (ConnectionRule _14 : ingoingNetConnections) {
          _12.add(_14);
        }
        for (ConnectionRule _15 : netConnections) {
          _13.add(_15);
        }
        _12.addAll(_13);
        for (ConnectionRule _16 : _12) {
          _10.add(_16);
        }
        _f.addAll(_10);
        for (ConnectionRule _17 : _f) {
          _cacheParentAccess.add(_17.accessNetworks);
        }
      }
      for (AttackStep attackStep : _cacheParentAccess) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepParents() {
      var tmp = super.getAttackStepParents();
      for (Application _18 : applications) {
        tmp.add(_18.accessNetworkAndConnections);
      }
      for (Application _19 : clientApplications) {
        tmp.add(_19.accessNetworkAndConnections);
      }
      tmp.add(attemptAccess);
      Set<RoutingFirewall> _1a = new HashSet<>();
      Set<RoutingFirewall> _1b = new HashSet<>();
      for (ConnectionRule _1c : diodeIngoingNetConnections) {
        if (_1c.routingFirewalls != null) {
          _1a.add(_1c.routingFirewalls);
        }
      }
      Set<RoutingFirewall> _1d = new HashSet<>();
      Set<RoutingFirewall> _1e = new HashSet<>();
      for (ConnectionRule _1f : ingoingNetConnections) {
        if (_1f.routingFirewalls != null) {
          _1d.add(_1f.routingFirewalls);
        }
      }
      Set<RoutingFirewall> _20 = new HashSet<>();
      Set<RoutingFirewall> _21 = new HashSet<>();
      for (ConnectionRule _22 : outgoingNetConnections) {
        if (_22.routingFirewalls != null) {
          _20.add(_22.routingFirewalls);
        }
      }
      for (ConnectionRule _23 : netConnections) {
        if (_23.routingFirewalls != null) {
          _21.add(_23.routingFirewalls);
        }
      }
      _20.addAll(_21);
      for (RoutingFirewall _24 : _20) {
        _1e.add(_24);
      }
      _1d.addAll(_1e);
      for (RoutingFirewall _25 : _1d) {
        _1b.add(_25);
      }
      _1a.addAll(_1b);
      for (RoutingFirewall _26 : _1a) {
        tmp.add(_26.fullAccess);
      }
      Set<ConnectionRule> _27 = new HashSet<>();
      Set<ConnectionRule> _28 = new HashSet<>();
      for (ConnectionRule _29 : diodeIngoingNetConnections) {
        _27.add(_29);
      }
      Set<ConnectionRule> _2a = new HashSet<>();
      Set<ConnectionRule> _2b = new HashSet<>();
      for (ConnectionRule _2c : ingoingNetConnections) {
        _2a.add(_2c);
      }
      for (ConnectionRule _2d : netConnections) {
        _2b.add(_2d);
      }
      _2a.addAll(_2b);
      for (ConnectionRule _2e : _2a) {
        _28.add(_2e);
      }
      _27.addAll(_28);
      for (ConnectionRule _2f : _27) {
        tmp.add(_2f.accessNetworks);
      }
      return tmp;
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Network.access");
    }
  }

  public class SuccessfulAccess extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenSuccessfulAccess;

    private Set<AttackStep> _cacheParentSuccessfulAccess;

    public SuccessfulAccess(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenSuccessfulAccess == null) {
        _cacheChildrenSuccessfulAccess = new HashSet<>();
        for (var _0 : _allowedApplicationConnectionsNetwork()) {
          _cacheChildrenSuccessfulAccess.add(_0.attemptConnectToApplications);
        }
        for (var _1 : _allowedApplicationConnectionsNetwork()) {
          _cacheChildrenSuccessfulAccess.add(_1.attemptTransmit);
        }
        for (Application _2 : applications) {
          _cacheChildrenSuccessfulAccess.add(_2.networkConnect);
        }
        for (Application _3 : applications) {
          _cacheChildrenSuccessfulAccess.add(_3.networkRequestConnect);
        }
        for (Application _4 : clientApplications) {
          _cacheChildrenSuccessfulAccess.add(_4.networkRespondConnect);
        }
        _cacheChildrenSuccessfulAccess.add(accessNetworkData);
        _cacheChildrenSuccessfulAccess.add(networkForwarding);
        _cacheChildrenSuccessfulAccess.add(denialOfService);
        _cacheChildrenSuccessfulAccess.add(eavesdrop);
        _cacheChildrenSuccessfulAccess.add(bypassEavesdropProtection);
        _cacheChildrenSuccessfulAccess.add(manInTheMiddle);
        _cacheChildrenSuccessfulAccess.add(bypassMitMProtection);
      }
      for (AttackStep attackStep : _cacheChildrenSuccessfulAccess) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepChildren() {
      var tmp = super.getAttackStepChildren();
      for (var _5 : _allowedApplicationConnectionsNetwork()) {
        tmp.add(_5.attemptConnectToApplications);
      }
      for (var _6 : _allowedApplicationConnectionsNetwork()) {
        tmp.add(_6.attemptTransmit);
      }
      for (Application _7 : applications) {
        tmp.add(_7.networkConnect);
      }
      for (Application _8 : applications) {
        tmp.add(_8.networkRequestConnect);
      }
      for (Application _9 : clientApplications) {
        tmp.add(_9.networkRespondConnect);
      }
      tmp.add(accessNetworkData);
      tmp.add(networkForwarding);
      tmp.add(denialOfService);
      tmp.add(eavesdrop);
      tmp.add(bypassEavesdropProtection);
      tmp.add(manInTheMiddle);
      tmp.add(bypassMitMProtection);
      return tmp;
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentSuccessfulAccess == null) {
        _cacheParentSuccessfulAccess = new HashSet<>();
        _cacheParentSuccessfulAccess.add(bypassAccessControl);
        _cacheParentSuccessfulAccess.add(access);
      }
      for (AttackStep attackStep : _cacheParentSuccessfulAccess) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepParents() {
      var tmp = super.getAttackStepParents();
      tmp.add(bypassAccessControl);
      tmp.add(access);
      return tmp;
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Network.successfulAccess");
    }
  }

  public class NetworkForwarding extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenNetworkForwarding;

    private Set<AttackStep> _cacheParentNetworkForwarding;

    public NetworkForwarding(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenNetworkForwarding == null) {
        _cacheChildrenNetworkForwarding = new HashSet<>();
        for (var _0 : _allowedNetworkConnectionsNetwork()) {
          _cacheChildrenNetworkForwarding.add(_0.attemptAccessNetworks);
        }
        for (var _1 : _allowedNetworkConnectionsNetwork()) {
          _cacheChildrenNetworkForwarding.add(_1.attemptConnectToApplications);
        }
        for (var _2 : _allowedNetworkConnectionsNetwork()) {
          _cacheChildrenNetworkForwarding.add(_2.attemptTransmitResponse);
        }
      }
      for (AttackStep attackStep : _cacheChildrenNetworkForwarding) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepChildren() {
      var tmp = super.getAttackStepChildren();
      for (var _3 : _allowedNetworkConnectionsNetwork()) {
        tmp.add(_3.attemptAccessNetworks);
      }
      for (var _4 : _allowedNetworkConnectionsNetwork()) {
        tmp.add(_4.attemptConnectToApplications);
      }
      for (var _5 : _allowedNetworkConnectionsNetwork()) {
        tmp.add(_5.attemptTransmitResponse);
      }
      return tmp;
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentNetworkForwarding == null) {
        _cacheParentNetworkForwarding = new HashSet<>();
        _cacheParentNetworkForwarding.add(successfulAccess);
      }
      for (AttackStep attackStep : _cacheParentNetworkForwarding) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepParents() {
      var tmp = super.getAttackStepParents();
      tmp.add(successfulAccess);
      return tmp;
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Network.networkForwarding");
    }
  }

  public class DenialOfService extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenDenialOfService;

    private Set<AttackStep> _cacheParentDenialOfService;

    public DenialOfService(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenDenialOfService == null) {
        _cacheChildrenDenialOfService = new HashSet<>();
        for (var _0 : _allNetConnectionsNetwork()) {
          _cacheChildrenDenialOfService.add(_0.attemptDenialOfService);
        }
        for (var _1 : _allowedApplicationConnectionsApplicationsNetwork()) {
          _cacheChildrenDenialOfService.add(_1.denyFromConnectionRule);
        }
      }
      for (AttackStep attackStep : _cacheChildrenDenialOfService) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepChildren() {
      var tmp = super.getAttackStepChildren();
      for (var _2 : _allNetConnectionsNetwork()) {
        tmp.add(_2.attemptDenialOfService);
      }
      for (var _3 : _allowedApplicationConnectionsApplicationsNetwork()) {
        tmp.add(_3.denyFromConnectionRule);
      }
      return tmp;
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentDenialOfService == null) {
        _cacheParentDenialOfService = new HashSet<>();
        _cacheParentDenialOfService.add(physicalAccess);
        _cacheParentDenialOfService.add(successfulAccess);
      }
      for (AttackStep attackStep : _cacheParentDenialOfService) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepParents() {
      var tmp = super.getAttackStepParents();
      tmp.add(physicalAccess);
      tmp.add(successfulAccess);
      return tmp;
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Network.denialOfService");
    }
  }

  public class AccessNetworkData extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAccessNetworkData;

    private Set<AttackStep> _cacheParentAccessNetworkData;

    public AccessNetworkData(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAccessNetworkData == null) {
        _cacheChildrenAccessNetworkData = new HashSet<>();
        for (Data _0 : transitData) {
          _cacheChildrenAccessNetworkData.add(_0.attemptAccess);
        }
        for (Data _1 : transitData) {
          _cacheChildrenAccessNetworkData.add(_1.attemptEavesdrop);
        }
        for (Data _2 : transitData) {
          _cacheChildrenAccessNetworkData.add(_2.attemptManInTheMiddle);
        }
      }
      for (AttackStep attackStep : _cacheChildrenAccessNetworkData) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepChildren() {
      var tmp = super.getAttackStepChildren();
      for (Data _3 : transitData) {
        tmp.add(_3.attemptAccess);
      }
      for (Data _4 : transitData) {
        tmp.add(_4.attemptEavesdrop);
      }
      for (Data _5 : transitData) {
        tmp.add(_5.attemptManInTheMiddle);
      }
      return tmp;
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAccessNetworkData == null) {
        _cacheParentAccessNetworkData = new HashSet<>();
        _cacheParentAccessNetworkData.add(successfulAccess);
      }
      for (AttackStep attackStep : _cacheParentAccessNetworkData) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepParents() {
      var tmp = super.getAttackStepParents();
      tmp.add(successfulAccess);
      return tmp;
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Network.accessNetworkData");
    }
  }

  public class EavesdropDefense extends Defense {
    public EavesdropDefense(String name) {
      this(name, false);
    }

    public EavesdropDefense(String name, Boolean isEnabled) {
      super(name);
      defaultValue = isEnabled;
      disable = new Disable(name);
    }

    public class Disable extends AttackStepMin {
      private Set<AttackStep> _cacheChildrenEavesdropDefense;

      public Disable(String name) {
        super(name);
      }

      @Override
      public void updateChildren(Set<AttackStep> attackSteps) {
        if (_cacheChildrenEavesdropDefense == null) {
          _cacheChildrenEavesdropDefense = new HashSet<>();
          _cacheChildrenEavesdropDefense.add(eavesdrop);
          _cacheChildrenEavesdropDefense.add(eavesdropAfterPhysicalAccess);
        }
        for (AttackStep attackStep : _cacheChildrenEavesdropDefense) {
          attackStep.updateTtc(this, ttc, attackSteps);
        }
      }

      @Override
      public Set<AttackStep> getAttackStepChildren() {
        var tmp = super.getAttackStepChildren();
        tmp.add(eavesdrop);
        tmp.add(eavesdropAfterPhysicalAccess);
        return tmp;
      }

      @Override
      public String fullName() {
        return "Network.eavesdropDefense";
      }
    }
  }

  public class ManInTheMiddleDefense extends Defense {
    public ManInTheMiddleDefense(String name) {
      this(name, false);
    }

    public ManInTheMiddleDefense(String name, Boolean isEnabled) {
      super(name);
      defaultValue = isEnabled;
      disable = new Disable(name);
    }

    public class Disable extends AttackStepMin {
      private Set<AttackStep> _cacheChildrenManInTheMiddleDefense;

      public Disable(String name) {
        super(name);
      }

      @Override
      public void updateChildren(Set<AttackStep> attackSteps) {
        if (_cacheChildrenManInTheMiddleDefense == null) {
          _cacheChildrenManInTheMiddleDefense = new HashSet<>();
          _cacheChildrenManInTheMiddleDefense.add(manInTheMiddle);
        }
        for (AttackStep attackStep : _cacheChildrenManInTheMiddleDefense) {
          attackStep.updateTtc(this, ttc, attackSteps);
        }
      }

      @Override
      public Set<AttackStep> getAttackStepChildren() {
        var tmp = super.getAttackStepChildren();
        tmp.add(manInTheMiddle);
        return tmp;
      }

      @Override
      public String fullName() {
        return "Network.manInTheMiddleDefense";
      }
    }
  }

  public class Eavesdrop extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenEavesdrop;

    private Set<AttackStep> _cacheParentEavesdrop;

    public Eavesdrop(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenEavesdrop == null) {
        _cacheChildrenEavesdrop = new HashSet<>();
        for (var _0 : _allowedApplicationConnectionsNetwork()) {
          _cacheChildrenEavesdrop.add(_0.attemptEavesdropOnDataInTransit);
        }
        for (var _1 : _allNetApplicationsNetwork()) {
          for (Data _2 : _1.transitData) {
            _cacheChildrenEavesdrop.add(_2.attemptEavesdrop);
          }
        }
      }
      for (AttackStep attackStep : _cacheChildrenEavesdrop) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepChildren() {
      var tmp = super.getAttackStepChildren();
      for (var _3 : _allowedApplicationConnectionsNetwork()) {
        tmp.add(_3.attemptEavesdropOnDataInTransit);
      }
      for (var _4 : _allNetApplicationsNetwork()) {
        for (Data _5 : _4.transitData) {
          tmp.add(_5.attemptEavesdrop);
        }
      }
      return tmp;
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentEavesdrop == null) {
        _cacheParentEavesdrop = new HashSet<>();
        _cacheParentEavesdrop.add(successfulAccess);
        _cacheParentEavesdrop.add(eavesdropDefense.disable);
      }
      for (AttackStep attackStep : _cacheParentEavesdrop) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepParents() {
      var tmp = super.getAttackStepParents();
      tmp.add(successfulAccess);
      tmp.add(eavesdropDefense.disable);
      return tmp;
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Network.eavesdrop");
    }
  }

  public class BypassEavesdropProtection extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenBypassEavesdropProtection;

    private Set<AttackStep> _cacheParentBypassEavesdropProtection;

    public BypassEavesdropProtection(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenBypassEavesdropProtection == null) {
        _cacheChildrenBypassEavesdropProtection = new HashSet<>();
        for (var _0 : _allowedApplicationConnectionsNetwork()) {
          _cacheChildrenBypassEavesdropProtection.add(_0.attemptEavesdropOnDataInTransit);
        }
        for (var _1 : _allNetApplicationsNetwork()) {
          for (Data _2 : _1.transitData) {
            _cacheChildrenBypassEavesdropProtection.add(_2.attemptEavesdrop);
          }
        }
      }
      for (AttackStep attackStep : _cacheChildrenBypassEavesdropProtection) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepChildren() {
      var tmp = super.getAttackStepChildren();
      for (var _3 : _allowedApplicationConnectionsNetwork()) {
        tmp.add(_3.attemptEavesdropOnDataInTransit);
      }
      for (var _4 : _allNetApplicationsNetwork()) {
        for (Data _5 : _4.transitData) {
          tmp.add(_5.attemptEavesdrop);
        }
      }
      return tmp;
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentBypassEavesdropProtection == null) {
        _cacheParentBypassEavesdropProtection = new HashSet<>();
        _cacheParentBypassEavesdropProtection.add(successfulAccess);
      }
      for (AttackStep attackStep : _cacheParentBypassEavesdropProtection) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepParents() {
      var tmp = super.getAttackStepParents();
      tmp.add(successfulAccess);
      return tmp;
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Network.bypassEavesdropProtection");
    }
  }

  public class ManInTheMiddle extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenManInTheMiddle;

    private Set<AttackStep> _cacheParentManInTheMiddle;

    public ManInTheMiddle(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenManInTheMiddle == null) {
        _cacheChildrenManInTheMiddle = new HashSet<>();
        for (var _0 : _allowedApplicationConnectionsNetwork()) {
          _cacheChildrenManInTheMiddle.add(_0.attemptManInTheMiddleOnDataInTransit);
        }
        for (var _1 : _allNetApplicationsNetwork()) {
          for (Data _2 : _1.transitData) {
            _cacheChildrenManInTheMiddle.add(_2.attemptManInTheMiddle);
          }
        }
      }
      for (AttackStep attackStep : _cacheChildrenManInTheMiddle) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepChildren() {
      var tmp = super.getAttackStepChildren();
      for (var _3 : _allowedApplicationConnectionsNetwork()) {
        tmp.add(_3.attemptManInTheMiddleOnDataInTransit);
      }
      for (var _4 : _allNetApplicationsNetwork()) {
        for (Data _5 : _4.transitData) {
          tmp.add(_5.attemptManInTheMiddle);
        }
      }
      return tmp;
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentManInTheMiddle == null) {
        _cacheParentManInTheMiddle = new HashSet<>();
        _cacheParentManInTheMiddle.add(successfulAccess);
        _cacheParentManInTheMiddle.add(manInTheMiddleDefense.disable);
      }
      for (AttackStep attackStep : _cacheParentManInTheMiddle) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepParents() {
      var tmp = super.getAttackStepParents();
      tmp.add(successfulAccess);
      tmp.add(manInTheMiddleDefense.disable);
      return tmp;
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Network.manInTheMiddle");
    }
  }

  public class BypassMitMProtection extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenBypassMitMProtection;

    private Set<AttackStep> _cacheParentBypassMitMProtection;

    public BypassMitMProtection(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenBypassMitMProtection == null) {
        _cacheChildrenBypassMitMProtection = new HashSet<>();
        for (var _0 : _allowedApplicationConnectionsNetwork()) {
          _cacheChildrenBypassMitMProtection.add(_0.attemptManInTheMiddleOnDataInTransit);
        }
        for (var _1 : _allNetApplicationsNetwork()) {
          for (Data _2 : _1.transitData) {
            _cacheChildrenBypassMitMProtection.add(_2.attemptManInTheMiddle);
          }
        }
      }
      for (AttackStep attackStep : _cacheChildrenBypassMitMProtection) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepChildren() {
      var tmp = super.getAttackStepChildren();
      for (var _3 : _allowedApplicationConnectionsNetwork()) {
        tmp.add(_3.attemptManInTheMiddleOnDataInTransit);
      }
      for (var _4 : _allNetApplicationsNetwork()) {
        for (Data _5 : _4.transitData) {
          tmp.add(_5.attemptManInTheMiddle);
        }
      }
      return tmp;
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentBypassMitMProtection == null) {
        _cacheParentBypassMitMProtection = new HashSet<>();
        _cacheParentBypassMitMProtection.add(successfulAccess);
      }
      for (AttackStep attackStep : _cacheParentBypassMitMProtection) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepParents() {
      var tmp = super.getAttackStepParents();
      tmp.add(successfulAccess);
      return tmp;
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Network.bypassMitMProtection");
    }
  }

  public class EavesdropAfterPhysicalAccess extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenEavesdropAfterPhysicalAccess;

    private Set<AttackStep> _cacheParentEavesdropAfterPhysicalAccess;

    public EavesdropAfterPhysicalAccess(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenEavesdropAfterPhysicalAccess == null) {
        _cacheChildrenEavesdropAfterPhysicalAccess = new HashSet<>();
        for (var _0 : _allowedApplicationConnectionsNetwork()) {
          _cacheChildrenEavesdropAfterPhysicalAccess.add(_0.attemptEavesdropOnDataInTransit);
        }
        for (var _1 : _allNetApplicationsNetwork()) {
          for (Data _2 : _1.transitData) {
            _cacheChildrenEavesdropAfterPhysicalAccess.add(_2.attemptEavesdrop);
          }
        }
        for (Data _3 : transitData) {
          _cacheChildrenEavesdropAfterPhysicalAccess.add(_3.attemptEavesdrop);
        }
      }
      for (AttackStep attackStep : _cacheChildrenEavesdropAfterPhysicalAccess) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepChildren() {
      var tmp = super.getAttackStepChildren();
      for (var _4 : _allowedApplicationConnectionsNetwork()) {
        tmp.add(_4.attemptEavesdropOnDataInTransit);
      }
      for (var _5 : _allNetApplicationsNetwork()) {
        for (Data _6 : _5.transitData) {
          tmp.add(_6.attemptEavesdrop);
        }
      }
      for (Data _7 : transitData) {
        tmp.add(_7.attemptEavesdrop);
      }
      return tmp;
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentEavesdropAfterPhysicalAccess == null) {
        _cacheParentEavesdropAfterPhysicalAccess = new HashSet<>();
        _cacheParentEavesdropAfterPhysicalAccess.add(physicalAccess);
        _cacheParentEavesdropAfterPhysicalAccess.add(networkAccessControl.disable);
        _cacheParentEavesdropAfterPhysicalAccess.add(eavesdropDefense.disable);
      }
      for (AttackStep attackStep : _cacheParentEavesdropAfterPhysicalAccess) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepParents() {
      var tmp = super.getAttackStepParents();
      tmp.add(physicalAccess);
      tmp.add(networkAccessControl.disable);
      tmp.add(eavesdropDefense.disable);
      return tmp;
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Network.eavesdropAfterPhysicalAccess");
    }
  }
}
