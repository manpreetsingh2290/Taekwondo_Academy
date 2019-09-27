package taekwondo.actions;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

public class RevenueAction extends ActionSupport {
	
	
	String revenue;
	
	
	
	
	
	
	public String getRevenue() {
		return revenue;
	}
	public void setRevenue(String revenue) {
		this.revenue = revenue;
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
		

		
			
			
			
			
			List<?> tempList = service.getMonthWiseFee();
			for(int i =0 ;i < tempList.size(); i++) {
	  		  Object[] temp = (Object[])tempList.get(i);

			
	  		  String d = temp[1].toString()+"-"+temp[2].toString();
	  		  Date date = new SimpleDateFormat("M-yyyy").parse(d);

	  		  
	  		String dd=new SimpleDateFormat("MMM-yyyy").format(date);
	  		  map = new HashMap<Object,Object>(); map.put("label", dd);map.put("y", temp[0]);
	  		 
	  		  list.add(map);
			
			    		 
	    	  }
			
			
			
			
			
			
		
		
		revenue  = gsonObj.toJson(list);
		
		
		
		

		if(tempList!=null)
			return SUCCESS;
		else
			return INPUT;
	}

}
