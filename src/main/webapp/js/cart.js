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
            if (res.ok) {
                updateCartCount();

                console.log("Đã thêm vào giỏ thành công!");
            } else {
                // tb lỗi
                console.error("Lỗi server khi thêm giỏ hàng");
                alert("Có lỗi xảy ra, vui lòng thử lại.");
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
            if (res.ok) {
                // Load lại trang để Server tính lại Tổng tiền (Total, VAT)
                location.reload();
            } else {
                alert("Lỗi cập nhật giỏ hàng!");
            }
        })
        .catch(err => console.error("Lỗi:", err));
}