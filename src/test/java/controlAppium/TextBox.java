package controlAppium;

import org.openqa.selenium.By;

import java.net.MalformedURLException;

public class TextBox extends Control{
    public TextBox(By locator){
        super(locator);
    }
    public void typeValue(String value) throws MalformedURLException {
        this.findControl();
        this.control.sendKeys(value);
    }
    public void clearValue() throws MalformedURLException {
        this.findControl();
        this.control.clear();
        //this.control.sendKeys("");
    }
}
