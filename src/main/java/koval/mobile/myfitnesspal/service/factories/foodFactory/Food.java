package koval.mobile.myfitnesspal.service.factories.foodFactory;

public class Food {

    private String brandName;
    private int servingsSize;
    private String description;
    private String servingsSizeQuantity;
    private int servingsPerContainer;
    private int calories;


    public Food(){}

    public Food(String brandName, int servingsSize, String description, String servingsSizeQuantity, int servingsPerContainer, int calories){
        this.brandName = brandName;
        this.servingsSize = servingsSize;
        this.description = description;
        this.servingsSizeQuantity = servingsSizeQuantity;
        this.servingsPerContainer = servingsPerContainer;
        this.calories = calories;
    }


    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public int getServingsSize() {
        return servingsSize;
    }

    public void setServingsSize(int servingsSize) {
        this.servingsSize = servingsSize;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getServingsSizeQuantity() {
        return servingsSizeQuantity;
    }

    public void setServingsSizeQuantity(String servingsSizeQuantity) {
        this.servingsSizeQuantity = servingsSizeQuantity;
    }

    public int getServingsPerContainer() {
        return servingsPerContainer;
    }

    public void setServingsPerContainer(int servingsPerContainer) {
        this.servingsPerContainer = servingsPerContainer;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }
}
