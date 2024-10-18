package product.service.product_service.Repos;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import product.service.product_service.Entities.ProductEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<ProductEntity, Integer> {

    @Modifying
    @Query(value = "INSERT INTO products (name, description, price, stock) VALUES (?1, ?2, ?3, ?4)", nativeQuery = true)
    void insertProduct(String name, String description, int price, int stock);  
    
    
    @Modifying
    @Query(value = "INSERT INTO product_categories (product_id, category_id) VALUES (?1, ?2)", nativeQuery = true)
    void HandleRelationInsert(int productId, String categoryId);


    @Modifying
    @Query(value = "DELETE FROM products WHERE id =?1 ", nativeQuery = true)
    void deleteById(int productId);

    @Modifying
    @Query(value = "DELETE FROM product_categories WHERE product_id =?1 ", nativeQuery = true)
    void HandleRelationDelete(int productId);

}
