package org.example;

import java.lang.reflect.Field;
import java.sql.*;

public class Annotation {

    public static void createTable(Object obj) throws SQLException {
        Table table = obj.getClass().getAnnotation(Table.class);//Получаем аннотацию table
        StringBuilder sql = new StringBuilder("CREATE TABLE " + table.title() + " (");//sql запрос для создания таблицы
        StringBuilder sqlDEL = new StringBuilder("DROP TABLE IF EXISTS " + table.title() + ";");//sql запрос для удаления таблицы
        Field[] fields = obj.getClass().getDeclaredFields();
        //Если есть аннотация Column добавляем к sql запросу
        for (Field field : fields) {
            if (field.isAnnotationPresent(Column.class)) {
                sql.append(field.getName()).append(" ");

                //определяем тип поля
                if (field.getType().getSimpleName().equals("int")) {
                    sql.append("INTEGER");
                }
                else {
                    sql.append("TEXT");
                }
                sql.append(",");
            }
        }

        sql.deleteCharAt(sql.length() - 1);
        sql.append(");");
        //================================================
        Connection connection = null;
        try{
            connection = DriverManager.getConnection("jdbc:sqlite:identifier.sqlite");
            Statement statement = connection.createStatement();
            statement.execute(sqlDEL.toString());
            statement.execute(sql.toString());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            connection.close();
        }
    }
    public static void insertIntoTable(Object obj) throws SQLException {
        String tableName = obj.getClass().getAnnotation(Table.class).title();//sql запрос для вставки в таблицу
        Field[] fields = obj.getClass().getDeclaredFields(); // получаем все поля класса объекта
        StringBuilder query = new StringBuilder("INSERT INTO " + tableName + " (");
        for (Field field : fields) {
            if (field.isAnnotationPresent(Column.class)) {
                query.append(field.getName()).append(",");
            }
        }
        query.deleteCharAt(query.length() - 1).append(") VALUES (");
        for (Field field : fields) {
            if (field.isAnnotationPresent(Column.class)) {
                field.setAccessible(true);
                try {
                    query.append("'").append(field.get(obj)).append("',");
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        query.deleteCharAt(query.length() - 1).append(")");
        //================================================
        Connection connection = null;
        try{
            connection = DriverManager.getConnection("jdbc:sqlite:identifier.sqlite");
            Statement statement = connection.createStatement();
            statement.execute(query.toString());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            connection.close();
        }
    }
}
