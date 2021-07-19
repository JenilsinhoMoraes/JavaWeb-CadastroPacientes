/**
 * Validar campos obrigatorios
 * 
 * @author Jenilson de Moraes
 */

function validar() {
	let nome = frmnovocadastro.nome.value;
	let sus = frmnovocadastro.sus.value;
	let tipo = frmnovocadastro.tipo.value;
	let data_nasc = frmnovocadastro.data_nasc.value;
	let fone = frmnovocadastro.fone.value;
	
	if (nome === "") {
		alert('Preencha o campo Nome');
		frmContato.nome.focus();
		return false
	} else if (sus === "") {
		alert('Preencha o campo Número do SUS');
		frmContato.sus.focus();
		return false
	} else if (tipo === "") {
		alert('Preencha o campo Tipo');
		frmContato.tipo.focus();
		return false
	}else if (data_nasc === "") {
		alert('Preencha o campo Data de Nascimento');
		frmContato.data_nasc.focus();
		return false
	}else if (fone === "") {
		alert('Preencha o campo Fone');
		frmContato.fone.focus();
		return false
	}
	else {
		document.forms["frmnovocadastro"].submit();
	}
}