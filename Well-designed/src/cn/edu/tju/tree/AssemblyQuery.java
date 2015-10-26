package cn.edu.tju.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

import cn.edu.tju.constructsubquery.ConstructQuery;
import cn.edu.tju.join.ConstructMap;
import cn.edu.tju.join.Matching;
import cn.edu.tju.sparqlresult.GetSparqlResults;
import cn.edu.tju.sparqlresult.SparqlResultSet;

public class AssemblyQuery {
	public static Stack<HashMap<String, ArrayList<String>>> postOrder(TreeNode currNode,String query,Stack<HashMap<String, ArrayList<String>>> stack){//ºóÐò±éÀú
		if(currNode != null){
			postOrder(currNode.left,query,stack);
			postOrder(currNode.right,query,stack);
			System.out.print(currNode.data+"  ");
			if(!currNode.data.equals("OPTIONAL")){
				String subquery = ConstructQuery.constructquery(query, currNode.data);
				//get result from gstore,asume it as answer
				String answer="";
				if(answer.length()>1){
					ArrayList<ArrayList<String>> result = GetSparqlResults.getsparqlresults(answer);
					ArrayList<ArrayList<String>> sparqlresult = SparqlResultSet.sparqlresultset(result);
					HashMap<String, ArrayList<String>> map = ConstructMap.constructmap(subquery,sparqlresult);
					stack.push(map);
				}
			}
			else{
				HashMap<String, ArrayList<String>> right = stack.pop();
				HashMap<String, ArrayList<String>> left = stack.pop();
				HashMap<String, ArrayList<String>>	match_result = Matching.matching(left,right);
				stack.push(match_result);
			}
		}
		return stack;
	}

}
