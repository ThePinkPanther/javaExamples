package example.swagger.controllers;

import example.swagger.Endpoints;
import example.swagger.controllers.exceptions.ResourceNotFoundException;
import example.swagger.dto.Product;
import example.swagger.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by Rimantas Jacikevičius on 18.6.23.
 */
@RestController
@RequestMapping(Endpoints.PRODUCTS)
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Product> list() {
        return productService.getAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void add(Product product) {
        productService.add(product);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Product findById(@PathVariable("id") String id) {
        Optional<Product> byId = productService.getById(id);
        if (byId.isPresent()) {
            return byId.get();
        }
        throw new ResourceNotFoundException();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") String id) {
        productService.delete(id);
    }

}
