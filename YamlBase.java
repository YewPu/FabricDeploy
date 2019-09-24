package FabricDeploy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

public class YamlBase extends Object{
	private Map<Object,Object> root = null;
	private Yaml yaml = null;
	
	public YamlBase() {

	}
	
	public Map<Object, Object> getRoot() {
		return root;
	}
	
	public boolean create() {
		yaml = new Yaml();
		root = new HashMap<Object,Object>();
		if(null != yaml && null != root) {
			return true;
		}
		
		return false;
	}
	
	public boolean read(String fileName) {
		try {
			root = (Map<Object, Object>) yaml.load(new FileInputStream(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		if(null != root)
			return true;
		return false;
	}

	public boolean write(String fileName) {

		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(fileName);
			fileWriter.write(yaml.dump(root));
			fileWriter.flush();
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return false;
	}
	
	public boolean  setYamlVersion(String version) {
		root.put("version", version);
		
		return true;
	}
	
	public String getYamlVersion() {
		Object obj = root.get("version");
		if(null == obj) {
			return "2";
		}
		if(obj instanceof String) {
			
		}
		return (String)obj;
	}
	
	public void addObject(String key,Object value) {
		root.put(key, value);
	}
}
