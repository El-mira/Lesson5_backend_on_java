package gb_retrofittests;

import gb_retrofit.dto.GetCategoryResponse;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import retrofit2.Response;
import java.io.IOException;
import static org.assertj.core.api.Assertions.assertThat;

public class CategoriesTests extends BaseTest{

    @ParameterizedTest
    @EnumSource(value = gb_retrofit.enums.Category.class)
    void getFoodCategoryTest(gb_retrofit.enums.Category category) throws IOException {
        Response<GetCategoryResponse> response = categoryService
                .getCategory(category.getId())
                .execute();
        assertThat(response.body().getTitle()).isEqualTo(category.getName());
        response.body()
                .getProducts()
                .forEach(e -> assertThat(e.getCategoryTitle()).isEqualTo(category.getName()));

//        try {
//            System.out.println(response.body().string());
//        } catch (NullPointerException e) {
//            System.out.println(response.errorBody().string());
//        }

//         - второй вариант
//        if (response.isSuccessful())
//            System.out.println(response.body().string());
//        else System.out.println(response.errorBody().string());
    }
}
