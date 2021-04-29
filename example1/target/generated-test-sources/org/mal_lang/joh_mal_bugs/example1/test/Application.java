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

public class Application extends Object {
  public Disabled disabled;

  public LocalConnect localConnect;

  public UseVulnerability useVulnerability;

  public AttemptLocalConnectVuln attemptLocalConnectVuln;

  public AttemptNetworkRequestRespondConnectVuln attemptNetworkRequestRespondConnectVuln;

  public AttemptLocalLowPrivVuln attemptLocalLowPrivVuln;

  public AttemptLocalHighPrivVuln attemptLocalHighPrivVuln;

  public NetworkConnect networkConnect;

  public AccessNetworkAndConnections accessNetworkAndConnections;

  public NetworkRequestConnect networkRequestConnect;

  public NetworkRespondConnect networkRespondConnect;

  public SpecificAccessFromLocalConnection specificAccessFromLocalConnection;

  public SpecificAccessFromNetworkConnection specificAccessFromNetworkConnection;

  public SpecificAccess specificAccess;

  public AttemptLocalConnectVulnOnHost attemptLocalConnectVulnOnHost;

  public Authenticate authenticate;

  public SpecificAccessAuthenticate specificAccessAuthenticate;

  public LocalAccess localAccess;

  public NetworkAccess networkAccess;

  public FullAccess fullAccess;

  public AttemptFullAccessAfterSoftProdVulnerability attemptFullAccessAfterSoftProdVulnerability;

  public AttemptReadAfterSoftProdVulnerability attemptReadAfterSoftProdVulnerability;

  public AttemptModifyAfterSoftProdVulnerability attemptModifyAfterSoftProdVulnerability;

  public AttemptDenyAfterSoftProdVulnerability attemptDenyAfterSoftProdVulnerability;

  public SoftwareCheck softwareCheck;

  public FullAccessAfterSoftProdVulnerability fullAccessAfterSoftProdVulnerability;

  public ReadAfterSoftProdVulnerability readAfterSoftProdVulnerability;

  public ModifyAfterSoftProdVulnerability modifyAfterSoftProdVulnerability;

  public DenyAfterSoftProdVulnerability denyAfterSoftProdVulnerability;

  public AttemptApplicationRespondConnectThroughData attemptApplicationRespondConnectThroughData;

  public CodeExecutionAfterVulnerability codeExecutionAfterVulnerability;

  public Read read;

  public Modify modify;

  public DenyFromConnectionRule denyFromConnectionRule;

  private Set<ManuallyModeledVulnerability> _cacheallManualVulnerabilitiesApplication;

  private Set<UnknownVulnerability> _cacheallUnknownVulnerabilitiesApplication;

  private Set<Vulnerability> _cacheallAutomaticVulnerabilitiesApplication;

  private Set<ConnectionRule> _cacheclientApplicationConnectionsApplication;

  private Set<ConnectionRule> _cacheserverApplicationConnectionsApplication;

  private Set<ConnectionRule> _cacheallApplicationConnectionsApplication;

  private Set<Network> _cachereverseallowedApplicationConnectionsApplicationsNetwork;

  private Set<Network> _cachereverseallNetApplicationsNetwork;

  private Set<ConnectionRule> _cachereverseserverApplicationsConnectionRule;

  private Set<ConnectionRule> _cachereverseclientApplicationsConnectionRule;

  private Set<ConnectionRule> _cachereverseallApplicationsConnectionRule;

  public Set<Vulnerability> vulnerabilities = new HashSet<>();

  public System hostSystem = null;

  public Set<Application> appExecutedApps = new HashSet<>();

  public Application hostApp = null;

  public SoftwareProduct appSoftProduct = null;

  public Set<RoutingFirewall> managedRoutingFw = new HashSet<>();

  public Set<Network> networks = new HashSet<>();

  public Set<Network> clientAccessNetworks = new HashSet<>();

  public Set<ConnectionRule> appConnections = new HashSet<>();

  public Set<ConnectionRule> ingoingAppConnections = new HashSet<>();

  public Set<ConnectionRule> outgoingAppConnections = new HashSet<>();

  public Set<Data> containedData = new HashSet<>();

  public Set<Data> transitData = new HashSet<>();

  public Set<Identity> executionPrivIds = new HashSet<>();

  public Set<Identity> highPrivAppIds = new HashSet<>();

  public Set<Identity> lowPrivAppIds = new HashSet<>();

  public Set<Group> executionPrivGroups = new HashSet<>();

  public Set<Group> highPrivAppGroups = new HashSet<>();

  public Set<Group> lowPrivAppGroups = new HashSet<>();

  public Set<Privileges> executionPrivAppPriv = new HashSet<>();

  public Set<Privileges> highPrivAppPriv = new HashSet<>();

  public Set<Privileges> lowPrivAppPriv = new HashSet<>();

  public Application(String name, boolean isDisabledEnabled) {
    super(name);
    assetClassName = "Application";
    if (disabled != null) {
      AttackStep.allAttackSteps.remove(disabled.disable);
    }
    Defense.allDefenses.remove(disabled);
    disabled = new Disabled(name, isDisabledEnabled);
    AttackStep.allAttackSteps.remove(localConnect);
    localConnect = new LocalConnect(name);
    AttackStep.allAttackSteps.remove(attemptUseVulnerability);
    attemptUseVulnerability = new AttemptUseVulnerability(name);
    AttackStep.allAttackSteps.remove(useVulnerability);
    useVulnerability = new UseVulnerability(name);
    AttackStep.allAttackSteps.remove(attemptLocalConnectVuln);
    attemptLocalConnectVuln = new AttemptLocalConnectVuln(name);
    AttackStep.allAttackSteps.remove(attemptNetworkRequestRespondConnectVuln);
    attemptNetworkRequestRespondConnectVuln = new AttemptNetworkRequestRespondConnectVuln(name);
    AttackStep.allAttackSteps.remove(attemptLocalLowPrivVuln);
    attemptLocalLowPrivVuln = new AttemptLocalLowPrivVuln(name);
    AttackStep.allAttackSteps.remove(attemptLocalHighPrivVuln);
    attemptLocalHighPrivVuln = new AttemptLocalHighPrivVuln(name);
    AttackStep.allAttackSteps.remove(networkConnect);
    networkConnect = new NetworkConnect(name);
    AttackStep.allAttackSteps.remove(accessNetworkAndConnections);
    accessNetworkAndConnections = new AccessNetworkAndConnections(name);
    AttackStep.allAttackSteps.remove(networkRequestConnect);
    networkRequestConnect = new NetworkRequestConnect(name);
    AttackStep.allAttackSteps.remove(networkRespondConnect);
    networkRespondConnect = new NetworkRespondConnect(name);
    AttackStep.allAttackSteps.remove(specificAccessFromLocalConnection);
    specificAccessFromLocalConnection = new SpecificAccessFromLocalConnection(name);
    AttackStep.allAttackSteps.remove(specificAccessFromNetworkConnection);
    specificAccessFromNetworkConnection = new SpecificAccessFromNetworkConnection(name);
    AttackStep.allAttackSteps.remove(specificAccess);
    specificAccess = new SpecificAccess(name);
    AttackStep.allAttackSteps.remove(attemptLocalConnectVulnOnHost);
    attemptLocalConnectVulnOnHost = new AttemptLocalConnectVulnOnHost(name);
    AttackStep.allAttackSteps.remove(authenticate);
    authenticate = new Authenticate(name);
    AttackStep.allAttackSteps.remove(specificAccessAuthenticate);
    specificAccessAuthenticate = new SpecificAccessAuthenticate(name);
    AttackStep.allAttackSteps.remove(localAccess);
    localAccess = new LocalAccess(name);
    AttackStep.allAttackSteps.remove(networkAccess);
    networkAccess = new NetworkAccess(name);
    AttackStep.allAttackSteps.remove(fullAccess);
    fullAccess = new FullAccess(name);
    AttackStep.allAttackSteps.remove(attemptFullAccessAfterSoftProdVulnerability);
    attemptFullAccessAfterSoftProdVulnerability = new AttemptFullAccessAfterSoftProdVulnerability(name);
    AttackStep.allAttackSteps.remove(attemptReadAfterSoftProdVulnerability);
    attemptReadAfterSoftProdVulnerability = new AttemptReadAfterSoftProdVulnerability(name);
    AttackStep.allAttackSteps.remove(attemptModifyAfterSoftProdVulnerability);
    attemptModifyAfterSoftProdVulnerability = new AttemptModifyAfterSoftProdVulnerability(name);
    AttackStep.allAttackSteps.remove(attemptDenyAfterSoftProdVulnerability);
    attemptDenyAfterSoftProdVulnerability = new AttemptDenyAfterSoftProdVulnerability(name);
    if (softwareCheck != null) {
      AttackStep.allAttackSteps.remove(softwareCheck.disable);
    }
    Defense.allDefenses.remove(softwareCheck);
    softwareCheck = new SoftwareCheck(name);
    AttackStep.allAttackSteps.remove(fullAccessAfterSoftProdVulnerability);
    fullAccessAfterSoftProdVulnerability = new FullAccessAfterSoftProdVulnerability(name);
    AttackStep.allAttackSteps.remove(readAfterSoftProdVulnerability);
    readAfterSoftProdVulnerability = new ReadAfterSoftProdVulnerability(name);
    AttackStep.allAttackSteps.remove(modifyAfterSoftProdVulnerability);
    modifyAfterSoftProdVulnerability = new ModifyAfterSoftProdVulnerability(name);
    AttackStep.allAttackSteps.remove(denyAfterSoftProdVulnerability);
    denyAfterSoftProdVulnerability = new DenyAfterSoftProdVulnerability(name);
    AttackStep.allAttackSteps.remove(attemptApplicationRespondConnectThroughData);
    attemptApplicationRespondConnectThroughData = new AttemptApplicationRespondConnectThroughData(name);
    AttackStep.allAttackSteps.remove(codeExecutionAfterVulnerability);
    codeExecutionAfterVulnerability = new CodeExecutionAfterVulnerability(name);
    AttackStep.allAttackSteps.remove(read);
    read = new Read(name);
    AttackStep.allAttackSteps.remove(modify);
    modify = new Modify(name);
    AttackStep.allAttackSteps.remove(deny);
    deny = new Deny(name);
    AttackStep.allAttackSteps.remove(denyFromConnectionRule);
    denyFromConnectionRule = new DenyFromConnectionRule(name);
  }

  public Application(String name) {
    super(name);
    assetClassName = "Application";
    if (disabled != null) {
      AttackStep.allAttackSteps.remove(disabled.disable);
    }
    Defense.allDefenses.remove(disabled);
    disabled = new Disabled(name, false);
    AttackStep.allAttackSteps.remove(localConnect);
    localConnect = new LocalConnect(name);
    AttackStep.allAttackSteps.remove(attemptUseVulnerability);
    attemptUseVulnerability = new AttemptUseVulnerability(name);
    AttackStep.allAttackSteps.remove(useVulnerability);
    useVulnerability = new UseVulnerability(name);
    AttackStep.allAttackSteps.remove(attemptLocalConnectVuln);
    attemptLocalConnectVuln = new AttemptLocalConnectVuln(name);
    AttackStep.allAttackSteps.remove(attemptNetworkRequestRespondConnectVuln);
    attemptNetworkRequestRespondConnectVuln = new AttemptNetworkRequestRespondConnectVuln(name);
    AttackStep.allAttackSteps.remove(attemptLocalLowPrivVuln);
    attemptLocalLowPrivVuln = new AttemptLocalLowPrivVuln(name);
    AttackStep.allAttackSteps.remove(attemptLocalHighPrivVuln);
    attemptLocalHighPrivVuln = new AttemptLocalHighPrivVuln(name);
    AttackStep.allAttackSteps.remove(networkConnect);
    networkConnect = new NetworkConnect(name);
    AttackStep.allAttackSteps.remove(accessNetworkAndConnections);
    accessNetworkAndConnections = new AccessNetworkAndConnections(name);
    AttackStep.allAttackSteps.remove(networkRequestConnect);
    networkRequestConnect = new NetworkRequestConnect(name);
    AttackStep.allAttackSteps.remove(networkRespondConnect);
    networkRespondConnect = new NetworkRespondConnect(name);
    AttackStep.allAttackSteps.remove(specificAccessFromLocalConnection);
    specificAccessFromLocalConnection = new SpecificAccessFromLocalConnection(name);
    AttackStep.allAttackSteps.remove(specificAccessFromNetworkConnection);
    specificAccessFromNetworkConnection = new SpecificAccessFromNetworkConnection(name);
    AttackStep.allAttackSteps.remove(specificAccess);
    specificAccess = new SpecificAccess(name);
    AttackStep.allAttackSteps.remove(attemptLocalConnectVulnOnHost);
    attemptLocalConnectVulnOnHost = new AttemptLocalConnectVulnOnHost(name);
    AttackStep.allAttackSteps.remove(authenticate);
    authenticate = new Authenticate(name);
    AttackStep.allAttackSteps.remove(specificAccessAuthenticate);
    specificAccessAuthenticate = new SpecificAccessAuthenticate(name);
    AttackStep.allAttackSteps.remove(localAccess);
    localAccess = new LocalAccess(name);
    AttackStep.allAttackSteps.remove(networkAccess);
    networkAccess = new NetworkAccess(name);
    AttackStep.allAttackSteps.remove(fullAccess);
    fullAccess = new FullAccess(name);
    AttackStep.allAttackSteps.remove(attemptFullAccessAfterSoftProdVulnerability);
    attemptFullAccessAfterSoftProdVulnerability = new AttemptFullAccessAfterSoftProdVulnerability(name);
    AttackStep.allAttackSteps.remove(attemptReadAfterSoftProdVulnerability);
    attemptReadAfterSoftProdVulnerability = new AttemptReadAfterSoftProdVulnerability(name);
    AttackStep.allAttackSteps.remove(attemptModifyAfterSoftProdVulnerability);
    attemptModifyAfterSoftProdVulnerability = new AttemptModifyAfterSoftProdVulnerability(name);
    AttackStep.allAttackSteps.remove(attemptDenyAfterSoftProdVulnerability);
    attemptDenyAfterSoftProdVulnerability = new AttemptDenyAfterSoftProdVulnerability(name);
    if (softwareCheck != null) {
      AttackStep.allAttackSteps.remove(softwareCheck.disable);
    }
    Defense.allDefenses.remove(softwareCheck);
    softwareCheck = new SoftwareCheck(name);
    AttackStep.allAttackSteps.remove(fullAccessAfterSoftProdVulnerability);
    fullAccessAfterSoftProdVulnerability = new FullAccessAfterSoftProdVulnerability(name);
    AttackStep.allAttackSteps.remove(readAfterSoftProdVulnerability);
    readAfterSoftProdVulnerability = new ReadAfterSoftProdVulnerability(name);
    AttackStep.allAttackSteps.remove(modifyAfterSoftProdVulnerability);
    modifyAfterSoftProdVulnerability = new ModifyAfterSoftProdVulnerability(name);
    AttackStep.allAttackSteps.remove(denyAfterSoftProdVulnerability);
    denyAfterSoftProdVulnerability = new DenyAfterSoftProdVulnerability(name);
    AttackStep.allAttackSteps.remove(attemptApplicationRespondConnectThroughData);
    attemptApplicationRespondConnectThroughData = new AttemptApplicationRespondConnectThroughData(name);
    AttackStep.allAttackSteps.remove(codeExecutionAfterVulnerability);
    codeExecutionAfterVulnerability = new CodeExecutionAfterVulnerability(name);
    AttackStep.allAttackSteps.remove(read);
    read = new Read(name);
    AttackStep.allAttackSteps.remove(modify);
    modify = new Modify(name);
    AttackStep.allAttackSteps.remove(deny);
    deny = new Deny(name);
    AttackStep.allAttackSteps.remove(denyFromConnectionRule);
    denyFromConnectionRule = new DenyFromConnectionRule(name);
  }

