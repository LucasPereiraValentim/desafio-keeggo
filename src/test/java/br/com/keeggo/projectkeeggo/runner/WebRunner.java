package br.com.keeggo.projectkeeggo.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features",
				glue = {"br.com.keeggo.projectkeeggo.step.cadastro"}, //
				tags = "@ValidarCadastro and @PWK_0001", //
				monochrome = true //
				)
public class WebRunner {

}
