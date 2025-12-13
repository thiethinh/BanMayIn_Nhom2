<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta> name="viewport" content="width=device-width, initial-scale=1.0">
    <title>PaperCraft</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@12/swiper-bundle.min.css" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css">

    <link rel="icon" href="${pageContext.request.contextPath}/images/logo.webp" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/product-details.css">
</head>

<body>
    <jsp:include page="includes/header.jsp"/>
    <!-- ==============MAIN ===================== -->

    <body>
        <main class="product-details-main">

            <section class="product-details">
                <nav class="block-select-img">

                    <div class="img-select">
                        <button class="bt-img-0" type="button">
                            <img id="img-0" src="images/Epson-L6270.webp" alt="Image 0">
                        </button>
                        <button class="bt-img-1" type="button">
                            <img id="img-1" src="images/epson-L6270-select1.webp" alt="Image 1">
                        </button>
                        <button class="bt-img-2" type="button">
                            <img id="img-2" src="images/epson-L6270-select2.webp" alt="Image 2">
                        </button>
                        <button class="bt-img-3" type="button">
                            <img id="img-3" src="images/epson-L6270-select3.webp" alt="Image 3">
                        </button>
                        <button class="bt-img-4" type="button">
                            <img id="img-4" src="images/epson-L6270-select4.webp" alt="Image 3">
                        </button>
                    </div>
                </nav>

                <div class="img-main">
                    <img src="images/Epson-L6270.webp" alt="Main Image">
                </div>

                <div class="info-product">
                    <div class="block-rate-product">
                        <h3 id="type-tag">Printer</h3>
                        <div class="rate">
                            <i class="fa-solid fa-star"></i>
                            <i class="fa-solid fa-star"></i>
                            <i class="fa-solid fa-star"></i>
                            <i class="fa-solid fa-star"></i>
                            <i class="fa-regular fa-star"></i>
                            <span><a href="#review"
                                    onclick="showTab('review', document.querySelector('.tag-btn:nth-child(3)'))">(3 đánh
                                    giá)</a></span>
                        </div>
                    </div>
                    <h1 class="product-name">Máy In Phun Màu Đa Năng Epson_L6270</h1>
                    <div class="price">

                        <span class="original-price">10.000.000₫</span>
                        <span id="discount"> (-15%)</span> <br />
                        <span class="current-price">8.500.000₫ </span>
                    </div>
                    <p class="info-description">
                        - Phù hợp: Văn phòng <br />
                        - Tính năng: Đa chức năng Print, Scan, Copy <br />
                        - Tốc độ/Khổ giấy: 33 trang/phút. A4, B5, A5, A6 <br />

                    </p>
                    <div class="block-quatity-cart">
                        <div class="quantity">
                            <button id="bt-down" class="qty-btn minus">-</button>
                            <input type="text" class="qty-input" value="1" min="1" max="100" />
                            <button id="bt-up" class="qty-btn plus">+</button>

                        </div>
                        <button class="bt-add-cart">Thêm Vào Giỏ Hàng
                            <i class="fa-solid fa-basket-shopping"></i></button>
                    </div>
                    <div class="product-share">
                        <span>Chia sẻ:</span>
                        <i id="fb" class="fa-brands fa-facebook-f"></i>
                        <i id="twitter" class="fa-brands fa-twitter"></i>
                        <i id="instagram" class="fa-brands fa-instagram"></i>
                        <i id="pinterest" class="fa-brands fa-pinterest-p"></i>
                    </div>
                </div>
            </section>

            <section class="block-description">
                <div class="tag-title">
                    <button class="tag-btn active" onclick="showTab('tag-title-display-description',this)">
                        <h2>Mô Tả Sản Phẩm</h2>
                    </button>
                    <button class="tag-btn " onclick="showTab('tag-title-display-info',this)">
                        <h2>Thông Tin Chi Tiết</h2>
                    </button>
                    <button class="tag-btn" onclick="showTab('review',this)">
                        <h2>Đánh Giá</h2>
                    </button>



                </div>
                <div class="tag-title-display">
                    <!-- ========================tag decription======================== -->
                    <div id="tag-title-display-description" class="tag-display active">
                        <h1>Mô tả sản phẩm</h1>
                        <p>
                            <a href="#">Máy in phun</a> màu Epson L6270 một sản phẩm với khả năng in ra chất lượng
                            hình
                            ảnh sắc nét,
                            chân thực thích hợp cho các công việc in quảng cáo, thiệp mời…Sản phẩm <a href="#">máy in
                                Epson</a> với
                            thiết kế nhỏ gọn nhưng cũng không kém phần hiện đại phù hợp với nhiều môi trường làm
                            việc.
                        </p>
                        <p><strong id="first-line">- Thiết kế hiện đại, kích thước gọn nhẹ, khay chứa giấy lớn</strong>
                            <br />
                            <a href="#">Máy in</a> phun màu Epson L6270 sở hữu khả năng hoạt động mạnh mẽ nhưng lại có
                            <strong>một thiết kế
                                khá
                                nhỏ
                                gọn</strong> dễ dàng để bạn có thể bố trí, sử dụng ở nhiều không gian, nhu cầu khác
                            nhau. Thiết
                            kế
                            tinh
                            tế với <strong>gam màu đen sang trọng</strong> mang lại tính thẩm mỹ cho môi trường làm việc
                            của bạn.
                            <br />
                            Máy in phun màu Epson L6270 được thiết kế với khay với giấy lớn có khả năng chứa giấy ra
                            <strong>tối
                                đa 30 tờ, nạp giấy đến 250 tờ</strong>, nguồn cấp tài liệu tự động 30 tờ cho khả năng
                            làm việc
                            liên
                            tục
                            mà không mất thời gian bỏ thêm giấy. Hơn thế, khay giấy còn có thể tự động nạp tờ, in
                            hai
                            mặt
                            một cách nhanh chóng, dễ dàng.
                        </p>
                        <p><strong id="first-line">- Chất lượng hình ảnh sắc nét, tốc độ làm việc ấn tượng</strong>
                            <br />
                            Máy in phun màu Epson L6270 có <strong>độ phân giải lên đến 4800 x 1200 dpi</strong>, cho ra
                            hình ảnh in
                            sắc
                            nét với độ chi tiết cao. Bản in được cho ra có độ bền cao chống nước, chống nhòe, máy
                            cũng
                            có chế độ in bóng chất lượng đáp ứng mọi nhu cầu in, ấn của bạn. <br />
                            Bên cạnh chất lượng in tốt máy in nhà Epson còn có tốc độ in ấn tượng với <strong>33,0
                                trang/phút</strong>
                            khi in trắng đen và <strong>20,0 trang/phút</strong> khi in màu. Giúp bạn dễ dàng giải quyết
                            một số lượng
                            lớn
                            bản in một cách nhanh chóng. Máy in phun màu Epson L6270 còn có khả năng in hai mặt giúp
                            tiết kiệm đáng kể chi phí giấy in.
                        </p>
                        <p><strong id="first-line">- Màu mực đa dạng, khả năng kết nối toàn diện</strong> <br />
                            Máy in phun màu Epson L6270 sử dụng <strong>mực in kèm máy C13T03Y100 (140ml)</strong>. Các
                            mực thay thế
                            màu
                            của máy, bao gồm <strong>mực đen C13T03Y100</strong> với khả năng <strong>in lên đến 7.500
                                trang, mực xanh lam
                                (C13T03Y200), mực đỏ tươi (C13T03Y300) và mực vàng (C13T03Y400)</strong>, đều có thể in
                            tối đa
                            <strong> 6.000
                                trang</strong> với số trang in hỗn hợp. <strong>Cổng USB 2.0</strong> được trang bị giúp
                            cho máy in dễ dàng kết
                            nối
                            với các thiết bị ngoại vi tương thích khác. <br />
                            Các chuẩn kết nối không dây <strong>Ethernet, Wi-Fi IEEE 802.11b / g / n, Wi-Fi
                                Direct</strong> giúp máy
                            in
                            phun màu Epson L6270 có khả năng tự động kết nối với các thiết bị như điện thoại thông
                            minh,
                            laptop,..một cách dễ dàng. Bên cạnh đó, không chỉ tiết kiệm được chi phí đầu tư các
                            thiết bị
                            mà vẫn đảm bảo kết nối làm việc mọi lúc mọi nơi.
                        </p>
                    </div>
                    <!-- =============tag info=========================== -->
                    <div id="tag-title-display-info" class="tag-display">
                        <h1>Thông tin chi tiết</h1>
                        <ul>
                            <li><strong>Loại máy in:</strong> Máy in phun màu đa chức năng</li>
                            <li><strong>Tính năng:</strong> In, Scan, Copy</li>
                            <li><strong>Tốc độ in:</strong> 33 trang/phút (đen trắng), 20 trang/phút (màu)</li>
                            <li><strong>Độ phân giải:</strong> 1200 x 4800 dpi</li>
                            <li><strong>Kết nối:</strong> USB 2.0, Ethernet, Wi-Fi</li>
                            <li><strong>Khổ giấy hỗ trợ:</strong> A4, B5, A5, A6</li>
                            <li><strong>Dung lượng khay giấy:</strong> 250 tờ</li>
                            <li><strong>Mực in kèm máy:</strong> Epson 001 Black(C13T03Y100); Epson 001
                                Cyan(C13T03Y200); Epson 001 Magenta (C13T03Y300); Epson 001 Yellow (C13T03Y400)</li>
                            <li><strong>Kích thước:</strong> 375 x 347 x 179 mm</li>
                            <li><strong>Trọng lượng:</strong> 6.5 kg</li>
                        </ul>
                    </div>
                    <!-- =====================tag review====================== -->
                    <div id="review" class="tag-display">
                        <h1>Đánh giá sản phẩm</h1>
                        <div class="block-User-feedback">
                            <div class="block-User">
                                <img src="images/user-02.png" alt="user-1">
                                <div class="user">
                                    <h2 class="user-name">Thái Nguyễn</h2>
                                    <span>Ngày 27 tháng 3 năm 2020 9:51 AM</span>
                                </div>
                                <div class="user-rate">
                                    <i class="fa-solid fa-star"></i>
                                    <i class="fa-solid fa-star"></i>
                                    <i class="fa-solid fa-star"></i>
                                    <i class="fa-solid fa-star"></i>
                                    <i class="fa-regular fa-star"></i>
                                </div>
                            </div>
                            <p class="user-write">
                                Sản phẩm rất tốt, in ấn nhanh chóng, màu sắc đẹp. Rất hài lòng với chất lượng máy in
                                này.
                            </p>
                        </div>
                        <div class="block-User-feedback">
                            <div class="block-User">
                                <img src="images/user-01.png" alt="user-2">
                                <div class="user">
                                    <h2 class="user-name">Duy Tân </h2>
                                    <span>Ngày 10 tháng 12 năm 2025 12:05 PM</span>
                                </div>
                                <div class="user-rate">
                                    <i class="fa-solid fa-star"></i>
                                    <i class="fa-solid fa-star"></i>
                                    <i class="fa-solid fa-star"></i>
                                    <i class="fa-solid fa-star"></i>
                                    <i class="fa-solid fa-star"></i>
                                </div>
                            </div>
                            <p class="user-write">
                                Màu in rất đẹp, tốc độ in nhanh, rất hài lòng với sản phẩm này.
                            </p>
                        </div>
                        <div class="block-User-feedback">
                            <div class="block-User">
                                <img src="images/user-03.png" alt="user-3">
                                <div class="user">
                                    <h2 class="user-name">Thiết Hinh</h2>
                                    <span>Ngày 2 tháng 9 năm 2025 6:30 PM</span>
                                </div>
                                <div class="user-rate">
                                    <i class="fa-solid fa-star"></i>
                                    <i class="fa-solid fa-star"></i>
                                    <i class="fa-solid fa-star"></i>
                                    <i class="fa-regular fa-star"></i>
                                    <i class="fa-regular fa-star"></i>
                                </div>
                            </div>
                            <p class="user-write">
                                Sử dụng máy in Epson L6270 rất tiện lợi, chất lượng in tốt, đáng đồng tiền bát gạo.
                            </p>
                        </div>
                        <div class="your-review">
                            <form action="#">
                                <h2>HÃY VIẾT ĐÁNH GIÁ CỦA BẠN</h2>
                                <div class="your-rate">
                                    <span>Đánh giá của bạn: </span>
                                    <i class="fa-regular fa-star"></i>
                                    <i class="fa-regular fa-star"></i>
                                    <i class="fa-regular fa-star"></i>
                                    <i class="fa-regular fa-star"></i>
                                    <i class="fa-regular fa-star"></i>
                                </div>
                                <textarea name="your-write" id="your-write"
                                    placeholder="Hãy nhập đánh giá của bạn..."></textarea>
                                <button type="submit" class="bt-submit-review">Gửi</button>
                            </form>

                        </div>
                    </div>

                </div>

            </section>
        </main>
    </body>
    <!-- ============END MAIN=========================== -->

    <jsp:include page="includes/footer.jsp"/>

    <script>
        function showTab(tabId, button) {
            // Ẩn tất cả nội dung
            document.querySelectorAll('.tag-display').forEach(el => el.classList.remove('active'));

            // Bỏ active khỏi tất cả nút
            document.querySelectorAll('.tag-btn').forEach(btn => btn.classList.remove('active'));

            // Hiện phần được chọn và tô đậm nút
            document.getElementById(tabId).classList.add('active');
            button.classList.add('active');
        }
    </script>

    <script src="https://cdn.jsdelivr.net/npm/swiper@12/swiper-bundle.min.js"></script>
    <script type="module" src="${pageContext.request.contextPath}/js/main.js"></script>
</body>

</html>