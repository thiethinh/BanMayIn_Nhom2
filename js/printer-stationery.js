function initDropDown() {
    const dropdowns = document.querySelectorAll(".custom-dropdown");

    dropdowns.forEach(container => {
        const trigger = container.querySelector(".select-trigger");
        const selectedValueEl = container.querySelector(".selected-value");
        const menu = container.querySelector(".option-value");
        const allOptions = container.querySelectorAll(".option-item");
        const arrow = container.querySelector(".arrow");

        //nhấn vào trigger để bật tắt menu
        trigger.addEventListener("click", (e) => {
            e.stopPropagation();
            const isOpen = menu.classList.toggle("open");
            arrow.classList.toggle("open", isOpen);
        });

        //nhấn vào option để đổi giá trị (trừ option đầu tiên)
        allOptions.forEach((option, index) => {
            option.addEventListener("click", () => {
                const newValue = option.getAttribute("data-value");
                selectedValueEl.textContent = newValue;

                allOptions.forEach(item => item.classList.remove("selected"));
                option.classList.add("selected");

                menu.classList.remove("open");
                arrow.classList.remove("open");
            });
        });

        //chuột rời hover khỏi menu thì đóng dropdown
        menu.addEventListener("mouseleave", () => {
            menu.classList.remove("open");
            arrow.classList.remove("open");
        });
    });

    //click ra ngoài để đóng tất cả dropdown
    window.addEventListener("click", () => {
        document.querySelectorAll(".option-value.open").forEach(menu => menu.classList.remove("open"));
        document.querySelectorAll(".arrow.open").forEach(arrow => arrow.classList.remove("open"));
    });
}



function initPagination() {
    const paginationContainer = document.querySelector('.pagination');
    // không tìm thấy div pagination hoặc không có sản phẩm nào thì dừng lại
    if (!paginationContainer || document.querySelectorAll('.card-product').length === 0) {
        return;
    }

    // CÀI ĐẶT
    const productsPerPage = 8;
    let currentPage = 1;
    const allProducts = Array.from(document.querySelectorAll('.card-product'));

    // Tính tổng số trang làm tròn lên
    const totalPages = Math.ceil(allProducts.length / productsPerPage);

    // Nếu chỉ 1 trang ẩn luôn pagination cho gọn
    if (totalPages <= 1) {
        paginationContainer.style.display = 'none';
        // Đảm bảo tất cả sản phẩm đều hiển thị
        allProducts.forEach(product => product.style.display = 'block');
        return;
    } else {
        // Nếu trước đó bị ẩn thì hiện lại
        paginationContainer.style.display = 'flex';
    }

    // hàm hiển thị sản phẩm đúng theo số trang
    function showPage(page) {
        const startIndex = (page - 1) * productsPerPage;
        const endIndex = startIndex + productsPerPage;

        allProducts.forEach((product, index) => {
            if (index >= startIndex && index < endIndex) {
                product.style.display = 'block'; // Hiển thị sản phẩm trong trang này
            } else {
                product.style.display = 'none';  // Ẩn các sản phẩm khác
            }
        });
    }

    // Hàm khởi tạo giao diện theo số lượng trang và vị trí trang hiện tại
    function createPagination(totalPages, currentPage) {
        paginationContainer.innerHTML = '';

        // nút previous
        const prevLink = document.createElement('a');
        prevLink.href = '#';
        prevLink.innerText = 'Trước';
        prevLink.classList.add('page-link', 'prev');
        if (currentPage === 1) prevLink.classList.add('disabled');
        prevLink.dataset.page = currentPage - 1;
        paginationContainer.appendChild(prevLink);

        // tạo số trang
        for (let i = 1; i <= totalPages; i++) {
            const pageLink = document.createElement('a');
            pageLink.href = '#';
            pageLink.innerText = i;
            pageLink.classList.add('page-link');
            if (i === currentPage) pageLink.classList.add('active-page');
            pageLink.dataset.page = i;
            paginationContainer.appendChild(pageLink);
        }

        // tạo nút next
        const nextLink = document.createElement('a');
        nextLink.href = '#';
        nextLink.innerText = 'Sau';
        nextLink.classList.add('page-link', 'next');
        if (currentPage === totalPages) nextLink.classList.add('disabled');
        nextLink.dataset.page = currentPage + 1;
        paginationContainer.appendChild(nextLink);
    }

    // khi click
    paginationContainer.addEventListener('click', function (e) {
        e.preventDefault();
        const target = e.target;

        // Kiểm tra nếu click vào nút hợp lệ và không bị disabled
        if (target.classList.contains('page-link') && !target.classList.contains('disabled')) {
            const newPage = parseInt(target.dataset.page);
            if (newPage && newPage !== currentPage) {
                currentPage = newPage;
                // Cập nhật giao diện
                createPagination(totalPages, currentPage);
                showPage(currentPage);

            }
        }
    });

    // --- KHỞI TẠO LẦN ĐẦU ---
    createPagination(totalPages, currentPage);
    showPage(currentPage); // Hiển thị trang 1 ngay lúc đầu
}

export function initilizePrinterStationery() {
    initDropDown();
    initPagination();
}