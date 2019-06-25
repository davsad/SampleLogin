/* Handles extraction of cookie */
function getCookie() {
    var cookies = document.cookie.match('(^|[^;]+)\\s*sample\\s*=\\s*([^;]+)');
    return cookies ? cookies.pop() : '';
}