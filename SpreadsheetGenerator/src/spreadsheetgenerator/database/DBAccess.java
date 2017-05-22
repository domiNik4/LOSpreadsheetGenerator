/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spreadsheetgenerator.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author D33
 */
public class DBAccess {
    
    private static final String USERNAME="root";
    private static final String PASSWORD="";
    private static final String DBNAME="world_x";
    private static final String URL="jdbc:mysql://localhost/";
    
    private Connection getConnection (){
        Connection c =null;
        try{
            
            c = DriverManager.getConnection(URL+DBNAME, USERNAME , PASSWORD);
        }catch(SQLException ex){
            System.out.println("Error:" + ex.toString());
        }
        return c;
    }
    
    public List<Object[]> getAllCities(){
        List<Object[]>cities=new ArrayList();
        Connection c=getConnection();
        String query="select * from city";
        
        if(c!=null){
            try{
                ResultSet rs = c.createStatement().executeQuery(query);
                while(rs.next()){
                    Object[] city=new Object[5];
                    city[0]=rs.getInt("ID");
                    city[1]=rs.getString("Name");
                    city[2]=rs.getString("CountryCode");
                    city[3]=rs.getString("District");
                    city[4]=rs.getString("Info");
                    cities.add(city);
                }
            }catch(SQLException e){
                System.out.println("Error: "+ e.toString());
            }
        }

        return cities;
    }
    
    public List<Object[]> getAllCountries(){
        List<Object[]>countries=new ArrayList();
        Connection c=getConnection();
        String query="select * from country";
        
        if(c!=null){
            try{
                ResultSet rs = c.createStatement().executeQuery(query);
                while(rs.next()){
                    Object[] country=new Object[3];
                    country[0]=rs.getString("Code");
                    country[1]=rs.getString("Name");
                    country[2]=rs.getString("Capital");
                    countries.add(country);
                }
            }catch(SQLException e){
                System.out.println("Error: "+ e.toString());
            }
        }

        return countries;
    }
    
    
}
