package domain.person;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({Lecturer.class, Student.class})
@Entity
@Table(name = "person")
@Inheritance(strategy = InheritanceType.JOINED)
public class Person {
	
	@Id
	@GeneratedValue
	@Column(name = "person_id", nullable = false, unique = true)
	@XmlElement(name="person_id")
	protected int _id;
	
	@XmlElement(name="last_name")
	@Column(name = "last_name",nullable = false,length = 10)
	protected String _lastname;
	
	@XmlElement(name="first_name")
	@Column(name = "first_name",nullable = false,length = 10)
	protected String _firstname;
	
	@XmlElement(name="nick_name")
	@Column(name = "nick_name",nullable=true,length=10)
	protected String _nickname;
	
	public Person(){
		this._firstname = "Null_first_name";
		this._lastname = "Null_last_name";
		this._nickname = "Null_nick_name";
	}
	
	public Person(String firstName){
		this();
		if (firstName == null || firstName.equals("")) { 
			this._firstname = "Null_first_name"; 
		}else{
			this._firstname = firstName;
		}
		
	}
	
	public Person(String firstName,String lastName){
		this(firstName);
		if (lastName == null || lastName.equals("")) { 
			this._lastname = "Null_last_name"; 
		}else{
			this._lastname = lastName;
		}
		
	}
	
	public Person(String firstName,String lastName,String nickName){
		this(firstName,nickName);
		if (nickName == null || nickName.equals("")) { 
			this._nickname = "Null_nick_name"; 
		}else{
			this._nickname = nickName;
		}
		
	}
	
	public int get_id() {
		return _id;
	}
	
	public void set_id(int _id) {
		this._id = _id;
	}
	
	public String get_lastname() {
		return _lastname;
	}
	
	public void set_lastname(String _lastname) {
		this._lastname = _lastname;
	}
	
	public String get_firstname() {
		return _firstname;
	}
	
	public void set_firstname(String _firstname) {
		this._firstname = _firstname;
	}
	
	public String get_nickname() {
		return _nickname;
	}

	public void set_nickname(String _nickname) {
		this._nickname = _nickname;
	}
}
