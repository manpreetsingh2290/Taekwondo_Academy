package taekwondo.actions;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import taekwondo.models.ClassDetails;
import taekwondo.models.ProductOrder;
import taekwondo.models.StudentDetails;
import taekwondo.services.CommonService;

public class ViewAllOrdersAction extends ActionSupport {
	
	List<ProductOrder> list;
	
	public List<ProductOrder> getList() {
		return list;
	}
	public void setList(List<ProductOrder> list) {
		this.list = list;
	}
	@Override
	public void validate() {
		//addFieldError("hh", "Must not be empty");
	}
	@Override
	public String execute() throws Exception {
		
		CommonService service = new CommonService();
		list = service.getAllOrdersList();
		
		if(list!=null)
		{
			for(ProductOrder order:list)
			{
				StudentDetails student=service.getStudentDetails(order.getStudentID());
				System.out.println(student);
				order.setStudentName(student.getFirstName()+" "+student.getLastName());
			}
			return SUCCESS;
		}			
		
		return INPUT;
	}
}

