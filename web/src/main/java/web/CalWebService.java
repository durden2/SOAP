package web;

/**
 * Created by Gandi on 02.05.2016.
 */

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface CalWebService {
    @WebMethod
    int add(int a, int b);
    @WebMethod
    int sub(int a, int b);
    @WebMethod
    String method();
}
