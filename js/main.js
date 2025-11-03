document.addEventListener('DOMContentLoaded', function () {

    const mainContent = document.querySelector('.main');
    if (!mainContent) return console.error("Lỗi: Không tìm thấy phần tử .main.");

    const navMap = {
        'HOME.html': 'nav-home',
        'LOGIN.html': 'nav-login'
    };
    const defaultPage = 'HOME.html';

    // --- CÁC HÀM XỬ LÝ ---

    const menuToggle = document.querySelector('.menu-toggle');
    const navWrapper = document.querySelector('.nav-wrapper');

    // 1. Hàm làm nổi bật menu
    function updateActiveMenu(pageUrl) {
        document.querySelectorAll('.menu, .login-btn').forEach(link => {
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

        // 1.Khởi tạo Swiper
        //Khởi tạo Swiper cho introduce-section
        const heroSwiperElement = document.querySelector('.hero-slider.swiper');
        if (typeof Swiper !== 'undefined' && heroSwiperElement) {
            new Swiper(heroSwiperElement, {
                effect: 'fade',
                loop: true,
                autoplay: {
                    delay: 3000,
                    disableOnInteraction: false,
                },
                pagination: {
                    el: '.hero-slider, .swiper-pagination',
                    clickable: true,
                },
            });
        }

        // Khởi tạo Swiper cho Máy In Nổi Bật
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

        // Khởi tạo Swiper cho Văn Phòng Phẩm
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
            mainContent.classList.add('page-is-loading');
            await new Promise(resolve => setTimeout(resolve, 300));
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

            await new Promise(resolve => setTimeout(resolve, 10));
            mainContent.classList.remove('page-is-loading');

        } catch (error) {
            console.error('Lỗi hệ thống khi tải nội dung:', error);
            mainContent.classList.remove('page-is-loading');
        }
    }

    // --- KHỞI TẠO & SỰ KIỆN ---
    const getPageFromUrl = () => {
        const urlParams = new URLSearchParams(window.location.search);
        return urlParams.get('page') || defaultPage;
    };
    mainContent.classList.add('page-is-loading');
    loadContent(getPageFromUrl(), false);

    document.querySelectorAll('.menu, .login-btn').forEach(link => {
        link.addEventListener('click', function (event) {
            event.preventDefault();
            const pageToLoad = this.getAttribute('data-page') || this.getAttribute('href');
            if (pageToLoad && pageToLoad !== '#') {
                loadContent(pageToLoad);

                if (navWrapper && navWrapper.classList.contains('mobile-active')) {
                    navWrapper.classList.remove('mobile-active');
                    menuToggle.classList.remove('active');
                }
            }
        });
    });

    // 3. Xử lý nút Back/Forward
    window.addEventListener('popstate', function () {
        loadContent(getPageFromUrl(), false);
    });
    if (menuToggle && navWrapper) {
        menuToggle.addEventListener('click', function () {
            navWrapper.classList.toggle('mobile-active');
            menuToggle.classList.toggle('active');
        });
    }
});

// login - register
function login() {
    var a = document.getElementById('login');
    var b = document.getElementById('register');

        a.style.left = "40px";
        b.style.right = "-100%";
        a.style.opacity = 1;
        b.style.opacity = 0;
}

function register() {
    var a = document.getElementById('login');
    var b = document.getElementById('register');
        a.style.left = "-100%";
        b.style.right = "40px";
        a.style.opacity = 0;
        b.style.opacity = 1;
}