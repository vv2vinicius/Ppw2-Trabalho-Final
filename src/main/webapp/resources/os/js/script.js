
toggleAside = function(event) {
    event.preventDefault();
    if(isMobile()){
        if(document.body.classList.contains('aside-mobile-open')){
            document.body.classList.remove('aside-mobile-open');
        } else {
            document.body.classList.add('aside-mobile-open');
        }
    } else {
        if(document.body.classList.contains('aside-open')){
            document.body.classList.remove('aside-open');
        } else {
            document.body.classList.add('aside-open');
        }
    }
};
toggleSubmenu = function(submenu) {
//    event.preventDefault();
//    console.log(event);
//    var submenu = event.target;
    if(submenu.classList.contains('submenu-open')){
        submenu.classList.remove('submenu-open');
    } else  {
        submenu.classList.add('submenu-open');
    }
};

document.querySelector('.aside-toggle').addEventListener('click', event => toggleAside(event));
document.querySelectorAll('.submenu-toggle').forEach(submenu => {
    //event quando clicado sobre o icone <i></i> nao permitia a abertura do menu
    submenu.addEventListener('click', event => {
        event.preventDefault();
        toggleSubmenu(submenu);
    });
});


function isMobile() {
    return window.innerWidth <= 768;
}