import org.apache.commons.lang.StringUtils;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;




public class HelloWorldAction extends ActionSupport{
   private String name;

   
   @Override
	public void validate() {
	   if(StringUtils.isEmpty(name))
		addFieldError("name", "Name Must not be empty");
	}
   
   public String execute() throws Exception {
      return Action.SUCCESS;
   }
   
   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }
   
  

}