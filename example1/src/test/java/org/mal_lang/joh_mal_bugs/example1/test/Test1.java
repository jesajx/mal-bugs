package org.mal_lang.joh_mal_bugs.example1.test;

import core.*;
import org.junit.jupiter.api.Test;

public class Test1 extends Base {
    @Test
    void test1() {
        var asset = new ChildAsset("asset");
        attack(asset.attemptAbuse);

        asset.attemptAbuse.assertCompromisedInstantaneously();
        asset.meh.assertCompromisedInstantaneously();
        asset.abuse.assertCompromisedInstantaneously(); // TODO fails
        //
        // 10 remaining explanation steps. didn't reach asset.abuse [1.7976931348623157E308] (AND) because
        // 9 remaining explanation steps.    but did reach asset.attemptAbuse [0.0].
        // 9 remaining explanation steps.    but did reach asset.meh [0.0].
        //
    }
}
