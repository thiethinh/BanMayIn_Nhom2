<%@ page import="com.papercraft.model.Product" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html lang="vn">

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

<body
<jsp:include page="includes/header.jsp"/>

<div class="container">
    <div class="content">

        <div class="top-content">
            <h1>Tất Cả Máy In</h1>
            <p>Tìm máy in hoàn hảo cho nhu cầu của bạn</p>
        </div>

        <form action="${pageContext.request.contextPath}/printer" method="get">
            <div class="search-container">
                <div class="search-box child">
                    <button type="submit" class="bt-search">
                        <i class='bx bx-search icon'></i>
                    </button>
                    <input type="text" name="search" id="search" placeholder="Tìm kiếm sản phẩm...">
                </div>

                <input type="hidden" name="category" id="categoryInput" value="0">
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

                <input type="hidden" name="sort" id="sortInput" value="rating">
                <div class="custom-dropdown child">
                    <div class="select-trigger">
                        <span class="selected-value">Đánh giá cao nhất</span>
                        <span class="arrow">▼</span>
                    </div>

                    <div class="option-value" name="sortBy">
                        <div class="option-item title-dropdown" data-value="rating"> Đánh giá cao nhất</div>
                        <div class="option-item" data-value="priceDesc"> Giá: Cao đến Thấp</div>
                        <div class="option-item" data-value="priceAsc"> Giá: Thấp đến Cao</div>
                    </div>
                </div>
            </div>
        </form>

        <div class="product-container">

            <c:forEach items="${printers}" var="p">
                <div class="card-product">
                    <div class="product-image">
                        <img src="${pageContext.request.contextPath}/${p.thumbnail}" alt="${p.productName}"
                             loading="lazy">
                    </div>
                    <p class="name-product">${p.productName}</p>
                    <ul>
                        <c:forEach items="${fn:split(p.descriptionThumbnail,'#')}" var="description">
                            <li>${description}</li>
                        </c:forEach>
                    </ul>
                    <p class="price">${p.price} VNĐ</p>
                    <div class="action">
                        <div class="add-cart">
                            <span><i class='bx bx-cart'></i></span>
                            <p>Thêm Vào Giỏ</p>
                        </div>
                        <a style="text-decoration: none;"
                           href="${pageContext.request.contextPath}/product-detail?id=${p.id}">
                            <button class="bt-detail">Xem</button>
                        </a>
                    </div>
                </div>
            </c:forEach>

        </div>
    </div>

    <div class="pagination"></div>
</div>

<jsp:include page="includes/footer.jsp"/>

<script src="https://cdn.jsdelivr.net/npm/swiper@12/swiper-bundle.min.js" defer></script>
<script type="module" src="${pageContext.request.contextPath}/js/main.js"></script>
</body>

</html>