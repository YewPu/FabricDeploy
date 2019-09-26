package FabricDeploy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.Writer;
import java.util.List;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

public class IacYamlMain {

	
	public static void main(String[] args) {
    	Writer writer;
        int rp, p;

        try {
            Map root = null;
            List<?> Organizations;
            Map Capabilities,Application,Orderer,Channel,Profiles;
            Yaml yaml = new Yaml();
            File file = new File("/root/configtx.yaml");

            //也可以将值转换为Map
            root = (Map) yaml.load(new FileInputStream(file));
            //通过map我们取值就可以了.
//            String version = (String) root.get("version");
//            Organizations = (List) root.get("Organizations");
//            Capabilities = (Map) root.get("Capabilities");
//            Application = (Map) root.get("Application");
//            Orderer = (Map) root.get("Orderer");
//            Channel = (Map) root.get("Channel");
            Profiles = (Map) root.get("Profiles");
//        	System.exit(0);
//
            FileWriter fileWriter = new FileWriter(new File("/root/test.yaml"));
            fileWriter.write(yaml.dump(Profiles));
            fileWriter.flush();
            fileWriter.close();
            
//            CryptoConfig cryconf = new CryptoConfig();
//            cryconf.create();
////            String version = "2";
//            cryconf.setYamlVersion(version);
//          //{Name=Orderer, Domain=example.com, CA={Country=US, Province=California, Locality=San Francisco}, Specs=[{Hostname=orderer}]}
//            String Name = "Orderer";
//            String Domain = "example.com";
//            String Country = "US";
//            String Province = "California";
//            String Locality = "San Francisco";
//            String Hostname = "orderer";
//            cryconf.addOrderer(Name, Domain, Country, Province, Locality, Hostname);
//            
//          //{Name=Org1, Domain=org1.example.com, EnableNodeOUs=true, CA={Country=US, Province=California, Locality=San Francisco}, Template={Count=1}, Users={Count=1}}
//            Name = "Org1";
//            Domain="org1.example.com";
//            int Count = 1;
//            //cryconf.addOrg(Name, Domain, Country, Province, Locality, Count);
//            cryconf.write("/root/test2.yaml");
            
            Configtx conftx = new Configtx();
            conftx.create();
            conftx.setYamlVersion("2");
            conftx.getRoot().put("Organizations",conftx.Organizations());
            conftx.getRoot().put("Capabilities",conftx.Capabilities());
            conftx.getRoot().put("Application",conftx.Application());
            conftx.getRoot().put("Orderer",conftx.Orderer());
            conftx.getRoot().put("Channel",conftx.Channel());
            conftx.getRoot().put("Profiles",conftx.Profiles());
            
            conftx.write("/root/test2.yaml");
            
            System.out.println("ok");
        } catch (Exception e) {
            e.printStackTrace();
        }

	}

}
