package taekwondo.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

import taekwondo.actions.LoginNotRequired;
import taekwondo.models.User;

public class AuthenticationInterceptor_OLD implements Interceptor{

	@Override
	public void destroy() {
		
		
	}

	@Override
	public void init() {
		
	}

	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		
		Map<String, Object> session =actionInvocation.getInvocationContext().getSession();
		
		Object action = actionInvocation.getAction();

        //if the action doesn't require sign-in, then let it through.
        if (action instanceof LoginNotRequired) {
            return actionInvocation.invoke();
        }
        else
        {
        	User user=(User)session.get("user");
    		if(user==null)
    		{
    			//return ActionSupport.LOGIN;
    			return "loginRedirect";
    		}
    		return actionInvocation.invoke();
        }
		
	}

}
