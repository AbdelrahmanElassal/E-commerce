package product.service.product_service.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import product.service.product_service.Entities.CategoryEntity;
import product.service.product_service.Repos.CategoryRepo;


@Service
public class CategoryServices {


    @Autowired
    private CategoryRepo categoryRepo;
    
    

    public CategoryEntity getCategory(String name){
        try{
            return categoryRepo.findByName(name);
        }catch(Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public void addCategory(String name){
        try{
            categoryRepo.insertCategory(name);
        }catch(Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }


    
}

