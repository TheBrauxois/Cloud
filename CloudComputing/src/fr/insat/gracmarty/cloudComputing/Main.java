package fr.insat.gracmarty.cloudComputing;

import java.util.List;

import net.elbandi.pve2api.Pve2Api;
import net.elbandi.pve2api.data.Resource;
import net.elbandi.pve2api.data.resource.Node;
import net.elbandi.pve2api.data.resource.Pool;
import net.elbandi.pve2api.data.resource.Storage;
import net.elbandi.pve2api.data.resource.Vm;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String host = "srv-px1.insa-toulouse.fr";
		String username = "a_marty";
		String group = "Ldap-INSA";
		String pass = "p7jm8.";
		
		Pve2Api api = new Pve2Api(host, username, group, pass);
		try {
			List<Resource> list = api.getResources();	
			List<Resource> list_pool = Resource.getResourcesByType(list, Resource.convertType("pool"));
			List<Resource> list_vm = Resource.getResourcesByType(list, Resource.convertType("qemu"));
			List<Resource> list_node = Resource.getResourcesByType(list, Resource.convertType("node"));
			List<Resource> list_storage = Resource.getResourcesByType(list, Resource.convertType("storage"));
			System.out.println("Pool");
			System.out.println(list_pool.size());

			for(Resource element : list_pool) {
				System.out.println(((Pool)element).getCpu());
			}
			System.out.println("Vm");
			for(Resource element : list_vm) {
				Vm vm = (Vm)element;
				System.out.println(vm.getId());
			}
			System.out.println("Node");
			for(Resource element : list_node) {
				Node node = (Node)element;
				float cpu = node.getCpu();
				float disk = node.getDisk();
				String id = node.getNode();
				System.out.println(id);
			}
			/*System.out.println("Storage");
			for(Resource element : list_storage) {
				System.out.println(((Storage)element).getDisk());
			}*/
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
	}

}
