package com.example.oneToOneJpaNotPOJO.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@Getter
@Setter
public class UniqueIdFilter {
//
//    private final String responseHeader;
//    private final String mdcKey;
//    private final String requestHeader;
//
//    public UniqueIdFilter(String responseHeader, String mdcKey, String requestHeader) {
//        this.responseHeader = ;
//        this.mdcKey = mdcKey;
//        this.requestHeader = requestHeader;
//    }
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//            throws ServletException, IOException {
//
//    }
}
