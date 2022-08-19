package ru.kremenia.persist;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ProductRepository {

    private final Map<Long, Product> userMap = new ConcurrentHashMap<>();

    private final AtomicLong identity = new AtomicLong(0);

    @PostConstruct
    public void init() {
        this.insert(new Product("Product 1"));
        this.insert(new Product("Product 2"));
        this.insert(new Product("Product 3"));
        this.insert(new Product("Product 4"));
        this.insert(new Product("Product 5"));
    }

    public List<Product> findAll() {
        return new ArrayList<>(userMap.values());
    }

    public Product findById(long id) {
        return userMap.get(id);
    }

    public void insert(Product product) {
        long id = identity.incrementAndGet();
        product.setId(id);
        userMap.put(id, product);
    }

    public Product save(Product product){
        if(product.getId() == null){
            product.setId(identity.incrementAndGet());
        }
        userMap.put(product.getId(), product);
        return product;
    }

    public void delete(long id) {
        userMap.remove(id);
    }

}

