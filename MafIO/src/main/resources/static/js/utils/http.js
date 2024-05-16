function getFrom(url) {
    var xhr = new XMLHttpRequest();
    xhr.open('GET', url, false);
    xhr.send();
    return xhr.responseText;
}

function deleteFrom(url) {
    var xhr = new XMLHttpRequest();
    xhr.open('DELETE', url, false);
    xhr.send();
    return xhr.responseText;
}