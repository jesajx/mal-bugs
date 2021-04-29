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

//
//package org.mal_lang.iotlang.test;
//
//import org.junit.jupiter.api.AfterEach;
//
//import core.*;
//import org.mal_lang.iotlang.test.*;
//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.fail;
//
//import java.util.HashSet;
//import java.util.HashMap;
//
//import org.mal_lang.attack_graph_visualizer.AttackGraphVisualizer;
//import org.mal_lang.attack_graph_visualizer.AssetGraphVisualizer;
//
//
//
//public class Base {
//
//    @AfterEach
//    public void deleteModel() {
//        Asset.allAssets.clear();
//        AttackStep.allAttackSteps.clear();
//        Defense.allDefenses.clear();
//    }
//
//    void println() {
//        java.lang.System.out.println();
//    }
//
//    void println(String... args) {
//        var first = true;
//        for (var x : args) {
//            if (!first) {
//                java.lang.System.out.print(" ");
//            }
//            java.lang.System.out.print(x);
//            first = false;
//        }
//        java.lang.System.out.println();
//    }
//
//
//    public void con(Application src, ConnectionRule dst) {
//        // app is client-like (outgoing)
//        src.addOutgoingAppConnections(dst);
//    }
//    public void con(ConnectionRule src, Application dst) {
//        // app is server-like (incoming)
//        dst.addIngoingAppConnections(src);
//    }
//
//    public void con(IotNetwork src, ConnectionRule dst) {
//        // net is client-like (outgoing)
//        src.addOutgoingNetConnections(dst);
//    }
//    public void con(ConnectionRule src, IotNetwork dst) {
//        // net is server-like (incoming)
//        dst.addIngoingNetConnections(src);
//    }
//
//    public void con(Application src, ConnectionRule conrule, IotNetwork dst) {
//        con(src, conrule);
//        con(conrule, dst);
//    }
//    public void con(IotNetwork src, ConnectionRule conrule, Application dst) {
//        con(src, conrule);
//        con(conrule, dst);
//    }
//
//    public void con(IotNetwork src, ConnectionRule conrule, IotNetwork dst) {
//        con(src, conrule);
//        con(conrule, dst);
//    }
//
//    public void conbi(Application src, ConnectionRule conrule, IotNetwork dst) {
//        con(src, conrule, dst);
//        con(dst, conrule, src);
//    }
//    public void conbi(IotNetwork src, ConnectionRule conrule, Application dst) {
//        con(src, conrule, dst);
//        con(dst, conrule, src);
//    }
//
//    public void conbi(IotNetwork src, ConnectionRule conrule, IotNetwork dst) {
//        con(src, conrule, dst);
//        con(dst, conrule, src);
//    }
//
//    public void transferData(IotNetwork medium, Data data) {
//        data.addTransitNetwork(medium);
//    }
//    public void transferData(Application medium, Data data) {
//        data.addTransitApp(medium);
//    }
//
//    public void execData(Data code, SoftwareProduct product, Application app) {
//        product.addOriginData(code);
//        product.addSoftApplications(app);
//    }
//
//    public void aOwnsB(Identity a, Identity b) {
//        a.addParentId(b);
//    }
//
//    public void containerAdd(PhysicalZone container, System inside) {
//        container.addSystems(inside);
//    }
//
//    public void containerAdd(System container, Application inside) {
//        container.addSysExecutedApps(inside);
//    }
//
//    public void containerAdd(System container, Data inside) {
//        container.addSysData(inside);
//    }
//
//    public void containerAdd(Application container, Application inside) {
//        container.addAppExecutedApps(inside);
//    }
//
//    public void containerAdd(Application container, Data inside) {
//        container.addContainedData(inside);
//    }
//
//    public void containerAdd(Data container, Data inside) {
//        container.addContainedData(inside);
//    }
//
//    public void containerAdd(Data container, Information inside) {
//        container.addInformation(inside);
//    }
//
//    // TODO merging smaller models into giant model? e.g. one function per
//    // LAN, and then connect them, together through internet.
//
//    // TODO common functions for iot devices (set up hw-sw, firmware, phys, radio, root password, etc.)
//
//    // Attack Vector:       Local(L) / IotNetwork(N)                 // Local means physical access to the System -> Application.localConnect. Else: IotNetwork -> Application.networkConnect.
//    // Attack Complexity:   Low(L)   / High(H)                    // Complexity affects TTC of the attack. High complexity takes longer.
//    // Privileges Required: None(N)  / Low(L)      / High(H)      // Does the attacker TODO
//    // User interaction:    None(N)  / Requires(R)                // Adds the Defense edge: Vulnerability.userInteracts.disabled (defense) -> Vulnerability.abuse. So you can turn the vuln. on/off using userInteracts on/off.
//
//    public NHNNVulnerability mkvulnNetworkComplex(String name) {
//        return new NHNNVulnerability(name);
//    }
//
//    String[] cvssAttackVectors = new String[]{"Local", "IotNetwork"};
//
//    public String cvssAttackVectorCode(String attackVector) {
//        switch (attackVector) {
//            case   "Local": return "L";
//            case "IotNetwork": return "N";
//        }
//        throw new RuntimeException("TODO");
//    }
//
//    String[] cvssAttackComplexities = new String[]{"Low", "High"};
//    public String cvssAttackComplexityCode(String attackComplexity) {
//        switch (attackComplexity) {
//            case  "Low": return "L";
//            case "High": return "H";
//        }
//        throw new RuntimeException("TODO");
//    }
//
//    String[] cvssPrivilegesRequired = new String[]{"None", "Low", "High"};
//    public String cvssPriviliegesRequiredCode(String privilegesRequired) {
//        switch (privilegesRequired) {
//            case "None": return "N";
//            case  "Low": return "L";
//            case "High": return "H";
//        }
//        throw new RuntimeException("TODO");
//    }
//
//    String[] cvssUseInteraction = new String[]{"None", "Required"};
//    public String cvssUserInteractionCode(String userInteraction) {
//        switch (userInteraction) {
//            case "None":     return "N";
//            case "Required": return "R";
//        }
//        throw new RuntimeException("TODO");
//    }
//
//    public String mkvulncode(String attackVector, String attackComplexity, String privilegesRequired, String userInteraction) {
//        return (cvssAttackVectorCode(attackVector) +
//                cvssAttackComplexityCode(attackComplexity) +
//                cvssPriviliegesRequiredCode(privilegesRequired) +
//                cvssUserInteractionCode(userInteraction));
//    }
//
//    public Vulnerability mkvuln(String name, String attackVector, String attackComplexity, String privilegesRequired, String userInteraction) {
//        var code = mkvulncode(attackVector, attackComplexity, privilegesRequired, userInteraction);
//        switch (code) {
//            case "LLNN": return new LLNNVulnerability(name, false, false);
//            case "LLNR": return new LLNRVulnerability(name, false, false);
//            case "LLLN": return new LLLNVulnerability(name, false, false);
//            case "LLLR": return new LLLRVulnerability(name, false, false);
//            case "LLHN": return new LLHNVulnerability(name, false, false);
//            case "LLHR": return new LLHRVulnerability(name, false, false);
//            case "LHLN": return new LHLNVulnerability(name, false, false);
//            case "LHLR": return new LHLRVulnerability(name, false, false);
//            case "LHNN": return new LHNNVulnerability(name, false, false);
//            case "LHNR": return new LHNRVulnerability(name, false, false);
//            case "LHHN": return new LHHNVulnerability(name, false, false);
//            case "LHHR": return new LHHRVulnerability(name, false, false);
//            case "NLNN": return new NLNNVulnerability(name, false, false);
//            case "NLNR": return new NLNRVulnerability(name, false, false);
//            case "NLLN": return new NLLNVulnerability(name, false, false);
//            case "NLLR": return new NLLRVulnerability(name, false, false);
//            case "NLHN": return new NLHNVulnerability(name, false, false);
//            case "NLHR": return new NLHRVulnerability(name, false, false);
//            case "NHNN": return new NHNNVulnerability(name, false, false);
//            case "NHNR": return new NHNRVulnerability(name, false, false);
//            case "NHLN": return new NHLNVulnerability(name, false, false);
//            case "NHLR": return new NHLRVulnerability(name, false, false);
//            case "NHHN": return new NHHNVulnerability(name, false, false);
//            case "NHHR": return new NHHRVulnerability(name, false, false);
//        }
//        throw new RuntimeException("TODO");
//    }
//
//    public NLNNVulnerability mkvulnNetworkSimple(String name) {
//        return new NLNNVulnerability(name);
//    }
//
//    public LLNNVulnerability mkvulnLocalSimple(String name) {
//        return new LLNNVulnerability(name);
//    }
//
//    public void addApiReadAccess(Identity id, Data data) {
//        id.addReadPrivData(data);
//    }
//
//    public void addApiWriteAccess(Identity id, Data data) {
//        id.addWritePrivData(data);
//    }
//
//    public void addApiUser(Application app, Identity id) {
//        id.addLowPrivApps(app);
//    }
//
//    public void addApiWriteUser(Application app, Identity id) {
//        id.addLowPrivApps(app);
//    }
//
//    public void addApiExecUser(Application app, Identity id) {
//        id.addHighPrivApps(app);
//    }
//
//    public void addApiData(Application app, Data data) {
//        containerAdd(app, data);
//    }
//
//    public void mkReadApi(Application app, Identity id, Data data) {
//        addApiUser(app, id);
//        addApiData(app, data);
//        addApiReadAccess(id, data);
//    }
//
//    public void mkWriteApi(Application app, Identity id, Data data) {
//        addApiUser(app, id);
//        addApiData(app, data);
//        addApiWriteAccess(id, data);
//    }
//
//
//    public void mkExecApi(Application app, Identity id) {
//        addApiExecUser(app, id);
//    }
//
//    public void appExecAs(Application app, Identity id) {
//        id.addExecPrivApps(app);
//    }
//
//    public void copy(IotData src, IotData dst) {
//        src.addCopyDst(dst);
//    }
//
//    public void compromised(int zeroIfUncompromised, AttackStep step) {
//        boolean isCompromised = (zeroIfUncompromised != 0);
//        compromised(isCompromised, step);
//    }
//
//    public void compromised(boolean isCompromised, AttackStep step) {
//        boolean actuallyCompromised = (step.ttc != AttackStep.infinity);
//
//        if (isCompromised != actuallyCompromised) {
//            java.lang.System.out.println(step.fullName() + ": fail");
//            fail();
//        }
//    }
//
//    public ConnectionRule autocon(String name, Application src, IotNetwork dst) {
//        var connectionRule = new OutgoingConnection(name);
//        con(src, connectionRule);
//        con(connectionRule, dst);
//        return connectionRule;
//    }
//    public ConnectionRule autocon(String name, IotNetwork src, Application dst) {
//        var connectionRule = new OpenPort(name);
//        con(src, connectionRule);
//        con(connectionRule, dst);
//        return connectionRule;
//    }
//
//    public ConnectionRule autocon(String name, IotNetwork src, IotNetwork dst) {
//        var connectionRule = new OneWayConnectionRule(name);
//        con(src, connectionRule);
//        con(connectionRule, dst);
//        return connectionRule;
//    }
//
//    public ConnectionRule autoconbi(String name, Application src, IotNetwork dst) {
//        var connectionRule = new TwoWayConnectionRule(name);
//        con(src, connectionRule, dst);
//        con(dst, connectionRule, src);
//        return connectionRule;
//    }
//
//    public ConnectionRule autoconbi(String name, IotNetwork src, Application dst) {
//        var connectionRule = new TwoWayConnectionRule(name);
//        con(src, connectionRule, dst);
//        con(dst, connectionRule, src);
//        return connectionRule;
//    }
//
//    public ConnectionRule autoconbi(String name, IotNetwork src, IotNetwork dst) {
//        var connectionRule = new TwoWayConnectionRule(name);
//        con(src, connectionRule, dst);
//        con(dst, connectionRule, src);
//        return connectionRule;
//    }
//
//}
