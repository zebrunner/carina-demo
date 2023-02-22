package koval.myfit.mobile.service.enums;

import com.qaprosoft.carina.core.gui.AbstractPage;
import koval.myfit.mobile.gui.common.aboutMePages.BirthdayPageBase;
import koval.myfit.mobile.gui.common.aboutMePages.GenderPageBase;
import koval.myfit.mobile.gui.common.aboutMePages.HeightPageBase;
import koval.myfit.mobile.gui.common.aboutMePages.WeightPageBase;
import koval.myfit.mobile.gui.common.downMenuPages.BrowsePageBase;
import koval.myfit.mobile.gui.common.downMenuPages.HomePageBase;
import koval.myfit.mobile.gui.common.downMenuPages.JournalPageBase;
import koval.myfit.mobile.gui.common.downMenuPages.ProfilePageBase;

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
