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
    <title>Редактировать Категорию</title>
    <jsp:include page="/res"/>
    <script src="${pageContext.request.contextPath}/resources/js/update_category.js"></script>
</head>
<body>
<jsp:include page="/_menu"/>
<div class="container" style="margin-top: 50px">
    <div class="col-md-20 col-md-offset-1">
        <div class="page-header"><h1>Редактирование категории</h1></div>

        <div class="panel panel-default" id="category-info">
            <div class="panel-heading">Параметры категории</div>
            <div class="panel-body" id="content">
                <div class="panel panel-default" id="name-select">
                    <div class="panel-heading">Название<a style="color: red">*</a></div>
                    <div class="panel-body">
                        <input class="text text-input" type="text" id="category-name" maxlength="20" required>
                    </div>
                </div>
            </div>
            <button type="submit" class="btn btn-success" id="add-category-button"
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
