<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="ru.apteka.model.Medicine, java.util.List" %>
<%@ include file="/WEB-INF/jspf/header.jspf" %>

<p><a class="btn" href="medicines?action=new">+ Добавить лекарство</a></p>

<table>
    <tr>
        <th>ID</th><th>Наименование</th><th>Производитель</th>
        <th>Количество</th><th>Цена, руб.</th><th>Срок годности</th><th>Действия</th>
    </tr>
    <%
        List<Medicine> list = (List<Medicine>) request.getAttribute("list");
        for (Medicine m : list) {
    %>
    <tr>
        <td><%= m.getId() %></td>
        <td><%= m.getName() %></td>
        <td><%= m.getManufacturer() %></td>
        <td><%= m.getQuantity() %></td>
        <td><%= m.getPrice() %></td>
        <td><%= m.getExpiryDate() %></td>
        <td>
            <a class="btn edit" href="medicines?action=edit&amp;id=<%= m.getId() %>">Редактировать</a>
            <a class="btn" style="background:#c62828" href="medicines?action=delete&amp;id=<%= m.getId() %>"
               onclick="return confirm('Удалить запись?');">Удалить</a>
        </td>
    </tr>
    <% } %>
</table>

<%@ include file="/WEB-INF/jspf/footer.jspf" %>
