package usaco2017december;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MilkMeasurement
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\jieli\\Downloads\\USACO\\MilkMeasurement\\2.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("C:\\Users\\jieli\\Downloads\\USACO\\MilkMeasurement\\measurement.out")));
		//BufferedReader br = new BufferedReader(new FileReader("measurement.in"));
		//PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("measurement.out")));
		StringTokenizer st;
		
		int [] BEM = new int [3];
		final String [] coworder = {"Bessie", "Elsie", "Mildred"}; 
		int N = Integer.parseInt(br.readLine());
		int leadingProduction=0;
		String leadingCow="";
		int changes=0;
		String [][] logbook = new String [N][3];
		int NextSmallestDay=0;
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			logbook [i][0] = st.nextToken();
			logbook [i][1] = st.nextToken();
			logbook [i][2] = st.nextToken();
		}
		
		
		for(int j=0; j<N; j++) {
			
			//Cycle trough to find smallest day
			int top=101;
			int pmin=0;
			for(int i=0; i<N; i++) {
				if((Integer.parseInt(logbook[i][0])>NextSmallestDay)&&(Integer.parseInt(logbook[i][0])<top)) {
					top=Integer.parseInt(logbook[i][0]);
					pmin=i;
				}
			}
			NextSmallestDay=Integer.parseInt(logbook[pmin][0]);
		
		
			
			String add = logbook[pmin][2];
			int pcow=0;
			//checks if change is increment or decrement
			if(add.charAt(0)=='+') {
				//find cow that is going through the change
				for(int i=0; i<3; i++) {
					if(logbook[pmin][1].equals(coworder[i]))pcow=i;
				}
				//Updates the cow's milking production
				BEM[pcow]=BEM[pcow]+Character.getNumericValue(add.charAt(1));
			}
			else {
				//find cow that is going through the change
				for(int i=0; i<3; i++) {
					if(logbook[pmin][1].equals(coworder[i]))pcow=i;
				}
				//Updates the cow's milking production
				BEM[pcow]=BEM[pcow]-Character.getNumericValue(add.charAt(1));
			}
			//Checks for matches
			Boolean match=false;
			for(int i=0; i<BEM.length; i++) {
				if(i==pcow) {
					
				}
				else if(BEM[i]==BEM[pcow]) {
					match=true;
				}
			}
			//Checks for leaderboard changes
			if(((BEM[pcow]>=leadingProduction)&&(!coworder[pcow].equals(leadingCow)))||(match)) {
				changes++;
				leadingProduction=BEM[pcow];
				leadingCow=coworder[pcow];
			}
		
		}
		pw.print(changes);
		pw.close();
		
	}

}
