<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="vi">

<head>
    <meta charset="UTF-8">
    <title>PaperCraft - Tài Khoản</title>
    <link rel="icon" href="${pageContext.request.contextPath}/images/logo.webp" />

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@12/swiper-bundle.min.css" />

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/account.css">
</head>

<body>
    <jsp:include page="includes/header.jsp"/>

    <div class="main">
        <div class="account-wrapper">
            <h1 class="account-title">Đổi mật khẩu</h1>

            <div class="account-container">
                <aside class="account-sidebar">
                    <ul>
                        <li>
                            <a href="${pageContext.request.contextPath}/account.jsp" >
                                <i class="fa-solid fa-user-edit"></i>
                                Thông tin cá nhân
                            </a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/order-history.jsp">
                                <i class="fa-solid fa-file-invoice"></i>
                                Lịch sử đơn hàng
                            </a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/password-change.jsp" class="active">
                                <i class="fa-solid fa-key"></i> 
                                Đổi mật khẩu
                            </a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/home.jsp" id="account-logout" class="logout-link">
                                <i class="fa-solid fa-right-from-bracket"></i>
                                Đăng xuất
                            </a>
                        </li>
                    </ul>
                </aside>

                <section class="account-content">
                    <!-- <h2>Đổi mật khẩu</h2> -->

                    <form class="account-form">

                        <div class="form-group">
                            <label for="phone">Mật Khẩu cũ</label>
                            <input type="password" id="password" placeholder="***" required>
                        </div>

                        <div class="form-group">
                            <label for="password">Mật khẩu mới</label>
                            <input type="password" id="password" placeholder="123456Az!" required>
                        </div>
                        <div class="form-group">
                            <label for="password">Xác nhận mật khẩu</label>
                            <input type="password" id="password" placeholder="123456Az!" required>
                        </div>

                        <button type="submit" class="btn btn-primary">Lưu thay đổi</button>
                    </form>

                    
                </section>
            </div>
        </div>
    </div>

    <jsp:include page="includes/footer.jsp"/>

    <script src="https://cdn.jsdelivr.net/npm/swiper@12/swiper-bundle.min.js" defer></script>
    <script type="module" src="${pageContext.request.contextPath}/js/main.js"></script>
</body>

</html>