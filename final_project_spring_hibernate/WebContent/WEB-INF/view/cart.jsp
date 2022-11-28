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

        <div class="breadcrumbs">
            <div class="container">
                <div class="row">
                    <div class="col">
                        <p class="bread"><span><a href="index.html">Home</a></span> / <span>Shopping Cart</span></p>
                    </div>
                </div>
            </div>
        </div>
        <div class="colorlib-product">
            <div class="container">
                <div class="row row-pb-lg">
                    <div class="col-md-12">
                        <div class="product-name d-flex">
                            <div class="one-forth text-left px-4">
                                <span>Product Details</span>
                            </div>
                            <div class="one-eight text-center">
                                <span>Price</span>
                            </div>
                            <div class="one-forth text-center">
                                <span>Quantity</span>
                            </div>
                            <div class="one-eight text-center">
                                <span>Total</span>
                            </div>
                            <div class="one-eight text-center px-4">
                                <span>Remove</span>
                            </div>
                        </div>
                        <c:choose>
                            <c:when test="${carts != null && carts.size() > 0}">
                                <c:forEach var="cart" items="${carts}">
                                	<c:url var="removeCartByIdProduct" value="/removeCart">
										<c:param name="productId" value="${cart.product.product_id}"></c:param>
									</c:url>
	                                <c:url var="buyProduct" value="/buyProduct">
											<c:param name="productId" value="${cart.product.product_id}"></c:param>
									</c:url>
									
									
                                    <div class="product-cart d-flex">
                                        <div class="one-forth">
                                            <div class="product-img" style="background-image: url('${cart.product.image}');">
                                            </div>
                                            <div class="display-tc">
                                                <h3> <a href="#">${cart.product.product_name}</a></h3>
                                            </div>
                                        </div>
                                        <div class="one-eight text-center">
                                            <div class="display-tc">
                                                <span class="price">${cart.product.price * cart.quantity}₫</span>
                                            </div>
                                        </div>
                                        <div class="one-forth text-center">
                                            <div class="display-tc">
                                                <form action="buyProduct" method="post" class="form-inline ">
                                                    <input type="hidden" name="productId" value="${cart.product.product_id}" class="form-input"/>
                                                    <div>
                                                        <a class="btn" href="<%=request.getContextPath()%>/quantityIncDec?action=dec&productId=${cart.product.product_id}">-</a>
                                                        <input type="text" name="quantity" class="form-control input-number text-center w-25" value="${cart.quantity}" readonly>
                                                        <a class="btn" href="<%=request.getContextPath()%>/quantityIncDec?action=inc&productId=${cart.product.product_id}">+</a>
                                                    </div>
                                                    <button type="submit" class="btn btn-primary btn-sm ml-2" >Buy</button>
                                                </form>
                                            </div>
                                        </div>
                                        <div class="one-eight text-center">
                                            <div class="display-tc">
                                                <span class="price">${cart.product.price}₫</span>
                                            </div>
                                        </div>
                                        <div class="one-eight text-center">
                                            <div class="display-tc">
                                                <a href="${removeCartByIdProduct}" class="closed"></a>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                            </c:when>
                            <c:otherwise>

                                <div class="product-cart d-flex">
                                    <p>Không có data ...</p>                            
                                </div>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
                <div class="row row-pb-lg">
                    <div class="col-md-12">
                        <div class="total-wrap">
                            <div class="row">
                                <div class="col-sm-4 text-center">

                                    <div class="total">
                                        <h4>Hoá đơn:</h4>
                                        <div class="sub">
                                            <p><span>Subtotal:</span> <span>${String.format("%.1f", TOTAL)} ₫</span></p>
                                            <p><span>Delivery:</span> <span>0₫</span></p>
                                            <p><span>Discount:</span> <span>0₫</span></p>
                                        </div>
                                        <div class="grand-total">
                                            <p><span><strong>Total:</strong></span> <span>${String.format("%.1f", TOTAL)} ₫</span></p>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-sm-8">
                                    <form action="#">
                                        <div class="row form-group">
                                            <div class="col-sm-3">
                                                <a class="btn btn-primary text-white" href="<%=request.getContextPath()%>/checkout">Check out</a>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <%@include file="./includes/footer.jsp" %>
    </body>
    <!-- Bootstrap core JS-->
</html>
