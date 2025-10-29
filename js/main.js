document.addEventListener('DOMContentLoaded', function () {

    const mainContent = document.querySelector('.main');
    if (!mainContent) return console.error("Lỗi: Không tìm thấy phần tử .main.");

    const navMap = {
        'HOME.html': 'nav-home'
    };
    const defaultPage = 'HOME.html';

    // --- CÁC HÀM XỬ LÝ ---

    // 1. Hàm làm nổi bật menu
    function updateActiveMenu(pageUrl) {
        document.querySelectorAll('.menu').forEach(link => {
            link.classList.remove('active-menu');
        });

        const activeId = navMap[pageUrl];
        if (activeId) {
            const activeLink = document.getElementById(activeId);
            activeLink?.classList.add('active-menu');
        }
    }

    // HÀM KHỞI TẠO SWIPER
    function initializeSwipers() {
        const swiperConfig = {
            loop: true,
            grabCursor: true,
            breakpoints: {
                992: {slidesPerView: 4, spaceBetween: 30},
                768: {slidesPerView: 2, spaceBetween: 20},
                0: {slidesPerView: 1, spaceBetween: 10}
            }
        };

        // 1. Khởi tạo Swiper cho Máy In Nổi Bật
        const printerSwiperElement = document.querySelector('.printer-product-section.swiper');

        if (typeof Swiper !== 'undefined' && printerSwiperElement) {
            new Swiper(printerSwiperElement, {
                ...swiperConfig,
                navigation: {
                    nextEl: '.printer-product-section .swiper-button-next',
                    prevEl: '.printer-product-section .swiper-button-prev',
                },
                pagination: {
                    el: '.printer-product-section .swiper-pagination',
                    clickable: true,
                },
            });
        }

        // 2. Khởi tạo Swiper cho Văn Phòng Phẩm
        const stationerySwiperElement = document.querySelector('.stationery-product-section.swiper');

        if (typeof Swiper !== 'undefined' && stationerySwiperElement) {
            new Swiper(stationerySwiperElement, {
                ...swiperConfig,
                navigation: {
                    nextEl: '.stationery-product-section .swiper-button-next',
                    prevEl: '.stationery-product-section .swiper-button-prev',
                },
                pagination: {
                    el: '.stationery-product-section .swiper-pagination',
                    clickable: true,
                },
            });
        }
    }

    // 2. Hàm tải nội dung
    async function loadContent(pageUrl, pushState = true) {
        try {
            const response = await fetch(pageUrl);

            if (!response.ok) {
                mainContent.innerHTML = `<h2>Lỗi ${response.status}: Không tìm thấy trang "${pageUrl}"</h2>`;
                throw new Error(`Tải trang thất bại: ${response.status}`);
            }

            mainContent.innerHTML = await response.text();

            if (pushState) {
                history.pushState({page: pageUrl}, null, `?page=${pageUrl}`);
            }

            updateActiveMenu(pageUrl);
            window.scrollTo(0, 0);

            initializeSwipers();

        } catch (error) {
            console.error('Lỗi hệ thống khi tải nội dung:', error);
        }
    }

    // --- KHỞI TẠO & SỰ KIỆN ---
    const getPageFromUrl = () => {
        const urlParams = new URLSearchParams(window.location.search);
        return urlParams.get('page') || defaultPage;
    };
    loadContent(getPageFromUrl(), false);

    document.querySelectorAll('.menu').forEach(link => {
        link.addEventListener('click', function (event) {
            event.preventDefault();
            const pageToLoad = this.getAttribute('data-page') || this.getAttribute('href');
            if (pageToLoad && pageToLoad !== '#') {
                loadContent(pageToLoad);
            }
        });
    });

    // 3. Xử lý nút Back/Forward
    window.addEventListener('popstate', function () {
        loadContent(getPageFromUrl(), false);
    });
});