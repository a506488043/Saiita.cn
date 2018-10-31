package Saiita.cn.Redmine;

import java.sql.SQLException;
import java.util.List;

import com.taskadapter.redmineapi.RedmineException;
import com.taskadapter.redmineapi.RedmineManager;
import com.taskadapter.redmineapi.RedmineManagerFactory;
import com.taskadapter.redmineapi.bean.Issue;

public class Test {
	public static void main(String[] args) throws SQLException, RedmineException {
		String uri = "http://redmine.ptq.com";
		String apiAccessKey = "c7ffc0e1d8a8006f615dc3b9c7c0747a4fa9c478";
		String projectKey = "ptq";
		Integer queryId = null; // any

		RedmineManager mgr = RedmineManagerFactory.createWithApiKey(uri, apiAccessKey);
		// override default page size if needed
		mgr.setObjectsPerPage(100);
		List<Issue> issues = mgr.getIssueManager().getIssues(projectKey, queryId);
		for (Issue issue : issues) {
			System.out.println(issue.toString());
		}
	}
}
