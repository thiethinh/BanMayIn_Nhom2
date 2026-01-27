package com.papercraft.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebFilter(filterName = "jspFilter")
public class jspFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
        // Khởi tạo (Initialization code)
    }

    public void destroy() {
        // Dọn dẹp tài nguyên (Cleanup code)
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        // Logic xử lý Filter ở đây
        // Ví dụ: request.setCharacterEncoding("UTF-8");

        chain.doFilter(request, response); // Chuyển quyền điều khiển đến Filter tiếp theo hoặc Servlet
    }
}