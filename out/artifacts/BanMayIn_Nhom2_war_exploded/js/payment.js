document.addEventListener("DOMContentLoaded", () => {
    //  Lấy tất cả các khối phương thức thanh toán
    const methods = document.querySelectorAll(".method");

    // Xử lý sự kiện CLICK cho từng khối
    methods.forEach((item) => {
        item.addEventListener("click", (e) => {

            //  Ngăn chặn sự kiện nếu bấm vào vùng nội dung con
            if (e.target.closest(".hidden")) return;

            //   Kiểm tra xem khối này CÓ ĐANG MỞ KHÔNG trước khi reset
            const wasActive = item.classList.contains("active");

            //  Đóng tất cả các khối (Reset)
            methods.forEach((m) => m.classList.remove("active"));

            //dùng Toggle
            if (!wasActive) {
                item.classList.add("active");

                // Tự động check vào nút Radio khi mở ra
                const radio = item.querySelector("input[type='radio']");
                if (radio) {
                    radio.checked = true;
                }
            }
        });
    });

    // Xử lý mặc định khi mới load trang
    const defaultChecked = document.querySelector(".method input[type='radio']:checked");
    if (defaultChecked) {
        const parentMethod = defaultChecked.closest(".method");
        if (parentMethod) {
            parentMethod.classList.add("active");
        }
    }
});