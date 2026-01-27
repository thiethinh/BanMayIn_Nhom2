<%@ taglib prefix="for" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin-order-view.css">
</head>

<body>

<div class="admin-container">
    <jsp:include page="includes/admin-sidebar.jsp"/>

    <!-- ===========main========= -->
    <main class="admin-main-content">
        <section class="order-detail">

            <!-- -------------UP--------- -->
            <section class="up">
                <div clas="back">
                    <a id="icon-back" href="${pageContext.request.contextPath}/admin-order-manage.jsp"><i class="fa-solid fa-arrow-left"></i></a>
                    <h1> Chi Tiết Đơn Hàng</h1>
                </div>
                <div>
                    <h2>Mã đơn: <span>#OD${order.id}</span></h2>
                    <a href="#">In/Export</a>
                </div>
            </section>

            <!-- -------CENTER----- -->
            <section class="center">

                <!-- INFO -->
                <div class="info">
                    <div class="info-cus">
                        <h2>Thông Tin Khách Hàng</h2>
                        <table>
                            <tbody>
                            <tr>
                                <td>Họ Tên KH:</td>
                                <td><span>${user.fullname}</span></td>
                            </tr>
                            <tr>
                                <td>SĐT:</td>
                                <td><span></span>{user.phoneNumber}</td>
                            </tr>
                            <tr>
                                <td>Email:</td>
                                <td><span>{user.email}</span></td>
                            </tr>
                            <tr>
                                <td>Địa chỉ giao hàng:</td>
                                <td><span>{order.shippingAddress}</span></td>
                            </tr>
                            </tbody>
                        </table>

                    </div>

                    <div class="list-product">
                        <table>
                            <thead>
                            <tr>
                                <td>Ảnh SP</td>
                                <td>Tên Sản Phẩm</td>
                                <td>Số Lượng</td>
                                <td>Đơn Giá</td>
                                <td>Thành Tiền</td>
                            </tr>
                            </thead>
                            <tbody>

                            <for:forEach items="${order.orderItems}" var="item">
                                <tr>
                                    <td><img src="${item.product.thumbnail}" alt="main-img"></td>
                                    <td>
                                        <div class="block-name-product">
                                            <h3>${item.product.productName}</h3>
                                            <span>Mã: #P${item.product.id}</span>
                                        </div>
                                    </td>
                                    <td>${item.quantity}</td>
                                    <td>${item.product.price} VND</td>
                                    <td><strong>${item.total} VND</strong></td>

                                </tr>
                            </for:forEach>



                            </tbody>

                        </table>
                        <div>
                            <h4>Ghi chú đơn hàng: </h4>
                            <p>${order.note}</p>
                        </div>
                    </div>
                </div>

                <!-- BILL -->
                <div class="bill">
                    <div class="bill-details">
                        <!-- <div>
                            <label for="admin-status-order-viewDetails"> Trạng thái đơn: </label>
                            <select name="admin-status-order-viewDetails" id="admin-status-order-viewDetails">
                                <option value="all">Tất cả</option>
                                <option value="pending">Chờ Xử Lý</option>
                                <option value="shipped">Đã Gửi</option>
                                <option value="completed">Hoàn Thành</option>
                                <option value="canceled">Đã Hủy</option>
                            </select>
                        </div> -->
                        <div class="summary-bill">
                            <h4>Tóm tắt thanh toán: </h4>
                            <p> Tạm tính: <span>4.450.000 VND</span></p>
                            <p> Phí vận chuyển: <span>50.000 VND</span></p>
                            <p> Thuế(VAT): <span>445.000 VND</span></p>
                            <h3>Tổng Cộng: <span>4.945.000 VND</span></h3>

                        </div>
                        <button class="btn update-status" type="submit" name="btn-update-status"> Cập nhật trạng
                            thái
                        </button>
                        <!-- <button class="btn contact" type="button" name="btn-contact"> Liên hệ khách hàng </button> -->
                        <div id="block-accept-cancel">
                            <button class="btn-accept" type="button" name="btn-accept">Xác nhận</button>
                            <button class="btn-cancel" type="button" name="btn-cancel">Hủy đơn</button>
                        </div>
                    </div>
                    <div class="payment-type">
                        <h4>Thông tin thanh toán: </h4>
                        <p> Phương thức: <span>${payment.paymentMethod}</span></p>
                        <p> Ngày thanh toán: <span>${payment.paidAt} </span></p>
                    </div>
                </div>

            </section>


        </section>

    </main>
</div>

</body>

</html>