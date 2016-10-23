package com.mindtree.xml;

import java.util.ArrayList;

import com.mindtree.entity.Employee;

public class EmployeeList {
	
	public static ArrayList<Employee> getList()
	{
		ArrayList<Employee> empList = new ArrayList<Employee>();
		try
		{
			Employee emp1 = new Employee("Yash","Mundhra","Manager",32000.00);
			empList.add(emp1);
			Employee emp2 = new Employee("Abhishek","Roy","Finance",27500.00);
			empList.add(emp2);
			Employee emp3 = new Employee("Pritwish","Mitra","Analyst",33750.00);
			empList.add(emp3);
		}catch(Exception e)
		{
			System.out.println("Exception occurred!!");
		}
		finally {
			return empList;
		}
	}
}
