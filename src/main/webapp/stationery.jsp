<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>PaperCraft - Trang Chủ</title>
    <link rel="icon" href="${pageContext.request.contextPath}/images/logo.webp"/>

    <link rel="preload" href="${pageContext.request.contextPath}/images/introduce-img.webp" as="image"
          fetchpriority="high">

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@12/swiper-bundle.min.css"/>
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/printer-stationery.css">
</head>

<body data-context="${pageContext.request.contextPath}">
<jsp:include page="includes/header.jsp"/>

<div class="container">
    <div class="content">

        <div class="top-content">
            <h1>Văn Phòng Phẩm</h1>
            <p>Mọi thứ bạn cần cho môi trường văn phòng hiệu quả</p>
        </div>

        <form action="${pageContext.request.contextPath}/stationery" method="get">

            <div class="search-container">
                <div class="search-box child">
                    <button type="submit" class="bt-search"><i class='bx bx-search icon'></i></button>
                    <input type="text" name="search" id="search" placeholder="Tìm kiếm sản phẩm...">
                </div>

                <input type="hidden" name="category" id="categoryInput">
                <div class="custom-dropdown child">
                    <div class="select-trigger">
                        <span class="selected-value">Tất Cả Danh Mục</span>
                        <span class="arrow">▼</span>
                    </div>

                    <div class="option-value">

                        <div class="option-item title-dropdown" data-id="0">Tất Cả Danh Mục</div>
                        <c:forEach items="${categories}" var="category">
                            <div class="option-item" data-id="${category.id}">${category.categoryName}</div>
                        </c:forEach>
                    </div>
                </div>

                <input type="hidden" name="sort" id="sortInput">
                <div class="custom-dropdown child">
                    <div class="select-trigger">
                        <span class="selected-value">Đánh giá cao nhất</span>
                        <span class="arrow">▼</span>
                    </div>

                    <div class="option-value">
                        <div class="option-item title-dropdown" data-value="rating"> Đánh giá cao nhất</div>
                        <div class="option-item" data-value="priceAsc"> Giá: Thấp đến Cao</div>
                        <div class="option-item" data-value="priceDesc"> Giá: Cao đến Thấp</div>
                    </div>
                </div>
            </div>
        </form>

        <div class="product-container">
            <c:if test="${not empty stationery}">

                <c:forEach items="${stationery}" var="s">
                    <div class="product-card swiper-slide">

                        <a href="${pageContext.request.contextPath}/product-detail?productId=${s.id}"
                           class="product-image-placeholder">
                            <c:if test="${s.discount > 0}">
                        <span class="badge-discount">
                            -<fmt:formatNumber value="${s.discount * 100}" maxFractionDigits="0"/>%
                        </span>
                            </c:if>

                            <img src="${pageContext.request.contextPath}/${s.thumbnail}"
                                 height="300" width="300" loading="lazy" alt="${s.productName}"/>
                        </a>

                        <h3 class="product-name">
                            <a href="${pageContext.request.contextPath}/product-detail?productId=${s.id}"
                               style="text-decoration: none; color: inherit;">
                                    ${s.productName}
                            </a>
                        </h3>

                        <ul class="product-details">
                            <c:forTokens items="${s.descriptionThumbnail}" delims="#" var="feature">
                                <li>${feature.trim()}</li>
                            </c:forTokens>
                        </ul>

<%--                        <p class="product-price">--%>
<%--                            <fmt:formatNumber value="${s.price}" type="currency" currencySymbol="VNĐ" maxFractionDigits="0"/>--%>
<%--                        </p>--%>

                        <p class="product-price">
                            <c:choose>
                                <c:when test="${s.price > 0}">
                                    <fmt:formatNumber value="${s.price}" pattern="#,###"/> VNĐ
                                </c:when>
                                <c:otherwise>Liên hệ</c:otherwise>
                            </c:choose>
                        </p>
                        <div class="action">
                            <div class="add-cart" onclick="addToCart(${s.id})">
                                <span><i class='bx bx-cart'></i></span>
                                <p>Thêm Vào Giỏ</p>
                            </div>

                            <a href="${pageContext.request.contextPath}/product-detail?productId=${s.id}"
                               style="text-decoration: none;">
                                <button class="bt-detail">Xem</button>
                            </a>
                        </div>
                    </div>
                </c:forEach>
            </c:if>
        </div>

        <div class="pagination"></div>

    </div>
</div>

<jsp:include page="includes/footer.jsp"/>

<script src="https://cdn.jsdelivr.net/npm/swiper@12/swiper-bundle.min.js" defer></script>
<script type="module" src="${pageContext.request.contextPath}/js/main.js"></script>
</body>

</html>