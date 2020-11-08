//package gr.dataverse.react.spring.filter;
//
////import com.google.gson.Gson;
//import com.kastkode.springsandwich.filter.api.BeforeHandler;
//import com.kastkode.springsandwich.filter.api.Flow;
//import gr.dataverse.react.spring.json.JwtResponse;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//import org.springframework.web.method.HandlerMethod;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//@Component
//public class JWTValidatorController implements BeforeHandler {
//
//    Logger logger = LoggerFactory.getLogger(ConsoleLogger.class);
//
//    @Override
//    public Flow handle(HttpServletRequest request, HttpServletResponse response, HandlerMethod handler, String[] flags) throws Exception {
//
//        //this could be used when having an object to check (most likely)
//        //mapping request object to its java model values
////        ObjectMapper mapper = new ObjectMapper();
////        JwtResponse jwtResponse = mapper.readValue(request.getInputStream(),JwtResponse.class);
//
//
////        BufferedReader reader = request.getReader();
//        Gson gson = new Gson();
//        JwtResponse jwtResponse = gson.fromJson(String.valueOf(request.getInputStream()), JwtResponse.class);
//
//        logger.debug(jwtResponse.getJwt());
//
//
//        return Flow.CONTINUE;
//    }
//
//
//}
//
