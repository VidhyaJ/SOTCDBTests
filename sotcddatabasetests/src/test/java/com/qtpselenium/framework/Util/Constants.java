package com.qtpselenium.framework.Util;

public class Constants {
	// paths
	public static final String SUITEA_XLS_PATH = System.getProperty("user.dir")+"\\executioninfo\\input-data\\SuiteA.xlsx";
	public static final String TESTSUITE_XLS_PATH = System.getProperty("user.dir")+"\\executioninfo\\input-data\\TestSuite.xlsx";
	public static final String PROPERTIES_FILE_PATH = System.getProperty("user.dir")+"//src//test//resources//project.properties";
	public static final String CHROMEDRIVER_EXE_PATH=System.getProperty("user.dir")+"//src//test//resources//chromedriver.exe";
	public static final String SCREENSHOT_PATH=System.getProperty("user.dir")+"\\executioninfo\\screenshots\\";
	// sheet names
	public static final String TESTSUITE_SHEET = "TestSuite";
	public static final String TestData_SHEET = "TestData";
	public static final String TESTCASES_SHEET = "TestCases";
	public static final String KEYWORDS_SHEET = "Keywords";


	// col names
	public static final String SUITENAME_COL = "SuiteName";
	public static final String RUNMODE_COL = "Runmode";
	public static final String TESTCASENAME_COL = "TestCaseName";
	public static final Object BROWSER_COL = "Browser";;

	
	
	// runmodes
	public static final String RUNMODE_YES="Y";
	public static final String RUNMODE_NO="N";
	public static final Object ITERATION_COL = "Iteration";
	
	
	public static final String PASS = "PASS";
	public static final String FAIL = "FAIL";
	public static final String MOZILLA = "mozilla";
	public static final String CHROME = "chrome";
	public static final String IE = "IE";
	public static final String RANDOM_VALUE = "random";

	//error message
	public static final String OPENBROWSER_ERROR = "ERROR - FAILED TO OPEN BROWSER - ";
	
	// failure
	public static final String ELEMENT_NOT_FOUND_FAILURE = "FAIL - ELEMENT NOT FOUND - ";
	
	

	

}
