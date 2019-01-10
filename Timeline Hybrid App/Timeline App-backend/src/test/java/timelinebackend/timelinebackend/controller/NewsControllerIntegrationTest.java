package timelinebackend.timelinebackend.controller;

import com.alibaba.fastjson.JSONArray;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import timelinebackend.timelinebackend.entity.News;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

@RunWith(SpringRunner.class)
public class NewsControllerIntegrationTest {

    Connection conn;
    PreparedStatement pstmt;
    ResultSet rs;
    Statement stmt;
    NewsController newsController ;

    @Before
    public void setup() throws Exception{
        newsController = new NewsController();
    }

    @Test
    public void get_list() throws Exception{

        Assert.assertNotNull(newsController.getList());
        Assert.assertNotNull(newsController.getList0());
    }

    @Test
    public void set_list() throws Exception{

        List<News> list_test0 = new ArrayList<>();
        List<News> list_test = new ArrayList<>();
        newsController.setList(list_test);
        newsController.setList0(list_test0);
    }

    @Test
    public void get_connection() throws Exception{

        Connection connection = newsController.getConnection();
        Assert.assertNotNull(connection);
    }

    @Test
    public void view_3_more_news() throws Exception {

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

        JSONArray check = newsController.viewThreeMoreNews("");
        Assert.assertNotNull(check);
    }

    @Test
    public void view_news_list_of_3() throws Exception {

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

        JSONArray newsList = newsController.viewNewsList("message");
        assertNotNull(newsList);

    }

    @Test
    public void view_news_list_less_than_3() throws Exception {

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

        JSONArray newsList = newsController.viewNewsList("message");
        assertNotNull(newsList);

    }

    @Test
    public void add_news() throws Exception {

        String json = "{\"content\":\"aaa\",\"imageURL\":\"5.jpg\",\"author\":\"ccc\",\"time\":\"\"}";

        boolean check = newsController.addNews(json);
        Assert.assertTrue(check);

    }

}