  public Application(boolean isDisabledEnabled) {
    this("Anonymous", isDisabledEnabled);
  }

  public Application() {
    this("Anonymous");
  }

  protected Set<ManuallyModeledVulnerability> _allManualVulnerabilitiesApplication() {
    if (_cacheallManualVulnerabilitiesApplication == null) {
      _cacheallManualVulnerabilitiesApplication = new HashSet<>();
      Set<ManuallyModeledVulnerability> _4 = new HashSet<>();
      Set<ManuallyModeledVulnerability> _5 = new HashSet<>();
      for (Vulnerability _6 : vulnerabilities) {
        if (_6 instanceof ManuallyModeledVulnerability) {
          _4.add(((org.mal_lang.joh_mal_bugs.example1.test.ManuallyModeledVulnerability) _6));
        }
      }
      if (appSoftProduct != null) {
        for (Vulnerability _7 : appSoftProduct.softProductVulnerabilities) {
          if (_7 instanceof ManuallyModeledVulnerability) {
            _5.add(((org.mal_lang.joh_mal_bugs.example1.test.ManuallyModeledVulnerability) _7));
          }
        }
      }
      _4.addAll(_5);
      for (ManuallyModeledVulnerability _8 : _4) {
        _cacheallManualVulnerabilitiesApplication.add(_8);
      }
    }
    return _cacheallManualVulnerabilitiesApplication;
  }

  protected Set<UnknownVulnerability> _allUnknownVulnerabilitiesApplication() {
    if (_cacheallUnknownVulnerabilitiesApplication == null) {
      _cacheallUnknownVulnerabilitiesApplication = new HashSet<>();
      Set<UnknownVulnerability> _9 = new HashSet<>();
      Set<UnknownVulnerability> _a = new HashSet<>();
      for (Vulnerability _b : vulnerabilities) {
        if (_b instanceof UnknownVulnerability) {
          _9.add(((org.mal_lang.joh_mal_bugs.example1.test.UnknownVulnerability) _b));
        }
      }
      if (appSoftProduct != null) {
        for (Vulnerability _c : appSoftProduct.softProductVulnerabilities) {
          if (_c instanceof UnknownVulnerability) {
            _a.add(((org.mal_lang.joh_mal_bugs.example1.test.UnknownVulnerability) _c));
          }
        }
      }
      _9.addAll(_a);
      for (UnknownVulnerability _d : _9) {
        _cacheallUnknownVulnerabilitiesApplication.add(_d);
      }
    }
    return _cacheallUnknownVulnerabilitiesApplication;
  }

  protected Set<Vulnerability> _allAutomaticVulnerabilitiesApplication() {
    if (_cacheallAutomaticVulnerabilitiesApplication == null) {
      _cacheallAutomaticVulnerabilitiesApplication = new HashSet<>();
      Set<Vulnerability> _e = new HashSet<>();
      Set<Vulnerability> _f = new HashSet<>();
      Set<Vulnerability> _10 = new HashSet<>();
      Set<Vulnerability> _11 = new HashSet<>();
      Set<Vulnerability> _12 = new HashSet<>();
      Set<Vulnerability> _13 = new HashSet<>();
      for (Vulnerability _14 : vulnerabilities) {
        _12.add(_14);
      }
      if (appSoftProduct != null) {
        for (Vulnerability _15 : appSoftProduct.softProductVulnerabilities) {
          _13.add(_15);
        }
      }
      _12.addAll(_13);
      for (Vulnerability _16 : _12) {
        _10.add(_16);
      }
      for (var _17 : _allManualVulnerabilitiesApplication()) {
        _11.add(_17);
      }
      _10.removeAll(_11);
      for (Vulnerability _18 : _10) {
        _e.add(_18);
      }
      for (var _19 : _allUnknownVulnerabilitiesApplication()) {
        _f.add(_19);
      }
      _e.removeAll(_f);
      for (Vulnerability _1a : _e) {
        _cacheallAutomaticVulnerabilitiesApplication.add(_1a);
      }
    }
    return _cacheallAutomaticVulnerabilitiesApplication;
  }

  protected Set<ConnectionRule> _clientApplicationConnectionsApplication() {
    if (_cacheclientApplicationConnectionsApplication == null) {
      _cacheclientApplicationConnectionsApplication = new HashSet<>();
      Set<ConnectionRule> _1b = new HashSet<>();
      Set<ConnectionRule> _1c = new HashSet<>();
      for (ConnectionRule _1d : appConnections) {
        _1b.add(_1d);
      }
      for (ConnectionRule _1e : outgoingAppConnections) {
        _1c.add(_1e);
      }
      _1b.addAll(_1c);
      for (ConnectionRule _1f : _1b) {
        _cacheclientApplicationConnectionsApplication.add(_1f);
      }
    }
    return _cacheclientApplicationConnectionsApplication;
  }

  protected Set<ConnectionRule> _serverApplicationConnectionsApplication() {
    if (_cacheserverApplicationConnectionsApplication == null) {
      _cacheserverApplicationConnectionsApplication = new HashSet<>();
      Set<ConnectionRule> _20 = new HashSet<>();
      Set<ConnectionRule> _21 = new HashSet<>();
      for (ConnectionRule _22 : appConnections) {
        _20.add(_22);
      }
      for (ConnectionRule _23 : ingoingAppConnections) {
        _21.add(_23);
      }
      _20.addAll(_21);
      for (ConnectionRule _24 : _20) {
        _cacheserverApplicationConnectionsApplication.add(_24);
      }
    }
    return _cacheserverApplicationConnectionsApplication;
  }

  protected Set<ConnectionRule> _allApplicationConnectionsApplication() {
    if (_cacheallApplicationConnectionsApplication == null) {
      _cacheallApplicationConnectionsApplication = new HashSet<>();
      Set<ConnectionRule> _25 = new HashSet<>();
      Set<ConnectionRule> _26 = new HashSet<>();
      Set<ConnectionRule> _27 = new HashSet<>();
      Set<ConnectionRule> _28 = new HashSet<>();
      for (ConnectionRule _29 : appConnections) {
        _27.add(_29);
      }
      for (ConnectionRule _2a : outgoingAppConnections) {
        _28.add(_2a);
      }
      _27.addAll(_28);
      for (ConnectionRule _2b : _27) {
        _25.add(_2b);
      }
      for (ConnectionRule _2c : ingoingAppConnections) {
        _26.add(_2c);
      }
      _25.addAll(_26);
      for (ConnectionRule _2d : _25) {
        _cacheallApplicationConnectionsApplication.add(_2d);
      }
    }
    return _cacheallApplicationConnectionsApplication;
  }

  protected Set<Network> _reverseallowedApplicationConnectionsApplicationsNetwork() {
    if (_cachereverseallowedApplicationConnectionsApplicationsNetwork == null) {
      _cachereverseallowedApplicationConnectionsApplicationsNetwork = new HashSet<>();
      Set<Network> _2e = new HashSet<>();
      Set<Network> _2f = new HashSet<>();
      for (Network _30 : networks) {
        _2e.add(_30);
      }
      Set<Network> _31 = new HashSet<>();
      Set<Network> _32 = new HashSet<>();
      for (ConnectionRule _33 : appConnections) {
        for (Network _34 : _33.outNetworks) {
          _31.add(_34);
        }
      }
      for (ConnectionRule _35 : appConnections) {
        for (Network _36 : _35.networks) {
          _32.add(_36);
        }
      }
      _31.addAll(_32);
      for (Network _37 : _31) {
        _2f.add(_37);
      }
      _2e.addAll(_2f);
      for (Network _38 : _2e) {
        _cachereverseallowedApplicationConnectionsApplicationsNetwork.add(_38);
      }
    }
    return _cachereverseallowedApplicationConnectionsApplicationsNetwork;
  }

  protected Set<Network> _reverseallNetApplicationsNetwork() {
    if (_cachereverseallNetApplicationsNetwork == null) {
      _cachereverseallNetApplicationsNetwork = new HashSet<>();
      Set<Network> _39 = new HashSet<>();
      Set<Network> _3a = new HashSet<>();
      for (Network _3b : networks) {
        _39.add(_3b);
      }
      for (Network _3c : clientAccessNetworks) {
        _3a.add(_3c);
      }
      _39.addAll(_3a);
      for (Network _3d : _39) {
        _cachereverseallNetApplicationsNetwork.add(_3d);
      }
    }
    return _cachereverseallNetApplicationsNetwork;
  }

  protected Set<ConnectionRule> _reverseserverApplicationsConnectionRule() {
    if (_cachereverseserverApplicationsConnectionRule == null) {
      _cachereverseserverApplicationsConnectionRule = new HashSet<>();
      Set<ConnectionRule> _3e = new HashSet<>();
      Set<ConnectionRule> _3f = new HashSet<>();
      for (ConnectionRule _40 : ingoingAppConnections) {
        _3e.add(_40);
      }
      for (ConnectionRule _41 : appConnections) {
        _3f.add(_41);
      }
      _3e.addAll(_3f);
      for (ConnectionRule _42 : _3e) {
        _cachereverseserverApplicationsConnectionRule.add(_42);
      }
    }
    return _cachereverseserverApplicationsConnectionRule;
  }

  protected Set<ConnectionRule> _reverseclientApplicationsConnectionRule() {
    if (_cachereverseclientApplicationsConnectionRule == null) {
      _cachereverseclientApplicationsConnectionRule = new HashSet<>();
      Set<ConnectionRule> _43 = new HashSet<>();
      Set<ConnectionRule> _44 = new HashSet<>();
      for (ConnectionRule _45 : outgoingAppConnections) {
        _43.add(_45);
      }
      for (ConnectionRule _46 : appConnections) {
        _44.add(_46);
      }
      _43.addAll(_44);
      for (ConnectionRule _47 : _43) {
        _cachereverseclientApplicationsConnectionRule.add(_47);
      }
    }
    return _cachereverseclientApplicationsConnectionRule;
  }

  protected Set<ConnectionRule> _reverseallApplicationsConnectionRule() {
    if (_cachereverseallApplicationsConnectionRule == null) {
      _cachereverseallApplicationsConnectionRule = new HashSet<>();
      Set<ConnectionRule> _48 = new HashSet<>();
      Set<ConnectionRule> _49 = new HashSet<>();
      for (ConnectionRule _4a : outgoingAppConnections) {
        _48.add(_4a);
      }
      Set<ConnectionRule> _4b = new HashSet<>();
      Set<ConnectionRule> _4c = new HashSet<>();
      for (ConnectionRule _4d : ingoingAppConnections) {
        _4b.add(_4d);
      }
      for (ConnectionRule _4e : appConnections) {
        _4c.add(_4e);
      }
      _4b.addAll(_4c);
      for (ConnectionRule _4f : _4b) {
        _49.add(_4f);
      }
      _48.addAll(_49);
      for (ConnectionRule _50 : _48) {
        _cachereverseallApplicationsConnectionRule.add(_50);
      }
    }
    return _cachereverseallApplicationsConnectionRule;
  }

  public void addVulnerabilities(Vulnerability vulnerabilities) {
    this.vulnerabilities.add(vulnerabilities);
    vulnerabilities.application = this;
  }

  public void addHostSystem(System hostSystem) {
    this.hostSystem = hostSystem;
    hostSystem.sysExecutedApps.add(this);
  }

  public void addAppExecutedApps(Application appExecutedApps) {
    this.appExecutedApps.add(appExecutedApps);
    appExecutedApps.hostApp = this;
  }

  public void addHostApp(Application hostApp) {
    this.hostApp = hostApp;
    hostApp.appExecutedApps.add(this);
  }

  public void addAppSoftProduct(SoftwareProduct appSoftProduct) {
    this.appSoftProduct = appSoftProduct;
    appSoftProduct.softApplications.add(this);
  }

  public void addManagedRoutingFw(RoutingFirewall managedRoutingFw) {
    this.managedRoutingFw.add(managedRoutingFw);
    managedRoutingFw.managerApp = this;
  }

  public void addNetworks(Network networks) {
    this.networks.add(networks);
    networks.applications.add(this);
  }

  public void addClientAccessNetworks(Network clientAccessNetworks) {
    this.clientAccessNetworks.add(clientAccessNetworks);
    clientAccessNetworks.clientApplications.add(this);
  }

  public void addAppConnections(ConnectionRule appConnections) {
    this.appConnections.add(appConnections);
    appConnections.applications.add(this);
  }

  public void addIngoingAppConnections(ConnectionRule ingoingAppConnections) {
    this.ingoingAppConnections.add(ingoingAppConnections);
    ingoingAppConnections.inApplications.add(this);
  }

  public void addOutgoingAppConnections(ConnectionRule outgoingAppConnections) {
    this.outgoingAppConnections.add(outgoingAppConnections);
    outgoingAppConnections.outApplications.add(this);
  }

  public void addContainedData(Data containedData) {
    this.containedData.add(containedData);
    containedData.containingApp.add(this);
  }

  public void addTransitData(Data transitData) {
    this.transitData.add(transitData);
    transitData.transitApp.add(this);
  }

  public void addExecutionPrivIds(Identity executionPrivIds) {
    this.executionPrivIds.add(executionPrivIds);
    executionPrivIds.execPrivApps.add(this);
  }

  public void addHighPrivAppIds(Identity highPrivAppIds) {
    this.highPrivAppIds.add(highPrivAppIds);
    highPrivAppIds.highPrivApps.add(this);
  }

  public void addLowPrivAppIds(Identity lowPrivAppIds) {
    this.lowPrivAppIds.add(lowPrivAppIds);
    lowPrivAppIds.lowPrivApps.add(this);
  }

  public void addExecutionPrivGroups(Group executionPrivGroups) {
    this.executionPrivGroups.add(executionPrivGroups);
    executionPrivGroups.execPrivApps.add(this);
  }

