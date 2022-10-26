package com.vytrack.stepdefinition;

import com.vytrack.utilities.Driver;
import org.junit.After;

public class hooks {

    @After
    public void tearDownScenario(){
        Driver.closeDriver();
    }

}
