package timelinebackend.timelinebackend.controller;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.*;
import com.alibaba.fastjson.JSONObject;
import timelinebackend.timelinebackend.MySqlConnector;
import java.sql.*;

/**
 * @Author: Fang Kun
 */

@RestController
@RequestMapping("/users")
public class UsersController {

    private Logger logger;
    private MySqlConnector mySqlConnector = new MySqlConnector();
    private String userName = "username";
    private String passWord = "password";

    public UsersController() throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
    }

    protected Connection getConnection() throws SQLException {
        Connection conn = null;
        conn = DriverManager.getConnection(mySqlConnector.getDB_URL(),
                mySqlConnector.getUSER(),
                mySqlConnector.getPASS());
        conn.setAutoCommit(false);
        return conn;
    }

    @PostMapping("register")
    @CrossOrigin(origins ="*")
    public boolean addUser(@RequestParam("message") String message){

        JSONObject user= JSON.parseObject(message);
        String password=user.get(passWord).toString();
        String username=user.get(userName).toString();

        if(checkIfUserExisted(message)==true) {
            return false;
        }
        else{
            Connection conn = null;
            PreparedStatement pstmt = null;
            try {
                conn = getConnection();
                String sql2 = "insert into users values (?,?)";
                pstmt = conn.prepareStatement(sql2);
                pstmt.setString(1, username);
                pstmt.setString(2, password);
                pstmt.executeUpdate();
                conn.commit();

            } catch (SQLException e) { logger.info("err", e); }
            finally {
                try {
                    if (pstmt != null) {
                        pstmt.close();
                    }
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException se) { logger.info("err", se); }
            }
        }
        return true;
    }

    protected boolean checkIfUserExisted(String message){

        JSONObject user= JSON.parseObject(message);
        String username=user.get(userName).toString();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try{
            conn = getConnection();
            stmt = conn.createStatement();
            String sql1 = "SELECT username FROM users WHERE username='" + username + "'";
            rs = stmt.executeQuery(sql1);
            if(rs.next()){
                return true;
            }
        } catch(SQLException e){ logger.info("err",e); }
        finally{
            try{
                if(rs != null) {
                    rs.close();
                }
                if(stmt != null) {
                    stmt.close();
                }
                if(conn != null) {
                    conn.close();
                }
            }catch(SQLException se1){ logger.info("err",se1); }
        }
        return false;
    }

    @PostMapping("login")
    @CrossOrigin(origins ="*")
    public boolean loginUser(@RequestParam("message") String message){

        JSONObject user= JSON.parseObject(message);
        String username=user.get(userName).toString();
        String password=user.get(passWord).toString();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try{
            conn = getConnection();
            stmt = conn.createStatement();
            String sql3 = "SELECT username, password FROM users WHERE username='" + username + "' and password='" + password + "'";
            rs = stmt.executeQuery(sql3);
            if(rs.next()){
                return true;
            }
        } catch(SQLException e){ logger.info("err",e); }
        finally{
            try{
                if(rs != null) {
                    rs.close();
                }
                if(stmt != null) {
                    stmt.close();
                }
                if(conn != null) {
                    conn.close();
                }
            }catch(SQLException se1){ logger.info("err",se1); }
        }
        return false;
    }
}