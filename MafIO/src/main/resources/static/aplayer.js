document.addEventListener('DOMContentLoaded', onload, false);

function onload() {
    document.getElementById("playerData").innerHTML=makeFields(JSON.parse(getFrom('/data/players/' + getIdFromUrl())))
}

function getIdFromUrl() {
    url = window.location.href
    a = url.split('/')
    return +(a[a.length-1])
}

function makeFields(jsObject) {
    var out = '<p>' + jsObject.nickname + '</p>'
    out = out + '<button type="button" onclick="deletePlayer()">Удалить</button>';
    return out;
}

function deletePlayer() {
    deleteFrom('/data/players/' + getIdFromUrl());
    window.location.href = '/players';
}