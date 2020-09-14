package Test.prac;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "E:\\suma-testing\\SumaFlipkartSelenium\\src\\main\\java\\Test\\prac\\test.feature"
        ,glue={"defn"}
        )

public class Runner {

}
