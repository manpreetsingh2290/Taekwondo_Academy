package taekwondo.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CLASS_AVAILABILITY")
public class ClassAvailabilityDetails  implements Serializable{
	
	@Id 
	@Column(name="Class_ID")	
	private int classID;
	
	@Id
	@Column(name="Class_Day")
	private String classDay;
	
	@Id
	@Column(name="Start_Time")
	private String startTime;
	
	@Id
	@Column(name="End_Time")
	private String endTime;

	public int getClassID() {
		return classID;
	}

	public void setClassID(int classID) {
		this.classID = classID;
	}

	public String getClassDay() {
		return classDay;
	}

	public void setClassDay(String classDay) {
		this.classDay = classDay;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return "ClassAvailabilityDetails [classID=" + classID + ", classDay=" + classDay + ", startTime=" + startTime
				+ ", endTime=" + endTime + "]";
	}
	
	
	
	
	
	

}
