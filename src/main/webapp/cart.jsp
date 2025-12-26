<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>PaperCraft</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">

    <link rel="icon" href="${pageContext.request.contextPath}/images/logo.webp"/>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/cart.css">

</head>

<body>
    <jsp:include page="includes/header.jsp"/>

    <!-- =================MAIN===================== -->

    <!-- ============CART EMPTY================ -->
    <c:if test="${empty items}">
        <main class="cart-empty-main">
            <div class="container">
                <i id="icon" class="fa fa-shopping-basket"></i>
                <h1>Giỏ Hàng Trống</h1>
                <p>Thêm một sản phẩm để bắt đầu!</p>
                <a href="${pageContext.request.contextPath}/printer.jsp">
                    <button>MUA SẮM NGAY</button>
                </a>
            </div>
        </main>
    </c:if>

    <!-- ============CART FILL================= -->
    <c:if test="${not empty items}">
        <main class="cart-fill-main">
            <div class="cart-banner">
                <marquee scrollamount="8">🎉 Đơn hàng từ 5.000.000đ được FREESHIP</marquee>
            </div>

            <div class="container">
                <h1>GIỎ HÀNG CỦA BẠN</h1>

                <section class="view">
                    <div class="product-list">

                        <c:forEach items="${items}" var="item">
                            <div class="product-detail">
                                <img src="${item.product.thumbnail}" />

                                <div id="info">
                                    <h2>${item.product.productName}</h2>

                                    <p>Số lượng:
                                        <input type="number"
                                               value="${item.quantity}"
                                               min="1"
                                               readonly>
                                    </p>

                                    <a href="remove-cart?id=${item.product.id}">
                                        <button id="bt-remove">
                                            <i class="fa fa-trash-can"></i> Xoá
                                        </button>
                                    </a>
                                </div>

                                <p id="cost">
                                    Giá:
                                    <span class="price">
                                ${item.total} đ
                            </span>
                                </p>
                            </div>
                        </c:forEach>

                    </div>

                    <!-- BILL -->
                    <div class="bill">
                        <h3>Tóm tắt đơn hàng</h3>

                        <p>Tạm tính:
                            <span>${subTotal} đ</span>
                        </p>

                        <p>VAT (5%):
                            <span>${vat} đ</span>
                        </p>

                        <h2>Tổng cộng:
                            <span>${grandTotal} đ</span>
                        </h2>

                        <a href="payment.jsp" id="bt-payment">
                            TIẾN HÀNH THANH TOÁN
                        </a>
                    </div>
                </section>
            </div>
        </main>
    </c:if>

    <script src="${pageContext.request.contextPath}/js/cart.js"></script>

    <!-- ================= END MAIN===================== -->

    <jsp:include page="includes/footer.jsp"/>

    <script src="https://cdn.jsdelivr.net/npm/swiper@12/swiper-bundle.min.js"></script>
    <script type="module" src="${pageContext.request.contextPath}/js/main.js"></script>
</body>

</html>