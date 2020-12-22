package geekbrains.kaushly;

import geekbrains.kaushly.dao.ProductDAO;
import geekbrains.kaushly.dao.ProductRepository;
import geekbrains.kaushly.database.GlobalFactory;
import geekbrains.kaushly.item.Product;
import org.hibernate.Session;


public class Main {
    public static void main(String[] args) {
        GlobalFactory globalFactory = new GlobalFactory("hibernate.cfg.xml");
        try(Session session = GlobalFactory.get().getCurrentSession()){
            ProductRepository productRepository = new ProductDAO();

            session.beginTransaction();

            productRepository.saveOrUpdate(new Product("Яблоко", 100));
            productRepository.saveOrUpdate(new Product("Банан", 54));
            productRepository.saveOrUpdate(new Product("Кокос", 230));
            productRepository.saveOrUpdate(new Product("Апельсин", 134));

//            productRepository.findAll().forEach(System.out::println);
            Product product = productRepository.findByID(3L);
            System.out.println(product);

            productRepository.deleteByID(1L);
//            productRepository.findAll().forEach(System.out::println);

            session.getTransaction().commit();
        }
        GlobalFactory.close();
    }
}
