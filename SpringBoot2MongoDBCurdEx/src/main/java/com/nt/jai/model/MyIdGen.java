package com.nt.jai.model;

import java.util.Random;

public interface MyIdGen {
	public static int getId() {
		return new Random().nextInt(999999);
		}
}
