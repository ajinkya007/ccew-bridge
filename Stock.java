import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class Stock {
	
	public static void main(String args[]) throws IOException
	{
		URL url=new URL("https://in.finance.yahoo.com/quote/sbin.ns?p=sbin.ns");
		URLConnection urc=url.openConnection();
		urc.setRequestProperty("User-Agent", "Mozilla/5.0");
		InputStreamReader ireader=new InputStreamReader(urc.getInputStream());
		BufferedReader buff=new BufferedReader(ireader);
		String line=buff.readLine();
		String name="";
		//ArrayList<String> nse=new ArrayList<>();
		//ArrayList<String> bse=new ArrayList<>();
		while(line!=null)
		{
			if(line.contains("<!-- react-text: 15 -->"))
			{
				int hr=line.indexOf("<!-- react-text: 15 -->");
				int cl_b=line.indexOf("<!-- /react-text -->",hr);
				//int dot=line.indexOf("<", cl_b);
				if(cl_b>0&&hr>0)
				{
					name=line.substring(hr+23, cl_b);
				}
			}
			if(!name.equals(""))
			{
				System.out.println(name);
				break;
			}
			line=buff.readLine();
		}
	}

}
