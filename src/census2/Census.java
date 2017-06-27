package census2;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

/**
 * @author b1016126 高橋啓太
 */
public class Census {
    private ArrayList<Town> town = new ArrayList<>();
 

    public Census(String link) throws IOException{
        URL url = new URL(link);
        InputStream is = url.openStream();
        InputStreamReader isr = new InputStreamReader(is, "SJIS");
        BufferedReader br = new BufferedReader(isr);
        String line = null;
        while((line = br.readLine()) != null) {
            //System.out.println(line);
            String[] s = line.split(",");
            if (s.length >= 4) {
            	if(s[1].equals("　　　合　　　　計")){
            		try {
            			int h = Integer.parseInt(s[2]);
            			int p = Integer.parseInt(s[3]);
            			town.add(new Town(s[0],s[1],h,p));
            		} catch (NumberFormatException e) {
            			// Integer.parseIntで整数への変換に失敗すると、try内の処理を中断して、このcatch節が実行される。
            			// 通常は数値に変換できなかった場合の処理を書くが、今回は特に何もしない。
            		}
            	}
            }
        }
        br.close();
        int sprhouses =0;
        int sprpersons = 0;
        for(int i=0;i<town.size();i++){
        	sprhouses = sprhouses + town.get(i).getHouses();
        	sprpersons = sprpersons + town.get(i).getPersons();     	
        }
        town.add(new Town("札幌市","　　　全　　　　体",sprhouses,sprpersons));
        
    }

    public ArrayList<Town> getTown(){
        return this.town;
    }

 
    public static void main(String[] args) throws IOException{
    	try {
            Census spr = new Census("http://www.city.sapporo.jp/toukei/jinko/juuki/documents/jou201704.csv");
            ArrayList<Town> towns = spr.getTown();
            for (int i = 0; i < towns.size(); i++) {
                System.out.println(towns.get(i));
            }
        } catch (IOException e) {
            System.out.println("入出力エラー");
        }
    }
}
