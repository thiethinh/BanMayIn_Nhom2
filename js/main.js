import {initializeLogin} from "./login.js";
import {initializeSwipers} from "./swiper.js";
import {initializeBlogNavigation} from "./blog.js";

document.addEventListener('DOMContentLoaded', function () {

    const mainContent = document.querySelector('.main');
    if (!mainContent) return console.error("Lỗi: Không tìm thấy phần tử .main.");

    const navMap = {
        'HOME.html': 'nav-home',
        'LOGIN.html': 'nav-login',
        'BLOG.html': 'nav-blog',
        'CONTACT.html': 'nav-contact'
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

            switch (pageUrl) {
                case 'HOME.html':
                    initializeSwipers();
                    break;
                case 'BLOG.html':
                    initializeBlogNavigation();
                    break;
                case 'LOGIN.html':
                    initializeLogin();
                    break;
            }

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