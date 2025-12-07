<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>PaperCraft - Trang Chủ</title>
    <link rel="icon" href="${pageContext.request.contextPath}/images/logo.webp" />

    <link rel="preload" href="${pageContext.request.contextPath}/images/introduce-img.webp" as="image" fetchpriority="high">

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@12/swiper-bundle.min.css" />
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/printer-stationery.css">
</head>

<body>
    <jsp:include page="includes/header.jsp"/>

    <div class="container">
        <div class="content">

            <div class="top-content">
                <h1>Văn Phòng Phẩm</h1>
                <p>Mọi thứ bạn cần cho môi trường văn phòng hiệu quả</p>
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
                        <div class="option-item" data-value="Máy In Laser">Giấy in</div>
                        <div class="option-item" data-value="Máy In Phun">Bút viết các loại</div>
                        <div class="option-item" data-value="Máy Đa Năng">Sổ tay & Tập vở</div>
                        <div class="option-item" data-value="Máy In Di Động">File & Bìa hồ sơ</div>
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
                        <img src="images/giấy a4.webp" alt="img">
                    </div>
                    <p class="name-product">Giấy in A4 Double A 70gsm</p>
                    <ul>
                        <li>Giấy dày, cho phép in 2 mặt mà không bị lem</li>
                        <li>Độ trắng rất cao</li>
                        <li>Số lượng 500 tờ/ream</li>
                    </ul>
                    <p class="price">120.000 VNĐ</p>
                    <div class="action">
                        <div class="add-cart">
                            <span><i class='bx bx-cart'></i></span>
                            <p>Thêm Vào Giỏ</p>
                        </div>
                        <a style="text-decoration: none;" href="${pageContext.request.contextPath}/product-details.jsp">
                            <button class="bt-detail">Xem</button>
                        </a>
                    </div>
                </div>

                <div class="card-product">
                    <div class="product-image">
                        <img src="images/Giấy in A4 PaperOne All Purpose 70gsm.webp" alt="img">
                    </div>
                    <p class="name-product">Giấy in A4 PaperOne All Purpose 70gsm</p>
                    <ul>
                        <li>Cao cấp</li>
                        <li>Giấy trắng sáng, độ mịn cao</li>
                        <li>Số lượng 500 tờ/ream</li>
                    </ul>
                    <p class="price">110.000 VNĐ</p>
                    <div class="action">
                        <div class="add-cart">
                            <span><i class='bx bx-cart'></i></span>
                            <p>Thêm Vào Giỏ</p>
                        </div>
                        <a style="text-decoration: none;" href="${pageContext.request.contextPath}/product-details.jsp">
                            <button class="bt-detail">Xem</button>
                        </a>
                    </div>
                </div>

                <div class="card-product">
                    <div class="product-image">
                        <img src="images/Giấy in A3 IK Plus 70gsm.webp" alt="img">
                    </div>
                    <p class="name-product">Giấy in A3 IK Plus (Indonesia), Định lượng 70 gsm</p>
                    <ul>
                        <li>Tốt, phổ thông</li>
                        <li>Độ trắng và độ mịn tốt</li>
                        <li>Số lượng 500 tờ/ream</li>
                    </ul>
                    <p class="price">160.000 VNĐ</p>
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
                        <img src="images/Sổ lò xo Klong B5.webp" alt="img">
                    </div>
                    <p class="name-product">Sổ gáy lò xo Klong khổ B5</p>
                    <ul>
                        <li>Rất cao cấp, giấy dày</li>
                        <li>Viết êm, không lem, không thấm mực</li>
                        <li>1 quyển 200 trang</li>
                    </ul>
                    <p class="price">60.000 VNĐ</p>
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
                        <img src="images/Vở Campus B5 (Kẻ ngang).webp" alt="img">
                    </div>
                    <p class="name-product">Vở học sinh/sinh viên Campus (Kokuyo Việt Nam) khổ B5</p>
                    <ul>
                        <li>Phổ biến nhất trong trường học</li>
                        <li>Viết êm, trắng sáng, không bị nhòe</li>
                        <li>1 quyển 200 trang</li>
                    </ul>
                    <p class="price">30.000 VNĐ</p>
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
                        <img src="images/Sổ bìa da PU A5 (Khóa nam châm).webp" alt="img">
                    </div>
                    <p class="name-product">Sổ tay bìa da PU cao cấp khổ A5, loại có khóa cài nam châm</p>
                    <ul>
                        <li>Tốt, kiểu dáng lịch sự, chuyên nghiệp</li>
                        <li>Độ trắng và độ mịn tốt</li>
                        <li>1 quyển 300 trang</li>
                    </ul>
                    <p class="price">150.000 VNĐ</p>
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
                        <img src="images/Bút gel Pentel EnerGel BLN105 (Nét 0.5mm).webp" alt="img">
                    </div>
                    <p class="name-product">Bút gel Pentel EnerGel BLN105 (hoặc BLN75/BLN77)</p>
                    <ul>
                        <li>Mực khô cực nhanh, không bị nhòe</li>
                        <li>Màu mực rất rực rỡ và đậm</li>
                        <li>Số lượng: 12 cây/hộp.</li>
                    </ul>
                    <p class="price">280.000 VNĐ</p>
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
                        <img src="images/Bút dạ quang Stabilo BOSS Original.webp" alt="img">
                    </div>
                    <p class="name-product">Bút đánh dấu (highlight) Stabilo BOSS Original</p>
                    <ul>
                        <li>Mở nắp 4 tiếng không bị khô mực</li>
                        <li>Rất tươi, không làm mờ chữ.</li>
                        <li>Vỉ 6 màu </li>
                    </ul>
                    <p class="price">150.000 VNĐ</p>
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
                        <img src="images/Bút dạ quang Stabilo BOSS Original.webp" alt="img">
                    </div>
                    <p class="name-product">Bút đánh dấu (highlight) Stabilo BOSS Original</p>
                    <ul>
                        <li>Mở nắp 4 tiếng không bị khô mực</li>
                        <li>Rất tươi, không làm mờ chữ.</li>
                        <li>Vỉ 6 màu </li>
                    </ul>
                    <p class="price">150.000 VNĐ</p>
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

            <div class="pagination"></div>

        </div>

    </div>

    <jsp:include page="includes/footer.jsp"/>

    <script src="https://cdn.jsdelivr.net/npm/swiper@12/swiper-bundle.min.js" defer></script>
    <script type="module" src="${pageContext.request.contextPath}/js/main.js"></script>
</body>

</html>