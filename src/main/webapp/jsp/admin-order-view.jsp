<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>PaperCraft - Admin Chỉnh Sửa Sản Phẩm</title>
    <link rel="icon" href="images/logo.webp" />

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">

    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/admin.css">
    <link rel="stylesheet" href="css/admin-product-edit.css">
    <link rel="stylesheet" href="css/admin-order-manage.css">
    <link rel="stylesheet" href="css/admin-order-view.css">
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
                        <a href="admin-products.html">
                            <i class="fa-solid fa-box-archive"></i> Quản Lý Sản Phẩm
                        </a>
                    </li>
                    <li>
                        <a href="admin-review.html">
                            <i class="fa-solid fa-file-lines"></i> Quản Lý Đánh Giá
                        </a>
                    </li>
                    <li>
                        <a href="admin-order-manage.html" class="active">
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
                        <a href="#">
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
        <!-- ===========main========= -->
        <main class="admin-main-content">
            <section class="order-detail">

                <!-- -------------UP--------- -->
                <section class="up">
                    <div clas="back">
                        <a id="icon-back" href="admin-order-manage.html"><i class="fa-solid fa-arrow-left"></i></a> 
                    <h1> Chi Tiết Đơn Hàng</h1>
                    </div>
                    <div>
                        <h2>Mã đơn: <span>#OD1256</span></h2>
                        <a  href="#">In/Export</a>
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
                                        <td>Họ Tên KH: </td>
                                        <td> <span>Nguyễn Văn A</span> </td>
                                    </tr>
                                    <tr>
                                        <td>SĐT: </td>
                                        <td><span>(+84) 912 612 789 </span></td>
                                    </tr>
                                    <tr>
                                        <td>Email: </td>
                                        <td><span>nguyenvana@gmail.com</span></td>
                                    </tr>
                                    <tr>
                                        <td>Địa chỉ giao hàng: </td>
                                        <td> <span>197 Phường Đông Hòa, Dĩ An, TP.HCM</span> </td>
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
                                    <tr>
                                        <td><img src="images\Epson-L6270.webp" alt="main-img"></td>
                                        <td>
                                            <div class="block-name-product">
                                                <h3>Máy In Epson-L6270</h3>
                                                <span>Mã: #P101</span>
                                            </div>
                                        </td>
                                        <td>1</td>
                                        <td>4.250.000 VND</td>
                                        <td><strong>4.200.000 VND</strong></td>

                                    </tr>

                                    <tr>
                                        <td><img id="img-so-A5" src="images\Sổ bìa da PU A5 (Khóa nam châm).webp"
                                                alt="main-img"></td>
                                        <td>
                                            <div class="block-name-product">
                                                <h3>Sổ bìa da PU A5</h3>
                                                <span>Mã: #P226</span>
                                            </div>
                                        </td>
                                        <td>1</td>
                                        <td>150.000 VND</td>
                                        <td><strong>150.000 VND</strong></td>
                                    </tr>
                                    <tr>
                                        <td><img src="images\Bút dạ quang Stabilo BOSS Original.webp" alt="main-img">
                                        </td>
                                        <td>
                                            <div class="block-name-product">
                                                <h3>Bút Dạ Quang Stabilo BOSS</h3>
                                                <span>Mã: #P318</span>
                                            </div>
                                        </td>
                                        <td>1</td>
                                        <td>100.000 VND</td>
                                        <td><strong>100.000 VND</strong></td>
                                    </tr>
                                </tbody>

                            </table>
                            <div>
                                <h4>Ghi chú đơn hàng: </h4>
                                <p>Giao hàng giờ hành chính, hàng dễ vỡ vận chuyển cẩn thận.</p>
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
                                thái </button>
                            <!-- <button class="btn contact" type="button" name="btn-contact"> Liên hệ khách hàng </button> -->
                            <div id="block-accept-cancel">
                                <button class="btn-accept" type="button" name="btn-accept">Xác nhận</button>
                                <button class="btn-cancel" type="button" name="btn-cancel">Hủy đơn</button>
                            </div>
                        </div>
                        <div class="payment-type">
                            <h4>Thông tin thanh toán: </h4>
                            <p> Phương thức: <span>Thanh toán qua momo</span></p>
                            <p> Ngày đặt: <span>2025-11-10 14:32</span></p>
                        </div>
                    </div>

                </section>



            </section>

        </main>
    </div>

</body>

</html>