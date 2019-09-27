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

public class ClassWiseStudents extends ActionSupport {
	
	
	String classStudents;
	
	
	
	
	
	public String getClassStudents() {
		return classStudents;
	}
	public void setClassStudents(String classStudents) {
		this.classStudents = classStudents;
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
		

		
			
			List<?> tempList = service.getStdCountClassWise();
			
			for(int i =0 ;i < tempList.size(); i++) {
	    		  Object[] temp = (Object[])tempList.get(i);
	    		  System.out.println(temp[0]+"  "+temp[1]+"\n");
	    		  
	    		  ClassDetails cd = service.getClassDetails((int)temp[0]);
	    		  map = new HashMap<Object,Object>(); map.put("label", cd.getClassDescription());map.put("y", temp[1]);
	    		  list.add(map);
	    	  }
			
			
			
			
			
			
		
		
		classStudents  = gsonObj.toJson(list);
		
		
		
		

		if(list!=null)
			return SUCCESS;
		else
			return INPUT;
	}

}
