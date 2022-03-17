package gb_retrofit;

import com.github.javafaker.Faker;
import gb_retrofit.db.dao.ProductsMapper;
import gb_retrofit.db.model.Products;
import gb_retrofit.db.model.ProductsExample;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.IOException;
@Slf4j
public class MainDB {

    static Faker faker = new Faker();
    private static String resource = "mybatisConfig.xml";
    public static void main(String[] args) {
        SqlSessionFactory sqlSessionFactory = null;
        try {
          sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(resource));
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSession sqlSession = sqlSessionFactory.openSession(true); // первый вариант коммита - параметр true
        ProductsMapper productsMapper = sqlSession.getMapper(ProductsMapper.class);
        Products product = productsMapper.selectByPrimaryKey(24629l);
        log.info(product.getTitle());
       // productsMapper.deleteByPrimaryKey(18974l);
                                       //sqlSession.commit(); второй вариант коммита

        long count = productsMapper.countByExample(new ProductsExample());// посчитать все сущности в таблице (без фильтров)
        log.info(String.valueOf(count));
        ProductsExample example = new ProductsExample();
        example.createCriteria().andPriceGreaterThan(900);
        log.info(String.valueOf(productsMapper.countByExample(example)));
        example.clear();
        example.createCriteria().andCategoryIdEqualTo(3l).andPriceGreaterThan(900);
        productsMapper.selectByExample(example).forEach(e -> log.info(String.valueOf(e)));
        int newId = productsMapper.insert(new Products("Мангостин", 777,3l));
        //в базе появляется позиция, а здесь выдает синтаксическую ошибку
        // log.info(String.valueOf(newId));
    }
}
