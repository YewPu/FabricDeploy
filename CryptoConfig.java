package FabricDeploy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CryptoConfig extends YamlBase{

	
	//{Name=Orderer, Domain=example.com, CA={Country=US, Province=California, Locality=San Francisco}, Specs=[{Hostname=orderer}]}
	public boolean addOrderer(String Name,String Domain,String Country,String Province,String Locality ,String Hostname) {
		Map<Object,Object> orderer = new HashMap<Object,Object>();
		orderer.put("Name", Name);
		orderer.put("Domain", Domain);
		
		Map<Object,Object> CA = new HashMap<Object,Object>();
		CA.put("Country",Country );
		CA.put("Province",Province );
		CA.put("Locality", Locality);
		orderer.put("CA", CA);
		
		List<Map<Object,Object>> Specs = new ArrayList<Map<Object,Object>> ();
		Map<Object,Object> tmpObj = new HashMap<Object,Object>();
		tmpObj.put("Hostname",Hostname);
		Specs.add(tmpObj);
		orderer.put("Specs", Specs);
		
		List<Object> OrdererOrgs = null;
		Object obj = getRoot().get("OrdererOrgs");
		if(null == obj) {
			OrdererOrgs = new ArrayList<Object>();
		}else {
			OrdererOrgs = (List)obj;
		}
		OrdererOrgs.add(orderer);
		getRoot().put("OrdererOrgs", OrdererOrgs);
		return false;
		
	}
	
	//{Name=Org1, Domain=org1.example.com, EnableNodeOUs=true, CA={Country=US, Province=California, Locality=San Francisco}, Template={Count=1}, Users={Count=1}}
	public boolean addOrg(String Name,String Domain,String Country,String Province,String Locality ,int Count ) {
		Map<Object,Object> org = new HashMap<Object,Object>();
		org.put("Name", Name);
		org.put("Domain", Domain);
		org.put("EnableNodeOUs", true);
		
		Map<Object,Object> CA = new HashMap<Object,Object>();
		CA.put("Country",Country );
		CA.put("Province",Province );
		CA.put("Locality", Locality);
		org.put("CA", CA);
		
		
		Map<Object,Object> Template = new HashMap<Object,Object>();
		Template.put("Count",1 );
		org.put("Template", Template);
		
		Map<Object,Object> Users = new HashMap<Object,Object>();
		Users.put("Count",1 );
		org.put("Users", Users);
		
		
		List<Object> PeerOrgs = null;
		Object obj = getRoot().get("PeerOrgs");
		if(null == obj) {
			PeerOrgs = new ArrayList<Object>();
		}else {
			PeerOrgs = (List)obj;
		}
		PeerOrgs.add(org);
		getRoot().put("PeerOrgs", PeerOrgs);
		
		return false;
	}
	
}
