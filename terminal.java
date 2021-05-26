package terminal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.io.*;
import java.io.File;
import java.nio.file.Paths;

public class terminal {
  
	  public void rm (String sourcepath)
	  {
		
		 File b =new File(sourcepath);
		 if(b.delete()) 
		 {
			 System.out.print("file is delete");
		 }
		 else
			 System.out.print("failed to delete");
	  }
	  public void rmdir (String sourcepath)
	  {
		  File dir  =new File(sourcepath);
			  if(dir.delete()) 
				 {
					 System.out.print("directory is delete");
				 }
				 else
					 System.out.print("failed to delete");
		 
		 
		
	  }
	  public void ls (String sourcepath)
	  {
		  File dir  =new File(sourcepath);
			  if(dir.isDirectory() )
				 {
				  String[] files=dir.list();
				  for(int i=0;i<files.length;i++)
				  {
					System.out.print(files[i]);
				  }
				 }                                     	
	  }
	public void date () 
	  {
		 LocalDateTime myDateObj = LocalDateTime.now();  
		    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("E, MMM dd yyyy HH:mm:ss");  
		    
		    String formattedDate = myDateObj.format(myFormatObj);  
		    System.out.println(formattedDate);
	  }
	public void more (String paths) throws FileNotFoundException 
	  {
		Scanner scanner =new Scanner (new File(paths)).useDelimiter("\\Z");
			    String contents = scanner.next();
			    System.out.println(contents);
			    scanner.close();
	  }
	public void cat(String[] paths)
	{
		try{
			for(int i=0;i<paths.length;i++) {
			
				File file=new File(paths[i]);	
				//if the file does not exist
				if(!file.exists())
				{
					System.out.println(file.getName()+":No such file or directory");
					continue;
				}
				else {
					//check if the file is a directory
					if(file.isDirectory()) {
						System.out.println(file.getName()+" :Is a directory");
						continue;
					}
				
			  // Open the file that is the first 
			  // command line parameter
			  FileInputStream fstream = new FileInputStream(paths[i]);
			 
			  // Get the object of DataInputStream
			  DataInputStream in = new DataInputStream(fstream);
			  BufferedReader br = new BufferedReader(new InputStreamReader(in));
			  String strLine;
			  //Read File Line By Line
			  while ((strLine = br.readLine()) != null)   {
			  
			  System.out.print(strLine);
			  }
			
			  //Close the input stream
			  in.close();
			}
			    }
		}catch (Exception e){//Catch exception if any
			  System.err.println("Error: " + e.getMessage());
			  }
		}
	static public void clear() {
	                String a = "\n";
	                a = a.repeat(100);
	                System.out.println(a);
	            }
		  

	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
	   terminal ma=new terminal();
	   ma.date();
	   String aa[]= {"marina33"};
	   ma.cat(aa);
		
		 

	}

}
