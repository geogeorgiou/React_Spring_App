package gr.dataverse.react.spring.interceptor;

import gr.dataverse.react.spring.util.JwtUtil;
import gr.dataverse.react.spring.util.UserAuthUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class EmployeeInterceptor implements HandlerInterceptor {

    private static Logger logger = LoggerFactory.getLogger(EmployeeInterceptor.class);

    @Autowired
    private UserAuthUtil userAuth;

    @Override
    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler) throws Exception {

//        logger.info("EmployeeInterceptor - Pre Handle");

        boolean isAuthUser = userAuth.isUserAuth(request);
        if (!isAuthUser){
//            logger.info("@@@@@@@@ 403 REQUEST AUTHORIZED @@@@@@@@@@@");

//            response.resetBuffer();
//            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
//            response.setHeader("Content-Type", "application/json");
//            response.getOutputStream().print("{\"errorMessage\":\"You can't use this!\"}");
//            response.flushBuffer(); //marks response as committed -- if we don't do this the request will go through normally!

            return false;
        }

        logger.info("@@@@@@@@ 200 REQUEST AUTHORIZED @@@@@@@@@@@");
        return true;
    }


}
