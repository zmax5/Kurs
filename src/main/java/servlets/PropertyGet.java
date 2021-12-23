package servlets;

import com.google.gson.Gson;
import entity.PropertyUnit;
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

@WebServlet(name = "propertyget", value = "/propertyget")
public class PropertyGet extends HttpServlet {

    private static final PropertyService propertyService = new PropertyService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // ID
        int id = Integer.parseInt(request.getParameter("id"));

        Property property = propertyService.findProperty(id);
        PropertyUnit propertyUnit = new PropertyUnit(property);
        Map<String, PropertyUnit> c = new HashMap<>();
        c.put("property", propertyUnit);

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
