package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter", urlPatterns = "/*")
public class LoginFilter implements Filter {

    private static final String[] IGNORE_URI = {"/login", "/register"};

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    /**
     * Filter request
     *
     * @param servletRequest  servlet request
     * @param servletResponse servlet response
     * @param filterChain     filter chain
     * @throws IOException      IO exception
     * @throws ServletException servlet exception
     */
    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        if (isIgnoreURI(request.getRequestURI())) {
            filterChain.doFilter(request, response);
            return;
        }

        if (request.getSession().getAttribute("userId") == null) {
            response.sendRedirect("/login");
            return;
        }

        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }

    /**
     * Determine if the requested URI is ignored
     *
     * @param requestURI request URI
     * @return true if the URI is ignored
     */
    private boolean isIgnoreURI(String requestURI) {
        if (requestURI.contains("/static/")) {
            return true;
        }
        for (String uri : IGNORE_URI) {
            if (requestURI.contains(uri)) {
                return true;
            }
        }
        return false;
    }
}
