package com.sannikov.objects.pages;

import com.sannikov.objects.AbstractBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.htmlelements.annotations.Block;

@Component
@Block(@FindBy(css = "body"))
public class LoginPage extends AbstractBase {

    private final static String uRL = "https://instr.by/sign-in";

    @FindBy(css = ".alert-warning")
    private WebElement alertWrongNameOrPassword;
    @FindBy(id = "username")
    private WebElement userNameBar;
    @FindBy(id = "password")
    private WebElement password;
    @FindBy(id = "remember")
    private WebElement rememberMeBox;
    @FindBy(css = "button[type='submit']")
    private WebElement submitButton;

    public String getURL() {
        return uRL;
    }

    public WebElement getUserNameBar() {
        return userNameBar;
    }

    public WebElement getPasswordBar() {
        return password;
    }

    public WebElement getRememberMeBox() {
        return rememberMeBox;
    }

    public WebElement getSubmitButton() {
        return submitButton;
    }

    public WebElement getAlertWrongNameOrPassword() {
        return alertWrongNameOrPassword;
    }

}
