package wheel;
/**
 *
 * @author b1016126 高橋啓太
 *
 */
import java.util.*;

public class Wheel {
    static Random  rnd = new Random();

    public static int spin(int[] s) {
        // ここにプログラムを作成
        int n = 0;
        for(int i=0;i<s.length;i++){
            n = n + s[i];
        }
        double ya = rnd.nextDouble()*n;
        int x = s[0];
        int atari = 0;
        while(x<ya){
            atari++;
            x = x + s[atari];
        }
        return(atari);
    }
    public static void main(String[] args) {
        // TEST1
        int[] p1 = {2, 5, 3, 7, 10};
        for(int i = 0; i < 30; ++i) {
            System.out.print(spin(p1)+" ");
        }

        System.out.println();

        // TEST2
        int[] p2 = {10, 5};
        for(int i = 0; i < 30; ++i) {
            System.out.print(spin(p2)+" ");
        }
    }

}