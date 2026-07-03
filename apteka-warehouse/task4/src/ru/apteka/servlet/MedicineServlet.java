package ru.apteka.servlet;

import ru.apteka.ejb.MedicineService;
import ru.apteka.model.Medicine;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Контроллер (Controller) в паттерне MVC.
 * Бизнес-логика и доступ к БД делегированы EJB-компоненту MedicineService,
 * который контейнер GlassFish внедряет автоматически через @EJB.
 */
@WebServlet(name = "MedicineServlet", urlPatterns = {"/medicines"})
public class MedicineServlet extends HttpServlet {

    @EJB
    private MedicineService medicineService;

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
                Medicine item = medicineService.getById(id);
                request.setAttribute("item", item);
                request.getRequestDispatcher("/form.jsp").forward(request, response);
                break;

            case "delete":
                int delId = Integer.parseInt(request.getParameter("id"));
                medicineService.delete(delId);
                response.sendRedirect("medicines");
                break;

            case "list":
            default:
                request.setAttribute("list", medicineService.getAll());
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

            if (id == 0) {
                Medicine m = new Medicine(name, manufacturer, quantity, price, expiryDate);
                medicineService.add(m);
            } else {
                Medicine m = medicineService.getById(id);
                m.setName(name);
                m.setManufacturer(manufacturer);
                m.setQuantity(quantity);
                m.setPrice(price);
                m.setExpiryDate(expiryDate);
                medicineService.update(m);
            }
        }
        response.sendRedirect("medicines");
    }
}
