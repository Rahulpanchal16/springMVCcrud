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
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<form action="${pageContext.request.contextPath }/handleproduct" method="post">
					<h1>Edit your product</h1>
					<div class="form-group">
						<label for="name">Product Name</label> <input type="text"
							class="form-control" id="name" name="name"
							placeholder="Enter product name" value="${prod.name }">
					</div>
					<div class="form-group">
						<label for="description">Product Description</label>
						<textarea class="form-control" id="description" name="description"
							rows="5" placeholder="Enter product description">${prod.description }</textarea>
					</div>
					<div class="form-group">
						<label for="price">Product Price</label> <input type="text"
							class="form-control" id="price" name="price"
							placeholder="Enter product price" value="${prod.price }">
					</div>
					<div class="container text-center mt-3">
						<a class="btn btn-primary"
							href="${pageContext.request.contextPath }/">Back</a>
						<button type="submit" class="btn btn-primary">Update
							Product</button>
					</div>
				</form>
			</div>
		</div>
	</div>

</body>
</html>