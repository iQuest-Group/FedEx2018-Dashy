package com.iquestgroup.dashy.web.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Returns the status of the machines in the environment
 */
@RestController
public class Monitor {


    @GetMapping(path = "/monitor")
    public String getEnvironmentStatus(){
        return "{\n"
            + "    \"id\": \"15\",\n"
            + "    \"services\": [\n"
            + "        {\n"
            + "            \"name\": \"gendg\",\n"
            + "            \"version\": \"0.5.0-SNAPSHOT\",\n"
            + "            \"type\": \"spring_boot | other_app\",\n"
            + "            \"status\": \"up | down\",\n"
            + "            \"url\": \" http://glances | http://spring_boot_admin_app_details\"\n"
            + "        },\n"
            + "        {\n"
            + "            \"name\": \"rest-jms-bridge\",\n"
            + "            \"version\": \"1.5.0-SNAPSHOT\",\n"
            + "            \"type\": \"spring_boot | other_app\",\n"
            + "            \"status\": \"up | down\",\n"
            + "            \"url\": \" http://glances | http://spring_boot_admin_app_details\"\n"
            + "        }\n"
            + "    ],\n"
            + "    \"schemaVersion\": \"1.0\"\n"
            + "}";
    }

}
