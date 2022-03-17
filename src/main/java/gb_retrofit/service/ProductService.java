package gb_retrofit.service;

import gb_retrofit.dto.GetCategoryResponse;
import gb_retrofit.dto.Product;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

public interface ProductService {
    @GET("products")
    Call<ResponseBody> getProduct();

    @POST("products")
    Call<Product> createProduct(@Body Product product);

    @PUT("products")
    Call<Product> putProduct(@Body Product product);

    @DELETE("products/{id}")
    Call<ResponseBody> deleteProduct(@Path("id") int id);

    @GET("products/{id}")
    Call<GetCategoryResponse> getProductWithId(@Path("id") int id);
}
