package com.solartis.test.common;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import com.solartis.test.Configuration.PropertiesHandle;
import com.solartis.test.exceptions.APIException;
import com.solartis.test.exceptions.DatabaseException;
import com.solartis.test.util.api.DBColoumnVerify;
import com.solartis.test.util.api.HttpHandle;
import com.solartis.test.util.api.JsonHandle;
import com.solartis.test.util.api.RequestHandler;
import com.solartis.test.util.api.RequestResponse;

public class BaseClass 
{
	protected RequestHandler sampleInput = null;
	protected RequestResponse request = null;
	protected RequestResponse response = null;
	protected LinkedHashMap<String, String> XmlElements = null;
	protected LinkedHashMap<String, String> jsonElements = null;
	protected PropertiesHandle config = null;
	protected LinkedHashMap<String, String> input = null;
	protected LinkedHashMap<String, String> output = null;
	protected HttpHandle http = null;
	protected DBColoumnVerify InputColVerify = null;
	protected DBColoumnVerify OutputColVerify = null;
	protected DBColoumnVerify StatusColVerify = null;
	protected ArrayList<String> errorParentname = new ArrayList<String>();
	protected ArrayList<String> errorMessage=new ArrayList<String>();
	protected DBColoumnVerify conditioncheck = new DBColoumnVerify();
	protected LinkedHashMap<Integer, LinkedHashMap<String, String>> table1;

	protected long start;
	protected long end;
	
	
	//------------------------------------Converts URL to PDF----------------------------------------------------------------------
	
	public void urltopdf(String URL,String path) throws IOException
	{
		System.setProperty("jsse.enableSNIExtension", "false");	
		URL website = new URL(URL);
		Path targetPath = new File(path).toPath();
		InputStream in = website.openStream();		
		Files.copy(in, targetPath, StandardCopyOption.REPLACE_EXISTING);		
	}
	
	//------------------------------------LOAD SAMPLE REQUEST----------------------------------------------------------------------	
	public void LoadSampleRequest(LinkedHashMap<String, String> InputData) throws APIException
	{
		this.input = InputData;
		
		try
		{
			sampleInput = new RequestHandler(config);
			sampleInput.openTemplate();
		}
		catch(IOException|ClassNotFoundException| DatabaseException e)
		{
			throw new APIException("Error in load sample request", e);
		}
	}
	
	public String tokenGenerator(PropertiesHandle config)
	{
		String Token="";
		try
		{
			System.out.println(config.getProperty("AuthenticationURL"));
			HttpHandle http = new HttpHandle(config.getProperty("AuthenticationURL"),"POST");
			http.AddHeader("Content-Type", config.getProperty("content_type"));
			String input_data = "{  \"ServiceRequestDetail\": { \"OwnerId\": \""+config.getProperty("OwnerID")+"\", \"ResponseType\": \"JSON\", \"BrowserIp\": \"192.168.5.140\", \"ServiceRequestVersion\": \"2.0\" }, \"UserCredential\": { \"UserName\": \""+config.getProperty("Userneme")+"\",    \"Password\": \""+config.getProperty("Password")+"\"  } }";
			http.SendData(input_data);
			String response_string = http.ReceiveData();	
			System.out.println(input_data+"/n/n/n"+response_string);
			JsonHandle response = new JsonHandle();
			//response.StringToFile(response_string);
			//response.FileToString();
			Token = Token+response.readToken("$..Token",response_string).replaceAll("\\[\"", "").replaceAll("\"\\]", "").replaceAll("\\\\","");
			System.out.println(Token);
		}
		catch(Exception e)
		{
			System.out.println("Error in Generating Token");
			e.printStackTrace();
		}
		return config.getProperty("AuthenticationToken");
	}
}
