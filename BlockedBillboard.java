

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class BlockedBillboard
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader("billboard.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("billboard.out")));
		StringTokenizer st;
	
		st=new StringTokenizer(br.readLine());
		int [] bb1 = new int [4];
		int [] bb2 = new int [4];
		int [] truck = new int [4];
	
		for(int i=0;i<4;i++) {
			bb1[i]=Integer.parseInt(st.nextToken());	
		}
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<4;i++) {
			bb2[i]=Integer.parseInt(st.nextToken());	
		}
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<4;i++) {
			truck[i]=Integer.parseInt(st.nextToken());	
		}
		
		//area of billboards
		int A1=(bb1[3]-bb1[1])*(bb1[2]-bb1[0]);
		int A2=(bb2[3]-bb2[1])*(bb2[2]-bb2[0]);
		int [] A1BR = {bb1[2],bb1[1]};
		int [] TruckTL = {truck[2], truck[1]};
		int x=0;
		int y=0;
		//find area of x
		if((TruckTL[1]<A1BR[1])||(TruckTL[0]>A1BR[0])) {} 
		else x=(TruckTL[1]-A1BR[1])*(A1BR[0]-TruckTL[0]);
		//find area of y
		if((truck[3]<bb2[1])||(truck[2]<bb2[0])) {} 
		else y=(truck[2]-bb2[0])*(truck[3]-bb2[1]);
		
		pw.print((A1+A2)-(x+y));
		pw.close();
		
		
		
		
	
	
	}

}
