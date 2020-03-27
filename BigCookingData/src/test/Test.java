package test;
import  persistance.*;

public class Test {
	public static void main(String[] args) {

		UserPersistance usr = new UserPersistance();
		
		usr.CreateUser("test1", "test2", "sdsd", "sds");
		System.out.println("hey");
			
	}
}
