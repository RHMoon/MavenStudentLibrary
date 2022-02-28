package com.devland.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.devland.Util.DatabaseConnector;

public class StudentRepository {
    private DatabaseConnector databaseConnector;
    private Connection connection;
    public StudentRepository(DatabaseConnector databaseConnector) {
        this.databaseConnector = databaseConnector;
        this.connection = this.databaseConnector.connect();
    }

    public void getAllStudent() {
        String sql = "SELECT * FROM student";
        try {
            Statement st = this.connection.createStatement();

            ResultSet resultSet = st.executeQuery(sql);

            System.out.println("Get All Students: ");

            this.printAllStudents(resultSet);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void getByID(int dbId) {
        String sql = "SELECT * FROM student WHERE ID =\'"+ dbId + "\' ";
        try {
            Statement st = this.connection.createStatement();

            ResultSet resultSet = st.executeQuery(sql);

            System.out.println("Get All Students with id '"+dbId+"': ");

            this.printAllStudents(resultSet);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void addStudent(String firstName, String lastName, int age) {
        try {
            PreparedStatement st = this.connection.prepareStatement("INSERT INTO student(first_name,last_name,age) VALUES(?, ?, ?)");
            st.setString(1, firstName);
            st.setString(2, lastName);
            st.setInt(3, age);
            st.executeUpdate();
            st.close();
            System.out.println("Student add successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void printAllStudents(ResultSet resultSet) {
        try {

            while (resultSet.next()) {

                int id = resultSet.getInt("id");

                String firstName = resultSet.getString("first_name");

                String lastName = resultSet.getString("last_name");

                int age = resultSet.getInt("age");



                String formatString = "%s - %s %s, %s";

                System.out.println(String.format(formatString, id, firstName, lastName, age));

            }

        }catch(SQLException exception) {

            System.out.println(exception.getMessage());

        }
    }

    
}
