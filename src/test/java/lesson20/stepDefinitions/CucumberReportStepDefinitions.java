package lesson20.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import lesson20.pages.CucumberReportPage;
import lesson20.utilities.Driver;
import lesson20.utilities.ReusableMethods;

import java.time.Duration;


public class CucumberReportStepDefinitions {

    CucumberReportPage locate=new CucumberReportPage();

    @When("the user closes the cookies pop-up")
    public void the_user_closes_the_cookies_pop_up() {
        try{
            locate.cookies.click();
        }catch (Exception e){
            ReusableMethods.clickJSElementWithJavaScript("document.querySelector(\"#__next > div.sc-927cf94c-0.kpliOC > div > div.sc-927cf94c-3.hAPxep > div:nth-child(1) > button\")");

        }
    }

    @Given("the user navigates to the getir website")
    public void theUserNavigatesToTheGetirWebsite() {
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Driver.getDriver().get("https://getir.com/");
        System.out.println("Getir page is navigated");
    }
}