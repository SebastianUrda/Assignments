package AnnotedClasses;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name="person", 
	   uniqueConstraints={@UniqueConstraint(columnNames={"idperson"})})
		public class PersonH {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idperson", unique = true, nullable = false)
	private int id;
	
	@Column(name="name", length=100, nullable=true)
	private String name;
	
	@Column(name="email", length=100, nullable=true)
	private String email;
	
	@Column(name="password", length=100, nullable=true)
	private String password;
	
	@Column(name="isadmin", length=100, nullable=true)
	private Boolean isadmin;
	
	@ManyToOne
	@JoinColumn(name="personaccount")
	private AccountH account;
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getIsadmin() {
		return isadmin;
	}

	public void setIsadmin(Boolean isadmin) {
		this.isadmin = isadmin;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public AccountH getAccount() {
		return account;
	}

	public void setAccount(AccountH account) {
		this.account = account;
	}
	
	
}
