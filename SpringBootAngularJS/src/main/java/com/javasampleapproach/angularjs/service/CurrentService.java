package com.javasampleapproach.angularjs.service;

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

import java.util.Random;

import com.google.gson.Gson;
import com.javasampleapproach.angularjs.model.CurrentStock;

@Service
public class CurrentService 
{
	public ArrayList<CurrentStock> Current() throws IOException 
	   {
		   File file = new File("C:\\Users\\A K GUPTA\\Desktop\\list.txt");

			BufferedReader br = new BufferedReader(new FileReader(file));
			ArrayList<CurrentStock> cs=new ArrayList<CurrentStock>();
			CurrentStock cso;
			String st;
			String NSE,BSE;
			Random rand = new Random();
			double profit=0.0,p=0;
			int cnt=0;
			System.out.println("Reached Here");
			while ((st = br.readLine()) != null&&cnt<3)
			{cnt++;
			//st=br.readLine();
				cso=new CurrentStock();
				StringTokenizer str=new StringTokenizer(st," ");
				BSE=str.nextToken();
				URL url = new URL( "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=BSE:"+BSE+"&apikey=tbd1&outputsize=full" );
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
						cso.setBsePrice(Double.parseDouble(name));
						break;
					}
					//System.out.println(line);
					line=buff.readLine();
				}
				
				NSE=str.nextToken();
				url = new URL( "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=NSE:"+NSE+"&apikey=tbd1&outputsize=full" );
				urc=url.openConnection();
				ireader=new InputStreamReader(urc.getInputStream());
				buff=new BufferedReader(ireader);
				line=buff.readLine();
				while(line!=null)
				{
					if(line.contains("close\""))
					{
						//System.out.println(line);
						int hr=line.indexOf(":");
						int cl_b=line.indexOf("\"", hr);
						int dot=line.indexOf("\"", cl_b+1);
						String name=line.substring(cl_b+1, dot);
						cso.setNsePrice(Double.parseDouble(name));
						break;
					}
					//System.out.println(line);
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
				p=Math.abs(cso.getBsePrice()-cso.getNsePrice())/Math.max(cso.getBsePrice(), cso.getNsePrice());
				p=p*100;
				int r=(int)(p * 100);
				double f = r / 100.0;
				cso.setProfit(f);
				if(cso.getNsePrice()>cso.getBsePrice())
					cso.setRecommendation("\t Buy from BSE sell in NSE");
				else
					cso.setRecommendation("\t Buy from NSE sell in BSE");
				cs.add(cso);
			//	cso.display();		
			/*	Gson gson = new Gson();
			    String json = gson.toJson(cso);
			    System.out.println(json); */
				System.out.println("Done");
			}
			br.close();
			Gson gson = new Gson();
		    String json = gson.toJson(cs);
		 //   System.out.println(json); 
		    return cs;
	   }
}
