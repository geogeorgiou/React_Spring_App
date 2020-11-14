//package gr.dataverse.react.spring.filter;
//
//import gr.dataverse.react.spring.util.JwtUtil;
//import gr.dataverse.react.spring.util.UserAuthUtil;
//import org.apache.catalina.connector.RequestFacade;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.*;
//import javax.servlet.http.HttpServletRequest;
//import java.io.IOException;
//
//
////this is a plain filter of servlet request to console log requests!
//@Component
//public class ConsoleFilter implements Filter {
//
//    private static Logger logger = LoggerFactory.getLogger(ConsoleFilter.class);
//
//    //filtering operation for JWT should be implemented somewhere here...
////    @Override
////    public void doFilter(ServletRequest servletRequest,
////                         ServletResponse servletResponse,
////                         FilterChain filterChain)
////
////            throws IOException, ServletException {
////
////        logger.info("do Filter");
////        logger.info("server.name = "+servletRequest.getServerName() );
////        logger.info("server.port = " + servletRequest.getServerPort());
////        logger.info("server.protocol = " + servletRequest.getProtocol());
////
////        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
////        logger.info("HTTP METHOD "+httpServletRequest.getMethod());
////        logger.info("HTTP URI "+httpServletRequest.getRequestURI());
////        logger.info("HTTP SERVLET PATH "+httpServletRequest.getServletPath());
////
////        filterChain.doFilter(servletRequest,servletResponse);
////    }
//
//    @Autowired
//    private UserAuthUtil userAuth;
//
//    //trying to implement the JWT filtering for api requests
//    @Override
//    public void doFilter(ServletRequest servletRequest,
//                         ServletResponse servletResponse,
//                         FilterChain filterChain)
//
//            throws IOException, ServletException {
//
////        logger.info("do Filter");
////        logger.info("server.name = "+servletRequest.getServerName() );
////        logger.info("server.port = " + servletRequest.getServerPort());
////        logger.info("server.protocol = " + servletRequest.getProtocol());
//
//        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
//        logger.info("HTTP METHOD "+httpServletRequest.getMethod());
//        logger.info("HTTP URI "+httpServletRequest.getRequestURI());
//        logger.info("HTTP SERVLET PATH "+httpServletRequest.getServletPath());
//
//        boolean isAuthUser = userAuth.isUserAuth(httpServletRequest);
//        if (!isAuthUser){
//            logger.info("@@@@@@@@ 400 REQUEST UNOTHORIZOD @@@@@@@@@@@");
//        }else{
//            logger.info("@@@@@@@@ 200 REQUEST AUTHORIZED @@@@@@@@@@@");
//
//            //this will only allows for the flow of the request further to the server
//            filterChain.doFilter(servletRequest,servletResponse);
//        }
//
//
//    }
//
//}
