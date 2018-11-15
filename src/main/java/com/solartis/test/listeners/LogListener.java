package com.solartis.test.listeners;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.solartis.test.testRunners.MainTestRunner;


public class LogListener /*implements Listener*/
{
	private static Logger Log;
	static
	{
		String log4jConfigFile = "src/main/java/log4j.properties";
		PropertyConfigurator.configure(log4jConfigFile);
		Log = Logger.getLogger(MainTestRunner.class);
	}
	

	public void beforeLoadSampleRequest()
	{
		//System.out.println("beforeLoadSampleRequest");
		Log.info("beforeLoadSampleRequest");
	}


	public void afterLoadSampleRequest() 
	{
		//System.out.println("afterLoadSampleRequest");
		Log.info("afterLoadSampleRequest");
	}


	public void beforePumpDataToRequest()
	{
		//System.out.println("beforePumpDataToRequest");
		Log.info("beforePumpDataToRequest");
	}


	public void afterPumpDataToRequest() 
	{
		//System.out.println("afterPumpDataToRequest");
		Log.info("afterPumpDataToRequest");
	}

	public void beforeRequestToString()
	{
		//System.out.println("beforeRequestToString");
		Log.info("beforeRequestToString");
	}


	public void afterRequestToString() 
	{
		//System.out.println("afterRequestToString");
		Log.info("afterRequestToString");
	}


	public void beforeAddHeaders(String Token)
	{
		//System.out.println("beforeAddHeaders");
		Log.info("beforeAddHeaders");
	}


	public void afterAddHeaders(String Token) 
	{
		//System.out.println("afterAddHeaders");
		Log.info("afterAddHeaders");
	}


	public void beforeSendAndReceiveData()
	{
		//System.out.println("beforeSendAndReceiveData");
		Log.info("beforeSendAndReceiveData");
	}


	public void afterSendAndReceiveData() 
	{
		//System.out.println("afterSendAndReceiveData");
		Log.info("afterSendAndReceiveData");
	}
	

	public void beforeResponseToString()
	{
		//System.out.println("beforeResponseToString");
		Log.info("beforeResponseToString");
	}


	public void afterResponseToString() 
	{
		//System.out.println("afterResponseToString");
		Log.info("afterResponseToString");
	}


	public void beforeSendResponseDataToFile()
	{
		//Log.info("beforeSendResponseDataToFile");
	}


	public void afterSendResponseDataToFile() 
	{
		//System.out.println("afterSendResponseDataToFile");
		Log.info("afterSendResponseDataToFile");
	}


	public void beforeCompareFunction() 
	{
		//System.out.println("beforeCompareFunction");
		Log.info("beforeCompareFunction");
	}


	public void afterCompareFunction() 
	{
		//System.out.println("afterCompareFunction");
		Log.info("afterCompareFunction");
	}


	public void onError(Throwable e)
	{
		//System.out.println("Printed by Listener");
		System.out.println(e.getMessage()+"--"+e.getCause().getMessage()+"--"+e.getCause().getCause().getMessage());
		Log.error(e.getMessage()+"--"+e.getCause().getMessage()+"--"+e.getCause().getCause().getMessage());
		Log.error(e);
		e.printStackTrace();
	}


	public void beforeTokenGenerator() {
		// TODO Auto-generated method stub
		Log.info("beforeTokenGenerator");
	}


	public void afterTokenGeneratior() {
		// TODO Auto-generated method stub
		Log.info("afterTokenGeneratior");
	}


	public void beforedifferrence() {
		// TODO Auto-generated method stub
		Log.info("beforedifference");
	}


	public void afterdifferrence() {
		// TODO Auto-generated method stub
		Log.info("afterdifference");
	}
}
