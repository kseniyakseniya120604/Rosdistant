package ru.apteka.servlet;

import ru.apteka.model.Medicine;
import ru.apteka.model.MedicineStore;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Контроллер (Controller) в паттерне MVC.
 * Принимает запросы пользователя, обращается к слою Model (MedicineStore)
 * и определяет, какую JSP-страницу (View) вернуть в ответ.
 */
@WebServlet(name = "MedicineServlet", urlPatterns = {"/medicines"})
public class MedicineServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) action = "list";

        switch (action) {
            case "new":
                request.setAttribute("item", new Medicine());
                request.getRequestDispatcher("/form.jsp").forward(request, response);
                break;

            case "edit":
                int id = Integer.parseInt(request.getParameter("id"));
                Medicine item = MedicineStore.getById(id);
                request.setAttribute("item", item);
                request.getRequestDispatcher("/form.jsp").forward(request, response);
                break;

            case "delete":
                int delId = Integer.parseInt(request.getParameter("id"));
                MedicineStore.delete(delId);
                response.sendRedirect("medicines");
                break;

            case "list":
            default:
                request.setAttribute("list", MedicineStore.getAll());
                request.getRequestDispatcher("/list.jsp").forward(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

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
        }
        response.sendRedirect("medicines");
    }
}
