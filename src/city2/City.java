/**
 * 
 */
package city2;

/**
 * @author b1016126 高橋啓太
 *
 */
public class City {
	/**
	 * @param args
	 */
	private int p;
	private String name;
	private int attract;


	public int getAttract(){
		return this.attract;
	}


	public void addP(int n){
		this.p = this.p + n;
	}
	
	public int getP(){
		return p;
	}

	public int calcP(int n){
		double res;
		res = this.p * 0.01 * n;
		return (int)res;
	}

	public int delP(int n){
		double res;
		res = this.p * 0.01 * n;
		this.p = this.p -(int)res;
		return (int)res;
	}

	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public City(String name,int p,int attract){
		this.p = p;
		this.name = name;
		this.attract = attract;
	}
	
	public String toString(){
		String itos = String.valueOf(this.p);
		return this.name+":"+itos;
	}


}
