<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>PaperCraft - Admin Quản Lý Sản Phẩm</title>
    <link rel="icon" href="${pageContext.request.contextPath}/images/logo.webp"/>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin-products.css">
</head>

<body>

<div class="admin-container">

    <jsp:include page="includes/admin-sidebar.jsp"/>

    <main class="admin-main-content">

        <header class="admin-content-header">
            <h1>Quản Lý Sản Phẩm</h1>
            <a href="${pageContext.request.contextPath}/admin-product-add.jsp" class="btn btn-primary">
                <i class="fa-solid fa-plus"></i> Thêm Sản Phẩm Mới
            </a>
        </header>

        <section class="content-table-card">

            <table class="content-table product-table">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Ảnh</th>
                    <th>Tên Sản Phẩm</th>
                    <th>Giá</th>
                    <th>Số lượng</th>
                    <th>Danh Mục</th>
                    <th>Hành Động</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${products}" var="p">
                    <tr>
                        <td>#P${p.id}</td>

                        <td>
                            <img class="product-table-image"
                                 src="${pageContext.request.contextPath}/${p.thumbnail}"
                                 alt="${p.productName}">
                        </td>

                        <td>${p.productName}</td>

                        <td>
                            <fmt:formatNumber value="${p.price}" type="number"/> VNĐ
                        </td>

                        <td>${p.stockQuantity}</td>

                        <td>
                            <c:choose>
                                <c:when test="${p.type == 'Printer'}">Máy In</c:when>
                                <c:otherwise>Văn Phòng Phẩm</c:otherwise>
                            </c:choose>
                        </td>

                        <td>
                            <a href="${pageContext.request.contextPath}/admin-product-edit?id=${p.id}" class="btn-action edit">Sửa</a>

                            <a href="${pageContext.request.contextPath}/admin-product?delete=${p.id}"
                               class="btn-action delete">Xóa</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>

            </table>

        </section>

    </main>
</div>

</body>

</html>