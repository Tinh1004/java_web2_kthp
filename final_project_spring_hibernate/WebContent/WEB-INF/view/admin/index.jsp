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
          <h1>Dashboard</h1>
          <small>Admin / Dashboard</small>
         
        </div>

        <div class="page-content">
          <div class="analytics">
            <div class="card">
              <div class="card-head">
                <h2>${count_users}</h2>
                <span class="las la-user-friends"></span>
              </div>
              <div class="card-progress">
                <small>Users</small>
                <div class="card-indicator">
                  <div class="indicator one" style="width: 60%"></div>
                </div>
              </div>
            </div>

            <div class="card">
              <div class="card-head">
                <h2>${count_products}</h2>
                <span class="las la-eye"></span>
              </div>
              <div class="card-progress">
                <small>Products</small>
                <div class="card-indicator">
                  <div class="indicator two" style="width: 80%"></div>
                </div>
              </div>
            </div>

            <div class="card">
              <div class="card-head">
                <h2>${All_orders.size()}</h2>
                <span class="las la-shopping-cart"></span>
              </div>
              <div class="card-progress">
                <small>Monthly revenue growth (Order)</small>
                <div class="card-indicator">
                  <div class="indicator three" style="width: 65%"></div>
                </div>
              </div>
            </div>

            <div class="card">
              <div class="card-head">
                <h2>999,999</h2>
                <span class="las la-envelope"></span>
              </div>
              <div class="card-progress">
                <small>New E-mails received</small>
                <div class="card-indicator">
                  <div class="indicator four" style="width: 90%"></div>
                </div>
              </div>
            </div>
          </div>

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
                    <th><span class="las la-sort"></span> Product</th>
                    <th><span class="las la-sort"></span> price</th>
                    <th><span class="las la-sort"></span> quantily</th>
                    <th><span class="las la-sort"></span> user</th>
                    <th><span class="las la-sort"></span> ACTIONS</th>
                  </tr>
                </thead>
                <tbody>
                
                <c:forEach var="order" items="${All_orders}">
                	<c:url var="viewLinkOrder" value="/ad/viewOrder">
						<c:param name="receipt_id" value="${order.receipt_id}"></c:param>
					</c:url>
	                 <tr>
	                    <td>#${order.receipt_id}</td>
	                    <td>
	                      <div class="client">
	                        <img
	                          src="${order.product.image}"
	                          width="60"
	                          height="60"
	                          alt=""
	                        />
	                        <div class="client-info">
	                          <h4>${order.product.product_name}</h4>
	                          <small>....</small>
	                        </div>
	                      </div>
	                    </td>
	                    <td>${order.product.price}</td>
	                    <td>${order.quantity}</td>
	                    <td>${order.user.fullname}</td>
	                    <td>
	                      <div class="actions">
	                        <span class=""></span>
	                        <a href="${viewLinkOrder}"><span class="las la-eye"></span></a>
	                        <span class=""></span>
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

