package gb_retrofittests;


import gb_retrofit.dto.Product;
import gb_retrofit.enums.Category;
import gb_retrofit.service.ProductService;
import gb_retrofit.utils.RetrofitUtils;
import lombok.SneakyThrows;
import okhttp3.ResponseBody;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import retrofit2.Response;

import static org.assertj.core.api.Assertions.assertThat;

public class PutProductTest {
    static ProductService productService;
    static Product product = new Product()
            .withId(20442)
            .withTitle("Черри")
            .withCategoryTitle("Food")
            .withPrice(200);

    static Product product1 = new Product()
            .withId(20442)
            .withTitle("Черри")
            .withCategoryTitle("Food")
            .withPrice(-50);


    @BeforeAll
    static void beforeAll() {
        productService = RetrofitUtils.getRetrofit().create(ProductService.class);
    }

    @SneakyThrows
    @Test
    void putProductTest()  {
        Response<Product> response = productService.putProduct(product).execute();
        assertThat(response.body().getTitle().equals("Черри"));
        assertThat(response.body().getPrice().equals(200));
        assertThat(response.body().getId().equals(20442));
    }

    @SneakyThrows
    @Test
    void putProduct1Test()  {
        Response<Product> response = productService.putProduct(product1).execute();
        assertThat(response.body().getTitle().equals("Черри"));
        assertThat(response.body().getPrice().equals(0));
        assertThat(response.body().getId().equals(20442));
    }

}

