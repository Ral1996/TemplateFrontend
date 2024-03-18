package com.ral1996.sv;

/*
    Developer: Mts. Ing. Raúl Mauricio Portillo Muñoz
    Description: Can you use this Class for run tests and indicate rutes for Steps and Features
 */

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/",
        glue = "com.ral1996.sv.steps",
        tags = "@EndpointGETWithParameter"
)

public class RunnerTest {  }
