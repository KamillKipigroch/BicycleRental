package com.rental.rental.soap.webservis;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfigStation extends WsConfigurerAdapter {

    @Bean(name = "station")
    public DefaultWsdl11Definition default2Wsdl11Definition( @Qualifier("stationS") XsdSchema stationSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("StationPort");
        wsdl11Definition.setLocationUri("/bike/station");
        wsdl11Definition.setTargetNamespace("https://rental-bike.pl/soap/station");
        wsdl11Definition.setSchema(stationSchema);
        return wsdl11Definition;
    }

    @Bean(name = "stationS")
    public XsdSchema stationSchema() {
        return new SimpleXsdSchema(new ClassPathResource("station.xsd"));
    }
}
