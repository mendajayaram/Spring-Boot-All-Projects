 package com.nt.jai.processor;

import org.springframework.batch.item.ItemProcessor;

import com.nt.jai.model.Product;

public class ProductProcessor implements ItemProcessor<Product, Product> {

	@Override
	public Product process(Product item) throws Exception {
	
		item.setGst(item.getProdCost()*12/100.0);
		item.setDisc(item.getProdCost()*20/100.0);
		return item;
	}

}
