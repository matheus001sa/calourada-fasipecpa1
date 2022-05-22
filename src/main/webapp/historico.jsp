<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="modelo.JavaBeans"%>
<%@ page import="java.util.ArrayList"%>
<%
	@SuppressWarnings ("unchecked")
	ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("ordenarBilhetes");
%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Sistema Calourada ADS: Histórico</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

	<section>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Número do Ingresso</th>
					<th>Data/Hora</th>
				</tr>
			</thead>
			<tbody>
				<%
				for (int i = 0; i < lista.size(); i++) {
				%>
				<tr>
					<td><%=lista.get(i).getNumeracao()%></td>
					<td><%=lista.get(i).getDatahora()%></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
	</section>

</body>
</html>