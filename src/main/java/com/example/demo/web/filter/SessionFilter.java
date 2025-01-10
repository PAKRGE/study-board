package com.example.demo.web.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.PatternMatchUtils;

import java.io.IOException;

@Slf4j
public class SessionFilter extends HttpFilter {
    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpSession session = request.getSession(false);
        if (isNotWhiteList(request) && invalidSession(session)) {
            response.sendRedirect("/users/login");
            return;
        }
        filterChain.doFilter(request, response);
    }

    private boolean invalidSession(HttpSession session) {
        return session == null;
    }

    private boolean isNotWhiteList(HttpServletRequest request) {
        return !PatternMatchUtils.simpleMatch("/users/login", request.getRequestURI());
    }
}
