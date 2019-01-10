package timelinebackend.timelinebackend.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.*;
import timelinebackend.timelinebackend.MySqlConnector;
import timelinebackend.timelinebackend.entity.*;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @Author: Fang Kun
 */

@RestController
@RequestMapping("/news")
public class NewsController {

    private List<News> list= new ArrayList<>();
    private List<News> list0 = new ArrayList<>();
    private Logger logger = null;
    private MySqlConnector mySqlConnector = new MySqlConnector();
    private String imageUrl = "imageURL";

    public void setList(List<News> list) { this.list = list; }

    public void setList0(List<News> list0) { this.list0 = list0; }

    public List<News> getList() { return list; }

    public List<News> getList0() { return list0; }

    public NewsController() throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
    }

    protected Connection getConnection() throws SQLException {
        Connection conn = null;
        conn = DriverManager.getConnection(mySqlConnector.getDB_URL(),mySqlConnector.getUSER(), mySqlConnector.getPASS());
        conn.setAutoCommit(false);
        return conn;
    }

    @PostMapping("moreNews")
    @CrossOrigin(origins ="*")
    public JSONArray viewThreeMoreNews(@RequestParam("message") String message){

        if((getList().size() - getList0().size()) >= 3){
            for(int j=0; j<3; j++){
                getList0().add(getList().get(getList().size()- getList0().size()-1));
            }
        }else if(((getList().size() - getList0().size()) < 3)
                && ((getList().size() - getList0().size()) > 0)){

            for(int j = 0; j < ((getList().size() - getList0().size()) + 1); j++){
                getList0().add(getList().get(getList().size()- getList0().size()-1));
            }
        }

        String str = JSON.toJSONString(getList0());
        return JSON.parseArray(str);

    }

    @PostMapping("newsList")
    @CrossOrigin(origins ="*")
    public JSONArray viewNewsList(@RequestParam("message") String message){

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try{

            conn = getConnection();
            stmt = conn.createStatement();
            String sql4 = "SELECT * FROM news";
            rs = stmt.executeQuery(sql4);

            while(rs.next()){

                int id=rs.getInt("id");
                if(id > getList().size()){
                    String content=rs.getString("content");
                    String imageURL=rs.getString(imageUrl);
                    String author=rs.getString("author");
                    String time=rs.getString("time");
                    News n=new News(id,content,imageURL,author,time);
                    getList().add(n);
                }
            }
        } catch (Exception e) { logger.info("err",e); }
        finally{
            try {
                if(rs!=null){ rs.close(); }
                if(stmt!=null) { stmt.close(); }
                if(conn!=null) { conn.close(); }

            }catch (SQLException se1){ logger.info("err",se1); }
        }

        this.setList0(new ArrayList<News>());
        if(getList().size()>3){
            for(int k=1;k<=3;k++){
                getList0().add(getList().get(getList().size()-k));
            }
        }else {
            for(int k=1;k<=getList().size();k++){
                getList0().add(getList().get(getList().size()-k));
            }
        }

        List<News> list1 = new ArrayList<>();
        if(!getList().isEmpty() && (getList().size() > 3)){
            for(int i=1; i<=3; i++){
                if(list1.size()<3){
                    list1.add(getList().get(getList().size()-i));
                }
            }
        }else if(!getList().isEmpty() && getList().size() <= 3){
            for(int i = 1; i<= getList().size(); i++){
                if(list1.size()<3){
                    list1.add(getList().get(getList().size()-i));
                }
            }
        }
        String str = JSON.toJSONString(list1);
        return JSON.parseArray(str);
    }

    @PostMapping("addNews")
    @CrossOrigin(origins ="*")
    public boolean addNews(@RequestParam("message") String message){

        JSONObject news = JSON.parseObject(message);

        Connection conn = null;
        PreparedStatement pstmt = null;
        try{
            conn = getConnection();
            String content;
            content = !Objects.equals(news.get("content").toString(),"") ? news.get("content").toString() : "";

            String imageURL;
            imageURL = !Objects.equals(news.get(imageUrl).toString(), "")
                    && news.get(imageUrl).toString().contains(".") ? "assets/imgs/"
                    + news.get(imageUrl) : "";

            String author = news.get("author").toString();

            Date time = new Date();
            SimpleDateFormat format = new SimpleDateFormat("MM-dd  HH:mm");
            String dateString = format.format(time);

            String sql6 = "insert into news(content,imageURL,author,time) values (?,?,?,?)";
            pstmt = conn.prepareStatement(sql6);
            pstmt.setString(1,content);
            pstmt.setString(2,imageURL);
            pstmt.setString(3,author);
            pstmt.setString(4,dateString);

            pstmt.executeUpdate();
            conn.commit();

        } catch (Exception e) { logger.info("err",e); }
        finally{
            try{
                if(conn!=null) { conn.close(); }
                if(pstmt!=null) { pstmt.close(); }
            }catch(SQLException se){ logger.info("err",se); }
        }
        return true;
    }

}
