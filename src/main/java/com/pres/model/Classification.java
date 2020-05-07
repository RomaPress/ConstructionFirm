package com.pres.model;

public class Classification {

    private int classification_id;
    private String name_classification;

    public Classification(int classification_id, String name_classification) {
        this.classification_id = classification_id;
        this.name_classification = name_classification;
    }

    public Classification(){}

    public int getClassification_id() {
        return classification_id;
    }

    public String getName_classification() {
        return name_classification;
    }

    public void setClassification_id(int classification_id) {
        this.classification_id = classification_id;
    }

    public void setName_classification(String name_classification) {
        this.name_classification = name_classification;
    }
}
