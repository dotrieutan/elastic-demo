package sample.ekino.hello.elastic.config;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Configuration
@ConfigurationProperties(prefix = "elastic")
@EnableElasticsearchRepositories(basePackages = "sample.ekino.hello.elastic.repository")
public class ElasticSearchConfig {

    String cluster;
    String host;
    int port;

    public Client client() throws UnknownHostException {
        Settings settings = Settings.builder().put("cluster.name", cluster).build();
        return new PreBuiltTransportClient(settings)
                .addTransportAddress(new TransportAddress(InetAddress.getByName(host), port));
    }

    @Bean
    public ElasticsearchOperations elasticsearchTemplate() throws UnknownHostException {
        return new ElasticsearchTemplate(client());
    }
}
