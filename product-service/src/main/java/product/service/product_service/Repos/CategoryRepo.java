package product.service.product_service.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import product.service.product_service.Entities.CategoryEntity;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoryRepo extends JpaRepository<CategoryEntity, String> {
    public CategoryEntity findByName (String name);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO categories (name) VALUES (?1) ON CONFLICT (name) DO NOTHING", nativeQuery = true)
    void insertCategory(String name);

}