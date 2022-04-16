function Menu() {
    const elements = document.getElementsByClassName("menuDictItem");
    for (i = 0; i < elements.length; i++) {
        elements[i].addEventListener('mousedown', showMenu);
        elements[i].addEventListener('mouseleave', hideMenu);
    }

    function showMenu() {
        if (this.children.length > 1) {
            this.children[1].style.height = 'auto';
            this.children[1].style.opacity = '1';
            this.children[1].style.overflow = 'visible';
        }
    }

    function hideMenu() {
        if (this.children.length > 1) {
            this.children[1].style.height = '0';
            this.children[1].style.opacity = '0';
            this.children[1].style.overflow = 'hidden';
        }
    }
}