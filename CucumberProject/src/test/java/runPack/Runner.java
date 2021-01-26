package runPack;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.vimalselvam.cucumber.listener.Reporter;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features={"src/test/resources"}, glue= {"stepDefs"},tags="@FergTest1", plugin={"pretty","html:target/Destination.html"} )
public class Runner {
	 
	
}
/**
 * For cucumber frameworks, you need,:
 * 
 * Step definition files
 * Feature files - gherkins statements
 * Base file or classes
 * runner class or run pack
 */