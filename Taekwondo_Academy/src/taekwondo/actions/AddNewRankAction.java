package taekwondo.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import taekwondo.models.BeltRank;
import taekwondo.models.ProductDetails;
import taekwondo.services.CommonService;

public class AddNewRankAction extends ActionSupport implements ModelDriven<BeltRank>{

	BeltRank obj = new BeltRank();
	
	@Override
	public void validate() {
		//addFieldError("hh", "Must not be empty");
	}
	@Override
	public String execute() throws Exception {
		
		CommonService service = new CommonService();
		if(service.addRank(obj))
			return SUCCESS;
		else
			return INPUT;
	}
	@Override
	public BeltRank getModel() {
		return obj;
	}

}

