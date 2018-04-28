package AnnotedClasses;
import java.util.Set;
import javax.persistence.*;
@Entity
@Table(name="assignment1.set", 
	   uniqueConstraints={@UniqueConstraint(columnNames={"idset"})})
public class SetH {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idset",nullable=false, unique=true, length=11)
	private long id;
	@Column(name = "points_player1",length=10, nullable=true)
	private int pp1;
	@Column(name = "points_player2",length=10, nullable=true)
	private int pp2;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getPp1() {
		return pp1;
	}
	public void setPp1(int pp1) {
		this.pp1 = pp1;
	}
	public int getPp2() {
		return pp2;
	}
	public void setPp2(int pp2) {
		this.pp2 = pp2;
	}
}
