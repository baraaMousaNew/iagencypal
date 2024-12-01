package model_classes.products;

public class ProductsModelClass {

    private String productName;

    private String carrierName;

    private String effectiveDate;

    private String productTermDate;

    private String CoverageType;

    private String description;

    private boolean isActiveOnCommission;


    //getter


    public String getProductName() {
        return productName;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public String getProductTermDate() {
        return productTermDate;
    }

    public String getCoverageType() {
        return CoverageType;
    }

    public String getDescription() {
        return description;
    }

    public boolean isActiveOnCommission() {
        return isActiveOnCommission;
    }

    public String getCarrierName() {
        return carrierName;
    }

    // setter


    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public void setProductTermDate(String productTermDate) {
        this.productTermDate = productTermDate;
    }

    public void setCoverageType(String coverageType) {
        CoverageType = coverageType;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setActiveOnCommission(boolean activeOnCommission) {
        isActiveOnCommission = activeOnCommission;
    }

    public void setCarrierName(String carrierName) {
        this.carrierName = carrierName;
    }
}
