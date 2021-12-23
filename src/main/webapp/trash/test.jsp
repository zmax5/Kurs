<%--
  Created by IntelliJ IDEA.
  User: zmax5
  Date: 21.12.2021
  Time: 21:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Test :D</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../resources/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="../resources/css/styles.css">
    <link rel="stylesheet" href="../resources/bootstrap/css/bootstrap-theme.min.css">
    <script src="${pageContext.request.contextPath}/webjars/jquery/3.6.0/dist/jquery.min.js"></script>
    <script src="../resources/bootstrap/js/bootstrap.min.js"></script>
    <script src="test.js"></script>
</head>
<body>
<jsp:include page="../_menu.jsp"/>
<div class="container" style="margin-top: 100px">
    <div class="col-md-8 col-md-offset-2">
        <div class="page-header" id="name" style="text-align: center; margintop: 30px;"></div>
        <div class="panel panel-default" id="description">
            <div class="panel-heading">Описание</div>
            <div class="panel-body">
            </div>
        </div>
        <div class="panel panel-default" id="properties">
            <div class="panel-heading">Параметры</div>
            <div class="panel-body">
            </div>
        </div>
        <div class="panel panel-default" id="categories">
            <div class="panel-heading">Категории</div>
            <div class="panel-body">
            </div>
        </div>
        <div class="panel panel-default" id="comments">
            <div class="panel-heading">Комментарии</div>
            <div class="panel-body">
            </div>
        </div>
    </div>
</div>
</body>
</html>
