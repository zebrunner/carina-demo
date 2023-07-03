package koval.web.myfitnesspal.service.factories.foodFactory;

public class Food {

    private String foodDescription;

    private String servingSize;

    private int servingsPerContainer;

    public Food() {
    }

    public Food( String foodDescription, String servingSize, int servingsPerContainer) {
        this.foodDescription = foodDescription;
        this.servingSize = servingSize;
        this.servingsPerContainer = servingsPerContainer;
    }


    public String getFoodDescription() {
        return foodDescription;
    }

    public void setFoodDescription(String foodDescription) {
        this.foodDescription = foodDescription;
    }

    public String getServingSize() {
        return servingSize;
    }

    public void setServingSize(String servingSize) {
        this.servingSize = servingSize;
    }

    public int getServingsPerContainer() {
        return servingsPerContainer;
    }

    public void setServingsPerContainer(int servingsPerContainer) {
        this.servingsPerContainer = servingsPerContainer;
    }
}
