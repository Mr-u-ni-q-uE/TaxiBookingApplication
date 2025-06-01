package TaxiBooking;

import java.util.ArrayList;
import java.util.List;

public class Taxi {
	int id;
	char location;
	int earning;
	int ttend;

//	public Taxi(char location, boolean aval, int earning) {
//		super();
//		Taxi.id=id++;
//		this.location = location;
//		this.aval = aval;
//		this.earning = earning;
//	}
//	S

	public Taxi(int id) {
		super();
		this.id = id;
		this.earning = 0;
		this.location = 'a';
		this.ttend = -1;
	}

	public char getLocation() {
		return location;
	}

	public void setLocation(char location) {
		this.location = location;
	}

	public int getEarning() {
		return earning;
	}

	public void setEarning(int earning) {
		this.earning += earning;
	}

	public static List<Taxi> createTaxi(int n) {

		List<Taxi> t = new ArrayList<>();

		for (int i = 1; i <= n; i++) {

			t.add(new Taxi(i));
		}

		return t;
	}

	public static boolean isAvailable(Taxi t, int time) {
		return (t.ttend <= time);
	}

	public static void setTtEnd(Taxi t, int endTime, int time) {
		if (t.ttend == -1)
			t.ttend = endTime;
		else {
			t.ttend = (time+endTime) % 24;
		}
	}

	public static List<Taxi> taxiAvail(int time, List<Taxi> t) {
		List<Taxi> tx = new ArrayList<>();

		for (int i = 0; i < t.size(); i++) {
			if (Taxi.isAvailable(t.get(i), time))
				tx.add(t.get(i));
		}

		return tx;
	}

	public static List<Taxi> taxiNearThePickUp(char pickUp, List<Taxi> t) {
		// TODO Auto-generated method stub
		List<Taxi> tx = new ArrayList<>();
		pickUp=Character.toUpperCase(pickUp);
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < t.size(); i++) {
//		    	 System.out.println("Distance between "+t.get(i).id+"and pickup is: "+Math.abs(t.get(i).getLocation()-pickUp));
//		    	 System.out.println("current min"+min);
			if (Math.abs(t.get(i).getLocation() - pickUp) < min) {
				min = Math.abs(t.get(i).getLocation() - pickUp);
			}
		}

		for (int i = 0; i < t.size(); i++) {
			if (Math.abs(t.get(i).getLocation() - pickUp) == min) {
				tx.add(t.get(i));
			}
		}

		return tx;
	}
	
	public static Taxi minEarningTaxi(List<Taxi> taxiNear) {
		// TODO Auto-generated method stub
		 int min=Integer.MAX_VALUE;
		 Taxi t=null;
		for(int i=0;i<taxiNear.size();i++) {
	    	 if(taxiNear.get(i).getEarning()<min) {
	    		 min=taxiNear.get(i).getEarning();
	    		 t=taxiNear.get(i);
	    	 }
	     }
		return t;
	}
	
	public static int calculateDistance(char pickUp, char drop) {
		// TODO Auto-generated method stub
		pickUp=Character.toUpperCase(pickUp);
		drop=Character.toUpperCase(drop);
		return Math.abs( (drop-pickUp)*15);
	}

	public static int calculateTimeTaken(int distance) {
		// TODO Auto-generated method stub
		return distance/15;
	}

	public static int calculateFair(int distance) {
		// TODO Auto-generated method stub
		int fair=0;
		if(distance<=5) return 100;
		else {
			fair=100+(distance-5)*10;
		}
		
		return fair;
	}
	
	public static void getInfo(List<Taxi> t2) {
		for(int i=0;i<t2.size();i++) {
			System.out.println("Taxi id: "+t2.get(i).id);
			System.out.println("Taxi Location: "+t2.get(i).getLocation());
			System.out.println("Taxi available after "+t2.get(i).ttend);
			System.out.println("Taxi total earnings: "+t2.get(i).getEarning());
			System.out.println();
		}
	}

}
