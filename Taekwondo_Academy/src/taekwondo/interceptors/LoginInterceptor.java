package taekwondo.interceptors;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import taekwondo.actions.LoginAction;
import taekwondo.actions.LoginNotRequired;
import taekwondo.models.User;

public class LoginInterceptor extends AbstractInterceptor {
   
	private static final long serialVersionUID = -3087455920575829444L;

	@Override
    public String intercept(final ActionInvocation actionInvocation) throws Exception {
        Map<String, Object> session = ActionContext.getContext().getSession();
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
    			return ActionSupport.LOGIN;
    		}
    		return actionInvocation.invoke();
        }
       // return actionInvocation.invoke();
    }
}