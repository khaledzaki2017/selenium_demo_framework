package com.tmb.config.converters;

import com.tmb.enums.BrowserType;
import org.aeonbits.owner.Converter;

import java.lang.reflect.Method;
import java.util.Map;

public class StringToBrowserType  implements Converter<BrowserType> {
    @Override
    public BrowserType convert(Method method, String browserName) {

       Map<String,BrowserType>browserTypeMap= Map.of("CHROME",BrowserType.CHROME,"FIREFOX",BrowserType.FIREFOX);

        return browserTypeMap.getOrDefault(browserName.toUpperCase(),BrowserType.CHROME);
    }
}
