export function initializeBlogNavigation() {
    const postContainer = document.querySelector('.post-container');
    const paginationContainer = document.querySelector('.pagination');
    const filterButtons = document.querySelectorAll('.filter-btn');

    if (!postContainer || !paginationContainer || !filterButtons) {
        return;
    }

    const postsPerPage = 9;
    let currentPage = 1;
    const allPosts = Array.from(document.querySelectorAll('.post-card'));

    function getFilteredPosts() {
        const activeFilter = document.querySelector('.filter-btn.active');
        const filterValue = activeFilter ? activeFilter.getAttribute('data-filter') : 'all';

        if (filterValue === 'all') {
            return allPosts;
        }
        return allPosts.filter(post => post.getAttribute('data-category') === filterValue);
    }

    function displayPage(postsToShow, page) {
        allPosts.forEach(post => post.style.display = 'none');

        const startIndex = (page - 1) * postsPerPage;
        const endIndex = startIndex + postsPerPage;
        const pagePosts = postsToShow.slice(startIndex, endIndex);

        pagePosts.forEach(post => {
            post.style.display = 'flex';
        });
    }

    function setupPagination(filteredPosts) {
        const totalPages = Math.ceil(filteredPosts.length / postsPerPage);
        paginationContainer.innerHTML = '';

        if (totalPages <= 1) {
            return;
        }

        const prevButton = document.createElement('a');
        prevButton.href = '#';
        prevButton.className = 'page-link prev';
        prevButton.textContent = 'Trước';
        if (currentPage === 1) {
            prevButton.classList.add('disabled');
        }
        paginationContainer.appendChild(prevButton);

        for (let i = 1; i <= totalPages; i++) {
            const pageButton = document.createElement('a');
            pageButton.href = '#';
            pageButton.className = 'page-link';
            pageButton.textContent = i;
            if (i === currentPage) {
                pageButton.classList.add('active-page');
            }
            paginationContainer.appendChild(pageButton);
        }

        const nextButton = document.createElement('a');
        nextButton.href = '#';
        nextButton.className = 'page-link next';
        nextButton.textContent = 'Sau';
        if (currentPage === totalPages) {
            nextButton.classList.add('disabled');
        }
        paginationContainer.appendChild(nextButton);
    }

    function handleFilterClick(event) {
        event.preventDefault();
        const clickedButton = event.currentTarget;

        filterButtons.forEach(btn => btn.classList.remove('active'));
        clickedButton.classList.add('active');

        currentPage = 1;

        const filteredPosts = getFilteredPosts();
        displayPage(filteredPosts, currentPage);
        setupPagination(filteredPosts);
    }

    function handlePaginationClick(event) {
        event.preventDefault();
        const clickedLink = event.target.closest('.page-link');

        if (!clickedLink || clickedLink.classList.contains('disabled') || clickedLink.classList.contains('active-page')) {
            return;
        }

        const filteredPosts = getFilteredPosts();
        const totalPages = Math.ceil(filteredPosts.length / postsPerPage);

        if (clickedLink.classList.contains('prev')) {
            if (currentPage > 1) currentPage--;
        } else if (clickedLink.classList.contains('next')) {
            if (currentPage < totalPages) currentPage++;
        } else {
            currentPage = parseInt(clickedLink.textContent);
        }

        displayPage(filteredPosts, currentPage);
        setupPagination(filteredPosts);

        const blogHeader = document.querySelector('.blog-section');
        if (blogHeader) {
            blogHeader.scrollIntoView({behavior: 'smooth', block: 'start'});
        }
    }

    filterButtons.forEach(btn => {
        btn.addEventListener('click', handleFilterClick);
    });

    paginationContainer.addEventListener('click', handlePaginationClick);

    const initialPosts = getFilteredPosts();
    displayPage(initialPosts, currentPage);
    setupPagination(initialPosts);
}