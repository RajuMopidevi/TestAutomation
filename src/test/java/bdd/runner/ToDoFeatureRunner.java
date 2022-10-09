package bdd.runner;

import io.cucumber.testng.CucumberOptions;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = { "classpath:featurefile/ToDo.feature" }, 
		glue = {"classpath:bdd.steps","classpath:fw.driver","classpath:listeners.reportlistener.CucumberReport"  }, 
		plugin = { "pretty","json:target/ToDoFeatureRunner.json" })
public class ToDoFeatureRunner extends AbstractTestNGCucumberTests {
	@Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

}
