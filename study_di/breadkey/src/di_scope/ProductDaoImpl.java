package di_scope;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
@Scope(
        value = BeanDefinition.SCOPE_PROTOTYPE
)
public class ProductDaoImpl implements ProductDao {
    private HashMap<Integer, Product> database = new HashMap<>();

    @Override
    public Product findByProductId(int id) {
        return database.get(id);
    }

    @Override
    public void addProduct(Product product) {
        database.put(product.getId(), product);
    }
}
