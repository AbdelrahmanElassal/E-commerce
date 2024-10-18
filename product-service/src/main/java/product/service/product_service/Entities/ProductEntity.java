package product.service.product_service.Entities;

import java.util.Set;
import java.util.HashSet;
import jakarta.persistence.CascadeType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "products")
@Data
public class ProductEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private int stock;

    
    @ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST , CascadeType.MERGE})
    @JoinTable(
        name = "product_categories", 
        joinColumns = @JoinColumn(name = "product_id"), 
        inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<CategoryEntity>categories= new HashSet<>();
    

    // Default constructor
    public ProductEntity() {
    }

    // Parameterized constructor
    public ProductEntity( String name, String description, int price, int stock) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }

    public void addCategory(CategoryEntity category) {
        this.categories.add(category);
    }

    public void removeCategory(CategoryEntity category) {
        this.categories.remove(category);
    }

  
}



