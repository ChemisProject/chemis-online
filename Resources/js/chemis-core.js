document.onkeydown = dixonEvents;

function dixonEvents(e) {
    if (!e) var e = window.event;
    (e.keyCode) ? key = e.keyCode : key.which;
    switch (key) {
    case 37:
        console.log("Esquerda");
        break;
    case 38:
        fieldMoveUp();
        break;
    case 39:
        console.log("Direita");
        break;
    case 40:
        fieldMoveDown();
        break;
    case 8: removeEmptyField();
        break;
    }
}