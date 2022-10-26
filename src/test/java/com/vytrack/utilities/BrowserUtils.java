package com.vytrack.utilities;


public class BrowserUtils {
    // methods are static. because we do not want to crate an object to call these methods we just want these methods with class name
    public static void sleep(int seconds){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Method info:
     *     Name: verifyTitle()
     *     Return type: void
     *     Arg1: WebDriver
     *     Arg2: String expectedTitle
     */

}
