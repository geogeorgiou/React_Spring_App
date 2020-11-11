//package gr.dataverse.react.spring.filter;
//
//import com.kastkode.springsandwich.filter.api.BeforeHandler;
//import com.kastkode.springsandwich.filter.api.Flow;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//import org.springframework.web.method.HandlerMethod;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//@Component
//public class ConsoleLogger implements BeforeHandler {
//
//    Logger logger = LoggerFactory.getLogger(ConsoleLogger.class);
//
//    @Override
//    public Flow handle(HttpServletRequest request, HttpServletResponse response, HandlerMethod handler, String[] flags) throws Exception {
//        logger.debug(request.getMethod() + "request is executing on" + request.getRequestURI());
//
//        return Flow.CONTINUE;
//    }
//}
