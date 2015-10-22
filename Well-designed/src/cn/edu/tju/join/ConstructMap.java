package cn.edu.tju.join;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class ConstructMap {
	public static HashMap<String, HashSet<String>> constructmap(String subquery,ArrayList<HashSet<String>> ahs){
		int start=subquery.indexOf("SELECT ");
		int end=subquery.indexOf("WHERE", start);
		String subString=subquery.substring(start, end);
		String[] s=subString.split(" ");
		ArrayList<String> variables=new ArrayList<String>();
		for (int i = 0; i < s.length; i++) {
			if(s[i].startsWith("?")){
				variables.add(s[i]);
			}
		}
		HashMap<String, HashSet<String>> subresult=new HashMap<String, HashSet<String>>();
		int length=ahs.size();
		if(length!=variables.size()){
			HashSet<String> hs=new HashSet<String>();
			hs.add("[empty result]");
			for (int i = 0; i < variables.size(); i++) {
				subresult.put(variables.get(i), hs);
			}
		}
		else if(length==variables.size()){
			for (int i = 0; i < length; i++) {
				subresult.put(variables.get(i),ahs.get(i));
			}
		}
		return subresult;
	}

}
