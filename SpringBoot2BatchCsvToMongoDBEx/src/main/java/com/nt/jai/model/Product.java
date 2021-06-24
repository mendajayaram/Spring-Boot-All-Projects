package com.nt.jai.model;

import lombok.Data;

@Data
public class Product {
	private Integer prodId;
	private String prodCode;
	private Double prodCost;
	private Double prodGst;
	private Double prodDiscount;
}
