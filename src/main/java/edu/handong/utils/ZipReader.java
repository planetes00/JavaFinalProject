package edu.handong.utils;

	import java.io.IOException;
	import java.io.InputStream;
import java.net.*;
	import java.io.*;
	import java.util.*;

	import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
	import org.apache.commons.compress.archivers.zip.ZipFile;
	import edu.handong.datamodel.*;

	public class ZipReader {

		public HashMap<String,ResultOne> readFileInZip(String path,HashMap<String,ResultOne> hm1) {
			ZipFile zipFile;
			HashMap<String,ResultOne> hm =new HashMap();
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
				        	//System.out.println(ho.getTitle());
				        	if(ho.checkPic()||ho.checkTable()) {
				        		if(!ho.checkFirst()) {
				        			tempname=ho.getTitle();
				        			hm.put(tempname,new ResultOne(tempname));
				        		}
				        		hm.get(tempname).addLine(ho);
				        	}
				        }
			        }
			        i++;
			        
			    }
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("정렬했을때 : " + hm);
			return hm;
		}
	}


