package com.papercraft.controller;

import com.papercraft.dao.CategoryDAO;
import com.papercraft.dao.ProductDAO;
import com.papercraft.model.Category;
import com.papercraft.model.Product;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "StationeryServlet", value = "/stationery")
public class StationeryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. Lấy các tham số từ request (dành cho tìm kiếm và lọc)
        String keyword = request.getParameter("search");
        String categoryIdParam = request.getParameter("category");
        String sortBy = request.getParameter("sort");

        int categoryId = 0;
        if (categoryIdParam != null && !categoryIdParam.isEmpty()) {
            try {
                categoryId = Integer.parseInt(categoryIdParam);
            } catch (NumberFormatException e) {
                categoryId = 0;
            }
        }

        ProductDAO dao = new ProductDAO();
        List<Product> stationery;

        // 2. Logic lấy dữ liệu: Nếu có tìm kiếm/lọc thì dùng searchProducts, ngược lại lấy tất cả
        if ((keyword != null && !keyword.trim().isEmpty()) || categoryId > 0 || sortBy != null) {
            // Lưu ý: Bạn cần đảm bảo đã sửa hàm searchProducts trong DAO tương tự như getAllProducts
            // Ở đây tôi giả sử bạn dùng các giá trị mặc định cho phân trang (offset=0, limit=100)
            stationery = dao.searchProducts(keyword, categoryId, sortBy, 0, 100);
        } else {
            stationery = dao.getAllProducts("Stationery");
        }

        // Kiểm tra null an toàn
        if (stationery == null) {
            stationery = new ArrayList<>();
        }

        // 3. Lấy danh sách danh mục để hiển thị trong dropdown filter
        CategoryDAO categoryDAO = new CategoryDAO();
        List<Category> categories = categoryDAO.getAllCategories("Stationery");
        if (categories == null) {
            categories = new ArrayList<>();
        }

        // 4. Gửi dữ liệu sang JSP
        request.setAttribute("stationery", stationery);
        request.setAttribute("categories", categories);

        // Gửi lại các giá trị cũ để giữ trạng thái cho các ô input trên giao diện
        request.setAttribute("selectedKeyword", keyword);
        request.setAttribute("selectedCategory", categoryId);
        request.setAttribute("selectedSort", sortBy);

        request.getRequestDispatcher("/stationery.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}