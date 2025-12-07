
// lấy toàn bộ ptu của class .method
document.querySelectorAll(".method").forEach((item) => {
  item.addEventListener("click", (e) => { //gán sự kiện cho method

    if (e.target.closest(".hidden")) return; //xử lý khi User bấm bào nội dung con sẽ tự động Un-Choose

    const isActive = item.classList.contains("active"); // check hiện tại đang chọn hay đóng
    document.querySelectorAll(".method").forEach((m) => m.classList.remove("active"));//khi chọn một khối khác đóng khối còn lại 
    if (!isActive) item.classList.add("active");// nếu chưa chọn thì mở còn đang mở thì đống lại 
  });
});
