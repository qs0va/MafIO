let count = {}

function onIdButtonClick(slot) {
    nicknameElement = getElement(slot, '.nicknameInput')
    buttonElement = getElement(slot, '.idButton')
    idElement = getElement(slot, '.idHidden')

    nicknameElement.value.replaceAll(' ', '');
    if (nicknameElement.disabled == false) {
        id = getIdFromServer(nicknameElement.value);
        if (id.length != 0 || nicknameElement.value.length == 0) {
            nicknameElement.style.border = 'none';
            nicknameElement.disabled = true;
            buttonElement.style.backgroundColor = 'green';
        }
        else {
            alert('Никнейм игрока №' + slot + ' не найден')
        }
        if (nicknameElement.value.length == 0) {
            idElement.innerHTML = 0
        }
        else {
            idElement.innerHTML = id
        }
    }
    else {
        nicknameElement.style.border = 'solid white 1px';
        nicknameElement.disabled = false;
        buttonElement.style.backgroundColor = 'var(--primary-color)';
        idElement.innerHTML = ''
    }
}

function getIdFromServer(nickname) {
    return getFrom('/data/players/id?nickname=' + nickname);
}

function onSaveClick() {
    if (checkForm()) {
        alert('Сохранено')
        postTo('/data/games', makeRequestBody(
            JSON.stringify(collectPlist()),
            document.getElementById('whoWins').querySelector('select').value == 'Города',
            document.getElementById('tag').querySelector('select').value
        ));
    }
}

function makeRequestBody(participations, townWins, tag) {
    out = 'participations=' + participations +
     '&' + 'townWins=' + townWins +
     '&' + 'tag=' + tag;
    return out;
}

function collectPlist() {
    let out = []
    for (let i = 0; i < 10; i++) {
        out.push(makeParticipation(
            1 + i,
            getElement(1 + i, '.idHidden').innerHTML,
            getElement(1 + i, '.roleInput').value,
            getElement(1 + i, '.ratingInput').value
        ))
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
    count = {}
    count.m = 0;
    count.d = 0;
    count.sh = 0;
    for (let i = 0; i < 10; i++) {
        idElement = getElement(1 + i, '.idHidden')
        if (idElement.innerHTML.replaceAll(' ', '').length == 0) {
            onIdButtonClick(1 + i)
        }
        if (idElement.innerHTML.replaceAll(' ', '').length == 0) {
            return false
        }
    }
    for (let i = 0; i < 10; i++) {
        ratingElement = getElement(1 + i, '.ratingInput')
        roleElement = getElement(1 + i, '.roleInput')

        // Preparing
        ratingElement.value = ratingElement.value.replaceAll(',', '.')

        // Checking ratings
        if (ratingElement.value.length != 0 && isNaN(parseFloat(ratingElement.value))) {
            alert('Некорректно указан балл игрока №' + (1 + i))
            return false
        }

        // Counting roles
        if (roleElement.value == 'Д') {
            count.d++;
        }
        if (roleElement.value == 'Ш') {
            count.sh++;
        }
        if (roleElement.value == 'М') {
            count.m++;
        }
    }
    if (count.m != 2 || count.d != 1 || count.sh != 1) {
        alert('Укажите роли корректно')
        return false
    }
    if (document.getElementById('whoWins').querySelector('select').value == '') {
        alert('Укажите результат игры')
        return false
    }
    return true
}

function getElement(slot, query) {
    return document.getElementById('player' + slot).querySelector(query)
}
