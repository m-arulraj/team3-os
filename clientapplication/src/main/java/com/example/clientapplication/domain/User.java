package com.example.clientapplication.domain;

import lombok.Data;

@Data
public class User {

	    long id;		
		String username;
        String password;

		public boolean isNew() {
			return (this.id == 0);
		}
		
}
