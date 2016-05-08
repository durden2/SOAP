package web;

import javax.xml.ws.Endpoint;

/**
 * Created by Gandi on 03.05.2016.
 */
public class CalWebPublisher {

    public static void main(String[] args){
        Endpoint.publish("http://localhost:8080/ws/cal", new CalWebServiceImpl());
    }
}
