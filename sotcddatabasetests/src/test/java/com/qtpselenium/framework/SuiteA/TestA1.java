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
	public static String domainname;
	
	@BeforeTest
	public static void initializeTest(){
		log=Utility.initLogs(testName);
	}
		
	@Test(dataProviderClass=TestCaseDataProvider.class,dataProvider="getDataForSuiteA")
	public void getDbforDomain(Hashtable<String,String> data){
		
	}
	
	@Test(dataProviderClass=TestCaseDataProvider.class,dataProvider="getDataForSuiteA")
	public void SetUpDbConnection(Hashtable<String,String> data) throws Exception{
		String testName="SetUpDbConnection";
		Xls_Reader xls = new Xls_Reader(Constants.SUITEA_XLS_PATH);
		Utility.validateTestExecution(testName,"SUITEA",data.get(Constants.RUNMODE_COL),xls);
		Keywords app = Keywords.getInstance();
		app.setLogger(log);
		app.executeKeywords(testName,xls,data);
		log.debug("Ending : "+testName);
		
	}

	@Test(dataProviderClass=TestCaseDataProvider.class,dataProvider="getDataForSuiteA",dependsOnMethods = { "SetUpDbConnection" })
	public void GetAsset_Shows_Users_Count(Hashtable<String,String> data) throws Exception{
		String testName="GetAsset_Shows_Users_Count";
		Xls_Reader xls = new Xls_Reader(Constants.SUITEA_XLS_PATH);
		Utility.validateTestExecution(testName,"SUITEA",data.get(Constants.RUNMODE_COL),xls);
		Keywords app = Keywords.getInstance();
		app.setLogger(log);
		app.executeKeywords(testName,xls,data);
		log.debug("Ending : "+testName);
		
	}
	
	@Test(dataProviderClass=TestCaseDataProvider.class,dataProvider="getDataForSuiteA",dependsOnMethods = { "SetUpDbConnection" })
	public void ActiveShowsCountTest(Hashtable<String,String> data) throws Exception{
		String testName="ActiveShowsCountTest";
		Xls_Reader xls = new Xls_Reader(Constants.SUITEA_XLS_PATH);
		Utility.validateTestExecution(testName,"SUITEA",data.get(Constants.RUNMODE_COL),xls);
		Keywords app = Keywords.getInstance();
		app.setLogger(log);
		app.executeKeywords(testName,xls,data);
		log.debug("Ending : "+testName);
	
	}
	
	@Test(dataProviderClass=TestCaseDataProvider.class,dataProvider="getDataForSuiteA",dependsOnMethods = { "SetUpDbConnection" })
	public void ActiveShowsListTest(Hashtable<String,String> data) throws Exception{
		String testName="ActiveShowsListTest";
		Xls_Reader xls = new Xls_Reader(Constants.SUITEA_XLS_PATH);
		Utility.validateTestExecution(testName,"SUITEA",data.get(Constants.RUNMODE_COL),xls);
		Keywords app = Keywords.getInstance();
		app.setLogger(log);
		app.executeKeywords(testName,xls,data);
		log.debug("Ending : "+testName);
	
	}

	@Test(dataProviderClass=TestCaseDataProvider.class,dataProvider="getDataForSuiteA",dependsOnMethods = { "SetUpDbConnection" })
	public void GetAssetsinShowTest(Hashtable<String,String> data) throws Exception{
		String testName="GetAssetsinShowTest";
		Xls_Reader xls = new Xls_Reader(Constants.SUITEA_XLS_PATH);
		Utility.validateTestExecution(testName,"SUITEA",data.get(Constants.RUNMODE_COL),xls);
		Keywords app = Keywords.getInstance();
		app.setLogger(log);
		app.executeKeywords(testName,xls,data);
		log.debug("Ending : "+testName);
	
	}

	
	
	@Test(dataProviderClass=TestCaseDataProvider.class,dataProvider="getDataForSuiteA")
	public void CloseDbConnection(Hashtable<String,String> data) throws Exception{
		String testName="CloseDbConnection";
		Xls_Reader xls = new Xls_Reader(Constants.SUITEA_XLS_PATH);
		Utility.validateTestExecution(testName,"SUITEA",data.get(Constants.RUNMODE_COL),xls);
		Keywords app = Keywords.getInstance();
		app.setLogger(log);
		app.executeKeywords(testName,xls,data);
		log.debug("Ending : "+testName);
		
	}
	
}
