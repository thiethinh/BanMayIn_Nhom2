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
    const buttons = document.querySelectorAll(".page-btn:not(#prev):not(#next)");
    const prevBtn = document.getElementById("prev");
    const nextBtn = document.getElementById("next");
    let currentPage = 1;

    function updatePagination() {
        buttons.forEach(btn => btn.classList.remove("active"));
        buttons[currentPage - 1].classList.add("active");
        prevBtn.disabled = currentPage === 1;
        nextBtn.disabled = currentPage === buttons.length;
    }

    buttons.forEach((btn, index) => {
        btn.addEventListener("click", () => {
            currentPage = index + 1;
            updatePagination();
        });
    });

    prevBtn.addEventListener("click", () => {
        if (currentPage > 1) {
            currentPage--;
            updatePagination();
        }
    });

    nextBtn.addEventListener("click", () => {
        if (currentPage < buttons.length) {
            currentPage++;
            updatePagination();
        }
    });

    updatePagination();
}

export function initilizePrinterStationery() {
        initDropDown();
        initPagination();
}