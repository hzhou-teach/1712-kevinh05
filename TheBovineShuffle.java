
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class TheBovineShuffle
{

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader("shuffle.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("shuffle.out")));
		StringTokenizer st;
		

		int n = Integer.parseInt(br.readLine());
		String[] Start = new String[n];
		//initialize boogie
		st = new StringTokenizer(br.readLine());
		int[] boogie = new int [n];
		for(int i=0; i<n; i++) {
			boogie[i]=Integer.parseInt(st.nextToken());
		}
		//initialize IDs
		String[] finalorder = new String [n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			finalorder[i]=st.nextToken();
		}
	
	
		for(int i=1; i<4; i++) {
			
			for(int j=1; j<=n; j++) {
				int original=0;
				
				for(int k=0;k<n; k++) {
					if(j==boogie[k]) {
						original=k;
						System.out.println(k);
						break;
					}
				}
				
				Start[original]=finalorder[j-1];
				System.out.println(finalorder[(j-1)]);
			
			}
			finalorder=Start.clone();
		}
		for(String ID : Start) {
			pw.print(ID);
			pw.println();
		}
		pw.close();
	
		
		
		
	}

}
