package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Person {
	private int id;
	private String name;
	private String password;
	private String email;
	private Boolean isadmin;
	
	

	public Person(){}
	
	public Person(int id, String name, String email, Boolean isadmin) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.isadmin = isadmin;
	}

	public Person(String name, String password, String email, Boolean isadmin) {
		this.name = name;
		this.password = password;
		this.email = email;
		this.isadmin = isadmin;
	}

	public Person (int id, String name, String password, String email,Boolean isadmin) {
		
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.isadmin=isadmin;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getIsAdmin() {
		return isadmin;
	}

	public void setIsAdmin(Boolean isadmin) {
		this.isadmin = isadmin;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getIsadmin() {
		return isadmin;
	}

	public void setIsadmin(Boolean isadmin) {
		this.isadmin = isadmin;
	}
	
	
	
	
	
	

}
