package com.test;

public class RoundOfMath {

	public static void main(String[] args) {
		short s1 = 1;
		s1 = (short) (s1 + 1); //��ʲô��?s1+1��������int�ͣ���Ҫǿ��ת������
		short s2 = 1;
		s2 += 1; //û���������У�
		System.out.print(Math.round(11.4)); //11
		System.out.print(Math.round(11.5)); //12
		System.out.println(Math.round(11.6)); //12
		System.out.print(Math.round(-11.4)); //-11
		System.out.print(Math.round(-11.5)); //-11
		System.out.println(Math.round(-11.6)); //-12

		String str = "Liu Zhi feng && LiuXiaomin AAAbbbDDDccc";
		String result = "";
		System.out.println(str.length());
		for (int i = 0; i < str.length(); i++){
			String temp = str.substring(i, i+1);
			if(str.charAt(i) >= 'a' && str.charAt(i) <= 'z'){
				result += temp.toUpperCase();
			}else if(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z'){
				result += temp.toLowerCase();
			}else{
				result += temp;
			}
		}
		System.out.println(result);
		System.out.println((2<<3));
	}

}
