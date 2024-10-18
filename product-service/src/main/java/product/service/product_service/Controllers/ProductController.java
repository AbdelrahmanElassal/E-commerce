package product.service.product_service.Controllers;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import product.service.product_service.Configs.ProductsPostBody;
import product.service.product_service.Entities.ProductEntity;
import product.service.product_service.Services.ProductServices;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import java.util.Optional;




@RequestMapping("/products")
@RestController
public class ProductController {


    @Autowired
    private ProductServices productServices;

    
    //GET


    
    //#####DONE#####
    @GetMapping(value = "")
    @ResponseBody
    public ArrayList<ProductEntity> getAllProducts() {
        return productServices.getAllProducts();
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public Optional<ProductEntity> getProductById(@PathVariable int id) {
        return productServices.getProductById(id);
    }


    

    @GetMapping("/availability/{id}")
    @ResponseBody
    public boolean getCheckIfAvailiable(@PathVariable int id) {
        Optional<ProductEntity> pe = productServices.getProductById(id);
        if(pe.isPresent())return true;
        return false;
    }
    

    ///////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////
    //POST 
    @PostMapping("")
    public ProductEntity postAddProduct(@RequestBody ProductsPostBody body ){
        return productServices.addProduct(body);
    }




    ///////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////
    //DELETE

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable int id) {
        productServices.deleteProduct(id);
        return "The product " + id + " has been deleted" ;  
    }
    
    
}
