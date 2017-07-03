package easystat;
/**
 * @author b1016126 高橋啓太
 */

import java.io.*;
import java.util.*;
import java.net.*;

public class Recom {

	private int persons;
	private int fruits;
	private String[] name;
	//private int[][] data;
	private double[] avg;
	private double[][] dt;
	private double[] var;
	private double[][] cor;
	private double[][] rcm;
	
	/**
	 * constructor
	 */
	
	public Recom (String address) throws Exception {
        makeDt(makeData(readInString(address)));
	}
	
	/** 1
	 * method: readFromURL
	 * read from address and store each line into txt
	 * set number of persons to persons
	 */

	private  ArrayList<String> readInString(String address) throws Exception {
		// private変数のaddressで示すURLからprivate変数のtxtに1行ずつ読み込む
		// その後personsをtxtの行数-1（1行目は項目名なので）に設定
		// fruitは15にする．
        ArrayList<String> txt = new ArrayList<>();
		URL url = new URL(address);
		InputStream is = url.openStream();
		InputStreamReader isr = new InputStreamReader(is, "UTF-8");
		BufferedReader br = new BufferedReader(isr);

		String line;
		while((line = br.readLine()) != null) {
			txt.add(line);
		}
		br.close();

		persons = txt.size() - 1;
		fruits = 15;
        //data = new int[persons][fruits];
        name = new String[persons];
        avg = new double[persons];
        dt = new double[persons][fruits];
        cor = new double[persons][persons];
        var = new double[persons];
        rcm = new double[persons][fruits];

		//---------------------------------
		// Check print
		System.out.println("Number of persons:" + persons);
		System.out.println("Number of fruits:" + fruits);
		System.out.println("--------------");
		return txt;
	}
	
	/** 2
	 * method: defineArrays
	 * defines arrays
	 */

	
	/** 3
	 * method: makeData
	 *  split and set data. missing data is temporarily set to 0
	 */

	private int[][] makeData(ArrayList<String> txt) {
		// 各行ごとに読み込んだ個人のデータが入っているtxt[i]から，
		// 各行・列に個人(i)の果物(j)の評価の値が仮に格納されるdata[i][j]を作る．
		// 具体的には，txtの2行目（txt.get(1)）から順に各行を\tで分割し，作業用の文字列配列に行の値を格納する
		// 作業用配列の添え字7の文字列は，氏名であるから，nameに格納する
		// 作業用配列の添え字9からが果物の評価値．
		// もし""(データ欠損）の場合は0とし，そうでなければ整数にしてdataに格納する
        int[][] data = new int[persons][fruits];
		for(int i = 0; i < persons; ++i) {
			String[] num = txt.get(i + 1).split("\t",-1);
			name[i] = num[7];
			for(int j = 0; j < fruits; ++j) {
				if(num[j + 9].equals("")) 
					data[i][j] = 0;
				else
					data[i][j] = Integer.parseInt(num[j + 9]);
			}
		}

		//---------------------------------
		// Check print
		System.out.println("data:");
		for(int i = 0; i < persons; ++i) {
			for(int j = 0; j < fruits; ++j)
				System.out.print("[" + data[i][j] + "]");
			System.out.println(":" + name[i]);
		}
		System.out.println("--------------");
		return data;
	}

	
	/** 4
	 * method: makeDt
	 *  fill missing data with personal average
	 */
	
	private double[][] makeDt(int[][] data) {
		// 各行・列に個人(i)の果物(j)の評価の値が仮に格納されるdata[i][j]から，
		// 欠損データ（data[i][j]が0であるもの）を，その行（個人）の（0値を除いた）平均値で置き換えて，
		// 個人(i)の果物(j)の評価値の格納用の配列dt[i][j]に格納する．
		// 具体的には，個人iのデータ（data[i]と表せる）をStatクラスのfillメソッドに送り，
		// 返ってきた個人iのデータをdt[i]に格納する
		
		for(int i = 0; i < persons; ++i) {
			dt[i] = Stat.fill(data[i]);
		}
		
		//---------------------------------
		// Check print
		System.out.println("dt:");
		for(int i = 0; i < persons; ++i) {
			for(int j = 0; j < fruits; ++j)
				System.out.print("[" + Math.round(dt[i][j]*10.0)/10.0 + "]");
			System.out.println(":" + name[i]);
		}
		System.out.println("--------------");
		return dt;
	}
	
	/** 5
	 * method: calcAverage
	 *  set personal average to avg[]
	 */
	
