<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>PaperCraft - Trang Chủ</title>
    <link rel="icon" href="images/logo.webp" />

    <link rel="preload" href="./images/introduce-img.webp" as="image" fetchpriority="high">

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@12/swiper-bundle.min.css" />
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/home.css">
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

    <div class="main">
        <div class="introduce-section">

            <div class="hero-slider swiper">
                <div class="swiper-wrapper">
                    <div class="swiper-slide" style="background-image: url('./images/introduce-img.webp');"></div>
                    <div class="swiper-slide" style="background-image: url('./images/benefit-img.webp');"></div>
                    <div class="swiper-slide" style="background-image: url('./images/login-bg.webp');"></div>
                </div>
                <div class="swiper-pagination"></div>
            </div>

            <div class="introduce-container">
                <h1 class="introduce-title">Giải Pháp Văn Phòng Hoàn Chỉnh Cho Doanh Nghiệp</h1>
                <p class="introduce-description">Từ máy in chuyên nghiệp đến văn phòng phẩm thiết yếu - mọi thứ bạn cần
                    cho
                    không gian làm việc hiệu quả. Chất lượng cao, đáng tin cậy và giá cả phải chăng</p>
                <div class="introduce-btn">
                    <a href="printer.html" class="btn btn-primary">Mua ngay</a>
                    <a href="about.html" class="btn btn-secondary">Tìm hiểu thêm</a>
                </div>
            </div>
        </div>

        <div class="printer-section">
            <h2 class="section-title">Máy In Nổi Bật</h2>
            <p class="section-subtitle">Giải pháp in ấn chuyên nghiệp cho mọi nhu cầu</p>
            <div class="printer-product-section swiper">

                <div class="product-card-list swiper-wrapper">

                    <div class="product-card swiper-slide">
                        <div class="product-image-placeholder">
                            <img src="images/Epson L3250.webp" height="300" width="300" loading="lazy" />
                        </div>
                        <h3 class="product-name">Máy in Epson L3250</h3>
                        <ul class="product-details">
                            <li>Tốc độ 50 trang/phút</li>
                            <li>Khay giấy 500 tờ</li>
                            <li>Hỗ trợ in 2 mặt tự động</li>
                            <li>Bảo hành 3 năm</li>
                        </ul>
                        <p class="product-price">4.500.000 VNĐ</p>
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

                    <div class="product-card swiper-slide">
                        <div class="product-image-placeholder">
                            <img src="images/Brother HL-B2180DW.webp" height="300" width="300" loading="lazy" />
                        </div>
                        <h3 class="product-name">Máy in trắng đen đơn năng Brother HL-B2180DW</h3>
                        <ul class="product-details">
                            <li>Tốc độ 50 trang/phút</li>
                            <li>Khay giấy 500 tờ</li>
                            <li>Hỗ trợ in 2 mặt tự động</li>
                            <li>Bảo hành 3 năm</li>
                        </ul>
                        <p class="product-price">4.390.000 VNĐ</p>
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

                    <div class="product-card swiper-slide">
                        <div class="product-image-placeholder">
                            <img src="images/CANON LBP 6030.webp" height="300" width="300" loading="lazy" />
                        </div>
                        <h3 class="product-name">Máy in laser trắng đen CANON LBP 6030</h3>
                        <ul class="product-details">
                            <li>Tốc độ 50 trang/phút</li>
                            <li>Khay giấy 500 tờ</li>
                            <li>Hỗ trợ in 2 mặt tự động</li>
                            <li>Bảo hành 3 năm</li>
                        </ul>
                        <p class="product-price">2.690.000 VNĐ</p>
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

                    <div class="product-card swiper-slide">
                        <div class="product-image-placeholder">
                            <img src="images/HP Laser 108a (4ZB79A).webp" height="300" width="300" loading="lazy" />
                        </div>
                        <h3 class="product-name">Máy in HP Laser 108a (4ZB79A)</h3>
                        <ul class="product-details">
                            <li>Tốc độ 50 trang/phút</li>
                            <li>Khay giấy 500 tờ</li>
                            <li>Hỗ trợ in 2 mặt tự động</li>
                            <li>Bảo hành 3 năm</li>
                        </ul>
                        <p class="product-price">2.590.000 VNĐ</p>
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

                    <div class="product-card swiper-slide">
                        <div class="product-image-placeholder">
                            <img src="images/HP Laser 108a (4ZB79A).webp" height="300" width="300" loading="lazy" />
                        </div>
                        <h3 class="product-name">Máy in HP Laser 108a (4ZB79A)</h3>
                        <ul class="product-details">
                            <li>Tốc độ 50 trang/phút</li>
                            <li>Khay giấy 500 tờ</li>
                            <li>Hỗ trợ in 2 mặt tự động</li>
                            <li>Bảo hành 3 năm</li>
                        </ul>
                        <p class="product-price">2.590.000 VNĐ</p>
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

                <div class="swiper-pagination"></div>
                <div class="swiper-button-prev"></div>
                <div class="swiper-button-next"></div>

            </div>

            <div class="view-all-btn-container">
                <a href="printer.html" class="btn view-all-btn">Xem Tất Cả</a>
            </div>

        </div>

        <div class="stationery-section">
            <h2 class="section-title">Văn Phòng Phẩm</h2>
            <p class="section-subtitle">Mọi thứ bạn cần cho không gian làm việc hiệu quả</p>
            <div class="stationery-product-section swiper">

                <div class="product-card-list swiper-wrapper">

                    <div class="product-card swiper-slide">
                        <div class="product-image-placeholder">
                            <img src="images/BoSoTayCaoCap.webp" height="400" width="400" loading="lazy" />
                        </div>
                        <h3 class="product-name">Bộ Sổ Tay Cao Cấp</h3>
                        <ul class="product-details">
                            <li>Bộ 3 cuốn</li>
                            <li>Khổ A5, 200 trang/cuốn</li>
                            <li>Giấy chất lượng cao</li>
                        </ul>
                        <p class="product-price">126.000 VNĐ</p>
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

                    <div class="product-card swiper-slide">
                        <div class="product-image-placeholder">
                            <img src="images/BoDoDungVanPhong.webp" height="761" width="1080" loading="lazy" />
                        </div>
                        <h3 class="product-name">Bộ Đồ Dùng Văn Phòng</h3>
                        <ul class="product-details">
                            <li>Bộ văn phòng đầy đủ</li>
                            <li>Bút, bút chì, bút dạ</li>
                            <li>Giấy nhớ và kẹp</li>
                        </ul>
                        <p class="product-price">190.000 VNĐ</p>
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

                    <div class="product-card swiper-slide">
                        <div class="product-image-placeholder">
                            <img src="images/HopDungDoBangTre.webp" height="608" width="1080" loading="lazy" />
                        </div>
                        <h3 class="product-name">Hộp Đựng Đồ Bằng Tre</h3>
                        <ul class="product-details">
                            <li>Nhiều ngăn</li>
                            <li>Chất liệu làm bằng tre</li>
                            <li>Thân thiện môi trường</li>
                        </ul>
                        <p class="product-price">119.000 VNĐ</p>
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

                    <div class="product-card swiper-slide">
                        <div class="product-image-placeholder">
                            <img src="images/BoFolderHoSo(50Cai).webp" height="500" width="500" loading="lazy" />
                        </div>
                        <h3 class="product-name">Bộ Folder Hồ Sơ (50 Cái)</h3>
                        <ul class="product-details">
                            <li>50 folder/bộ</li>
                            <li>Khổ A4</li>
                            <li>Nhiều màu sắc</li>
                        </ul>
                        <p class="product-price">125.500 VNĐ</p>
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

                    <div class="product-card swiper-slide">
                        <div class="product-image-placeholder">
                            <img src="images/BoFolderHoSo(50Cai).webp" height="500" width="500" loading="lazy" />
                        </div>
                        <h3 class="product-name">Bộ Folder Hồ Sơ (50 Cái)</h3>
                        <ul class="product-details">
                            <li>50 folder/bộ</li>
                            <li>Khổ A4</li>
                            <li>Nhiều màu sắc</li>
                        </ul>
                        <p class="product-price">125.500 VNĐ</p>
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

                <div class="swiper-pagination"></div>
                <div class="swiper-button-prev"></div>
                <div class="swiper-button-next"></div>

            </div>

            <div class="view-all-btn-container">
                <a href="stationery.html" class="btn view-all-btn">Xem Tất Cả</a>
            </div>

        </div>

        <div class="benefits-section">
            <div class="benefits-container">
                <h2 class="section-title">Tại Sao Chọn PaperCraft?</h2>
                <p class="section-subtitle">Chúng tôi cung cấp giải pháp văn phòng tốt nhất với dịch vụ vượt trội</p>
                <div class="benefits-grid">
                    <div class="benefit-card">
                        <div class="benefit-icon-wrapper">
                            <i class="fas fa-bolt benefit-icon"></i>
                        </div>
                        <h3 class="benefit-title">In Nhanh</h3>
                        <p class="benefit-description">Tốc độ in cao lên đến 50 trang mỗi phút</p>
                    </div>

                    <div class="benefit-card">
                        <div class="benefit-icon-wrapper">
                            <i class="fas fa-shield-alt benefit-icon"></i>
                        </div>
                        <h3 class="benefit-title">Bảo Hành 3 Năm</h3>
                        <p class="benefit-description">Bảo hành toàn diện cho tất cả sản phẩm</p>
                    </div>

                    <div class="benefit-card">
                        <div class="benefit-icon-wrapper">
                            <i class="fas fa-headset benefit-icon"></i>
                        </div>
                        <h3 class="benefit-title">Hỗ Trợ 24/7</h3>
                        <p class="benefit-description">Hỗ trợ kỹ thuật chuyên nghiệp bất cứ khi nào bạn cần</p>
                    </div>

                    <div class="benefit-card">
                        <div class="benefit-icon-wrapper">
                            <i class="fas fa-shipping-fast benefit-icon"></i>
                        </div>
                        <h3 class="benefit-title">Miễn Phí Vận Chuyển</h3>
                        <p class="benefit-description">Giao hàng miễn phí cho đơn hàng trên 500.000 VNĐ</p>
                    </div>
                </div>
            </div>
        </div>

        <div class="contact-section">
            <div class="contact-container">

                <div class="about-split-layout">

                    <div class="about-images">
                        <img src="images/about-img-large.webp" class="about-img-large" width="800" height="400"
                            loading="lazy">
                        <img src="images/about-img-small.webp" class="about-img-small" width="800" height="600"
                            loading="lazy">
                        <img src="images/about-img-medium.webp" class="about-img-medium" width="800" height="500"
                            loading="lazy">
                    </div>

                    <div class="about-content">
                        <h2 class="section-title">Bạn Cần Một Giải Pháp Riêng?</h2>
                        <p>
                            Mỗi doanh nghiệp có một nhu cầu khác nhau. Thay vì tự tìm kiếm,
                            hãy để các chuyên gia của PaperCraft tư vấn miễn phí cho bạn.
                            Chúng tôi sẽ giúp bạn chọn đúng sản phẩm, tối ưu hiệu suất và tiết kiệm chi phí.
                        </p>

                        <ul class="about-features-list">
                            <li>Tư vấn giải pháp trọn gói</li>
                            <li>Sản phẩm chính hãng, bảo hành uy tín</li>
                            <li>Hỗ trợ kỹ thuật 24/7</li>
                            <li>Nhận báo giá & chiết khấu tốt nhất</li>
                        </ul>

                        <a href="contact.html" class="btn btn-dark-new">Nhận Tư Vấn Miễn Phí</a>
                    </div>

                </div>
            </div>
        </div>

        <div class="cta-section">
            <div class="cta-container">
                <h2 class="section-title">Sẵn Sàng Nâng Cấp Văn Phòng?</h2>
                <p class="section-subtitle">Mua sắm toàn bộ sản phẩm máy in và văn phòng phẩm ngay hôm nay</p>

                <a href="printer.html" class="cta-btn">Mua Ngay</a>
            </div>
        </div>
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