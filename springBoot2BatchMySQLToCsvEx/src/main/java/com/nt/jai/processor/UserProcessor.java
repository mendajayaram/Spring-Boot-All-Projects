package com.nt.jai.processor;

import org.springframework.batch.item.ItemProcessor;

import com.nt.jai.model.User;

public class UserProcessor  implements ItemProcessor<User, User>{

	@Override
	public User process(User item) throws Exception {
		// TODO Auto-generated method stub
		return item;
	}

}
