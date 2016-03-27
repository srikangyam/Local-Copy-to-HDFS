package com.skangyam.hadoop.copyFromLocal;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.io.IOException;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;


/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     * @throws IOException 
     * @throws URISyntaxException 
     */
    public void testApp() throws IOException, URISyntaxException
    {
    	//Path source = new Path(System.getProperty("/user/skangyam/input/core-site.xml"));
    	
        assertTrue( ifExists() );
    }
    
    public static boolean ifExists () throws IOException, URISyntaxException{
    	 
    	Configuration config = new Configuration();
    	config.addResource(new Path("/user/skangyam/input/core-site.xml"));
    	config.addResource(new Path("/user/skangyam/input/hdfs-site.xml"));
    	config.addResource(new Path("/user/skangyam/input/mapred-site.xml"));
    	config.set("fs.default.name", "hdfs://localhost:8020");
    	 
    	FileSystem hdfs = FileSystem.get(config);
    	Path source = new Path(System.getProperty("searchKey"));
    	
    	System.out.println("Path to be searched is:" + source);
    	boolean isExists = hdfs.exists(source);
    	return isExists;
    	}
}
