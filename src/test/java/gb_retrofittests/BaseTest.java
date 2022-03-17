package gb_retrofittests;

import com.github.javafaker.Faker;
import gb_retrofit.db.dao.CategoriesMapper;
import gb_retrofit.db.dao.ProductsMapper;
import gb_retrofit.db.model.Categories;
import gb_retrofit.db.model.CategoriesExample;
import gb_retrofit.db.model.ProductsExample;
import gb_retrofit.service.CategoryService;
import gb_retrofit.service.ProductService;
import gb_retrofit.utils.DbUtils;
import gb_retrofit.utils.RetrofitUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import retrofit2.Retrofit;

public class BaseTest {
    static Retrofit retrofit;
    static CategoryService categoryService;
    static ProductService productService;
    static Faker faker;
    static ProductsMapper productsMapper;
    static CategoriesMapper categoriesMapper;
    static Categories testCategory;

    @BeforeAll
    static void beforeAll() {
        retrofit = RetrofitUtils.getRetrofit();
        categoryService = retrofit.create(CategoryService.class);
        productService = retrofit.create(ProductService.class);
        faker = new Faker();
//        productsMapper = DbUtils.getProductsMapper();
//        categoriesMapper = DbUtils.getCategoriesMapper();
//
//        String quote = faker.animal().name();
//        testCategory = DbUtils.getNewTestCategory(quote);
//    }
//
//    @AfterAll
//    static void afterAll() {
//        DbUtils.deleteAllProductsWithTheCategory(testCategory.getId());
//        categoriesMapper.deleteByPrimaryKey(testCategory.getId());
//    }

    }
}