  public void addHighPrivAppGroups(Group highPrivAppGroups) {
    this.highPrivAppGroups.add(highPrivAppGroups);
    highPrivAppGroups.highPrivApps.add(this);
  }

  public void addLowPrivAppGroups(Group lowPrivAppGroups) {
    this.lowPrivAppGroups.add(lowPrivAppGroups);
    lowPrivAppGroups.lowPrivApps.add(this);
  }

  public void addExecutionPrivAppPriv(Privileges executionPrivAppPriv) {
    this.executionPrivAppPriv.add(executionPrivAppPriv);
    executionPrivAppPriv.execPrivApps.add(this);
  }

  public void addHighPrivAppPriv(Privileges highPrivAppPriv) {
    this.highPrivAppPriv.add(highPrivAppPriv);
    highPrivAppPriv.highPrivApps.add(this);
  }

  public void addLowPrivAppPriv(Privileges lowPrivAppPriv) {
    this.lowPrivAppPriv.add(lowPrivAppPriv);
    lowPrivAppPriv.lowPrivApps.add(this);
  }

  @Override
  public String getAssociatedAssetClassName(String field) {
    if (field.equals("vulnerabilities")) {
      return Vulnerability.class.getName();
    } else if (field.equals("hostSystem")) {
      return System.class.getName();
    } else if (field.equals("appExecutedApps")) {
      return Application.class.getName();
    } else if (field.equals("hostApp")) {
      return Application.class.getName();
    } else if (field.equals("appSoftProduct")) {
      return SoftwareProduct.class.getName();
    } else if (field.equals("managedRoutingFw")) {
      return RoutingFirewall.class.getName();
    } else if (field.equals("networks")) {
      return Network.class.getName();
    } else if (field.equals("clientAccessNetworks")) {
      return Network.class.getName();
    } else if (field.equals("appConnections")) {
      return ConnectionRule.class.getName();
    } else if (field.equals("ingoingAppConnections")) {
      return ConnectionRule.class.getName();
    } else if (field.equals("outgoingAppConnections")) {
      return ConnectionRule.class.getName();
    } else if (field.equals("containedData")) {
      return Data.class.getName();
    } else if (field.equals("transitData")) {
      return Data.class.getName();
    } else if (field.equals("executionPrivIds")) {
      return Identity.class.getName();
    } else if (field.equals("highPrivAppIds")) {
      return Identity.class.getName();
    } else if (field.equals("lowPrivAppIds")) {
      return Identity.class.getName();
    } else if (field.equals("executionPrivGroups")) {
      return Group.class.getName();
    } else if (field.equals("highPrivAppGroups")) {
      return Group.class.getName();
    } else if (field.equals("lowPrivAppGroups")) {
      return Group.class.getName();
    } else if (field.equals("executionPrivAppPriv")) {
      return Privileges.class.getName();
    } else if (field.equals("highPrivAppPriv")) {
      return Privileges.class.getName();
    } else if (field.equals("lowPrivAppPriv")) {
      return Privileges.class.getName();
    }
    return "";
  }

  @Override
  public Set<Asset> getAssociatedAssets(String field) {
    Set<Asset> assets = new HashSet<>();
    if (field.equals("vulnerabilities")) {
      assets.addAll(vulnerabilities);
    } else if (field.equals("hostSystem")) {
      if (hostSystem != null) {
        assets.add(hostSystem);
      }
    } else if (field.equals("appExecutedApps")) {
      assets.addAll(appExecutedApps);
    } else if (field.equals("hostApp")) {
      if (hostApp != null) {
        assets.add(hostApp);
      }
    } else if (field.equals("appSoftProduct")) {
      if (appSoftProduct != null) {
        assets.add(appSoftProduct);
      }
    } else if (field.equals("managedRoutingFw")) {
      assets.addAll(managedRoutingFw);
    } else if (field.equals("networks")) {
      assets.addAll(networks);
    } else if (field.equals("clientAccessNetworks")) {
      assets.addAll(clientAccessNetworks);
    } else if (field.equals("appConnections")) {
      assets.addAll(appConnections);
    } else if (field.equals("ingoingAppConnections")) {
      assets.addAll(ingoingAppConnections);
    } else if (field.equals("outgoingAppConnections")) {
      assets.addAll(outgoingAppConnections);
    } else if (field.equals("containedData")) {
      assets.addAll(containedData);
    } else if (field.equals("transitData")) {
      assets.addAll(transitData);
    } else if (field.equals("executionPrivIds")) {
      assets.addAll(executionPrivIds);
    } else if (field.equals("highPrivAppIds")) {
      assets.addAll(highPrivAppIds);
    } else if (field.equals("lowPrivAppIds")) {
      assets.addAll(lowPrivAppIds);
    } else if (field.equals("executionPrivGroups")) {
      assets.addAll(executionPrivGroups);
    } else if (field.equals("highPrivAppGroups")) {
      assets.addAll(highPrivAppGroups);
    } else if (field.equals("lowPrivAppGroups")) {
      assets.addAll(lowPrivAppGroups);
    } else if (field.equals("executionPrivAppPriv")) {
      assets.addAll(executionPrivAppPriv);
    } else if (field.equals("highPrivAppPriv")) {
      assets.addAll(highPrivAppPriv);
    } else if (field.equals("lowPrivAppPriv")) {
      assets.addAll(lowPrivAppPriv);
    }
    return assets;
  }

  @Override
  public Set<Asset> getAllAssociatedAssets() {
    Set<Asset> assets = new HashSet<>();
    assets.addAll(vulnerabilities);
    if (hostSystem != null) {
      assets.add(hostSystem);
    }
    assets.addAll(appExecutedApps);
    if (hostApp != null) {
      assets.add(hostApp);
    }
    if (appSoftProduct != null) {
      assets.add(appSoftProduct);
    }
    assets.addAll(managedRoutingFw);
    assets.addAll(networks);
    assets.addAll(clientAccessNetworks);
    assets.addAll(appConnections);
    assets.addAll(ingoingAppConnections);
    assets.addAll(outgoingAppConnections);
    assets.addAll(containedData);
    assets.addAll(transitData);
    assets.addAll(executionPrivIds);
    assets.addAll(highPrivAppIds);
    assets.addAll(lowPrivAppIds);
    assets.addAll(executionPrivGroups);
    assets.addAll(highPrivAppGroups);
    assets.addAll(lowPrivAppGroups);
    assets.addAll(executionPrivAppPriv);
    assets.addAll(highPrivAppPriv);
    assets.addAll(lowPrivAppPriv);
    return assets;
  }

