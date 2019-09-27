
package taekwondo.interceptors;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

import taekwondo.actions.LoginNotRequired;
import taekwondo.models.UserDetails;

public class AuthenticationInterceptor implements Interceptor {

	private static final long serialVersionUID = -5011962009065225959L;

	@Override
	public void destroy() {
		//release resources here
	}

	@Override
	public void init() {
		// create resources here
	}

	@Override
	public String intercept(ActionInvocation actionInvocation)
			throws Exception {
		System.out.println("inside auth interceptor");
		Map<String, Object> sessionAttributes = actionInvocation.getInvocationContext().getSession();
		
		UserDetails user = (UserDetails) sessionAttributes.get("USER");
		
		Action action = (Action) actionInvocation.getAction();
		if(action instanceof LoginNotRequired){
			return actionInvocation.invoke();
		}
		else if(user == null)
		{
			return Action.LOGIN;
		}
		else
		{
			return actionInvocation.invoke();
		}
		/*
		 * if(user == null){ return Action.LOGIN; }else{ Action action = (Action)
		 * actionInvocation.getAction(); if(action instanceof LoginNotRequired){ return
		 * actionInvocation.invoke(); } return actionInvocation.invoke(); }
		 */
	}

}
