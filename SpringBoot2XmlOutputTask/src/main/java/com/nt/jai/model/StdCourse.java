package com.nt.jai.model;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StdCourse {

	private Integer cid;
	private String  cname;
	private double  cfee;

}
