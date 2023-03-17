package koval.mobile.myfitnesspal.service.accountFactory;


import koval.mobile.myfitnesspal.service.enums.Gender;
import koval.mobile.myfitnesspal.service.enums.WeightMeasure;

import java.util.Random;

public class AccountFactory {


    private static final Random random = new Random();

    public static Account generateAccount() {

        int maxAge = 40;
        int minAge = 18;
        int maxHeight = 199;
        int minHeight = 160;
        int maxWeight = 100;
        int minWeight = 70;
        Account account = new Account();

        account.setAge(random.nextInt(maxAge - minAge) + minAge);
        account.setGender(Gender.FEMALE);
        account.setCountry("Ukraine");
        account.setHeightCentimeters(random.nextInt(maxHeight - minHeight) + minHeight);
        account.setWeightKilograms(random.nextInt(maxWeight - minWeight) + minWeight);
        account.setWeightMeasure(WeightMeasure.KILOGRAMS);
        account.setKilograms(random.nextInt(5));

        return account;
    }

}