  @Override
  public HashMap<String, HashSet<Asset>> getFields() {
    var fields = super.getFields();
    fields.put("vulnerabilities", new HashSet<Asset>());
    fields.get("vulnerabilities").addAll(vulnerabilities);
    fields.put("hostSystem", new HashSet<Asset>());
    if (hostSystem != null) {
      fields.get("hostSystem").add(hostSystem);
    }
    fields.put("appExecutedApps", new HashSet<Asset>());
    fields.get("appExecutedApps").addAll(appExecutedApps);
    fields.put("hostApp", new HashSet<Asset>());
    if (hostApp != null) {
      fields.get("hostApp").add(hostApp);
    }
    fields.put("appSoftProduct", new HashSet<Asset>());
    if (appSoftProduct != null) {
      fields.get("appSoftProduct").add(appSoftProduct);
    }
    fields.put("managedRoutingFw", new HashSet<Asset>());
    fields.get("managedRoutingFw").addAll(managedRoutingFw);
    fields.put("networks", new HashSet<Asset>());
    fields.get("networks").addAll(networks);
    fields.put("clientAccessNetworks", new HashSet<Asset>());
    fields.get("clientAccessNetworks").addAll(clientAccessNetworks);
    fields.put("appConnections", new HashSet<Asset>());
    fields.get("appConnections").addAll(appConnections);
    fields.put("ingoingAppConnections", new HashSet<Asset>());
    fields.get("ingoingAppConnections").addAll(ingoingAppConnections);
    fields.put("outgoingAppConnections", new HashSet<Asset>());
    fields.get("outgoingAppConnections").addAll(outgoingAppConnections);
    fields.put("containedData", new HashSet<Asset>());
    fields.get("containedData").addAll(containedData);
    fields.put("transitData", new HashSet<Asset>());
    fields.get("transitData").addAll(transitData);
    fields.put("executionPrivIds", new HashSet<Asset>());
    fields.get("executionPrivIds").addAll(executionPrivIds);
    fields.put("highPrivAppIds", new HashSet<Asset>());
    fields.get("highPrivAppIds").addAll(highPrivAppIds);
    fields.put("lowPrivAppIds", new HashSet<Asset>());
    fields.get("lowPrivAppIds").addAll(lowPrivAppIds);
    fields.put("executionPrivGroups", new HashSet<Asset>());
    fields.get("executionPrivGroups").addAll(executionPrivGroups);
    fields.put("highPrivAppGroups", new HashSet<Asset>());
    fields.get("highPrivAppGroups").addAll(highPrivAppGroups);
    fields.put("lowPrivAppGroups", new HashSet<Asset>());
    fields.get("lowPrivAppGroups").addAll(lowPrivAppGroups);
    fields.put("executionPrivAppPriv", new HashSet<Asset>());
    fields.get("executionPrivAppPriv").addAll(executionPrivAppPriv);
    fields.put("highPrivAppPriv", new HashSet<Asset>());
    fields.get("highPrivAppPriv").addAll(highPrivAppPriv);
    fields.put("lowPrivAppPriv", new HashSet<Asset>());
    fields.get("lowPrivAppPriv").addAll(lowPrivAppPriv);
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
          _cacheChildrenDisabled.add(specificAccessFromLocalConnection);
          _cacheChildrenDisabled.add(specificAccessFromNetworkConnection);
          _cacheChildrenDisabled.add(localAccess);
          _cacheChildrenDisabled.add(networkAccess);
          _cacheChildrenDisabled.add(fullAccessAfterSoftProdVulnerability);
          _cacheChildrenDisabled.add(readAfterSoftProdVulnerability);
          _cacheChildrenDisabled.add(modifyAfterSoftProdVulnerability);
          _cacheChildrenDisabled.add(denyAfterSoftProdVulnerability);
          _cacheChildrenDisabled.add(useVulnerability);
        }
        for (AttackStep attackStep : _cacheChildrenDisabled) {
          attackStep.updateTtc(this, ttc, attackSteps);
        }
      }

      @Override
      public Set<AttackStep> getAttackStepChildren() {
        var tmp = super.getAttackStepChildren();
        tmp.add(specificAccessFromLocalConnection);
        tmp.add(specificAccessFromNetworkConnection);
        tmp.add(localAccess);
        tmp.add(networkAccess);
        tmp.add(fullAccessAfterSoftProdVulnerability);
        tmp.add(readAfterSoftProdVulnerability);
        tmp.add(modifyAfterSoftProdVulnerability);
        tmp.add(denyAfterSoftProdVulnerability);
        tmp.add(useVulnerability);
        return tmp;
      }

      @Override
      public String fullName() {
        return "Application.disabled";
      }
    }
  }

  public class LocalConnect extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenLocalConnect;

    private Set<AttackStep> _cacheParentLocalConnect;

    public LocalConnect(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenLocalConnect == null) {
        _cacheChildrenLocalConnect = new HashSet<>();
        _cacheChildrenLocalConnect.add(localAccess);
        _cacheChildrenLocalConnect.add(specificAccessFromLocalConnection);
        _cacheChildrenLocalConnect.add(attemptUseVulnerability);
        _cacheChildrenLocalConnect.add(attemptLocalConnectVuln);
      }
      for (AttackStep attackStep : _cacheChildrenLocalConnect) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepChildren() {
      var tmp = super.getAttackStepChildren();
      tmp.add(localAccess);
      tmp.add(specificAccessFromLocalConnection);
      tmp.add(attemptUseVulnerability);
      tmp.add(attemptLocalConnectVuln);
      return tmp;
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentLocalConnect == null) {
        _cacheParentLocalConnect = new HashSet<>();
        if (hostSystem != null) {
          _cacheParentLocalConnect.add(hostSystem.specificAccess);
        }
        if (hostApp != null) {
          _cacheParentLocalConnect.add(hostApp.specificAccess);
        }
        for (Application _0 : appExecutedApps) {
          _cacheParentLocalConnect.add(_0.fullAccess);
        }
      }
      for (AttackStep attackStep : _cacheParentLocalConnect) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepParents() {
      var tmp = super.getAttackStepParents();
      if (hostSystem != null) {
        tmp.add(hostSystem.specificAccess);
      }
      if (hostApp != null) {
        tmp.add(hostApp.specificAccess);
      }
      for (Application _1 : appExecutedApps) {
        tmp.add(_1.fullAccess);
      }
      return tmp;
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.localConnect");
    }
  }

  public class AttemptUseVulnerability extends Object.AttemptUseVulnerability {
    private Set<AttackStep> _cacheChildrenAttemptUseVulnerability;

    private Set<AttackStep> _cacheParentAttemptUseVulnerability;

    public AttemptUseVulnerability(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAttemptUseVulnerability == null) {
        _cacheChildrenAttemptUseVulnerability = new HashSet<>();
        _cacheChildrenAttemptUseVulnerability.add(useVulnerability);
      }
      for (AttackStep attackStep : _cacheChildrenAttemptUseVulnerability) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepChildren() {
      var tmp = super.getAttackStepChildren();
      tmp.add(useVulnerability);
      return tmp;
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAttemptUseVulnerability == null) {
        _cacheParentAttemptUseVulnerability = new HashSet<>();
        _cacheParentAttemptUseVulnerability.add(localConnect);
        _cacheParentAttemptUseVulnerability.add(networkConnect);
        _cacheParentAttemptUseVulnerability.add(specificAccess);
        for (Application _0 : appExecutedApps) {
          _cacheParentAttemptUseVulnerability.add(_0.attemptLocalConnectVulnOnHost);
        }
      }
      for (AttackStep attackStep : _cacheParentAttemptUseVulnerability) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepParents() {
      var tmp = super.getAttackStepParents();
      tmp.add(localConnect);
      tmp.add(networkConnect);
      tmp.add(specificAccess);
      for (Application _1 : appExecutedApps) {
        tmp.add(_1.attemptLocalConnectVulnOnHost);
      }
      return tmp;
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.attemptUseVulnerability");
    }
  }

  public class UseVulnerability extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenUseVulnerability;

    private Set<AttackStep> _cacheParentUseVulnerability;

    public UseVulnerability(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenUseVulnerability == null) {
        _cacheChildrenUseVulnerability = new HashSet<>();
        for (var _0 : _allManualVulnerabilitiesApplication()) {
          _cacheChildrenUseVulnerability.add(_0.attemptAbuse);
        }
        for (var _1 : _allUnknownVulnerabilitiesApplication()) {
          _cacheChildrenUseVulnerability.add(_1.attemptAbuse);
        }
        _cacheChildrenUseVulnerability.add(fullAccessAfterSoftProdVulnerability);
        _cacheChildrenUseVulnerability.add(readAfterSoftProdVulnerability);
        _cacheChildrenUseVulnerability.add(modifyAfterSoftProdVulnerability);
        _cacheChildrenUseVulnerability.add(denyAfterSoftProdVulnerability);
      }
      for (AttackStep attackStep : _cacheChildrenUseVulnerability) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepChildren() {
      var tmp = super.getAttackStepChildren();
      for (var _2 : _allManualVulnerabilitiesApplication()) {
        tmp.add(_2.attemptAbuse);
      }
      for (var _3 : _allUnknownVulnerabilitiesApplication()) {
        tmp.add(_3.attemptAbuse);
      }
      tmp.add(fullAccessAfterSoftProdVulnerability);
      tmp.add(readAfterSoftProdVulnerability);
      tmp.add(modifyAfterSoftProdVulnerability);
      tmp.add(denyAfterSoftProdVulnerability);
      return tmp;
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentUseVulnerability == null) {
        _cacheParentUseVulnerability = new HashSet<>();
        _cacheParentUseVulnerability.add(disabled.disable);
        _cacheParentUseVulnerability.add(attemptUseVulnerability);
      }
      for (AttackStep attackStep : _cacheParentUseVulnerability) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepParents() {
      var tmp = super.getAttackStepParents();
      tmp.add(disabled.disable);
      tmp.add(attemptUseVulnerability);
      return tmp;
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.useVulnerability");
    }
  }

  public class AttemptLocalConnectVuln extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAttemptLocalConnectVuln;

    private Set<AttackStep> _cacheParentAttemptLocalConnectVuln;

    public AttemptLocalConnectVuln(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAttemptLocalConnectVuln == null) {
        _cacheChildrenAttemptLocalConnectVuln = new HashSet<>();
        for (var _0 : _allAutomaticVulnerabilitiesApplication()) {
          if (_0 instanceof LLNNVulnerability) {
            _cacheChildrenAttemptLocalConnectVuln.add(((org.mal_lang.joh_mal_bugs.example1.test.LLNNVulnerability) _0).attemptAbuse);
          }
        }
        for (var _1 : _allAutomaticVulnerabilitiesApplication()) {
          if (_1 instanceof LLNRVulnerability) {
            _cacheChildrenAttemptLocalConnectVuln.add(((org.mal_lang.joh_mal_bugs.example1.test.LLNRVulnerability) _1).attemptAbuse);
          }
        }
        for (var _2 : _allAutomaticVulnerabilitiesApplication()) {
          if (_2 instanceof LHNNVulnerability) {
            _cacheChildrenAttemptLocalConnectVuln.add(((org.mal_lang.joh_mal_bugs.example1.test.LHNNVulnerability) _2).attemptAbuse);
          }
        }
        for (var _3 : _allAutomaticVulnerabilitiesApplication()) {
          if (_3 instanceof LHNRVulnerability) {
            _cacheChildrenAttemptLocalConnectVuln.add(((org.mal_lang.joh_mal_bugs.example1.test.LHNRVulnerability) _3).attemptAbuse);
          }
        }
      }
      for (AttackStep attackStep : _cacheChildrenAttemptLocalConnectVuln) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepChildren() {
      var tmp = super.getAttackStepChildren();
      for (var _4 : _allAutomaticVulnerabilitiesApplication()) {
        if (_4 instanceof LLNNVulnerability) {
          tmp.add(((org.mal_lang.joh_mal_bugs.example1.test.LLNNVulnerability) _4).attemptAbuse);
        }
      }
      for (var _5 : _allAutomaticVulnerabilitiesApplication()) {
        if (_5 instanceof LLNRVulnerability) {
          tmp.add(((org.mal_lang.joh_mal_bugs.example1.test.LLNRVulnerability) _5).attemptAbuse);
        }
      }
      for (var _6 : _allAutomaticVulnerabilitiesApplication()) {
        if (_6 instanceof LHNNVulnerability) {
          tmp.add(((org.mal_lang.joh_mal_bugs.example1.test.LHNNVulnerability) _6).attemptAbuse);
        }
      }
      for (var _7 : _allAutomaticVulnerabilitiesApplication()) {
        if (_7 instanceof LHNRVulnerability) {
          tmp.add(((org.mal_lang.joh_mal_bugs.example1.test.LHNRVulnerability) _7).attemptAbuse);
        }
      }
      return tmp;
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAttemptLocalConnectVuln == null) {
        _cacheParentAttemptLocalConnectVuln = new HashSet<>();
        _cacheParentAttemptLocalConnectVuln.add(localConnect);
        _cacheParentAttemptLocalConnectVuln.add(specificAccess);
        for (Application _8 : appExecutedApps) {
          _cacheParentAttemptLocalConnectVuln.add(_8.attemptLocalConnectVulnOnHost);
        }
      }
      for (AttackStep attackStep : _cacheParentAttemptLocalConnectVuln) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepParents() {
      var tmp = super.getAttackStepParents();
      tmp.add(localConnect);
      tmp.add(specificAccess);
      for (Application _9 : appExecutedApps) {
        tmp.add(_9.attemptLocalConnectVulnOnHost);
      }
      return tmp;
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.attemptLocalConnectVuln");
    }
  }

  public class AttemptNetworkRequestRespondConnectVuln extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAttemptNetworkRequestRespondConnectVuln;

    private Set<AttackStep> _cacheParentAttemptNetworkRequestRespondConnectVuln;

    public AttemptNetworkRequestRespondConnectVuln(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAttemptNetworkRequestRespondConnectVuln == null) {
        _cacheChildrenAttemptNetworkRequestRespondConnectVuln = new HashSet<>();
        for (var _0 : _allAutomaticVulnerabilitiesApplication()) {
          if (_0 instanceof NLNNVulnerability) {
            _cacheChildrenAttemptNetworkRequestRespondConnectVuln.add(((org.mal_lang.joh_mal_bugs.example1.test.NLNNVulnerability) _0).attemptAbuse);
          }
        }
        for (var _1 : _allAutomaticVulnerabilitiesApplication()) {
          if (_1 instanceof NLNRVulnerability) {
            _cacheChildrenAttemptNetworkRequestRespondConnectVuln.add(((org.mal_lang.joh_mal_bugs.example1.test.NLNRVulnerability) _1).attemptAbuse);
          }
        }
        for (var _2 : _allAutomaticVulnerabilitiesApplication()) {
          if (_2 instanceof NLLNVulnerability) {
            _cacheChildrenAttemptNetworkRequestRespondConnectVuln.add(((org.mal_lang.joh_mal_bugs.example1.test.NLLNVulnerability) _2).attemptAbuse);
          }
        }
        for (var _3 : _allAutomaticVulnerabilitiesApplication()) {
          if (_3 instanceof NLLRVulnerability) {
            _cacheChildrenAttemptNetworkRequestRespondConnectVuln.add(((org.mal_lang.joh_mal_bugs.example1.test.NLLRVulnerability) _3).attemptAbuse);
          }
        }
        for (var _4 : _allAutomaticVulnerabilitiesApplication()) {
          if (_4 instanceof NLHNVulnerability) {
            _cacheChildrenAttemptNetworkRequestRespondConnectVuln.add(((org.mal_lang.joh_mal_bugs.example1.test.NLHNVulnerability) _4).attemptAbuse);
          }
        }
        for (var _5 : _allAutomaticVulnerabilitiesApplication()) {
          if (_5 instanceof NLHRVulnerability) {
            _cacheChildrenAttemptNetworkRequestRespondConnectVuln.add(((org.mal_lang.joh_mal_bugs.example1.test.NLHRVulnerability) _5).attemptAbuse);
          }
        }
        for (var _6 : _allAutomaticVulnerabilitiesApplication()) {
          if (_6 instanceof NHNNVulnerability) {
            _cacheChildrenAttemptNetworkRequestRespondConnectVuln.add(((org.mal_lang.joh_mal_bugs.example1.test.NHNNVulnerability) _6).attemptAbuse);
          }
        }
        for (var _7 : _allAutomaticVulnerabilitiesApplication()) {
          if (_7 instanceof NHNRVulnerability) {
            _cacheChildrenAttemptNetworkRequestRespondConnectVuln.add(((org.mal_lang.joh_mal_bugs.example1.test.NHNRVulnerability) _7).attemptAbuse);
          }
        }
        for (var _8 : _allAutomaticVulnerabilitiesApplication()) {
          if (_8 instanceof NHLNVulnerability) {
            _cacheChildrenAttemptNetworkRequestRespondConnectVuln.add(((org.mal_lang.joh_mal_bugs.example1.test.NHLNVulnerability) _8).attemptAbuse);
          }
        }
        for (var _9 : _allAutomaticVulnerabilitiesApplication()) {
          if (_9 instanceof NHLRVulnerability) {
            _cacheChildrenAttemptNetworkRequestRespondConnectVuln.add(((org.mal_lang.joh_mal_bugs.example1.test.NHLRVulnerability) _9).attemptAbuse);
          }
        }
        for (var _a : _allAutomaticVulnerabilitiesApplication()) {
          if (_a instanceof NHHNVulnerability) {
            _cacheChildrenAttemptNetworkRequestRespondConnectVuln.add(((org.mal_lang.joh_mal_bugs.example1.test.NHHNVulnerability) _a).attemptAbuse);
          }
        }
        for (var _b : _allAutomaticVulnerabilitiesApplication()) {
          if (_b instanceof NHHRVulnerability) {
            _cacheChildrenAttemptNetworkRequestRespondConnectVuln.add(((org.mal_lang.joh_mal_bugs.example1.test.NHHRVulnerability) _b).attemptAbuse);
          }
        }
      }
      for (AttackStep attackStep : _cacheChildrenAttemptNetworkRequestRespondConnectVuln) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepChildren() {
      var tmp = super.getAttackStepChildren();
      for (var _c : _allAutomaticVulnerabilitiesApplication()) {
        if (_c instanceof NLNNVulnerability) {
          tmp.add(((org.mal_lang.joh_mal_bugs.example1.test.NLNNVulnerability) _c).attemptAbuse);
        }
      }
      for (var _d : _allAutomaticVulnerabilitiesApplication()) {
        if (_d instanceof NLNRVulnerability) {
          tmp.add(((org.mal_lang.joh_mal_bugs.example1.test.NLNRVulnerability) _d).attemptAbuse);
        }
      }
      for (var _e : _allAutomaticVulnerabilitiesApplication()) {
        if (_e instanceof NLLNVulnerability) {
          tmp.add(((org.mal_lang.joh_mal_bugs.example1.test.NLLNVulnerability) _e).attemptAbuse);
        }
      }
      for (var _f : _allAutomaticVulnerabilitiesApplication()) {
        if (_f instanceof NLLRVulnerability) {
          tmp.add(((org.mal_lang.joh_mal_bugs.example1.test.NLLRVulnerability) _f).attemptAbuse);
        }
      }
      for (var _10 : _allAutomaticVulnerabilitiesApplication()) {
        if (_10 instanceof NLHNVulnerability) {
          tmp.add(((org.mal_lang.joh_mal_bugs.example1.test.NLHNVulnerability) _10).attemptAbuse);
        }
      }
      for (var _11 : _allAutomaticVulnerabilitiesApplication()) {
        if (_11 instanceof NLHRVulnerability) {
          tmp.add(((org.mal_lang.joh_mal_bugs.example1.test.NLHRVulnerability) _11).attemptAbuse);
        }
      }
      for (var _12 : _allAutomaticVulnerabilitiesApplication()) {
        if (_12 instanceof NHNNVulnerability) {
          tmp.add(((org.mal_lang.joh_mal_bugs.example1.test.NHNNVulnerability) _12).attemptAbuse);
        }
      }
      for (var _13 : _allAutomaticVulnerabilitiesApplication()) {
        if (_13 instanceof NHNRVulnerability) {
          tmp.add(((org.mal_lang.joh_mal_bugs.example1.test.NHNRVulnerability) _13).attemptAbuse);
        }
      }
      for (var _14 : _allAutomaticVulnerabilitiesApplication()) {
        if (_14 instanceof NHLNVulnerability) {
          tmp.add(((org.mal_lang.joh_mal_bugs.example1.test.NHLNVulnerability) _14).attemptAbuse);
        }
      }
      for (var _15 : _allAutomaticVulnerabilitiesApplication()) {
        if (_15 instanceof NHLRVulnerability) {
          tmp.add(((org.mal_lang.joh_mal_bugs.example1.test.NHLRVulnerability) _15).attemptAbuse);
        }
      }
      for (var _16 : _allAutomaticVulnerabilitiesApplication()) {
        if (_16 instanceof NHHNVulnerability) {
          tmp.add(((org.mal_lang.joh_mal_bugs.example1.test.NHHNVulnerability) _16).attemptAbuse);
        }
      }
      for (var _17 : _allAutomaticVulnerabilitiesApplication()) {
        if (_17 instanceof NHHRVulnerability) {
          tmp.add(((org.mal_lang.joh_mal_bugs.example1.test.NHHRVulnerability) _17).attemptAbuse);
        }
      }
      return tmp;
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAttemptNetworkRequestRespondConnectVuln == null) {
        _cacheParentAttemptNetworkRequestRespondConnectVuln = new HashSet<>();
        _cacheParentAttemptNetworkRequestRespondConnectVuln.add(networkRequestConnect);
        _cacheParentAttemptNetworkRequestRespondConnectVuln.add(networkRespondConnect);
      }
      for (AttackStep attackStep : _cacheParentAttemptNetworkRequestRespondConnectVuln) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepParents() {
      var tmp = super.getAttackStepParents();
      tmp.add(networkRequestConnect);
      tmp.add(networkRespondConnect);
      return tmp;
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.attemptNetworkRequestRespondConnectVuln");
    }
  }

  public class AttemptLocalLowPrivVuln extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAttemptLocalLowPrivVuln;

    private Set<AttackStep> _cacheParentAttemptLocalLowPrivVuln;

    public AttemptLocalLowPrivVuln(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAttemptLocalLowPrivVuln == null) {
        _cacheChildrenAttemptLocalLowPrivVuln = new HashSet<>();
        for (var _0 : _allAutomaticVulnerabilitiesApplication()) {
          if (_0 instanceof LLLNVulnerability) {
            _cacheChildrenAttemptLocalLowPrivVuln.add(((org.mal_lang.joh_mal_bugs.example1.test.LLLNVulnerability) _0).attemptAbuse);
          }
        }
        for (var _1 : _allAutomaticVulnerabilitiesApplication()) {
          if (_1 instanceof LLLRVulnerability) {
            _cacheChildrenAttemptLocalLowPrivVuln.add(((org.mal_lang.joh_mal_bugs.example1.test.LLLRVulnerability) _1).attemptAbuse);
          }
        }
        for (var _2 : _allAutomaticVulnerabilitiesApplication()) {
          if (_2 instanceof LHLNVulnerability) {
            _cacheChildrenAttemptLocalLowPrivVuln.add(((org.mal_lang.joh_mal_bugs.example1.test.LHLNVulnerability) _2).attemptAbuse);
          }
        }
        for (var _3 : _allAutomaticVulnerabilitiesApplication()) {
          if (_3 instanceof LHLRVulnerability) {
            _cacheChildrenAttemptLocalLowPrivVuln.add(((org.mal_lang.joh_mal_bugs.example1.test.LHLRVulnerability) _3).attemptAbuse);
          }
        }
      }
      for (AttackStep attackStep : _cacheChildrenAttemptLocalLowPrivVuln) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepChildren() {
      var tmp = super.getAttackStepChildren();
      for (var _4 : _allAutomaticVulnerabilitiesApplication()) {
        if (_4 instanceof LLLNVulnerability) {
          tmp.add(((org.mal_lang.joh_mal_bugs.example1.test.LLLNVulnerability) _4).attemptAbuse);
        }
      }
      for (var _5 : _allAutomaticVulnerabilitiesApplication()) {
        if (_5 instanceof LLLRVulnerability) {
          tmp.add(((org.mal_lang.joh_mal_bugs.example1.test.LLLRVulnerability) _5).attemptAbuse);
        }
      }
      for (var _6 : _allAutomaticVulnerabilitiesApplication()) {
        if (_6 instanceof LHLNVulnerability) {
          tmp.add(((org.mal_lang.joh_mal_bugs.example1.test.LHLNVulnerability) _6).attemptAbuse);
        }
      }
      for (var _7 : _allAutomaticVulnerabilitiesApplication()) {
        if (_7 instanceof LHLRVulnerability) {
          tmp.add(((org.mal_lang.joh_mal_bugs.example1.test.LHLRVulnerability) _7).attemptAbuse);
        }
      }
      return tmp;
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAttemptLocalLowPrivVuln == null) {
        _cacheParentAttemptLocalLowPrivVuln = new HashSet<>();
        _cacheParentAttemptLocalLowPrivVuln.add(specificAccess);
      }
      for (AttackStep attackStep : _cacheParentAttemptLocalLowPrivVuln) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepParents() {
      var tmp = super.getAttackStepParents();
      tmp.add(specificAccess);
      return tmp;
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.attemptLocalLowPrivVuln");
    }
  }

  public class AttemptLocalHighPrivVuln extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAttemptLocalHighPrivVuln;

    private Set<AttackStep> _cacheParentAttemptLocalHighPrivVuln;

    public AttemptLocalHighPrivVuln(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAttemptLocalHighPrivVuln == null) {
        _cacheChildrenAttemptLocalHighPrivVuln = new HashSet<>();
        for (var _0 : _allAutomaticVulnerabilitiesApplication()) {
          if (_0 instanceof LLHRVulnerability) {
            _cacheChildrenAttemptLocalHighPrivVuln.add(((org.mal_lang.joh_mal_bugs.example1.test.LLHRVulnerability) _0).attemptAbuse);
          }
        }
        for (var _1 : _allAutomaticVulnerabilitiesApplication()) {
          if (_1 instanceof LLHNVulnerability) {
            _cacheChildrenAttemptLocalHighPrivVuln.add(((org.mal_lang.joh_mal_bugs.example1.test.LLHNVulnerability) _1).attemptAbuse);
          }
        }
        for (var _2 : _allAutomaticVulnerabilitiesApplication()) {
          if (_2 instanceof LHHNVulnerability) {
            _cacheChildrenAttemptLocalHighPrivVuln.add(((org.mal_lang.joh_mal_bugs.example1.test.LHHNVulnerability) _2).attemptAbuse);
          }
        }
        for (var _3 : _allAutomaticVulnerabilitiesApplication()) {
          if (_3 instanceof LHHRVulnerability) {
            _cacheChildrenAttemptLocalHighPrivVuln.add(((org.mal_lang.joh_mal_bugs.example1.test.LHHRVulnerability) _3).attemptAbuse);
          }
        }
      }
      for (AttackStep attackStep : _cacheChildrenAttemptLocalHighPrivVuln) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepChildren() {
      var tmp = super.getAttackStepChildren();
      for (var _4 : _allAutomaticVulnerabilitiesApplication()) {
        if (_4 instanceof LLHRVulnerability) {
          tmp.add(((org.mal_lang.joh_mal_bugs.example1.test.LLHRVulnerability) _4).attemptAbuse);
        }
      }
      for (var _5 : _allAutomaticVulnerabilitiesApplication()) {
        if (_5 instanceof LLHNVulnerability) {
          tmp.add(((org.mal_lang.joh_mal_bugs.example1.test.LLHNVulnerability) _5).attemptAbuse);
        }
      }
      for (var _6 : _allAutomaticVulnerabilitiesApplication()) {
        if (_6 instanceof LHHNVulnerability) {
          tmp.add(((org.mal_lang.joh_mal_bugs.example1.test.LHHNVulnerability) _6).attemptAbuse);
        }
      }
      for (var _7 : _allAutomaticVulnerabilitiesApplication()) {
        if (_7 instanceof LHHRVulnerability) {
          tmp.add(((org.mal_lang.joh_mal_bugs.example1.test.LHHRVulnerability) _7).attemptAbuse);
        }
      }
      return tmp;
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAttemptLocalHighPrivVuln == null) {
        _cacheParentAttemptLocalHighPrivVuln = new HashSet<>();
        _cacheParentAttemptLocalHighPrivVuln.add(fullAccess);
      }
      for (AttackStep attackStep : _cacheParentAttemptLocalHighPrivVuln) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepParents() {
      var tmp = super.getAttackStepParents();
      tmp.add(fullAccess);
      return tmp;
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.attemptLocalHighPrivVuln");
    }
  }

  public class NetworkConnect extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenNetworkConnect;

    private Set<AttackStep> _cacheParentNetworkConnect;

    public NetworkConnect(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenNetworkConnect == null) {
        _cacheChildrenNetworkConnect = new HashSet<>();
        _cacheChildrenNetworkConnect.add(networkAccess);
        _cacheChildrenNetworkConnect.add(specificAccessFromNetworkConnection);
        _cacheChildrenNetworkConnect.add(attemptUseVulnerability);
      }
      for (AttackStep attackStep : _cacheChildrenNetworkConnect) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepChildren() {
      var tmp = super.getAttackStepChildren();
      tmp.add(networkAccess);
      tmp.add(specificAccessFromNetworkConnection);
      tmp.add(attemptUseVulnerability);
      return tmp;
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentNetworkConnect == null) {
        _cacheParentNetworkConnect = new HashSet<>();
        _cacheParentNetworkConnect.add(networkRespondConnect);
        for (Identity _0 : executionPrivIds) {
          for (User _1 : _0.users) {
            _cacheParentNetworkConnect.add(_1.reverseTakeover);
          }
        }
        for (Network _2 : networks) {
          _cacheParentNetworkConnect.add(_2.successfulAccess);
        }
        for (ConnectionRule _3 : appConnections) {
          if (_3.routingFirewalls != null) {
            _cacheParentNetworkConnect.add(_3.routingFirewalls.fullAccess);
          }
        }
        for (var _4 : _reverseserverApplicationsConnectionRule()) {
          _cacheParentNetworkConnect.add(_4.connectToApplications);
        }
      }
      for (AttackStep attackStep : _cacheParentNetworkConnect) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepParents() {
      var tmp = super.getAttackStepParents();
      tmp.add(networkRespondConnect);
      for (Identity _5 : executionPrivIds) {
        for (User _6 : _5.users) {
          tmp.add(_6.reverseTakeover);
        }
      }
      for (Network _7 : networks) {
        tmp.add(_7.successfulAccess);
      }
      for (ConnectionRule _8 : appConnections) {
        if (_8.routingFirewalls != null) {
          tmp.add(_8.routingFirewalls.fullAccess);
        }
      }
      for (var _9 : _reverseserverApplicationsConnectionRule()) {
        tmp.add(_9.connectToApplications);
      }
      return tmp;
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.networkConnect");
    }
  }

  public class AccessNetworkAndConnections extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAccessNetworkAndConnections;

    private Set<AttackStep> _cacheParentAccessNetworkAndConnections;

    public AccessNetworkAndConnections(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAccessNetworkAndConnections == null) {
        _cacheChildrenAccessNetworkAndConnections = new HashSet<>();
        for (Network _0 : networks) {
          _cacheChildrenAccessNetworkAndConnections.add(_0.access);
        }
        for (Network _1 : clientAccessNetworks) {
          _cacheChildrenAccessNetworkAndConnections.add(_1.access);
        }
        for (var _2 : _clientApplicationConnectionsApplication()) {
          _cacheChildrenAccessNetworkAndConnections.add(_2.attemptConnectToApplications);
        }
        for (var _3 : _clientApplicationConnectionsApplication()) {
          _cacheChildrenAccessNetworkAndConnections.add(_3.attemptTransmit);
        }
        for (var _4 : _serverApplicationConnectionsApplication()) {
          _cacheChildrenAccessNetworkAndConnections.add(_4.attemptTransmitResponse);
        }
        for (var _5 : _allApplicationConnectionsApplication()) {
          _cacheChildrenAccessNetworkAndConnections.add(_5.attemptAccessNetworks);
        }
      }
      for (AttackStep attackStep : _cacheChildrenAccessNetworkAndConnections) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepChildren() {
      var tmp = super.getAttackStepChildren();
      for (Network _6 : networks) {
        tmp.add(_6.access);
      }
      for (Network _7 : clientAccessNetworks) {
        tmp.add(_7.access);
      }
      for (var _8 : _clientApplicationConnectionsApplication()) {
        tmp.add(_8.attemptConnectToApplications);
      }
      for (var _9 : _clientApplicationConnectionsApplication()) {
        tmp.add(_9.attemptTransmit);
      }
      for (var _a : _serverApplicationConnectionsApplication()) {
        tmp.add(_a.attemptTransmitResponse);
      }
      for (var _b : _allApplicationConnectionsApplication()) {
        tmp.add(_b.attemptAccessNetworks);
      }
      return tmp;
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAccessNetworkAndConnections == null) {
        _cacheParentAccessNetworkAndConnections = new HashSet<>();
        _cacheParentAccessNetworkAndConnections.add(specificAccess);
        _cacheParentAccessNetworkAndConnections.add(fullAccess);
      }
      for (AttackStep attackStep : _cacheParentAccessNetworkAndConnections) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepParents() {
      var tmp = super.getAttackStepParents();
      tmp.add(specificAccess);
      tmp.add(fullAccess);
      return tmp;
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.accessNetworkAndConnections");
    }
  }

  public class NetworkRequestConnect extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenNetworkRequestConnect;

    private Set<AttackStep> _cacheParentNetworkRequestConnect;

    public NetworkRequestConnect(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenNetworkRequestConnect == null) {
        _cacheChildrenNetworkRequestConnect = new HashSet<>();
        _cacheChildrenNetworkRequestConnect.add(attemptNetworkRequestRespondConnectVuln);
      }
      for (AttackStep attackStep : _cacheChildrenNetworkRequestConnect) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepChildren() {
      var tmp = super.getAttackStepChildren();
      tmp.add(attemptNetworkRequestRespondConnectVuln);
      return tmp;
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentNetworkRequestConnect == null) {
        _cacheParentNetworkRequestConnect = new HashSet<>();
        for (Network _0 : networks) {
          _cacheParentNetworkRequestConnect.add(_0.successfulAccess);
        }
        for (var _1 : _reverseclientApplicationsConnectionRule()) {
          _cacheParentNetworkRequestConnect.add(_1.transmit);
        }
      }
      for (AttackStep attackStep : _cacheParentNetworkRequestConnect) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepParents() {
      var tmp = super.getAttackStepParents();
      for (Network _2 : networks) {
        tmp.add(_2.successfulAccess);
      }
      for (var _3 : _reverseclientApplicationsConnectionRule()) {
        tmp.add(_3.transmit);
      }
      return tmp;
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.networkRequestConnect");
    }
  }

  public class NetworkRespondConnect extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenNetworkRespondConnect;

    private Set<AttackStep> _cacheParentNetworkRespondConnect;

    public NetworkRespondConnect(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenNetworkRespondConnect == null) {
        _cacheChildrenNetworkRespondConnect = new HashSet<>();
        _cacheChildrenNetworkRespondConnect.add(attemptNetworkRequestRespondConnectVuln);
        _cacheChildrenNetworkRespondConnect.add(networkConnect);
      }
      for (AttackStep attackStep : _cacheChildrenNetworkRespondConnect) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepChildren() {
      var tmp = super.getAttackStepChildren();
      tmp.add(attemptNetworkRequestRespondConnectVuln);
      tmp.add(networkConnect);
      return tmp;
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentNetworkRespondConnect == null) {
        _cacheParentNetworkRespondConnect = new HashSet<>();
        for (Data _0 : transitData) {
          _cacheParentNetworkRespondConnect.add(_0.applicationRespondConnect);
        }
        for (Network _1 : clientAccessNetworks) {
          _cacheParentNetworkRespondConnect.add(_1.successfulAccess);
        }
        for (var _2 : _reverseclientApplicationsConnectionRule()) {
          _cacheParentNetworkRespondConnect.add(_2.transmitResponse);
        }
      }
      for (AttackStep attackStep : _cacheParentNetworkRespondConnect) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepParents() {
      var tmp = super.getAttackStepParents();
      for (Data _3 : transitData) {
        tmp.add(_3.applicationRespondConnect);
      }
      for (Network _4 : clientAccessNetworks) {
        tmp.add(_4.successfulAccess);
      }
      for (var _5 : _reverseclientApplicationsConnectionRule()) {
        tmp.add(_5.transmitResponse);
      }
      return tmp;
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.networkRespondConnect");
    }
  }

  public class SpecificAccessFromLocalConnection extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenSpecificAccessFromLocalConnection;

    private Set<AttackStep> _cacheParentSpecificAccessFromLocalConnection;

    public SpecificAccessFromLocalConnection(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenSpecificAccessFromLocalConnection == null) {
        _cacheChildrenSpecificAccessFromLocalConnection = new HashSet<>();
        _cacheChildrenSpecificAccessFromLocalConnection.add(specificAccess);
      }
      for (AttackStep attackStep : _cacheChildrenSpecificAccessFromLocalConnection) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepChildren() {
      var tmp = super.getAttackStepChildren();
      tmp.add(specificAccess);
      return tmp;
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentSpecificAccessFromLocalConnection == null) {
        _cacheParentSpecificAccessFromLocalConnection = new HashSet<>();
        _cacheParentSpecificAccessFromLocalConnection.add(disabled.disable);
        _cacheParentSpecificAccessFromLocalConnection.add(localConnect);
        _cacheParentSpecificAccessFromLocalConnection.add(specificAccessAuthenticate);
      }
      for (AttackStep attackStep : _cacheParentSpecificAccessFromLocalConnection) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepParents() {
      var tmp = super.getAttackStepParents();
      tmp.add(disabled.disable);
      tmp.add(localConnect);
      tmp.add(specificAccessAuthenticate);
      return tmp;
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.specificAccessFromLocalConnection");
    }
  }

  public class SpecificAccessFromNetworkConnection extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenSpecificAccessFromNetworkConnection;

    private Set<AttackStep> _cacheParentSpecificAccessFromNetworkConnection;

    public SpecificAccessFromNetworkConnection(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenSpecificAccessFromNetworkConnection == null) {
        _cacheChildrenSpecificAccessFromNetworkConnection = new HashSet<>();
        _cacheChildrenSpecificAccessFromNetworkConnection.add(specificAccess);
      }
      for (AttackStep attackStep : _cacheChildrenSpecificAccessFromNetworkConnection) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepChildren() {
      var tmp = super.getAttackStepChildren();
      tmp.add(specificAccess);
      return tmp;
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentSpecificAccessFromNetworkConnection == null) {
        _cacheParentSpecificAccessFromNetworkConnection = new HashSet<>();
        _cacheParentSpecificAccessFromNetworkConnection.add(disabled.disable);
        _cacheParentSpecificAccessFromNetworkConnection.add(networkConnect);
        _cacheParentSpecificAccessFromNetworkConnection.add(specificAccessAuthenticate);
      }
      for (AttackStep attackStep : _cacheParentSpecificAccessFromNetworkConnection) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepParents() {
      var tmp = super.getAttackStepParents();
      tmp.add(disabled.disable);
      tmp.add(networkConnect);
      tmp.add(specificAccessAuthenticate);
      return tmp;
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.specificAccessFromNetworkConnection");
    }
  }

  public class SpecificAccess extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenSpecificAccess;

    private Set<AttackStep> _cacheParentSpecificAccess;

    public SpecificAccess(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenSpecificAccess == null) {
        _cacheChildrenSpecificAccess = new HashSet<>();
        for (Application _0 : appExecutedApps) {
          _cacheChildrenSpecificAccess.add(_0.localConnect);
        }
        _cacheChildrenSpecificAccess.add(attemptLocalConnectVulnOnHost);
        _cacheChildrenSpecificAccess.add(attemptUseVulnerability);
        _cacheChildrenSpecificAccess.add(attemptLocalConnectVuln);
        _cacheChildrenSpecificAccess.add(attemptLocalLowPrivVuln);
        for (Data _1 : containedData) {
          _cacheChildrenSpecificAccess.add(_1.attemptAccessFromIdentity);
        }
        for (Data _2 : transitData) {
          _cacheChildrenSpecificAccess.add(_2.attemptAccessFromIdentity);
        }
        _cacheChildrenSpecificAccess.add(attemptApplicationRespondConnectThroughData);
        _cacheChildrenSpecificAccess.add(accessNetworkAndConnections);
      }
      for (AttackStep attackStep : _cacheChildrenSpecificAccess) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepChildren() {
      var tmp = super.getAttackStepChildren();
      for (Application _3 : appExecutedApps) {
        tmp.add(_3.localConnect);
      }
      tmp.add(attemptLocalConnectVulnOnHost);
      tmp.add(attemptUseVulnerability);
      tmp.add(attemptLocalConnectVuln);
      tmp.add(attemptLocalLowPrivVuln);
      for (Data _4 : containedData) {
        tmp.add(_4.attemptAccessFromIdentity);
      }
      for (Data _5 : transitData) {
        tmp.add(_5.attemptAccessFromIdentity);
      }
      tmp.add(attemptApplicationRespondConnectThroughData);
      tmp.add(accessNetworkAndConnections);
      return tmp;
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentSpecificAccess == null) {
        _cacheParentSpecificAccess = new HashSet<>();
        _cacheParentSpecificAccess.add(specificAccessFromLocalConnection);
        _cacheParentSpecificAccess.add(specificAccessFromNetworkConnection);
        _cacheParentSpecificAccess.add(fullAccess);
      }
      for (AttackStep attackStep : _cacheParentSpecificAccess) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepParents() {
      var tmp = super.getAttackStepParents();
      tmp.add(specificAccessFromLocalConnection);
      tmp.add(specificAccessFromNetworkConnection);
      tmp.add(fullAccess);
      return tmp;
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.specificAccess");
    }
  }

  public class AttemptLocalConnectVulnOnHost extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAttemptLocalConnectVulnOnHost;

    private Set<AttackStep> _cacheParentAttemptLocalConnectVulnOnHost;

    public AttemptLocalConnectVulnOnHost(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAttemptLocalConnectVulnOnHost == null) {
        _cacheChildrenAttemptLocalConnectVulnOnHost = new HashSet<>();
        if (hostApp != null) {
          _cacheChildrenAttemptLocalConnectVulnOnHost.add(hostApp.attemptLocalConnectVuln);
        }
        if (hostApp != null) {
          _cacheChildrenAttemptLocalConnectVulnOnHost.add(hostApp.attemptUseVulnerability);
        }
      }
      for (AttackStep attackStep : _cacheChildrenAttemptLocalConnectVulnOnHost) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepChildren() {
      var tmp = super.getAttackStepChildren();
      if (hostApp != null) {
        tmp.add(hostApp.attemptLocalConnectVuln);
      }
      if (hostApp != null) {
        tmp.add(hostApp.attemptUseVulnerability);
      }
      return tmp;
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAttemptLocalConnectVulnOnHost == null) {
        _cacheParentAttemptLocalConnectVulnOnHost = new HashSet<>();
        _cacheParentAttemptLocalConnectVulnOnHost.add(specificAccess);
      }
      for (AttackStep attackStep : _cacheParentAttemptLocalConnectVulnOnHost) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepParents() {
      var tmp = super.getAttackStepParents();
      tmp.add(specificAccess);
      return tmp;
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.attemptLocalConnectVulnOnHost");
    }
  }

  public class Authenticate extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAuthenticate;

    private Set<AttackStep> _cacheParentAuthenticate;

    public Authenticate(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAuthenticate == null) {
        _cacheChildrenAuthenticate = new HashSet<>();
        _cacheChildrenAuthenticate.add(localAccess);
        _cacheChildrenAuthenticate.add(networkAccess);
      }
      for (AttackStep attackStep : _cacheChildrenAuthenticate) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepChildren() {
      var tmp = super.getAttackStepChildren();
      tmp.add(localAccess);
      tmp.add(networkAccess);
      return tmp;
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAuthenticate == null) {
        _cacheParentAuthenticate = new HashSet<>();
        for (Identity _0 : executionPrivIds) {
          _cacheParentAuthenticate.add(_0.assume);
        }
        for (Identity _1 : highPrivAppIds) {
          _cacheParentAuthenticate.add(_1.assume);
        }
        for (Privileges _2 : executionPrivAppPriv) {
          _cacheParentAuthenticate.add(_2.assume);
        }
        for (Privileges _3 : highPrivAppPriv) {
          _cacheParentAuthenticate.add(_3.assume);
        }
        for (Group _4 : executionPrivGroups) {
          _cacheParentAuthenticate.add(_4.compromiseGroup);
        }
        for (Group _5 : highPrivAppGroups) {
          _cacheParentAuthenticate.add(_5.compromiseGroup);
        }
      }
      for (AttackStep attackStep : _cacheParentAuthenticate) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepParents() {
      var tmp = super.getAttackStepParents();
      for (Identity _6 : executionPrivIds) {
        tmp.add(_6.assume);
      }
      for (Identity _7 : highPrivAppIds) {
        tmp.add(_7.assume);
      }
      for (Privileges _8 : executionPrivAppPriv) {
        tmp.add(_8.assume);
      }
      for (Privileges _9 : highPrivAppPriv) {
        tmp.add(_9.assume);
      }
      for (Group _a : executionPrivGroups) {
        tmp.add(_a.compromiseGroup);
      }
      for (Group _b : highPrivAppGroups) {
        tmp.add(_b.compromiseGroup);
      }
      return tmp;
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.authenticate");
    }
  }

  public class SpecificAccessAuthenticate extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenSpecificAccessAuthenticate;

    private Set<AttackStep> _cacheParentSpecificAccessAuthenticate;

    public SpecificAccessAuthenticate(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenSpecificAccessAuthenticate == null) {
        _cacheChildrenSpecificAccessAuthenticate = new HashSet<>();
        _cacheChildrenSpecificAccessAuthenticate.add(specificAccessFromLocalConnection);
        _cacheChildrenSpecificAccessAuthenticate.add(specificAccessFromNetworkConnection);
      }
      for (AttackStep attackStep : _cacheChildrenSpecificAccessAuthenticate) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepChildren() {
      var tmp = super.getAttackStepChildren();
      tmp.add(specificAccessFromLocalConnection);
      tmp.add(specificAccessFromNetworkConnection);
      return tmp;
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentSpecificAccessAuthenticate == null) {
        _cacheParentSpecificAccessAuthenticate = new HashSet<>();
        for (Identity _0 : lowPrivAppIds) {
          _cacheParentSpecificAccessAuthenticate.add(_0.assume);
        }
        for (Privileges _1 : lowPrivAppPriv) {
          _cacheParentSpecificAccessAuthenticate.add(_1.assume);
        }
        for (Group _2 : lowPrivAppGroups) {
          _cacheParentSpecificAccessAuthenticate.add(_2.compromiseGroup);
        }
      }
      for (AttackStep attackStep : _cacheParentSpecificAccessAuthenticate) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepParents() {
      var tmp = super.getAttackStepParents();
      for (Identity _3 : lowPrivAppIds) {
        tmp.add(_3.assume);
      }
      for (Privileges _4 : lowPrivAppPriv) {
        tmp.add(_4.assume);
      }
      for (Group _5 : lowPrivAppGroups) {
        tmp.add(_5.compromiseGroup);
      }
      return tmp;
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.specificAccessAuthenticate");
    }
  }

  public class LocalAccess extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenLocalAccess;

    private Set<AttackStep> _cacheParentLocalAccess;

    public LocalAccess(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenLocalAccess == null) {
        _cacheChildrenLocalAccess = new HashSet<>();
        _cacheChildrenLocalAccess.add(fullAccess);
      }
      for (AttackStep attackStep : _cacheChildrenLocalAccess) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepChildren() {
      var tmp = super.getAttackStepChildren();
      tmp.add(fullAccess);
      return tmp;
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentLocalAccess == null) {
        _cacheParentLocalAccess = new HashSet<>();
        _cacheParentLocalAccess.add(disabled.disable);
        _cacheParentLocalAccess.add(localConnect);
        _cacheParentLocalAccess.add(authenticate);
      }
      for (AttackStep attackStep : _cacheParentLocalAccess) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepParents() {
      var tmp = super.getAttackStepParents();
      tmp.add(disabled.disable);
      tmp.add(localConnect);
      tmp.add(authenticate);
      return tmp;
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.localAccess");
    }
  }

  public class NetworkAccess extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenNetworkAccess;

    private Set<AttackStep> _cacheParentNetworkAccess;

    public NetworkAccess(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenNetworkAccess == null) {
        _cacheChildrenNetworkAccess = new HashSet<>();
        _cacheChildrenNetworkAccess.add(fullAccess);
      }
      for (AttackStep attackStep : _cacheChildrenNetworkAccess) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepChildren() {
      var tmp = super.getAttackStepChildren();
      tmp.add(fullAccess);
      return tmp;
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentNetworkAccess == null) {
        _cacheParentNetworkAccess = new HashSet<>();
        _cacheParentNetworkAccess.add(disabled.disable);
        _cacheParentNetworkAccess.add(networkConnect);
        _cacheParentNetworkAccess.add(authenticate);
      }
      for (AttackStep attackStep : _cacheParentNetworkAccess) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepParents() {
      var tmp = super.getAttackStepParents();
      tmp.add(disabled.disable);
      tmp.add(networkConnect);
      tmp.add(authenticate);
      return tmp;
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.networkAccess");
    }
  }

  public class FullAccess extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenFullAccess;

    private Set<AttackStep> _cacheParentFullAccess;

    public FullAccess(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenFullAccess == null) {
        _cacheChildrenFullAccess = new HashSet<>();
        _cacheChildrenFullAccess.add(read);
        _cacheChildrenFullAccess.add(modify);
        _cacheChildrenFullAccess.add(deny);
        for (Application _0 : appExecutedApps) {
          _cacheChildrenFullAccess.add(_0.fullAccess);
        }
        for (Identity _1 : executionPrivIds) {
          _cacheChildrenFullAccess.add(_1.assume);
        }
        for (Group _2 : executionPrivGroups) {
          _cacheChildrenFullAccess.add(_2.compromiseGroup);
        }
        for (Data _3 : containedData) {
          _cacheChildrenFullAccess.add(_3.attemptAccess);
        }
        for (Data _4 : transitData) {
          _cacheChildrenFullAccess.add(_4.attemptAccess);
        }
        _cacheChildrenFullAccess.add(attemptApplicationRespondConnectThroughData);
        _cacheChildrenFullAccess.add(accessNetworkAndConnections);
        if (hostApp != null) {
          _cacheChildrenFullAccess.add(hostApp.localConnect);
        }
        for (RoutingFirewall _5 : managedRoutingFw) {
          _cacheChildrenFullAccess.add(_5.fullAccess);
        }
        _cacheChildrenFullAccess.add(specificAccess);
        _cacheChildrenFullAccess.add(attemptLocalHighPrivVuln);
      }
      for (AttackStep attackStep : _cacheChildrenFullAccess) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepChildren() {
      var tmp = super.getAttackStepChildren();
      tmp.add(read);
      tmp.add(modify);
      tmp.add(deny);
      for (Application _6 : appExecutedApps) {
        tmp.add(_6.fullAccess);
      }
      for (Identity _7 : executionPrivIds) {
        tmp.add(_7.assume);
      }
      for (Group _8 : executionPrivGroups) {
        tmp.add(_8.compromiseGroup);
      }
      for (Data _9 : containedData) {
        tmp.add(_9.attemptAccess);
      }
      for (Data _a : transitData) {
        tmp.add(_a.attemptAccess);
      }
      tmp.add(attemptApplicationRespondConnectThroughData);
      tmp.add(accessNetworkAndConnections);
      if (hostApp != null) {
        tmp.add(hostApp.localConnect);
      }
      for (RoutingFirewall _b : managedRoutingFw) {
        tmp.add(_b.fullAccess);
      }
      tmp.add(specificAccess);
      tmp.add(attemptLocalHighPrivVuln);
      return tmp;
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentFullAccess == null) {
        _cacheParentFullAccess = new HashSet<>();
        if (hostSystem != null) {
          _cacheParentFullAccess.add(hostSystem.fullAccess);
        }
        _cacheParentFullAccess.add(localAccess);
        _cacheParentFullAccess.add(networkAccess);
        if (hostApp != null) {
          _cacheParentFullAccess.add(hostApp.fullAccess);
        }
        _cacheParentFullAccess.add(fullAccessAfterSoftProdVulnerability);
        _cacheParentFullAccess.add(codeExecutionAfterVulnerability);
      }
      for (AttackStep attackStep : _cacheParentFullAccess) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepParents() {
      var tmp = super.getAttackStepParents();
      if (hostSystem != null) {
        tmp.add(hostSystem.fullAccess);
      }
      tmp.add(localAccess);
      tmp.add(networkAccess);
      if (hostApp != null) {
        tmp.add(hostApp.fullAccess);
      }
      tmp.add(fullAccessAfterSoftProdVulnerability);
      tmp.add(codeExecutionAfterVulnerability);
      return tmp;
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.fullAccess");
    }
  }

  public class AttemptFullAccessAfterSoftProdVulnerability extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAttemptFullAccessAfterSoftProdVulnerability;

    private Set<AttackStep> _cacheParentAttemptFullAccessAfterSoftProdVulnerability;

    public AttemptFullAccessAfterSoftProdVulnerability(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAttemptFullAccessAfterSoftProdVulnerability == null) {
        _cacheChildrenAttemptFullAccessAfterSoftProdVulnerability = new HashSet<>();
        _cacheChildrenAttemptFullAccessAfterSoftProdVulnerability.add(fullAccessAfterSoftProdVulnerability);
      }
      for (AttackStep attackStep : _cacheChildrenAttemptFullAccessAfterSoftProdVulnerability) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepChildren() {
      var tmp = super.getAttackStepChildren();
      tmp.add(fullAccessAfterSoftProdVulnerability);
      return tmp;
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAttemptFullAccessAfterSoftProdVulnerability == null) {
        _cacheParentAttemptFullAccessAfterSoftProdVulnerability = new HashSet<>();
        if (appSoftProduct != null) {
          _cacheParentAttemptFullAccessAfterSoftProdVulnerability.add(appSoftProduct.compromiseApplication);
        }
      }
      for (AttackStep attackStep : _cacheParentAttemptFullAccessAfterSoftProdVulnerability) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepParents() {
      var tmp = super.getAttackStepParents();
      if (appSoftProduct != null) {
        tmp.add(appSoftProduct.compromiseApplication);
      }
      return tmp;
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.attemptFullAccessAfterSoftProdVulnerability");
    }
  }

  public class AttemptReadAfterSoftProdVulnerability extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAttemptReadAfterSoftProdVulnerability;

    private Set<AttackStep> _cacheParentAttemptReadAfterSoftProdVulnerability;

    public AttemptReadAfterSoftProdVulnerability(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAttemptReadAfterSoftProdVulnerability == null) {
        _cacheChildrenAttemptReadAfterSoftProdVulnerability = new HashSet<>();
        _cacheChildrenAttemptReadAfterSoftProdVulnerability.add(readAfterSoftProdVulnerability);
      }
      for (AttackStep attackStep : _cacheChildrenAttemptReadAfterSoftProdVulnerability) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepChildren() {
      var tmp = super.getAttackStepChildren();
      tmp.add(readAfterSoftProdVulnerability);
      return tmp;
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAttemptReadAfterSoftProdVulnerability == null) {
        _cacheParentAttemptReadAfterSoftProdVulnerability = new HashSet<>();
        if (appSoftProduct != null) {
          _cacheParentAttemptReadAfterSoftProdVulnerability.add(appSoftProduct.readApplication);
        }
      }
      for (AttackStep attackStep : _cacheParentAttemptReadAfterSoftProdVulnerability) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepParents() {
      var tmp = super.getAttackStepParents();
      if (appSoftProduct != null) {
        tmp.add(appSoftProduct.readApplication);
      }
      return tmp;
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.attemptReadAfterSoftProdVulnerability");
    }
  }

  public class AttemptModifyAfterSoftProdVulnerability extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAttemptModifyAfterSoftProdVulnerability;

    private Set<AttackStep> _cacheParentAttemptModifyAfterSoftProdVulnerability;

    public AttemptModifyAfterSoftProdVulnerability(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAttemptModifyAfterSoftProdVulnerability == null) {
        _cacheChildrenAttemptModifyAfterSoftProdVulnerability = new HashSet<>();
        _cacheChildrenAttemptModifyAfterSoftProdVulnerability.add(modifyAfterSoftProdVulnerability);
      }
      for (AttackStep attackStep : _cacheChildrenAttemptModifyAfterSoftProdVulnerability) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepChildren() {
      var tmp = super.getAttackStepChildren();
      tmp.add(modifyAfterSoftProdVulnerability);
      return tmp;
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAttemptModifyAfterSoftProdVulnerability == null) {
        _cacheParentAttemptModifyAfterSoftProdVulnerability = new HashSet<>();
        if (appSoftProduct != null) {
          _cacheParentAttemptModifyAfterSoftProdVulnerability.add(appSoftProduct.modifyApplication);
        }
      }
      for (AttackStep attackStep : _cacheParentAttemptModifyAfterSoftProdVulnerability) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepParents() {
      var tmp = super.getAttackStepParents();
      if (appSoftProduct != null) {
        tmp.add(appSoftProduct.modifyApplication);
      }
      return tmp;
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.attemptModifyAfterSoftProdVulnerability");
    }
  }

  public class AttemptDenyAfterSoftProdVulnerability extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAttemptDenyAfterSoftProdVulnerability;

    private Set<AttackStep> _cacheParentAttemptDenyAfterSoftProdVulnerability;

    public AttemptDenyAfterSoftProdVulnerability(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAttemptDenyAfterSoftProdVulnerability == null) {
        _cacheChildrenAttemptDenyAfterSoftProdVulnerability = new HashSet<>();
        _cacheChildrenAttemptDenyAfterSoftProdVulnerability.add(denyAfterSoftProdVulnerability);
      }
      for (AttackStep attackStep : _cacheChildrenAttemptDenyAfterSoftProdVulnerability) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepChildren() {
      var tmp = super.getAttackStepChildren();
      tmp.add(denyAfterSoftProdVulnerability);
      return tmp;
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAttemptDenyAfterSoftProdVulnerability == null) {
        _cacheParentAttemptDenyAfterSoftProdVulnerability = new HashSet<>();
        if (appSoftProduct != null) {
          _cacheParentAttemptDenyAfterSoftProdVulnerability.add(appSoftProduct.denyApplication);
        }
      }
      for (AttackStep attackStep : _cacheParentAttemptDenyAfterSoftProdVulnerability) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepParents() {
      var tmp = super.getAttackStepParents();
      if (appSoftProduct != null) {
        tmp.add(appSoftProduct.denyApplication);
      }
      return tmp;
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.attemptDenyAfterSoftProdVulnerability");
    }
  }

  public class SoftwareCheck extends Defense {
    public SoftwareCheck(String name) {
      super(name);
      disable = new Disable(name);
    }

    @Override
    public boolean isEnabled() {
      if (appSoftProduct != null) {
        return false;
      }
      return true;
    }

    public class Disable extends AttackStepMin {
      private Set<AttackStep> _cacheChildrenSoftwareCheck;

      public Disable(String name) {
        super(name);
      }

      @Override
      public void updateChildren(Set<AttackStep> attackSteps) {
        if (_cacheChildrenSoftwareCheck == null) {
          _cacheChildrenSoftwareCheck = new HashSet<>();
          _cacheChildrenSoftwareCheck.add(fullAccessAfterSoftProdVulnerability);
          _cacheChildrenSoftwareCheck.add(readAfterSoftProdVulnerability);
          _cacheChildrenSoftwareCheck.add(modifyAfterSoftProdVulnerability);
          _cacheChildrenSoftwareCheck.add(denyAfterSoftProdVulnerability);
        }
        for (AttackStep attackStep : _cacheChildrenSoftwareCheck) {
          attackStep.updateTtc(this, ttc, attackSteps);
        }
      }

      @Override
      public Set<AttackStep> getAttackStepChildren() {
        var tmp = super.getAttackStepChildren();
        tmp.add(fullAccessAfterSoftProdVulnerability);
        tmp.add(readAfterSoftProdVulnerability);
        tmp.add(modifyAfterSoftProdVulnerability);
        tmp.add(denyAfterSoftProdVulnerability);
        return tmp;
      }

      @Override
      public String fullName() {
        return "Application.softwareCheck";
      }
    }
  }

  public class FullAccessAfterSoftProdVulnerability extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenFullAccessAfterSoftProdVulnerability;

    private Set<AttackStep> _cacheParentFullAccessAfterSoftProdVulnerability;

    public FullAccessAfterSoftProdVulnerability(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenFullAccessAfterSoftProdVulnerability == null) {
        _cacheChildrenFullAccessAfterSoftProdVulnerability = new HashSet<>();
        _cacheChildrenFullAccessAfterSoftProdVulnerability.add(fullAccess);
      }
      for (AttackStep attackStep : _cacheChildrenFullAccessAfterSoftProdVulnerability) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepChildren() {
      var tmp = super.getAttackStepChildren();
      tmp.add(fullAccess);
      return tmp;
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentFullAccessAfterSoftProdVulnerability == null) {
        _cacheParentFullAccessAfterSoftProdVulnerability = new HashSet<>();
        _cacheParentFullAccessAfterSoftProdVulnerability.add(disabled.disable);
        _cacheParentFullAccessAfterSoftProdVulnerability.add(useVulnerability);
        _cacheParentFullAccessAfterSoftProdVulnerability.add(attemptFullAccessAfterSoftProdVulnerability);
        _cacheParentFullAccessAfterSoftProdVulnerability.add(softwareCheck.disable);
      }
      for (AttackStep attackStep : _cacheParentFullAccessAfterSoftProdVulnerability) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepParents() {
      var tmp = super.getAttackStepParents();
      tmp.add(disabled.disable);
      tmp.add(useVulnerability);
      tmp.add(attemptFullAccessAfterSoftProdVulnerability);
      tmp.add(softwareCheck.disable);
      return tmp;
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.fullAccessAfterSoftProdVulnerability");
    }
  }

  public class ReadAfterSoftProdVulnerability extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenReadAfterSoftProdVulnerability;

    private Set<AttackStep> _cacheParentReadAfterSoftProdVulnerability;

    public ReadAfterSoftProdVulnerability(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenReadAfterSoftProdVulnerability == null) {
        _cacheChildrenReadAfterSoftProdVulnerability = new HashSet<>();
        _cacheChildrenReadAfterSoftProdVulnerability.add(read);
      }
      for (AttackStep attackStep : _cacheChildrenReadAfterSoftProdVulnerability) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepChildren() {
      var tmp = super.getAttackStepChildren();
      tmp.add(read);
      return tmp;
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentReadAfterSoftProdVulnerability == null) {
        _cacheParentReadAfterSoftProdVulnerability = new HashSet<>();
        _cacheParentReadAfterSoftProdVulnerability.add(disabled.disable);
        _cacheParentReadAfterSoftProdVulnerability.add(useVulnerability);
        _cacheParentReadAfterSoftProdVulnerability.add(attemptReadAfterSoftProdVulnerability);
        _cacheParentReadAfterSoftProdVulnerability.add(softwareCheck.disable);
      }
      for (AttackStep attackStep : _cacheParentReadAfterSoftProdVulnerability) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepParents() {
      var tmp = super.getAttackStepParents();
      tmp.add(disabled.disable);
      tmp.add(useVulnerability);
      tmp.add(attemptReadAfterSoftProdVulnerability);
      tmp.add(softwareCheck.disable);
      return tmp;
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.readAfterSoftProdVulnerability");
    }
  }

  public class ModifyAfterSoftProdVulnerability extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenModifyAfterSoftProdVulnerability;

    private Set<AttackStep> _cacheParentModifyAfterSoftProdVulnerability;

    public ModifyAfterSoftProdVulnerability(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenModifyAfterSoftProdVulnerability == null) {
        _cacheChildrenModifyAfterSoftProdVulnerability = new HashSet<>();
        _cacheChildrenModifyAfterSoftProdVulnerability.add(modify);
      }
      for (AttackStep attackStep : _cacheChildrenModifyAfterSoftProdVulnerability) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepChildren() {
      var tmp = super.getAttackStepChildren();
      tmp.add(modify);
      return tmp;
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentModifyAfterSoftProdVulnerability == null) {
        _cacheParentModifyAfterSoftProdVulnerability = new HashSet<>();
        _cacheParentModifyAfterSoftProdVulnerability.add(disabled.disable);
        _cacheParentModifyAfterSoftProdVulnerability.add(useVulnerability);
        _cacheParentModifyAfterSoftProdVulnerability.add(attemptModifyAfterSoftProdVulnerability);
        _cacheParentModifyAfterSoftProdVulnerability.add(softwareCheck.disable);
      }
      for (AttackStep attackStep : _cacheParentModifyAfterSoftProdVulnerability) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepParents() {
      var tmp = super.getAttackStepParents();
      tmp.add(disabled.disable);
      tmp.add(useVulnerability);
      tmp.add(attemptModifyAfterSoftProdVulnerability);
      tmp.add(softwareCheck.disable);
      return tmp;
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.modifyAfterSoftProdVulnerability");
    }
  }

  public class DenyAfterSoftProdVulnerability extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenDenyAfterSoftProdVulnerability;

    private Set<AttackStep> _cacheParentDenyAfterSoftProdVulnerability;

    public DenyAfterSoftProdVulnerability(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenDenyAfterSoftProdVulnerability == null) {
        _cacheChildrenDenyAfterSoftProdVulnerability = new HashSet<>();
        _cacheChildrenDenyAfterSoftProdVulnerability.add(deny);
      }
      for (AttackStep attackStep : _cacheChildrenDenyAfterSoftProdVulnerability) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepChildren() {
      var tmp = super.getAttackStepChildren();
      tmp.add(deny);
      return tmp;
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentDenyAfterSoftProdVulnerability == null) {
        _cacheParentDenyAfterSoftProdVulnerability = new HashSet<>();
        _cacheParentDenyAfterSoftProdVulnerability.add(disabled.disable);
        _cacheParentDenyAfterSoftProdVulnerability.add(useVulnerability);
        _cacheParentDenyAfterSoftProdVulnerability.add(attemptDenyAfterSoftProdVulnerability);
        _cacheParentDenyAfterSoftProdVulnerability.add(softwareCheck.disable);
      }
      for (AttackStep attackStep : _cacheParentDenyAfterSoftProdVulnerability) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepParents() {
      var tmp = super.getAttackStepParents();
      tmp.add(disabled.disable);
      tmp.add(useVulnerability);
      tmp.add(attemptDenyAfterSoftProdVulnerability);
      tmp.add(softwareCheck.disable);
      return tmp;
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.denyAfterSoftProdVulnerability");
    }
  }

  public class AttemptApplicationRespondConnectThroughData extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAttemptApplicationRespondConnectThroughData;

    private Set<AttackStep> _cacheParentAttemptApplicationRespondConnectThroughData;

    public AttemptApplicationRespondConnectThroughData(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAttemptApplicationRespondConnectThroughData == null) {
        _cacheChildrenAttemptApplicationRespondConnectThroughData = new HashSet<>();
        for (Data _0 : transitData) {
          _cacheChildrenAttemptApplicationRespondConnectThroughData.add(_0.attemptApplicationRespondConnect);
        }
        for (Data _1 : containedData) {
          _cacheChildrenAttemptApplicationRespondConnectThroughData.add(_1.attemptApplicationRespondConnect);
        }
      }
      for (AttackStep attackStep : _cacheChildrenAttemptApplicationRespondConnectThroughData) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepChildren() {
      var tmp = super.getAttackStepChildren();
      for (Data _2 : transitData) {
        tmp.add(_2.attemptApplicationRespondConnect);
      }
      for (Data _3 : containedData) {
        tmp.add(_3.attemptApplicationRespondConnect);
      }
      return tmp;
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAttemptApplicationRespondConnectThroughData == null) {
        _cacheParentAttemptApplicationRespondConnectThroughData = new HashSet<>();
        _cacheParentAttemptApplicationRespondConnectThroughData.add(specificAccess);
        _cacheParentAttemptApplicationRespondConnectThroughData.add(fullAccess);
      }
      for (AttackStep attackStep : _cacheParentAttemptApplicationRespondConnectThroughData) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepParents() {
      var tmp = super.getAttackStepParents();
      tmp.add(specificAccess);
      tmp.add(fullAccess);
      return tmp;
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.attemptApplicationRespondConnectThroughData");
    }
  }

  public class CodeExecutionAfterVulnerability extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenCodeExecutionAfterVulnerability;

    private Set<AttackStep> _cacheParentCodeExecutionAfterVulnerability;

    public CodeExecutionAfterVulnerability(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenCodeExecutionAfterVulnerability == null) {
        _cacheChildrenCodeExecutionAfterVulnerability = new HashSet<>();
        _cacheChildrenCodeExecutionAfterVulnerability.add(fullAccess);
      }
      for (AttackStep attackStep : _cacheChildrenCodeExecutionAfterVulnerability) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepChildren() {
      var tmp = super.getAttackStepChildren();
      tmp.add(fullAccess);
      return tmp;
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentCodeExecutionAfterVulnerability == null) {
        _cacheParentCodeExecutionAfterVulnerability = new HashSet<>();
        for (Vulnerability _0 : vulnerabilities) {
          if (_0 instanceof UnknownVulnerability) {
            _cacheParentCodeExecutionAfterVulnerability.add(((org.mal_lang.joh_mal_bugs.example1.test.UnknownVulnerability) _0).codeExecution);
          }
        }
        for (Vulnerability _1 : vulnerabilities) {
          if (_1 instanceof ManualHighImpactVulnerability) {
            _cacheParentCodeExecutionAfterVulnerability.add(((org.mal_lang.joh_mal_bugs.example1.test.ManualHighImpactVulnerability) _1).impact);
          }
        }
        for (Vulnerability _2 : vulnerabilities) {
          for (Exploit _3 : _2.exploits) {
            if (_3 instanceof HHHExploit) {
              _cacheParentCodeExecutionAfterVulnerability.add(((org.mal_lang.joh_mal_bugs.example1.test.HHHExploit) _3).impact);
            }
          }
        }
      }
      for (AttackStep attackStep : _cacheParentCodeExecutionAfterVulnerability) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepParents() {
      var tmp = super.getAttackStepParents();
      for (Vulnerability _4 : vulnerabilities) {
        if (_4 instanceof UnknownVulnerability) {
          tmp.add(((org.mal_lang.joh_mal_bugs.example1.test.UnknownVulnerability) _4).codeExecution);
        }
      }
      for (Vulnerability _5 : vulnerabilities) {
        if (_5 instanceof ManualHighImpactVulnerability) {
          tmp.add(((org.mal_lang.joh_mal_bugs.example1.test.ManualHighImpactVulnerability) _5).impact);
        }
      }
      for (Vulnerability _6 : vulnerabilities) {
        for (Exploit _7 : _6.exploits) {
          if (_7 instanceof HHHExploit) {
            tmp.add(((org.mal_lang.joh_mal_bugs.example1.test.HHHExploit) _7).impact);
          }
        }
      }
      return tmp;
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.codeExecutionAfterVulnerability");
    }
  }

  public class Read extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenRead;

    private Set<AttackStep> _cacheParentRead;

    public Read(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenRead == null) {
        _cacheChildrenRead = new HashSet<>();
        for (Data _0 : containedData) {
          _cacheChildrenRead.add(_0.attemptRead);
        }
      }
      for (AttackStep attackStep : _cacheChildrenRead) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepChildren() {
      var tmp = super.getAttackStepChildren();
      for (Data _1 : containedData) {
        tmp.add(_1.attemptRead);
      }
      return tmp;
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentRead == null) {
        _cacheParentRead = new HashSet<>();
        for (Vulnerability _2 : vulnerabilities) {
          if (_2 instanceof UnknownVulnerability) {
            _cacheParentRead.add(((org.mal_lang.joh_mal_bugs.example1.test.UnknownVulnerability) _2).read);
          }
        }
        for (Vulnerability _3 : vulnerabilities) {
          if (_3 instanceof ManualLowImpactVulnerability) {
            _cacheParentRead.add(((org.mal_lang.joh_mal_bugs.example1.test.ManualLowImpactVulnerability) _3).lowImpact);
          }
        }
        for (Vulnerability _4 : vulnerabilities) {
          for (Exploit _5 : _4.exploits) {
            if (_5 instanceof AutomaticExploit) {
              _cacheParentRead.add(((org.mal_lang.joh_mal_bugs.example1.test.AutomaticExploit) _5).readImpact);
            }
          }
        }
        _cacheParentRead.add(fullAccess);
        _cacheParentRead.add(readAfterSoftProdVulnerability);
      }
      for (AttackStep attackStep : _cacheParentRead) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepParents() {
      var tmp = super.getAttackStepParents();
      for (Vulnerability _6 : vulnerabilities) {
        if (_6 instanceof UnknownVulnerability) {
          tmp.add(((org.mal_lang.joh_mal_bugs.example1.test.UnknownVulnerability) _6).read);
        }
      }
      for (Vulnerability _7 : vulnerabilities) {
        if (_7 instanceof ManualLowImpactVulnerability) {
          tmp.add(((org.mal_lang.joh_mal_bugs.example1.test.ManualLowImpactVulnerability) _7).lowImpact);
        }
      }
      for (Vulnerability _8 : vulnerabilities) {
        for (Exploit _9 : _8.exploits) {
          if (_9 instanceof AutomaticExploit) {
            tmp.add(((org.mal_lang.joh_mal_bugs.example1.test.AutomaticExploit) _9).readImpact);
          }
        }
      }
      tmp.add(fullAccess);
      tmp.add(readAfterSoftProdVulnerability);
      return tmp;
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.read");
    }
  }

  public class Modify extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenModify;

    private Set<AttackStep> _cacheParentModify;

    public Modify(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenModify == null) {
        _cacheChildrenModify = new HashSet<>();
        for (Data _0 : containedData) {
          _cacheChildrenModify.add(_0.attemptAccess);
        }
      }
      for (AttackStep attackStep : _cacheChildrenModify) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepChildren() {
      var tmp = super.getAttackStepChildren();
      for (Data _1 : containedData) {
        tmp.add(_1.attemptAccess);
      }
      return tmp;
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentModify == null) {
        _cacheParentModify = new HashSet<>();
        for (Vulnerability _2 : vulnerabilities) {
          if (_2 instanceof UnknownVulnerability) {
            _cacheParentModify.add(((org.mal_lang.joh_mal_bugs.example1.test.UnknownVulnerability) _2).modify);
          }
        }
        for (Vulnerability _3 : vulnerabilities) {
          if (_3 instanceof ManualLowImpactVulnerability) {
            _cacheParentModify.add(((org.mal_lang.joh_mal_bugs.example1.test.ManualLowImpactVulnerability) _3).lowImpact);
          }
        }
        for (Vulnerability _4 : vulnerabilities) {
          for (Exploit _5 : _4.exploits) {
            if (_5 instanceof AutomaticExploit) {
              _cacheParentModify.add(((org.mal_lang.joh_mal_bugs.example1.test.AutomaticExploit) _5).modifyImpact);
            }
          }
        }
        _cacheParentModify.add(fullAccess);
        _cacheParentModify.add(modifyAfterSoftProdVulnerability);
      }
      for (AttackStep attackStep : _cacheParentModify) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepParents() {
      var tmp = super.getAttackStepParents();
      for (Vulnerability _6 : vulnerabilities) {
        if (_6 instanceof UnknownVulnerability) {
          tmp.add(((org.mal_lang.joh_mal_bugs.example1.test.UnknownVulnerability) _6).modify);
        }
      }
      for (Vulnerability _7 : vulnerabilities) {
        if (_7 instanceof ManualLowImpactVulnerability) {
          tmp.add(((org.mal_lang.joh_mal_bugs.example1.test.ManualLowImpactVulnerability) _7).lowImpact);
        }
      }
      for (Vulnerability _8 : vulnerabilities) {
        for (Exploit _9 : _8.exploits) {
          if (_9 instanceof AutomaticExploit) {
            tmp.add(((org.mal_lang.joh_mal_bugs.example1.test.AutomaticExploit) _9).modifyImpact);
          }
        }
      }
      tmp.add(fullAccess);
      tmp.add(modifyAfterSoftProdVulnerability);
      return tmp;
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.modify");
    }
  }

  public class Deny extends Object.Deny {
    private Set<AttackStep> _cacheChildrenDeny;

    private Set<AttackStep> _cacheParentDeny;

    public Deny(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenDeny == null) {
        _cacheChildrenDeny = new HashSet<>();
        for (Data _0 : containedData) {
          _cacheChildrenDeny.add(_0.attemptDeny);
        }
        for (Data _1 : transitData) {
          _cacheChildrenDeny.add(_1.attemptDeny);
        }
        for (Application _2 : appExecutedApps) {
          _cacheChildrenDeny.add(_2.deny);
        }
      }
      for (AttackStep attackStep : _cacheChildrenDeny) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepChildren() {
      var tmp = super.getAttackStepChildren();
      for (Data _3 : containedData) {
        tmp.add(_3.attemptDeny);
      }
      for (Data _4 : transitData) {
        tmp.add(_4.attemptDeny);
      }
      for (Application _5 : appExecutedApps) {
        tmp.add(_5.deny);
      }
      return tmp;
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentDeny == null) {
        _cacheParentDeny = new HashSet<>();
        for (Vulnerability _6 : vulnerabilities) {
          if (_6 instanceof UnknownVulnerability) {
            _cacheParentDeny.add(((org.mal_lang.joh_mal_bugs.example1.test.UnknownVulnerability) _6).deny);
          }
        }
        for (Vulnerability _7 : vulnerabilities) {
          if (_7 instanceof ManualLowImpactVulnerability) {
            _cacheParentDeny.add(((org.mal_lang.joh_mal_bugs.example1.test.ManualLowImpactVulnerability) _7).lowImpact);
          }
        }
        for (Vulnerability _8 : vulnerabilities) {
          for (Exploit _9 : _8.exploits) {
            if (_9 instanceof AutomaticExploit) {
              _cacheParentDeny.add(((org.mal_lang.joh_mal_bugs.example1.test.AutomaticExploit) _9).denyImpact);
            }
          }
        }
        if (hostSystem != null) {
          _cacheParentDeny.add(hostSystem.deny);
        }
        _cacheParentDeny.add(fullAccess);
        _cacheParentDeny.add(denyAfterSoftProdVulnerability);
        if (hostApp != null) {
          _cacheParentDeny.add(hostApp.deny);
        }
        _cacheParentDeny.add(denyFromConnectionRule);
      }
      for (AttackStep attackStep : _cacheParentDeny) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepParents() {
      var tmp = super.getAttackStepParents();
      for (Vulnerability _a : vulnerabilities) {
        if (_a instanceof UnknownVulnerability) {
          tmp.add(((org.mal_lang.joh_mal_bugs.example1.test.UnknownVulnerability) _a).deny);
        }
      }
      for (Vulnerability _b : vulnerabilities) {
        if (_b instanceof ManualLowImpactVulnerability) {
          tmp.add(((org.mal_lang.joh_mal_bugs.example1.test.ManualLowImpactVulnerability) _b).lowImpact);
        }
      }
      for (Vulnerability _c : vulnerabilities) {
        for (Exploit _d : _c.exploits) {
          if (_d instanceof AutomaticExploit) {
            tmp.add(((org.mal_lang.joh_mal_bugs.example1.test.AutomaticExploit) _d).denyImpact);
          }
        }
      }
      if (hostSystem != null) {
        tmp.add(hostSystem.deny);
      }
      tmp.add(fullAccess);
      tmp.add(denyAfterSoftProdVulnerability);
      if (hostApp != null) {
        tmp.add(hostApp.deny);
      }
      tmp.add(denyFromConnectionRule);
      return tmp;
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.deny");
    }
  }

  public class DenyFromConnectionRule extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenDenyFromConnectionRule;

    private Set<AttackStep> _cacheParentDenyFromConnectionRule;

    public DenyFromConnectionRule(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenDenyFromConnectionRule == null) {
        _cacheChildrenDenyFromConnectionRule = new HashSet<>();
        _cacheChildrenDenyFromConnectionRule.add(deny);
      }
      for (AttackStep attackStep : _cacheChildrenDenyFromConnectionRule) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepChildren() {
      var tmp = super.getAttackStepChildren();
      tmp.add(deny);
      return tmp;
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentDenyFromConnectionRule == null) {
        _cacheParentDenyFromConnectionRule = new HashSet<>();
        for (var _0 : _reverseallowedApplicationConnectionsApplicationsNetwork()) {
          _cacheParentDenyFromConnectionRule.add(_0.denialOfService);
        }
        for (var _1 : _reverseallApplicationsConnectionRule()) {
          _cacheParentDenyFromConnectionRule.add(_1.denialOfService);
        }
      }
      for (AttackStep attackStep : _cacheParentDenyFromConnectionRule) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public Set<AttackStep> getAttackStepParents() {
      var tmp = super.getAttackStepParents();
      for (var _2 : _reverseallowedApplicationConnectionsApplicationsNetwork()) {
        tmp.add(_2.denialOfService);
      }
      for (var _3 : _reverseallApplicationsConnectionRule()) {
        tmp.add(_3.denialOfService);
      }
      return tmp;
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.denyFromConnectionRule");
    }
  }
}
