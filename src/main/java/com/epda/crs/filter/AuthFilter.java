package com.epda.crs.filter;

import com.epda.crs.enums.UserRole;
import com.epda.crs.model.User;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter("/pages/*")
public class AuthFilter implements Filter {
    private static final Set<String> PUBLIC_PAGES = new HashSet<>(Arrays.asList("/pages/login.xhtml"));

    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        String contextPath = httpRequest.getContextPath();
        String uri = httpRequest.getRequestURI().substring(contextPath.length());

        if (PUBLIC_PAGES.contains(uri)) {
            chain.doFilter(request, response);
            return;
        }

        HttpSession session = httpRequest.getSession(false);
        User currentUser = session == null ? null : (User) session.getAttribute("currentUser");
        if (currentUser == null) {
            httpResponse.sendRedirect(contextPath + "/pages/login.xhtml");
            return;
        }

        if (uri.contains("users") || uri.contains("audit-log")) {
            if (currentUser.getRole() != UserRole.COURSE_ADMINISTRATOR) {
                httpResponse.sendRedirect(contextPath + "/pages/dashboard.xhtml");
                return;
            }
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}
