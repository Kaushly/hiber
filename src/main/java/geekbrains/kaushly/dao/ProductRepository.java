package geekbrains.kaushly.dao;

import geekbrains.kaushly.item.Product;

import java.util.List;

public interface ProductRepository {
    Product findByID(Long id);
    List<Product> findAll();
    void deleteByID(Long id);
    Product saveOrUpdate(Product product);
}