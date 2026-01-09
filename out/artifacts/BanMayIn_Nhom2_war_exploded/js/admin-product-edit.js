
document.addEventListener('DOMContentLoaded', function () {

    //  Bật tắt các khối thông số theo danh mục type
    const specsGroup = document.getElementById('specs-collapsible-group');

    if (specsGroup) {
        const header = specsGroup.querySelector('.collapsible-header');
        if (header) {
            header.addEventListener('click', function () {
                specsGroup.classList.toggle('active'); //active
            });
        }
    }

    // Cọn danh mục chính (Category_type)
    const categoryTypeSelect = document.getElementById('product-category');
    const subCategorySelect = document.getElementById('product-sub-category');

    //  chọn danh mục con category)
    const specsPlaceholder = document.getElementById('specs-placeholder');
    const specsPrinter = document.getElementById('specs-printer');
    const specsStationery = document.getElementById('specs-stationery');
    const specsOfficeMachine = document.getElementById('specs-office-machine');

    //data
    const printerCategories = [
        "Máy In Laser",
        "Máy In Phun",
        "Máy In Đa Năng",
        "Máy In Kim"
    ];

    const stationeryCategories = [
        "Giấy & Bìa",
        "Bút & Dụng cụ viết",
        "Sổ tay & Tập vở",
        "File và Bìa Hồ sơ",
        "Dụng cụ văn phòng"
    ];

    const officeMachineCategories = [
        "Máy scan",
        "Máy photocopy",
        "Máy hủy tài liệu"
    ];

    //  Ẩn toàn bộ nhóm thông số, chỉ hiển thị placeholder
    function hideAllSpecs() {
        if (specsPrinter) specsPrinter.style.display = 'none';
        if (specsStationery) specsStationery.style.display = 'none';
        if (specsOfficeMachine) specsOfficeMachine.style.display = 'none';
        if (specsPlaceholder) specsPlaceholder.style.display = 'block';
    }

    function resetSubCategory() {
        subCategorySelect.innerHTML = '<option value="">-- Chọn loại sản phẩm --</option>';
        subCategorySelect.disabled = true;
    }

    //  Category type change
    if (categoryTypeSelect) {
        categoryTypeSelect.addEventListener('change', function () {

            // Reset danh mục con và ẩn toàn bộ thông số
            resetSubCategory();
            hideAllSpecs();

            const type = categoryTypeSelect.value;

            if (!type) return;
            //active danh mục con
            subCategorySelect.disabled = false;

            if (type === '1') {
                // Máy In
                printerCategories.forEach(item => {
                    subCategorySelect.innerHTML += `<option value="${item}">${item}</option>`;
                });
            }

            if (type === '2') {
                // Văn phòng phẩm
                [...stationeryCategories, ...officeMachineCategories].forEach(item => {
                    subCategorySelect.innerHTML += `<option value="${item}">${item}</option>`;
                });
            }
        });
    }

    // Category change
    if (subCategorySelect) {
        subCategorySelect.addEventListener('change', function () {

            hideAllSpecs();

            const value = subCategorySelect.value;
            if (!value) return;

            // Ẩn placeholder khi đã chọn category
            specsPlaceholder.style.display = 'none';

            // Máy in
            if (printerCategories.includes(value)) {
                specsPrinter.style.display = 'block';
            }
            // Văn phòng phẩm
            else if (stationeryCategories.includes(value)) {
                specsStationery.style.display = 'block';
            }
            // Máy văn phòng khác
            else if (officeMachineCategories.includes(value)) {
                specsOfficeMachine.style.display = 'block';
            }
        });
    }

    // Page default when reload
    hideAllSpecs();
});
