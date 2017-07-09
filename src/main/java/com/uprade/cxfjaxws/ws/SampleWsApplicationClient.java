package com.uprade.cxfjaxws.ws;

/**
 * Created by indrakumaruprade on 7/9/17.
 */
import java.io.StringReader;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import javax.xml.ws.Service.Mode;

import org.apache.cxf.staxutils.StaxUtils;


//CHECKSTYLE:OFF
public class SampleWsApplicationClient {

    public static void main(String[] args) throws Exception {
        String address = "http://localhost:8080/Service/Hello";
        String request = "<q0:sayHello xmlns:q0=\"http://service.ws.sample/\"><myname>Elan</myname></q0:sayHello>";

        StreamSource source = new StreamSource(new StringReader(request));
        Service service = Service.create(new URL("http://localhost:8080/Service/Hello?wsdl"),
                new QName("http://service.ws.sample/" , "HelloService"));
        Dispatch<Source> disp = service.createDispatch(new QName("http://service.ws.sample/" , "HelloPort"),
                Source.class, Mode.PAYLOAD);

        Source result = disp.invoke(source);
        String resultAsString = StaxUtils.toString(result);
        System.out.println(resultAsString);

    }
}
//CHECKSTYLE:ON
