package domain.person;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@Entity
@Table(name = "student")
@PrimaryKeyJoinColumn(name="person_id")
@XmlType(name="student")
@XmlAccessorType(XmlAccessType.FIELD)
public class Student extends Person{
	
	@Column(name = "NO_YEAR")
	private int _numberOfYear;

	public int get_numberOfYear() {
		return _numberOfYear;
	}

	public void set_numberOfYear(int _numberOfYear) {
		this._numberOfYear = _numberOfYear;
	}
}
