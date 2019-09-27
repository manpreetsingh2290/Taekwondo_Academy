package taekwondo.actions;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport implements SessionAware{//,ModelDriven<InstructorDetails>{

	Map<String, Object> session;
	@Override
	public String execute()
	{
		session.remove("USER");
		return SUCCESS;
	}


	@Override
	public void setSession(Map<String, Object> session) {
		
		this.session=session;
	}
	
	
}
