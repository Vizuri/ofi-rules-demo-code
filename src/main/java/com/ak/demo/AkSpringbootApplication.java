package com.ak.demo;

//import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class AkSpringbootApplication {
    
   //@Value("${server.port}")   
   // static String serverPort; // DOES not work as YML is not read yet at start up in main
    
    

	public static void main(String[] args) {
	    //System.out.println ("\n\n\t\txxxxxxxxxxxx main is starting at least");
	    LOG.debug("Application is about to start");
		SpringApplication.run(AkSpringbootApplication.class, args);
		
		
		//System.out.println("\nServer will be running at: " + serverPort);
		System.out.println ("\n\tApp has started - http://localhost:8090/\n");
		System.out.println ("\n\tActuator example: http://localhost:8090/actuator/health");
		//LOG.debug("App started, sample URLs");
		//LOG.debug("http://localhost:8090/");
		//http://localhost:8090/actuator/health
		
		//http://localhost:8090/actuator/loggers/com.ak.demo
		//http://localhost:8090/data
	}
	
    /*
     * Logger
     */
    private static final Logger LOG = LoggerFactory.getLogger(AkSpringbootApplication.class);
}
