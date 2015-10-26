package cn.edu.tju.execute;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cn.edu.tju.constructsubquery.ConstructQuery;
import cn.edu.tju.constructsubquery.Variable;
import cn.edu.tju.join.Matching;
import cn.edu.tju.prefix.Prefix;
import cn.edu.tju.rules.ConvertRules;
import cn.edu.tju.rules.GetAllString;
import cn.edu.tju.rules.GetAndString;
import cn.edu.tju.rules.GetOptionalString;
import cn.edu.tju.rules.GetResults;
import cn.edu.tju.sparqlresult.InvertedMatrix;
import cn.edu.tju.sparqlresult.GetSparqlResults;
import cn.edu.tju.sparqlresult.SparqlResult;
import cn.edu.tju.tree.AssemblyQuery;
import cn.edu.tju.tree.OptTree;
import cn.edu.tju.tree.TreeNode;
import cn.edu.tju.where.Where;

public class execute {
	public static void main(String[] args) {
		String query = "PREFIX owl:<http://www.w3.org/2002/07/owl#>   PREFIX psiSchool:<http://www.openpsi.org/def/school/>   PREFIX pop:<http://statistics.data.gov.uk/def/population/>   PREFIX year:<http://statistics.data.gov.uk/def/census-year/>   PREFIX scv:<http://purl.org/NET/scovo#>   PREFIX skos:<http://www.w3.org/2008/05/skos#>   PREFIX rdfs:<http://www.w3.org/2000/01/rdf-schema#>   PREFIX psi-id:<http://reference.data.openpsi.org/id/>   PREFIX reg:<http://statistics.data.gov.uk/id/government-office-region/>   PREFIX foaf:<http://xmlns.com/foaf/0.1/>   PREFIX skos2004:<http://www.w3.org/2004/02/skos/core#>   PREFIX psi:<http://reference.data.openpsi.org/def/>   PREFIX void:<http://rdfs.org/ns/void#>   PREFIX dc:<http://purl.org/dc/elements/1.1/>   PREFIX dct:<http://purl.org/dc/terms/>   PREFIX geo:<http://statistics.data.gov.uk/def/census-geography/>   PREFIX admingeo:<http://data.ordnancesurvey.co.uk/ontology/admingeo/>   PREFIX sdmx:<http://proxy.data.gov.uk/sdmx.org/def/sdmx/>   PREFIX rdf:<http://www.w3.org/1999/02/22-rdf-syntax-ns#>   PREFIX xsd:<http://www.w3.org/2001/XMLSchema#>   PREFIX time:<http://www.w3.org/2006/time#>   PREFIX os:<http://www.ordnancesurvey.co.uk/ontology/v1/AdministrativeGeography#>   SELECT distinct  ?sub  ?super  ?sublabel ?suplabel WHERE{ {?sub rdfs:subClassOf ?super .} OPTIONAL {?sub rdfs:label ?sublabel } OPTIONAL {?sup rdfs:label ?suplabel } }";
		String prefix=Prefix.find_prefix(query);
		String where=Where.find_where(query);
		System.out.println(prefix);
		System.out.println(where);
		String results=GetResults.getresults(where);
		System.out.println("rules:	"+results);
		TreeNode Root=OptTree.construcTree(where);
		OptTree.postOrder(Root);
		Stack<HashMap<String, ArrayList<String>>> stack = new Stack<HashMap<String, ArrayList<String>>>();
		Stack<HashMap<String, ArrayList<String>>> line = AssemblyQuery.postOrder(Root, query, stack);
		System.out.println(line);
	}

}
