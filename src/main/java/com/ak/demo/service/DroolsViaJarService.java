package com.ak.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;
//import com.myteam.ak_age_classification.Person;
//import org.sis.rules.sis_demo.PersonClassificationCo

@Service
public class DroolsViaJarService {
    
    public String callDroolsViaJava () {
        LOG.debug("callDroolsViaJava starting ...");
        
        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
       // KieSession kSession = kContainer.newKieSession("sis-demo-session");
        //KieSession kSession =
                
        //https://stackoverflow.com/questions/43346204/how-to-use-a-spring-service-in-drools-rules
            //StatelessKieSession kSession=     kContainer.newStatelessKieSession("sis-demo-session");
            StatelessKieSession kSession=   kContainer.newStatelessKieSession();
            // kSession.setGlobal(arg0, arg1);

//        Person p1 = new Person();
//        p1.setAge(11);
//        p1.setName("Joe");
//        //p1.setLastName("Minor");
//    
//        Person p2 = new Person();
//        p2.setAge(44);
//        p2.setName("Jane");
//        //p2.setLastName("Adult");
//        
//        Person p3 = new Person();
//        p3.setAge(84);
//        p3.setName("Senior Al");
//        //p3.setLastName("Senior");
//        // kSession.insert(p);
//        
//        HashMap results = new HashMap();
//        kSession.setGlobal("results", results);
//        
//        ArrayList<Person> input = new ArrayList<Person>();
//        input.add(p1);
//        input.add(p2);
//        input.add(p3);
//        
//        LOG.debug("-------------------------------");
//        LOG.debug("Groups BEFORE kSession calls");
//        LOG.debug("p1: [{}], p2: [{}],], p3: [{}]", p1.getGroup(), p2.getGroup(), p3.getGroup());
//        LOG.debug("-------------------------------");
//
//        kSession.execute(input);
//        
//        LOG.debug("*===============================*");
//        LOG.debug("Groups AFTER kSession calls");
//        LOG.debug("p1: [{}], p2: [{}],], p3: [{}]", p1.getGroup(), p2.getGroup(), p3.getGroup());
//        LOG.debug("*===============================*");
//        
//        String poorMansJson = String.join(
//                System.getProperty("line.separator"), 
//                "{",
//                "\"person_groups\":[",
//                    "{\"name\": \"" + p1.getName() + "\",",
//                    "\"group\": \"" + p1.getGroup() + "\"},",
//
//                    "{\"name\": \"" + p2.getName() + "\",",
//                    "\"group\": \"" + p2.getGroup() + "\"},",
//
//                    "{\"name\": \"" + p3.getName() + "\",",
//                    "\"group\": \"" + p3.getGroup() + "\"}",
//                "]",
//                "}"
//                );

        
//        return poorMansJson;
            return null;
    }
    
    
    /*
     * Logger
     */
    private static final Logger LOG = LoggerFactory.getLogger(DroolsViaJarService.class);


}
