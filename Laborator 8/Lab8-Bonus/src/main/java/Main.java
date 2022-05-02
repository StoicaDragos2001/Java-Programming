import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.log4j.BasicConfigurator;
import java.util.Scanner;
import java.io.IOException;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;


public class Main {


    public static void main(String[] args) throws SQLException, InterruptedException, IOException {
        BasicConfigurator.configure();
        bonus();
    }
    public static void bonus(){
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:oracle:thin:@localhost:1521/xe");
        config.setUsername("STUDENT");
        config.setPassword("STUDENT");
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        HikariDataSource ds = new HikariDataSource(config);
    }


}

