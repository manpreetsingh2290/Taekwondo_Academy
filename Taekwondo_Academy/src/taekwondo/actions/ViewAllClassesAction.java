package taekwondo.actions;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import taekwondo.models.ClassDetails;
import taekwondo.models.InstructorDetails;
import taekwondo.services.CommonService;

public class ViewAllClassesAction extends ActionSupport {
	
	List<ClassDetails> list;
	
	public List<ClassDetails> getList() {
		return list;
	}
	public void setList(List<ClassDetails> list) {
		this.list = list;
	}
	@Override
	public void validate() {
		//addFieldError("hh", "Must not be empty");
	}
	@Override
	public String execute() throws Exception {
		
		CommonService service = new CommonService();
		list = service.getAllClassList();
		
		if(list!=null)
		{
			InstructorDetails inst=null;
			for (ClassDetails classDetails : list) {
				inst=service.getInstructorDetails(classDetails.getInstructorID());
				classDetails.setInstructorName(inst.getFirstName()+" "+ inst.getLastName());
			}
			return SUCCESS;
		}
		else
			return INPUT;
	}
	
	/*public String changeTimeFormat(String timeString)
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
					formattedTimeStr=(hours-12)+":"+ar[0]+" PM";
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
	}*/
}
