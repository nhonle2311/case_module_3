package org.example.casemodule3.model.category;

import java.sql.Timestamp;
import org.example.casemodule3.model.user.Users;

public class Category {
    private int id;
    private String categoryName;
    private CategoryType categoryType;
    private Users users ;
    private Timestamp createdAt;

    public Category() {
    }

    public Category(int id, String categoryName, CategoryType categoryType, Users users, Timestamp createdAt) {
        this.id = id;
        this.categoryName = categoryName;
        this.categoryType = categoryType;
        this.users = users;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public CategoryType getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(CategoryType categoryType) {
        this.categoryType = categoryType;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
