package edu.handong.utils;

import java.util.*;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.io.*;
import java.nio.*;
import java.io.FileWriter;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import edu.handong.utils.*;
import edu.handong.datamodel.*;

public class Utils {
	
	
	public static void writeAFile(ArrayList<String> lines, String targetFileName) {
		
		
		
		try (FileWriter writer = new FileWriter(targetFileName)){
			Iterator iterator = lines.listIterator();
			while (iterator.hasNext()) {
				String str1=(String)iterator.next();
				writer.append(str1);
				writer.append('\n');
						
			}
	        writer.flush();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}



	
}
