import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class BitPositions {
	private String fName;
	private int n;
	private int p1;
	private int p2;
	BitPositions(){
		
	}
	private void SetFileName(String name){
		fName = name;
	}
	private BufferedReader readFromFile(){
		BufferedReader br=null;
		try
		{
			FileReader fReader = new FileReader(fName);//this.fileName contains the name of file passed as command line argument
			br = new BufferedReader(fReader);
		}
		catch(FileNotFoundException ex){
			System.out.println("File " + fName + " not Found. Program will exit.");
			System.out.println("Execute again and provide proper file name with entire path.");
			System.exit(0);
			return null;
		}
	    return br;
	}
	private void SetParameters(){
		String line = null;
		BufferedReader bReader = readFromFile();
		
		try{
			while((line = bReader.readLine()) != null){
				StringTokenizer st = new StringTokenizer(line,",");
				n = Integer.parseInt(st.nextToken()) ;
				p1 = Integer.parseInt(st.nextToken());
				p2 = Integer.parseInt(st.nextToken());
				ProcessOutput();
				System.out.println();
				
			}
		}
		catch (IOException ex) {
			System.out.println("IO Exception");
			System.exit(0);
		}
	}
	private void ProcessOutput(){
		//Get the p1 bit of n, & p2 bit of n 
		//(Creating bitmasks by shifting a '1' bit into the correct position using shift left (<<)
		//Compare them for equality
		Boolean result = ((n >> (p1-1))&1) == ((n >> (p2-1))&1);
		
		if(result==true){
			System.out.print("true");
		}
		else{
			System.out.print("false");
		}
	}
	
	public static void main(String[] args){
		BitPositions bp = new BitPositions();
		String fileName = null;
		fileName = "E:\\Eclipse workspace\\BitPositions\\src\\in.txt";
		//fileName = args[0];
		bp.SetFileName(fileName);
		bp.SetParameters();
		System.exit(0);
	}

}
