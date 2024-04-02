package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BaseServlet extends HttpServlet {

    /**
     * handler all request
     *
     * @param request  servlet request
     * @param response servlet response
     */
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        doService(request, response);
    }

    /**
     * call method by invoke
     *
     * @param request  servlet request
     * @param response servlet response
     */
    public void doService(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String methodName = request.getParameter("method");
        if (methodName == null) {
            methodName = "index";
        }

        try {
            Method method = getClass().getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this, request, response);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new ServletException("Failed to invoke method: " + methodName, e);
        }
    }


}
