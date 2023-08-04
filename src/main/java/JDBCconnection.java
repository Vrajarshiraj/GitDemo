package main.java;

import com.mysql.cj.protocol.Resultset;
import io.github.bonigarcia.wdm.WebDriverManager;

import javax.xml.transform.Result;
import java.sql.*;

public class JDBCconnection
{
    public static void main(String[] args) throws SQLException {
        WebDriverManager.chromedriver().setup();
        String host="localhost";
        String port="3306";

        Connection conn=DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/etl","root","Vrajarshi@123");

        Statement s = conn.createStatement();
        ResultSet rs = s.executeQuery("select * from patient where patid='1'");


        while (rs.next())
        {
            System.out.println(rs.getString("fname")); //returns index of 1
            System.out.println(rs.getString("lname"));
        }

    }
}
