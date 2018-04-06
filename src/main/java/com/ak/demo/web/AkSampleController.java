package com.ak.demo.web;

// import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;

import com.ak.demo.model.Fund;
import com.ak.demo.service.AkSamplerService;
import com.ak.demo.service.DroolsViaJarService;
import com.ak.demo.service.DroolsApiService;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
@EnableAutoConfiguration
public class AkSampleController {

    
    @Autowired
    private AkSamplerService  akService;

    @Autowired
    private DroolsViaJarService  rulesEngineService;

    @Autowired
    private DroolsApiService  rulesEngineViaApiService;
    
    // http://localhost:8090
    @RequestMapping(value="/")
    @ResponseBody
    String home() {
        LOG.debug("Sample home page called.........");
        // return "AK Sample SpringBoot Service coming to a Theater Near You!";
        return "<!DOCTYPE html> <html> <body> <h1>AK SpringBoot 2.x Sample</h1> <p>AK Sample SpringBoot Service coming to a Theater Near You!</p> </body> </html>";
    }
    
    // http://localhost:8090/data
    @RequestMapping(value="/data", method=RequestMethod.GET, produces=APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    String getSampleJson() {
        LOG.debug("Will be trying to get JSON from static file");
        String aJson = akService.readJsonFromFiles();
        return aJson;
    }

    // http://localhost:8090/rules-java
    @RequestMapping(value="/rules-java", method=RequestMethod.GET, produces=APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    String callDroolsViaJava() {
        String aJson = rulesEngineService.callDroolsViaJava();
        return aJson;
    }

    // http://localhost:8090/rules-api
    // @RequestMapping(value="/rules-api", method=RequestMethod.GET, produces=APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value="/rules-api", method=RequestMethod.GET)
    @ResponseBody
    Object callDroolsViaApi() {
        Object aJson = rulesEngineViaApiService.callDroolsViaApi();
        return aJson;
    }

    // @RequestParam(value=PARAM_INVESTMENT_VEHICLE, required=false, defaultValue="0") String investmentV)
    // http://localhost:8090/positions-test?fund_code=00200
    @RequestMapping(value="/positions-test", method=RequestMethod.GET, produces=APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    String getFundPosition(
           @RequestParam(value="fund_code", required=false) String aFundCode) {
        String aJson = akService.getPositionsMarketValuePercentage(aFundCode);
        return aJson;
    }
    // @RequestParam(value=PARAM_INVESTMENT_VEHICLE, required=false, defaultValue="0") String investmentV)
    // http://localhost:8090/positions-test_json?fund_code=00200
    @RequestMapping(value="/positions-test_json", method=RequestMethod.GET, produces=APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    Fund getFundPositionJson(
           @RequestParam(value="fund_code", required=false) String aFundCode) {
        Fund aJson = akService.getPositionsMarketValuePercentageJSON(aFundCode);
        return aJson;
    }
    
    /*
     * Logger
     */
    private static final Logger LOG = LoggerFactory.getLogger(AkSampleController.class);

}
