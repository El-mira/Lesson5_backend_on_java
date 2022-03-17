package gb_retrofit.utils;

import gb_retrofit.db.dao.CategoriesMapper;
import gb_retrofit.db.dao.ProductsMapper;
import gb_retrofit.db.model.Categories;
import gb_retrofit.db.model.CategoriesExample;
import gb_retrofit.db.model.ProductsExample;
import lombok.experimental.UtilityClass;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

@UtilityClass
public class DbUtils {
    private String resource = "mybatisConfig.xml";
    public SqlSession getSqlSession() {
        SqlSessionFactory sqlSessionFactory = null;
        try {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(resource));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sqlSessionFactory.openSession(true);
    }

    public ProductsMapper getProductsMapper(){
         return getSqlSession().getMapper(ProductsMapper.class);
    }

    public CategoriesMapper getCategoriesMapper(){
        return getSqlSession().getMapper(CategoriesMapper.class);
    }
//
//    public Categories getNewTestCategory(String quote) {
//        getCategoriesMapper().insert(new Categories(quote));
//        CategoriesExample categoriesExample = new CategoriesExample();
//        categoriesExample.createCriteria().andTitleEqualTo(quote);
//        return getCategoriesMapper().selectByExample(categoriesExample).get(0);
//    }
//
//    public void deleteAllProductsWithTheCategory(Integer categoryId) {
//        ProductsExample example = new ProductsExample();
//        example.createCriteria().andCategoryIdEqualTo(Long.valueOf(categoryId));
//        getProductsMapper().deleteByExample(example);
//    }

}
