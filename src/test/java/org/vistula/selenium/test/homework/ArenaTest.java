package org.vistula.selenium.test.homework;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;


public class ArenaTest extends BaseAttribute {
    @Test
    public void logToArena () {
      ArenaHomePage arena = new ArenaHomePage(driver);
      String login = "administrator@testarena.pl";
      String password = "sumXQQ72$L";
      arena.enterDatatoLogIn(login, password);

      SearchResultPage searchResultPage = new SearchResultPage(driver);
      searchResultPage.waitForSidebarLink();
      searchResultPage.verifyLinkUrl("http://demo.testarena.pl/");

    }
    @Test
    public void enterAdminPanel(){
        ArenaHomePage arena = new ArenaHomePage(driver);
        String login = "administrator@testarena.pl";
        String password = "sumXQQ72$L";
        arena.enterDatatoLogIn(login, password);

        arena.enterAdminPanel();
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        searchResultPage.waitForSidebarLink();
        searchResultPage.verifyLinkUrl("http://demo.testarena.pl/administration/projects");

    }
    @Test
    public void addNewProject () {
        ArenaHomePage arena = new ArenaHomePage(driver);
        String login = "administrator@testarena.pl";
        String password = "sumXQQ72$L";
        arena.enterDatatoLogIn(login, password);

        arena.enterAdminPanel();
        String projectName = RandomStringUtils.randomNumeric(7);
        String projectPrefix = RandomStringUtils.randomNumeric(7);
        arena.addNewProject(projectName, projectPrefix );
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        searchResultPage.waitForSidebarLink();
        searchResultPage.verifyLinkUrlNotEquals("http://demo.testarena.pl/administration/adding_project");
    }
    @Test
    public  void enterToAllProjects (){
        ArenaHomePage arena = new ArenaHomePage(driver);
        String login = "administrator@testarena.pl";
        String password = "sumXQQ72$L";
        arena.enterDatatoLogIn(login, password);

        arena.enterAdminPanel();
        arena.enterToAllProjects();
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        searchResultPage.waitForSidebarLink();
        searchResultPage.verifyLinkUrl("http://demo.testarena.pl/administration/projects");

    }
    @Test
    public void searchForMyProject () {
        ArenaHomePage arena = new ArenaHomePage(driver);
        String login = "administrator@testarena.pl";
        String password = "sumXQQ72$L";
        arena.enterDatatoLogIn(login, password);

        arena.enterAdminPanel();
        String projectName = RandomStringUtils.randomNumeric(6);
        String projectPrefix = RandomStringUtils.randomNumeric(6);
        arena.addNewProject(projectName, projectPrefix );
        arena.enterToAllProjects();
        arena.searchForMyProject(projectName);

        String searchResult = arena.searchResultCheck();
        Assert.assertEquals(projectPrefix, searchResult);

    }

}

