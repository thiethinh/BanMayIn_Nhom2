<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>PaperCraft - Đăng Nhập</title>
    <link rel="icon" href="${pageContext.request.contextPath}/images/logo.webp" />

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
</head>

<body>
<jsp:include page="includes/header.jsp"/>

<div class="form-wrapper">
    <img src="images/login-bg.webp" alt="" class="login-background-image" fetchpriority="high" width="1920"
         height="1080">
    <div class="form-box">
        <div class="login-container" id="login">
            <div class="top">
                <header>Quên Mật Khẩu</header>
            </div>

            <div class="two-forms">

                <div class="input-box">
                    <input type="text" class="input-field" placeholder="Số điện thoại">
                    <i class="bx bx-phone"></i>
                </div>

                <div class="input-box">
                    <input type="password" class="input-field" placeholder="Nhập mã OTP">
                    <i class="bx bx-lock"></i>
                </div>

                <div class="two-col">
                    <div class="one">
                        <label><a href="${pageContext.request.contextPath}/contact.jsp">Liên hệ giúp đỡ</a></label>
                    </div>

                    <div class="two">
                        <label><a href="#">Gửi mã OTP</a></label>
                    </div>
                </div>

                <div class="input-box">
                    <input type="submit" class="submit" value="Xác nhận">
                </div>

                <div class="bottom">
                    <span>Quay lại trang <a href="${pageContext.request.contextPath}/login.jsp" id="login-trigger">Đăng nhập</a></span>
                </div>
            </div>
        </div>

    </div>
</div>

<jsp:include page="includes/footer.jsp"/>
</body>
<script type="module" src="${pageContext.request.contextPath}/js/main.js"></script>

</html>