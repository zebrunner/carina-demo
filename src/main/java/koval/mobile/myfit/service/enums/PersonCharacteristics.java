package koval.mobile.myfit.service.enums;

import com.qaprosoft.carina.core.gui.AbstractPage;
import koval.mobile.myfit.gui.common.aboutMePages.BirthdayPageBase;
import koval.mobile.myfit.gui.common.aboutMePages.GenderPageBase;
import koval.mobile.myfit.gui.common.aboutMePages.HeightPageBase;
import koval.mobile.myfit.gui.common.aboutMePages.WeightPageBase;

public enum PersonCharacteristics {
    GENDER("gender", 0, GenderPageBase.class),
    BIRTHDAY("birthday", 1, BirthdayPageBase.class),
    WEIGHT("weight", 2, WeightPageBase.class),
    HEIGHT("height", 3, HeightPageBase.class);


    public final String characteristic;
    public final int characteristicIndex;
    private final Class<? extends AbstractPage> className;

    PersonCharacteristics(String characteristic, int characteristicIndex, Class<? extends AbstractPage> className) {
        this.characteristic = characteristic;
        this.characteristicIndex = characteristicIndex;
        this.className = className;
    }


    public String getCharacteristic() {
        return characteristic;
    }

    public int getCharacteristicIndex() {
        return characteristicIndex;
    }

    public Class<? extends AbstractPage> getClassName() {
        return className;
    }
}
