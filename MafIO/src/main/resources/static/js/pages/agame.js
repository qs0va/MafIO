document.addEventListener('DOMContentLoaded', onload, false);

function onload() {
    game = JSON.parse(getFrom('/data/games/' + getIdFromUrl()))
    alert(game.townWins)
    arr = []
    for (i = 0; i < 10; i++) {
        bob = {}
        bob.nickname = game.participations[i].player.nickname
        bob.slot = game.participations[i].slot;
        bob.role = game.participations[i].role;
        bob.rating = game.participations[i].rating;
        arr.push(bob)
    }
    document.getElementById("aGame").innerHTML = makeAGame(game.id, arr, game.townWins)
}

function makeAGame(number, jsArray, townWins) {
    out = "<h1>Игра #" + number + "</h1>"
    for (i = 0; i < jsArray.length; i++) {
        out += makeAPlayer(jsArray[i].slot, jsArray[i].nickname, jsArray[i].role, jsArray[i].rating)
    }
    if (townWins) {
        out += "<p>Победа города</p>";
    }
    else {
        out += "<p>Победа мафии</p>";
    }
    return out;
}

function makeAPlayer(slot, nickname, role, rating) {
    out = 
        "<div class=\"aPlayer\">" + 
            "<div class=\"left\">" + 
                "<div class=\"slot\">" + 
                    slot + 
                "</div>" + 
                "<div class=\"nickname\">" +
                    nickname + 
                "</div>" +
            "</div>" + 
            "<div class=\"right\">" + 
                "<div class=\"role\">" + 
                    role +
                "</div>" +
                "<div class=\"rating\">" + 
                    rating +
                "</div>" +
            "</div>" + 
        "</div>";
    return out;
}

function getIdFromUrl() {
    url = window.location.href
    a = url.split('/')
    return +(a[a.length-1])
}