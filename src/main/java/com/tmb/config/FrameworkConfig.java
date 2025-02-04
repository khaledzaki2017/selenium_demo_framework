package com.tmb.config;

import com.tmb.config.converters.StringToBrowserType;
import com.tmb.enums.BrowserType;
import org.aeonbits.owner.Config;





@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "system:env",
        "file:${user.dir}/src/test/resources/config.properties"
})
public interface FrameworkConfig  extends Config {

    @DefaultValue("Chrome")
    @ConverterClass(StringToBrowserType.class)
    BrowserType browser();
}
