package servlets;

import com.google.gson.Gson;
import entity.VendorUnit;
import entity.hibirnated.Vendor;
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

@WebServlet(name = "VendorGet", value = "/vendorget")
public class VendorGet extends HttpServlet {

    private static final VendorService vendorService = new VendorService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // ID
        int id = Integer.parseInt(request.getParameter("id"));

        Vendor vendor = vendorService.findVendor(id);
        VendorUnit vendorUnit = new VendorUnit(vendor);
        Map<String, VendorUnit> c = new HashMap<>();
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
