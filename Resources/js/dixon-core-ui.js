function addValueField() {
	$("#chemis-dixon-values-list").append(
		$('<li />').addClass("pure-control-group").append(
			$("<div/>").append(
				$('<input />').addClass("chemis-dixon-value").attr("type", "text").attr("placeholder", "0,000")
			)
		).append(
			$("<div/>").append(
				$("<button />").addClass("pure-button").text("X").attr("onclick", "removeValueField(this)")
			)
		)
	);
	var valuesCount = $(".chemis-dixon-value").length;
	$("#chemis-dixon-values-count").text("Valores: " + valuesCount);
}

function removeValueField(self) {
	var valuesCount = $(".chemis-dixon-value").length;
	if (valuesCount > 3) {
		$(self).addClass("chemis-dixon-value-rem");
		$(self).removeClass("chemis-dixon-value");
		$(self).parent().parent().fadeOut(300, function () {
			$(this).remove();
		});
		$("#chemis-dixon-values-count").text("Values: " + (valuesCount - 1));
	}
}

function getAllFields() {
	return $("#chemis-dixon-values-list .chemis-dixon-value");
}

function clearAllFields() {
	$("#chemis-dixon-values-list").html("");
	for (i = 0; i < 3; i++) {
		addValueField();
	}
}

function displayResults(dixon, results) {
	var per = results.percent;
	if (dixon !== null) {
		$("#result-" + per).html("Aprovado");
		//$("#le-" + per).html(results.lowerEnd);
		//$("#ue-" + per).html(results.upperEnd);
		//$("#n-" + per).html(dixon.getN());
		//$("#q-" + per).html(dixonConstants[per + "_" + dixon.getN()]);
		var le = new countUp("le-" + per, 0, results.lowerEnd, 4, 0.5, options);
		var ue = new countUp("ue-" + per, 0, results.upperEnd, 4, 0.5, options);
		var n = new countUp("n-" + per, 0, dixon.getN(), 0, 0.5, options);
		var q = new countUp("q-" + per, 0, dixonConstants[per + "_" + dixon.getN()], 3, 0.5, options);
		le.start();
		ue.start();
		n.start();
		q.start();
		if (dixon.removed.length === 0) {
			$("#rm-" + per).html($("<li />").text("---"));
		} else {
			$("#rm-" + per).html("");
		}
		$.each(dixon.removed, function () {
			$("#rm-" + per).append($("<li />").text(this));
		});
	} else {
		$("#result-" + per).html("Reprovado");
		$("#le-" + per).html("---");
		$("#ue-" + per).html("---");
		$("#n-" + per).html("---");
		$("#q-" + per).html("---");
		$("#rm-" + per).html($("<li />").text("---"));
	}
}

//Show selected dixon history register on result panel
function displayRegister(id){
	var register=dixonHistory.getRegisterById(id);
	displayResults(register.rDixon95,register.rResult95);
	displayResults(register.rDixon99,register.rResult99);
	$("#chemis-dixon-results").addClass("dixon-history");
}

function valuesToDixon() {
	var values = getAllFields();
	var dixon = new Dixon();
	$.each(values, function (index) {
		var value = $(this).val();
		value = value.replace(",", ".");
		value = value.trim();
		value = parseFloat(value);
		if (validateField(this, value, index, dixon)) {
			console.log("Value added:" + value);
			$(this).removeClass("chemis-dixon-value-invalid");
			$(this).val(value);
			dixon.addValue(value);
		}
	});

	return dixon;
}

function validateField(field, value, index, dixon) {
	if ($(field).val() === "") {
		removeValueField(field);
		console.log("Index #" + (index + 1) + " removed - empty value");
		return false;
	} else if (isNaN(value)) {
		$(field).addClass("chemis-dixon-value-invalid");
		console.log("Index #" + (index + 1) + " alert - Not a Number");
	} else if (dixon.values.indexOf(parseFloat(value)) != -1) {
		removeValueField(field);
		console.log("Index #" + (index + 1) + " removed - duplicated value");
		return false;
	} else {
		return true;
	}
}

function calcDixon() {
	var dixon95 = valuesToDixon();
	var dixon99 = valuesToDixon();
	var register = new DixonRegister("Resultado " + getCurrentDate() + " " + getCurrentTime(), new Date());
	register.dixon95(dixon95);
	register.dixon99(dixon99);
	try {
		var result95 = DixonControl.calc(dixon95, 95);
		register.result95(result95); /*salva registro95*/
		displayResults(dixon95, result95);
	} catch (err) {
		console.log(err.message);
		displayResults(null, JSON.parse('{"percent":95}'));
	}

	try {
		var result99 = DixonControl.calc(dixon99, 99);
		register.result99(result99); /*salva registro99*/
		displayResults(dixon99, result99);
	} catch (err) {
		console.log(err.message);
		displayResults(null, JSON.parse('{"percent":99}'));
	}
	dixonHistory.addRegister(register);
	addHistoryRegister(register);
}

function fieldMoveUp() {
	if (document.activeElement !== null) {
		var allFields = getAllFields();
		var index = allFields.index(document.activeElement);
		if (index != -1 && index !== 0) {
			allFields[index - 1].focus();
			console.log("Move up");
		} else if (index === 0) {
			getAllFields()[0].focus();
		}
	}
}

function fieldMoveDown() {
	if (document.activeElement !== null) {
		var allFields = getAllFields();
		var index = allFields.index(document.activeElement);
		if (index != -1 && index != allFields.length - 1) {
			allFields[index + 1].focus();
			console.log("Move down");
		} else if (index == allFields.length - 1) {
			addValueField();
			getAllFields()[index + 1].focus();
		}
	}
}

function removeEmptyField() {
	var active = document.activeElement;
	if ($(active).val() === "" && getAllFields().length > 3) {
		if (getAllFields().index(active) === 0) {
			fieldMoveDown();
			removeValueField(active);
		} else {
			fieldMoveUp();
			removeValueField(active);
		}
	} else if ($(active).val() === "") {
		fieldMoveUp();
	}
}

function addHistoryRegister(register) {
	var list = $("#dixon-history-list");
	var id="reg-" + register.date().getTime();
	var item = $("<li />").html($("<a />").attr("id", id).attr("href", "#").attr("title", "Registro").attr("onclick","displayRegister('"+id+"')").text(register.name()));
	$(list).append($(item));
	console.log("Registro adicionado");
}

var options = {  
	useEasing: true,
	useGrouping: true,
	separator: ',',
	decimal: '.'
};

var dixonHistory = new DixonHistory();
var tempRegister = null;
clearAllFields();