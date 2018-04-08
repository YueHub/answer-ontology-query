package cn.lcy.ontology.query;

import cn.lcy.ontology.query.sem.model.QueryResult;
import cn.lcy.ontology.query.service.QueryServiceI;
import cn.lcy.ontology.query.service.QueryServiceImpl;

public class Main {

  public static void main(String[] args) {
    QueryServiceI queryService = QueryServiceImpl.getInstance();

    String query = "SELECT ?导演姓名 WHERE { mymo:489e1493d8b34285b5a24017e574c0f5 mymo:有导演 ?导演.\n"
      + "?导演 mymo:有中文名 ?导演姓名.}";
    QueryResult queryResult = queryService.queryOntology(query);
    System.out.println(queryResult.getAnswers().get(0).getContent());
  }

}
