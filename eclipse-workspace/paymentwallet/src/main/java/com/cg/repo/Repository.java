package com.cg.repo;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cg.dto.Account;
import com.cg.dto.Transaction;
import com.cg.dto.User;

public class Repository {
	public static List<Transaction> lst=new ArrayList<Transaction>();
	public static Map<String,Account> map=new HashMap<>();
	public static Map<Integer,Transaction> map1=new HashMap<>();
	public static int tid =100;
	static
	{
		User user1=new User("101","suman","124hxvs","7984531522");
		Account acc1=new Account("12345841545",1000,"completed",user1);
		Transaction tr1=new Transaction(10001,"hsbgdshc",LocalDate.of(2019,06,14),500,acc1);
		Transaction tr2=new Transaction(10002,"vtrchkcj",LocalDate.of(2019,06,15),300,acc1);
		lst.add(tr1);
		lst.add(tr2);
		map.put(acc1.getAccountId(),acc1);
	
		

		User user2=new User("102","lova","251bshcx","7087524455");
		Account acc2=new Account("12245841545",1000,"completed",user2);
		Transaction tr3=new Transaction(10003,"hsbgdshc",LocalDate.of(2019,10,10),500,acc2);
		Transaction tr4=new Transaction(10004,"vtrchkcj",LocalDate.of(2019,06,11),300,acc2);
		lst.add(tr3);
		lst.add(tr4);
		map.put(acc2.getAccountId(),acc2);
		
		User user3=new User("103","abcd","251bshcx","7087524455");
		Account acc3=new Account("12245841565",1000,"complet-ed",user3);
		Transaction tr5=new Transaction(10003,"hsbgdshc",LocalDate.of(2019,02,06),500,acc3);
		Transaction tr6=new Transaction(10004,"vtrchkcj",LocalDate.of(2019,02,07),300,acc3);
		lst.add(tr5);
		lst.add(tr6);
		map.put(acc3.getAccountId(),acc3);
	}
	
	
	
	
	

}
