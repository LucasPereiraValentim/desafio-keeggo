package br.com.keeggo.projectkeeggo.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features",
				glue = {"br.com.keeggo.projectkeeggo.step"}, //
				tags = "@PWK_0001" //
				)
public class WebRunner {

}
