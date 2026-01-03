function initDropDown() {
    const dropdowns = document.querySelectorAll(".custom-dropdown");

    dropdowns.forEach(container => {
        const trigger = container.querySelector(".select-trigger");
        const selectedValueEl = container.querySelector(".selected-value");
        const menu = container.querySelector(".option-value");
        const allOptions = container.querySelectorAll(".option-item");
        const arrow = container.querySelector(".arrow");

        // Lấy input ẩn dựa trên attribute data-target đã thêm ở JSP
        const targetInputId = container.getAttribute("data-target");
        const hiddenInput = document.getElementById(targetInputId);

        // Toggle menu
        trigger.addEventListener("click", (e) => {
            e.stopPropagation();
            // Đóng các dropdown khác trước khi mở cái này
            document.querySelectorAll(".option-value.open").forEach(openedMenu => {
                if (openedMenu !== menu) openedMenu.classList.remove("open");
            });
            document.querySelectorAll(".arrow.open").forEach(openedArrow => {
                if (openedArrow !== arrow) openedArrow.classList.remove("open");
            });

            const isOpen = menu.classList.toggle("open");
            arrow.classList.toggle("open", isOpen);
        });

        // Xử lý chọn option
        allOptions.forEach((option) => {
            option.addEventListener("click", () => {
                const newValue = option.getAttribute("data-value");
                const newText = option.textContent;

                // 1. Cập nhật giao diện text
                selectedValueEl.textContent = newText;

                // 2. Highlight option được chọn
                allOptions.forEach(item => item.classList.remove("selected"));
                option.classList.add("selected");

                // 3. QUAN TRỌNG: Cập nhật giá trị vào thẻ input hidden để gửi về server
                if (hiddenInput) {
                    hiddenInput.value = newValue;
                    console.log(`Updated ${targetInputId} to: ${newValue}`); // Debug
                }

                // 4. Đóng menu
                menu.classList.remove("open");
                arrow.classList.remove("open");
            });
        });

        menu.addEventListener("mouseleave", () => {
            menu.classList.remove("open");
            arrow.classList.remove("open");
        });
    });

    // Click outside closing logic
    window.addEventListener("click", () => {
        document.querySelectorAll(".option-value.open").forEach(menu => menu.classList.remove("open"));
        document.querySelectorAll(".arrow.open").forEach(arrow => arrow.classList.remove("open"));
    });
}

function initPagination() {
    const paginationContainer = document.querySelector('.pagination');
    const productSelector = '.product-card';
    const allProducts = Array.from(document.querySelectorAll(productSelector));

    if (!paginationContainer || allProducts.length === 0) {
        if(paginationContainer) paginationContainer.style.display = 'none';
        return;
    }

    const productsPerPage = 8;
    let currentPage = 1;
    const totalPages = Math.ceil(allProducts.length / productsPerPage);

    if (totalPages <= 1) {
        paginationContainer.style.display = 'none';
        allProducts.forEach(product => product.style.display = 'flex');
        return;
    } else {
        paginationContainer.style.display = 'flex';
    }

    function showPage(page) {
        const startIndex = (page - 1) * productsPerPage;
        const endIndex = startIndex + productsPerPage;

        allProducts.forEach((product, index) => {
            if (index >= startIndex && index < endIndex) {
                product.style.display = 'flex';
            } else {
                product.style.display = 'none';
            }
        });
    }

    function createPagination(totalPages, currentPage) {
        paginationContainer.innerHTML = '';

        // Nút Prev
        const prevLink = document.createElement('a');
        prevLink.href = '#';
        prevLink.innerHTML = "<i class='bx bx-chevron-left'></i>"; // Thêm icon cho đẹp
        prevLink.classList.add('page-link', 'prev');
        if (currentPage === 1) prevLink.classList.add('disabled');
        prevLink.dataset.page = currentPage - 1;
        paginationContainer.appendChild(prevLink);

        // Các số trang
        for (let i = 1; i <= totalPages; i++) {
            const pageLink = document.createElement('a');
            pageLink.href = '#';
            pageLink.innerText = i;
            pageLink.classList.add('page-link');
            if (i === currentPage) pageLink.classList.add('active-page');
            pageLink.dataset.page = i;
            paginationContainer.appendChild(pageLink);
        }

        // Nút Next
        const nextLink = document.createElement('a');
        nextLink.href = '#';
        nextLink.innerHTML = "<i class='bx bx-chevron-right'></i>";
        nextLink.classList.add('page-link', 'next');
        if (currentPage === totalPages) nextLink.classList.add('disabled');
        nextLink.dataset.page = currentPage + 1;
        paginationContainer.appendChild(nextLink);
    }

    paginationContainer.addEventListener('click', function (e) {
        e.preventDefault();
        const target = e.target.closest('.page-link');

        if (target && !target.classList.contains('disabled')) {
            const newPage = parseInt(target.dataset.page);
            if (newPage && newPage !== currentPage) {
                currentPage = newPage;
                createPagination(totalPages, currentPage);
                showPage(currentPage);

                document.querySelector('.product-container').scrollIntoView({ behavior: 'smooth' });
            }
        }
    });

    createPagination(totalPages, currentPage);
    showPage(currentPage);
}



export function initilizePrinterStationery() {
    initDropDown();
    initPagination();
}