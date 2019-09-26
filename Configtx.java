package FabricDeploy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Configtx extends YamlBase {
	public enum CONSENSUS {
		SOLO, KAFKA, RAFT
	};

	// [{Name=OrdererOrg, ID=OrdererMSP,
	// MSPDir=crypto-config/ordererOrganizations/example.com/msp,
	// Policies={Readers={Type=Signature, Rule=OR('OrdererMSP.member')},
	// Writers={Type=Signature, Rule=OR('OrdererMSP.member')},
	// Admins={Type=Signature, Rule=OR('OrdererMSP.admin')}}},
	// {Name=Org1MSP, ID=Org1MSP,
	// MSPDir=crypto-config/peerOrganizations/org1.example.com/msp,
	// Policies={Readers={Type=Signature, Rule=OR('Org1MSP.admin', 'Org1MSP.peer',
	// 'Org1MSP.client')}, Writers={Type=Signature, Rule=OR('Org1MSP.admin',
	// 'Org1MSP.client')}, Admins={Type=Signature, Rule=OR('Org1MSP.admin')}},
	// AnchorPeers=[{Host=peer0.org1.example.com, Port=7051}]}]
	public IacList Organizations() {
		IacList Organizations = new IacList().push(OrdererOrg()).push(OrgN());

		return Organizations;

	}

	public IacMap OrdererOrg() {
		IacMap OrdererOrg = new IacMap();
		String Name = "OrdererOrg";
		String ID = "OrdererMSP";
		String MSPDir = "crypto-config/ordererOrganizations/example.com/msp";
		OrdererOrg.add("Name", Name).add("ID", ID).add("MSPDir", MSPDir);

		String Readers_Type = "Signature";
		String Readers_Rule = "OR('OrdererMSP.member')";
		String Writers_Type = "Signature";
		String Writers_Rule = "OR('OrdererMSP.member')";
		String Admins_Type = "Signature";
		String Admins_Rule = "OR('OrdererMSP.admin')";
		IacMap Policies = new IacMap().add("Readers", new IacMap().add("Type", Readers_Type).add("Rule", Readers_Rule))
				.add("Writers", new IacMap().add("Type", Writers_Type).add("Rule", Writers_Rule))
				.add("Admins", new IacMap().add("Type", Admins_Type).add("Rule", Admins_Rule));
		OrdererOrg.add("Policies", Policies);

		return OrdererOrg;
	}

	// {Name=Org1MSP, ID=Org1MSP,
	// MSPDir=crypto-config/peerOrganizations/org1.example.com/msp,
	// Policies={Readers={Type=Signature, Rule=OR('Org1MSP.admin', 'Org1MSP.peer',
	// 'Org1MSP.client')}, Writers={Type=Signature, Rule=OR('Org1MSP.admin',
	// 'Org1MSP.client')}, Admins={Type=Signature, Rule=OR('Org1MSP.admin')}},
	// AnchorPeers=[{Host=peer0.org1.example.com, Port=7051}]}
	public IacMap OrgN() {
		IacMap OrgN = new IacMap();
		String Name = "Org1MSP";
		String ID = "Org1MSP";
		String MSPDir = "crypto-config/peerOrganizations/org1.example.com/msp";
		String Readers_Type = "Signature";
		String Readers_Rule = "OR('Org1MSP.admin', 'Org1MSP.peer', 'Org1MSP.client')";
		String Writers_Type = "Signature";
		String Writers_Rule = "OR('Org1MSP.admin', 'Org1MSP.client')";
		String Admins_Type = "Signature";
		String Admins_Rule = "OR('Org1MSP.admin')";
		IacMap Policies = new IacMap().add("Readers", new IacMap().add("Type", Readers_Type).add("Rule", Readers_Rule))
				.add("Writers", new IacMap().add("Type", Writers_Type).add("Rule", Writers_Rule))
				.add("Admins", new IacMap().add("Type", Admins_Type).add("Rule", Admins_Rule));
		OrgN.add("Name", Name).add("ID", ID).add("MSPDir", MSPDir).add("Policies", Policies);

		IacList AnchorPeers = new IacList();
		String Host = "peer0.org1.example.com";
		String Port = "7051";
		{
			AnchorPeers.push(new IacMap().add("Host", Host).add("Port", Port));
			AnchorPeers.push(new IacMap().add("Host", Host).add("Port", Port));
		}
		OrgN.add("AnchorPeers", AnchorPeers);

		return OrgN;
	}

	// {Channel={V1_4_3=true, V1_3=false, V1_1=false}, Orderer={V1_4_2=true,
	// V1_1=false}, Application={V1_4_2=true, V1_3=false, V1_2=false, V1_1=false}}
	public IacMap Capabilities() {
		IacMap Capabilities = new IacMap();
		boolean V1_4_3 = true;
		boolean V1_3 = false;
		boolean V1_1 = false;
		Capabilities.add("Channel", new IacMap().add("V1_4_3", V1_4_3).add("V1_3", V1_3).add("V1_1", V1_1));

		boolean V1_4_2 = true;
		V1_1 = false;
		Capabilities.add("Orderer", new IacMap().add("V1_4_2", V1_4_2).add("V1_1", V1_1));

		V1_4_2 = true;
		V1_3 = false;
		boolean V1_2 = false;
		V1_1 = false;
		Capabilities.add("Application",
				new IacMap().add("V1_4_2", V1_4_2).add("V1_3", V1_3).add("V1_2", V1_2).add("V1_1", V1_1));

		return Capabilities;

	}

	public IacMap Application() {
		IacMap Application = new IacMap();

		Application.add("Organizations","");
		String Readers_Type = "ImplicitMeta";
		String Readers_Rule = "ANY Readers";
		String Writers_Type = "ImplicitMeta";
		String Writers_Rule = "ANY Writers";
		String Admins_Type = "ImplicitMeta";
		String Admins_Rule = "MAJORITY Admins";
		IacMap Policies = new IacMap().add("Readers", new IacMap().add("Type", Readers_Type).add("Rule", Readers_Rule))
				.add("Writers", new IacMap().add("Type", Writers_Type).add("Rule", Writers_Rule))
				.add("Admins", new IacMap().add("Type", Admins_Type).add("Rule", Admins_Rule));

		Application.add("Policies", Policies);

		boolean V1_4_2 = true;
		boolean V1_3 = false;
		boolean V1_2 = false;
		boolean V1_1 = false;
		Application.add("Capabilities",
				new IacMap().add("V1_4_2", V1_4_2).add("V1_3", V1_3).add("V1_2", V1_2).add("V1_1", V1_1));

		return Application;
	}

	public boolean addOrdererOrg() {
		Map<String, Object> OrdererOrg = new HashMap<String, Object>();

		String Name = "OrdererOrg";
		String ID = "OrdererMSP";
		String MSPDir = "crypto-config/ordererOrganizations/example.com/msp";
		OrdererOrg.put("Name", Name);
		OrdererOrg.put("ID", ID);
		OrdererOrg.put("MSPDir", MSPDir);

		Map<String, Object> Policies = new HashMap<String, Object>();
		String Type = "ImplicitMeta";
		String Rule = "ANY Readers";
		Map<String, Object> Readers = Readers(Type, Rule);
		Policies.put("Readers", Readers);
		Map<String, Object> Writers = Writers();
		Policies.put("Writers", Writers);
		Map<String, Object> Admins = Admins();
		Policies.put("Admins", Admins);
		OrdererOrg.put("Policies", Policies);

		return false;

	}

	public IacMap EtcdRaft() {
		IacMap EtcdRaft = new IacMap();

		IacList Consenters = new IacList();
		{
			IacMap tmpObj = new IacMap();
			String Host = "orderer.example.com";
			String Port = "7050";
			String ClientTLSCert = "crypto-config/ordererOrganizations/example.com/orderers/orderer.example.com/tls/server.crt";
			String ServerTLSCert = "crypto-config/ordererOrganizations/example.com/orderers/orderer.example.com/tls/server.crt";
			tmpObj.add("Host", Host);
			tmpObj.add("Port", Port);
			tmpObj.add("ClientTLSCert", ClientTLSCert);
			tmpObj.add("ServerTLSCert", ServerTLSCert);

			Consenters.add(tmpObj);
		}
		EtcdRaft.put("Consenters", Consenters);

		IacMap Options = new IacMap();
		{
			String TickInterval = "500ms";
			String ElectionTick = "10";
			String HeartbeatTick = "1";
			String MaxInflightBlocks = "5";
			String SnapshotIntervalSize = "200";
			Options.add("TickInterval", TickInterval);
			Options.add("ElectionTick", ElectionTick);
			Options.add("HeartbeatTick", HeartbeatTick);
			Options.add("MaxInflightBlocks", MaxInflightBlocks);
			Options.add("SnapshotIntervalSize", SnapshotIntervalSize);
		}
		EtcdRaft.add("Options", Options);

		return EtcdRaft;
	}

	// {OrdererType=etcdraft, Addresses=[orderer.example.com:7050], BatchTimeout=2s,
	// BatchSize={MaxMessageCount=10, AbsoluteMaxBytes=99 MB, PreferredMaxBytes=512
	// KB},
	// Kafka={Brokers=[127.0.0.1:9092]},
	// EtcdRaft={Consenters=[{Host=orderer.example.com, Port=7050,
	// ClientTLSCert=crypto-config/ordererOrganizations/example.com/orderers/orderer.example.com/tls/server.crt,
	// ServerTLSCert=crypto-config/ordererOrganizations/example.com/orderers/orderer.example.com/tls/server.crt}],
	// Options={TickInterval=500ms, ElectionTick=10, HeartbeatTick=1,
	// MaxInflightBlocks=5, SnapshotIntervalSize=200}}, Organizations=null,
	// Policies={Readers={Type=ImplicitMeta, Rule=ANY Readers},
	// Writers={Type=ImplicitMeta, Rule=ANY Writers}, Admins={Type=ImplicitMeta,
	// Rule=MAJORITY Admins}, BlockValidation={Type=ImplicitMeta, Rule=ANY
	// Writers}}}
	public IacMap Orderer() {
		IacMap Orderer = new IacMap();
		String OrdererType = "etcdraft";
		Orderer.add("OrdererType", OrdererType);
		IacList Addresses = new IacList();
		Addresses.push("orderer.example.com:7050");
		Orderer.add("Addresses", Addresses);
		String BatchTimeout = "2s";
		Orderer.add("BatchTimeout", BatchTimeout);

		IacMap BatchSize = new IacMap();
		{
			String MaxMessageCount = "10";
			String AbsoluteMaxBytes = "99 MB";
			String PreferredMaxBytes = "512 KB";
			BatchSize.add("MaxMessageCount", MaxMessageCount);
			BatchSize.add("AbsoluteMaxBytes", AbsoluteMaxBytes);
			BatchSize.add("PreferredMaxBytes", PreferredMaxBytes);
		}
		Orderer.add("BatchSize", BatchSize);

		IacMap Kafka = new IacMap();
		{
			IacList Brokers = new IacList();
			Brokers.add("127.0.0.1:9092");
			Kafka.add("Brokers", Brokers);
		}
		Orderer.add("Kafka", Kafka);

		Orderer.put("EtcdRaft", EtcdRaft());

		Orderer.put("Organizations", new IacMap());

		String Readers_Type = "ImplicitMeta";
		String Readers_Rule = "ANY Readers";
		String Writers_Type = "ImplicitMeta";
		String Writers_Rule = "ANY Writers";
		String Admins_Type = "ImplicitMeta";
		String Admins_Rule = "MAJORITY Admins";
		String BlockValidation_Type = "ImplicitMeta";
		String BlockValidation_Rule = "ANY Writers";
		IacMap Policies = new IacMap().add("Readers", new IacMap().add("Type", Readers_Type).add("Rule", Readers_Rule))
				.add("Writers", new IacMap().add("Type", Writers_Type).add("Rule", Writers_Rule))
				.add("Admins", new IacMap().add("Type", Admins_Type).add("Rule", Admins_Rule)).add("BlockValidation",
						new IacMap().add("Type", BlockValidation_Type).add("Rule", BlockValidation_Rule));
		Orderer.put("Policies", Policies);

		return Orderer;

	}

	public Map<String, Object> Readers(String Type, String Rule) {
		Map<String, Object> Readers = new HashMap<String, Object>();
		{
			Readers.put("Type", Type);
			Readers.put("Rule", Rule);
		}
		return Readers;
	}

	public Map<String, Object> Writers() {
		Map<String, Object> Writers = new HashMap<String, Object>();
		{
			String Type = "ImplicitMeta";
			String Rule = "ANY Writers";
			Writers.put("Type", Type);
			Writers.put("Rule", Rule);
		}

		return Writers;
	}

	public Map<String, Object> Admins() {
		Map<String, Object> Admins = new HashMap<String, Object>();
		{
			String Type = "ImplicitMeta";
			String Rule = "MAJORITY Admins";
			Admins.put("Type", Type);
			Admins.put("Rule", Rule);
		}

		return Admins;
	}

	public Map<String, Object> BlockValidation() {
		Map<String, Object> BlockValidation = new HashMap<String, Object>();
		{
			String Type = "ImplicitMeta";
			String Rule = "ANY Writers";
			BlockValidation.put(Type, Type);
			BlockValidation.put(Rule, Rule);
		}

		return BlockValidation;
	}

	public boolean logError(boolean status) throws Exception {
		boolean debug = true;
		if (debug) {
			throw new Exception("异常信息");
		}

		return status;
	}

	public boolean addObject(Object parent, Object child) {

		if (parent instanceof Map) {
			if (child instanceof Map.Entry) {
				((Map) parent).put(((Map.Entry) child).getKey(), ((Map.Entry) child).getValue());
				return true;
			}
			return false;
		} else if (parent instanceof List) {
			((List) parent).add(child);
			return true;
		}
		return false;

	}

	public boolean add(Object parent, Object child) {

		if (parent instanceof Map) {
			if (child instanceof Map.Entry) {
				((Map) parent).put(((Map.Entry) child).getKey(), ((Map.Entry) child).getValue());
				return true;
			}
			return false;
		} else if (parent instanceof List) {
			((List) parent).add(child);
			return true;
		}
		return false;

	}
	// {Policies={Readers={Type=ImplicitMeta, Rule=ANY Readers},
	// Writers={Type=ImplicitMeta, Rule=ANY Writers}, Admins={Type=ImplicitMeta,
	// Rule=MAJORITY Admins}}, Capabilities={V1_4_3=true, V1_3=false, V1_1=false}}
	public IacMap Channel() {
		IacMap Channel = new IacMap();

		String Readers_Type = "ImplicitMeta";
		String Readers_Rule = "ANY Readers";
		String Writers_Type = "ImplicitMeta";
		String Writers_Rule = "ANY Writers";
		String Admins_Type = "ImplicitMeta";
		String Admins_Rule = "MAJORITY Admins";
		IacMap Policies = new IacMap().add("Readers", new IacMap().add("Type", Readers_Type).add("Rule", Readers_Rule))
				.add("Writers", new IacMap().add("Type", Writers_Type).add("Rule", Writers_Rule))
				.add("Admins", new IacMap().add("Type", Admins_Type).add("Rule", Admins_Rule));
		Channel.add("Policies", Policies);

		boolean V1_4_3 = true;
		boolean V1_3 = false;
		boolean V1_1 = false;
		Channel.add("Capabilities", new IacMap().add("V1_4_3", V1_4_3).add("V1_3", V1_3).add("V1_1", V1_1));

		return Channel;

	}

	public IacMap Profiles() {
		IacMap Profiles = new IacMap();
		IacMap TwoOrgsOrdererGenesis = new IacMap();
		TwoOrgsOrdererGenesis.putAll(Channel());
		IacMap Orderer = Orderer();
		IacList Organizations = new IacList();
		Organizations.add(OrdererOrg());
		Orderer.add("Organizations",Organizations);
        boolean  V1_4_2 = true;
        boolean V1_1 =  false;
		Orderer.add("Capabilities",new IacMap().add("V1_4_2", V1_4_2).add("V1_1",V1_1));
		TwoOrgsOrdererGenesis.add("Orderer", Orderer);
		{
			Organizations.clear();
			Organizations.add(OrgN());
			TwoOrgsOrdererGenesis.add("Consortiums"
					,new IacMap().add("SampleConsortium", new IacMap().add("Organizations", Organizations)));
		}
		Profiles.add("TwoOrgsOrdererGenesis", TwoOrgsOrdererGenesis);
		
//////////////////////////////////////////////////////	
		IacMap TwoOrgsChannel = new IacMap();
		String Consortium = "SampleConsortium";
		TwoOrgsChannel.add("Consortium", Consortium);	
		TwoOrgsChannel.putAll(Channel());

		IacMap Application = new IacMap();
		Application.putAll(Application());
		Organizations.clear();
		Organizations.add(OrgN());
		Application.add("Organizations", Organizations);
		V1_4_2 = true;
		boolean V1_3 = false;
		boolean V1_2 = false;
		V1_1 = false;
		IacMap ApplicationCapabilities = new IacMap().add("V1_4_2", V1_4_2).add("V1_3", V1_3).add("V1_2", V1_2)
				.add("V1_1", V1_1);
		Application.add("Capabilities", ApplicationCapabilities);
		
		TwoOrgsChannel.add("Application", Application);
		
		Profiles.add("TwoOrgsChannel", TwoOrgsChannel);
		
		
		
//		boolean V1_4_2 = true;
//		boolean V1_1 = false;
//		Orderer.add("Capabilities", new IacMap().add("V1_4_2", V1_4_2).add("V1_1", V1_1));
//		Profiles.add("Orderer", Orderer);
//		Profiles.add("Consortiums",
//				new IacMap().add("SampleConsortium", new IacMap().add("Organizations", new IacList().push(OrgN()))));
//		String Consortium = "SampleConsortium";
//		IacMap TwoOrgsChannel = new IacMap().add("Consortium", Consortium);

		return Profiles;

	}
}
