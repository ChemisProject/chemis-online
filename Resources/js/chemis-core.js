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

var menuOpened=false;

function openMenu(){
    var menu=$("#chemis-menu-bar");
    if(menuOpened){
        console.log("Fechou");
        $(menu).animate({left:"-15em"},200);
        menuOpened=false;
    }else{
        $(menu).css("left","-15em");
        console.log("Abriu");
        $(menu).animate({left:0},200);
        menuOpened=true;
    }
}

function getCurrentDate(){
    return formatDate(new Date());
}

function getCurrentTime(){
    return formatTime(new Date());
}

function formatTime(date){
    var hour=date.getHours();
    var min=date.getMinutes();
    var sec=date.getSeconds();
    if(hour<10){
        hour="0"+hour;
    }
    if(min<10){
        min="0"+min;
    }
    if(sec<10){
        sec="0"+sec;
    }
    return ""+hour+":"+min+":"+sec;
}

function formatDate(date){
    var dia=date.getDate();
    var mes=date.getMonth()+1;
    if(dia<10){
        dia="0"+dia;
    }
    if(mes<10){
        mes="0"+mes;
    }
    return ""+dia+"/"+mes+"/"+date.getFullYear();
}

function daysInMonth(month,year) {
    return new Date(year, month, 0).getDate();
}