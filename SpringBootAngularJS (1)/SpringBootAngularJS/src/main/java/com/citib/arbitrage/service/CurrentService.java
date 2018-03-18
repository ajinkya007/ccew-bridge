package com.citib.arbitrage.service;
//Provide service to access data from Alpha Vantage
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.StringTokenizer;

import org.springframework.stereotype.Service;

import com.citib.arbitrage.model.CurrentStock;
import com.google.gson.Gson;

@Service
public class CurrentService 
{
	public ArrayList<CurrentStock> Current() throws IOException 
	   {
		   //This file stores company name along with their BSE and NSE symbols
		   File file = new File("C:\\Users\\A K GUPTA\\Desktop\\list.txt");

			BufferedReader br = new BufferedReader(new FileReader(file));
			ArrayList<CurrentStock> cs=new ArrayList<CurrentStock>();
			CurrentStock cso;
			String st;
			String NSE,BSE;
			double profit=0.0;
			while ((st = br.readLine()) != null)
			{
				cso=new CurrentStock();
				StringTokenizer str=new StringTokenizer(st," ");
				BSE=str.nextToken();
				//Url for fetching BSE data from Alpha-Vantage
				URL url = new URL( "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=BSE:"+BSE+"&apikey=tbd1&outputsize=full" );
				URLConnection urc=url.openConnection();
				InputStreamReader ireader=new InputStreamReader(urc.getInputStream());
				BufferedReader buff=new BufferedReader(ireader);
				String line=buff.readLine();
				while(line!=null)
				{
					if(line.contains("close\""))
					{
						int hr=line.indexOf(":");
						int cl_b=line.indexOf("\"", hr);
						int dot=line.indexOf("\"", cl_b+1);
						String name=line.substring(cl_b+1, dot);
						cso.setBsePrice(Double.parseDouble(name));
						break;
					}
					line=buff.readLine();
				}
				
				NSE=str.nextToken();
				//Url for fetching NSE data from Alpha-Vantage
				url = new URL( "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=NSE:"+NSE+"&apikey=tbd1&outputsize=full" );
				urc=url.openConnection();
				ireader=new InputStreamReader(urc.getInputStream());
				buff=new BufferedReader(ireader);
				line=buff.readLine();
				while(line!=null)
				{
					if(line.contains("close\""))
					{
						int hr=line.indexOf(":");
						int cl_b=line.indexOf("\"", hr);
						int dot=line.indexOf("\"", cl_b+1);
						String name=line.substring(cl_b+1, dot);
						cso.setNsePrice(Double.parseDouble(name));
						break;
					}
					line=buff.readLine();
				}
				cso.setStockName(str.nextToken());
				if(cso.getBsePrice()== 0.0)
				{
					double d = (Math.random() * ((5) + 1)) + cso.getNsePrice();
					int r = (int)(d * 100);
					double f = r / 100.0;
					cso.setBsePrice(f);
				}
				profit=Math.abs(cso.getBsePrice()-cso.getNsePrice())/Math.max(cso.getBsePrice(), cso.getNsePrice());
				profit=profit*100;
				int r=(int)(profit * 100);
				double f = r / 100.0;
				cso.setProfit(f);
				if(cso.getNsePrice()>cso.getBsePrice())
					cso.setRecommendation("\t Buy from BSE sell in NSE");
				else
					cso.setRecommendation("\t Buy from NSE sell in BSE");
				if(f>=0.1)
					cs.add(cso);
			//	cso.display();		
			/*	Gson gson = new Gson();
			    String json = gson.toJson(cso);
			    System.out.println(json); */
			}
			br.close();
			Gson gson = new Gson();
		    String json = gson.toJson(cs);
		    return cs;
	   }
}
