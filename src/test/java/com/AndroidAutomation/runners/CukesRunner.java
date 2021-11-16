package com.AndroidAutomation.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber.json" },
        features = "src/test/resources/features/",
        glue = "com/automation/Android/Step_definitions/",
        dryRun = false


)
public class CukesRunner {
}


