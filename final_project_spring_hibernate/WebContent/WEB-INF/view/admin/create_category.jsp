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
          <h1>Create Category</h1>
          <small>Admin /Create Category</small>
        </div>

          <div class="records table-responsive">
            <div class="container_form">
              <div class="form-create_product">
              <form:form cssClass="form" action="postCreateCategory" modelAttribute="categories" method="POST">
					
				<div class="form-group">
                    <label for="category">Category Name</label>
                  
                    <form:input cssClass="form-control" path="category_name" placeholder="category" />
                  </div>
                  
				 <input type="submit" value="Submit"/>
				</form:form>
               
              </div>
            </div>
          </div>
          <div class="records table-responsive">
              
            <div>
              <table width="100%">
                <thead>
                
                  <tr>
                    <th>#</th>

                    <th><span class="las la-sort"></span> Name</th>
                    <th><span class="las la-sort"></span> Discription</th>
                    <th><span class="las la-sort"></span> ACTIONS</th>
                  </tr>
               
                </thead>
                <tbody>
                <c:forEach var="category" items="${listCategory}">
                	<c:url var="deleteLink" value="/ad/deleteCategory">
						<c:param name="category_id" value="${category.category_id}"></c:param>
					</c:url>
                	<tr>
                    <td>#${category.category_id}</td>
                    <td>${category.category_name}</td>
                    <td>....</td>
                    <td>
                      <div class="actions">
                      	 <a href="${deleteLink}" style="color:red;" onclick="if(!confirm('Are you sure to detele?')) return false; "><span class="las la-trash" ></span></a>
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
