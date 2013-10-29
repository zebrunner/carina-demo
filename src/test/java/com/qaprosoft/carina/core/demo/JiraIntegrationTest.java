package com.qaprosoft.carina.core.demo;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.APITest;

public class JiraIntegrationTest extends APITest
{
	@Test(description="JIRA#KUL-1")
	@Parameters({ "oper1", "oper2", "expSum" })
	public void testSumOperation(String oper1, String oper2, String expSum) throws IOException
	{
		int expextedResult = Integer.valueOf(expSum);
		Assert.assertEquals(Integer.valueOf(oper1) + Integer.valueOf(oper2), expextedResult, "Unexpected sum result!");
	}
	
	@Test(description="JIRA#KUL-2")
	@Parameters({ "oper1", "oper2", "expMult" })
	public void testMultOperation(String oper1, String oper2, String expMult) throws IOException, InterruptedException
	{
		int expextedResult = Integer.valueOf(expMult);
		Assert.assertEquals(Integer.valueOf(oper1) * Integer.valueOf(oper2), expextedResult, "Unexpected multiply result!");
	}
}
