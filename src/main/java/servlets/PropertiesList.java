package servlets;

import com.google.gson.Gson;
import entity.PropertyUnit;
import entity.hibirnated.Product;
import entity.hibirnated.ProductHasCategory;
import entity.hibirnated.Property;
import services.property.PropertyService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "properties", value = "/properties")
public class PropertiesList extends HttpServlet {

    private static final PropertyService propertyService = new PropertyService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Property> properties = propertyService.getAllProperty();
        List<PropertyUnit> propertyUnits = new ArrayList<>();
        for (Property p : properties) {
            propertyUnits.add(new PropertyUnit(p));
        }
        Map<String, Object> c = new HashMap<>();
        c.put("properties", propertyUnits);
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
            String value = req.getParameter("value");
            int idProduct = Integer.parseInt(req.getParameter("id"));
            Property property = new Property();
            property.setName(name);
            property.setValue(value);
            property.setIdProduct(idProduct);
            propertyService.createProperty(property);
            response.getWriter().print("ok!");
        } else if (action.equals("UPDATE")) {
            int id = Integer.parseInt(req.getParameter("id"));
            String name = req.getParameter("name");
            String value = req.getParameter("value");
            int idProduct = Integer.parseInt(req.getParameter("idProduct"));
            Property property = new Property();
            property.setIdProperty(id);
            property.setName(name);
            property.setValue(value);
            property.setIdProduct(idProduct);
            propertyService.updateProperty(property);
        } else if (action.equals("DELETE")) {
            String id = req.getParameter("id");
            propertyService.deleteProperty(Integer.parseInt(id));
        }
    }
}
