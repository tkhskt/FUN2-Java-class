/**
 * 
 */
package easydb;

/**
 * @author b1016126 高橋啓太
 *
 */
public class Card {
	private String name;
	private String gender;
	
	public String getName(){
		return this.name;
	}
	
	public String getGender(){
		return this.gender;
	}
	
	public Card(String name,String gender){
		this.name = name;
		this.gender = gender;
	}
}
