package com.sprint.demo.entity;



import jakarta.persistence.*;

@Entity
@Table(name = "Category", uniqueConstraints = @UniqueConstraint(columnNames = "category_name"))
public class Category {

    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CategoryID")
    private Integer categoryId;

    @Column(name = "Category_Name", nullable = false, length = 255)
    private String categoryName;

    // Getters and Setters
    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
