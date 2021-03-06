package com.ak.demo.service;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.ak.demo.model.Fund;
//import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AkSamplerService {
    
//    @Value("${server.port}")   
//    String serverPort;

    public String readJsonFromFiles() {
        LOG.debug("readJsonFromFiles starting");
        String data;
        //LOG.debug("xxxxxxxxxxxxxxx" + serverPort);
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            File file = new File(classLoader.getResource("SampleJson-1.json").getFile());
            data = FileUtils.readFileToString(file, "UTF-8");
        } catch (Exception ex) {
            LOG.error("caught an excetoion trying to read data from sample json, exception: ", ex);
            data = "{\"error\": \"Failed to read file\"}";
        }

        return data;
    }
    
    public String getPositionsMarketValuePercentage ( String aFundCode ) {
        LOG.debug("getPositionsMarketValuePercentage starting for fund code: [{}]", aFundCode);

        if ( "00200".equals(aFundCode)) {
            return "66.67";
        }
        else if ( "00700".equals(aFundCode)) {
            return "75.00";
        }
        else {
            return "50.00";
        }
    }

    public Fund getPositionsMarketValuePercentageJSON ( String aFundCode ) {
        LOG.debug("getPositionsMarketValuePercentage starting for fund code: [{}]", aFundCode);
        Fund aFund = new Fund();

        if ( "00200".equals(aFundCode)) {
            aFund.setCode(aFundCode);
            aFund.setMarketValuePercentage("66.25");
            aFund.setName("OFI fund 1");
        }
        else if ( "00700".equals(aFundCode)) {
            aFund.setCode(aFundCode);
            aFund.setMarketValuePercentage("78.35");
            aFund.setName("OFI fund 2");
        }
        else {
            aFund.setCode(aFundCode);
            aFund.setMarketValuePercentage("50.15");
            aFund.setName("OFI fund 3");
        }
        return aFund;
    }

    /*
     * Logger
     */
    private static final Logger LOG = LoggerFactory.getLogger(AkSamplerService.class);

}
