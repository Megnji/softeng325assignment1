package domain.person;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAccessType;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import domain.course.Course;

@XmlType(name="lecture")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "lecture")
@PrimaryKeyJoinColumn(name="person_id")
public class Lecturer extends Person {

	@Column(name="office_address")
	@XmlElement(name="office_address")
	private String _officeAddress;
	
	@OneToMany(mappedBy = "taughtBy")
	@Cascade(CascadeType.ALL)
	@XmlElementWrapper(name="courses")
	@XmlElement(name="course")
	private List<Course> _courses;

	public Lecturer(){
		super();
		this._officeAddress = "No_office_information";
	}
	
	public Lecturer(String office){
		this();
		if (office == null || office.equals("")){
			this._officeAddress = "No_office_information";
		}else{
			this._officeAddress = office;
		}
	}
	
	public String get_officeAddress() {
		return _officeAddress;
	}

	public void set_officeAddress(String _officeAddress) {
		this._officeAddress = _officeAddress;
	}

	public List<Course> get_courses() {
		return _courses;
	}

	public void set_courses(List<Course> _courses) {
		this._courses = _courses;
	}
	
	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		
		
		buffer.append("Lecture: { [");
		buffer.append(_id);
		buffer.append("]; ");
		if(_lastname != null) {
			buffer.append(_lastname);
			buffer.append(", ");
		}
		if(get_firstname() != null) {
			buffer.append(_firstname);
		}
		buffer.append("; ");
		if(_nickname != null) {
			buffer.append(_nickname);
		}
		buffer.append("; ");
		buffer.append("\n  ");
		
		buffer.append(" }");
		
		return buffer.toString();
	}

}
