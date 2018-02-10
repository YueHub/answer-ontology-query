package cn.lcy.ontology.query;

import cn.lcy.ontology.query.config.Config;
import cn.lcy.ontology.query.sem.model.QueryResult;
import cn.lcy.ontology.query.service.QueryServiceI;
import cn.lcy.ontology.query.service.QueryServiceImpl;
import org.apache.jena.vocabulary.OWL;
import org.apache.jena.vocabulary.RDFS;

public class Main {

  public static void main(String[] args) {
    QueryServiceI queryService = QueryServiceImpl.getInstance();
    String prefix = "prefix mymo: <" + Config.pizzaNs + ">\n" +
      "prefix rdfs: <" + RDFS.getURI() + ">\n" +
      "prefix owl: <" + OWL.getURI() + ">\n";
    String QL = "SELECT ?导演姓名 WHERE { mymo:美人鱼  mymo:有导演  ?导演.\n"
      + "?导演  mymo:有姓名  ?导演姓名.}";
    String SPARQL = prefix + QL;
    QueryResult queryResult = queryService.queryOntology(SPARQL);
    System.out.println(queryResult);
  }

}
