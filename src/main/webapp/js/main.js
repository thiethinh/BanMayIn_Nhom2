// --- HÀM CHÍNH ---
document.addEventListener('DOMContentLoaded', () => {

    // Khởi tạo Menu Mobile
    const menuToggle = document.querySelector('.menu-toggle');
    const navWrapper = document.querySelector('.nav-wrapper');
    if (menuToggle && navWrapper) {
        menuToggle.addEventListener('click', function () {
            navWrapper.classList.toggle('mobile-active');
            menuToggle.classList.toggle('active');
        });
    }

    const currentPage = window.location.pathname.split('/').pop() || 'home.html';
    const navMap = {
        'home': 'nav-home',
        'login': 'nav-login',
        'blog.jsp': 'nav-blog',
        'contact.jsp': 'nav-contact',
        'printer': 'nav-printer',
        'stationery': 'nav-stationery'
    };
    document.querySelectorAll('.menu, .login-btn').forEach(link => {
        link.classList.remove('active-menu');
    });
    const activeId = navMap[currentPage];
    if (activeId) {
        const activeLink = document.getElementById(activeId);
        if (activeLink) {
            activeLink.classList.add('active-menu');
        }
    }

    if (document.querySelector('.hero-slider.swiper')) {
        import('./swiper.js')
            .then(module => {
                module.initializeSwipers();
            })
    }

    if (document.querySelector('.form-box')) {
        import('./login.js')
            .then(module => {
                module.initializeLogin();
            })
    }

    if (document.querySelector('.blog-nav')) {
        import('./blog.js')
            .then(module => {
                module.initializeBlogNavigation();
            })
    }

    if (document.querySelector('.stats-section') || document.querySelector('.values-section')) {
        import('./about.js')
            .then(module => {
                module.initializeScrollAnimations();
            })
    }

    if (document.querySelector('.product-container')) {
        import('./printer-stationery.js')
            .then(module => {
                module.initilizePrinterStationery();
            })
    }
});