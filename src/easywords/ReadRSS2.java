package easywords;
import java.io.*;
import java.net.*;
import java.util.HashMap;
/**
 * @author b1016126 高橋啓太
 */
public class ReadRSS2{
    private String address;
    private HashMap<String,Integer> hm;
    public ReadRSS2(String url){
        this.address = url;
    }
    public HashMap<String,Integer> reader() throws IOException{
    	this.hm = new HashMap<String,Integer>();
        URL url = new URL(this.address);
        InputStream is = url.openStream();
        InputStreamReader isr = new InputStreamReader(is, "UTF-8");
        BufferedReader br = new BufferedReader(isr);
        String line = null;
        while((line = br.readLine()) != null) {
            line = line.trim().toLowerCase();
            if(line.startsWith("<description>")){
                String []lines =line.split("[<> ,/\\?\\[\\]\\.\"]+");
                for(String i:lines){
                    if(hm.containsKey(i)){
                    	int val = hm.get(i);
                    	hm.put(i, val+1);
                    }else{
                    	hm.put(i, 1);
                    }
                }
  
            }

        }
        br.close();
        return this.hm;
    }


    public static void main(String[] args){
        try {
            ReadRSS2 rs = new ReadRSS2("http://newsrss.bbc.co.uk/rss/newsonline_uk_edition/health/rss.xml");
            HashMap<String,Integer> maps = rs.reader();
            for(String key:maps.keySet()){
            	if(key.length()>=6){
            		String val = String.valueOf(maps.get(key));
            		System.out.println(val+":"+key);
            	}
            }
        } catch (IOException e) {
            System.out.println("入出力エラー");
        }
    }
}