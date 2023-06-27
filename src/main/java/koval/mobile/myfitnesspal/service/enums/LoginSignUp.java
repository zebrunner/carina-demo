package koval.mobile.myfitnesspal.service.enums;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.resources.L10N;
import koval.mobile.myfitnesspal.gui.common.loginPages.LogInPageBase;
import koval.mobile.myfitnesspal.gui.common.loginPages.SignUpPageBase;


public enum LoginSignUp {
    LOGIN("logIn", LogInPageBase.class),
    SIGN_UP("signUp", SignUpPageBase.class);


    public final String stringValue;
    private final Class<? extends AbstractPage> className;

    LoginSignUp(String stringValue, Class<? extends AbstractPage> className) {
        this.stringValue = stringValue;
        this.className = className;
    }

    public String getStringValue() {
        return stringValue;
    }

    public Class<? extends AbstractPage> getClassName() {
        return className;
    }
}
