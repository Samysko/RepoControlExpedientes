/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.sql.*;

/**
 *
 * @author TechM User
 */
public class DataSource {
        public Connection getConexion(){
            System.out.println("obteniendoconexion");
            Connection c=null;
            try{
                Class.forName("com.mysql.jdbc.Driver");
                c=DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb","root","root");
            }
            catch(Exception e){
                e.printStackTrace();
            }
            return c;
    }
}
