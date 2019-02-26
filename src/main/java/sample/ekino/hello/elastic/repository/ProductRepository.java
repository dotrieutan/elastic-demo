package sample.ekino.hello.elastic.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import sample.ekino.hello.elastic.domain.Product;

import java.util.List;

public interface ProductRepository extends ElasticsearchRepository<Product, String> {
    List<Product> findByAuthor(String author);
}
