package fr.ecolenum.dd.database;

import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;

public class DatabaseTest {
    @Test
    public void testDatabaseGetInstance() {
        Connection connection = Database.databaseGetInstance();
        Assert.assertNotNull("The connection must not be zero.", connection);

        try {
            Assert.assertTrue("The connection must be valid.", connection.isValid(5));
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("The connection is not valid.");
        }
        System.out.println("Test passed: Obtain a database connection instance.");
    }
}