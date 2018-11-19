package com.iquestgroup.dashy.web;

import com.iquestgroup.dashy.domain.Monitor;
import com.iquestgroup.dashy.domain.ServiceConfig;
import com.iquestgroup.dashy.domain.ServiceType;
import com.iquestgroup.dashy.model.Service;
import com.iquestgroup.dashy.model.ServicesStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Returns the status of the machines in the environment
 */
@RestController
public class MonitorController {


    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(path = "/monitor", produces = "application/json")
    public ServicesStatus getEnvironmentStatus() {

        ServicesStatus response = new ServicesStatus();
        response.setId("8");

        for (ServiceConfig config : getConfiguredMonitoredServices()) {
            Service service = new Service().withName("rest-jms-bridge").withUrl(config.getUrl()).withType(config.getType().toString());
            Monitor status = getStatus(config.getUrl());
            if (status != null) {
                service.withStatus("up").withVersion(status.getVersion());
            } else {
                service.withStatus("down");
            }
            response.getServices().add(service);
        }
        return response;
    }

    private Monitor getStatus(String url) {
        ResponseEntity<Monitor> response = null;
        try {
            response = restTemplate.getForEntity(url, Monitor.class);
        } catch (Exception ex) {
            return null; // TODO improve (hackathon exception handling for now)
        }
        if (response.getStatusCode().equals(HttpStatus.OK)) {
            return response.getBody();
        } else {
            return null;
        }
    }

    // TODO replace mock with values extracted from a Service Registry e.g. Eureka
    private List<ServiceConfig> getConfiguredMonitoredServices() {
        List<ServiceConfig> services = new ArrayList<>();
        services.add(new ServiceConfig("http://10.83.16.21:8090/#/applications/749cb52a/details", ServiceType.spring_boot));
        services.add(new ServiceConfig("http://10.83.16.21:8090/#/applications/c34dea40/details", ServiceType.spring_boot));
        services.add(new ServiceConfig("http://10.83.16.21:8090/#/applications/8a997fce/details", ServiceType.spring_boot));
        services.add(new ServiceConfig("http://10.83.16.21:8083/", ServiceType.other_app));
        return services;
    }

}
