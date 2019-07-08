package com.test;
/*
 * http://wenku.baidu.com/link?url=-rhVkpW1Pbl8__xWntScW4mSDfr7-wUm7ex-uxtD5OWjd8uZ5nXdVndHnpwk_HkSL_eXXAiJ1Y2y95zMrDRcU1jkTI362vM9YKT7qEy1zhG
 * http://wenku.baidu.com/link?url=-rhVkpW1Pbl8__xWntScW4mSDfr7-wUm7ex-uxtD5OWjd8uZ5nXdVndHnpwk_HkSL_eXXAiJ1Y2y95zMrDRcU1jkTI362vM9YKT7qEy1zhG
 * 
 * wait()��notify()һϵ�еķ����������ڶ���ģ����������̵߳ġ����������߳�ͬ��ʱ��synchronized�����С�
 * 		��synchronized�����У�ͬһ������һ���߳���ִ������һ�����֮ǰ����һ���̣߳��������������ͬһ
 * ��object���ǲ��ܽ����������ġ�Ҳ����˵��ͬһ�������ǲ���ͬʱ�������߳���������synchronized�еġ�
 * ������߳�ͬ����
 * 
 * �߳�������˳�򣬺ʹ�����Ⱥ�˳����������û�й�ϵ�ģ�
 * wait��notify�����ͬһ��object�ģ������̡߳�������һƪ���ڽ����������������̡߳�
 */

//˳��˵һ�£����û���߳���wait������notify�ǲ�����ʲô����ģ�����������
public class BaiDuWaitNotify {
	public static void main(String[] args) {
		final Object object = new Object();
		Thread t1 = new Thread() {
			public void run()
			{
				synchronized (object) {
					System.out.println("T1 start!");
					object.notify();
					System.out.println("T1 end!");
				}
			}
		};
		t1.start();
	}

}

/*
 * ���н��
 * T1 start!
 * T1 end!
 * 
 * http://zhidao.baidu.com/link?url=TD7dUlq837hsc5E_rpUUMrDtzfVYffvbBdwHISAoyFV0xNfxtwrAI9pTbpaXR6g2Ir67gfkPobhnhU_CIF4yiK
 * http://zhidao.baidu.com/link?url=TD7dUlq837hsc5E_rpUUMrDtzfVYffvbBdwHISAoyFV0xNfxtwrAI9pTbpaXR6g2Ir67gfkPobhnhU_CIF4yiK
 * ��Ҫע��ĸ����ǣ�
 * 	������obj��wait������ notify��������ǰ��������obj����Ҳ���Ǳ���д��synchronized��obj�� {����} ������ڡ�
 * 	������obj.wait�������߳�A���ͷ���obj�����������߳�B�޷����obj����Ҳ���޷���synchronized��obj�� {����} ������ڻ���A.
 * 	����obj.wait�����������غ��߳�A��Ҫ�ٴλ��obj�������ܼ���ִ�С�
 * 	�����A1��A2��A3����obj.wait��������B����obj.notify����ֻ�ܻ���A1��A2��A3�е�һ����������һ����JVM��������
 * 	��obj.notifyAll��������ȫ������A1��A2��A3������Ҫ����ִ��obj.wait��������һ����䣬������obj������ˣ�A1��A2��A3ֻ��һ���л�����������ִ�У�����A1���������Ҫ�ȴ�A1�ͷ�obj��֮����ܼ���ִ�С�
 * 	����B����obj.notify/notifyAll��ʱ��B������obj������ˣ�A1��A2��A3�䱻���ѣ��������޷����obj����ֱ��B�˳�synchronized�飬�ͷ�obj����A1��A2��A3�е�һ�����л�����������ִ�С�
 */