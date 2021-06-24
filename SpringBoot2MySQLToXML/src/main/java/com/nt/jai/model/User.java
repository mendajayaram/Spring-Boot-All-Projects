package com.nt.jai.model;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "user")

public class User {
	private Integer userId;
	private String userName;
	private String userRole;
	private String userDept;
}
