package taekwondo.actions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

import taekwondo.models.ClassDetails;
import taekwondo.models.StudentForCity;
import taekwondo.services.CommonService;

public class DashboardAction extends ActionSupport {
	
	
	int totalNoOfStudents;
	int totalNoOfOrders;
	int totalNoOfClasses;
	int totalNoOfProducts;
	
   String revenueData;

	
	

	public String getRevenueData() {
	return revenueData;
}
public void setRevenueData(String revenueData) {
	this.revenueData = revenueData;
}
	public int getTotalNoOfProducts() {
		return totalNoOfProducts;
	}
	public void setTotalNoOfProducts(int totalNoOfProducts) {
		this.totalNoOfProducts = totalNoOfProducts;
	}
	public int getTotalNoOfStudents() {
		return totalNoOfStudents;
	}
	public void setTotalNoOfStudents(int totalNoOfStudents) {
		this.totalNoOfStudents = totalNoOfStudents;
	}
	public int getTotalNoOfOrders() {
		return totalNoOfOrders;
	}
	public void setTotalNoOfOrders(int totalNoOfOrders) {
		this.totalNoOfOrders = totalNoOfOrders;
	}
	public int getTotalNoOfClasses() {
		return totalNoOfClasses;
	}
	public void setTotalNoOfClasses(int totalNoOfClasses) {
		this.totalNoOfClasses = totalNoOfClasses;
	}


	String cityWiseStudents;
	String revenue;
	
	
	
	
	public String getCityWiseStudents() {
		return cityWiseStudents;
	}
	public void setCityWiseStudents(String cityWiseStudents) {
		this.cityWiseStudents = cityWiseStudents;
	}
	public String getRevenue() {
		return revenue;
	}
	public void setRevenue(String revenue) {
		this.revenue = revenue;
	}
	
	
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
		List <StudentForCity> temp = service.getStudentForCity();
		int max=-1;
		for(StudentForCity s : temp) {
			map = new HashMap<Object,Object>(); map.put("label", s.getCity()); map.put("y", s.getStudentCount());
			map.put("exploded", true);
			list.add(map);
		}
		
		cityWiseStudents  = gsonObj.toJson(list);
		
		
		classWiseStudentChartInitialize();
		reveneueDataSetup();
		setUp();
		

		if(list!=null)
			return SUCCESS;
		else
			return SUCCESS;
	}
	
	public void classWiseStudentChartInitialize()
	{
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
	}
	
	public void setUp()
	{
		try
		{
			CommonService service = new CommonService();
			totalNoOfOrders=(int)service.getTotalNoOfOrders();
			totalNoOfClasses=(int)service.getTotalNoOfClasses();
			totalNoOfProducts=(int)service.getTotalNoOfProducts();
			totalNoOfStudents=(int)service.getTotalNoOfStudents();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void reveneueDataSetup() throws ParseException
	{

		
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
			
	
		revenueData  = gsonObj.toJson(list);
		
		
	
	}

}
