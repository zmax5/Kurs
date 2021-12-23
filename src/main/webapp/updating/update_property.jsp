<%--
  Created by IntelliJ IDEA.
  User: zmax5
  Date: 22.12.2021
  Time: 23:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Редактировать Характеристику</title>
    <jsp:include page="/res"/>
    <script src="${pageContext.request.contextPath}/resources/js/update_property.js?ver=2"></script>
</head>
<body>
<jsp:include page="/_menu"/>
<div class="container" style="margin-top: 50px">
    <div class="col-md-20 col-md-offset-1">
        <div class="page-header"><h1>Редактирование характеристики</h1></div>
        <div class="panel panel-default" id="property-info">
            <div class="panel-heading">Параметры характеристики</div>
            <div class="panel-body" id="content">
                <div class="panel panel-default" id="name-select">
                    <div class="panel-heading">Характеристика<a style="color: red">*</a></div>
                    <div class="panel-body">
                        <input class="text text-input" type="text" id="property-name" maxlength="20" required>
                    </div>
                </div>
                <div class="panel panel-default" id="value-select">
                    <div class="panel-heading">Значение<a style="color: red">*</a></div>
                    <div class="panel-body">
                        <input class="text text-input" type="text" id="property-value" maxlength="20" required>
                    </div>
                </div>
                <div class="panel panel-default" id="product-select">
                    <div class="panel-heading">Продукт<a style="color: red">*</a></div>
                    <div class="panel-body">
                        <select class="product-select" name="vendor" id="list-products"></select>
                    </div>
                </div>
            </div>
            <button type="submit" class="btn btn-success" id="add-property-button"
                    style="margin-left: 15px; margin-bottom: 20px; margin-right: 15px; right: 0">
                Сохранить
            </button>
            <button type="button" class="btn btn-danger" id="cancel-add"
                    style="margin-left: 15px; margin-bottom: 20px; margin-right: 15px; right: 0">
                Отмена
            </button>
        </div>
    </div>
</div>
</body>
</html>
