/**
 * 
 */
package city2;

/**
 * @author b1016126 高橋啓太
 *
 */
public class CitySim {
	private City ct[];
    
    CitySim (City []ct) {
    	this.ct = new City[ct.length];
        for(int i=0;i<this.ct.length;i++){
        	this.ct[i] = ct[i];
        }
    }
     
    public String calc (int step) {
        // ここに1年分のシミュレーション処理を実装
    	String res = step + " ";
    	int zogen[] = new int[this.ct.length];
    	
    	
    	for(int i=0;i<this.ct.length;i++){
    		int plus = 0;
    		int minus = 0;
    		for(int y=0;y<this.ct.length;y++){
    			if(y==i){
    				continue;
    			}
    			plus = plus + this.ct[y].calcP(this.ct[i].getAttract());
    			minus = minus + this.ct[i].calcP(this.ct[y].getAttract());
    		}
    		zogen[i] = plus - minus;
    	}
    	
    	
    	for(int i=0;i<this.ct.length;i++){
    		ct[i].addP(zogen[i]);
    	}
    	
    	
    	for(int i=0;i<this.ct.length;i++){
    		res = res + this.ct[i] + " ";
    	}
    	
    	res = res.substring(0, res.length()-1);
    	
        return res;
    }
     
    public static void main(String[] args) {
    	City ct[] = {new City("hkd", 200000, 3),new City("ask", 400000, 1),new City("spr", 1800000, 2)};
        CitySim m = new CitySim(ct);
        for(int i=0;i<200;i++){
          System.out.println(m.calc(i));
        }
    }
}
