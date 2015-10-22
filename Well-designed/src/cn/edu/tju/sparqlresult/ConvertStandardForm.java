package cn.edu.tju.sparqlresult;

import java.util.ArrayList;
import java.util.HashSet;

public class ConvertStandardForm {
	public static ArrayList<HashSet<String>> convertstandardform(ArrayList<ArrayList<String>> results){
		ArrayList<HashSet<String>> ash=new ArrayList<HashSet<String>>();
		int sum_variables=results.get(0).size();
		int sum_result=results.size();
		for (int i = 0; i < sum_variables; i++) {
			HashSet<String> hs=new HashSet<String>();
			for (int j = 0; j < sum_result; j++) {
				hs.add(results.get(j).get(i));
			}
			ash.add(hs);
		}
		return ash;
	}

}
