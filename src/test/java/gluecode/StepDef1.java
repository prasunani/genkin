package gluecode;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.GooglePage;
import utilities.SiteUtility;

public class StepDef1 
{
	public Shared sh;
	//Dependency injection via constructor
	public StepDef1(Shared sh)
	{
		this.sh=sh;
	}
	//Step definitions
	@Given("open {string} browser")
	public void method1(String bn)
	{
		sh.u=new SiteUtility();
		sh.driver=sh.u.openBrowser(bn);
		sh.w=sh.u.defineWait(sh.driver,20,1000);
	}
	
	@When("i launch {string} site")
	public void method2(String url) throws Exception
	{
		
		sh.u.launchSite(sh.driver,"QA");
	}
	
	@Then("title should be {string}")
	public void method3(String expected) throws Exception
	{
		sh.obj=new GooglePage(sh.driver);
		if(sh.obj.verifyTitle(sh.driver, expected))
		{
			sh.s.log("Test passed");
		}
		else
		{
			sh.s.log("Test failed");
		}
	}
}
