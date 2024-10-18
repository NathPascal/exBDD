import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import fr.fms.dao.ArticleDao;
import fr.fms.entities.Article;

public class TestJdbc { //exo 2

	public static void main(String[] args) throws Exception {
		
		//exo 4 
		//Properties prop = CreateConfigFile.configFile("Conf.properties");
		//System.out.println(prop.getProperty("db.login"));
		//ArrayList <Article> articles = new ArrayList<Article>(); //exo 2
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");	
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	

		//String url = "jdbc:mariadb://localhost:3306/shop"; 
		//String login = "root";
		//String password = "fms2024";
		
		//try(Connection connection = DriverManager.getConnection(url,login,password)) { // exo 2
			//String strSql = "SELECT * FROM T_Articles";
			//try (Statement statement = connection.createStatement()){
				//try(ResultSet resultSet = statement.executeQuery(strSql)){
					//while(resultSet.next()) {
						//int rsIdArticle = resultSet.getInt(1);
						//String rsDescription = resultSet.getString(2);
						//String rsBrand = resultSet.getString(3);
						//double rsPrice = resultSet.getDouble(4);
						//articles.add((new Article(rsIdArticle,rsDescription,rsBrand,rsPrice)));
					//}
					
				//}
				
			//}
			//for(Article a: articles)
				//System.out.println(a.getIdArticle() + " - " + a.getDescription() + " - " + a.getBrand() + " -" + a.getPrice());
		//}
		//catch(SQLException e) {
			//e.printStackTrace();
		//}
	//}
	
	Connection connection = CreateConfigFile.connection(); // exo 3
	ArticleDao articleDao = new ArticleDao(connection);	
	
	//insertion d'un article
	Article newArticle = new Article(15, "clavier","Logitech", 25);
	articleDao.create(newArticle);
	
	System.out.println(newArticle);
	
	//mise à jour de l'article
	newArticle.setPrice(38);
	articleDao.update(newArticle);
	
	System.out.println(newArticle);
	
	//suppression de l'article
	articleDao.delete(newArticle);
	System.out.println("---------------");
	
	//Lecture de tous les articles
	ArrayList<Article> articles = articleDao.readAll();
    for (Article article : articles) System.out.println(article);
    
	}
}
