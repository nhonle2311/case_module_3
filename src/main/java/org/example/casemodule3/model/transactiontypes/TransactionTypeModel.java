package org.example.casemodule3.model.transactiontypes;

import org.example.casemodule3.model.category.Category;

public class TransactionTypeModel {
    private int id;
    private String typeName;
    private String typeDescription;
    private Category category;

    public TransactionTypeModel() {
    }

    public TransactionTypeModel(int id, String typeName, String typeDescription, Category category) {
        this.id = id;
        this.typeName = typeName;
        this.typeDescription = typeDescription;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeDescription() {
        return typeDescription;
    }

    public void setTypeDescription(String typeDescription) {
        this.typeDescription = typeDescription;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
