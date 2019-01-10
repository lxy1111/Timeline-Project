package timelinebackend.timelinebackend.controller;

import org.junit.Assert;
import org.mockito.ArgumentCaptor;
import org.mockito.internal.verification.Times;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;
import java.sql.*;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class UsersControllerTest {

    @Mock
    Connection conn;

    @Mock
    PreparedStatement pstmt;

    @Mock
    Statement stmt;

    @Mock
    ResultSet rs;

    UsersController usersController;

    @Before
    public void setup() throws Exception {
        usersController = new TestableUsersController();
    }

    @Test
    public void get_connection() throws Exception{
        UsersController usersController1 = new UsersController();
        Connection connection = usersController1.getConnection();
        Assert.assertNotNull(connection);
    }

    @Test
    public void add_user_success() throws Exception {

        when(conn.prepareStatement(anyString())).thenReturn(pstmt);

        String json = "{\"username\":\"111\",\"password\":\"111\"}";

        boolean check = usersController.addUser(json);
        Assert.assertTrue(check);

        ArgumentCaptor<String> stringArgCaptor = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<Integer> intArgCaptor = ArgumentCaptor.forClass(Integer.class);
        verify(pstmt, new Times(2))
                .setString(intArgCaptor.capture(),stringArgCaptor.capture());

        assertEquals("111", stringArgCaptor.getAllValues().get(0));
        assertEquals("111", stringArgCaptor.getAllValues().get(1));

        verify(conn).prepareStatement(stringArgCaptor.capture());
        String sql2 = "insert into users values (?,?)";
        assertEquals(sql2, stringArgCaptor.getValue());

        verify(pstmt).executeUpdate();
        verify(conn).commit();
        verify(pstmt).close();
        verify(conn).close();

    }

    @Test
    public void add_user_fail() throws Exception {

        when(conn.prepareStatement(anyString())).thenReturn(pstmt);

        String json = "{\"username\":\"123\",\"password\":\"123\"}";

        boolean check = usersController.addUser(json);
        Assert.assertFalse(check);

    }

    @Test
    public void check_if_user_existed_return_true() throws Exception {

        UsersController usersController1 = new UsersController();
        when(conn.createStatement()).thenReturn(stmt);
        when(stmt.executeQuery(anyString())).thenReturn(rs);
        when(rs.next()).thenReturn(true);

        String json = "{\"username\":\"123\",\"password\":\"123\"}";
        boolean check = usersController1.checkIfUserExisted(json);
        Assert.assertTrue(check);
    }

    @Test
    public void check_if_user_existed_return_false() throws Exception {

        UsersController usersController1 = new UsersController();
        when(conn.createStatement()).thenReturn(stmt);
        when(stmt.executeQuery(anyString())).thenReturn(rs);
        when(rs.next()).thenReturn(false);

        String json = "{\"username\":\"mmm\",\"password\":\"mmm\"}";
        boolean check = usersController1.checkIfUserExisted(json);
        Assert.assertFalse(check);

    }

    @Test
    public void login_user_return_true() throws Exception {

        when(conn.createStatement()).thenReturn(stmt);
        when(stmt.executeQuery(anyString())).thenReturn(rs);
        when(rs.next()).thenReturn(true);

        String json = "{\"username\":\"123\",\"password\":\"123\"}";
        boolean check = usersController.loginUser(json);
        Assert.assertTrue(check);

    }

    @Test
    public void login_user_return_false() throws Exception {

        when(conn.createStatement()).thenReturn(stmt);
        when(stmt.executeQuery(anyString())).thenReturn(rs);
        when(rs.next()).thenReturn(false);

        String json = "{\"username\":\"123\",\"password\":\"123\"}";
        boolean check = usersController.loginUser(json);
        Assert.assertFalse(check);

    }

    class TestableUsersController extends UsersController {

        public TestableUsersController() throws ClassNotFoundException {
        }

        protected Connection getConnection() throws SQLException {
            return conn;
        }

        protected boolean checkIfUserExisted(String message){

            String json = "{\"username\":\"123\",\"password\":\"123\"}";

            if(message.equals(json)){
                return true;
            }else {
                return false;
            }
        }
    }

}