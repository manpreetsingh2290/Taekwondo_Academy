package taekwondo.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "BELT_RANK")
@SequenceGenerator(name= "RANK_ID_SEQ", sequenceName = "RANK_ID_SEQ", initialValue=1, allocationSize = 1)
public class BeltRank  implements Serializable{

	@Id 
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="RANK_ID_SEQ")
	@Column(name="Rank_ID")
	private int rankID;
	
	@Column(name="Belt_Color")
	private String beltColor;
	
	
	@Column(name="Rank_Level")
	private String rankLevel;


	public int getRankID() {
		return rankID;
	}


	public void setRankID(int rankID) {
		this.rankID = rankID;
	}


	public String getBeltColor() {
		return beltColor;
	}


	public void setBeltColor(String beltColor) {
		this.beltColor = beltColor;
	}


	public String getRankLevel() {
		return rankLevel;
	}


	public void setRankLevel(String rankLevel) {
		this.rankLevel = rankLevel;
	}


	@Override
	public String toString() {
		return "BeltRank [rankID=" + rankID + ", beltColor=" + beltColor + ", rankLevel=" + rankLevel + "]";
	}
	
	
	
	
}
