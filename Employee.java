package com.mindtree.entity;

public class Employee {
		private String firstName;
		private String lastName;
		private String designation;
		private double salary;
		
		public Employee(String firstName, String lastName, String designation, double salary) {
			this.firstName = firstName;
			this.lastName = lastName;
			this.designation = designation;
			this.salary = salary;
		}

		public String getFirstName() {
			return firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public String getDesignation() {
			return designation;
		}

		public double getSalary() {
			return salary;
		}
		
		@Override
		public String toString()
		{
			return firstName+"\t"+lastName+"\t"+designation+"\t"+salary;
		}
}
