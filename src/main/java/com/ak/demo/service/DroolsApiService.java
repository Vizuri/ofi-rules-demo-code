package com.ak.demo.service;

import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.kie.api.KieServices;
import org.kie.api.command.Command;
import org.kie.api.command.KieCommands;
import org.kie.api.runtime.ExecutionResults;
import org.kie.server.api.marshalling.MarshallingFormat;
import org.kie.server.api.model.ServiceResponse;
import org.kie.server.client.KieServicesClient;
import org.kie.server.client.KieServicesConfiguration;
import org.kie.server.client.KieServicesFactory;
import org.kie.server.client.RuleServicesClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

//import com.myteam.ak_age_classification.Person;
//import org.sis.rules.sis_demo.PersonClassificationCo

@Service
public class DroolsApiService {

    public Object callDroolsViaApi() {
        LOG.debug("callDroolsViaApi starting ...");
        
        try {
           return callDroolsViaApis();
        }
        catch (Exception e) {
            LOG.error("callDroolsViaApi caught an exception, e: ", e);
            return null;
        }
    }
    
    
    private Object callDroolsViaApis() throws MalformedURLException {
        System.out.println("Test");
        KieServicesConfiguration conf;
        KieServicesClient kieServicesClient;

        conf = KieServicesFactory.newRestConfiguration(URL, USER, PASSWORD);
        conf.setMarshallingFormat(FORMAT);
        
        Set<Class<?>> classes = new HashSet<Class<?>>();
        
        //classes.add(PersonClassificationCounter.class);
        //Set
        //conf.addJaxbClasses(classes);
        
        kieServicesClient = KieServicesFactory.newKieServicesClient(conf);
        RuleServicesClient rulesClient = kieServicesClient.getServicesClient(RuleServicesClient.class);
        
        kieServicesClient = KieServicesFactory.newKieServicesClient(conf);

        KieCommands commandsFactory = KieServices.Factory.get().getCommands();
        
        HashMap results = new HashMap();
        
        Command<?>  globals = commandsFactory.newSetGlobal("results", results, true);
        
                
//        Person p1 = new Person();
//        p1.setAge(11);
//        p1.setName("Young Joe");
//        //p1.setLastName("Minor");
//    
//        Person p2 = new Person();
//        p2.setAge(44);
//        p2.setName("Young Jane");
//        //p2.setLastName("Adult");
//        
//        Person p3 = new Person();
//        p3.setAge(84);
//        p3.setName("Mr. Adult Bob");
//        //p3.setLastName("Senior");
//        
//
//        Command<?> insertP1 = commandsFactory.newInsert(p1,"p1");   
//        Command<?> insertP2 = commandsFactory.newInsert(p1,"p2");   
//        Command<?> insertP3 = commandsFactory.newInsert(p1,"p3");   
//        Command<?> fireAllRules = commandsFactory.newFireAllRules(10000);
//
//        Command<?> batchCommand = commandsFactory.newBatchExecution(Arrays.asList( insertP1, insertP2, insertP3, fireAllRules));
//
//        
//        ServiceResponse<ExecutionResults> executeResponse = rulesClient.executeCommandsWithResults(CONTAINER_ID, batchCommand);
//
//        
//        LOG.debug("aaaaaaaaApi returned: " + executeResponse.getResult().getIdentifiers());
//        
//        return executeResponse.getResult();
        return null;
    }


    /*
     * Logger
     */
    private static final Logger LOG = LoggerFactory.getLogger(DroolsApiService.class);

    /*
     * Private Attributes
     */
    private static final String URL               = "http://localhost:8080/kie-server/services/rest/server";
    private static final String CONTAINER_ID      = "ak-age-classification_1.0.0";
    private static final String USER              = "kieAdmin";
    private static final String PASSWORD          = "P@ssw0rd";
    private static final MarshallingFormat FORMAT = MarshallingFormat.JSON;

}
