package timelinebackend.timelinebackend.controller;

import com.alibaba.fastjson.JSONArray;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.internal.verification.Times;
import org.springframework.test.context.junit4.SpringRunner;
import timelinebackend.timelinebackend.entity.News;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

@RunWith(SpringRunner.class)
public class NewsControllerTest {

    @Mock
    Connection conn;

    @Mock
    PreparedStatement pstmt;

    @Mock
    ResultSet rs;

    @Mock
    Statement stmt;

    NewsController newsController;

    @Before
    public void setup() throws Exception{
        newsController = new TestableNewsController();
    }

    @Test
    public void get_list() throws Exception{

        NewsController newsController1 = new NewsController();
        Assert.assertNotNull(newsController1.getList());
        Assert.assertNotNull(newsController1.getList0());
    }

    @Test
    public void set_list() throws Exception{

        List<News> list_test0 = new ArrayList<>();
        List<News> list_test = new ArrayList<>();

        NewsController newsController1 = new NewsController();
        newsController1.setList(list_test);
        newsController1.setList0(list_test0);
    }

    @Test
    public void get_connection() throws Exception{

        NewsController newsController1 = new NewsController();
        Connection connection = newsController1.getConnection();
        Assert.assertNotNull(connection);
    }

    @Test
    public void view_3_more_news() throws Exception {

        when(conn.createStatement()).thenReturn(stmt);
        when(stmt.executeQuery(anyString())).thenReturn(rs);
        when(rs.next()).thenReturn(true);

        List<News> list_size_5 = new ArrayList<>();
        List<News> list_size_1 = new ArrayList<>();

        Date time = new Date();
        SimpleDateFormat format = new SimpleDateFormat("MM-dd  HH:mm");
        String dateString = format.format(time);

        News n1 = new News(9,"aaa","assets/imgs/6.jpg","bbb",dateString);
        News n2 = new News(10,"aa","assets/imgs/7.jpg","bbb",dateString);
        News n3 = new News(11,"a","assets/imgs/8.jpg","bbb",dateString);
        News n4 = new News(12,"bb","assets/imgs/9.jpg","bbb",dateString);
        News n5 = new News(13,"b","assets/imgs/10.jpg","bbb",dateString);

        list_size_5.add(n1);
        list_size_5.add(n2);
        list_size_5.add(n3);
        list_size_5.add(n4);
        list_size_5.add(n5);
        list_size_1.add(n1);

        newsController.setList(list_size_5);
        newsController.setList0(list_size_1);

        JSONArray check = newsController.viewThreeMoreNews("");
        Assert.assertNotNull(check);
    }

    @Test
    public void view_less_than_3_more_news() throws Exception {

        when(conn.createStatement()).thenReturn(stmt);
        when(stmt.executeQuery(anyString())).thenReturn(rs);
        when(rs.next()).thenReturn(true);

        List<News> list_size_2 = new ArrayList<>();
        List<News> list_size_1 = new ArrayList<>();

        Date time = new Date();
        SimpleDateFormat format = new SimpleDateFormat("MM-dd  HH:mm");
        String dateString = format.format(time);

        News n1 = new News(9,"aaa","assets/imgs/6.jpg","bbb",dateString);
        News n2 = new News(10,"aa","assets/imgs/7.jpg","bbb",dateString);

        list_size_2.add(n1);
        list_size_2.add(n2);
        list_size_1.add(n1);

        newsController.setList(list_size_2);
        newsController.setList0(list_size_1);

        JSONArray check = newsController.viewThreeMoreNews("");
        Assert.assertNotNull(check);
    }

