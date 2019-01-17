package di_scope;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertNull;

public class ProductDaoImplTest {
    BeanFactory context = new ClassPathXmlApplicationContext("/di_scope/config/applicationContext.xml");

    @Test
    public void scopePrototypeTest() {
        addProduct(new Product(1, "연필"));
        Product product = findByProductId(1);

        assertNull(product);
    }

    private void addProduct(Product product) {
        ProductDao productDao = context.getBean(ProductDao.class);
        productDao.addProduct(product);
    }

    private Product findByProductId(int id) {
        ProductDao productDao = context.getBean(ProductDao.class);
        return productDao.findByProductId(id);
    }
}