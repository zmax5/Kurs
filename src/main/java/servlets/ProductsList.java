package servlets;

import com.google.gson.Gson;
import entity.*;
import entity.hibirnated.*;
import services.category.CategoryService;
import services.comments.CommentsService;
import services.product.ProductService;
import services.property.PropertyService;
import services.vendor.VendorService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "productslist", value = "/products")
public class ProductsList extends HttpServlet {

    private static final ProductService productService = new ProductService();
    private static final CategoryService categoryService = new CategoryService();
    private static final PropertyService propertyService = new PropertyService();
    private static final CommentsService comm = new CommentsService();
    private static final VendorService vendorService = new VendorService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<Product> products = productService.getAllProducts();
        List<Map<String, Object>> b = new ArrayList<>();
        for (Product p : products) {
            // ID
            int id = p.getIdProduct();
            // PRODUCT
            ProductUnit productUnit = new ProductUnit(p);
            // VENDOR
            Vendor vendor = vendorService.findVendor(productUnit.getIdVendor());
            VendorUnit vendorUnit = new VendorUnit(vendor);
            // CATEGORIES
            List<Category> categories = categoryService.getByIdProduct(id);
            List<CategoryUnit> categoryUnits = new ArrayList<>();
            for (Category cat : categories) {
                categoryUnits.add(new CategoryUnit(cat));
            }
            // PROPERTIES
            List<Property> properties = propertyService.getPropertyByProduct(id);
            List<PropertyUnit> propertyUnt = new ArrayList<>();
            for (Property prop : properties) {
                propertyUnt.add(new PropertyUnit(prop));
            }
            // COMMENTS
            List<Comments> comments = comm.findByIdProduct(id);
            List<CommentUnit> commentUnits = new ArrayList<>();
            for (Comments com : comments) {
                commentUnits.add(new CommentUnit(com));
            }
            // MAP
            Map<String, Object> c = new HashMap<>();
            c.put("prod", productUnit);
            c.put("properties", propertyUnt);
            c.put("categories", categoryUnits);
            c.put("comments", commentUnits);
            c.put("vendor", vendorUnit);
            b.add(c);
        }
        Gson gson = new Gson();
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();
        String json = gson.toJson(b);
        out.print(json);
        out.flush();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

    }

}
