/**
 * 
 */

package easydb;
import java.util.ArrayList;

/**
 * @author b1016126 高橋啓太
 *
 */
public class DB {
	private ArrayList<MCard> data;
	
	public void insert(MCard mc){
		data.add(mc);
	}
	
	public ArrayList<MCard> getAll(){
		return data;
	}
	
	public ArrayList<MCard> selectGender(String gender){
		ArrayList<MCard> res = new ArrayList<>();
		for(MCard m:data){
			if(m.getGender()==gender){
				res.add(m);
			}
		}
		return res;
	}

    public ArrayList<MCard> deleteAgeLessThan(int age){
    	ArrayList<MCard> del = new ArrayList<>();
    	for(MCard i:data){
    		if(i.getAge()<age){
    			del.add(i);
    		}
    	}
    	data.removeAll(del);
    	return del;
    }
	
	public DB(){
		this.data = new ArrayList<>();
	}
}
