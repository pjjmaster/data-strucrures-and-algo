package com.practice.stack;

import java.util.HashSet;

public class Employee {

	int id;
	
	Employee(int id){
		this.id = id;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Employee) {
			Employee emp = (Employee) obj;
 			return this.id==emp.getId();
		} else {
			return super.equals(obj);
		}
	}
	
	@Override
    public int hashCode() {
        return this.id;
    }
	
	public static void main(String[] args) {
		Employee em1 = new Employee(0);
		Employee em2 = new Employee(2);
		Employee em3 = new Employee(2);
		Employee em4 = new Employee(3);
		Employee em5 = new Employee(0);
		
		HashSet<Employee> set = new HashSet<>();
		set.add(em1);
		set.add(em2);set.add(em3);set.add(em4);
		set.add(em5);
		System.out.println("Employee.main()" + set.size());
	}
}
