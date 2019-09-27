package taekwondo.services;

import taekwondo.database.dao.LoginInfoDao;
import taekwondo.models.InstructorDetails;
import taekwondo.models.UserDetails;

public class LoginService {

	public UserDetails checkLogin(UserDetails user)
	{
		
		LoginInfoDao dao= new LoginInfoDao();
		UserDetails obj= dao.checkLogin(user.getUserName(), user.getPassword());	
		if(obj!=null && obj.getUserName() != null && !"".equalsIgnoreCase(obj.getUserName()))
		{
			return obj;
		}
		return null;
				
	}
}
