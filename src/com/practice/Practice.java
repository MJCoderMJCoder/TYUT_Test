/**
 * 
 */
package com.practice;

/**
 * @author zhifengfei
 *
 */
public class Practice {

	public static String name = "tom";

	static {
		System.out.println("Dog init");
	}

	{
		System.out.println("=============");
	}

	public Practice() {
		System.out.println("���췽��");
	}

	public static void info() {
		System.out.println("a dog");
	}

}
