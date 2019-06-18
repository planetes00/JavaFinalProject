package edu.handong.datamodel;

import java.net.*;
import java.io.*;
import java.util.*;

import edu.handong.utils.*;
import edu.handong.datamodel.*;

public class CountMaterial{
	private String studentName;
	private HashMap<String,ResultOne> hm;
	
	
	public CountMaterial(String path, HashMap<String,ResultOne> hm1) {
		studentName=path.substring(0,path.indexOf("."));
		ZipReader zipReader = new ZipReader();
		hm=zipReader.readFileInZip(path,hm);
		this.hm=hm1;
	}
	public String getName() {
		return this.studentName;
	}
	public HashMap<String,ResultOne> giveList(){
		return this.hm;
	}
	
}
