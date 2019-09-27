package taekwondo.actions;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import taekwondo.models.InstructorDetails;
import taekwondo.models.UserDetails;
import taekwondo.services.LoginService;

public class LoginAction extends ActionSupport implements SessionAware,LoginNotRequired,ModelDriven<UserDetails>{

	/*
	 * public String userName; public String password;
	 */
	UserDetails user= new UserDetails();
	Map<String, Object> session;
	LoginService loginService = new LoginService();
	
	/*
	 * public String getUserName() { return userName; } public void
	 * setUserName(String userName) { this.userName = userName; } public String
	 * getPassword() { return password; } public void setPassword(String password) {
	 * this.password = password; }
	 */
	
	@Override
	public String execute()
	{
		clearFieldErrors();
		UserDetails loginUser= (UserDetails) session.get("USER");
		if(loginUser!=null)
		{
			return SUCCESS;
		}
		else
		{	
			if(user==null)
			{
				return INPUT;
			}
			UserDetails obj =checkUser(user);
			if(obj !=null && obj.getUserName()!=null)
			{
				session.put("USER", obj);
				return SUCCESS;
			}
			else
			{
				addFieldError("invalid", "Invalid username or password");
			}
			return INPUT;
		}
		//return SUCCESS;
	}

	public UserDetails checkUser(UserDetails user)
	{
		return loginService.checkLogin(user);
		
	}

	@Override
	public void setSession(Map<String, Object> session) {
		
		this.session=session;
	}

	@Override
	public UserDetails getModel() {
		return user;
	}
	
	/*
	 * InstructorDetails instructor = new InstructorDetails(); Map<String, Object>
	 * session;
	 * 
	 * @Override public InstructorDetails getModel() { return instructor; }
	 * 
	 * @Override public void validate() { addFieldError("", "Must not be empty"); }
	 * 
	 * @Override public String execute() throws Exception {
	 * 
	 * System.out.println(instructor.getUserID()); session.put("LoginUser",
	 * instructor.getUserID()); return null; }
	 * 
	 * @Override public void setSession(Map<String, Object> session) {
	 * 
	 * this.session=session;
	 * 
	 * }
	 */
	
}
