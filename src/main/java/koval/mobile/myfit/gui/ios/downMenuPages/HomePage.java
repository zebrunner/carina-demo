package koval.mobile.myfit.gui.ios.downMenuPages;


import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.mobile.myfit.gui.common.loginPages.WelcomePageBase;
import koval.mobile.myfit.gui.common.downMenuPages.HomePageBase;
import koval.mobile.myfit.gui.common.modal.PlusButtonModalBase;
import koval.mobile.myfit.service.enums.DownMenuElement;
import koval.mobile.myfit.service.enums.MaterialCardTopics;
import koval.mobile.myfit.service.enums.PlusButtonMenuElement;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.List;


@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        throw new NotImplementedException();
    }

    @Override
    public boolean isPageOpened(Long timeout) {
        throw new NotImplementedException();
    }

    @Override
    public WelcomePageBase signOut() {
        throw new NotImplementedException();
    }

    @Override
    public AbstractPage openPageFromDownMenuByName(DownMenuElement downMenuElement) {
        throw new NotImplementedException();
    }


    @Override
    public boolean isPlusBtnStatic() {
        throw new NotImplementedException();
    }

    @Override
    public boolean isPlusBtnOverElements() {
        throw new NotImplementedException();
    }

    @Override
    public AbstractPage openPageFromPlusButtonMenuByName(PlusButtonMenuElement plusButtonMenuElement) {
        throw new NotImplementedException();
    }

    @Override
    public HomePageBase closePlusButtonMenu() {
        throw new NotImplementedException();
    }

    @Override
    public PlusButtonModalBase openPlusButtonMenu() {
        throw new NotImplementedException();
    }

    @Override
    public boolean isPlusButtonBelowBlockContainer() {
        throw new NotImplementedException();
    }

    @Override
    public int getAccountImageColor() throws IOException {
        throw new NotImplementedException();
    }


    @Override
    public String getChartTitleColor(){
        throw new NotImplementedException();
    }

    @Override
    public String getHeartCardImage() {
        throw new NotImplementedException();
    }

    @Override
    public int getMetricValueListSize() {
        throw new NotImplementedException();
    }

    @Override
    public String getMetricValueColor(int i){
        throw new NotImplementedException();
    }

    @Override
    public String getHeartPtsLabelColor() {
        throw new NotImplementedException();
    }

    @Override
    public String getHeartPointsTitleColor()   {
        throw new NotImplementedException();
    }

    @Override
    public boolean isBlockByTitlePresent(MaterialCardTopics topic) {
        throw new NotImplementedException();
    }

    @Override
    public List<String> getPlaylistTitlesToList() {
        throw new NotImplementedException();
    }


}
