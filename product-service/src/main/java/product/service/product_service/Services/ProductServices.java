package product.service.product_service.Services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import product.service.product_service.Repos.ProductRepo;
import java.util.ArrayList;

import product.service.product_service.Configs.ProductsPostBody;
import product.service.product_service.Entities.CategoryEntity;
import product.service.product_service.Entities.ProductEntity;
import java.util.Optional;

@Service
public class ProductServices {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private CategoryServices categoryServices;


    
    

    //CRUD Operations
    public ArrayList<ProductEntity> getAllProducts() {
        try{
            return (ArrayList<ProductEntity>) productRepo.findAll();
        }catch(Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public Optional<ProductEntity> getProductById(int id){
        try{
            return productRepo.findById(id);
        }catch(Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Transactional
    public ProductEntity addProduct(ProductsPostBody body){
        try{
            ProductEntity product = body.getEntity();
            ProductEntity product1 = productRepo.save(product);
            for (CategoryEntity category : body.getCategories()){
                categoryServices.addCategory(category.getName());
                productRepo.HandleRelationInsert(product.getId(), category.getName());
            }

            return product1;
        }catch(Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Transactional
    public int deleteProduct(int id){
        try{
            productRepo.HandleRelationDelete(id);
            productRepo.deleteById(id);
            return id;
        }catch(Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

}
