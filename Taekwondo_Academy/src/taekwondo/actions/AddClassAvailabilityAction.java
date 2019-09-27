package taekwondo.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import taekwondo.models.ClassAvailabilityDetails;
import taekwondo.models.ClassDetails;
import taekwondo.services.CommonService;

public class AddClassAvailabilityAction extends ActionSupport implements ModelDriven<ClassAvailabilityDetails>{

	ClassAvailabilityDetails obj = new ClassAvailabilityDetails();

	/*int classID;
	
	
	public int getClassID() {
		return classID;
	}
	public void setClassID(int classID) {
		this.classID = classID;
	}*/
	int tempClassID;
	
	
	public int getTempClassID() {
		return tempClassID;
	}
	public void setTempClassID(int tempClassID) {
		this.tempClassID = tempClassID;
	}
	@Override
	public void validate() {
		//addFieldError("hh", "Must not be empty");
	}
	@Override
	public String execute() throws Exception {
		
		CommonService service = new CommonService();
		obj.setClassID(tempClassID);
		String startTime=changeTimeFormat(obj.getStartTime());
		String endTime=changeTimeFormat(obj.getEndTime());
		obj.setStartTime(startTime);
		obj.setEndTime(endTime);
		
		if(service.addClassAvailabilityDetails(obj))
			return SUCCESS;
		else
			return INPUT;
	}
	@Override
	public ClassAvailabilityDetails getModel() {
		return obj;
	}
	
	public String changeTimeFormat(String timeString)
	{
		String formattedTimeStr="";
		try
		{
			if(timeString!=null)
			{
				String ar[]=timeString.split(":");
				int hours=Integer.parseInt(ar[0]);
				if(hours >12)
				{
					formattedTimeStr="0"+(hours-12)+":"+ar[1]+" PM";
				}
				else
				{
					formattedTimeStr=timeString+" AM";
				}
				return formattedTimeStr;
			}			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return timeString;
	}

}
