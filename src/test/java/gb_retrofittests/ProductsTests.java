package gb_retrofittests;

import gb_retrofit.dto.Product;
import gb_retrofit.enums.Category;
import org.junit.jupiter.api.AfterEach;
import retrofit2.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.assertj.core.api.Assertions.assertThat;

public class ProductsTests extends BaseTest {
    Product product;
    Integer id;

    @BeforeEach
    void setUp() {
       product = new Product()
               .withTitle(faker.food().fruit())
               .withCategoryTitle(Category.FOOD.getName())
               .withPrice(250);
    }

    @Test
    void createNewProductTest() throws IOException {
        Response<Product> response =
    productService.createProduct(product).execute();
        id = response.body().getId();
        assertThat(response.body().getCategoryTitle()).isEqualTo(product.getCategoryTitle());
        assertThat(response.body().getTitle()).isEqualTo(product.getTitle());
        assertThat(response.body().getPrice()).isEqualTo(product.getPrice());
        assertThat(response.body().getId()).isNotNull();
    }

//    @Test
//    void getProduct() throws IOException {
//        Response<Product> response = productService.getProduct(20442).execute();
//    }

    @AfterEach
    void tearDown() throws IOException {
        productService.deleteProduct(id).execute();
    }
}
