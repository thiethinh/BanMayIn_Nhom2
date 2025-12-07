<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>PaperCraft - Đăng Nhập</title>
    <link rel="icon" href="images/logo.webp" />

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/login.css">
</head>

<body>
    <jsp:include page="includes/header.jsp"/>

    <div class="form-wrapper">
        <img src="images/login-bg.webp" alt="" class="login-background-image" fetchpriority="high" width="1920"
            height="1080">
        <div class="form-box">
            <div class="login-container" id="login">
                <div class="top">
                    <header>Đăng Nhập</header>
                </div>

                <div class="two-forms">

                    <div class="input-box">
                        <input type="text" class="input-field" placeholder="Email">
                        <i class="bx bx-user"></i>
                    </div>

                    <div class="input-box">
                        <input type="password" class="input-field" placeholder="Mật khẩu">
                        <i class="bx bx-lock-alt"></i>
                    </div>

                    <div class="two-col">
                        <div class="one">
                            <input type="checkbox" id="login-check">
                            <label for="login-check">Ghi nhớ mật khẩu</label>
                        </div>

                        <div class="two">
                            <label><a href="forgot-password.html">Quên mật khẩu?</a></label>
                        </div>
                    </div>

                    <div class="input-box">
                        <input type="submit" class="submit" value="Đăng nhập">
                    </div>

                    <div class="bottom">
                        <span>Bạn chưa có tài khoản? <a href="#" id="register-trigger">Đăng ký</a></span>
                    </div>
                </div>
            </div>

            <div class="register-container" id="register">
                <div class="top">
                    <header>Đăng Ký</header>
                </div>

                <div class="two-forms">
                    <div class="two-row">
                        <div class="input-box">
                            <input type="text" class="input-field" placeholder="Họ">
                            <i class="bx bx-user"></i>
                        </div>

                        <div class="input-box">
                            <input type="text" class="input-field" placeholder="Tên">
                            <i class="bx bx-user"></i>
                        </div>
                    </div>

                    <div class="input-box">
                        <input type="text" class="input-field" placeholder="Email">
                        <i class="bx bx-envelope"></i>
                    </div>

                    <div class="input-box">
                        <input type="tel" class="input-field" placeholder="Số điện thoại">
                        <i class="bx bx-phone"></i>
                    </div>

                    <div class="input-box select-box"> <select class="input-field" id="gender-select" required>
                        <option value="" disabled selected>Giới tính</option>
                        <option value="male">Nam</option>
                        <option value="female">Nữ</option>
                    </select>
                        <i class="bx bx-user-check"></i>
                    </div>

                    <div class="input-box">
                        <input type="password" class="input-field" placeholder="Mật khẩu">
                        <i class="bx bx-lock-alt"></i>
                    </div>

                    <div class="input-box">
                        <input type="password" class="input-field" placeholder="Nhập lại mật khẩu">
                        <i class="bx bx-lock-alt"></i>
                    </div>

                    <div class="two-col">
                        <div class="one">
                            <input type="checkbox" id="register-check">
                            <label for="register-check">Tôi đã đọc và đồng ý với</label>
                        </div>

                        <div class="two">
                            <label><a href="policies-and-services.html">Điều khoản & Dịch vụ</a></label>
                        </div>
                    </div>

                    <div class="input-box">
                        <input type="submit" class="submit" value="Đăng ký">
                    </div>

                </div>

                <div class="bottom">
                    <span>Bạn đã có tài khoản? <a href="#" id="login-trigger">Đăng nhập</a></span>
                </div>
            </div>

        </div>
    </div>

    <jsp:include page="includes/footer.jsp"/>
</body>
<script type="module" src="js/main.js"></script>

</html>