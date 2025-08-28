<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<div class="col-sm-6">
    <ul class="list-inline float-end">

        <c:choose>
 
            <c:when test="${sessionScope.account == null}">
                <li class="list-inline-item">
                    <a href="${pageContext.request.contextPath}/login">Login</a>
                </li>
                <li class="list-inline-item">|</li>
                <li class="list-inline-item">
                    <a href="${pageContext.request.contextPath}/register">Register</a>
                </li>
            </c:when>

            <%-- Nếu đã đăng nhập --%>
            <c:otherwise>
                <li class="list-inline-item">
                    <a href="${pageContext.request.contextPath}/member/myaccount">
                        ${sessionScope.account.fullName}
                    </a>
                </li>
                <li class="list-inline-item">|</li>
                <li class="list-inline-item">
                    <a href="${pageContext.request.contextPath}/logout">Logout</a>
                </li>
            </c:otherwise>
        </c:choose>

        <!-- Icon tìm kiếm -->
        <li class="list-inline-item">
            <i class="fa fa-search search-button"></i>
        </li>
    </ul>
</div>
