package com.qa.DemoSiteCucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/com/qa/DemoSiteCucumber", 
glue = "com.qa.DemoSiteCucumber",
tags = "not @ignore",
plugin ={"pretty"})
public class RunCucumberTest {

}
