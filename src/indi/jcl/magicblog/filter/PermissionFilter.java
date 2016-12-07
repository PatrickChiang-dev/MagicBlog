package indi.jcl.magicblog.filter;

import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Magic Long on 2016/9/22.
 */
public class PermissionFilter implements Filter {
    private List<String> excludeList;// 不做过滤的地址

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        excludeList = new ArrayList<String>();
        String excludeStr = filterConfig.getInitParameter("exclude");
        String[] arr = excludeStr.split(",");
        for (String str : arr) {
            excludeList.add(str.trim());
        }
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession(true);
        String loginPath = "/" + request.getContextPath() + "/login.html";
        String path = request.getServletPath();
        path = path.substring(1, path.length());
        if (excludeList.contains(path)) {
            chain.doFilter(req, res);
             return;
        }
        if (session.getAttribute("session") == null) {
            // 此处考虑ajax操作session过期的操作，如果ajax请求过程中session过期，则指定过期状态码为：911.
            String requestType = request.getHeader("X-Requested-With");
            // response.sendRedirect("login.html");
            if (!StringUtils.isEmpty(requestType) && requestType.equalsIgnoreCase("XMLHttpRequest")) {
                response.setStatus(911);
                response.setHeader("sessionstatus", "timeout");
                response.addHeader("loginPath", loginPath);
                return;
            } else {
                response.sendRedirect(loginPath);
                return;
            }
        } else {
            chain.doFilter(req, res);
        }
    }

    @Override
    public void destroy() {
    }
}
