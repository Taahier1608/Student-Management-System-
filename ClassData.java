package Students;

import java.sql.*;

public class ClassData {
    public static void displayClassData(int classId) {
        String tableName = "Class_" + (char) ('A' + classId - 1);
        try (
        	    Connection connection = DatabaseManager.getConnection();
        	    Statement statement = connection.createStatement();
        	) {
        	    System.out.println("\nData of " + tableName + ":");
        	    String query = "SELECT * FROM " + tableName;
        	    ResultSet resultSet = statement.executeQuery(query);
        	   
        	    System.out.println("Roll Number\t\tName\t\tAge\t\tMarks\t\tGrade\t\tCity");
        	    while (resultSet.next()) {
        	        int rollNum = resultSet.getInt("Roll_Num");
        	        String name = resultSet.getString("Name");
        	        int age = resultSet.getInt("Age");
        	        double marks = resultSet.getDouble("Marks");
        	        String grade = resultSet.getString("Grade");
        	        String city = resultSet.getString("City");
        	        
        	        System.out.println(rollNum + "\t\t" + name + "\t\t" + age + "\t\t" + marks + "\t\t" + grade + "\t\t" + city);
        	       
        	    }
        	} catch (SQLException e) {
        	    e.printStackTrace();
        	}
        UpdateData.updateData();
    }
}

