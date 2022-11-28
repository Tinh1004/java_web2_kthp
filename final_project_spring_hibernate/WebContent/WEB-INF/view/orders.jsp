<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MyShop</title>
        <%@include file="./includes/header.jsp" %>
    </head>
    <style>
        a.btn-info{
            color: white!important;
        }
    </style>
    <body class="d-flex flex-column min-vh-100">
        <%@include file="./includes/navbar.jsp" %>
        <div class="container">
            <div class="container card-header my-4">All Orders</div>
            <div class="container">
                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col">image</th>
                            <th scope="col">Name</th>
                            <th scope="col">Price</th>
                            <th scope="col">Quantity</th>
                            <th scope="col">Cancel</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:choose>
                            <c:when test="${orders.size() > 0 && orders != null}">
                                <c:forEach var="order" items="${orders}">
	                                <c:url var="deleteMyOrderLink" value="/user/deleteMyOrder">
										<c:param name="productId" value="${order.receipt_id}"></c:param>
									</c:url>
                                    <tr>
                                        <td><img width="60" height="60" src="${order.product.image}"/></td>
                                        <td> <a href="#">${order.product.product_name}</a></td>
                                        <td>${order.product.price}</td>
                                        <td>${order.quantity}</th>
                                        <td><a class="btn btn-sm btn-danger text-white" href="${deleteMyOrderLink}">Cancel</a></td>
                                    </tr>
                                </c:forEach>
                            </c:when>
                            
                            <c:otherwise>
                                <tr>
                                    <td scope="col" colspan="5">Không có data ...</td>
                                </tr>
                            </c:otherwise>
                        </c:choose>

                    </tbody>
                </table>
            </div>

        </div>
        <%@include file="./includes/footer.jsp" %>
    </body>
    <!-- Bootstrap core JS-->
</html>
