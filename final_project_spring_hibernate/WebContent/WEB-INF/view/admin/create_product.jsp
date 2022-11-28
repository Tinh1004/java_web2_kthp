<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta
      name="viewport"
      content="width=device-width,initial-scale=1,maximum-scale=1"
    />
    <title>Modern Admin Dashboard</title>
    <%@include file="./includes/header_admin.jsp" %>
  </head>
  <body>
    <input type="checkbox" id="menu-toggle" />
    
<%@include file="./includes/left_admin.jsp" %>
    <div class="main-content">
   
<%@include file="./includes/navbar_admin.jsp" %>
      <main>
        <div class="page-header">
          <h1>Create Product</h1>
          <small>Admin / Create Product</small>
        </div>

          <div class="records table-responsive">
            <div class="container_form">
              <div class="form-create_product">
      
              	<form class="form" action="postCreateProduct" method="POST">
                  <div class="form-group">
                    <label for="productName">Product Name</label>
                    <input type="text" name="productName" class="productNameInput" placeholder="Product Name" required/>
                  </div>
                  <div class="form-group">
                    <label for="price">Price</label>
                    <input type="text"  name="price" class="priceInput" placeholder="Price" required>
                  </div>
                  <div class="form-group">
                    <label for="image">Url Image</label>
                    <input type="text" name="image" class="imageInput" placeholder="Url Image" required>
                  </div>
                  <div class="form-group">
                    <label for="category">Category</label>
                    <select name="categoryId" class="category">
                    		<option value="1" selected>--- Choose category ---</option>
                    	<c:forEach var="category" items="${listCategory}">
                    	
                    		<option value="${category.category_id}" >${category.category_name}</option>
                    	</c:forEach>
                    </select>
                  </div>
                  <input type="submit" value="Submit">
                </form>
              </div>
              
              
              <div class="card-item">
                <div class="card-image">
                  <img src="https://cdn4.iconfinder.com/data/icons/ionicons/512/icon-image-512.png" alt="Image" class="image">
                </div>
                <div class="description">
                  <h3 id="name">Product Name</h3>
                  <p>Discription:</p>
                  <p>Price: <span id="price">... </span>đ </p>
                </div>
              </div>
            </div>
            <div class="records table-responsive">
              
              <div>
                <table width="100%">
                  <thead>
                    <tr>
                      <th>#</th>
                      <th><span class="las la-sort"></span> Image</th>
                      <th><span class="las la-sort"></span> Name</th>
                      <th><span class="las la-sort"></span> Price</th>
                      <th><span class="las la-sort"></span> ACTIONS</th>
                    </tr>
                  </thead>
                  <tbody>
                  <c:forEach var="product" items="${listProducts}">
                  <c:url var="updateLink" value="/ad/updateProduct">
						<c:param name="product_id" value="${product.product_id}"></c:param>
					</c:url>
					
					<c:url var="deleteLink" value="/ad/deleteProduct">
						<c:param name="product_id" value="${product.product_id}"></c:param>
					</c:url>
                  <tr>
                      <td>#${product.product_id}</td>
                      <td>
                        <img src="${product.image}" width="60" height="60" alt="">
                      </td>
                      <td>${product.product_name}</td>
                      <td>${product.price} đ</td>
                      <td>
                        <div class="actions">
                          <a href="${updateLink}">
                      		<span class="lab la-telegram-plane"></span>
                      	</a>
                      	<a href="${deleteLink}" style="color: red;" onclick="if(!confirm('Are you sure to detele?')) return false; ">
                      		<span class="las la-trash"></span>
                      	</a>
                          
                        </div>
                      </td>
                    </tr>
                    
                  </c:forEach>
                    
                  </tbody>
                </table>
              </div>
            </div>
          </div>
        </div>
      </main>
    </div>
  </body>
  <script>
    const inputProductName = document.querySelector("input.productNameInput");
    const inputPrice = document.querySelector("input.priceInput");
    const inputImage = document.querySelector("input.imageInput");

    const name = document.querySelector("#name");
    const price = document.querySelector("span#price");
    const image = document.querySelector(".image");

    console.log(price)


    inputImage.addEventListener("change",(e)=>{
      image.src = e.target.value;
    });

    inputProductName.addEventListener("change",(e)=>{
      name.innerHTML = e.target.value;
    });

    inputPrice.addEventListener("change",(e)=>{
      price.innerHTML = e.target.value;
    });


  </script>
</html>
