package servlets;

import com.google.gson.Gson;
import entity.*;
import entity.hibirnated.*;
import services.category.CategoryService;
import services.comments.CommentsService;
import services.phc.PHCService;
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

@WebServlet(name = "productget", value = "/productget")
public class ProductGet extends HttpServlet {
    private static final ProductService productService = new ProductService();
    private static final CategoryService categoryService = new CategoryService();
    private static final PropertyService propertyService = new PropertyService();
    private static final CommentsService comm = new CommentsService();
    private static final VendorService vendorService = new VendorService();
    private static final PHCService phcService = new PHCService();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // ID
        int id = Integer.parseInt(request.getParameter("id"));
        // PRODUCT
        Product product = productService.findProduct(id);
        ProductUnit productUnit = new ProductUnit(product);
        // VENDOR
        Vendor vendor = vendorService.findVendor(productUnit.getIdVendor());
        VendorUnit vendorUnit = new VendorUnit(vendor);
        // CATEGORIES
        List<Category> categories = categoryService.getByIdProduct(id);
        List<CategoryUnit> categoryUnits = new ArrayList<>();
        for (Category c : categories) {
            categoryUnits.add(new CategoryUnit(c));
        }
        // PROPERTIES
        List<Property> properties = propertyService.getPropertyByProduct(id);
        List<PropertyUnit> propertyUnt = new ArrayList<>();
        for (Property p : properties) {
            propertyUnt.add(new PropertyUnit(p));
        }
        // COMMENTS
        List<Comments> comments = comm.findByIdProduct(id);
        List<CommentUnit> commentUnits = new ArrayList<>();
        for (Comments c : comments) {
            commentUnits.add(new CommentUnit(c));
        }
        // MAP
        Map<String, Object> c = new HashMap<>();
        c.put("prod", productUnit);
        c.put("properties", propertyUnt);
        c.put("categories", categoryUnits);
        c.put("comments", commentUnits);
        c.put("vendor", vendorUnit);
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
            Gson gson = new Gson();
            String name = req.getParameter("name");
            String descr = req.getParameter("descr");
            int idVendor = Integer.parseInt(req.getParameter("vendor"));
            String categories = req.getParameter("categories");
            Product product = new Product();
            product.setName(name);
            product.setDescr(descr);
            product.setIdVendor(idVendor);
            productService.createProduct(product);
            Integer[] list = gson.fromJson(categories, Integer[].class);
            List<Product> newProduct = productService.findByExample(product);
            if (!newProduct.isEmpty()) {
                for (Integer c : list) {
                    ProductHasCategory phc = new ProductHasCategory();
                    phc.setCategIdCategory(categoryService.findCategory(c.intValue()).getIdCategory());
                    phc.setProdIdProduct(newProduct.get(newProduct.indexOf(product)).getIdProduct());
                    phcService.createPHC(phc);
                }
            }
            response.getWriter().print(newProduct.get(newProduct.indexOf(product)).getIdProduct());
        } else if (action.equals("UPDATE")) {
            Gson gson = new Gson();
            int id = Integer.parseInt(req.getParameter("id"));
            String name = req.getParameter("name");
            String descr = req.getParameter("descr");
            int idVendor = Integer.parseInt(req.getParameter("vendor"));
            String categories = req.getParameter("categories");
            Product product = new Product();
            product.setIdProduct(id);
            product.setName(name);
            product.setDescr(descr);
            product.setIdVendor(idVendor);
            productService.updateProduct(product);
            Integer[] list = gson.fromJson(categories, Integer[].class);
            List<ProductHasCategory> phcList = phcService.findByIdProduct(id);
            for (ProductHasCategory phc : phcList){
                phcService.deletePHC(phc);
            }
            for (Integer c : list) {
                ProductHasCategory phc = new ProductHasCategory();
                phc.setCategIdCategory(c.intValue());
                phc.setProdIdProduct(id);
                phcService.createPHC(phc);
            }
            response.getWriter().print(id);
        } else if (action.equals("DELETE")) {
            String id = req.getParameter("id");
            productService.deleteProduct(Integer.parseInt(id));
        }
    }
}
