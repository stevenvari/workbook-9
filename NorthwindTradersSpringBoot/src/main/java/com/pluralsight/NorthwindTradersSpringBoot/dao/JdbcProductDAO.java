package com.pluralsight.NorthwindTradersSpringBoot.dao;

import com.pluralsight.NorthwindTradersSpringBoot.model.Product;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcProductDAO implements ProductDAO {
   private DataSource dataSource;

    public JdbcProductDAO(BasicDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Product> getAll() {
        String sql = """
                select *
                from products
                """;
        List<Product> products = new ArrayList<>();

        try (

                Connection connection = dataSource.getConnection();

                PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {

            try (ResultSet resultSet = preparedStatement.executeQuery()) {


                //loop through the results and display them
                while (resultSet.next()) {
                    int productId = resultSet.getInt("productid");
                    String productName = resultSet.getString("productname");
                    Double unitPrice = resultSet.getDouble("unitprice");
                    int unitsInStock = resultSet.getInt("unitsinstock");

                    Product product = new Product(productId, productName, unitPrice);
                    products.add(product);

                }
            }

        } catch (SQLException e) {
            //display user friendly error message
            System.out.println("There was an error retrieving the products. Please try again or contact support");
            //display error message for developer
            e.printStackTrace();
        }
        return products;
    }

    public List<Product> searchProducts(String searchLetter) {
        //create a SQL statement/query
        String sql = """
                 select *
                 from products
                 where ProductName like ?;
                """;

        List<Product> products = new ArrayList<>();

        try (
                //create a connection
                Connection connection = dataSource.getConnection();
                // create a SQL statement
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {
            // execuete the statement/query
            preparedStatement.setString(1, searchLetter);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {

                //loop through the results and display them
                while (resultSet.next()) {
                    int productId = resultSet.getInt("productid");
                    String productName = resultSet.getString("productname");
                    Double unitPrice = resultSet.getDouble("unitprice");
                    int unitsInStock = resultSet.getInt("unitsinstock");
                    Product product = new Product(productId, productName, unitPrice);
                    products.add(product);

                    //print row
                    System.out.printf("%-4d %-40s %15.2f %n", productId, productName, unitPrice);
                }
            }

        } catch (SQLException e) {
            //display user friendly error message
            System.out.println("There was an error retrieving the products. Please try again or contact support");
            //display error message for developer
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public Product add(Product product) {
        return null;
    }
}
