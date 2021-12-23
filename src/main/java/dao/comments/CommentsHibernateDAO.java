package dao.comments;

import dao.AbstractGenericDao;
import entity.hibirnated.Comments;
import entity.hibirnated.Property;

import java.util.List;

public class CommentsHibernateDAO
        extends AbstractGenericDao<Comments> implements CommentsDAO{
    public List<Comments> getByIdProduct(int id) {
        openTransaction();
        List<Comments> results = getEm().createNamedQuery("Comments.findByProduct", Comments.class)
                .setParameter("id", id)
                .getResultList();
        closeTransaction();
        return results;
    }
}
