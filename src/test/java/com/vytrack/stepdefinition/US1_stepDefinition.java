package com.vytrack.stepdefinition;

import com.vytrack.pages.US1_pages;
import com.vytrack.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class US1_stepDefinition {

    US1_pages us1_pages = new US1_pages();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 15);

    @Given("User is on Log In Page")
    public void user_is_on_log_in_page() {
        Driver.getDriver().get("https://qa1.vytrack.com/user/login");
    }

    @When("User clicks on login button")
    public void user_clicks_on_login_button() throws InterruptedException {
        us1_pages.logInButton.click();
        Thread.sleep(3000);
    }

    @Given("user enters user and password as store or sales manager, {string}, {string}")
    public void userEntersUserAndPasswordAsStoreSalesManager(String user, String pass) {

        us1_pages.usernameBox.sendKeys(user);
        us1_pages.passwordBox.sendKeys(pass);

    }

    @Then("User is on Home Page, expected title Dashboard")
    public void userIsOnHomePageExpectedTitleDashboard() {
        Assert.assertEquals("Dashboard", Driver.getDriver().getTitle());
    }

    @Given("Verify user sees eight modules: Dashboards, Fleet, Customers, Sales, Activities, Marketing, Reports & Segments, System")
    public void verify_user_sees_modules_dashboards_fleet_customers_sales_activities_marketing_reports_segments_system() {
        wait.until(ExpectedConditions.visibilityOf(us1_pages.fleetDropdown));
        List<WebElement> list = Driver.getDriver().findElements(By.xpath("(//div[@id='main-menu']//ul)[1]//li//span[@class='title title-level-1']"));
        String str = "Dashboards\nFleet\nCustomers\nSales\nActivities\nMarketing\nReports & Segments\nSystem";
        String str2 = "";

        for (WebElement each : list) {
            str2 += each.getText() + "\n";
        }

        str2 = str2.trim();

        Assert.assertEquals(str, str2);

    }

    @Given("drivers should view four module names: Expected module names: Fleet, Customers, Activities, System")
    public void drivers_should_view_module_names_expected_module_names_fleet_customers_activities_system() {
        wait.until(ExpectedConditions.visibilityOf(us1_pages.fleetDropdownAsDriver));

        List<WebElement> list = Driver.getDriver().findElements(By.xpath("(//span[@class='title title-level-1'])"));
        String str = "Fleet\nCustomers\nActivities\nSystem";
        String str2 = "";

        for (WebElement each : list) {
            str2 += each.getText() + "\n";
        }

        str2 = str2.trim();

        Assert.assertEquals(str, str2);
    }

    @Given("User enters user and password, {string}, {string}")
    public void userEntersUserAndPassword(String user, String pass) {

        us1_pages.usernameBox.sendKeys(user);
        us1_pages.passwordBox.sendKeys(pass);

    }

    @Then("user logs out")
    public void userLogsOut() {
        Driver.getDriver().findElement(By.xpath("//*[@id=\"user-menu\"]/a")).click();
        us1_pages.logOutButton.click();
    }
}
