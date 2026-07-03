<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="ru.apteka.model.Medicine" %>
<%@ include file="/WEB-INF/jspf/header.jspf" %>

<%
    Medicine editItem = (Medicine) request.getAttribute("item");
    if (editItem == null) editItem = new Medicine();
%>

<h2><%= editItem.getId() == 0 ? "Добавление лекарства" : "Редактирование лекарства" %></h2>

<form method="post" action="medicines">
    <input type="hidden" name="action" value="save">
    <input type="hidden" name="id" value="<%= editItem.getId() %>">

    <label>Наименование<br>
        <input type="text" name="name" value="<%= editItem.getName() == null ? "" : editItem.getName() %>" required>
    </label><br>
    <label>Производитель<br>
        <input type="text" name="manufacturer" value="<%= editItem.getManufacturer() == null ? "" : editItem.getManufacturer() %>" required>
    </label><br>
    <label>Количество<br>
        <input type="number" name="quantity" value="<%= editItem.getQuantity() %>" required>
    </label><br>
    <label>Цена, руб.<br>
        <input type="number" step="0.01" name="price" value="<%= editItem.getPrice() %>" required>
    </label><br>
    <label>Срок годности<br>
        <input type="date" name="expiryDate" value="<%= editItem.getExpiryDate() == null ? "" : editItem.getExpiryDate() %>" required>
    </label><br><br>

    <button type="submit">Сохранить</button>
    <a href="medicines">Отмена</a>
</form>

<%@ include file="/WEB-INF/jspf/footer.jspf" %>
