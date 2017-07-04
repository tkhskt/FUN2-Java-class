package easystat;
/**
 * 
 * @author b1016126 高橋啓太
 *
 */
public class Stat {
	
	/** 1
	 * class method: average
	 * calculate average
	 */
	public static double average (double[] data) {
		/*
		 * 実数行列dataを受け取り，その要素の単純平均を計算して返す
		 * ※　要素数はdataの長さ(.length）で得られる．
		 */
		
		double avg = 0.0;
		for(double i:data){
		    avg = avg +i;
        }
		return avg/data.length; // これは仮のものであり，正しい行に置き換えること
	}
	
	/** 2
	 * class method: variance
	 * calculate variance
	 */	
	public static double variance (double[] data) {
		/*
		 * 実数行列dataを受け取り，その要素の分散（標本分散）を計算して返す
		 * ※　要素数はdataの長さ(.length）で得られる．
		 * ※　dataの平均はaverage()メソッドに渡して得られる．
		 */
		double avg=0.0;
		double bunsan = 0.0;
		for(double i:data){
			avg = avg + i;
		}
		avg = avg/data.length;
		for(double j:data){
			bunsan = bunsan + Math.pow(j-avg, 2);
		}
		
		// TODO 2 ここを作成
		return bunsan/data.length; // これは仮のものであり，正しい行に置き換えること
	}
	
	/** 3
	 * class method: cor
	 * calculate correlation coefficient
	 */	
	public static double cor (double[] data1, double[] data2) {
		/*
		 * 2つの実数行列data1とdata2を受け取り，その相関係数を計算して返す
		 * ※　data1, data2それぞれの平均は，average()メソッドに渡して得られる
		 * ※　要素数はdataの長さ(.length）で得られる．
		 * ※　この場合はdata1とdata2の2つの配列を同一の添え字で参照するので，拡張for文は使えない
		 * ※　平方根はMath.sqrt()で得られる．
		 */
		double n = 0.0;
		double avg1 = 0.0;
		double avg2 = 0.0;
		for(double d1:data1){
			avg1 = avg1 + d1;
		}
		avg1 = avg1/data1.length;//data1平均
		for(double d2:data2){
			avg2 = avg2 + d2;
		}
		avg2 = avg2/data2.length; //data2平均
		for(int i=0;i<data1.length;i++){
			n = n + (data1[i]-avg1)*(data2[i]-avg2);
		}
		
		double hensa1 = 0.0;
		double hensa2 = 0.0;
	    for(double dd1:data1){
	    	hensa1 = hensa1 + Math.pow(dd1-avg1, 2);
	    }
		hensa1 = Math.sqrt(hensa1/data1.length);
		for(double dd2:data2){
	    	hensa2 = hensa2 + Math.pow(dd2-avg2, 2);
	    }
		hensa2 = Math.sqrt(hensa2/data2.length);
		
		return n/(data1.length*hensa1*hensa2);
		
		
		// TODO 3 ここを作成
	}
	
	/** 4
	 * class method: fill
	 * fill average value into zero column
	 */
	public static double[] fill (int[] data) {
		/*
		 * 整数行列dataを受け取り，まず，値が0ではない要素についての平均値を計算する．
		 * その後dataの要素を順にみて，値が0であれば，それを平均値で置き換える．
		 * 結果をdouble[]型で返す．
		 * 作業変数：double[]型のd：返す結果を入れる変数．サイズをdataの長さとしてnewする．
		 */
		double[] d = new double[data.length];
		/*
		 * まずdataの値を見て，0ではない値についての平均値を計算する
		 * 作業変数：double型のa：平均値を格納する
		 * 作業変数：int型のn：0ではない要素の数を格納する
		 */
		
		double avg =0.0;
		int len=0;
		for(double i:data){
			if(i==0){
				continue;
			}
			avg = avg + i;
			len++;
		}
		avg = avg/len;
		for(int i=0;i<data.length;i++){
			if(data[i]==0){
				d[i] = avg;
			}else{
				d[i]= data[i];
			}
		}
		
		/*
		 * 続いて，dataの各要素を見てゆき，0以外の要素であれば，それをdに入れ，
		 * 0であれば，上で計算した平均値（a）をdに入れる．
		 * ※注意　この場合はdataとd両方ともに添え字を動かしながら参照・代入する必要があるので，拡張for文は使えない
		 */

		// TODO 5 ここを作成
		
		/*
		 * 出来上がった0を平均値で置き換えた配列dを返す．
		 */
		return d;
	}
}
