package cn.edu.tju.sparqlresult;

import java.util.ArrayList;
import java.util.HashSet;

public class SparqlResultSet {
	public static ArrayList<HashSet<String>> sparqlresultset(ArrayList<ArrayList<String>> results){
		ArrayList<HashSet<String>> ahs = new ArrayList<HashSet<String>>();
		if(!results.get(0).isEmpty()){
			ahs=ConvertStandardForm.convertstandardform(results);
		}
		else{
			ahs.clear();
		}
		return ahs;
	}

}
