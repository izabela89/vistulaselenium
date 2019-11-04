package org.vistula.selenium.test.homework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ArenaHomePage {
    private WebDriver driver;
    @FindBy(id="email")
    private WebElement email;
    @FindBy(id="password")
    private WebElement password;
    @FindBy(id="login")
    private WebElement login;
    @FindBy(className = "header_admin")
    private WebElement adminPanel;
    @FindBy(className = "button_link")
    private WebElement projectButton;
    @FindBy(id= "name")
    private WebElement name;
    @FindBy(id= "prefix")
    private WebElement prefix;
    @FindBy (id= "save")
    private WebElement save;
    @FindBy (className = "activeMenu")
    private WebElement allProjects;
    @FindBy (id = "search")
    private WebElement search;
    @FindBy (id = "j_searchButton")
    private WebElement searchButton;
    @FindBy (className = "t_number")
    private WebElement searchResultPrefix;



    public ArenaHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void enterDatatoLogIn(String log, String pass) {
        email.sendKeys(log);
        password.sendKeys(pass);
        login.click();
    }

    public void enterAdminPanel () {
        adminPanel.click();
    }
    public void addNewProject (String n, String p) {
        projectButton.click();
        name.sendKeys(n);
        prefix.sendKeys(p);
        save.click();
    }
    public void enterToAllProjects (){
        allProjects.click ();
    }
    public void searchForMyProject (String pr) {
        search.sendKeys(pr);
        searchButton.click();
    }
    public String searchResultCheck() {
        return searchResultPrefix.getText();
    }
}