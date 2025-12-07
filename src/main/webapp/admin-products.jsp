<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>PaperCraft - Admin Quản Lý Sản Phẩm</title>
    <link rel="icon" href="images/logo.webp" />

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">

    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/admin.css">
    <link rel="stylesheet" href="css/admin-products.css">
</head>

<body>

    <div class="admin-container">

        <aside class="admin-sidebar">
            <div class="sidebar-header">
                <img src="images/logo.webp" height="60" width="60" alt="Logo">
                <h2>PaperCraft Admin</h2>
            </div>

            <nav class="admin-nav">
                <ul>
                    <li>
                        <a href="admin.html">
                            <i class="fa-solid fa-gauge"></i> Bảng Điều Khiển
                        </a>
                    </li>
                    <li>
                        <a href="admin-products.html" class="active">
                            <i class="fa-solid fa-box-archive"></i> Quản Lý Sản Phẩm
                        </a>
                    </li>
                    <li>
                        <a href="admin-review.html">
                            <i class="fa-solid fa-file-lines"></i> Quản Lý Đánh Giá
                        </a>
                    </li>
                    <li>
                        <a href="admin-order-manage.html">
                            <i class="fa-solid fa-receipt"></i> Quản Lý Đơn Hàng
                        </a>
                    </li>
                    <li>
                        <a href="admin-customer-manage.html">
                            <i class="fa-solid fa-users"></i> Quản Lý Khách Hàng
                        </a>
                    </li>
                    <li>
                        <a href="admin-blog.html">
                            <i class="fa-solid fa-blog"></i> Quản Lí Blog
                        </a>
                    </li>
                    <li>
                        <a href="admin-contacts.html">
                            <i class="fa-solid fa-message"></i> Tin Nhắn Liên Hệ
                        </a>
                    </li>
                </ul>
            </nav>

            <div class="sidebar-footer">
                <a href="home.html" class="btn-logout">
                    <i class="fa-solid fa-right-from-bracket"></i> Xem Website
                </a>
            </div>
        </aside>

        <main class="admin-main-content">

            <header class="admin-content-header">
                <h1>Quản Lý Sản Phẩm</h1>
                <a href="admin-product-add.html" class="btn btn-primary">
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
                                <a href="admin-product-edit.html" class="btn-action edit">Sửa</a>
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
                                <a href="admin-product-edit.html" class="btn-action edit">Sửa</a>
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