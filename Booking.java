package TaxiBooking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Booking {
	
	static Scanner sc=new Scanner(System.in);
	char pickUp;
	char drop;
	int time;
	int bookingId;
	int taxiBooked;
	int endTime;
	
	
	
	static ArrayList<Booking> b=new ArrayList<>();    

	
	public Booking() {
		super();
		this.bookingId=b.size()+1;
	}


	public char getPickUp() {
		return pickUp;
	}


	public void setPickUp(char pickUp) {
		this.pickUp = pickUp;
	}


	public char getDrop() {
		return drop;
	}


	public void setDrop(char drop) {
		this.drop = drop;
	}


	public int getTime() {
		return time;
	}


	public void setTime(int time) {
		this.time = time;
	}
	
	public static void Book(List<Taxi> t) {
		// TODO Auto-generated method stub
		
		System.out.println("enter the pickUp point");
		System.out.println("enter the drop point");
		System.out.println("Enter the time");
		
		Booking bx=new Booking();
		bx.setPickUp(sc.next().charAt(0));
		bx.setDrop(sc.next().charAt(0));
		bx.setTime(sc.nextInt());
		
		List<Taxi> taxi=Taxi.taxiAvail(bx.getTime(), t);
		

		if(taxi.size()>0) {
		
		List<Taxi> taxiNear=Taxi.taxiNearThePickUp(bx.pickUp,taxi);
		
//		System.out.println("No of taxies near pickup "+taxiNear.size());
		
		Taxi s=Taxi.minEarningTaxi(taxiNear);
		
//		System.out.println(s.id +"  " + s.getEarning());
//		
		bx.taxiBooked=s.id;
		
		System.out.println("Taxi Booked with id : "+bx.taxiBooked);
		
		b.add(bx);
		
		System.out.println("Booking information: \n");
		
		System.out.println("Your booking ID: "+bx.bookingId+" Taxi id: "+s.id);
		
		System.out.println("Pick Up : " + bx.getPickUp());
		
		s.setLocation(bx.getDrop());
		
		System.out.println("Drop : "+ bx.getDrop());
		
		int distance=Taxi.calculateDistance(bx.getPickUp(),bx.getDrop());
		
		int tt=Taxi.calculateTimeTaken(distance);
		
		bx.endTime=(bx.time+(tt))%24;
		
		Taxi.setTtEnd(s,bx.endTime,bx.time);
		
		System.out.println("Distance : "+distance);
		
		int fare=Taxi.calculateFair(distance);
		
		s.setEarning(fare);
		
		System.out.println("Fare : " + fare);
		System.out.println();
		System.out.println();
		
		
		}
		else {
			System.out.println("No taxi Available. Your booking has been cancelled");
		}
		
		
		
	}
	
	public static void showDetails() {
		// TODO Auto-generated method stub
		if(b.size()==0) System.out.println("No bookings Yet \n");
		for(int i=0;i<b.size();i++) {
			System.out.println("Booking id: "+b.get(i).bookingId);
			System.out.println("Pick Up : "+b.get(i).getPickUp());
			System.out.println("Drop : "+b.get(i).getDrop());
			System.out.println("Pickup time : "+b.get(i).time);
			System.out.println("Drop Time : "+b.get(i).endTime);
			System.out.println("Taxi Booked : "+b.get(i).taxiBooked);
			System.out.println();System.out.println();
		}
		
	}

}
