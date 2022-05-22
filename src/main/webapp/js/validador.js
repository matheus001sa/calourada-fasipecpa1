function validar() {
	let usuario = formulario.usuario.value;
	let senha = formulario.senha.value;
	
	if (usuario === "") {
		window.alert("[ERRO] Preencha o campo usuário");
		formulario.usuario.focus();
		return false;
	} else if (senha === "") {
		window.alert("[ERRO] Preencha o campo de senha de acesso");
		formulario.senha.focus();
		return false;
	} else {
		window.document.forms["formulario"].submit();
	}
}