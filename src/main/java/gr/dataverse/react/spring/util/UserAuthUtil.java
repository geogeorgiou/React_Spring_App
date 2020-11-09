package gr.dataverse.react.spring.util;


import gr.dataverse.react.spring.filter.ConsoleLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class UserAuthUtil {

    //use this to validate what's coming from request
    @Autowired
    JwtUtil jwtUtil;

    static Logger logger = LoggerFactory.getLogger(ConsoleLogger.class);

    //Basic authentication Util that returns the user credentials in String Array

    public boolean isUserAuth(HttpServletRequest httpRequest){


        try{

            final String authorization = httpRequest.getHeader("Authorization");
//            logger.debug("_**AUTHORIZATION**_"+authorization);

            //Authorization that is being applied (using jwt token)
            if (authorization != null) {
//                System.out.println("_**AUTHORIZATION**_"+authorization);
//
//                logger.debug("_*********_");
                String jwt = authorization.substring("Bearer".length()).trim();
//                logger.debug(jwt);

                //this decodes and validates JWT (also throws exceptions if invalid)
                jwtUtil.decodeJWT(jwt);
                return true;

            }

        }catch (Exception e){
            return false;
        }

        return false;
    }

}
