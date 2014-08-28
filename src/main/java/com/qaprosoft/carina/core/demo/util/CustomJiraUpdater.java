package com.qaprosoft.carina.core.demo.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import net.rcarz.jiraclient.Field;
import net.rcarz.jiraclient.Issue;
import net.rcarz.jiraclient.JiraClient;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestResult;

import com.qaprosoft.carina.core.foundation.jira.IJiraUpdater;
import com.qaprosoft.carina.core.foundation.report.TestResultItem;
import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.Configuration.Parameter;

public class CustomJiraUpdater implements IJiraUpdater
{
	protected static final Logger LOG = Logger.getLogger(CustomJiraUpdater.class);
	
	@Override
	public void updateAfterTest(JiraClient jira, ITestResult result) 
	{
		try
		{
			String description = result.getMethod().getDescription();
			// Check if test description has JIRA id
			if(!StringUtils.isEmpty(description) && description.contains("JIRA#"))
			{
				String id = description.split("#")[1];
				// Retrieve Jira issue using client
				Issue issue = jira.getIssue(id);
				if("Done".equals(issue.getStatus().getName()))
				{
					// Reopen issue
					issue.transition().execute("Reopen and start progress");
				}
				String date = new SimpleDateFormat(Configuration.get(Parameter.DATE_FORMAT)).format(new Date());
				// PASS
				if(result.getStatus() == 1)
				{
					// If test passed - press done, and add comment
					issue.transition().execute("Done");
					issue.addComment("PASSED at " + date);
				}
				// FAIL
				else
				{
					// If test failed - populated description with details and add comment
					issue.update().field(Field.DESCRIPTION, result.getThrowable().getMessage()).execute();
					issue.addComment("FAILED at " + date);
				}
			}
		}
		catch(Exception e)
		{
			LOG.error("Jira status not updated: " + e.getMessage());
		}
	}

	@Override
	public void updateAfterSuite(JiraClient arg0, ITestContext arg1, List<TestResultItem> arg2) throws Exception
	{
		// TODO Auto-generated method stub
	}
}
