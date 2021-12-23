package servlets;

import com.google.gson.Gson;
import entity.ProductUnit;
import entity.hibirnated.Category;
import entity.hibirnated.Product;
import org.hibernate.Session;
import services.category.CategoryService;
import services.product.ProductService;
import utils.HibernateFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@WebServlet(name = "restest", value = "/restest")
public class restest extends HttpServlet {

    private static final ProductService productService = new ProductService();
    private static final CategoryService categoryService = new CategoryService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> product = productService.getAllProducts();
        List<ProductUnit> productUnit = new ArrayList<>();
        //Category categories = categoryService.findCategory(Integer.parseInt(request.getParameter("id")));
        for (Product p : product) {
            productUnit.add(new ProductUnit(p));
        }
        Map<String, List<ProductUnit>> c = new HashMap<>();
        c.put("prod", productUnit);
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
