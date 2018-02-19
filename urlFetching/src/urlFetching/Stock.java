package urlFetching;

import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.util.*;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class Stock {

   public static void main(String args[]) throws IOException 
   {
	   File file = new File("C:\\Users\\A K GUPTA\\Desktop\\list.txt");

		BufferedReader br = new BufferedReader(new FileReader(file));
		String st;
		String NSE,BSE;
		double n=0.0,b=0.0;
		while ((st = br.readLine()) != null)
		{
		//st=br.readLine();
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
					b=Double.parseDouble(name);
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
					n=Double.parseDouble(name);
					break;
				}
				//System.out.println(line);
				line=buff.readLine();
			}
			System.out.println(str.nextToken()+"\t"+b+"\t"+n);
		}

   }
}