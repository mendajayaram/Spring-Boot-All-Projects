package com.nt.jai.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Product {
	private Integer prodId;
	private String prodCode;
	private double prodCost;
	private double gst;
	private double disc;
}
