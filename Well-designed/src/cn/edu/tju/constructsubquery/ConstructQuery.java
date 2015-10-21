package cn.edu.tju.constructsubquery;

import java.util.ArrayList;

import cn.edu.tju.prefix.Prefix;

public class ConstructQuery {
	public static String constructquery(String query,String subpattern){
		String prefix=Prefix.find_prefix(query);
		ArrayList<String> variables=Variable.get_variable(subpattern);
		String var="";
		for (int i = 0; i < variables.size(); i++) {
			var=var+variables.get(i)+" ";
		}
		String results="";
		if(subpattern.contains("{")){
			results=prefix+" "+"SELECT "+var+" "+"WHERE "+subpattern;
		}
		else{
			results=prefix+" "+"SELECT "+var+" "+"WHERE {"+subpattern+" }";
		}
		return results;
	}

}
