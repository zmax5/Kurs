package services.comments;

import dao.comments.CommentsHibernateDAO;
import entity.hibirnated.Comments;

import java.util.List;

public class CommentsService implements ICommentsService {

    private final CommentsHibernateDAO commentsHibernateDAO = new CommentsHibernateDAO();

    public void createComments(Comments comments) {
        commentsHibernateDAO.create(comments);
    }

    public Comments findComments(int commentsId) {
        return commentsHibernateDAO.findById(commentsId);
    }

    public void updateComments(Comments comments) {
        commentsHibernateDAO.saveOrUpdate(comments);
    }

    public void deleteComments(int commentsId) {
        commentsHibernateDAO.delete(commentsId);
    }

    public List<Comments> getAllComments() {
        return commentsHibernateDAO.findAll();
    }

    public List<Comments> findByIdProduct(int id) {
        return commentsHibernateDAO.getByIdProduct(id);
    }
}
