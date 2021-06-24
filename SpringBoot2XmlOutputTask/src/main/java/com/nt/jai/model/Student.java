
package com.nt.jai.model;

import java.util.List;
import java.util.Map;
import java.util.Set;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data

@NoArgsConstructor

@AllArgsConstructor
public class Student {


	private Integer sid;
	private String sname;
	private Set <String> subs;

	private List <Integer> marks;
	private Map <String,String> grades;

	private StdCourse Course;
}
