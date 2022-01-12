import java.util.Random;

public class WeekEightQuestion2{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Random rnd = new Random();
		
		
		int[] arrayN = new int[rnd.nextInt(100)+1];
		
		
		for(int i = 0; i<arrayN.length; i++) {
			int randomNumber = rnd.nextInt();
			System.out.println(arrayN[i]);	
		}
		
		
	}

}
