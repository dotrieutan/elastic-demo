package sample.ekino.hello.elastic.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sample.ekino.hello.elastic.domain.Product;
import sample.ekino.hello.elastic.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/search")
    public ResponseEntity<List<Product>> getProducts(@RequestParam("author") String author) {
        return ResponseEntity.ok(productService.getProducts(author));
    }
}
