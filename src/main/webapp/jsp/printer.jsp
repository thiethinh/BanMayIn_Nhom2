<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="vn">

<head>
    <meta charset="UTF-8">
    <title>PaperCraft - Trang Chủ</title>
    <link rel="icon" href="images/logo.webp" />

    <link rel="preload" href="./images/introduce-img.webp" as="image" fetchpriority="high">

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@12/swiper-bundle.min.css" />
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/printer-stationery.css">
</head>

<body>
    <header class="main-header">
        <nav>
            <div class="header-container">
                <a href="home.html" class="logo">
                    <img src="images/logo.webp" height="80" width="80" />
                </a>

                <div class="nav-wrapper">
                    <div class="menu-bar">
                        <a class="menu" href="home.html" id="nav-home">Trang Chủ</a>
                        <a class="menu" href="printer.html" id="nav-printer">Máy In</a>
                        <a class="menu" href="stationery.html" id="nav-stationery">Văn Phòng Phẩm</a>
                        <a class="menu" href="blog.html" id="nav-blog">Blog</a>
                        <a class="menu" href="contact.html" id="nav-contact">Liên Hệ</a>
                    </div>
                </div>

                <div class="header-right-side">
                    <div class="user-action">
                        <a href="cart.html" id="nav-cart" class="fa-solid fa-cart-shopping cart-btn"></a>
                        <a class="login-btn" href="login.html" id="nav-login">Đăng Nhập</a>
                    </div>

                    <div class="menu-toggle">
                        <i class="fa-solid fa-bars" id="menu-open-icon"></i>
                        <i class="fa-solid fa-times" id="menu-close-icon"></i>
                    </div>
                </div>
            </div>
        </nav>
    </header>


    <div class="container">
        <div class="content">

            <div class="top-content">
                <h1>Tất Cả Máy In</h1>
                <p>Tìm máy in hoàn hảo cho nhu cầu của bạn</p>
            </div>

            <div class="search-container">
                <div class="search-box child">
                    <button class="bt-search"><i class='bx bx-search icon'></i></button>
                    <input type="text" name="search" id="search" placeholder="Tìm kiếm sản phẩm...">
                </div>

                <div class="custom-dropdown child">
                    <div class="select-trigger">
                        <span class="selected-value">Tất Cả Danh Mục</span>
                        <span class="arrow">▼</span>
                    </div>

                    <div class="option-value">
                        <div class="option-item title-dropdown" data-value="Tất Cả Danh Mục">Tất Cả Danh Mục</div>
                        <div class="option-item" data-value="Máy In Laser">Máy In Laser</div>
                        <div class="option-item" data-value="Máy In Phun">Máy In Phun</div>
                        <div class="option-item" data-value="Máy Đa Năng">Máy Đa Năng</div>
                        <div class="option-item" data-value="Máy In Di Động">Máy In Di Động</div>
                    </div>
                </div>

                <div class="custom-dropdown child">
                    <div class="select-trigger">
                        <span class="selected-value">Đánh giá cao nhất</span>
                        <span class="arrow">▼</span>
                    </div>

                    <div class="option-value">
                        <div class="option-item title-dropdown" data-value="Đánh giá cao nhất"> Đánh giá cao nhất</div>
                        <div class="option-item" data-value="Giá: Cao đến Thấp"> Giá: Cao đến Thấp</div>
                        <div class="option-item" data-value="Giá: Thấp đến Cao"> Giá: Thấp đến Cao</div>
                    </div>
                </div>


            </div>
            <div class="product-container">

                <div class="card-product">
                    <div class="product-image">
                        <img src="images/Epson-L6270.webp" alt="img" loading="lazy">
                    </div>
                    <p class="name-product">Máy In Phun Màu Đa Năng Epson_L6270</p>
                    <ul>
                        <li>Tính năng: Đa chức năng Print, Scan, Copy</li>
                        <li>Tốc độ/Khổ giấy: 33 trang/phút. A4, B5, A5, A6</li>
                        <li>Bảo hành 2 năm</li>
                    </ul>
                    <p class="price">8.500.000 VNĐ</p>
                    <div class="action">
                        <div class="add-cart">
                            <span><i class='bx bx-cart'></i></span>
                            <p>Thêm Vào Giỏ</p>
                        </div>
                        <a style="text-decoration: none;" href="product-details.html">
                            <button class="bt-detail">Xem</button>
                        </a>
                    </div>
                </div>


                <div class="card-product">
                    <div class="product-image">
                        <img src="images/Copystar 300ix.webp" alt="img" loading="lazy">
                    </div>
                    <p class="name-product">Máy in đa chức năng laser đơn sắc Copystar CS 300ix</p>
                    <ul>
                        <li>Tốc độ 30 trang/phút</li>
                        <li>In 2 mặt tự động</li>
                        <li>Bảo hành 3 năm</li>
                    </ul>
                    <p class="price">12.000.000 VNĐ</p>
                    <div class="action">
                        <div class="add-cart">
                            <span><i class='bx bx-cart'></i></span>
                            <p>Thêm Vào Giỏ</p>
                        </div>
                        <a style="text-decoration: none;" href="product-details.html">
                            <button class="bt-detail">Xem</button>
                        </a>
                    </div>
                </div>

                <div class="card-product">
                    <div class="product-image">
                        <img src="images/Máy in đa chức năng HP MFP 135w Printer 4ZB83A.webp " alt="img" loading="lazy">
                    </div>
                    <p class="name-product">Máy in đa chức năng HP MFP 135w Printer 4ZB83A</p>
                    <ul>
                        <li>Lên đến 20 trang/phút</li>
                        <li>In 2 mặt thủ công</li>
                        <li>Bảo hành 2 năm</li>
                    </ul>
                    <p class="price">3.500.000 VNĐ</p>
                    <div class="action">
                        <div class="add-cart">
                            <span><i class='bx bx-cart'></i></span>
                            <p>Thêm Vào Giỏ</p>
                        </div>
                        <a style="text-decoration: none;" href="product-details.html">
                            <button class="bt-detail">Xem</button>
                        </a>
                    </div>
                </div>

                <div class="card-product">
                    <div class="product-image">
                        <img src="images/Máy in đa chức năng HP Neverstop Laser MFP 4RY26A.webp" alt="img"
                            loading="lazy">
                    </div>
                    <p class="name-product">Máy in đa chức năng HP Neverstop Laser MFP 4RY26A</p>
                    <ul>
                        <li>Lên đến 20 trang/phút</li>
                        <li>In 2 mặt thủ công</li>
                        <li>Bảo hành 2 năm</li>
                    </ul>
                    <p class="price">4.900.000 VNĐ</p>
                    <div class="action">
                        <div class="add-cart">
                            <span><i class='bx bx-cart'></i></span>
                            <p>Thêm Vào Giỏ</p>
                        </div>
                        <a style="text-decoration: none;" href="product-details.html">
                            <button class="bt-detail">Xem</button>
                        </a>
                    </div>
                </div>

                <div class="card-product">
                    <div class="product-image">
                        <img src="images/Máy in phun màu HP Ink Tank 315 Z4B04A.webp" alt="img" loading="lazy">
                    </div>
                    <p class="name-product">Máy in phun màu HP Ink Tank 315 Z4B04A</p>
                    <ul>
                        <li>Lên đến 8 trang/phút</li>
                        <li>In phun màu</li>
                        <li>Bảo hành 2 năm</li>
                    </ul>
                    <p class="price">3.500.000 VNĐ</p>
                    <div class="action">
                        <div class="add-cart">
                            <span><i class='bx bx-cart'></i></span>
                            <p>Thêm Vào Giỏ</p>
                        </div>
                        <a style="text-decoration: none;" href="product-details.html">
                            <button class="bt-detail">Xem</button>
                        </a>
                    </div>
                </div>

                <div class="card-product">
                    <div class="product-image">
                        <img src="images/Máy in laser Canon LBP 2900.webp" alt="img" loading="lazy">
                    </div>
                    <p class="name-product">Máy in laser Canon LASER SHOT LBP 2900</p>
                    <ul>
                        <li>Tốc độ 12 trang/phút</li>
                        <li>In 2 mặt thủ công</li>
                        <li>Bảo hành 2 năm</li>
                    </ul>
                    <p class="price">4.000.000 VNĐ</p>
                    <div class="action">
                        <div class="add-cart">
                            <span><i class='bx bx-cart'></i></span>
                            <p>Thêm Vào Giỏ</p>
                        </div>
                        <a style="text-decoration: none;" href="product-details.html">
                            <button class="bt-detail">Xem</button>
                        </a>
                    </div>
                </div>


                <div class="card-product">
                    <div class="product-image">
                        <img src="images/Máy in đa chức năng Canon E410.webp" alt="img" loading="lazy">
                    </div>
                    <p class="name-product">Máy in phun màu đa chức năng Canon PIXMA E410</p>
                    <ul>
                        <li>Lên đến 8 trang/phút</li>
                        <li>Bản mới nhất</li>
                        <li>Bảo hành 1 năm</li>
                    </ul>
                    <p class="price">1.600.000 VNĐ</p>
                    <div class="action">
                        <div class="add-cart">
                            <span><i class='bx bx-cart'></i></span>
                            <p>Thêm Vào Giỏ</p>
                        </div>
                        <a style="text-decoration: none;" href="product-details.html">
                            <button class="bt-detail">Xem</button>
                        </a>
                    </div>
                </div>

                <div class="card-product">
                    <div class="product-image">
                        <img src="images/Máy in laser HP 107a (4ZB77A).webp" alt="img" loading="lazy">
                    </div>
                    <p class="name-product">Máy in laser đơn sắc đen trắng HP 107a (4ZB77A)</p>
                    <ul>
                        <li>Lên đến 8 trang/phút</li>
                        <li>In 2 mặt thủ công</li>
                        <li>Bảo hành 1 năm</li>
                    </ul>
                    <p class="price">1.300.000 VNĐ</p>
                    <div class="action">
                        <div class="add-cart">
                            <span><i class='bx bx-cart'></i></span>
                            <p>Thêm Vào Giỏ</p>
                        </div>
                        <a style="text-decoration: none;" href="product-details.html">
                            <button class="bt-detail">Xem</button>
                        </a>
                    </div>
                </div>

                <div class="card-product">
                    <sapn class="hot-show">Mới</sapn>
                    <div class="product-image">
                        <img src="images/HP LaserJet M209DW Wireless Compact Mono Laser Jet Printer.webp" alt="img"
                            loading="lazy">
                    </div>
                    <p class="name-product">Máy in Laser Đơn sắc Không dây HP LaserJet M209DW</p>
                    <ul>
                        <li>Tốc độ 30 trang/phút</li>
                        <li>In 2 mặt tự động</li>
                        <li>Bảo hành 2 năm</li>
                    </ul>
                    <p class="price">3.999.999 VNĐ</p>
                    <div class="action">
                        <div class="add-cart">
                            <span><i class='bx bx-cart'></i></span>
                            <p>Thêm Vào Giỏ</p>
                        </div>
                        <a style="text-decoration: none;" href="product-details.html">
                            <button class="bt-detail">Xem</button>
                        </a>
                    </div>
                </div>

            </div>
        </div>

        <div class="pagination"> </div>
    </div>

    <footer class="main-footer">
        <div class="footer-container">
            <div class="footer-col footer-col-info">
                <div class="footer-logo">
                    <img src="images/logo.webp" height="80" width="80" />
                </div>
                <p class="footer-description">
                    Đối tác tin cậy cho máy in và văn phòng phẩm từ năm 2010.
                </p>
            </div>

            <div class="footer-col">
                <h4 class="footer-heading">Sản Phẩm</h4>
                <ul>
                    <li><a href="printer.html">Máy In</a></li>
                    <li><a href="stationery.html">Văn Phòng Phẩm</a></li>
                </ul>
            </div>

            <div class="footer-col">
                <h4 class="footer-heading">Pháp Lý</h4>
                <ul>
                    <li><a href="privacy-policy.html">Chính Sách Bảo Mật</a></li>
                    <li><a href="policies-and-services.html">Điều Khoản & Dịch Vụ</a></li>
                    <li><a href="return-policy.html">Đổi Trả</a></li>
                    <li><a href="guarantee.html">Bảo Hành</a></li>
                </ul>
            </div>

            <div class="footer-col">
                <h4 class="footer-heading">Theo Dõi Chúng Tôi</h4>
                <div class="social-icons">
                    <i class="fab fa-facebook-f"></i>
                    <i class="fab fa-twitter"></i>
                    <i class="fab fa-instagram"></i>
                </div>
            </div>
        </div>

        <div class="footer-bottom">
            <p>&copy; 2025 PaperCraft. All rights reserved.</p>
        </div>
    </footer>

    <script src="https://cdn.jsdelivr.net/npm/swiper@12/swiper-bundle.min.js" defer></script>
    <script type="module" src="js/main.js"></script>
</body>

</html>