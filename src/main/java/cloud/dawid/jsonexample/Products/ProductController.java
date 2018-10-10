package cloud.dawid.jsonexample.Products;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/products")
@NoArgsConstructor
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/all")
    public List<Product> getAll(){
        return productService.findAll();
    }

    @DeleteMapping("/del/{id}")
    public void delete(@PathVariable long id){
        productService.delete(id);
    }

    @PostMapping("/add")
    public void create(@RequestBody Product product){
        productService.create(product);
    }
}

