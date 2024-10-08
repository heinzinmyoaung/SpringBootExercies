package com.example.oneToOneJpaNotPOJO.filter;


import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;

@Component
public class RequestIdFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        // Generate a unique RequestId
        String requestId = UUID.randomUUID().toString();

        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
        httpResponse.addHeader("x-request-id", requestId); // requestId add in Header

        // Set the requestId in MDC
        MDC.put("requestId", requestId); // define key(requestId) to can use in application.properties file
        try {
            filterChain.doFilter(servletRequest,httpResponse);
        } finally {
            // Clean up MDC
            MDC.remove("requestId"); //remove
        }
    }
}
