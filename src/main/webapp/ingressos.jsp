<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Sistema Calourada ADS: Cadastro</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	
	<nav class="navbar navbar-expand-lg navbar-dark bg-success">
		<div class="container-fluid">
			<a href="https://www.instagram.com/atleticavirais/" target="_blank" rel="external" class="navbar-brand"><img src="img/logovirais.png" alt="Logo Atlética Virais" width="30" height="24" class="img-fluid"> Atlética Virais</a>
			<a href="main" class="navbar-brand">Histórico</a>
			<a href="report" class="navbar-brand">Gerar relatório PDF</a>
		</div>
	</nav>
	
	<section>
		<div class="container col-xs-12 col-sm-6 col-md-6 col-lg-3">
			<form name="formulario" action="insert" method="GET">
				<div class="input-group mb-3">
					<img src="img/logovirais.png" alt="Logo Atlética Virais" width="300" height="250" class="img-fluid">
					<input type="text" name="numeracao" placeholder="Número do ingresso" class="form-control-sm">
					<input type="button" value="Cadastrar" onclick="validarCadastro()" class="btn btn-outline-dark">
				</div>
			</form>
			<p class="text-danger">STATUS: <%out.print(request.getAttribute("resposta"));%></p>
		</div>
		<p class="text-center p-3 fs-6">ATENÇÃO:<br>O cadastro deve ser feito pelo número do ingresso marcado em vermelho.<br>Não permitido ingressos com numerações iguais.</p>
	</section>
	
	<footer class="bg-success">
		<div class="text-center p-3">
			<a href="https://www.instagram.com/atleticavirais/" target="_blank" rel="external" class="navbar-brand text-white">Sistema de cadastro de ingressos | Por: Atlética Virais <img src="img/logovirais.png" width="30" height="24" class="img-fluid"></a>
		</div>
	</footer>
	
	<script src="js/validarCadastro.js"></script>
	
</body>
</html>