package junitDate.test;

import static org.testng.Assert.assertEquals;

import java.util.Date;
import java.util.GregorianCalendar;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junitDate.service.DateCalculator;

public class DateStep {
    private String result;
    private DateCalculator calculator;

    @Given("^today is date (\\d+)-(\\d+)-(\\d+)$")
    public void today_is_date(int arg1, int arg2, int arg3) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    	Date date = new GregorianCalendar(arg1, arg2, arg3).getTime();
    	
   	 calculator = new DateCalculator(date);
    }
    

@When("^I ask if Jan (\\d+), (\\d+) is in the past$")
public void i_ask_if_Jan_is_in_the_past(int a1, int a2) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	Date date = new GregorianCalendar(a1, 1, a2).getTime();
	 result = calculator.isDateInThePast(date);
}

@Then("the result should be (.+)")
public void the_result_should_be(String expectedResult) {
    assertEquals(expectedResult, result);
}

}