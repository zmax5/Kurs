<%--
  Created by IntelliJ IDEA.
  User: zmax5
  Date: 22.12.2021
  Time: 19:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавление продукта</title>
    <jsp:include page="/res"/>
    <script src="${pageContext.request.contextPath}/resources/js/add_product.js?ver=6"></script>
</head>
<body>
<jsp:include page="/_menu"/>

<div class="container" style="margin-top: 50px">
    <div class="col-md-20 col-md-offset-1">
        <div class="page-header"><h1>Создание товара</h1></div>

        <div class="panel panel-default" id="product-info">
            <div class="panel-heading">Параметры создаваемого товара</div>
            <div class="panel-body" id="content">
                <div class="panel panel-default" id="name-select">
                    <div class="panel-heading">Название<a style="color: red">*</a></div>
                    <div class="panel-body">
                        <input class="text text-input" type="text" id="product-name" maxlength="20" required>
                    </div>
                </div>
                <div class="panel panel-default" id="descr-select">
                    <div class="panel-heading">Описание</div>
                    <div class="panel-body">
                        <textarea class="text text-input" id="descr-text" maxlength="255"
                                  style="margin-bottom: 20px; width: 100%; height: 10%; resize: none;"
                                  required></textarea>
                    </div>
                </div>
                <div class="panel panel-default" id="vendor-select">
                    <div class="panel-heading">Производитель<a style="color: red">*</a></div>
                    <div class="panel-body">
                        <select class="vendor-select" name="vendor" id="list-vendors"></select>
                    </div>
                </div>
                <div class="panel panel-default" id="categories-select">
                    <div class="panel-heading">Категории</div>
                    <div class="panel-body">
                        <div class="panel-body" id="categories-list" style="width: 100%; height: fit-content; border: black groove thin"></div>
                        <button type="button" class="btn btn-primary" data-toggle="modal"
                                data-target="#modal-categories"
                        style="margin-top: 10px">
                            Изменить список
                        </button>
                    </div>
                </div>
            </div>
            <button type="submit" class="btn btn-success" id="add-product-button"
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
<div class="modal fade" id="modal-categories" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Список категорий</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <table class="table table-responsive" id="categories">
                    <thead>
                    <th>№</th>
                    <th>Название</th>
                    </thead>
                    <tbody></tbody>
                </table>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" id="add-categories-dialog-btn">Принять</button>
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Отмена</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>
