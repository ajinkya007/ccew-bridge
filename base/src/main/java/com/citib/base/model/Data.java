package com.citib.base.model;

import java.util.*;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class Data {
	
	public static double urlConnect(URL url) throws IOException
	{
		double n=0.0;
		URLConnection urc=url.openConnection();
		InputStreamReader ireader=new InputStreamReader(urc.getInputStream());
		BufferedReader buff=new BufferedReader(ireader);
		String line=buff.readLine();
		while(line!=null)
		{
			if(line.contains("close\""))
			{
				//System.out.println(line);
				int hr=line.indexOf(":");
				int cl_b=line.indexOf("\"", hr);
				int dot=line.indexOf("\"", cl_b+1);
				String name=line.substring(cl_b+1, dot);
				n=Double.parseDouble(name);
				break;
			}
			//System.out.println(line);
			line=buff.readLine();
		}
		return n;
	}

}
