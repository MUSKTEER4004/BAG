package org.ding.utils;

import org.ding.entity.GraphBAG;
import org.ding.entity.GraphEdge;
import org.ding.entity.GraphNode;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class XMLReader {
    public void ReadGraph(GraphBAG graphBAG) throws DocumentException {
        List<GraphNode> graphNodeList=new ArrayList<>();
        List<GraphEdge> graphEdgeList=new ArrayList<>();
        //创建Reader对象
        SAXReader reader = new SAXReader();
        //加载xml
        Document document = reader.read(new File("src/main/resources/AttackGraph.xml"));
        //获取根节点
        Element rootElement = document.getRootElement();
        //获取arc子节点
        Element arcs=rootElement.element("arcs");
        List<Element> arc=arcs.elements("arc");
        for (Element a:arc){
            String src=a.elementTextTrim("src");
            String dst=a.elementTextTrim("dst");
            GraphEdge edge=new GraphEdge();
            edge.setStart(src);
            edge.setEnd(dst);
            graphEdgeList.add(edge);
        }
        //获取vertex子节点
        Element vertices=rootElement.element("vertices");
        List<Element> vertex=vertices.elements("vertex");
        for (Element v:vertex){
            String id=v.elementTextTrim("id");
            String fact=v.elementTextTrim("fact");
            String metric=v.elementTextTrim("metric");
            String type=v.elementTextTrim("type");
            GraphNode node=new GraphNode();
            node.setId(id);
            node.setStatement(fact);
            node.setMetric(metric);
            node.setType(type);
            graphNodeList.add(node);
        }
        graphBAG.setGraphNodeList(graphNodeList);
        graphBAG.setGraphEdgeList(graphEdgeList);
    }

}
