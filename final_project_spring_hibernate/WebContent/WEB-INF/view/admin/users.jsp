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
          <small>Admin / User</small>
        </div>

        <div class="page-content">
          <div class="records table-responsive">
            <div class="record-header">
              <div class="add">
                <span>Entries</span>
                <select name="" id="">
                  <option value="">ID</option>
                </select>
                <button>Add product</button>
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
                    <th><span class="las la-sort"></span> User</th>
                    <th><span class="las la-sort"></span> User Name</th>
                    <th><span class="las la-sort"></span> Role</th>
                    <th><span class="las la-sort"></span> ACTIONS</th>
                  </tr>
                </thead>
                <tbody>
                <c:forEach var="user" items="${listUser}">
                	 <tr>
	                    <td>#${user.user_id}</td>
	                    <td>
	                      <div class="client">
	                        <div
	                          class="client-img bg-img"
	                          style="background-image: url(${pageContext.request.contextPath}/resources/img/1.jpeg)"
	                        ></div>
	                        <div class="client-info">
	                          <h4>${user.fullname}</h4>
	                          <small>....</small>
	                        </div>
	                      </div>
	                    </td>
	                    <td>${user.username}</td>
	                    <td>${user.isUser_role() == true ? "admin" : "user"}</td>
	                    <td>
	                      <div class="actions">
	                        <span class="lab la-telegram-plane"></span>
	                        <span class="las la-eye"></span>
	                        <span class="las la-ellipsis-v"></span>
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
