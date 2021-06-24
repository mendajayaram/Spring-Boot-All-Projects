package com.nt.jai.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	private Integer userId;
	private String userName;
	private String userRole;
	private String userDept;
}
