import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;

/**
 * Created by ll on 2017/5/15.
 */
public class ConnectionPool {
    private Vector<Connection> pool;

    private String url="jdbc:mysql://localhost:3306/test";
    private String username="root";
    private String password="root";
    private String driverClassName="com.mysql.jdbc.Driver";

    private int poolSize=100;
    private static ConnectionPool instance=null;
    Connection conn=null;

    /*构造方法，做一些初始化工作*/
    private ConnectionPool(){
        pool=new Vector<>(poolSize);
        for (int i = 0; i < poolSize; i++) {
            try{
                Class.forName(driverClassName);
                conn= DriverManager.getConnection(url,username,password);
                pool.add(conn);
            }catch(ClassNotFoundException e){
                e.printStackTrace();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }

    /*返回链接到连接池*/
    public synchronized void release(){
        pool.add(conn);
    }

    public synchronized Connection getConnnection(){
        if(pool.size()>0){
            Connection conn=pool.get(0);
            pool.remove(conn);
            return conn;
        }else{
            return null;
        }
    }
}
