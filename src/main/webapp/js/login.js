const formBox = document.querySelector('.form-box');

function login() {
    var a = document.getElementById('login');
    var b = document.getElementById('register');
    if (!a || !b) return;

    a.style.left = "40px";
    b.style.right = "-100%";
    a.style.opacity = 1;
    b.style.opacity = 0;

    if(formBox) formBox.style.height = '520px';
}

function register() {
    var a = document.getElementById('login');
    var b = document.getElementById('register');
    if (!a || !b) return;

    a.style.left = "-100%";
    b.style.right = "40px";
    a.style.opacity = 0;
    b.style.opacity = 1;

    if(formBox) formBox.style.height = '750px';
}

export function initializeLogin() {
    const loginTrigger = document.getElementById('login-trigger');
    const registerTrigger = document.getElementById('register-trigger');
    const loginSubmitButton = document.querySelector('#login .submit');

    if (!loginTrigger || !registerTrigger) {
        return;
    }

    loginTrigger.addEventListener('click', (e) => {
        e.preventDefault();
        login();
    });

    registerTrigger.addEventListener('click', (e) => {
        e.preventDefault();
        register();
    });

    if (loginSubmitButton) {
        loginSubmitButton.addEventListener('click', (e) => {
            e.preventDefault();
            localStorage.setItem('loggedIn', 'true');
            window.location.href = 'home.html';
        });
    }
}