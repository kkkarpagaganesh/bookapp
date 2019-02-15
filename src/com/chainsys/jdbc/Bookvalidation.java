package com.chainsys.jdbc;

public class Bookvalidation {
     
	public void validateBook(Book book) throws Exception{
		if(book.id<=0){
			System.out.println("INVALID");
		}
		if(book.name==null){
			throw new Exception("INVALID name");
		}
		if(book.price<=0){
			throw new Exception("INVALID PRICE");
		}
	}
	public void validateAdd(Book book) throws Exception{
		if(book.name==null){
			throw new Exception("Invalid naame");
		}
		if(book.price<=0){
			throw new Exception("Invalid price, price cannot be less than 0");
			
		}
	}
	public void validateDelete(Book book) throws Exception{
		if(book.id<=0){
			throw new Exception("Invalid price, ID cannot be less than 0");
		}
	}
}
