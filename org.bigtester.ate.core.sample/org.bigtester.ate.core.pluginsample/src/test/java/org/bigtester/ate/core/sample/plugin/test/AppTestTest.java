package org.bigtester.ate.core.sample.plugin.test;

import java.net.MalformedURLException;
import java.sql.SQLException;

import org.bigtester.ate.TestProjectRunner;
import org.dbunit.DatabaseUnitException;
import org.testng.annotations.Test;

public class AppTestTest {

  @Test
  public void AppTest() throws MalformedURLException, DatabaseUnitException, SQLException {
	  TestProjectRunner.runTest("testproject/testproject.xml");
  }
}
