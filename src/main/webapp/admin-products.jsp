<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
                <tr>
                    <td>#P101</td>
                    <td>
                        <img src="images/Epson L3250.webp" class="product-table-image">
                    </td>
                    <td>Máy in Epson L3250</td>
                    <td>4.500.000 VNĐ</td>
                    <td>150</td>
                    <td>Máy In</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/admin-product-edit.jsp"
                           class="btn-action edit">Sửa</a>
                        <a href="#" class="btn-action delete">Xóa</a>
                    </td>
                </tr>

                <tr>
                    <td>#P102</td>
                    <td>
                        <img src="images/CANON LBP 6030.webp" class="product-table-image">
                    </td>
                    <td>Máy in laser trắng đen CANON LBP 6030</td>
                    <td>2.690.000 VNĐ</td>
                    <td>75</td>
                    <td>Máy In</td>
                    <td>
                        <a href="admin-product-edit.html" class="btn-action edit">Sửa</a>
                        <a href="#" class="btn-action delete">Xóa</a>
                    </td>
                </tr>

                <tr>
                    <td>#P201</td>
                    <td>
                        <img src="images/BoSoTayCaoCap.webp" class="product-table-image">
                    </td>
                    <td>Bộ Sổ Tay Cao Cấp</td>
                    <td>4.500.000 VNĐ</td>
                    <td>29</td>
                    <td>Văn Phòng Phẩm</td>
                    <td>
                        <a href="admin-product-edit.html" class="btn-action edit">Sửa</a>
                        <a href="#" class="btn-action delete">Xóa</a>
                    </td>
                </tr>

                <tr>
                    <td>#P202</td>
                    <td>
                        <img src="images/BoDoDungVanPhong.webp" class="product-table-image">
                    </td>
                    <td>Bộ Đồ Dùng Văn Phòng</td>
                    <td>4.390.000 VNĐ</td>
                    <td>119</td>
                    <td>Văn Phòng Phẩm</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/admin-product-edit.jsp" class="btn-action edit">Sửa</a>
                        <a href="#" class="btn-action delete">Xóa</a>
                    </td>
                </tr>

                </tbody>
            </table>

        </section>

    </main>
</div>

</body>

</html>