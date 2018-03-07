package com.ak.demo.web;

// import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import com.ak.demo.service.AkSamplerService;
import com.ak.demo.service.DroolsViaJarService;
import com.ak.demo.service.DroolsApiService;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@Controller
@EnableAutoConfiguration
public class AkSampleController {

    
    @Autowired
    private AkSamplerService  akService;

    @Autowired
    private DroolsViaJarService  rulesEngineService;

    @Autowired
    private DroolsApiService  rulesEngineViaApiService;
    
    @RequestMapping(value="/")
    @ResponseBody
    String home() {
        return "AK Sample SpringBoot Service coming to a Theater Near You!";
    }
    
    // http://localhost:8090/data
    @RequestMapping(value="/data", method=RequestMethod.GET, produces=APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    String getSampleJson() {
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

}
