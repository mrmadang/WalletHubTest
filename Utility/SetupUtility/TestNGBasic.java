package SetupUtility;

import org.testng.annotations.*;//BeforeClass;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeTest;

public class TestNGBasic
{
//Annotation start with @Before knows as Precondition-----
@BeforeSuite//Sequence 1
public void SetUp()
{
	System.out.println("Setup Systems properties for browser");
}

@BeforeTest //Sequence 2
public void LaunchBrowser()
{
	System.out.println("Launch browser");
}

@BeforeClass //Sequence 3
public void Login()
{
	System.out.println("Login to Site");
}

@BeforeMethod //Sequence 4
public void EnterURL()
{
	System.out.println("Enter URL");
}

//Annotation start with @Test knows as Test Condition
@Test ////Sequence 5
public void GetGoogleText()
{
	System.out.println("Test Google page");
}
@Test ////Sequence 5
public void GetGoogleText1()
{
	System.out.println("Test Google page1");
}
//Annotation start with @After knows as Post Condition
@AfterMethod ////Sequence 6
public void LogOut()
{
	System.out.println("Logout from Syste");
}

@AfterClass //Sequence 7
public void CloseBrowser()
{
	System.out.println("Close browser");
}
@AfterTest //Sequence 8
public void DeleteAllCookies()
{
	System.out.println("Delete all cookies");
}
@AfterSuite //Sequence 9
public void GenerateReport()
{
	System.out.println("Generate Report");
}
}
