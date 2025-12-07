<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="vi">

<head>
    <meta charset="UTF-8">
    <title>PaperCraft - Tài Khoản</title>
    <link rel="icon" href="images/logo.webp" />

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@12/swiper-bundle.min.css" />

    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/account.css">
</head>

<body>
    <jsp:include page="includes/header.jsp" />

    <div class="main">
        <div class="account-wrapper">
            <h1 class="account-title">Tài Khoản Của Bạn</h1>

            <div class="account-container">
                <aside class="account-sidebar">
                    <ul>
                        <li>
                            <a href="account.html" class="active">
                                <i class="fa-solid fa-user-edit"></i>
                                Thông tin cá nhân
                            </a>
                        </li>
                        <li>
                            <a href="order-history.html">
                                <i class="fa-solid fa-file-invoice"></i>
                                Lịch sử đơn hàng
                            </a>
                        </li>
                        <li>
                            <a href="Password-change.html">
                                <i class="fa-solid fa-key"></i> 
                                Đổi mật khẩu
                            </a>
                        </li>
                        <li>
                            <a href="home.html" id="account-logout" class="logout-link">
                                <i class="fa-solid fa-right-from-bracket"></i>
                                Đăng xuất
                            </a>
                        </li>
                    </ul>
                </aside>

                <section class="account-content">
                    <h2>Thông tin cá nhân</h2>
                    <p>Quản lý thông tin cá nhân của bạn để bảo mật tài khoản.</p>

                    <form class="account-form">
                        <div class="form-row">
                            <div class="form-group">
                                <label for="first-name">Họ</label>
                                <input type="text" id="first-name" placeholder="Nguyễn">
                            </div>
                            <div class="form-group">
                                <label for="last-name">Tên</label>
                                <input type="text" id="last-name" placeholder="Văn An">
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="email">Email</label>
                            <input type="email" id="email" placeholder="email@example.com">
                        </div>

                        <div class="form-group">
                            <label for="phone">Số điện thoại</label>
                            <input type="text" id="phone" placeholder="0987035821">
                        </div>

                        <div class="form-group">
                            <label for="gender-select">Giới tính</label>
                            <select id="gender-select" required>
                                <option value="male">Nam</option>
                                <option value="female">Nữ</option>
                            </select>
                        </div>

                        <button type="submit" class="btn btn-primary">Lưu thay đổi</button>
                    </form>

                    </form>

                    <hr class="divider">
                    <h2>Sổ Địa Chỉ (Giao Hàng)</h2>
                    <p>Thông tin địa chỉ để chúng tôi giao hàng cho bạn.</p>

                    <form class="account-form address-form">
                        <div class="form-row">
                            <div class="form-group">
                                <label for="addr-firstname">Họ người nhận</label>
                                <input type="text" id="addr-firstname" placeholder="Nguyễn">
                            </div>
                            <div class="form-group">
                                <label for="addr-lastname">Tên người nhận</label>
                                <input type="text" id="addr-lastname" placeholder="Văn An">
                            </div>
                        </div>

                        <div class="form-row">
                            <div class="form-group">
                                <label for="addr-phone">Số điện thoại nhận hàng</label>
                                <input type="text" id="addr-phone" placeholder="0987...">
                            </div>
                        </div>

                        <div class="form-row">
                            <div class="form-group">
                                <label for="addr-nation">Quốc Gia</label>
                                <select name="nation" id="addr-nation" required>
                                    <option value="">--Chọn Quốc Gia--</option>
                                    <option value="VN">Việt Nam</option>
                                    <option value="US">Hoa Kỳ</option>
                                    <option value="UK">Vương quốc Anh</option>
                                    <option value="JP">Nhật Bản</option>
                                    <option value="KR">Hàn Quốc</option>
                                    <option value="CN">Trung Quốc</option>
                                    <option value="FR">Pháp</option>
                                    <option value="DE">Đức</option>
                                    <option value="RU">Nga</option>
                                    <option value="IN">Ấn Độ</option>
                                    <option value="CA">Canada</option>
                                    <option value="AU">Úc</option>
                                    <option value="BR">Brazil</option>
                                    <option value="TH">Thái Lan</option>
                                    <option value="MY">Malaysia</option>
                                    <option value="SG">Singapore</option>
                                    <option value="ID">Indonesia</option>
                                    <option value="PH">Philippines</option>
                                    <option value="IT">Ý</option>
                                    <option value="ES">Tây Ban Nha</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="addr-city">Tỉnh / Thành phố</label>
                                <select id="addr-city">
                                    <option value="">-- Chọn Tỉnh/Thành --</option>
                                    <option value="hcm">TP. Hồ Chí Minh</option>
                                    <option value="hn">Hà Nội</option>
                                    <option value="dn">Đà Nẵng</option>
                                </select>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="addr-postcode">Mã bưu chính (Postcode)</label>
                            <input type="text" id="addr-postcode" placeholder="Ví dụ: 700000">
                        </div>

                        <div class="form-group">
                            <label for="addr-detail">Địa chỉ chi tiết</label>
                            <input type="text" id="addr-detail"
                                placeholder="Số nhà, tên đường, phường/xã, quận/huyện...">
                        </div>

                        <button type="submit" class="btn btn-primary">Lưu Địa Chỉ Mới</button>
                    </form>
                </section>
            </div>
        </div>
    </div>

    <jsp:include page="includes/footer.jsp" />

    <script src="https://cdn.jsdelivr.net/npm/swiper@12/swiper-bundle.min.js" defer></script>
    <script type="module" src="js/main.js"></script>
</body>

</html>