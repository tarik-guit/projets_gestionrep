package com.gest.gestions.Filter1;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
@Component
    public class Addheader implements Filter {

        @Override
        public void doFilter(ServletRequest request, ServletResponse response,
                             FilterChain chain) throws IOException, ServletException {
            HttpServletResponse httpServletResponse = (HttpServletResponse) response;
            httpServletResponse.addHeader("Access-Control-Allow-Origin","*");
            httpServletResponse.addHeader("Access-Control-Allow-Methods","DELETE, POST, GET, PUT, OPTIONS");
            httpServletResponse.addHeader("Access-Control-Allow-Headers","Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With");
            chain.doFilter(request, response);
        }

        @Override
        public void init(FilterConfig filterConfig) throws ServletException {
            // ...
        }

        @Override
        public void destroy() {
            // ...
        }
    }

