package cn.edu.tju.execute;

import java.util.ArrayList;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cn.edu.tju.constructsubquery.ConstructQuery;
import cn.edu.tju.constructsubquery.Variable;
import cn.edu.tju.prefix.Prefix;
import cn.edu.tju.rules.ConvertRules;
import cn.edu.tju.rules.GetAllString;
import cn.edu.tju.rules.GetAndString;
import cn.edu.tju.rules.GetOptionalString;
import cn.edu.tju.rules.GetResults;
import cn.edu.tju.sparqlresult.SparqlResult;
import cn.edu.tju.tree.OptTree;
import cn.edu.tju.tree.TreeNode;
import cn.edu.tju.where.Where;

public class execute {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		String str="{{A.Z.}X.} OPTIONAL {B.C.} OPTIONAL D";
		TreeNode Root=OptTree.construcTree(str);
		OptTree.postOrder(Root);
		OptTree.preOrder(Root);*/
		//String query="{{A.B.}OPTIONAL {C.}{D.}}{{E.}OPTIONAL{F.}}";
		//String query="{E.}{{A.B.}OPTIONAL{C.}OPTIONAL{D.}}";
		//String  query=" {?b a lgdo:Peak. ?b wgs84:geometry ?point.} OPTIONAL { ?b rdfs:label ?v0 . } OPTIONAL { ?b geo:geometry ?v1 . } ";
		//String query="{{A.}{B.}}OPTIONAL{C.D.}";
		/*
		String str="PREFIX  rdfs: <http://www.w3.org/2000/01/rdf-schema#> PREFIX  dbprop: <http://dbpedia.org/property/>  SELECT  ?x ?label WHERE   { {?x  dbprop:redirect  <http://dbpedia.org/resource/Bear-resistant_food_storage_container> .}     OPTIONAL       { ?x  rdfs:label  ?label .}   } ";
		String query=Where.find_where(str);
		System.out.println("query:	"+query);
		System.out.println("prefix:	"+Prefix.find_prefix(str));
		String results=GetResults.getres`ults(query);
		System.out.println(results);
		TreeNode Root=OptTree.construcTree(results);
		OptTree.preOrder(Root);
		System.out.println();
		OptTree.inOrder(Root);
		System.out.println();
		OptTree.postOrder(Root);
		System.out.println();*/
		//System.out.println(SparqlResult.get_result("\"a  b  c\" \"dd  ee  ff\"@en <gg>"));
		//System.out.println(Variable.get_variable("?x  dbprop:redirect  <http://dbpedia.org/resource/Mineral_water> .     OPTIONAL       { ?x  rdfs:label  ?label .} "));
		String query="PREFIX  rdfs: <http://www.w3.org/2000/01/rdf-schema#> PREFIX  dbprop: <http://dbpedia.org/property/>  SELECT  ?x ?label WHERE   { {?x  dbprop:redirect  <http://dbpedia.org/resource/Dungeons_%26_Dragons> .}     OPTIONAL       { ?x  rdfs:label  ?label .}   } ";
		String s=GetResults.getresults(Where.find_where(query));
		//System.out.println(s);
		TreeNode Root=OptTree.construcTree(s);
		//OptTree.postOrder(Root);
		System.out.println(ConstructQuery.constructquery(query,"?x  dbprop:redirect  <http://dbpedia.org/resource/Dungeons_%26_Dragons> ."));
		//System.out.println(ConstructQuery.constructquery("PREFIX  rdfs: <http://www.w3.org/2000/01/rdf-schema#> PREFIX  dbprop: <http://dbpedia.org/property/>  SELECT  ?x ?label WHERE   { {?x  dbprop:redirect  <http://dbpedia.org/resource/Dungeons_%26_Dragons> .     OPTIONAL       { ?x  rdfs:label  ?label .}   } ","?x  dbprop:redirect  <http://dbpedia.org/resource/Dungeons_%26_Dragons> . "));
	}

}
