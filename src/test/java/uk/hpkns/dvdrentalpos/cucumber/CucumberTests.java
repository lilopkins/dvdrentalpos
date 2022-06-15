package uk.hpkns.dvdrentalpos.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty" },
    features = "src/test/resources/cucumber",
    glue = "uk.hpkns.dvdrentalpos.cucumber")
public class CucumberTests { }
