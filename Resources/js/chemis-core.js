function Chemis() {};

Chemis.clone = function (object) {
    var strObj = JSON.stringify(object);
    return JSON.parse(strObj);
};