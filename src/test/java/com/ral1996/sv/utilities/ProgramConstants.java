package com.ral1996.sv.utilities;

/*
    Developer: Mts. Ing. Raúl Mauricio Portillo Muñoz
    Description: Can you use this final class to save variables as constants and
                 then use them for other files that require it
 */

public final class ProgramConstants {

    public ProgramConstants() { }

    //  Constants for files ".properties"
    public static final String BASE_URL = "base.url";
    public static final String USER_SITE = "user.site";
    public static final String PASS_SITE = "pass.site";

    // Constants for class "Saucelabs"
    public static final String SET_PLATFORM_NAME = "Windows 11";
    public static final String SET_BROWSER_VERSION = "latest";
    public static final String SAUCE_OPTION_USERNAME = "username";
    public static final String SAUCE_OPTION_ACCESSKEY = "accessKey";
    public static final String SAUCE_OPTION_BUILD = "build";
    public static final String SAUCE_OPTION_TESTNAME = "name";
    public static final String SAUCE_OPTIONS = "sauce:options";
    public static final String SAUCE_HUB = "https://ondemand.us-west-1.saucelabs.com:443/wd/hub";


}
