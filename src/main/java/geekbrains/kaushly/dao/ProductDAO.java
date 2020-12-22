package geekbrains.kaushly.dao;

import geekbrains.kaushly.database.GlobalFactory;
import geekbrains.kaushly.item.Product;
import org.hibernate.Session;

import java.util.List;

public class ProductDAO implements ProductRepository {

    @Override
    public Product findByID(Long id) {
        Session session = GlobalFactory.get().getCurrentSession();
        return session.createQuery("select p from Product p where p.id = :id", Product.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public List<Product> findAll() {
        Session session = GlobalFactory.get().getCurrentSession();

        return session.createQuery("select p from Product p", Product.class)
                .getResultList();
    }

    @Override
    public void deleteByID(Long id) {
        Session session = GlobalFactory.get().getCurrentSession();
        session.createQuery("delete from Product where id = :id")
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    public Product saveOrUpdate(Product product) {
        Session session = GlobalFactory.get().getCurrentSession();
        session.saveOrUpdate(product);
        return product;
    }
}
