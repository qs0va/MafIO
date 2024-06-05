let count = {}

function onIdButtonClick(slot) {
    playerElement = document.getElementById('player' + slot)
    nicknameElement = playerElement.querySelector('.nickname').querySelector('input')
    buttonElement = playerElement.querySelector('.idButton')
    idslotElement = playerElement.querySelector('.idHidden')

    nicknameElement.value.replaceAll(' ', '');
    if (nicknameElement.disabled == false) {
        id = getIdFromServer(nicknameElement.value);
        if (id.length != 0) {
            nicknameElement.style.border = 'none';
            nicknameElement.disabled = true;
            buttonElement.style.backgroundColor = 'green';
        }
        else {
            alert('Никнейм игрока №' + slot + ' не найден')
        }
        idslotElement.innerHTML = id
    }
    else {
        nicknameElement.style.border = 'solid white 1px';
        nicknameElement.disabled = false;
        buttonElement.style.backgroundColor = 'var(--primary-color)';
        idslotElement.innerHTML = ' '
    }
}

function getIdFromServer(nickname) {
    return getFrom('/data/players/id?nickname=' + nickname);
}

function onSaveClick() {
    checkForm()

    postTo('/data/games', makeRequestBody(JSON.stringify(collectPlist()), 1, 'tag'));
}

function makeRequestBody(participations, townWins, tag) {
    out = 'participations=' + participations +
     '&' + 'townWins=' + townWins +
     '&' + 'tag=' + tag;
    return out;
}

function collectPlist() {
    let out = [{}]
    for (let i = 0; i < out.length; i++) {
        out[i] = makeParticipation(1, 1, 1, 1)
    }
    return out
}

function makeParticipation(slot, playerId, role, rating) {
    let out = {}
    out.slot = slot
    out.playerId = playerId
    out.rating = rating
    out.role = role
    return out
}

function checkForm() {

}





function checkForm(idElement, roleElement, ratingElement, slot) {
    if (slot == 1) {
        count.m = 0;
        count.d = 0;
        count.sh = 0;
    }
    if (roleElement.value == 'Д') {
        count.d++;
    }
    if (roleElement.value == 'Ш') {
        count.sh++;
    }
    if (roleElement.value == 'М') {
        count.m++;
    }

    ratingElement.value = ratingElement.value.replaceAll(',', '.')
    if (idElement.innerHTML.replaceAll(' ', '').length == 0) {
        onIdButtonClick(slot)
    }

    if (idElement.innerHTML.replaceAll(' ', '').length == 0) {
        return false
    }
    if (roleElement.value != ''  &&
        roleElement.value != 'Д' &&
        roleElement.value != 'Ш' &&
        roleElement.value != 'М') {
        alert('Некорректно указана роль игрока №' + slot)
        return false
    }
    if (isNaN(parseFloat(ratingElement.value))) {
        alert('Некорректно указан балл игрока №' + slot)
        return false
    }
    if (slot == 10 && (count.m != 2 || count.d != 1 || count.sh != 1)) {
        alert('Укажите роли корректно')
        return false
    }
    return true
}
