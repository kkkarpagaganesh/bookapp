package com.chainsys.jdbc.test;

import java.sql.Connection;

import com.chainsys.jdbc.Connectionutil;

public class Testconnectionutil {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection connection=Connectionutil.getconnection();
		System.out.println(connection);

	}

}
