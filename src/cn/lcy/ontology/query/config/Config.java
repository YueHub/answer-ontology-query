package cn.lcy.ontology.query.config;

import cn.lcy.ontology.query.util.Configuration;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.util.FileManager;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Properties;

public class Config {

    /**
     * 配置文件名
     */
    public static final String PROPERTY_FILE = "answer-ontology-query.properties";

    /**
     * 配置
     */
    public static Properties properties;

    /**
     * 是否使用默认本体数据
     */
    public static String defaultDataSource;

    /**
     * 本体标识
     */
    public static String pizzaNs;

    /**
     * 根路径
     */
    public static String rootPath;

    /**
     * 本体文件路径
     */
    public static String ontologyPath;


    public static OntModel model;

    public static Model loadModel;

    /**
     * 读取配置
     */
    static {
        try {
            properties = Configuration.propertiesLoader(PROPERTY_FILE);
        } catch (IOException e) {
            e.printStackTrace();
        }
        pizzaNs = properties.getProperty("pizzaNs").toString();
        defaultDataSource = properties.getProperty("defaultDataSource").toString();

        if ("true".equals(defaultDataSource)) { // 使用默认数据源
            try {
                ontologyPath = Thread.currentThread().getContextClassLoader().getResource("").toURI().getPath().toString() + "data/Ontologies/Answer_Ontology_V2.owl";
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        } else {
            rootPath = properties.getProperty("rootPath").toString();
            ontologyPath = rootPath + properties.get("ontologyPath").toString();
        }
        model = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM);
        loadModel = FileManager.get().readModel(model, ontologyPath);
    }

    /**
     * 配置类 不需要生成实例
     */
    private Config() {
    }

}
