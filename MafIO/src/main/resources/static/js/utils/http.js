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

function postTo(url, body) {
    var xhr = new XMLHttpRequest();
    xhr.open('POST', url, false);
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.send(body);
    return xhr.status;
}