package com.nt.jai.processor;

import org.springframework.batch.item.ItemProcessor;

import com.nt.jai.model.Employee;

public class Myprocessor  implements ItemProcessor<Employee, Employee>{

	@Override
	public Employee process(Employee item) throws Exception {
		item.setHra(item.getEsal()*12/100);
		item.setTa(item.getEsal()*3/100);
		return item;
	}

}
