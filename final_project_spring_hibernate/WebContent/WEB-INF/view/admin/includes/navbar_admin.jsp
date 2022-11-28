<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<header>
        <div class="header-content">
          <label for="menu-toggle">
            <span class="las la-bars"></span>
          </label>

          <div class="header-menu">
            <label for="">
              <span class="las la-search"></span>
            </label>

            <div class="notify-icon">
              <span class="las la-envelope"></span>
              <span class="notify">4</span>
            </div>

            <div class="notify-icon">
              <span class="las la-bell"></span>
              <span class="notify">3</span>
            </div>

            <div class="user">
              <div
                class="bg-img"
                style="background-image: url(${pageContext.request.contextPath}/resources/img/1.jpeg)"
              ></div>

				<a href="<%=request.getContextPath()%>/auth/logout">
				 	<span class="las la-power-off"></span>
              		<span>Logout</span>
				</a>
             
            </div>
          </div>
        </div>
      </header>