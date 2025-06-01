package TaxiBooking;

import java.util.List;
import java.util.Scanner;



public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the total no of taxies");
		int n = sc.nextInt();
		List<Taxi> t = Taxi.createTaxi(n);
		boolean f=true;
		while (f) {

			String s = """
					What do you want to do?
					1. Book a Taxi
					2. View Details of taxi
					3. View Details of booking
					4. Exit
					""";
			System.out.println(s);

			switch (sc.nextInt()) {
				case 1: {
					Booking.Book(t);
					break;
				}
				case 2: {
					Taxi.getInfo(t);
					break;
				}
				case 3: {
					Booking.showDetails();
					break;
				}
				case 4: {
					System.out.println("Thank You");
					f=false;
					break;
				}
			}
		
		}
	}
}