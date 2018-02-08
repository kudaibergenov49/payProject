package SQLConnector;

import type.Journal;
import java.sql.*;
import java.util.ArrayList;

public class QueryDB {

    /**
     *
     * @return все записи с БД
     */
    public static ArrayList<Journal> queryDB(){
        DBWorker dbWorker = new DBWorker();
        String query = "select * from journal;";
        ArrayList<Journal> tableInfo = new ArrayList<>();
        try(Connection connection = dbWorker.getConnection();
            Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                Journal journal = new Journal();
                journal.setNote(resultSet.getString(2));
                journal.setDate(resultSet.getString(3));
                tableInfo.add(journal);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tableInfo;
    }

    /**
     * Записывает в БД заметку
     * @param text Вводимая заметка
     */
    public static void insertIntoDB(String text,String currentDate){
        DBWorker dbWorker = new DBWorker();
        String insertIntoTable = "insert into journal (note,date) values('" +text+ "','" + currentDate + "');";

        try( Connection connection = dbWorker.getConnection();
             Statement statement = connection.createStatement();) {

                statement.executeUpdate(insertIntoTable);

            } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

}