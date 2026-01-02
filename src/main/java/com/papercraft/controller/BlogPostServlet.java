package com.papercraft.controller;

import com.papercraft.dao.BlogDao;
import com.papercraft.model.Blog;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "BlogPostServlet", value = "/blog-post")
public class BlogPostServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String idParam = request.getParameter("id");
        if (idParam == null) {
            response.sendRedirect("blog");
            return;
        }
        int id = Integer.parseInt(idParam);

        BlogDao blogDao = new BlogDao();
        Blog blog = blogDao.getBlogById(id);

        if (blog != null) {
            List<Blog> relatedBlogs = blogDao.getRelatedBlogs(blog.getTypeBlog(), id);
            request.setAttribute("relatedBlogs", relatedBlogs);

            List<Blog> latestBlogs = blogDao.getLatestBlogs(id);
            request.setAttribute("latestBlogs", latestBlogs);
        }

        request.setAttribute("blog", blog);
        request.getRequestDispatcher("blog-post.jsp").forward(request, response);
    }
}
