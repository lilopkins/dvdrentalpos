package uk.hpkns.dvdrentalpos.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty", "html:target/cucumber-report.html" },
    features = "src/test/resources/cucumber/api",
    glue = "uk.hpkns.dvdrentalpos.cucumber")
public class CucumberTests { }
