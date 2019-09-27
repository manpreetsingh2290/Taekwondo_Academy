package taekwondo.actions;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import taekwondo.models.BeltRank;
import taekwondo.models.ClassDetails;
import taekwondo.services.CommonService;

public class ViewAllRanksAction extends ActionSupport {
	

	List<BeltRank> list;
	
	public List<BeltRank> getList() {
		return list;
	}
	public void setList(List<BeltRank> list) {
		this.list = list;
	}
	@Override
	public void validate() {
		//addFieldError("hh", "Must not be empty");
	}
	@Override
	public String execute() throws Exception {
		
		CommonService service = new CommonService();
		list = service.getAllRank();
		
		if(list!=null)
			return SUCCESS;
		else
			return INPUT;
	}

}
