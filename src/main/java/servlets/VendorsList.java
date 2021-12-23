package servlets;

import com.google.gson.Gson;
import entity.VendorUnit;
import entity.hibirnated.Category;
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

@WebServlet(name = "vendors", value = "/vendors")
public class VendorsList extends HttpServlet {

    private static final VendorService vendorService = new VendorService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Vendor> vendors = vendorService.getAllVendor();
        List<VendorUnit> vendorUnits = new ArrayList<>();
        for (Vendor v : vendors) {
            vendorUnits.add(new VendorUnit(v));
        }
        Map<String, Object> c = new HashMap<>();
        c.put("vendors", vendorUnits);
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
            String phone = req.getParameter("phone");
            Vendor vendor = new Vendor();
            vendor.setName(name);
            vendor.setPhone(phone);
            vendorService.createVendor(vendor);
            response.getWriter().print("ok!");
        } else if (action.equals("UPDATE")) {
            String id = req.getParameter("id");
            String name = req.getParameter("name");
            String phone = req.getParameter("phone");
            Vendor vendor = new Vendor();
            vendor.setIdVendor(Integer.parseInt(id));
            vendor.setName(name);
            vendor.setPhone(phone);
            vendorService.updateVendor(vendor);
        } else if (action.equals("DELETE")) {
            String id = req.getParameter("id");
            vendorService.deleteVendor(Integer.parseInt(id));
        }
    }
}
