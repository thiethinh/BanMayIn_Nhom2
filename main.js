// main.js - Phiên bản Tối ưu & Dễ đọc hơn

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

    // 2. Hàm tải nội dung
    async function loadContent(pageUrl, pushState = true) {
        try {
            const response = await fetch(pageUrl);

            if (!response.ok) {
                mainContent.innerHTML = `<h2 style="text-align:center; color:red; padding-top: 150px;">Lỗi ${response.status}: Không tìm thấy trang "${pageUrl}"</h2>`;
                throw new Error(`Tải trang thất bại: ${response.status}`);
            }

            mainContent.innerHTML = await response.text();

            if (pushState) {
                history.pushState({ page: pageUrl }, null, `?page=${pageUrl}`);
            }

            updateActiveMenu(pageUrl);
            window.scrollTo(0, 0);

        } catch (error) {
            console.error('Lỗi hệ thống khi tải nội dung:', error);
        }
    }

    // --- KHỞI TẠO & SỰ KIỆN ---

    // Lấy tên trang từ URL hoặc dùng mặc định
    const getPageFromUrl = () => {
        const urlParams = new URLSearchParams(window.location.search);
        return urlParams.get('page') || defaultPage;
    };

    // 1. Tải trang ban đầu (Khởi tạo)
    loadContent(getPageFromUrl(), false);

    // 2. Xử lý sự kiện click trên Menu
    document.querySelectorAll('.menu').forEach(link => {
        link.addEventListener('click', function (event) {
            event.preventDefault();
            const pageToLoad = this.getAttribute('data-page');
            if (pageToLoad) {
                loadContent(pageToLoad);
            }
        });
    });

    // 3. Xử lý nút Back/Forward
    window.addEventListener('popstate', function () {
        // Tải lại nội dung từ URL hiện tại mà không push state mới
        loadContent(getPageFromUrl(), false);
    });
});