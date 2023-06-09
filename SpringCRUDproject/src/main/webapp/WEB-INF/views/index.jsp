<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="./bootcssjs.jsp"%>


</head>
<body>
	<div class="container mt-3">
		<h2>All Listed Products</h2>
		<table class="table">
			<thead>
				<tr>
					<th scope="col">Product ID</th>
					<th scope="col">Name</th>
					<th scope="col">Description</th>
					<th scope="col">Price</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${products }" var="p">
					<tr>
						<th scope="row">${p.id }</th>
						<td>${p.name }</td>
						<td>${p.description }</td>
						<td>&#x20B9; ${p.price }</td>
						<td><a href="delete/${p.id }" style="margin-right: 20px;"><i
								class="fa-sharp fa-solid fa-trash"></i></a> <a
							href="update/${p.id }"><i class="fa-regular fa-pen-to-square"></i></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="container text-center">
			<a href="add-product" class="btn btn-primary">Add Product</a>
		</div>
	</div>
</body>
</html>