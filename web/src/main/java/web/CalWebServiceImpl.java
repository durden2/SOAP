package web;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import java.util.List;
import java.util.Map;

/**
 * Created by Gandi on 02.05.2016.
 */
@WebService(endpointInterface = "web.CalWebService", portName = "calWebServicePort", serviceName = "calWebService")
public class CalWebServiceImpl implements CalWebService{
    @Override
    public int add(int a, int b){
        return a+b;
    }

    @Override
    public int sub(int a, int b) {
        return 5;
    }

    @Resource
    WebServiceContext wsctx;

    @Override
    public String method() {

        MessageContext mctx = wsctx.getMessageContext();

        //get detail from request headers
        Map http_headers = (Map) mctx.get(MessageContext.HTTP_REQUEST_HEADERS);
        List userList = (List) http_headers.get("Username");
        List passList = (List) http_headers.get("Password");

        String username = "";
        String password = "";

        if(userList!=null){
            //get username
            username = userList.get(0).toString();
        }

        if(passList!=null){
            //get password
            password = passList.get(0).toString();
        }

        //Should validate username and password with database
        if (username.equals("mkyong") && password.equals("password")){

            return add(4,5) + "Hello World JAX-WS - Valid User!";
        }else{
            return "Unknown User!";
        }

    }
}
