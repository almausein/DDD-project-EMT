package mk.ukim.finki.emt.reservationmodule.xport;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class FilmClient {
    private final RestTemplate restTemplate;
    private final String serverUrl;

    public FilmClient(@Value("${app.product-catalog.url}") String serverUrl) {
        this.serverUrl = serverUrl;
        this.restTemplate = new RestTemplate();
        var requestFactory = new SimpleClientHttpRequestFactory();
        this.restTemplate.setRequestFactory(requestFactory);
    }

    private UriComponentsBuilder uri() {
        return UriComponentsBuilder.fromUriString(this.serverUrl);
    }


//    public List<Film> findAll() {
//        try {
//            return restTemplate.exchange(uri().path("/api/product").build().toUri(), HttpMethod.GET,null, new ParameterizedTypeReference<List<Product>>() {
//            }).getBody();
//        } catch (Exception e) {
//            return Collections.emptyList();
//        }
    }


