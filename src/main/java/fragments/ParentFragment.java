package fragments;

import libs.ActionsWithOurWebElements;
import libs.UIMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ParentFragment {
    protected WebDriver webDriver;
    protected ActionsWithOurWebElements actionsWithOurWebElements;
    protected UIMap datafile;


    public ParentFragment(WebDriver webDriver) {
        this.webDriver = webDriver;
        actionsWithOurWebElements = new ActionsWithOurWebElements(webDriver);
        PageFactory.initElements(webDriver, this);
        datafile = new UIMap("src/datafile.properties");
    }
}
