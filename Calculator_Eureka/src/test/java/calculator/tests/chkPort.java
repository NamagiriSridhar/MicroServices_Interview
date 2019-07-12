package calculator.tests;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class chkPort {

	 private static HtmlUnitDriver browser;
@LocalServerPort
    private int port;
@Autowired
TestRestTemplate rest;

@BeforeClass
public static void setup() {
  browser = new HtmlUnitDriver();
  browser.manage().timeouts()
      .implicitlyWait(10, TimeUnit.SECONDS);
}

@AfterClass
public static void closeBrowser() {
  browser.quit();
}

    @Test
    public void printPort() throws Exception {
    	//System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&"+port);
        assertEquals(port, 8010);
    }

}
