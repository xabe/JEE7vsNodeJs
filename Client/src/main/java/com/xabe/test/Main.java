package com.xabe.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;


	

public class Main {
	public static final double TIME = 1000.0;
	public static final String RETURN = "\n";
	public static final String CRLF = "\r\n";
	public StringBuffer bufferMessage;
	public StringBuffer bufferMessageError;
	public BufferedReader reader;
	public boolean exit = false;
	private long millisJEE7 = -1l;
	private long millisNodeJs = -1l;
	
	public Main() {
		bufferMessage = new StringBuffer();
		bufferMessage.append("-----------------------Welcome to comparison test between JEE7 and NodeJs-----------------------");
		bufferMessage.append(CRLF);
		bufferMessage.append("Select a option: ");
		bufferMessage.append(CRLF);
		bufferMessage.append("-->>  1º		View time JEE7");
		bufferMessage.append(CRLF);
		bufferMessage.append("-->>  2º		View time Node Js");
		bufferMessage.append(CRLF);
		bufferMessage.append("-->>  3º		Exit");
		bufferMessage.append(CRLF);
		
		bufferMessageError = new StringBuffer();
		bufferMessageError.append("-----------------------Incorrect option!!!!!!!!!");
		bufferMessageError.append(CRLF);
		bufferMessageError.append("The allowed values ​​are:");
		bufferMessageError.append(CRLF);
		bufferMessageError.append("-->>  1º		View time JEE7");
		bufferMessageError.append(CRLF);
		bufferMessageError.append("-->>  2º		View time Node Js");
		bufferMessageError.append(CRLF);
		bufferMessageError.append("-->>  3º		Exit");
		bufferMessageError.append(CRLF);
		
		reader = new BufferedReader(new InputStreamReader(System.in));
		String readline = "";
		int optionSelect;
		try{
			System.out.println(bufferMessage.toString());
			while((readline = reader.readLine()) != null){
				optionSelect = executeOption(readline);
				switch (optionSelect) {
					case 1 : timeJava();						
						break;
					case 2 : timeNode();						
						break;
					case 3 : exit = true;						
						break;
					default: System.out.println(bufferMessageError.toString());
						break;
				}
				if(exit)
				{
					break;
				}
				checkBest();
			}
			System.out.println("Bye!!");
		}catch(Exception e){
			e.printStackTrace();
		}		
	}
	
	public int executeOption(String readline){
		int option  = -1;
		try
		{
			option = Integer.parseInt(readline);
		}catch(Exception e){
			
		}
		return option;
	}
	
	public void checkBest(){
		if(millisNodeJs != -1l && millisJEE7 != -1l)
		{
			if(millisNodeJs > millisJEE7)
			{
				System.out.println("----------------> 		JEE7 is faster than Node Js !!!!!");
			}
			else if(millisJEE7 > millisNodeJs)
			{
				System.out.println("----------------> 		Node Js is faster than JEE7 !!!!!");
			}
			else
			{
				System.out.println("----------------> 		They are equally fast !!!!!");
			}
			
		}
	}
	
	public void timeJava(){
		try
		{
			Client client = ClientBuilder.newClient();
			WebTarget javaTarget = client.target("http://localhost:8000/Caso1/ws/rest/all");
			long startTime = System.nanoTime();
			javaTarget.request("application/json").get();
			long time = (System.nanoTime() - startTime);
			millisJEE7 = TimeUnit.MILLISECONDS.convert(time,TimeUnit.NANOSECONDS);
			System.out.println("Time it takes JEE7 = " + millisJEE7 / TIME + " seconds.");
			
		}catch(Exception e){
			System.out.println("Error during test java");
			e.printStackTrace();
		}
	}
	
	public void timeNode(){
		try
		{
			Client client = ClientBuilder.newClient();
			WebTarget javaTarget = client.target("http://localhost:3000/rest/all");
			long startTime = System.nanoTime();
			javaTarget.request("application/json").get();
			long time = (System.nanoTime() - startTime);
			millisNodeJs = TimeUnit.MILLISECONDS.convert(time,TimeUnit.NANOSECONDS);
			System.out.println("Time it takes nodejs = " + millisNodeJs / TIME + " seconds.");
			
		}catch(Exception e){
			System.out.println("Error during test js");
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new Main();
	}

}
