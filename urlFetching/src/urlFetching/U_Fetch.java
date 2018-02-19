package urlFetching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;


public class U_Fetch
{
	public static void main(String args[]) throws IOException
	{
	//	URL url=new URL("https://www.moneyworks4me.com/best-index/nse-stocks/top-nifty50-companies-list/");
		URL url = new URL( "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=BSE:532187&apikey=tbd1&outputsize=full" );
		URLConnection urc=url.openConnection();
		//urc.setRequestProperty("User-Agent", "Mozilla/5.0");
		InputStreamReader ireader=new InputStreamReader(urc.getInputStream());
		BufferedReader buff=new BufferedReader(ireader);
		String line=buff.readLine();
	//	ArrayList<String> nse=new ArrayList<>();
	//	ArrayList<String> bse=new ArrayList<>();
		while(line!=null)
		{
			/*if(line.contains("td width=\"325px\""))
			{
				int hr=line.indexOf("href");
				int cl_b=line.indexOf(">", hr);
				int dot=line.indexOf("<", cl_b);
				String name=line.substring(cl_b+1, dot);
				nse.add(name);
			}*/
			System.out.println(line);
			line=buff.readLine();
		}
		/*URL ur1=new URL("https://www.moneyworks4me.com/best-index/bse-stocks/top-bse30-companies-list/page/1");
		URL ur2=new URL("https://www.moneyworks4me.com/best-index/bse-stocks/top-bse30-companies-list/page/2");
		URL ur3=new URL("https://www.moneyworks4me.com/best-index/bse-stocks/top-bse30-companies-list/page/3");
		urc=ur1.openConnection();
		urc.setRequestProperty("User-Agent", "Mozilla/5.0");
		ireader=new InputStreamReader(urc.getInputStream());
		buff=new BufferedReader(ireader);
		line=buff.readLine();
		while(line!=null)
		{
			if(line.contains("td width=\"325px\""))
			{
				int hr=line.indexOf("href");
				int cl_b=line.indexOf(">", hr);
				int dot=line.indexOf("<", cl_b);
				String name=line.substring(cl_b+1, dot);
				bse.add(name);
			}
			
			line=buff.readLine();
		}
		urc=ur2.openConnection();
		urc.setRequestProperty("User-Agent", "Mozilla/5.0");
		ireader=new InputStreamReader(urc.getInputStream());
		buff=new BufferedReader(ireader);
		line=buff.readLine();
		while(line!=null)
		{
			if(line.contains("td width=\"325px\""))
			{
				int hr=line.indexOf("href");
				int cl_b=line.indexOf(">", hr);
				int dot=line.indexOf("<", cl_b);
				String name=line.substring(cl_b+1, dot);
				bse.add(name);
			}
			
			line=buff.readLine();
		}
		urc=ur3.openConnection();
		urc.setRequestProperty("User-Agent", "Mozilla/5.0");
		ireader=new InputStreamReader(urc.getInputStream());
		buff=new BufferedReader(ireader);
		line=buff.readLine();
		while(line!=null)
		{
			if(line.contains("td width=\"325px\""))
			{
				int hr=line.indexOf("href");
				int cl_b=line.indexOf(">", hr);
				int dot=line.indexOf("<", cl_b);
				String name=line.substring(cl_b+1, dot);
				bse.add(name);
			}
			
			line=buff.readLine();
		}
		ArrayList<String> common=new ArrayList<>(nse);
		common.retainAll(bse);
		for(int i=0;i<common.size();i++)
		{
			System.out.println(common.get(i));
		}*/
	}

}
