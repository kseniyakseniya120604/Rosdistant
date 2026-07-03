<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="ru.apteka.model.Medicine, ru.apteka.model.MedicineStore, java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Аптечный склад — список лекарств</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 40px; }
        table { border-collapse: collapse; width: 100%; }
        th, td { border: 1px solid #ccc; padding: 8px 12px; text-align: left; }
        th { background: #f2f2f2; }
        a.btn { padding: 4px 10px; background: #2e7d32; color: #fff; text-decoration: none; border-radius: 4px; }
        a.btn.edit { background: #1565c0; }
    </style>
</head>
<body>
<h1>Аптечный склад — список лекарств</h1>

<p><a class="btn" href="medicine_form.jsp">+ Добавить лекарство</a></p>

<table>
    <tr>
        <th>ID</th><th>Наименование</th><th>Производитель</th>
        <th>Количество</th><th>Цена, руб.</th><th>Срок годности</th><th>Действия</th>
    </tr>
    <%
        List<Medicine> list = MedicineStore.getAll();
        for (Medicine m : list) {
    %>
    <tr>
        <td><%= m.getId() %></td>
        <td><%= m.getName() %></td>
        <td><%= m.getManufacturer() %></td>
        <td><%= m.getQuantity() %></td>
        <td><%= m.getPrice() %></td>
        <td><%= m.getExpiryDate() %></td>
        <td><a class="btn edit" href="medicine_form.jsp?id=<%= m.getId() %>">Редактировать</a></td>
    </tr>
    <% } %>
</table>
</body>
</html>
