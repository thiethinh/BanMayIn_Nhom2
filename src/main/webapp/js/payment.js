
document.addEventListener("DOMContentLoaded", () => {
    //  Lấy tất cả các khối phương thức thanh toán
    const methods = document.querySelectorAll(".method");

    //  Xử lý sự kiện CLICK cho từng khối
    methods.forEach((item) => {
        item.addEventListener("click", (e) => {

            //  Ngăn chặn sự kiện nếu bấm vào vùng nội dung con => (user có thể nhập liệu vào ô input, copy text mà không bị đóng khối lại)
            if (e.target.closest(".hidden")) return;

            //  Reset: Xóa class 'active' của tất cả các khối khác
            methods.forEach((m) => m.classList.remove("active"));

            // Active: Thêm class 'active' cho khối vừa bấm vào
            item.classList.add("active");

            //   Tự động check vào nút Radio ẩn bên trong
            const radio = item.querySelector("input[type='radio']");
            if (radio) {
                radio.checked = true;
            }
        });
    });

    //  Xử lý khi mới load trang
    const defaultChecked = document.querySelector(".method input[type='radio']:checked");
    if (defaultChecked) {
        // Tìm lên thẻ cha => thêm class active
        const parentMethod = defaultChecked.closest(".method");
        if (parentMethod) {
            parentMethod.classList.add("active");
        }
    }
});