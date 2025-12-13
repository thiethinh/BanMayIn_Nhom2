<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<header class="main-header">
    <nav>
        <div class="header-container">

            <a href="${pageContext.request.contextPath}/home.jsp" class="logo">
                <img src="${pageContext.request.contextPath}/images/logo.webp" height="80" width="80" />
            </a>

            <div class="nav-wrapper">
                <div class="menu-bar">

                    <a class="menu" href="${pageContext.request.contextPath}/home.jsp" id="nav-home">Trang Chủ</a>
                    <a class="menu" href="${pageContext.request.contextPath}/printer.jsp" id="nav-printer">Máy In</a>
                    <a class="menu" href="${pageContext.request.contextPath}/stationery.jsp" id="nav-stationery">Văn Phòng Phẩm</a>
                    <a class="menu" href="${pageContext.request.contextPath}/blog.jsp" id="nav-blog">Blog</a>
                    <a class="menu" href="${pageContext.request.contextPath}/contact.jsp" id="nav-contact">Liên Hệ</a>
                </div>
            </div>

            <div class="header-right-side">
                <div class="user-action">
                    <a href="${pageContext.request.contextPath}/cart.jsp" id="nav-cart" class="fa-solid fa-cart-shopping cart-btn"></a>
                    <a class="login-btn" href="${pageContext.request.contextPath}/login.jsp" id="nav-login">Đăng Nhập</a>
                </div>

                <div class="menu-toggle">
                    <i class="fa-solid fa-bars" id="menu-open-icon"></i>
                    <i class="fa-solid fa-times" id="menu-close-icon"></i>
                </div>
            </div>
        </div>
    </nav>
</header>