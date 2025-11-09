import { initializeSwipers } from './swiper.js';
import { initializeLogin } from './login.js';
import { initializeBlogNavigation } from './blog.js';
import { initializeScrollAnimations } from './about.js';
import { initilizePrinterStationery } from './printer-stationery.js';

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

    // Làm nổi bật Menu Hiện tại
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

    if (document.querySelector('.hero-slider.swiper')) {
        initializeSwipers();
    }

    if (document.querySelector('.form-box')) {
        initializeLogin();
    }

    if (document.querySelector('.blog-nav')) {
        initializeBlogNavigation();
    }

    if (document.querySelector('.stats-section') || document.querySelector('.values-section')) {
        initializeScrollAnimations();
    }

    if(document.querySelector('.product-container')) {
        initilizePrinterStationery();
    }
    
});