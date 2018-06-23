package example.swagger.services;

import example.swagger.dto.Product;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by Rimantas Jacikevičius on 18.6.23.
 */
@Service
public class ProductService {

    private final Map<String, Product> products = new HashMap<>();

    {
        var product = new Product();
        product.setId("123");
        product.setName("Huge black dildos");
        product.setCost(12);

        add(product);
    }

    public Collection<Product> getAll() {
        return products.values();
    }

    public Optional<Product> getById(String id) {
        if (products.containsKey(id)) {
            return Optional.of(products.get(id));
        }
        return Optional.empty();
    }

    public void add(Product product) {
        String id = product.getId();
        if (id != null && !id.isEmpty()) {
            products.put(id, product);
        } else {
            throw new IllegalArgumentException("Can I has ID");
        }
    }

    public void delete(String id) {
        products.remove(id);
    }

}

