package com.autohero.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import net.thucydides.core.reports.html.HtmlAggregateStoryReporter;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;


// added some
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/",
        glue={"com.autohero.cucumber"}
)
@Test
public class Runner {


    // cooment added
    @AfterClass
    public static void generateReports() throws IOException {
        HtmlAggregateStoryReporter html = new HtmlAggregateStoryReporter("");
        File currentDir = new File("");
        File serenityRoot = new File(currentDir.getAbsolutePath() + "/target/site/serenity");
        html.setOutputDirectory(serenityRoot);
        html.generateReportsForTestResultsFrom(serenityRoot);
    }
}
