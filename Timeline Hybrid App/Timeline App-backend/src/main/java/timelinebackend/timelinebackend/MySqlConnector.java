package timelinebackend.timelinebackend;

/**
 * @Author: Fang Kun
 */

public class MySqlConnector {

    private String DB_URL = "jdbc:mysql://localhost:3306/timeline?useSSL=false&serverTimezone=GMT%2B8";
    private String USER = "root";
    private String PASS = "123456";

    public String getDB_URL() {
        return this.DB_URL;
    }

    public String getUSER() {
        return this.USER;
    }

    public String getPASS() {
        return this.PASS;
    }

}
