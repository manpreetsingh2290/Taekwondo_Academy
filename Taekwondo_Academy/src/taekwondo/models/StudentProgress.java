package taekwondo.models;

import java.io.Serializable;

import java.util.Date;




public class StudentProgress implements Serializable{

	
	private int studentID;
	
	
	private int rankID;
	 
	
	private Date rankAttainDate;

	private String belt;

	@Override
	public String toString() {
		return "StudentProgress [studentID=" + studentID + ", rankID=" + rankID + ", rankAttainDate=" + rankAttainDate
				+ ", belt=" + belt + "]";
	}

	public String getBelt() {
		return belt;
	}

	public void setBelt(String belt) {
		this.belt = belt;
	}

	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	public int getRankID() {
		return rankID;
	}

	public void setRankID(int rankID) {
		this.rankID = rankID;
	}

	public Date getRankAttainDate() {
		return rankAttainDate;
	}

	public void setRankAttainDate(Date rankAttainDate) {
		this.rankAttainDate = rankAttainDate;
	}
	
	
}
