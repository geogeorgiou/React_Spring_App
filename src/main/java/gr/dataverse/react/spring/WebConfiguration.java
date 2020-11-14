package gr.dataverse.react.spring;

import gr.dataverse.react.spring.interceptor.EmployeeInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
class WebConfig extends WebMvcConfigurerAdapter {

    @Autowired
    EmployeeInterceptor employeeInterceptor;

    /**
     * Ensure client-side paths redirect to index.html because client handles routing. NOTE: Do NOT use @EnableWebMvc or it will break this.
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

        // Map "/"
        registry.addViewController("/")
                .setViewName("forward:/index.html");

        // Map "/word", "/word/word", and "/word/word/word" - except for anything starting with "/api/..." or ending with
        // a file extension like ".js" - to index.html. By doing this, the client receives and routes the url. It also
        // allows client-side URLs to be bookmarked.

        // Single directory level - no need to exclude "api"
        registry.addViewController("/{x:[\\w\\-]+}")
                .setViewName("forward:/index.html");
        // Multi-level directory path, need to exclude "api" on the first part of the path
        registry.addViewController("/{x:^(?!api$).*$}/**/{y:[\\w\\-]+}")
                .setViewName("forward:/index.html");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
    }


//    @Bean
//    public FilterRegistrationBean<ConsoleFilter> loggingFilter(){
//        FilterRegistrationBean<ConsoleFilter> registrationBean
//                = new FilterRegistrationBean<>();
//
//        registrationBean.setFilter(new ConsoleFilter());
//        registrationBean.addUrlPatterns("/api/jwt/*");
//
//        return registrationBean;
//    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(employeeInterceptor)
                .addPathPatterns("**/userAuth")
                .excludePathPatterns("/saadekef/eticket/**"); //by default applies to
//        registry.addInterceptor(new EmployeeInterceptor()).addPathPatterns("/auth");

        // Register admin interceptor with multiple path patterns
        /*registry.addInterceptor(new LogInterceptor())
                .addPathPatterns(new String[] { "/admin", "/admin*//*" });
         */
//        registry.addInterceptor((new SubLogInterceptor())).addPathPatterns("/admin/*").excludePathPatterns("admin/oldLogin");


    }
}
