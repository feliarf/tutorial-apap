package apap.tutorial.shapee.model;

import java.util.List;

public class TokoModel {
    private String Owner;
    private int number_of_staf;
    private String location;
    private List<ProductModel> productModel;
    private String branch;

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getOwner() {
        return Owner;
    }

    public void setOwner(String owner) {
        Owner = owner;
    }

    public int getNumber_of_staf() {
        return number_of_staf;
    }

    public void setNumber_of_staf(int number_of_staf) {
        this.number_of_staf = number_of_staf;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<ProductModel> getProductModel() {
        return productModel;
    }

    public void setProductModel(List<ProductModel> productModel) {
        this.productModel = productModel;
    }
}
