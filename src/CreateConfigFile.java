//exo 4

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class CreateConfigFile {
	

	 public static Properties configFile(String fileName) throws IOException {
	      FileInputStream fis = null;
	      Properties prop = null;
	      try {
	         fis = new FileInputStream(fileName);
	         prop = new Properties();
	         prop.load(fis);
	      } catch(FileNotFoundException fnfe) {
	         fnfe.printStackTrace();
	      } catch(IOException ioe) {
	         ioe.printStackTrace();
	      } finally {
	         fis.close();
	      }
	      return prop;
	   }

	  public static Connection connection() throws IOException, SQLException {
	        Properties prop = configFile("conf.properties");
	        String driver = prop.getProperty("db.driver.class");
	        String url = prop.getProperty("db.url");
	        String user = prop.getProperty("db.login");
	        String password = prop.getProperty("db.password");
	        return DriverManager.getConnection(url, user, password);
	        //System.out.println(driver);
	        //System.out.println(url);
	        //System.out.println(user);
	        //System.out.println(password);
	      // return null;
	    }
	}
