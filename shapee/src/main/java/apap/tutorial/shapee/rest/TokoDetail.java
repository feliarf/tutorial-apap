package apap.tutorial.shapee.rest;

import apap.tutorial.shapee.model.ProductModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TokoDetail {

    @JsonProperty("owner")
    private String Owner;


    @JsonProperty("number-of-staf")
    private int number_of_staf;

    @JsonProperty("location")
    private String location;

    @JsonProperty("products")
    private List<ProductModel> productModel;

    @JsonProperty("branch")
    private String Branch;

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

    public String getBranch() {
        return Branch;
    }

    public void setBranch(String branch) {
        Branch = branch;
    }
}
