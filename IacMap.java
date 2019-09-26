package FabricDeploy;

import java.util.LinkedHashMap;
import java.util.Map;

public class IacMap extends LinkedHashMap<String, Object> {

	private static final long serialVersionUID = 5257863356128798034L;

	public IacMap() {
		
	}
	
//	public IacMap add(Object e) {
//		if(e instanceof  Map.Entry ) {
//			this.put(
//			 (String)((Map.Entry) e).getKey()
//			,((Map.Entry) e).getValue()
//			);
//		}
//		return this;
//	}
	
	public IacMap add(String key,Object value) {
		this.put(key, value);
		
		return this;
	}
}
