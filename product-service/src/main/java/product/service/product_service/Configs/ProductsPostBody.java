package product.service.product_service.Configs;

import product.service.product_service.Entities.CategoryEntity;
import product.service.product_service.Entities.ProductEntity;
import java.util.Set;


public class ProductsPostBody {
    private ProductEntity entity;
    private Set<CategoryEntity> categories;

    public ProductEntity getEntity() {
        return entity;
    }

    public void setEntity(ProductEntity entity) {
        this.entity = entity;
    }

    public Set<CategoryEntity> getCategories() {
        return categories;
    }

    public void setCategories(Set<CategoryEntity> categories) {
        this.categories = categories;
    }



}
