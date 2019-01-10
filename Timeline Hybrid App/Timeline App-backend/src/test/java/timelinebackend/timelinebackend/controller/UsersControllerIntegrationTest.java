package timelinebackend.timelinebackend.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import java.sql.*;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class UsersControllerIntegrationTest {

    Connection conn;
    PreparedStatement pstmt;
    Statement stmt;
    ResultSet rs;
    UsersController usersController;

    @Before
    public void setup() throws Exception {
        usersController = new UsersController();
    }

    @Test
    public void get_connection() throws Exception{

        Connection connection = usersController.getConnection();
        Assert.assertNotNull(connection);
    }

    @Test
    public void add_user_success() throws Exception {

        String json = "{\"username\":\"765\",\"password\":\"765\"}";

        boolean check = usersController.addUser(json);
        Assert.assertTrue(check);
    }

    @Test
    public void add_user_fail() throws Exception {

        String json = "{\"username\":\"123\",\"password\":\"123\"}";

        boolean check = usersController.addUser(json);
        Assert.assertFalse(check);

    }

    @Test
    public void check_if_user_existed_return_true() throws Exception {

        String json = "{\"username\":\"123\",\"password\":\"123\"}";
        boolean check = usersController.checkIfUserExisted(json);
        Assert.assertTrue(check);
    }

    @Test
    public void check_if_user_existed_return_false() throws Exception {

        String json = "{\"username\":\"mmm\",\"password\":\"mmm\"}";
        boolean check = usersController.checkIfUserExisted(json);
        Assert.assertFalse(check);

    }

    @Test
    public void login_user_return_true() throws Exception {

        String json = "{\"username\":\"123\",\"password\":\"123\"}";
        boolean check = usersController.loginUser(json);
        Assert.assertTrue(check);

    }

    @Test
    public void login_user_return_false() throws Exception {

        String json = "{\"username\":\"987\",\"password\":\"987\"}";
        boolean check = usersController.loginUser(json);
        Assert.assertFalse(check);

    }

}