/**
 * 
 */
package census2;

/**
 * @author b1016126 高橋啓太
 *
 */
public class Town {
	private String ward;
	private String town;
	private int houses;
	private int persons;
	
	public String getWard(){
		return this.ward;
	}
	public String getTown(){
		return this.town;
	}
	public int getHouses(){
		return this.houses;
	}
	public int getPersons(){
		return this.persons;
	}
	
	public Town(String ward,String town,int houses,int persons){
		this.ward = ward;
		this.town = town;
		this.houses = houses;
		this.persons = persons;
	}
	
	public double getAverageNumberOfFamily(){
		double p = (double)persons;
		double h = (double)houses;
		double ave = p/h;
		return ave;
	}
	
	public String toString(){
		String average = String.format("%1$.2f",getAverageNumberOfFamily());
		return ward+":"+town+":"+houses+":"+persons+":"+average;
	}
	
	
	
	
}
