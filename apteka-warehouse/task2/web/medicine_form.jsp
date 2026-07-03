<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="ru.apteka.model.Medicine, ru.apteka.model.MedicineStore" %>
<%
    // --- обработка отправленной формы (упрощённый контроллер уровня JSP) ---
    String action = request.getParameter("action");
    if ("save".equals(action)) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String manufacturer = request.getParameter("manufacturer");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        double price = Double.parseDouble(request.getParameter("price"));
        String expiryDate = request.getParameter("expiryDate");

        Medicine m = new Medicine(id, name, manufacturer, quantity, price, expiryDate);
        if (id == 0) {
            MedicineStore.add(m);
        } else {
            MedicineStore.update(m);
        }
        response.sendRedirect("index.jsp");
        return;
    }

    // --- подготовка данных для отображения формы ---
    Medicine editItem = new Medicine();
    String idParam = request.getParameter("id");
    if (idParam != null) {
        Medicine found = MedicineStore.getById(Integer.parseInt(idParam));
        if (found != null) editItem = found;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Аптечный склад — форма лекарства</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 40px; }
        label { display: block; margin-top: 10px; }
        input { padding: 6px; width: 260px; }
        button { margin-top: 16px; padding: 8px 16px; }
    </style>
</head>
<body>
<h1><%= editItem.getId() == 0 ? "Добавление лекарства" : "Редактирование лекарства" %></h1>

<form method="post" action="medicine_form.jsp">
    <input type="hidden" name="action" value="save">
    <input type="hidden" name="id" value="<%= editItem.getId() %>">

    <label>Наименование
        <input type="text" name="name" value="<%= editItem.getName() == null ? "" : editItem.getName() %>" required>
    </label>
    <label>Производитель
        <input type="text" name="manufacturer" value="<%= editItem.getManufacturer() == null ? "" : editItem.getManufacturer() %>" required>
    </label>
    <label>Количество
        <input type="number" name="quantity" value="<%= editItem.getQuantity() %>" required>
    </label>
    <label>Цена, руб.
        <input type="number" step="0.01" name="price" value="<%= editItem.getPrice() %>" required>
    </label>
    <label>Срок годности
        <input type="date" name="expiryDate" value="<%= editItem.getExpiryDate() == null ? "" : editItem.getExpiryDate() %>" required>
    </label>

    <button type="submit">Сохранить</button>
    <a href="index.jsp">Отмена</a>
</form>
</body>
</html>
