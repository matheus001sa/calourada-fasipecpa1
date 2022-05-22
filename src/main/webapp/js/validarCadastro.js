function validarCadastro() {
	let numeracao = formulario.numeracao.value;
	
	if (numeracao === "") {
		window.alert("[ERRO] Preencha o campo número do ingresso");
		formulario.numeracao.focus();
		return false;
	} else {
		window.document.forms["formulario"].submit();
	}
}