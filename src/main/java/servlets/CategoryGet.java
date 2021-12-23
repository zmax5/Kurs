package servlets;

import com.google.gson.Gson;
import entity.CategoryUnit;
import entity.hibirnated.Category;
import services.category.CategoryService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "categoryget", value = "/categoryget")
public class CategoryGet extends HttpServlet {

    private static final CategoryService categoryService = new CategoryService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // ID
        int id = Integer.parseInt(request.getParameter("id"));

        Category category = categoryService.findCategory(id);
        CategoryUnit categoryUnits = new CategoryUnit(category);
        Map<String, CategoryUnit> c = new HashMap<>();
        c.put("category", categoryUnits);

        // GSON to JSON
        Gson gson = new Gson();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        String json = gson.toJson(c);
        out.print(json);
        out.flush();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
