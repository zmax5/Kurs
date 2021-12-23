<%--
  Created by IntelliJ IDEA.
  User: zmax5
  Date: 22.12.2021
  Time: 22:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавление Производителя</title>
    <jsp:include page="/res"/>
    <script src="${pageContext.request.contextPath}/resources/js/add_vendor.js"></script>
</head>
<body>
<jsp:include page="/_menu"/>
<div class="container" style="margin-top: 50px">
    <div class="col-md-20 col-md-offset-1">
        <div class="page-header"><h1>Создание производителя</h1></div>

        <div class="panel panel-default" id="vendor-info">
            <div class="panel-heading">Параметры создаваемого производителя</div>
            <div class="panel-body" id="content">
                <div class="panel panel-default" id="name-select">
                    <div class="panel-heading">Название<a style="color: red">*</a></div>
                    <div class="panel-body">
                        <input class="text text-input" type="text" id="vendor-name" maxlength="20" required>
                    </div>
                </div>
                <div class="panel panel-default" id="phone-select">
                    <div class="panel-heading">Телефон<a style="color: red">*</a></div>
                    <div class="panel-body">
                        8 <input type="tel" id="vendor-phone" name="phone"
                               pattern="[0-9]{10}" maxlength="10"
                               required>
                    </div>
                </div>
            </div>
            <button type="submit" class="btn btn-success" id="add-vendor-button"
                    style="margin-left: 15px; margin-bottom: 20px; margin-right: 15px; right: 0">
                Создать
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
