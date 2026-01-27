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
            <h1 class="account-title">Lịch sử mua hàng</h1>

            <div class="account-container">
                <jsp:include page="includes/account-sidebar.jsp"/>

                <section class="account-content">
                    <p style="text-align: center; font-size: larger;">Chưa có lịch sử mua hàng</p>
                </section>
            </div>
        </div>
    </div>

    <jsp:include page="includes/footer.jsp"/>

    <script src="https://cdn.jsdelivr.net/npm/swiper@12/swiper-bundle.min.js" defer></script>
    <script type="module" src="${pageContext.request.contextPath}/js/main.js"></script>
</body>

</html>