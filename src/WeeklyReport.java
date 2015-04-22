/*
 * CS315 Assignment 4, WeekleyReport class
 * Hannah Hoover
 */

import java.util.ArrayList;


public class WeeklyReport extends Database{
	private double overallFee;
	private int totalProviders;
	//private ArrayList<Provider> person = new ArrayList<Provider>();
	private ArrayList<Provider> activePeople = new ArrayList<Provider>();
	
	/**
	 * Constructor for Weekly Report; initializes variables
	 * 
	 */
	public WeeklyReport(){
		overallFee = 0;
		totalProviders = 0;
		generateReport();
		//person = super.getProviders();
	}
	
	/**
	 * Generates the Weekly Report
	 */
	public void generateReport(){
		System.out.println(" --- Begin Weekly report ---");
		getActives();
		for (int i=0; i<activePeople.size();i++){
			overallFee += activePeople.get(i).getMoneyEarned();
			totalProviders += 1;
			System.out.println("Provider Name: " + activePeople.get(i).getName());
			System.out.println("Number of Consultations: " + activePeople.get(i).getServices().size());
			System.out.println("Total Weekly Fee: " + activePeople.get(i).getMoneyEarned());
			System.out.println();
		}
		
		
		System.out.println("Total number of providers who provided services: " + totalProviders);
		System.out.println("Overall total fee: " + overallFee);
	}
	
	/**
	 * Gets active members
	 */
	public void getActives(){
		for (int i=0; i<providers.size();i++){
			if (providers.get(i).getServices().size() > 0){
				activePeople.add(providers.get(i));
			}else{
				continue;
			}
		}
	}
}
