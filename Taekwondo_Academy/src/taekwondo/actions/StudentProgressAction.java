package taekwondo.actions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

import taekwondo.models.BeltRank;
import taekwondo.models.ClassDetails;
import taekwondo.models.StudentDetails;
import taekwondo.models.StudentForCity;
import taekwondo.models.StudentProgress;
import taekwondo.models.StudentRank;
import taekwondo.services.CommonService;

public class StudentProgressAction extends ActionSupport {
	
	
	int studentID;
	
	String studentProgress;
	String studentName;
	
	
	
	
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getStudentID() {
		return studentID;
	}
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	public String getStudentProgress() {
		return studentProgress;
	}
	public void setStudentProgress(String studentProgress) {
		this.studentProgress = studentProgress;
	}
	@Override
	public void validate() {
		//addFieldError("hh", "Must not be empty");
	}
	@Override
	public String execute() throws Exception {
		
		Gson gsonObj = new Gson();
		
		Map<Object,Object> map = null;
		
		List<Map<Object,Object>> list = new ArrayList<Map<Object,Object>>();
		 
	
		CommonService service = new CommonService();
		List <StudentRank> temp = service.getStudentRank(studentID);

		for(StudentRank s : temp) {
			BeltRank br = service.getBelt(s.getRankID());
			map = new HashMap<Object,Object>(); map.put("label", s.getRankAttainDate().substring(0, 10)); map.put("y", s.getRankID());
			map.put("Belt", br.getBeltColor());
			
			list.add(map);
		}
		
		studentProgress  = gsonObj.toJson(list);
		
		
		StudentDetails sd = service.getStudentDetails(studentID);
		
		studentName=sd.getFirstName()+" "+sd.getLastName();
		System.out.println(studentName);
		

		if(list!=null)
			return SUCCESS;
		else
			return INPUT;
	}

}
