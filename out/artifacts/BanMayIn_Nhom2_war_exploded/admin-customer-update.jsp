<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>PaperCraft - Admin Bảng Điều Khiển</title>
    <link rel="icon" href="${pageContext.request.contextPath}/images/logo.webp"/>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin-customer-manage.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin-customer-details.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin-customer-update.css">
</head>

<body>

<jsp:include page="includes/admin-sidebar.jsp"/>

<main class="admin-main-content">

    <header class="admin-customer-update-header">
        <a href="${pageContext.request.contextPath}/admin-customer-manage.jsp"><i class="fa-solid fa-arrow-left"></i>
            Quay lại</a>
        <h1>Sửa thông tin khách hàng</h1>

    </header>

    <section class="customer-update-view">
        <h3>Thông tin cá nhân</h3>
        <form id="editForm">
            <div>
                <label>Mã khách hàng</label>
                <input type="text" value="KH001" disabled>
            </div>

            <div>
                <label>Email</label>
                <input type="email" value="nguyenvana@gmail.com" disabled>
            </div>


            <div>
                <label>Họ</label>
                <input type="text" value="Nguyễn Văn ">
            </div>
            <div>
                <label>Tên</label>
                <input type="text" value="A">
            </div>

            <div>
                <label>Mật khẩu</label>
                <input type="password" value="*******">
            </div>


            <!-- <div>
                <label>Ngày sinh</label>
                <input type="date" value="1990-05-12">
            </div> -->

            <div>
                <label>Số điện thoại</label>
                <input type="text" value="0909123456">
            </div>

            <div class="block-full-width">
                <label>Địa chỉ</label>
                <textarea>123 Lê Lợi, Phường Đông Hòa, Dĩ An</textarea>
            </div>

            <div>
                <label>Tỉnh/Thành</label>
                <select>
                    <option selected>TP. Hồ Chí Minh</option>
                    <option>Hà Nội</option>
                    <option>TP. Đà Nẵng</option>
                    <option>TP. Hải Phòng</option>
                    <option>TP. Cần Thơ</option>
                    <option>An Giang</option>
                    <option>Bắc Ninh</option>
                    <option>Bến Tre</option>
                    <option>Cà Mau</option>
                    <option>Đắk Lắk</option>
                    <option>Điện Biên</option>
                    <option>Đồng Nai</option>
                    <option>Đồng Tháp</option>
                    <option>Gia Lai</option>
                    <option>Hà Tĩnh</option>
                    <option>Hưng Yên</option>
                    <option>Khánh Hòa</option>
                    <option>Lâm Đồng</option>
                    <option>Lạng Sơn</option>
                    <option>Nghệ An</option>
                    <option>Ninh Bình</option>
                    <option>Phú Quốc</option>
                    <option>Phú Thọ</option>
                    <option>Quảng Ninh</option>
                    <option>Quảng Ngãi</option>
                    <option>Quảng Trị</option>
                    <option>Sơn La</option>
                    <option>Tây Ninh</option>
                    <option>Thái Nguyên</option>
                    <option>Thanh Hóa</option>
                    <option>Thừa Thiên Huế</option>
                    <option>Thừa Thiên Huế</option>
                    <option>Tuyên Quang</option>
                    <option>Vĩnh Long</option>
                    <option>Yên Bái</option>
                </select>
            </div>

            <div>
                <label>Trạng thái tài khoản</label>
                <select>
                    <option selected>Đang hoạt động</option>
                    <option>Bị khóa</option>
                </select>
            </div>


            <!-- <div class="block-full-width">
                <label>Ghi chú nội bộ</label>
                <textarea>Khách hàng VIP, ưu tiên xử lý đơn hàng nhanh.</textarea>
            </div> -->

            <div class="buttons block-full-width">
                <a href="${pageContext.request.contextPath}/admin-customer-manage.jsp">
                    <button type="button" class="bt cancel">Hủy</button>
                </a>
                <button type="submit" class="bt save">💾 Lưu thay đổi</button>
            </div>
        </form>


    </section>

</main>
</div>

</body>

</html>