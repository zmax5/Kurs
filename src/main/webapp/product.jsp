<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Информация о продукте</title>
    <jsp:include page="/res"/>
    <script src="resources/js/product.js?ver=21"></script>
</head>
<body>
<jsp:include page="/_menu"/>
<div class="container" style="margin-top: 100px">
    <div class="col-md-8 col-md-offset-2">
        <div class="page-header" id="name" style="text-align: center; margintop: 30px;">
            <div class="panel-info" id="nameHere"></div>
            <div class="panel-info" id="vendor"></div>
        </div>
        <div class="panel panel-default" id="description">
            <div class="panel-heading">Описание</div>
            <div class="panel-body"></div>
        </div>
        <div class="panel panel-default" id="properties">
            <div class="panel-heading">Характеристики</div>
            <div class="panel-body"></div>
        </div>
        <div class="panel panel-default" id="categories">
            <div class="panel-heading">Категории</div>
            <div class="panel-body"></div>
        </div>
        <div class="panel panel-default" id="comments">
            <div class="panel-heading">Комментарии</div>
            <div class="panel-body"></div>
            <div class="panel panel-default" id="commnets-add">
                <div class="panel-heading">Добавить комментарий</div>
                <div class="panel-body">
                    <label for="comments-nick">Никнейм:</label><br>
                    <input class="text-input" type="text" id="comments-nick" maxlength="20" required/>
                    <br>
                    <label for="comments-text">Комментарий:</label><br>
                    <textarea class="text-input" id="comments-text" maxlength="255"
                              style="margin-bottom: 20px; width: 100%; height: 10%; resize: none;" required></textarea>
                    <br>
                    <input type="button" id="add-coment" value="Добавить комментарий"/>
                </div>
            </div>
        </div>
    </div>
    <div id="dialog-button" class="action-button" style="right:140px; position: fixed;">
        <i class="glyphicon glyphicon-pencil" title="Редактировать"></i>
    </div>
    <div id="delete-button" class="action-button" style="right:140px;bottom: 120px; position: fixed;">
        <i class="glyphicon glyphicon-trash" title="Удалить"></i>
    </div>
</div>
</body>
</html>