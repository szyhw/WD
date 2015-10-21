package cn.edu.tju.constructsubquery;

import java.util.ArrayList;

public class Variable {
	public static ArrayList<String> get_variable(String pattern){
		String[] subpattern=pattern.split(" ");
		ArrayList<String> variables=new ArrayList<String>();
		for (int i = 0; i < subpattern.length; i++) {
			String s=subpattern[i];
			if(s.startsWith("?")){
				variables.add(s);
			}
		}
		return variables;
	}

}
