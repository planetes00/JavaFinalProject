package edu.handong.analysis;

import java.io.File;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

import java.util.*;
import edu.handong.datamodel.*;
import edu.handong.utils.*;

public class DataAdder {
	
	private HashMap<String,ResultOne> hm1;
	private CountMaterial nw;
	private String input;
	private String output;
	private String analysis;
	private String coursecode;
	private String startyear;
	private String endyear;
	private boolean help;
	
	public void run(String[] args) {
		Options options = createOptions();
		
		
		if(parseOptions(options, args)){
			if (help){
				printHelp(options);
				return;
			}
		}
		
		try {
			// when there are not enough arguments from CLI, it throws the NotEnoughArgmentException which must be defined by you.
			if(args.length<2)
				throw new NotEnoughArgumentException();
		} catch (NotEnoughArgumentException e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}
		String dataPath = input; // csv file to be analyzed
		String resultPath = output; // the file path where the results are saved.
		
		nw = new CountMaterial(dataPath,hm1);
		hm1= nw.giveList();
		Map<String, ResultOne> sorted = new TreeMap<String,ResultOne>(hm1);
		ArrayList<String> linesToBeSaved = countNumber(sorted);
		Utils.writeAFile(linesToBeSaved, resultPath);
	
	}
	
	

	private ArrayList<String> countNumber(Map<String, ResultOne> hm) {
		ArrayList<String> ho=new ArrayList<>();
		
		
		Iterator<String> keySetIterator = hm.keySet().iterator();

		while (keySetIterator.hasNext()) {

			String pw=keySetIterator.next();;
			ho.add(nw.getName()+","+hm.get(pw).getTitle()+","+hm.get(pw).getPic()+","+hm.get(pw).getTable());
			
			
		}

		ho.add(0,nw.getName()+", 제목, 그림의 수, 표의 수");
		return ho; // do not forget to return a proper variable.
	}
	
	private Options createOptions() {
		Options options = new Options();
		
		options.addOption(Option.builder("i").longOpt("input")
				.desc("Input path")
				.hasArg()
				.argName("Set an input file path")
				.required()
				.build());
		
		options.addOption(Option.builder("o").longOpt("output")
				.desc("Output path")
				.hasArg()
				.argName("Set an output file path")
				.required()
				.build());
		
		
		options.addOption(Option.builder("h").longOpt("help")
		        .desc("Help")
		        .build());
		
		return options;
	}
	
	private boolean parseOptions(Options options, String[] args) {
		CommandLineParser parser = new DefaultParser();

		try {

			CommandLine cmd = parser.parse(options, args);

			input = cmd.getOptionValue("i");
			output = cmd.getOptionValue("o");
			help = cmd.hasOption("h");

		} catch (Exception e) {
			printHelp(options);
			return false;
		}

		return true;
	}
	
	private void printHelp(Options options) {
		// automatically generate the help statement
		HelpFormatter formatter = new HelpFormatter();
		String header = "HGU Course Analyzer";
		String footer = "" ; // Leave this empty.

		formatter.printHelp("HGU Course Analyzer", header, options, footer, true);
	}
}
