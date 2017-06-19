package census0;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

/**
 * @author b1016126 高橋啓太
 */
public class Census {
    private ArrayList<String> ward = new ArrayList<>();
    private ArrayList<String> town = new ArrayList<>();
    private ArrayList<Integer> houses = new ArrayList<>();
    private ArrayList<Integer> persons = new ArrayList<>();

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
                try {
                    int h = Integer.parseInt(s[2]);
                    int p = Integer.parseInt(s[3]);
                    ward.add(s[0]);//をwardに追加;
                    town.add(s[1]);//をtownに追加;
                    houses.add(h);//をhousesに追加;
                    persons.add(p);//をpersonsに追加;
                } catch (NumberFormatException e) {
                    // Integer.parseIntで整数への変換に失敗すると、try内の処理を中断して、このcatch節が実行される。
                    // 通常は数値に変換できなかった場合の処理を書くが、今回は特に何もしない。
                }
            }
        }
        br.close();
    }

    public ArrayList<String> getWard(){
        return this.ward;
    }

    public ArrayList<String> getTown(){
        return this.town;
    }

    public ArrayList<Integer> getHouses(){
        return this.houses;
    }

    public ArrayList<Integer> getPersons(){
        return this.persons;
    }
    public static void main(String[] args) throws IOException{
        try {
            Census spr = new Census("http://www.city.sapporo.jp/toukei/jinko/juuki/documents/jou201704.csv");
            System.out.println(spr.getWard().subList(0, 5));
            System.out.println(spr.getTown().subList(0, 5));
            System.out.println(spr.getHouses().subList(0, 5));
            System.out.println(spr.getPersons().subList(0, 5));
        } catch (IOException e) {
            System.out.println("入出力エラー");
        }
    }
}
