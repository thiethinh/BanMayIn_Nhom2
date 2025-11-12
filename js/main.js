// Xử lý trạng thái đăng nhập của trang
function logOut(button) {
    button.addEventListener('click', (e) => {
        e.preventDefault();
        localStorage.removeItem('loggedIn');
        window.location.reload();
    });
}

function changeHeaderWherLoggedIn() {
    const userActionDiv = document.querySelector('.user-action');
    const loginBtn = document.getElementById('nav-login');

    if (!userActionDiv || !loginBtn) return;

    loginBtn.remove();

    const accountLink = document.createElement('a');
    accountLink.href = 'account.html';
    accountLink.className = 'user-profile-btn';
    accountLink.innerHTML = '<i class="fa-solid fa-user"></i>';

    userActionDiv.appendChild(accountLink);
}

function checkLoginStatus() {
    const loggedIn = localStorage.getItem('loggedIn');
    if (loggedIn === 'true') {
        changeHeaderWherLoggedIn();
    }
}

// --- HÀM CHÍNH ---
document.addEventListener('DOMContentLoaded', () => {

    // Khởi tạo Menu Mobile (Giữ nguyên)
    const menuToggle = document.querySelector('.menu-toggle');
    const navWrapper = document.querySelector('.nav-wrapper');
    if (menuToggle && navWrapper) {
        menuToggle.addEventListener('click', function () {
            navWrapper.classList.toggle('mobile-active');
            menuToggle.classList.toggle('active');
        });
    }

    const currentPage = window.location.pathname.split('/').pop() || 'index.html';
    const navMap = {
        'index.html': 'nav-home',
        'home.html': 'nav-home',
        'login.html': 'nav-login',
        'blog.html': 'nav-blog',
        'contact.html': 'nav-contact',
        'printer.html' : 'nav-printer',
        'stationery.html' : 'nav-stationery'
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

    checkLoginStatus();
    const accountLogoutBtn = document.getElementById('account-logout');
    if (accountLogoutBtn) {
        logOut(accountLogoutBtn);
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

});