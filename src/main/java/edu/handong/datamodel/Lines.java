package edu.handong.datamodel;

public class Lines {
	
	private String title;
	private String number;
	private String exp;
	private String pageNumber;
	
	
	public Lines(String line){
		String[] array = line.split(",");
		this.title= array[0].trim();
		this.number=array[1].trim();
		this.exp=array[2].trim();
		this.pageNumber=array[3].trim();
	}
	
	public boolean checkPic() {
		if(this.exp.equals("그림")) return true;
		return false;
	}
	public boolean checkTable() {
		if(this.exp.equals("표")) return true;
		return false;
	}
	public boolean checkFirst() {
		if(this.title.equals("")) return true;
		return false;
	}
	public String getTitle() {
		return this.title;
	}
}
