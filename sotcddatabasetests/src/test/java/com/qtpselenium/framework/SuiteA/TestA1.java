package com.qtpselenium.framework.SuiteA;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Hashtable;

import com.qtpselenium.framework.Util.Constants;
import com.qtpselenium.framework.Util.Keywords;
import com.qtpselenium.framework.Util.TestCaseDataProvider;
import com.qtpselenium.framework.Util.Utility;
import com.qtpselenium.framework.Util.Xls_Reader;

public class TestA1 {
	public static Keywords app;
	public static Logger log=null;
	public static String testName="testA";
	
	@BeforeTest
	public static void initializeTest(){
		log=Utility.initLogs(testName);
	}
		
	@Test(dataProviderClass=TestCaseDataProvider.class,dataProvider="getDataForSuiteA")
	public void testA1(Hashtable<String,String> data) throws Exception{
		String testName="TestA1";
		Xls_Reader xls = new Xls_Reader(Constants.SUITEA_XLS_PATH);
		Utility.validateTestExecution(testName,"SUITEA",data.get(Constants.RUNMODE_COL),xls);
		Keywords app = Keywords.getInstance();
		app.setLogger(log);
		app.executeKeywords(testName,xls,data);
		log.debug("Ending : "+testName);
		
	}

	@Test(dataProviderClass=TestCaseDataProvider.class,dataProvider="getDataForSuiteA")
	public void testA2(Hashtable<String,String> data) throws Exception{
		String testName="TestA2";
		Xls_Reader xls = new Xls_Reader(Constants.SUITEA_XLS_PATH);
		Utility.validateTestExecution(testName,"SUITEA",data.get(Constants.RUNMODE_COL),xls);
		Keywords app = Keywords.getInstance();
		app.setLogger(log);
		app.executeKeywords(testName,xls,data);
		log.debug("Ending : "+testName);
		
	}
	
	@Test(dataProviderClass=TestCaseDataProvider.class,dataProvider="getDataForSuiteA")
	public void ActiveShowsTest(Hashtable<String,String> data) throws Exception{
		String testName="ActiveShowsTest";
		Xls_Reader xls = new Xls_Reader(Constants.SUITEA_XLS_PATH);
		Utility.validateTestExecution(testName,"SUITEA",data.get(Constants.RUNMODE_COL),xls);
		Keywords app = Keywords.getInstance();
		app.setLogger(log);
		app.executeKeywords(testName,xls,data);
		log.debug("Ending : "+testName);
	
	}
	
	@Test(dataProviderClass=TestCaseDataProvider.class,dataProvider="getDataForSuiteA")
	public void testA4(Hashtable<String,String> data) throws Exception{
		String testName="TestA4";
		Xls_Reader xls = new Xls_Reader(Constants.SUITEA_XLS_PATH);
		Utility.validateTestExecution(testName,"SUITEA",data.get(Constants.RUNMODE_COL),xls);
		Keywords app = Keywords.getInstance();
		app.setLogger(log);
		app.executeKeywords(testName,xls,data);
		log.debug("Ending : "+testName);
		
	}
	
}
