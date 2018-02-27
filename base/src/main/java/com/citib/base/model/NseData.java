package com.citib.base.model;

import java.nio.channels.SeekableByteChannel;
import com.google.gson.Gson;
import java.nio.file.Files;
import java.util.*;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class NseData {

   public static void main(String args[]) throws IOException  
   {
	   File file = new File("C:\\Users\\A K GUPTA\\Desktop\\listnse.txt");   

		BufferedReader br = new BufferedReader(new FileReader(file));
		String st;
		String NSE;
		HashMap <String, Double> hmap =new HashMap<String,Double>();
		
		//ArrayList<Double> arrayListNSE = new ArrayList<Double>();
		
		while ((st = br.readLine()) != null)
		{
		//st=br.readLine();
			StringTokenizer str=new StringTokenizer(st," ");
			NSE=str.nextToken();
			URL url = new URL( "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=BSE:"+NSE+"&apikey=tbd1&outputsize=full" );
			/*URLConnection urc=url.openConnection();
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
					arrayListNSE.add(n);
					break;
				}
				//System.out.println(line);
				line=buff.readLine();
			}*/
			hmap.put(str.nextToken(),Data.urlConnect(url));
			
		/*	System.out.println(str.nextToken()+"\t"+b+"\t"+n);
			if(b>n)
			{
				System.out.println("\tBuy from NSE and Sell in BSE ");
			}
			if(n>b)
			{
				System.out.println("\tBuy from BSE and Sell in NSE ");
			}
			double profit=(Math.abs(b-n)/Math.min(n, b))*100;
			System.out.println("\tProfit % = "+profit);*/
			
		}
		//  System.out.println(hmap); 
		  br.close();
		  Gson gson = new Gson();
	      String json = gson.toJson(hmap);
	      System.out.println(json);
		 
   }
}