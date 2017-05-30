/**
 * 
 */
package easycard;

/**
 * @author b1016126 高橋啓太
 *
 */
public class BookCard extends Card {
	private String bookname;
	
	public void setBookname(String bookname){
		this.bookname = bookname;
	}
	
	public String getBookname(){
		return this.bookname;
	}
	
	public BookCard(String name,String gender){
		super(name,gender);
		this.bookname = "";
	}

	
	
}