    @Test
    public void view_news_list_of_3() throws Exception {

        when(conn.createStatement()).thenReturn(stmt);
        when(stmt.executeQuery(anyString())).thenReturn(rs);
        when(rs.next()).thenReturn(true).thenReturn(false);

        List<News> list_size_3 = new ArrayList<>();
        List<News> list_size_1 = new ArrayList<>();

        Date time = new Date();
        SimpleDateFormat format = new SimpleDateFormat("MM-dd  HH:mm");
        String dateString = format.format(time);

        News n1 = new News(9,"aaa","assets/imgs/6.jpg","bbb",dateString);
        News n2 = new News(10,"aa","assets/imgs/7.jpg","bbb",dateString);
        News n3 = new News(11,"a","assets/imgs/8.jpg","bbb",dateString);

        list_size_3.add(n1);
        list_size_3.add(n2);
        list_size_3.add(n3);
        list_size_1.add(n1);

        newsController.setList(list_size_3);
        newsController.setList0(list_size_1);

        when(rs.getInt("id")).thenReturn(9);
        when(rs.getString("content")).thenReturn("aaa");
        when(rs.getString("imageURL")).thenReturn("assets/imgs/6.jpg");
        when(rs.getString("author")).thenReturn("bbb");
        when(rs.getString("time")).thenReturn(dateString);

        JSONArray newsList = newsController.viewNewsList("message");
        assertEquals(3,newsList.size());

        verify(rs).close();
        verify(stmt).close();
        verify(conn).close();
    }

    @Test
    public void view_news_list_less_than_3() throws Exception {

        when(conn.createStatement()).thenReturn(stmt);
        when(stmt.executeQuery(anyString())).thenReturn(rs);
        when(rs.next()).thenReturn(true).thenReturn(false);

        List<News> list_size_2 = new ArrayList<>();
        //List<News> list_size_1 = new ArrayList<>();

        Date time = new Date();
        SimpleDateFormat format = new SimpleDateFormat("MM-dd  HH:mm");
        String dateString = format.format(time);

        News n1 = new News(9,"aaa","assets/imgs/6.jpg","bbb",dateString);
        News n2 = new News(10,"aa","assets/imgs/7.jpg","bbb",dateString);

        list_size_2.add(n1);
        list_size_2.add(n2);
        //list_size_1.add(n1);

        newsController.setList(list_size_2);
        //newsController.setList0(list_size_1);

        when(rs.getInt("id")).thenReturn(9);
        when(rs.getString("content")).thenReturn("aaa");
        when(rs.getString("imageURL")).thenReturn("assets/imgs/6.jpg");
        when(rs.getString("author")).thenReturn("bbb");
        when(rs.getString("time")).thenReturn(dateString);

        JSONArray newsList = newsController.viewNewsList("message");
        assertEquals(3,newsList.size());

        verify(rs).close();
        verify(stmt).close();
        verify(conn).close();
    }

    @Test
    public void add_news() throws Exception {

        when(conn.prepareStatement(anyString())).thenReturn(pstmt);

        String json = "{\"content\":\"aaa\",\"imageURL\":\"5.jpg\",\"author\":\"ccc\",\"time\":\"\"}";

        boolean check = newsController.addNews(json);
        Assert.assertTrue(check);

        ArgumentCaptor<String> stringArgCaptor = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<Integer> intArgCaptor = ArgumentCaptor.forClass(Integer.class);
        verify(pstmt, new Times(4))
                .setString(intArgCaptor.capture(),stringArgCaptor.capture());

        Date time = new Date();
        SimpleDateFormat format = new SimpleDateFormat("MM-dd  HH:mm");
        String dateString = format.format(time);

        assertEquals("aaa", stringArgCaptor.getAllValues().get(0));
        assertEquals("assets/imgs/5.jpg", stringArgCaptor.getAllValues().get(1));
        assertEquals("ccc", stringArgCaptor.getAllValues().get(2));
        assertEquals(dateString, stringArgCaptor.getAllValues().get(3));

        verify(conn).prepareStatement(stringArgCaptor.capture());
        String sql6 = "insert into news(content,imageURL,author,time) values (?,?,?,?)";
        assertEquals(sql6, stringArgCaptor.getValue());

        verify(pstmt).executeUpdate();
        verify(conn).commit();
        verify(pstmt).close();
        verify(conn).close();
    }

    class TestableNewsController extends NewsController {

        List<News> list;
        List<News> list0;

        public TestableNewsController() throws ClassNotFoundException {

        }

        public List<News> getList() { return list; }

        public List<News> getList0() { return list0; }

        public void setList0(List<News> list0) { this.list0 = list0; }

        public void setList(List<News> list) { this.list = list; }

        protected Connection getConnection() throws SQLException {
            return conn;
        }

    }

}