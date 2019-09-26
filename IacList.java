package FabricDeploy;

import java.util.ArrayList;
import java.util.List;

public class IacList extends ArrayList<Object>{

	private static final long serialVersionUID = 1138707738650663576L;

	public IacList() {
		
	}
	
	public IacList push(Object e) {
		this.add(e);
		return this;
	}
	
}
