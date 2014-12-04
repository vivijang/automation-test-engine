package org.bigtester.ate.core.sample.simplemaven;

import java.net.MalformedURLException;
import java.sql.SQLException;

import org.bigtester.ate.TestProjectRunner;
import org.dbunit.DatabaseUnitException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws MalformedURLException, DatabaseUnitException, SQLException
    {
    	TestProjectRunner.runTest("testproject/testproject.xml");
    }
}
