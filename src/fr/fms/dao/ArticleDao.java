package fr.fms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Logger;

import fr.fms.entities.Article;

public class ArticleDao implements Dao {//exo 3
	
	private Connection connection;
	public static final Logger logger = Logger.getLogger(ArticleDao.class.getName());
	public ArticleDao(Connection connection) {
        this.connection = connection;
   }
	
//public static Connection getConnection() {	// 
		
		//try{ 
		//String url = "jdbc:mariadb://localhost:3306/shop";
		//String login = "root";
		//String password = "fms2024";
		//return DriverManager.getConnection(url,login,password);
		//}catch (SQLException e) {
			//e.printStackTrace();
		//}
		//return null;
	//}
	public void create(Article obj) { // ajout d'une nouvelle occurrence en base 
		String str = "Insert into T_Articles(Description, Brand, UnitaryPrice)"
				+ "values (?,?,?)";
		try (PreparedStatement ps = connection.prepareStatement(str)){ // pour éviter les attaques injection sql
			ps.setString(1, obj.getDescription());
			ps.setString(2, obj.getBrand());
			ps.setDouble(3, obj.getPrice());
			if (ps.executeUpdate() == 1) System.out.println("insertion ok");
		}catch(SQLException e) {
			logger.severe("pb Sql" + e.getMessage());
		}
	} 
	
	public boolean update (Article obj) { // met l'objet à jour en base,  renvoi vrai si c'est fait
		String str = "UPDATE T_Articles set Description = ?, Brand = ?, UnitaryPrice = ? where IdArticle = ?";
		try (PreparedStatement ps = connection.prepareStatement(str)){
			ps.setString(1, obj.getDescription());
			ps.setString(2, obj.getBrand());
			ps.setDouble(3, obj.getPrice());
			ps.setInt(4, obj.getIdArticle());
			return ps.executeUpdate() > 0;
		}catch(SQLException e) {
			logger.severe("pb Sql" + e.getMessage());
		}
			return false;
			
	} 
	
	public boolean delete (Article obj) { // supprime un objet en base, renvoi vrai si c'est fait
		String str = "DELETE FROM T_Articles WHERE IdArticle = ?";
		try (PreparedStatement ps = connection.prepareStatement(str)){			
			ps.setInt(1, obj.getIdArticle());
			return ps.executeUpdate() > 0;
		}catch(SQLException e) {
			logger.severe("pb Sql" + e.getMessage());
		}
			return false;
			
	} 
	
	public ArrayList<Article>readAll(){ // renvoi tous les objets de la table correspondante
		ArrayList<Article> articles = new ArrayList<>();
		String strSql = "SELECT * FROM T_Articles";
		try (Statement statement = connection.createStatement()){
			try(ResultSet resultSet = statement.executeQuery(strSql)){
				while(resultSet.next()) {
					int rsIdArticle = resultSet.getInt(1);
					String rsDescription = resultSet.getString(2);
					String rsBrand = resultSet.getString(3);
					double rsPrice = resultSet.getDouble(4);
					articles.add((new Article(rsIdArticle,rsDescription,rsBrand,rsPrice)));
				}	}				
	} catch(SQLException e) {
		logger.severe("pb Sql" + e.getMessage());
	}
	return articles;
	}

}