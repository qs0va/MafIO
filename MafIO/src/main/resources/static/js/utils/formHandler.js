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

function save() {
    let out = Array(10).fill({})

    for (i = 0; i < 10; i++) {
        slot = 1 + i
        playerElement = document.getElementById('player' + slot)
        idslotElement = playerElement.querySelector('.idHidden')
        ratingElement = playerElement.querySelector('.rating').querySelector('input')
        roleElement   = playerElement.querySelector('.role')  .querySelector('input')

        if(checkForm(idslotElement, roleElement, ratingElement, slot)) {
            out[i] = makePlayerGame(idslotElement.innerHTML, slot, roleElement.value,ratingElement.value)
        }
        else {
            return
        }
    }

    if (putTo('/data/games', JSON.stringify(out)) == 200) {
        alert('Сохранено')
    }
    else {
        alert('Ошибка сервера')
    }
}

function makePlayerGame(playerId, slot, role, rating) {
    let out = {}
    out.player = {}
    out.player.id = playerId
    out.role = role
    out.rating = rating
    out.slot = slot
    return out
}

function getIdFromServer(nickname) {
    return getFrom('/data/players/id?nickname=' + nickname);
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
