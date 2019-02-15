package com.chainsys.jdbc.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.util.Scanner;

import com.chainsys.jdbc.Book;
import com.chainsys.jdbc.BookDAO;
import com.chainsys.jdbc.Bookvalidation;
import com.chainsys.jdbc.Connectionutil;

public class TestbookDAO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		BookDAO bookdao=new BookDAO();
		
/*	System.out.println("Enter the id,name,price to add");
		int id=scanner.nextInt();
		String name=scanner.next();
		int price=scanner.nextInt();*/
		
		System.out
		.println("enter the option you want to do::\nPRESS 1-INSERT\nPRESS 2-UPDATE\nPRESS 3-DELETE\nPRESS 4-DISPLAY\nPRESS 5-PROCESS COMPLITION");
		int change = scanner.nextInt();
		try {
			switch (change) {
			case 1:
				int id = 0;
				Connection connection=Connectionutil.getconnection();
			String sql=	"CREATE SEQUENCE val2 INCREMENT BY 1 minvalue maxvalue 1000" ;
			PreparedStatement preparedstatement = connection
					.prepareStatement(sql);
			preparedstatement.setInt(1, id);
				System.out.println("Enter the name,price to add");
				
				
				String name=scanner.next();
				int price=scanner.nextInt();
				String date=scanner.next();
				
			Bookvalidation bookvalidation = new Bookvalidation();
			Book book=new Book();
			book.id=id;
			book.name=name;
			book.price=price;
			book.publisheddate=LocalDate.parse(date);
			
			bookvalidation.validateAdd(book);
				
				bookdao.addBook(book);
				
				break;
			case 2:
				System.out
				.println("enter the 'NAME' you want to update of the book where 'ID' is:");
			//	BookDAO bookdao=new BookDAO();
				Book book1=new Book();
				
				int id1 =scanner.nextInt();
				String name1=scanner.next();
				book1.id=id1;
				book1.name=name1;
				bookdao.updateBook(book1);
				break;
			case 3:
				System.out.println("enter the file 'ID' you want to delete:");
				int id2=scanner.nextInt();
				Bookvalidation bookvalidation1 = new Bookvalidation();
				Book book11=new Book();
				book11.id=id2;
				
				bookvalidation1.validateDelete(book11);
				bookdao.deleteBook(id2);
				
				break;
			case 4:
				System.out.println("your dataset is displayed ");
				int id3=scanner.nextInt();
				String name3=scanner.next();
				int price1=scanner.nextInt();
				bookdao.displayBook(id3, name3, price1);
				break;

			default:
				System.out.println("INVALID OPTION");
				break;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		scanner.close();
	/*	Book bookresult=bookDAO.findbyid(book){
			if(bookresult!=null){
				System.out.println(bookresult.id);
				System.out.println(bookresult.name);
				System.out.println(bookresult.price);
				 */
	}

	
		

	}


