<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>PaperCraft - Admin Chỉnh Sửa Sản Phẩm</title>
    <link rel="icon" href="${pageContext.request.contextPath}/images/logo.webp"/>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin-product-edit.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin-order-manage.css">
</head>




<body>

<div class="admin-container">
    <jsp:include page="includes/admin-sidebar.jsp"/>

    <!-- ===========main========= -->
    <main class="admin-main-content">
        <div class="admin-order-manage-view">
            <h1 id="title-table">Quản Lý Đơn Hàng</h1>
        </div>
        <section class="content-table-view">
            <div class="filter">
                <label for="statusFilter"><i class="fa fa-filter"></i> Lọc theo trạng thái:</label>
                <select id="statusFilter">
                    <option value="all">Tất cả</option>
                    <option value="pending">Chờ Xử Lý</option>
                    <option value="shipped">Đã Gửi</option>
                    <option value="completed">Hoàn Thành</option>
                    <option value="canceled">Đã Hủy</option>
                </select>
            </div>


            <table class="table-view">
                <thead>
                <tr>
                    <th>Mã ĐH</th>
                    <th>Khách Hàng</th>
                    <th>Ngày Đặt</th>
                    <th>Tổng Tiền</th>
                    <th>Trạng Thái</th>
                    <th>Hành Động</th>
                </tr>
                </thead>
                <tbody>
                <c:if test="${not empty orders}">
                    <c:forEach items="${orders}" var="o">

                        <tr>
                            <td>${o.id}</td>
                            <td>${o.shippingName}</td>
                            <td>${o.createdAt}</td>
                            <td><fmt:formatNumber value="${o.totalPrice}" type="currency"/></td>
                            <td><span class="status-badge ${o.getStatusClass}">${o.status}</span></td>
                            <td><a href="${pageContext.request.contextPath}/admin-order-view?orderId=${o.id}" class="btn-action view">Xem</a></td>
                        </tr>
                    </c:forEach>
                </c:if>




                </tbody>

            </table>

            <div class="footer">
                <nav>
                    <ul class="nav-change-page">
                        <li><a href="#"><span>«</span> Trang trước</a></li>
                        <li class="active"><a href="#">1</a></li>
                        <li><a href="#">2</a></li>
                        <li><a href="#">3</a></li>
                        <li><a href="#">Trang tiếp theo <span>»</span></a></li>
                    </ul>
                </nav>

            </div>

        </section>

    </main>
</div>

</body>

</html>