package servlets;

import com.google.gson.Gson;
import entity.CategoryUnit;
import entity.CommentUnit;
import entity.ProductUnit;
import entity.PropertyUnit;
import entity.hibirnated.Category;
import entity.hibirnated.Comments;
import entity.hibirnated.Product;
import entity.hibirnated.Property;
import services.comments.CommentsService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "comment", value = "/comment")
public class CommentAdd extends HttpServlet {

    private final CommentsService commentsService = new CommentsService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // ID
        int id = Integer.parseInt(request.getParameter("id"));
        // COMMENTS
        List<Comments> comments = commentsService.findByIdProduct(id);
        List<CommentUnit> commentUnits = new ArrayList<>();
        for (Comments c : comments) {
            commentUnits.add(new CommentUnit(c));
        }
        // MAP
        Map<String, Object> c = new HashMap<>();
        c.put("comments", commentUnits);
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
            List<Comments> list = commentsService.getAllComments();
            String nick = req.getParameter("nick");
            String text = req.getParameter("text");
            int idProduct = Integer.parseInt(req.getParameter("id"));
            Comments comments = new Comments();
            //comments.setIdComments(list.get(list.size() - 1).getIdComments() + 1);
            comments.setNick(nick);
            comments.setText(text);
            comments.setIdProduct(idProduct);
            commentsService.createComments(comments);
        } else if (action.equals("UPDATE")) {
            String nick = req.getParameter("nick");
            String text = req.getParameter("text");
            int idProduct = Integer.parseInt(req.getParameter("id"));
            Comments comments = new Comments();
            comments.setNick(nick);
            comments.setText(text);
            comments.setIdProduct(idProduct);
            commentsService.updateComments(comments);
        } else if (action.equals("DELETE")) {
            String id = req.getParameter("id");
            commentsService.deleteComments(Integer.parseInt(id));
        }
    }
}
