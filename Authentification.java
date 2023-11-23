import java.util.Scanner;
import java.io.IOException;
class WrongLoginException extends Exception{
	public String alerte() {
		return ("login incorrect");
	}
}
class WrongPwdException extends Exception{
	public String alerte() {
		return ("mod de passe irrone");
	}
}
class  WrongInputLength extends Exception{
	public String alerte() {
		return ("erreur de length");
	}
}
public class Authentification {
final String LoginCorrect="scott";
final String PwdCorrect="tiger";
String getUserLogin() throws WrongInputLength ,WrongLoginException,IOException{
	Scanner sc=new Scanner(System.in);
	System.out.println("donner le login : ");
	String l=sc.nextLine();
	if(l.length()>10)
		throw new WrongInputLength();
	if(!l.equals(LoginCorrect)) 
		throw new WrongLoginException();
	return l;
}
String getUserPwd() throws WrongInputLength,WrongPwdException,IOException  {
	Scanner sc=new Scanner(System.in);
	System.out.println("donner le password : ");
	String p=sc.nextLine();
	if(p.length()>10)
		throw new WrongInputLength();
	if(!p.equals(PwdCorrect)) 
		throw new WrongPwdException();
	return p;
		}
Authentification() throws WrongInputLength,WrongPwdException,WrongLoginException,IOException{
	getUserLogin();
	getUserPwd();
}
}
class TestAuthentification{
	public static void main(String[] args) {
		boolean erreur=true;
		do {
			try {
			Authentification a =new Authentification();
			erreur =false;
			}
			catch(WrongInputLength e) {
			System.out.println(e.alerte());
			System.exit(0);}
			catch(WrongPwdException e) {
				System.out.println(e.alerte());
				}
			catch(WrongLoginException e) {
				System.out.println(e.alerte());
			}
			catch(IOException e) {
                System.out.println(e.getMessage());
                System.exit(0);
            }
		}
		while(erreur==true);
	}
}