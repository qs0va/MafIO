function onIdButtonClick(slot) {
    playerElement = document.getElementById('player' + slot)
    nicknameElement = playerElement.querySelector('.nickname').querySelector('input')
    buttonElement = playerElement.querySelector('.idButton')
    idslotElement = playerElement.querySelector('.idHidden')

    if (nicknameElement.disabled == false) {
        id = getIdFromServer(nicknameElement.value);
        if (id != 0) {
            nicknameElement.style.border = 'none';
            nicknameElement.disabled = true;
            buttonElement.style.backgroundColor = 'green';
        }
        else {
            alert('Никнейм не найден')
        }
        idslotElement.innerHTML = id
    }
    else {
        nicknameElement.style.border = 'solid white 1px';
        nicknameElement.disabled = false;
        buttonElement.style.backgroundColor = 'var(--primary-color)';
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

        if(checkForm(idslotElement.innerHTML, roleElement.value, ratingElement.value)) {
            out[i] = makePlayerGame(idslotElement.innerHTML, slot, roleElement.value,ratingElement.value)
        }
        else {
            return
        }
    }

    alert(JSON.stringify(out))
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
    return (nickname.length == 0) ? 0 : 1;
}

function checkForm(playerId, role, rating) {
    alert(playerId == 0)
    return false
}
