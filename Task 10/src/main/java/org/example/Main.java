package org.example;

import java.sql.*;

public class Main {
    private static Connection connection;
    private static Statement statement;

    public static void main(String[] args) {
//        create_table();
//     insert_data();
          task();
    }
    public static void create_table() {
        try {
            connect();
            statement.execute("create table students(\n" +
                    "id serial NOT NULL PRIMARY KEY,  \n" +
                    "name varchar NOT NULL,  \n" +
                    "passport_series int NOT NULL,  \n" +
                    "passport_number int NOT NULL, \n" +
                    "UNIQUE(passport_series, passport_number) \n" +
                    ")");

            statement.execute("create table subjects(\n" +
                    "id serial NOT NULL, \n" +
                    "namesubjects varchar NOT NULL PRIMARY KEY \n" +
                    ")");

            statement.execute("create table progress(\n" +
                    "id serial NOT NULL PRIMARY KEY,\n" +
                    "student int NOT NULL  REFERENCES students(id) ON DELETE CASCADE,\n" +
                    "subject varchar NOT NULL,\n" +
                    "FOREIGN KEY (subject) REFERENCES subjects(namesubjects) ON DELETE CASCADE," +
                    "mark smallint NOT NULL \n" +
                    "CHECK(mark >= 2 AND mark <= 5)" +
                    ");");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            disconnection();
        }
    }

    public static void insert_data() {
        try {
            connect();

            statement.execute("insert into students(id, name, passport_series, passport_number)\n"+
                    "values\n" +
                    "(1, 'Дмитрий', 4546, 123465),\n" +
                    "(2, 'Денис', 4566, 123746),\n" +
                    "(3, 'Максим', 3321, 123456),\n" +
                    "(4, 'Георгий', 4567, 124746),\n" +
                    "(5, 'Андрей', 5565, 654123);");


            statement.execute("insert into subjects(id, namesubjects)\n" +
                    "values\n" +
                    "    (1, 'Физика'),\n" +
                    "    (2, 'Русский язык'),\n" +
                    "    (2, 'Математика'),\n" +
                    "    (4, 'Информатика');");

            statement.execute("insert into progress(id, student, subject, mark)\n" +
                    "values \n" +
                    "    (1, 1,'Физика', 5),\n" +
                    "    (2, 2, 'Физика', 3),\n" +
                    "    (3, 3, 'Физика', 4),\n" +
                    "    (5, 5, 'Физика', 4),\n" +
                    "    (6, 1, 'Русский язык', 5),\n" +
                    "     (7, 2, 'Русский язык', 5),\n" +
                    "    (8, 3, 'Русский язык', 5),\n" +
                    "    (9, 4, 'Русский язык', 4),\n" +
                    "    (10, 5, 'Русский язык', 5),\n" +
                    "     (11, 1, 'Математика', 5),\n" +
                    "    (12, 2, 'Математика', 2),\n" +
                    "    (13, 3, 'Математика', 5),\n" +
                    "    (14, 4, 'Математика', 4),\n" +
                    "    (15, 5, 'Математика', 5),\n" +
                    "    (16, 1, 'Информатика', 5),\n" +
                    "    (17, 2, 'Информатика', 5),\n" +
                    "    (18, 3, 'Информатика', 4),\n" +
                    "    (19, 4, 'Информатика', 3),\n" +
                    "    (20, 5, 'Информатика', 4)");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            disconnection();
        }
    }

    public static void task() {
        try {
            connect();

            System.out.println("Студенты сдавшие физику больше чем на три: ");
            ResultSet rs = statement.executeQuery("SELECT students.id, students.name, progress.mark\n" +
                    "FROM students\n" +
                    "         JOIN progress ON students.id = progress.student\n" +
                    "WHERE progress.subject = 'Физика' AND progress.mark > 3;");
            while (rs.next()) {
                String name = rs.getString("name");
                int st_id = rs.getInt("id");
                System.out.println(name + " id = " + st_id);
            }
            System.out.println();
            System.out.println("Средний балл по Математике: ");
            rs = statement.executeQuery("SELECT AVG(p.mark) AS \"Средний балл\"\n" +
                    "FROM progress p\n" +
                    "         INNER JOIN subjects s ON p.subject = s.namesubjects\n" +
                    "WHERE s.namesubjects = 'Математика';");
            while (rs.next()) {
                System.out.println(rs.getFloat("Средний балл"));
            }
            System.out.println();
            System.out.println("Средний балл Димы: ");
            rs = statement.executeQuery("SELECT students.name, AVG(progress.mark) AS \"Средний балл\"\n" +
                    "FROM students\n" +
                    "         JOIN progress ON students.id = progress.student\n" +
                    "WHERE students.name = 'Дмитрий'\n" +
                    "GROUP BY students.name;");
            while (rs.next()) {
                System.out.println(rs.getFloat("Средний балл"));
            }

            rs = statement.executeQuery("SELECT subject, COUNT(*) AS succes\n" +
                    "FROM progress\n" +
                    "WHERE progress.mark > 2\n" +
                    "GROUP BY subject ORDER BY succes DESC\n" +
                    "limit 3;");
            while (rs.next()) {
                String subject = rs.getString("subject");
                int succes = rs.getInt("succes");
                System.out.println(subject + " - " + "сдало " + succes + " человек(а)");
            }
            System.out.println();
            System.out.println("Студенты на стипендии:");
            rs = statement.executeQuery("SELECT s.id, s.name\n" +
                    "FROM students s\n" +
                    "WHERE s.id NOT IN (\n" +
                    "    -- Подзапрос для студентов с оценками ниже 4\n" +
                    "    SELECT p1.student\n" +
                    "    FROM progress p1\n" +
                    "    WHERE p1.mark < 4\n" +
                    ")\n" +
                    "  AND s.id IN (\n" +
                    "    -- Подзапрос для студентов, которые имеют оценки по всем предметам\n" +
                    "    SELECT p2.student\n" +
                    "    FROM progress p2\n" +
                    "    GROUP BY p2.student\n" +
                    "    HAVING COUNT(*) = (\n" +
                    "        -- Подзапрос для подсчета количества уникальных предметов\n" +
                    "        SELECT COUNT(DISTINCT subject)\n" +
                    "        FROM progress\n" +
                    "    )\n" +
                    ")\n" +
                    "order by id asc ;");
            while (rs.next()) {
                String st_name = rs.getString("name");
                int st_id = rs.getInt("id");
                System.out.println(st_name + " id = " + st_id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            disconnection();
        }
    }

    public static void connect() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "32815");
            statement = connection.createStatement();

        } catch (ClassNotFoundException | SQLException e) {
            throw new SQLException("Не удалось подключиться");
        }
    }

    public static void disconnection() {
        try {
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

