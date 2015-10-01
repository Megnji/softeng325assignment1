package domain.course;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import domain.person.Lecturer;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "person")
public class Course {
	@XmlElement(name="course_number")
	@Id
	@GeneratedValue
	@Column(name = "course_number", nullable = false, unique = true)
	private int _courseNo;
	@XmlElement(name="course_name")
	@Column(name = "course_name",nullable = false,length = 10)
	private String _courseName;
	@XmlElement(name="course_description")
	@Column(name = "course_description",nullable = true,length = 100)
	private String _courseDescription;
	
	@ManyToOne
	@JoinColumn(name = "lecture_id")
	@XmlElement(name="lecture")
	private Lecturer _lecturer;
	
	public Course(){
		this._courseName = "Null_course";
		this._courseDescription = "NULL";
		this._lecturer = new Lecturer();
	}
	
	public Course(String name){
		this();
		if (name == null || name.equals("")){
			this._courseName = "Null_course";
		}else {
			this._courseName = name;
		}
	}
	
	public Course(String name,String description){
		this(name);
		if (description == null || description.equals("")){
			_courseDescription = "NULL";
		}else{
			_courseDescription = description;
		}
	}
	
	public Course(Lecturer lecturer){
		this();
		if (lecturer != null){
			this._lecturer = lecturer;
		}
	}
	
	public int get_courseNo() {
		return _courseNo;
	}

	public void set_courseNo(int _courseNo) {
		this._courseNo = _courseNo;
	}

	public String get_courseName() {
		return _courseName;
	}

	public void set_courseName(String _courseName) {
		this._courseName = _courseName;
	}

	public String get_courseDescription() {
		return _courseDescription;
	}

	public void set_courseDescription(String _courseDescription) {
		this._courseDescription = _courseDescription;
	}
	
	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		
		
		buffer.append("Course: { [");
		buffer.append(_courseNo);
		buffer.append("]; ");
		if(_courseName != null) {
			buffer.append(_courseName);
			buffer.append(", ");
		}
		if(_courseDescription != null) {
			buffer.append(_courseDescription);
		}
		buffer.append("; ");
		buffer.append("\n  ");
		
		buffer.append(" }");
		
		return buffer.toString();
	}
}
