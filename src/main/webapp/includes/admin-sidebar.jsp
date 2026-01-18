<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<aside class="admin-sidebar">
    <div class="sidebar-header">
        <img src="${pageContext.request.contextPath}/images/logo.webp" height="60" width="60" alt="Logo">
        <h2>PaperCraft Admin</h2>
    </div>

    <nav class="admin-nav">
        <ul>
            <li>
                <a href="${pageContext.request.contextPath}/admin" class="active">
                    <i class="fa-solid fa-gauge"></i> Bảng Điều Khiển
                </a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/admin-products.jsp">
                    <i class="fa-solid fa-box-archive"></i> Quản Lý Sản Phẩm
                </a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/admin-review.jsp">
                    <i class="fa-solid fa-file-lines"></i> Quản Lý Đánh Giá
                </a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/admin-order-manage.jsp">
                    <i class="fa-solid fa-receipt"></i> Quản Lý Đơn Hàng
                </a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/admin-customer-manage.jsp">
                    <i class="fa-solid fa-users"></i> Quản Lý Khách Hàng
                </a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/admin-blog.jsp">
                    <i class="fa-solid fa-blog"></i> Quản Lí Blog
                </a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/admin-contacts.jsp">
                    <i class="fa-solid fa-message"></i> Tin Nhắn Liên Hệ
                </a>
            </li>
        </ul>
    </nav>

    <div class="sidebar-footer">
        <a href="${pageContext.request.contextPath}/home" class="btn-logout">
            <i class="fa-solid fa-right-from-bracket"></i> Xem Website
        </a>
    </div>
</aside>