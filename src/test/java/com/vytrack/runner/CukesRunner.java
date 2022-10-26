package com.vytrack.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = "html:target/cucumber-report.html" ,
        features = "src/test/resources/features" ,
        glue = "com/vytrack/stepdefinition",
        dryRun = false,
        tags = "@wip"
)
public class CukesRunner {

}
