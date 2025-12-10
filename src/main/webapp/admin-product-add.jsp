<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>PaperCraft - Admin Chỉnh Sửa Sản Phẩm</title>
    <link rel="icon" href="${pageContext.request.contextPath}/images/logo.webp"/>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin-product-add.css">

</head>

<body>

<div class="admin-container">

    <jsp:include page="includes/admin-sidebar.jsp"/>

    <main class="admin-main-content">

        <header class="admin-content-header">
            <h1>Thêm Sản Phẩm</h1>
            <a href="${pageContext.request.contextPath}/admin-products.jsp" class="btn btn-secondary">
                <i class="fa-solid fa-arrow-left"></i> Quay Lại Danh Sách
            </a>
        </header>

        <div class="admin-form-container">

            <div class="admin-form-card">
                <h2 class="form-card-title">Thông Tin Sản Phẩm</h2>

                <div class="form-group">
                    <label for="product-name">Tên Sản Phẩm</label>
                    <input type="text" id="product-name" class="form-input" placeholder="Ví dụ: Máy in Epson L3250">
                </div>

                <div class="form-row">
                    <div class="form-group">
                        <label for="product-category">Danh Mục</label>
                        <select id="product-category" class="form-input">
                            <option value="">-- Chọn danh mục --</option>
                            <option value="1">Máy In</option>
                            <option value="2">Văn Phòng Phẩm</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="product-price">Giá (VNĐ)</label>
                        <input type="number" id="product-price" class="form-input" placeholder="Ví dụ: 4500000">
                    </div>
                    <div class="form-group">
                        <label for="product-amount">Số lượng</label>
                        <input type="number" id="product-amount" class="form-input" placeholder="Số lượng: 10">
                    </div>
                </div>

                <div class="form-group">
                    <label for="product-description">Mô Tả Sản Phẩm</label>
                    <textarea id="product-description" class="form-input" rows="6"
                              placeholder="Mô tả chi tiết sản phẩm..."></textarea>
                </div>

                <div class="form-group">
                    <label for="product-details">Chi Tiết Sản Phẩm Để Hiện Ở Thẻ Sản Phẩm</label>
                    <textarea id="product-details" class="form-input" rows="6"
                              placeholder="Nhập mỗi chi tiết trên một dòng..."></textarea>
                    <small>Mỗi chi tiết (bullet point) trên một dòng. Ví dụ: <br>
                        Tốc độ 50 trang/phút<br>
                        Khay giấy 500 tờ<br>
                        Bảo hành 3 năm
                    </small>
                </div>

                <div class="form-group collapsible" id="specs-collapsible-group">
                    <div class="collapsible-header">
                        <h2 class="form-card-title">Thông Số</h2>
                        <button type="button" class="toggle-spec-btn">
                            <i class="fa-solid fa-plus"></i>
                        </button>
                    </div>

                    <div class="collapsible-content">

                        <p id="specs-placeholder">Vui lòng chọn danh mục ở trên để nhập thông số kỹ thuật.</p>

                        <div id="specs-printer" class="specs-group">
                            <div class="form-row">
                                <div class="form-group">
                                    <label for="printer-type">Loại máy in</label>
                                    <select id="printer-type" class="form-input">
                                        <option value="">-- Chọn loại máy --</option>
                                        <option value="laser-bw">Máy In Laser</option>
                                        <option value="inkjet">Máy In Phun</option>
                                        <option value="multifunction">Máy In Đa Năng</option>
                                        <option value="dot-matrix">Máy In Di Động</option>
                                    </select>
                                </div>

                                <div class="form-group">
                                    <label>Thương hiệu</label>
                                    <input type="text" classgi="form-input" placeholder="Ví dụ: Epson, Canon...">
                                </div>

                                <div class="form-group">
                                    <label>Tính năng</label>
                                    <input type="text" class="form-input" placeholder="Ví dụ: In, Scan,...">
                                </div>

                                <div class="form-group">
                                    <label>Tốc độ in</label>
                                    <input type="text" class="form-input" placeholder="Ví dụ: 33 trang/phút">
                                </div>

                                <div class="form-group">
                                    <label>Độ phân giải</label>
                                    <input type="text" class="form-input" placeholder="Ví dụ: 1200 x 4800 dpi">
                                </div>

                                <div class="form-group">
                                    <label>Kết nối</label>
                                    <input type="text" class="form-input" placeholder="Ví dụ: USB 2.0,...">
                                </div>

                                <div class="form-group">
                                    <label>Khổ giấy hỗ trợ</label>
                                    <input type="text" class="form-input" placeholder="Ví dụ: A1, A2,...">
                                </div>

                                <div class="form-group">
                                    <label>Dung lượng khay giấy</label>
                                    <input type="text" class="form-input" placeholder="Ví dụ: 250 tờ">
                                </div>

                                <div class="form-group">
                                    <label>Mực in kèm máy</label>
                                    <input type="text" class="form-input"
                                           placeholder="Ví dụ: Epson 001 Black(C13T03Y100),...">
                                </div>

                                <div class="form-group">
                                    <label>Kích thước</label>
                                    <input type="text" class="form-input" placeholder="Ví dụ: 375 x 347 x 179 mm">
                                </div>

                                <div class="form-group">
                                    <label>Trọng lượng</label>
                                    <input type="text" class="form-input" placeholder="Ví dụ: 6.5 kg">
                                </div>
                            </div>
                        </div>

                        <div id="specs-stationery" class="specs-group">
                            <div class="form-row" style="grid-template-columns: 1fr 1fr;">
                                <div class="form-group">
                                    <label for="stationery-type">Loại sản phẩm (Type)</label>
                                    <select id="stationery-type" class="form-input">
                                        <option value="">-- Chọn nhóm sản phẩm --</option>
                                        <option label="Giấy & Bìa"></option>
                                        <option label="Bút & Dụng cụ viết"></option>
                                        <option label="Sổ tay & Tập vở"></option>
                                        <option label="File & Bìa Hồ sơ"></option>
                                        <option label="Dụng cụ văn phòng"></option>
                                        <option label="Thiết bị văn phòng nhỏ"></option>
                                    </select>
                                </div>

                                <div class="form-group">
                                    <label>Thương hiệu</label>
                                    <input type="text" class="form-input" placeholder="Ví dụ: Thiên Long, Double A, Casio...">
                                </div>

                                <div class="form-group">
                                    <label>Đơn vị tính</label>
                                    <input type="text" class="form-input"
                                           placeholder="Ví dụ: Cái, Hộp, Ram (500 tờ)">
                                </div>

                                <div class="form-group">
                                    <label>Chất liệu</label>
                                    <input type="text" class="form-input" placeholder="Ví dụ: Nhựa, Giấy, Kim loại">
                                </div>

                                <div class="form-group">
                                    <label>Màu sắc</label>
                                    <input type="text" class="form-input" placeholder="Ví dụ: Xanh, Đen, Trắng">
                                </div>

                                <div class="form-group">
                                    <label>Xuất xứ</label>
                                    <input type="text" class="form-input" placeholder="Ví dụ: Việt Nam, Nhật Bản">
                                </div>
                            </div>
                        </div>

                        <textarea id="product-specs-hidden" name="product_specs" style="display: none;"></textarea>

                    </div>
                </div>
            </div>

            <div class="admin-form-card-secondary">
                <div class="admin-form-card">
                    <h2 class="form-card-title">Ảnh Đại Diện</h2>
                    <div class="image-uploader">
                        <div class="image-preview" id="image-preview">
                            <img src="" class="image-preview-image">
                            <span class="image-preview-text">Chưa chọn ảnh</span>
                        </div>
                        <label for="product-image-upload" class="btn btn-secondary">Tải Ảnh Lên</label>
                        <input type="file" id="product-image-upload" accept="image/*" style="display: none;">
                    </div>
                </div>

                <div class="admin-form-card">
                    <h2 class="form-card-title">Ảnh Chi Tiết (Gallery)</h2>

                    <div class="form-group">
                        <label for="product-gallery-upload">Tải Thêm Ảnh</label>
                        <input type="file" id="product-gallery-upload" class="form-input" multiple accept="image/*">
                        <small>Giữ Ctrl (hoặc Cmd trên Mac) để chọn nhiều ảnh.</small>
                        <small>Tối đa 2 ảnh.</small>
                    </div>

                    <div class="gallery-preview" id="gallery-preview">
                        <span class="gallery-preview-text">Chưa có ảnh chi tiết</span>
                    </div>
                </div>

                <button type="submit" class="btn btn-primary btn-save">Thêm sản phẩm</button>
            </div>

        </div>
    </main>
</div>
<script src="${pageContext.request.contextPath}/js/admin-product-edit.js"></script>
</body>

</html>