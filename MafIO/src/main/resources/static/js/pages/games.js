document.addEventListener('DOMContentLoaded', onload, false);

function onload() {
    document.getElementById('listContainer').innerHTML = makeList(JSON.parse(getFrom('/data/games')));
}

function makeList(jsArray) {
    out = '';
    for (let i = 0; i < jsArray.length; i++) {
        out += makeListItem(i+1, 'icon', 'Игра #' + jsArray[i].id, '', jsArray[i].tag,  jsArray[i].id);
    }
    return out;
}

function onListItemClick(id) {
    document.location.href = '/games/' + id;
}
