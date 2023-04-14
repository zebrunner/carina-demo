package koval.mobile.myfitnesspal.service.enums;

public enum WidgetSize {
    SIZE_2X2(2, 2),
    SIZE_2X1(2, 1);

    public final int firstValue;
    public final int secondValue;

    WidgetSize(int firstValue, int secondValue) {
        this.firstValue = firstValue;
        this.secondValue = secondValue;
    }


    public int getFirstValue() {
        return firstValue;
    }

    public int getSecondValue() {
        return secondValue;
    }
}
