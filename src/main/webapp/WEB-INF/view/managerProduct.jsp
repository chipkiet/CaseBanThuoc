<%--
  Created by IntelliJ IDEA.
  User: hoccu
  Date: 8/16/2024
  Time: 4:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>CRUD</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/mproduct.css">
</head>
<body>
<main class="container">
    <!-- Form thêm sản phẩm mới -->
    <section class="product-form">
        <h2>Thêm sản phẩm mới</h2>
        <form action="${pageContext.request.contextPath}/addProduct" method="post">
            <input type="text" name="name" placeholder="Tên sản phẩm" required>
            <input type="text" name="image" placeholder="URL hình ảnh" required>
            <input type="number" name="price" placeholder="Giá sản phẩm" required>
            <input type="text" name="category" placeholder="Loại sản phẩm" required>
            <textarea name="description" placeholder="Mô tả sản phẩm"></textarea>
            <button type="submit" class="btn btn-primary">Thêm sản phẩm</button>
        </form>
    </section>

    <!-- Bảng hiển thị danh sách sản phẩm -->
    <section class="product-list">
        <h2>Danh sách sản phẩm</h2>
        <table>
            <thead>
            <tr>
                <th>ID</th>
                <th>Tên sản phẩm</th>
                <th>Hình ảnh</th>
                <th>Giá</th>
                <th>Loại sản phẩm</th>
                <th>Mô tả</th>
                <th>Hành động</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="o" items="${products}">
                <tr>
                    <td>${o.id}</td>
                    <td>${o.name}</td>
                    <td><img src="${o.image}" alt="${o.name}"></td>
                    <td>${o.price}</td>
                    <td>${o.category}</td>
                    <td>${o.description}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/editProduct?id=${o.id}" class="btn btn-edit">Sửa</a>
                        <a href="${pageContext.request.contextPath}/deleteProduct?id=${o.id}" class="btn btn-delete">Xóa</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </section>
</main>

</body>
</html>
