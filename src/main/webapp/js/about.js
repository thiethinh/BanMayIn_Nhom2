// Dùng để định dạng một con số cho đẹp mắt theo chuẩn Việt Nam
function formatNumber(num) {
    return new Intl.NumberFormat('vi-VN').format(num);
}

// Hiệu ứng tăng số
function animateCountUp(element) {
    const goal = parseInt(element.dataset.goal, 10);
    const duration = 2000;
    const startTime = performance.now();

    function updateCount(timestamp) {
        const elapsedTime = timestamp - startTime;
        const progress = Math.min(elapsedTime / duration, 1);
        const easedProgress = 1 - Math.pow(1 - progress, 3); //Hiệu ứng đếm số mượt
        const currentValue = Math.floor(easedProgress * goal);

        element.textContent = formatNumber(currentValue) + '+';

        if (progress < 1) {
            requestAnimationFrame(updateCount); //API
        } else {
            element.textContent = formatNumber(goal) + '+';
        }
    }

    requestAnimationFrame(updateCount);
}

export function initializeScrollAnimations() {
    // Người quan sát: Nếu 5% nội dung lọt vào màn hình thì thêm .is-visible => css xử lý hiệu ứng của lớp .is-visible
    const observer = new IntersectionObserver((entries) => {
        entries.forEach((entry) => {
            if (entry.isIntersecting) {
                entry.target.classList.add("is-visible");
            }
        });
    }, {
        threshold: 0.05
    });


    // Gọi observer quan sát những lớp này
    const elementsToAnimate = document.querySelectorAll(
        ".about-mission-section .content-container, .stat-item, .value-item"
    );
    elementsToAnimate.forEach((element) => {
        observer.observe(element);
    });

    // 50% con số lọt vào màn hình thì gọi animateCountUp
    const countUpObserver = new IntersectionObserver((entries, observer) => {
        entries.forEach((entry) => {
            if (entry.isIntersecting) {
                animateCountUp(entry.target); //Bắt đầu đếm
                observer.unobserve(entry.target); //Ngưng quan sát
            }
        });
    }, {
        threshold: 0.5
    });

    // Quan sát những con số trong data-goal
    const numbersToAnimate = document.querySelectorAll(".stat-number[data-goal]");
    numbersToAnimate.forEach((number) => {
        countUpObserver.observe(number);
    });
}