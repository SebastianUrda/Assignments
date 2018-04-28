package AnnotedClasses;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="account", 
	   uniqueConstraints={@UniqueConstraint(columnNames={"idaccount"})})
public class AccountH {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idaccount")
	private int id;
	
	@Column(name="balance", length=100, nullable=true)
	private int balance;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
}
