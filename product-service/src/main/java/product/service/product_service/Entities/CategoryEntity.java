package product.service.product_service.Entities;


import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;

import java.util.HashSet;
import java.util.Set;


import lombok.Data;

@Entity
@Table(name = "categories")
@Data
public class CategoryEntity {
    
    @Id
    private String name;

    @ManyToMany(mappedBy = "categories", fetch = FetchType.EAGER)
    private Set<ProductEntity> products= new HashSet<>();



    // Default constructor
    public CategoryEntity() {
    }



    // Parameterized constructor
    public CategoryEntity(String name) {
        this.name = name;
    }

}
