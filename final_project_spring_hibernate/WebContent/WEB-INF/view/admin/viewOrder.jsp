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
  <style>
    .card-item {
      width: 650px;
      height: 400px;
      margin-bottom: 30px;
      display: flex;
      justify-content: space-between;
    }
    .card-item .card-image {
      width: 49%;
      height: 100%;
    }
    .card-item .description {
      width: 49%;
      height: 100%;
    }
  </style>
  <body>
    <input type="checkbox" id="menu-toggle" />
    
<%@include file="./includes/left_admin.jsp" %>
    <div class="main-content">
   
<%@include file="./includes/navbar_admin.jsp" %>
      <main>
        <div class="page-header">
          <h1>Update Product</h1>
          <small>Admin / Update Product</small>
        </div>

          <div class="records table-responsive" >
            <div class="container_form">
             
              <div class="card-item" style="margin-bottom: 100px">
                <div class="card-image">
                  <img src="${order.product.image}" alt="Image" class="image">
                </div>
                <div class="description">
                  <h3 id="name">${order.product.product_name}</h3>
                  <p>Discription:</p>
                  <p>Price: <span id="price">${order.product.price} </span>đ </p>
                  <p>User buy: ${order.user.fullname}</p>
                </div>
              </div>
            
            </div>

          </div>
       
       
        </div>
      </main>
    </div>
  </body>

</html>
