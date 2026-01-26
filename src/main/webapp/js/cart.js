// Lấy thẻ input ẩn ở header
const contextElement = document.getElementById("globalContextPath");
const contextPath = contextElement ? contextElement.value : "";

// Thêm sản phẩm vào giỏ(AJAX)
function addToCart(productId) {
    console.log("Đang thêm sản phẩm ID:", productId);

    fetch(`${contextPath}/cart`, {
        method: "POST",
        headers: {
            "Content-Type": "application/x-www-form-urlencoded"
        },
        body: `action=add&id=${productId}&quantity=1`
    })
        .then(res => {
            // Lỗi 401 =>chua đăng nhập
            if (res.status === 401) {
                Swal.fire({
                    title: 'Bạn chưa đăng nhập!',
                    text: "Vui lòng đăng nhập để thêm sản phẩm vào giỏ hàng.",
                    icon: 'warning',
                    showCancelButton: true,
                    confirmButtonColor: '#165FF2',
                    cancelButtonColor: '#d33',
                    confirmButtonText: 'Đăng nhập',
                    cancelButtonText: 'Để sau',
                    didOpen: () => {
                        const popup = Swal.getPopup();
                        popup.style.textAlign = 'center';

                        const confirmBtn = Swal.getConfirmButton();
                        const cancelBtn = Swal.getCancelButton();

                        if (confirmBtn && cancelBtn) {
                            confirmBtn.style.minWidth = '160px';
                            cancelBtn.style.minWidth = '160px';

                            confirmBtn.style.margin = '0 10px';
                            cancelBtn.style.margin = '0 10px';
                        }
                    }
                }).then((result) => {
                    if (result.isConfirmed) {
                        // Chuyển hướng sang trang Login
                        window.location.href = `${contextPath}/login`;
                    }
                });
                return;
            }


            //Xly Thêm thành côcng
            if (res.ok) {
                updateCartCount();

            // Hiện thông báo nhỏ góc trên bên phải (Toast)
                Swal.fire({
                    icon: 'success',
                    title: 'Đã thêm vào giỏ hàng!',
                    toast: true,
                    position: 'top-end',
                    showConfirmButton: false,
                    timer: 1500,
                    timerProgressBar: true,
                    didOpen: (toast) => {
                        toast.addEventListener('mouseenter', Swal.stopTimer)
                        toast.addEventListener('mouseleave', Swal.resumeTimer)
                    }
                });
            } else {
                // Lỗi khng thêm được vào giỏ hàng khác
                Swal.fire({
                    icon: 'error',
                    title: 'Lỗi!',
                    text: 'Không thể thêm sản phẩm vào giỏ.',
                });
            }
        })
        .catch(err => {
            console.error("Lỗi kết nối:", err);
        });
}

// Lấy tổng số lượng sản phẩm
function updateCartCount() {
    fetch(`${contextPath}/cart?action=count`)
        .then(res => res.text())
        .then(count => {
            count = parseInt(count);
            const badge = document.getElementById("cartCount");

            if (badge) {
                if (count > 0) {
                    badge.innerText = count;
                    badge.style.display = "flex";
                } else {
                    badge.style.display = "none";
                }
            }
        })
        .catch(err => console.error(err));
}

// Khi load trang thì sync lại icon cart
document.addEventListener("DOMContentLoaded", () => {
    updateCartCount();
});


//============= Cart Quantity edition ===========
function updateQuantity(productId, change) {
    const inputElement = document.getElementById(`qty-${productId}`);
    if (!inputElement) return;

    let currentQty = parseInt(inputElement.value);
    let newQty = currentQty;

    // Logic tính toán số lượng mới
    if (change === 0) {
        // Trường hợp nhập trực tiếp
        newQty = currentQty;
    } else {
        // Trường hợp bấm nút +/-
        newQty = currentQty + change;
    }

    //limit = 1
    if (newQty < 1) {
        newQty = 1;
        inputElement.value = 1;
        return;
    }

    // Cập nhật lại giá trị hiển thị trên ô input (cho trường hợp bấm nút)
    inputElement.value = newQty;

    // Gửi AJAX về Server => cập nhật giỏ hàng
    fetch(`${contextPath}/cart`, {
        method: "POST",
        headers: {
            "Content-Type": "application/x-www-form-urlencoded"
        },
        body: `action=update&id=${productId}&quantity=${newQty}`
    })
        .then(res => {
            //XLy Thành công
            if (res.ok) {
                // Load lại trang để Server tính lại Tổng tiền (Total, VAT)
                location.reload();
            } else {
                alert("Lỗi cập nhật giỏ hàng!");
            }
        })
        .catch(err => console.error("Lỗi:", err));
}
