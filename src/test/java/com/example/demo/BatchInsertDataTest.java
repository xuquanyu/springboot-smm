//package com.example.demo;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.util.Random;
//
//@SpringBootTest
//public class BatchInsertDataTest {
//
//    private String url = "jdbc:mysql://localhost:3306/testdb?rewriteBatchedStatements=true&characterEncoding=utf-8" +
//            "&serverTimezone=UTC";
//    private String user = "root";
//    private String password = "admin";
//
//    @Test
//    public void Test() {
//        Connection conn = null;
//        PreparedStatement pstm = null;
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            conn = DriverManager.getConnection(url, user, password);
//            String sql = "INSERT INTO userinfo(uid,uname,uphone,uaddress) VALUES(?,CONCAT('姓名',?),?,?)";
//            pstm = conn.prepareStatement(sql);
//            //关闭事务自动提交
//            conn.setAutoCommit(false);
//            Long startTime = System.currentTimeMillis();
//            Random rand = new Random();
//            int a, b, c, d;
//            for (int i = 1; i <= 1000000; i++) {
//                pstm.setInt(1, i);
//                pstm.setInt(2, i);
//                a = rand.nextInt(10);
//                b = rand.nextInt(10);
//                c = rand.nextInt(10);
//                d = rand.nextInt(10);
//                pstm.setString(3, "188" + a + "88" + b + c + "66" + d);
//                pstm.setString(4, "xxxxxxxxxx_" + "188" + a + "88" + b + c + "66" + d);
//                pstm.addBatch();
//            }
//            //批处理
//            pstm.executeBatch();
//            //提交事务
//            conn.commit();
//            Long endTime = System.currentTimeMillis();
//            System.out.println("OK 耗时：" + (endTime - startTime) + "毫秒");
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new RuntimeException(e);
//        } finally {
//            if (pstm != null) {
//                try {
//                    pstm.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                    throw new RuntimeException(e);
//                }
//            }
//            if (conn != null) {
//                try {
//                    conn.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                    throw new RuntimeException(e);
//                }
//            }
//        }
//    }
//
//}
