document.addEventListener('DOMContentLoaded', onload, false);

function onload() {
    game = JSON.parse(getFrom('/data/games/' + getIdFromUrl()))
    arr = []
    for (i = 0; i < 10; i++) {
        bob = {}
        if (game.playersGames[i].player) {
            bob.nickname = game.playersGames[i].player.nickname
        }
        else {
            bob.nickname = 'Гость'
        }
        bob.slot = game.playersGames[i].slot;
        bob.role = game.playersGames[i].role;
        bob.rating = game.playersGames[i].rating;
        arr.push(bob)
    }
    arr.sort((a, b) => {
        return a.slot - b.slot;
    })
    document.getElementById("aGame").innerHTML = makeAGame(game.number, arr, game.townWins)
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