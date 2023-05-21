document.addEventListener('DOMContentLoaded', function() {
    var carousel = document.querySelector('#carouselExampleControls');
    var carouselInner = carousel.querySelector('.carousel-inner');
    var carouselItems = carousel.querySelectorAll('.carousel-item');
    var prevButton = carousel.querySelector('.carousel-control-prev');
    var nextButton = carousel.querySelector('.carousel-control-next');

    var cardWidth = carouselItems[0].offsetWidth;
    var scrollPosition = 0;
    var maxScrollPosition = carouselInner.scrollWidth - carouselInner.offsetWidth;

    nextButton.addEventListener('click', function() {
        if (scrollPosition < maxScrollPosition) {
            scrollPosition += cardWidth;
            carouselInner.style.transform = 'translateX(-' + scrollPosition + 'px)';
        }
    });

    prevButton.addEventListener('click', function() {
        if (scrollPosition > 0) {
            scrollPosition -= cardWidth;
            carouselInner.style.transform = 'translateX(-' + scrollPosition + 'px)';
        }
    });
});