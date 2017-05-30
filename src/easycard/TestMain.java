/**
 * 
 */
package easycard;

/**
 * @author b1016126 高橋啓太
 *
 */
public class TestMain {
	public static void main(String[] args) {
        
        // (1) 図書カードの作成と利用テスト
         
        // Taroさんが新規に図書カードを作成
        BookCard card1 = new BookCard("Taro", "male");
         
        // Taroさんはまだ何も借りていないことを確認
        System.out.println("名前:" + card1.getName()
                + " 借りている図書：" + card1.getBookname());
         
        // Taroさんが図書１を借りる
        card1.setBookname("図書１");
         
        // Taroさんの図書カードcard1の情報を出力
        System.out.println("名前:" + card1.getName()
                + " 性別:" + card1.getGender()
                + " 借りている図書：" + card1.getBookname());
         
        // (2) ポイントカードの作成と利用テスト（BookCardまで完成した後に以下のコメントを外してください）
        /*
        // Hanakoさんが新規にポイントカードを作成
        PointCard card2 = new PointCard("Hanako", "female");
 
        // Hanakoさんはまだポイント０であることを確認
        System.out.println("名前:" + card2.getName()
                + " ポイント:" + card2.getPoint());
         
        // Hanakoさんに１０ポイントを付与（女性なので獲得は２倍）
        card2.addPoint(10);
         
        // Hanakoさんの獲得ポイントを表示
        System.out.println("名前:" + card2.getName()
                + " 性別:" + card2.getGender()
                + " ポイント:" + card2.getPoint());
        */
    }

}
