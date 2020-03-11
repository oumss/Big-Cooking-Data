package business;
import beans.*;
import persistance.UserPersistance;

public class Test {
	public static void main(String[] args) {
		
		SigninBean sgn = new SigninBean();
		
		String login = "test";
		String password = "mdp";
		
		sgn.setConnected(true);
		sgn.setLogin("test");
		sgn.setIncorrect("sssssssss");
		sgn.setPassword("mdp");
		
		sgn.verify();
		
		System.out.println("hey");
	
	}
}
