package org.sid.service;

import org.springframework.beans.factory.annotation.Autowired;

public class Test {
	
	static ServiceBanque serviceBanque;
	
	static boolean res1, res2, res3;

	public static void main(String[] args) {
		
		res1 = serviceBanque.connexion("samuel@gmail.com", "123456");
		res2 = serviceBanque.connexion("ok@gmail.com", "123456");
		res3 = serviceBanque.connexion("samuel@gmail.com", "123987");
		
		System.out.println(res1);
		System.out.println(res2);
		System.out.println(res3);
	}

}
