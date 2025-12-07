<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Tạo Bài Viết Mới | PaperCraft Blog</title>
    <link rel="icon" href="${pageContext.request.contextPath}/images/logo.webp" />

    <!-- Icons -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">
    <!-- <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css"> -->

    <!-- QuillJS Rich Text -->
    <link href="https://cdn.quilljs.com/1.3.6/quill.snow.css" rel="stylesheet">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/create-blog.css">
</head>

<body>

<!-- ===================== HEADER ===================== -->
<jsp:include page="includes/header.jsp"/>

<!-- ===================== CREATE BLOG FORM ===================== -->
<div class="blog-create-wrapper">
    <div class="blog-create-card">

        <h1 class="blog-create-title">Viết Blog Mới</h1>
        <p class="blog-create-sub">
            Chia sẻ kiến thức của bạn. Bài viết sẽ được Admin duyệt trước khi xuất bản.
        </p>

        <form class="blog-form">

            <!-- Title -->
            <div class="form-group">
                <label>Tiêu đề bài viết</label>
                <input type="text" id="blog-title" placeholder="Nhập tiêu đề...">
            </div>

            <!-- Thumbnail Upload -->
            <div class="form-group">
                <label>Ảnh Thumbnail</label>

                <div class="upload-box">
                    <label for="thumbnail-input" class="upload-label">Chọn ảnh...</label>
                    <input type="file" id="thumbnail-input" accept="image/*" hidden>
                </div>

                <img id="thumbnail-preview" class="thumb-preview" alt="Preview" />
            </div>

            <!-- Short Description -->
            <div class="form-group">
                <label>Mô tả ngắn</label>
                <textarea id="blog-desc" placeholder="Nhập mô tả ..."></textarea>
            </div>

            <!-- Tags -->
            <div class="form-group">
                <label>Tags</label>
                <select id="blog-tags">
                    <option value="">-- Chọn tag --</option>
                    <option>Máy In</option>
                    <option>Văn Phòng Phẩm</option>
                    <option>Hướng Dẫn</option>
                    <option>Bảo Trì</option>
                </select>
            </div>

            <!-- Rich Text Editor -->
            <div class="form-group">
                <label>Nội dung bài viết</label>
                <div id="blog-editor"></div>
            </div>

            <!-- Submit -->
            <button type="submit" class="submit-blog">Gửi bài viết</button>

        </form>

    </div>
</div>

<!-- ===================== FOOTER ===================== -->
<jsp:include page="includes/footer.jsp"/>

<!--Dùng QuillJS để tạo trinhg soạn thảo-->
<script src="https://cdn.quilljs.com/1.3.6/quill.js"></script>

<!-- JS -->
<script type="module" src="${pageContext.request.contextPath}/js/create-blog.js"></script>
</body>
</html>
