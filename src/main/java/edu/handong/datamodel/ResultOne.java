package edu.handong.datamodel;

import edu.handong.datamodel.*;
import java.net.*;
import java.io.*;
import java.util.*;

public class ResultOne {
	private String title;
	private ArrayList<Lines> lines;
	
	private int picNum=0;
	private int picTable=0;
	public ResultOne(String name) {
		this.title=name;
	}
	public void addLine(Lines l) {
		if(this.lines==null) lines=new ArrayList<Lines>();
		this.lines.add(l);
	}
	public int getPic() {
		for(Lines l:lines)
			if(l.checkPic()) picNum++;
		return picNum;
	}
	public int getTable() {
		for(Lines l:lines)
			if(l.checkTable()) picTable++;
		return picTable;
	}
	public String getTitle() {
		return this.title;
	}
}
