
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<aside class="account-sidebar">
    <ul>
        <li>
            <a href="${pageContext.request.contextPath}/account" class="active">
                <i class="fa-solid fa-user-edit"></i>
                Thông tin cá nhân
            </a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/order-history">
                <i class="fa-solid fa-file-invoice"></i>
                Lịch sử đơn hàng
            </a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/change-password">
                <i class="fa-solid fa-key"></i>
                Đổi mật khẩu
            </a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/logout" id="account-logout" class="logout-link">
                <i class="fa-solid fa-right-from-bracket"></i>
                Đăng xuất
            </a>
        </li>
    </ul>
</aside>

