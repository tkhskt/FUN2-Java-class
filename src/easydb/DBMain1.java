/**
 * 
 */
package easydb;

/**
 * @author b1016126 高橋啓太
 *
 */
public class DBMain1 {
	 
    public static void main(String[] args) {
        // create new database
        DB db = new DB();
         
        // add some data
        db.insert(new MCard("Ms Atom", "F", 18));
        db.insert(new MCard("Mr Bean", "M", 61));
        db.insert(new MCard("Ms Cake", "F", 40));
        db.insert(new MCard("Mr Dean", "M", 19));
        db.insert(new MCard("Ms Even", "F", 19));
        db.insert(new MCard("Mr Feel", "M", 18));
 
        // current data entries
        System.out.println("Show all");
         
        for (MCard i:db.getAll()) {
            System.out.println (i.toString());
        }
         
        // choose male cards and show
        System.out.println("Show male:");
 
        for (MCard i:db.selectGender("M")) {
            System.out.println (i.toString());
        }
    }
}