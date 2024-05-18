document.addEventListener('DOMContentLoaded', onload, false);

function onload() {
    document.getElementById("aGame").innerHTML = makeAGame();
}

function makeAGame() {
    out = makeAGameHeader()
    for (i = 0; i < 10; i++) {
        out += makeAPlayer(i + 1)
    }
    out += makeAGameFooter()
    return out;
}

function makeAGameHeader() {
    out = 
        '<h1>Новая игра</h1>' +
        '<div class="aPlayer" id="header">' +
        '    <div class="left">' +
        '        <div class="slot">' +
        '            Слот' +
        '        </div>' +
        '        <div class="nickname">' +
        '            Никнейм' +
        '        </div>' +
        '    </div>' +
        '    <div class="right">' +
        '        <div class="role">' +
        '            Роль' +
        '        </div>' +
        '        <div class="rating">' +
        '            Балл' +
        '        </div>' +
        '    </div>' +
        '</div>';
    return out;
}

function makeAPlayer(slot) {
    out = 
        '<div class="aPlayer" id="player' + slot + '">' +
        '   <div class="left">' +
        '       <div class="slot">' +
                    slot +
        '       </div>' +
        '       <div class="nickname">' +
        '           <input class="nicknameInput" type="text" placeholder="Игрок ' + slot +'">' +
        '       </div>' +
        '       <div class="idButton" onclick="onIdButtonClick(' + slot + ')">' +
        '           ' +
        '       </div>' +
        '       <div class="idHidden" style="display: none">' +
        '       </div>' +
        '   </div>' +
        '   <div class="right">' +
        '       <div class="role">' +
        '           <input class="roleInput" type="text" placeholder="">' +
        '       </div>' +
        '       <div class="rating">' +
        '           <input class="ratingInput" type="text" placeholder="">' +
        '       </div>' +
        '   </div>' +
        '</div>';
    return out;
}

function makeAGameFooter() {
    out = 
        '<div class="control">' +
            '<input type="button" value="Сохранить" onclick="save()">' +
        '</div>';
    return out;
}