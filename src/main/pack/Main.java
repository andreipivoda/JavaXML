package main.pack;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.filefilter.RegexFileFilter;



public class Main {

	public static void main(String[] args) {
		List<File> filteredFiles = new ArrayList<>();

		while(true) { //always search for 

			filteredFiles = getFile(); //new files
			System.out.println(filteredFiles);
			
			for (File file : filteredFiles) {
				System.out.println("Processing : "+ file.getAbsolutePath());
				Solver solve = new Solver();
				solve.parseXML(file);
				solve.saveToXML();
				solve.moveFile(file);
			}
			try {
				Thread.sleep(5000); //wait 5 seconds then loop back
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	private static List<File> getFile() {
		
		File directory = new File("input"); //working directory
		File[] files = directory.listFiles();
		//		file name pattern is orders##.xml, where ## are digits
		String pattern = "orders[0-9][0-9]\\.xml";
		FileFilter filter = new RegexFileFilter(pattern); //apply regex
		files = directory.listFiles(filter); //list of filtered files	
		return Arrays.asList(files);

	}



}
