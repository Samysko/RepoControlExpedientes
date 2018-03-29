/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author TechM User
 */
public class DataSource {
        public Connection getConexion(){
        Connection c=null;
            try{
                Class.forName("com.mysql.jdbc.Driver");
                c=DriverManager.getConnection("jdbc:mysql://localhost:3306/javaDB","root","unitec");
            }
            catch(Exception e){
                e.printStackTrace();
            }
            return c;
    }
}
