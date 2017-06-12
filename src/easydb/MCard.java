package easydb;

/**
 * @author b1016126 高橋啓太
 */


public class MCard extends Card {
    private int age;
    public MCard(String name,String gender,int age){
        super(name,gender);
        this.age = age;
    }

    public void setAge(int age){
        this.age = age;
    }

    public int getAge(){
        return this.age;
    }

    public String toString(){
        return "Name: "+super.getName()+", Gender: "+super.getGender()+", Age: "+String.valueOf(this.age);
    }



}
