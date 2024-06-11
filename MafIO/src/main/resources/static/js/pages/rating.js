document.addEventListener('DOMContentLoaded', onload, false);

function onload() {
    document.getElementById('controlContainer').innerHTML = makeControl();
}

function onShowClick() {
    document.getElementById('tableContainer').innerHTML = makeTable();
}
