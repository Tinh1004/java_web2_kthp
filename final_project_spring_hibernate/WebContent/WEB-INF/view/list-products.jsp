
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<%@include file="./includes/header.jsp" %>
</head>

<body>

<div id="page">
<%@include file="./includes/navbar.jsp" %>

<div class="colorlib-product">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-8 offset-sm-2 text-center colorlib-heading">
                            
	                         <c:choose>
	                            <c:when test="${auth == null}">
	                                <h2>Best Sellers</h2>
	                            </c:when>
	                            <c:otherwise>
									<h2>Welcome -  ${auth.fullname}</h2>
	                            </c:otherwise>
	                        </c:choose>
                        </div>
                    </div>
                    
                    <div style="margin-bottom: 30px; display: flex;flex-wrap: wrap; border-bottom: 1px solid grey">
                    <a href="<%=request.getContextPath()%>/home" style="padding: 0.3rem 1rem; margin-right: 10px; border-right: 1px solid grey">Tất cả</a>
                    <c:forEach var="category" items="${listCategories}">
                    	<c:url var="linkHome" value="/home">
								<c:param name="category_id" value="${category.category_id}"></c:param>
						</c:url>
                    	<a href="${linkHome}" style="padding: 0.3rem 1rem; margin-right: 5px;border-right: 1px solid grey">${category.category_name}</a>
                    </c:forEach>
                    	
                    </div>
                    
                    <div class="row row-pb-md">
                    	
                    	<c:choose>
	                            <c:when test="${products.size() == 0}">
	                                <p style="padding: 2rem;">Hiện chưa có sản phẩm nào...</p>
	                            </c:when>
	                    </c:choose>
                    	
                        <c:forEach var="tempProduct" items="${products}">
	                        <c:url var="detailLink" value="/detail">
								<c:param name="productId" value="${tempProduct.product_id}"></c:param>
							</c:url>
							<c:url var="addCardLink" value="/addCart">
								<c:param name="productId" value="${tempProduct.product_id}"></c:param>
							</c:url>
	                        
                            <div class="col-lg-3 mb-4 text-center">
                                <div class="product-entry border">
                                    <a href="#" class="prod-img">
                                        <img src=${tempProduct.image} class="img-fluid" alt="Free html5 bootstrap 4 template">
                                    </a>
                                    <div class="desc">
                                        <h2><a href="#">${tempProduct.product_name}</a></h2>
                                        <span class="price">${tempProduct.price} đ</span>
                                    </div>
                                    <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                        <div class="text-center">
                                            <a class="btn btn-outline-dark mt-auto" href="${addCardLink}">Add to cart</a>
                                            <a class="btn btn-outline-secondary mt-auto" href="${detailLink}">Detail</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                        
                    </div>
                    <div class="row">
                            <div class="col-md-12 text-center">
                                <p><a href="#" class="btn btn-primary btn-lg">Shop All Products</a></p>
                            </div>
                        </div>
                </div>

            </div>

    <%@include file="./includes/footer.jsp" %>
</div>
	
</body>
</html>