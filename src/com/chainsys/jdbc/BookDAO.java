package com.chainsys.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class BookDAO {
    
//	static Connection connection=Connectionutil.getconnection();
	Scanner scanner = new Scanner(System.in);
	
//	static PreparedStatement preparedstatement =null;
//	static ResultSet rset =null;
	public  void addBook(Book book) throws Exception {
		try {
			Connection connection=Connectionutil.getconnection();
			
			String sql = "insert into filesforjava(id,name,price,publisheddate) values(?,?,?,?)";
//	System.out.println(sql);
		//	System.out.println("enter the id,name,price of the book");
			PreparedStatement preparedstatement = connection
					.prepareStatement(sql);
			preparedstatement.setInt(1,book. id);
			preparedstatement.setString(2,book. name);
			preparedstatement.setInt(3,book. price);
			
			preparedstatement.setDate(4,Date.valueOf(book.publisheddate));//converting Localdate(java date as a string) into SQL date)
			int rows = preparedstatement.executeUpdate();
			System.out.println("rows inserted: " + rows);
Connectionutil.close(connection, preparedstatement, null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception("Unable to insert");
		}
	}
	
	public  void updateBook(Book book)
			throws SQLException {
		Connection connection=Connectionutil.getconnection();
		String sql1 = "update filesforjava set name= ? where id=?";
	//	System.out.println(sql1);
	//	System.out.println("enter the 'NAME' you want to update of the book where 'ID' is:");
		PreparedStatement preparedstatement = connection
				.prepareStatement(sql1);
		preparedstatement.setInt(2, book.id);
		preparedstatement.setString(1, book.name);

		int rows1 = preparedstatement.executeUpdate();
		System.out.println("rows updated: " + rows1);
		Connectionutil.close(connection, preparedstatement, null);
	//	Connectionutil.close(connection, preparedstatement, null);
	}
	
	public  void deleteBook(int id)
			throws SQLException {
		Connection connection=Connectionutil.getconnection();
		String sql2 = "delete from filesforjava where id=?";
	//	System.out.println(sql2);
	//	System.out.println("enter the file 'ID' you want to delete:");
		PreparedStatement preparedstatement = connection
				.prepareStatement(sql2);
		preparedstatement.setInt(1, id);

		preparedstatement.executeUpdate();
		System.out.println("rows deleted: " );
		Connectionutil.close(connection, preparedstatement, null);
	}
	
	public void displayBook(int id,String name,int price) throws SQLException {
		Connection connection=Connectionutil.getconnection();
		String sql3 = "select id,name,price from filesforjava ";
	//	System.out.println(sql3);
	//	System.out.println("your dataset is displayed ");
		PreparedStatement preparedstatement = connection
				.prepareStatement(sql3);

		ResultSet rset = preparedstatement.executeQuery();
		while (rset.next()) { // "IF" STATEMENT USED TO ELIMINATE THE
								// COPY IF MORETHAN ONE
			System.out.print(rset.getInt("id")+"\t\t"); // "WHILE" STATEMENT
													// USED TO PRINT THE
													// ALL SAME COPY
			System.out.print(rset.getString("name")+"\t\t");
			System.out.println(rset.getInt("price")+"\t\t");
			System.out.println(rset.getDate("published_date").toLocalDate()+"\t\t");}
		Connectionutil.close(connection, preparedstatement, rset);
	}
	public Book FindById(Book book) throws Exception {
		Book book1 = null;
		Connection connection = Connectionutil.getconnection();
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		try {
		String	sql = "select id,name,price,author,published_date from book where id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, book.id);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				book1 = new Book();
				book1.id = resultSet.getInt("id");
				book1.name = resultSet.getString("name");
				book1.price = resultSet.getInt("price");
			//	book1.author = resultSet.getString("author");
				book1.publisheddate=resultSet.getDate("published_date").toLocalDate();

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception("unable to select records");
		}
		Connectionutil.close(connection, preparedStatement, resultSet);
		return book1;
	}
	
	
	
}
