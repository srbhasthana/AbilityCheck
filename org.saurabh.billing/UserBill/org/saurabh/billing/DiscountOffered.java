package org.saurabh.billing;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiscountOffered {

	private static Map<String ,Boolean> employeeRecord  = new HashMap<String,Boolean>();

	private static Map<String, Integer> groceryRecord = new HashMap<String, Integer>();

	private static Map<String, Integer> nonGroceryRecord = new HashMap<String, Integer>();

	private static List<Customer> customerInfo = new ArrayList<Customer>();

	public DiscountOffered(){
		employeeRecord.put("9619623927", true);
		employeeRecord.put("9987779348", false);
		groceryRecord.put("ID01", 100);
		groceryRecord.put("ID02", 110);
		nonGroceryRecord.put("ID03", 200);
		nonGroceryRecord.put("ID04", 300);
		Customer customer = new Customer();
		customer.setName("Gokul");
		customer.setMobileNumber("9987779348");
		customer.setDateOfEnrollment(new Date());

		customerInfo.add(customer);
	}

	public float calculateEmployeeDiscount(int discountAmount) {

		return  (float) (discountAmount*0.3);		
	}

	public double getDiscountableAmount(String mobileNumber, Map<String,Integer> productInfo){

		int groceryAmount = 0;

		double discountAmount;
		for(Map.Entry<String, Integer> item : productInfo.entrySet()){
			groceryAmount  = groceryAmount + groceryRecord.get(item.getKey()) * item.getValue();
		}

		int nonGroceryAmount = 0;

		for(Map.Entry<String, Integer> item : productInfo.entrySet()){
			nonGroceryAmount  = nonGroceryAmount + nonGroceryRecord.get(item.getKey()) * item.getValue();
		}

		if(employeeRecord.get(mobileNumber)){
			discountAmount = calculateEmployeeDiscount(nonGroceryAmount);
		}
		else {
			discountAmount = calculateCustomerDiscount(mobileNumber, nonGroceryAmount);
		}

		double billedAmount = groceryAmount+nonGroceryAmount-discountAmount;

		return billedAmount;

	}

	public Boolean checkIfEmployee(String mobileNumber) {

		return employeeRecord.get(mobileNumber);

	}

	public double calculateCustomerDiscount(String mobileNumber, int discountAmount){

		for (Customer customer : customerInfo) {

			if(customer.getMobileNumber().equalsIgnoreCase(mobileNumber)){

				Date timeOfFirstJoining = customer.getDateOfEnrollment();
				Date currentTime = new Date();
				if( currentTime.getYear() - timeOfFirstJoining.getYear()  > 2){
					return (discountAmount*.05);
				}
				else {
					return 0;
				}
			}								
		}
		
		//For affiliate discount
		return discountAmount*0.1;


	}



}
