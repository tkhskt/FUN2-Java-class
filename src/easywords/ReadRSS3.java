package easywords;
import java.io.*;
import java.net.*;
import java.util.*;
/**
 * @author b1016126 高橋啓太
 */
public class ReadRSS3{
    private String address;
    private HashMap<String,Integer> hm;
    private ArrayList<Map.Entry<String, Integer>> result = new ArrayList<Map.Entry<String, Integer>>();
    
    
    public ArrayList<Map.Entry<String, Integer>> keySort(HashMap<String, Integer> map) {
    	ArrayList<String> al = new ArrayList<>();
    	for(String i:map.keySet()){
    		al.add(i);
    	}
    	Collections.sort(al);
    	for(String i:al){
    		this.result.add(new AbstractMap.SimpleEntry(i, map.get(i)));
    	}
    	//ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
    	return result;
    }
    
    
    public ReadRSS3(String url){
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
    		ReadRSS3 rss = new ReadRSS3("http://newsrss.bbc.co.uk/rss/newsonline_uk_edition/health/rss.xml");
    		for (Map.Entry<String, Integer> entry: rss.keySort(rss.reader())) {
    			String key = entry.getKey();
    			if (key.length() >= 6)
    				System.out.println(entry.getKey() + ":" + entry.getValue());
    		}
    	} catch (IOException e) {
    		System.out.println("入出力エラー");
    	}
    }
}