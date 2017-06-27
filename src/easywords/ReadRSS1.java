package easywords;
import java.io.*;
import java.net.*;

/**
 * @author b1016126 高橋啓太
 */
public class ReadRSS1{
    private String address;

    public ReadRSS1(String url){
        this.address = url;
    }
    public void reader() throws IOException{
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
                    System.out.print("("+i+")");
                }
                System.out.println();
            }

        }
        br.close();
    }


    public static void main(String[] args){
        try {
            ReadRSS1 rs = new ReadRSS1("http://newsrss.bbc.co.uk/rss/newsonline_uk_edition/health/rss.xml");
            rs.reader();
        } catch (IOException e) {
            System.out.println("入出力エラー");
        }
    }
}