	public void calcAverage() {
		//  個人(i)の果物(j)の評価値の格納用の配列dt[i][j]から，個人(i)の平均値をavg[i]に得る
		// 具体的には，個人iのデータ（dt[i]と表せる）をStatクラスのaverageメソッドに渡して，
		// 平均を得て，個人iの平均値の格納先であるavg[i]に入れる
		
		for(int i = 0; i < persons; ++i) {
			avg[i] = Stat.average(dt[i]);
		}
		
		//---------------------------------
		// Check print
		System.out.println("average:");
		for(int i = 0; i < persons; ++i)
				System.out.println("[" + Math.round(avg[i]*10.0)/10.0 + "]:" + name[i]);
		System.out.println("--------------");
	}

	/** 6
	 * method: calcVariance
	 *  set personal variance to var[]
	 */
	
	public void calcVariance() {
		//  個人(i)の果物(j)の評価値の格納用の配列dt[i][j]から，個人(i)の分散（標本分散）をvar[i]に得る
		// 具体的には，個人iのデータ（dt[i]と表せる）をStatクラスのvarianceメソッドに渡して，
		// 平均を得て，個人iの平均値の格納先であるvar[i]に入れる
		
		for(int i = 0; i < persons; ++i) {
			var[i] = Stat.variance(dt[i]);
		}
		
		//---------------------------------
		// Check print
		System.out.println("variance:");
		for(int i = 0; i < persons; ++i)
				System.out.println("[" + Math.round(var[i]*10.0)/10.0 + "]:" + name[i]);
		System.out.println("--------------");
	}
	
	/** 7
	 * method: calcCorr
	 *  set correlation coefficient between persons to cor[][]
	 */
	
	public void calcCorr() {
		// 個人(i1)と個人（i2)の間の相関係数を計算し，cor[i1][i2]に格納する．
		// 具体的には，個人i1のデータ（dt[i1]と表せる）と個人i2のデータ（dt[i2]と表せる）を
		// Statクラスのcorメソッドに引き渡し，その結果である相関係数をcor[i1][i2]に入れる．
		// これをi1のすべて（persons分）とi2のすべて（persons分）について（2重ループで）行う
		
		// TODO 1 ここを作成
		
		//---------------------------------
		// Check print
		System.out.println("correlation coefficient:");
		for(int i = 0; i < persons; ++i) {
			for(int j = 0; j < fruits; ++j)
				System.out.print("[" + Math.round(cor[i][j]*10.0)/10.0 + "]");
			System.out.println(":" + name[i]);
		}
		System.out.println("--------------");
	}
	
	/** 8
	 * method: doRecomm
	 *  do recommendation to all persons and all fruits
	 */
	
	public void doRecomm() {
		/* 個人i1の果物jについてのレコメンデーションを計算し，rcm[i1][j]に格納する．
 			具体的には，
 			(1) レコメンデーションを行う対象者i1についてのループを用意する
 			(2) 果物jについてのループを用意する
 			(3) i1のjについてのレコメンデーションを行う，具体的には
 			 1. レコメンデーション値を計算するためのdouble変数xとyを用意し，0に初期化．
 			 2. 対象者を含めたすべての個人i2についてのループを用意し，以下2つを行う
 			 3. 　xに，（個人i2の果物jについての評価から，個人i2の平均値を引いたもの）に個人i1とi2の相関係数をかけたものを，加算してゆく
 			 4. 　yに，個人i1と個人i2の相関係数の絶対値（Math.abs()を利用）を加算してゆく
 			 5. 加算の終了したx, yを用いて，個人i1の果物jについてのレコメンデーション値rcm[i1][j]を，
 			 　　個人i1の平均値 +  x/y
 			 　　とする．
 			 
 			 ※注意，以上の説明での平均値，相関係数，はあらかじめ計算を済ませて格納済みであるavgやcorrを用いること
		 */
		
		// TODO 2 ここを作成
		
		//---------------------------------
		// Check print
		System.out.println("recommendation:");
		for(int i = 0; i < persons; ++i) {
			for(int j = 0; j < fruits; ++j)
				System.out.print("[" + Math.round(rcm[i][j]*10.0)/10.0 + "]");
			System.out.println(":" + name[i]);
		}
		System.out.println("--------------");
	}
	
	/**
	 * main
	 */
	
	public static void main(String[] args) throws Exception {
		Recom a = new Recom("http://www.trace-info.net/IPP1/fruit.txt");
		//a.readInString();
		//a.defineArrays();
		//a.makeData();
		//a.makeDt();
		a.calcAverage();
		a.calcVariance();
		a.calcCorr();
		a.doRecomm();	
	}
}
