<%--
  Created by IntelliJ IDEA.
  User: zmax5
  Date: 22.12.2021
  Time: 19:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Характеристики</title>
    <jsp:include page="/res"/>
    <script src="resources/js/properties_list.js?ver=3"></script>
</head>
<body>

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
                <li class="active"><a href="${pageContext.request.contextPath}/PropertiesList">Характеристики</a></li>
            </ul>
        </div>
    </nav>
</div>

<div class="container" style="margin-top: 50px">
    <div class="col-md-20 col-md-offset-1">
        <div class="page-header"><h1>Характеристики</h1></div>
        <div class="panel panel-default" id="properties-list">
            <div class="panel-body" id="property-list-cont"></div>
        </div>

    </div>

    <div id="dialog-button" class="action-button" style="right:140px; position: fixed;">
        <i class="glyphicon glyphicon-plus" title="Добавить"></i>
    </div>
</div>

</body>
</html>
