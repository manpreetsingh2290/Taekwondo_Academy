package taekwondo.models;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT_RANK")
public class StudentRank implements Serializable{

	@Id
	@Column(name="Student_ID")
	private int studentID;
	
	@Id 
	@Column(name="Rank_ID")
	private int rankID;
	 
	@Column(name="Rank_Attain_Date")
	private Date rankAttainDate;

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

	public String getRankAttainDate() {
		return rankAttainDate.toString();
	}

	public void setRankAttainDate(String rankAttainDate) throws ParseException {
		this.rankAttainDate = new SimpleDateFormat("yyyy-MM-dd").parse(rankAttainDate);
	}

	@Override
	public String toString() {
		return "StudentRank [studentID=" + studentID + ", rankID=" + rankID + ", rankAttainDate=" + rankAttainDate
				+ "]";
	}
	
	
}
