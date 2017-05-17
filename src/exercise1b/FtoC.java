package exercise1b;

/**
 * @author b1016126 高橋啓太
 */
public class FtoC {
    static int sum = 0;
    static int m = 0;
 		public static void main(String[] args) {

        		for (int i = 1; i <= 100; i++) {

            			sum = sum + i;
                        m = i;
                }

                String f = String.valueOf(m);
                String um = String.valueOf(sum);
        		System.out.println("i=" + f);

        		System.out.println("sum=" + um);

        	}
}
