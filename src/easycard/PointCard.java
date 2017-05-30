/**
 * 
 */
package easycard;

/**
 * @author b1016126 高橋啓太
 *
 */
public class PointCard extends Card {
	private int point;
	
	public void addPoint(int p){
		String gender = super.getGender();
		if(gender.equals("female")){
			this.point = this.point + p*2;
		}else{
			this.point = this.point + p;
		}
	}
	
	public int getPoint(){
		return this.point;
	}
	
	public PointCard(String name,String gender){
		super(name,gender);
		this.point = 0;
	}
}
