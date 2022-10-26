package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US1_pages {

    public US1_pages(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@id='prependedInput']")
    public WebElement usernameBox;

    @FindBy(xpath = "//input[@id='prependedInput2']")
    public WebElement passwordBox;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement logInButton;

    @FindBy(xpath = "(//span[@class='title title-level-1'])[2]")
    public WebElement fleetDropdown;

    @FindBy(xpath = "(//span[@class='title title-level-1'])[1]")
    public WebElement fleetDropdownAsDriver;

    @FindBy(xpath = "//*[@id=\"user-menu\"]/ul/li[4]/a")
    public WebElement logOutButton;

}

