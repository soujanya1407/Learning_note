package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReadData {
    private  String name;
    private  String phoneNo;
    private  String email;

    List<String> validRow = new ArrayList<String>();
    List<String> invalidRow = new ArrayList<String>();



    public void read() throws IOException
    {
        // list that holds strings of a file
        List<String> listOfStrings = new ArrayList<String>();

        // load data from file
        BufferedReader bf = new BufferedReader(new FileReader("Data.txt"));

        // read entire line as string
        String line = bf.readLine();

        // checking for end of file
        while (line != null) {
            listOfStrings.add(line);
            line = bf.readLine();
        }

        // closing bufferreader object
        bf.close();

        for(String lt: listOfStrings)
        {
            //System.out.println(lt);
            String line1 = lt.replace(',', ' ');
            String val1[] =line1.trim().split("[\\s']");




            if(val1.length==3  )
            {
                name = val1[0];
                phoneNo = val1[1];
                email = val1[2];



                //execute db operation for inserting the data
                try {
                    if(phoneNo.length()==10  &&  email.contains("@")) {
                        System.out.println("Name:"+name+'\n'+"phoneNo: "+phoneNo+'\n'+"email: "+email+'\n');
                        validRow.add(line1);
                        saveData();
                    }
                    else
                    {
                        System.out.println("row entry is not proper: "+lt+'\n');
                        invalidRow.add(line1);
                    }

                } catch (ClassNotFoundException e) {

                    e.printStackTrace();
                }
            }
            else
            {
                System.out.println("row entry is not proper: "+lt+'\n');

                invalidRow.add(line1);
            }

        }

        // write Sucess row to the text.
        FileWriter file1 = new FileWriter("Success.txt");
        for(String st: validRow)
        {
            System.out.println("valid row: "+st);
            file1.write(st+'\n');
        }
        file1.close();


        // write failure row to the text.
        FileWriter file = new FileWriter("Failure.txt");
        for(String st: invalidRow)
        {
            file.write(st+'\n');
        }




        file.close();

    }
    public void saveData() throws ClassNotFoundException {
        String INSERT_USERS_SQL = "INSERT INTO customer" + "  (name , phoneNo , email) VALUES " + " (?, ?, ?);";
        Class.forName("com.mysql.cj.jdbc.Driver");
        //System.out.println("test jdbc");
        int result =0;

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hpsa?useSSL=false", "root", "root");
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL))
        {
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,phoneNo);
            preparedStatement.setString(3,email);

            result = preparedStatement.executeUpdate();
        }

        catch (SQLException e) {

            e.printStackTrace();
        }

    }


}
