package de.sea2p.klausurenService.stepDef;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/feature/resource/spieler_zieht_karten.feature"})
public class CucumberRunner {

}
