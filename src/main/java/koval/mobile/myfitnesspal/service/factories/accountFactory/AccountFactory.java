package koval.mobile.myfitnesspal.service.factories.accountFactory;


import koval.mobile.myfitnesspal.service.enums.Gender;
import koval.mobile.myfitnesspal.service.enums.WeightMeasure;

import java.util.Random;

import static koval.mobile.myfitnesspal.utils.IConstantUtils.*;

public class AccountFactory {


    private static final Random random = new Random();

    public static Account generateAccount() {

        Account account = new Account();

        account.setAge(random.nextInt(MAX_AGE - MIN_AGE) + MIN_AGE);
        account.setGender(Gender.FEMALE);
        account.setCountry("Ukraine");
        account.setHeightCentimeters(random.nextInt(MAX_HEIGHT - MIN_HEIGHT) + MIN_HEIGHT);
        account.setWeightKilograms(random.nextInt(MAX_WEIGHT - MIN_WEIGHT) + MIN_WEIGHT);
        account.setWeightMeasure(WeightMeasure.KILOGRAMS);
        account.setKilograms(random.nextInt(5));

        return account;
    }

}
