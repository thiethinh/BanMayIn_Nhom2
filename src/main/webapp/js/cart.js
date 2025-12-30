// Lấy contextPath từ body
const contextPath = document.body.getAttribute("data-context");

// Thêm sản phẩm vào giỏ (AJAX)
function addToCart(productId) {
    fetch(`${contextPath}/cart`, {
        method: "POST",
        headers: {
            "Content-Type": "application/x-www-form-urlencoded"
        },
        body: `action=add&id=${productId}&quantity=1`
    })
        .then(res => {
            if (!res.ok) throw new Error("Add to cart failed");
            return res.text();
        })
        .then(() => {
            updateCartCount();   // ✅ cập nhật icon cart
        })
        .catch(err => console.error(err));
}


// Lấy tổng số lượng sản phẩm trong cart từ session
function updateCartCount() {
    fetch(`${contextPath}/cart?action=count`)
        .then(res => res.text())
        .then(count => {
            count = parseInt(count);

            const badge = document.getElementById("cartCount");
            if (!badge) return;

            if (count > 0) {
                badge.innerText = count;
                badge.style.display = "inline-block";
            } else {
                badge.innerText = "0";
                badge.style.display = "none";
            }
        })
        .catch(err => console.error(err));
}


// Khi load trang thì sync lại icon cart
document.addEventListener("DOMContentLoaded", () => {
    updateCartCount();
});
