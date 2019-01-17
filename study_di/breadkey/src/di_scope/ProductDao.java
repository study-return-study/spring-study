package di_scope;

public interface ProductDao {
    Product findByProductId(int id);
    void addProduct(Product product);
}
