<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <div class="sidebar">
      <div class="side-header">
        <h3>M<span>odern</span></h3>
      </div>

      <div class="side-content">
  
        <div class="side-menu">
          <ul>
            <li>
              <a href="<%=request.getContextPath()%>/ad/showAdmin" class="active">
                <span class="las la-home"></span>
                <small>Dashboard</small>
              </a>
            </li>
            <li>
              <a href="<%=request.getContextPath()%>/ad/showUsers">
                <span class="las la-user-alt"></span>
                <small>Users</small>
              </a>
            </li>
            <li>
              <a href="<%=request.getContextPath()%>/ad/showProducts">
                <span class="las la-envelope"></span>
                <small>Products</small>
              </a>
            </li>
            <li>
              <a href="<%=request.getContextPath()%>/ad/showProductCreatePage">
                <span class="las la-clipboard-list"></span>
                <small>Create Product</small>
              </a>
            </li>
            <li>
              <a href="<%=request.getContextPath()%>/ad/showCategoryCreatePage">
                <span class="las la-shopping-cart"></span>
                <small>Create category</small>
              </a>
            </li>
            
          </ul>
        </div>
      </div>
    </div>
