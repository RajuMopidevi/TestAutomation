package fw.interfaces;

import io.cucumber.testng.AbstractTestNGCucumberTests;

@io.cucumber.testng.CucumberOptions(glue = "stepdefs", features = ".")
public class RunnerIT extends AbstractTestNGCucumberTests{

}