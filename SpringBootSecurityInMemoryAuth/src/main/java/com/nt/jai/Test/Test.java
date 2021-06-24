package com.nt.jai.Test;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Test {

	public static void main(String[] args) {
		BCryptPasswordEncoder enc=new BCryptPasswordEncoder();
	String ep=	enc.encode("syed");
	System.out.println(ep);
		

	}

}
