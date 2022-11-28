<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
          <h1>Product</h1>
          <small>Admin / Product</small>
        </div>

        <div class="page-content">
          <div class="records table-responsive">
            <div class="record-header">
              <div class="add">
                <span>Entries</span>
                <select name="" id="">
                  <option value="">ID</option>
                </select>
                
              </div>

              <div class="browse">
                <input
                  type="search"
                  placeholder="Search"
                  class="record-search"
                />
                <select name="" id="">
                  <option value="">Status</option>
                </select>
              </div>
            </div>

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
                 <c:forEach var="product" items="${listProduct}">
                  	<c:url var="updateLink" value="/ad/updateProduct">
						<c:param name="product_id" value="${product.product_id}"></c:param>
					</c:url>
					
					<c:url var="deleteLink" value="/ad/deleteProduct">
						<c:param name="product_id" value="${product.product_id}"></c:param>
					</c:url>
					
                 	<tr>
                    <td>#${product.product_id}</td>
                    <td>
                      <img
                        src="${product.image}"
                        width="60"
                        height="60"
                        alt=""
                      />
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
      </main>
    </div>
  </body>
</html>
