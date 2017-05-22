package city;

/**
 * @author b1016126 高橋啓太
 */


public class CityMain {

    private String name;
    private int p;
    private int attract;

    CityMain(String name, int p, int attract) {
        this.name = name;
        this.p = p;
        this.attract = attract;
        System.out.println(name + ":" + p + ":" + attract);
    }

    public void test() {
        // Cityインスタンスの作成
        City city = new City(name, p, attract);
        // getName, getAttract, getPのテスト
        System.out.println(" getName - " + name.equals(city.getName()));
        System.out.println(" getAttract - " + (attract == city.getAttract()));
        System.out.println(" getP - " + (p == city.getP()));
        // addP/getPのテスト
        int m = 500 + (int)(Math.random() * 500);
        city.addP(m);
        System.out.println(" addP/getP - " + (p + m == city.getP()));
        // calcPのテスト
        int n = 3;
        int expected = (int)((p + m) * 0.01 * n);
        System.out.println(" calcP - " + (expected == city.calcP(n)));
        // delP/getPのテスト
        System.out.println(" delP - " + (expected == city.delP(n)));
        System.out.println(" delP/getP - " + (p + m - expected == city.getP()));
    }

    public static void main(String[] args) {
        new CityMain("hkd", 200000, 3).test();
    }
}