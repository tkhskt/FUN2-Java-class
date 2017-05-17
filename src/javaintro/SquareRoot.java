package javaintro;

/**
 * @author b1016126 高橋啓太
 */
public class SquareRoot {
    public static double calcSQRoot(int num){
        double x0 = 1.0;
        double x1;
        if(num<=0.0){
            return 0.0;
        }
        else {
            do {
                x1 = (x0 + num / x0) / 2;
                if (x1 != x0) {
                    x0 = x1;
                } else {
                    break;
                }
            } while (true);

            return x0;
        }
    }

    public static void main(String[] args){
        for(int i = 0;i<100;i++){
            int n = (int)(Math.random()*Integer.MAX_VALUE);
            System.out.print(n);
            System.out.print("=>");
            double sqrt = calcSQRoot(n);
            System.out.print(sqrt);
            System.out.print("=>");
            System.out.println(sqrt*sqrt);
            //System.out.println(calcSQRoot(20));
        }

    }
}
