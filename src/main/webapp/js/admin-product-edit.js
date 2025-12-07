document.addEventListener('DOMContentLoaded', function() {
    const specsGroup = document.getElementById('specs-collapsible-group');

    if (specsGroup) {
        const header = specsGroup.querySelector('.collapsible-header');
        if (header) {
            header.addEventListener('click', function () {
                specsGroup.classList.toggle('active');
            });
        }
    }


    // LOGIC HIỆN THÔNG SỐ THEO DANH MỤC
    const categorySelect = document.getElementById('product-category');
    const specsPlaceholder = document.getElementById('specs-placeholder');
    const specsPrinter = document.getElementById('specs-printer');
    const specsStationery = document.getElementById('specs-stationery');

    // Tạo một hàm để xử lý việc ẩn/hiện
    function handleCategoryChange() {
        if (!categorySelect || !specsPlaceholder || !specsPrinter || !specsStationery) {
            return;
        }

        const selectedValue = categorySelect.value;
        specsPrinter.style.display = 'none';
        specsStationery.style.display = 'none';
        specsPlaceholder.style.display = 'block';

        // Hiện nhóm tương ứng
        if (selectedValue === '1') {
            // value của "Máy In"
            specsPrinter.style.display = 'block';
            specsPlaceholder.style.display = 'none';
        } else if (selectedValue === '2') {
            // value của "Văn Phòng Phẩm"
            specsStationery.style.display = 'block';
            specsPlaceholder.style.display = 'none';
        }
    }

    if (categorySelect) {
        categorySelect.addEventListener('change', handleCategoryChange);
    }
    handleCategoryChange();
});