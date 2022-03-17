package gb_retrofittests;

import gb_retrofit.service.ProductService;
import gb_retrofit.utils.RetrofitUtils;
import lombok.SneakyThrows;
import okhttp3.ResponseBody;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import retrofit2.Response;
import static org.assertj.core.api.Assertions.assertThat;

public class GetProductTest {
    static ProductService productService;

    @BeforeAll
    static void beforeAll() {
        productService = RetrofitUtils.getRetrofit().create(ProductService.class);
    }

    @SneakyThrows
    @Test
    void getProductTest()  {
        Response<ResponseBody> response = productService.getProduct().execute();
        System.out.println(response);
        assertThat(response.toString().contains("500"));
    }
}
