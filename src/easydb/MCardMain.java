package easydb;

/**
 * @author b1016126 高橋啓太
 */
public class MCardMain {
    public static void main(String[] args){
        MCard a = new MCard("Taro","M",20);
        System.out.println(a.toString());
        System.out.println(a.getAge());
        System.out.println(a.getGender());
    }
}
