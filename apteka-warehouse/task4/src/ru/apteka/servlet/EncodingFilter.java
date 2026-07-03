package ru.apteka.servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * Простой фильтр, устанавливающий кодировку UTF-8 для всех запросов и ответов.
 */
public class EncodingFilter implements Filter {

    private String encoding = "UTF-8";

    @Override
    public void init(FilterConfig filterConfig) {
        String param = filterConfig.getInitParameter("encoding");
        if (param != null) {
            encoding = param;
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        request.setCharacterEncoding(encoding);
        response.setCharacterEncoding(encoding);
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}
