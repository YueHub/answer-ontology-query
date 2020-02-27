package cn.lcy.ontology.query;

import cn.lcy.ontology.query.dao.QueryDAOI;
import cn.lcy.ontology.query.dao.QueryDAOImpl;
import cn.lcy.ontology.query.sem.model.QueryResult;

public class Main {

    public static void main(String[] args) {
        QueryDAOI queryDAO = QueryDAOImpl.getInstance();

        String query = "SELECT ?导演姓名 WHERE { mymo:489e1493d8b34285b5a24017e574c0f5 mymo:有导演 ?导演.\n"
                + "?导演 mymo:有中文名 ?导演姓名.}";
        QueryResult queryResult = queryDAO.queryOntology(query);
        System.out.println(queryResult.getAnswers().get(0).getContent());
        System.out.println(queryDAO.querySameIndividual("c1eff05c87504975b2820960ee25b2d7"));
    }

}
