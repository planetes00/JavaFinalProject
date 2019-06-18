package edu.handong.utils;

	import java.io.IOException;
	import java.io.InputStream;
	import java.util.Enumeration;
	import java.net.*;
	import java.io.*;
	import java.util.*;

	import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
	import org.apache.commons.compress.archivers.zip.ZipFile;
	import edu.handong.datamodel.*;

	public class ZipReader {

		public void readFileInZip(String path,HashMap<String,ResultOne> hm) {
			ZipFile zipFile;
			try {
				zipFile = new ZipFile(path);
				Enumeration<? extends ZipArchiveEntry> entries = zipFile.getEntries();
				Lines ho=null;
				String tempname="";
				int i=0;
			    while(entries.hasMoreElements()){
			    	ZipArchiveEntry entry = entries.nextElement();
			        InputStream stream = zipFile.getInputStream(entry);
			    
			        ExcelReader myReader = new ExcelReader();
			        
			        if(i!=0) {
				        for(String value:myReader.getData(stream)) {
				        	ho=new Lines(value);
				        	if(ho.checkPic()||ho.checkTable()) {
				        		if(!ho.checkFirst()) {
				        			tempname=ho.getTitle();
				        			hm.put(tempname,new ResultOne(ho.getTitle()));
				        			hm.get(tempname).addLine(ho);
				        		}
				        		
				        	}
				        }
			        }
			        i++;
			    }
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


