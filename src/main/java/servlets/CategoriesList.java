package servlets;

import com.google.gson.Gson;
import entity.CategoryUnit;
import entity.hibirnated.Category;
import entity.hibirnated.Product;
import entity.hibirnated.ProductHasCategory;
import services.category.CategoryService;
import services.phc.PHCService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "categories", value = "/categories")
public class CategoriesList extends HttpServlet {

    private static final CategoryService categoryService = new CategoryService();
    private static final PHCService phcService = new PHCService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> categories = categoryService.getAllCategory();
        List<CategoryUnit> categoryUnits = new ArrayList<>();
        for (Category c : categories) {
            categoryUnits.add(new CategoryUnit(c));
        }
        Map<String, Object> c = new HashMap<>();
        c.put("categories", categoryUnits);
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
    protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action.equals("ADD")) {
            String name = req.getParameter("name");
            Category category = new Category();
            category.setName(name);
            categoryService.createCategory(category);
            response.getWriter().print("ok!");
        } else if (action.equals("UPDATE")) {
            String id = req.getParameter("id");
            String name = req.getParameter("name");
            Category category = new Category();
            category.setIdCategory(Integer.parseInt(id));
            category.setName(name);
            categoryService.updateCategory(category);
        } else if (action.equals("DELETE")) {
            int id = Integer.parseInt(req.getParameter("id"));
            categoryService.deleteCategory(id);
        }
    }
}
