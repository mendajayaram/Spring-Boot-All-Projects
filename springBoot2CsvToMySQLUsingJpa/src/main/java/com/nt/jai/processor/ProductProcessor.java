package com.nt.jai.processor;

import org.springframework.batch.item.ItemProcessor;

import com.nt.jai.model.Product;

public class ProductProcessor implements ItemProcessor<Product, Product>{

	

	@Override
	public Product process(Product item) throws Exception {
		// TODO Auto-generated method stub
		 var  cost=item.getProdCost();
		 item.setProdGst(cost*12/100);
		 item.setProdDiscount(cost*8/100);
		 return item;
	}

	
}

