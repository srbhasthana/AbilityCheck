package org.saurabh.billing;

import java.util.HashMap;
import java.util.Map;

public class exec {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		  Map<String, Integer> itemsPurchsedByUser1 = new HashMap<String, Integer>();
		  Map<String, Integer> itemsPurchsedByUser2 = new HashMap<String, Integer>();
		  
		  itemsPurchsedByUser1.put("ID01", 10);
		  itemsPurchsedByUser1.put("ID03", 10);
		  itemsPurchsedByUser2.put("ID02", 10);
		  itemsPurchsedByUser2.put("ID04", 20);
		  
		  DiscountOffered dO  = new DiscountOffered();
		  double  totalAmountToBePaid = dO.getDiscountableAmount("9619623927", itemsPurchsedByUser1);
		  
		  System.out.println("amount to be paid by user1:" + totalAmountToBePaid);
		  totalAmountToBePaid = dO.getDiscountableAmount("9987779348", itemsPurchsedByUser2);
		  System.out.println("amount to be paid by user2:" + totalAmountToBePaid);

	}

}
