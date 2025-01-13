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
    private static final String[] PERMIT_URLS = new String[]{
            "/users/login*",
            "/h2-console*",
            "/favicon.ico"
    };

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpSession session = request.getSession(false);
        boolean a = isLoginCheckPass(request.getRequestURI());
        boolean b = invalidSession(session);

        if (a && b) {
            response.sendRedirect("/users/login");
            return;
        }
        filterChain.doFilter(request, response);
    }

    private boolean invalidSession(HttpSession session) {
        if ((session == null) || session.getAttribute("userData") == null) {
            return true;
        }
        return false;
    }

    private boolean isLoginCheckPass(String requestUri) {
        return !PatternMatchUtils.simpleMatch(PERMIT_URLS, requestUri);
    }
}
