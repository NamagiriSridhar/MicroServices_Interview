package client.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController 
{
	@Autowired
	private DiscoveryClient discoveryClient;
	
	@RequestMapping("/service-instances/{appName}")
	public List<ServiceInstance> serviceInstancesByApplicationName(
			@PathVariable String appName )
	
	{
		return this.discoveryClient.getInstances(appName);
	}
	//http://localhost:8010/service-instances/Eureka


	
}
