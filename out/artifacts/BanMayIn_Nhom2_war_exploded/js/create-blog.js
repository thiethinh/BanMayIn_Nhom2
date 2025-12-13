// Khởi tạo Quill Editor
var quill = new Quill('#blog-editor', {
    theme: 'snow',
    placeholder: 'Nhập nội dung bài viết...',
    modules: {
        toolbar: [
            [{ 'header': [1, 2, 3, false] }], //nút header
            ['bold', 'italic', 'underline'], //nút B I U
            [{ 'list': 'ordered' }, { 'list': 'bullet' }], 
            ['link', 'image'],   // Nút chèn ảnh 
            ['clean']
        ]
    }
});
