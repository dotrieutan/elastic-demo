package sample.ekino.hello.elastic.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sample.ekino.hello.elastic.domain.Product;
import sample.ekino.hello.elastic.repository.ProductRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> getProducts(String author) {
        return productRepository.findByAuthor(author);
    }
}
