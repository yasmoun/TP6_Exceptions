class ParametreNullException extends Exception{
	public String alerte() {
		return ("impossible de faire une division par zero !");}
	}
class NegatifException extends Exception{
	NegatifException(String message){
		super(message);
	}
}
class Mathematique {
	static double f(double n,double x) throws ParametreNullException ,NegatifException {
		if(n == 0) {
			//throw new ArithmeticException(" impossible de faire une division par zero ! ");
			throw new ParametreNullException();
	}
		if(x<0) {
			throw new NegatifException("on ne peut pas calculer une racine pour un reel negatif !!!!!!");
		}
		return Math.sqrt(x)/n;
	}
}
class test{
	public static void main(String[] args) {
		try {
		double x=Double.parseDouble(args[0]);
		double n=Double.parseDouble(args[1]);
		System.out.println(Mathematique.f(n,x));}
		catch(ArrayIndexOutOfBoundsException e){
			System.out.println(" Vous devriez entrer deux nombres sur la ligne de commande pour que ca fonctionne");
		}
		catch(NumberFormatException e) {
			System.out.println("Les arguments doivent etre des nombres");
		}
		/*catch(ArithmeticException e) {
			e.printStackTrace();
			e.getMessage();
		} */
		catch(ParametreNullException e) {
			System.out.println(e.alerte());
		}
		catch(NegatifException e) {
			System.out.println(e.getMessage()); 
		}
		finally {
			System.out.println("fin du programme");
		} 
			

	}
}