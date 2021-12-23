<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="row">
    <nav class="navbar navbar-default navbar-fixed-top" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <img src="resources/img/cart128.png" alt="Cart" class="site-logo">
                <a class="navbar-brand" href="${pageContext.request.contextPath}/ProductsList">Не-каталог</a>
            </div>
            <ul class="nav navbar-nav">
                <li><a href="${pageContext.request.contextPath}/ProductsList">Товары</a></li>
                <li><a href="${pageContext.request.contextPath}/CategoriesList">Категории</a></li>
                <li><a href="${pageContext.request.contextPath}/VendorsList">Производители</a></li>
                <li><a href="${pageContext.request.contextPath}/PropertiesList">Характеристики</a></li>
            </ul>
        </div>
    </nav>
</div>