package sample.ekino.hello.elastic.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.math.BigDecimal;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Document(indexName = "catalog", type = "product")
public class Product {

    @Id
    String id;

    String sku;

    String title;

    String description;

    String author;

    BigDecimal price;
}
