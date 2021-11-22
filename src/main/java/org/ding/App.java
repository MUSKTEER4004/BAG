package org.ding;

/**
 * Hello world!
 *
 */

import guru.nidi.graphviz.attribute.*;
import guru.nidi.graphviz.engine.Format;
import guru.nidi.graphviz.engine.Graphviz;
import guru.nidi.graphviz.model.*;
import org.ding.entity.GraphBAG;
import org.ding.entity.GraphEdge;
import org.ding.entity.GraphNode;
import org.ding.utils.XMLReader;
import org.dom4j.DocumentException;


import java.io.File;
import java.io.IOException;
import java.util.*;

import static guru.nidi.graphviz.model.Factory.*;

public class App 
{
    public static void main( String[] args ) throws DocumentException, IOException {
        // 构造数据
        GraphBAG graphBAG=new GraphBAG();
        XMLReader xmlReader=new XMLReader();
        xmlReader.ReadGraph(graphBAG);
        List<GraphEdge> graphEdgeList = graphBAG.getGraphEdgeList();
        List<GraphNode> graphNodeList = graphBAG.getGraphNodeList();

        MutableGraph g=mutGraph("example1").setDirected(true).use((gr,ctx)->{
            for (GraphEdge graphEdge:graphEdgeList){
                mutNode(graphEdge.getStart()).addLink(graphEdge.getEnd());
            }
        });

        // 输出到本地
        Graphviz.fromGraph(g).width(900).render(Format.PNG)
                .toFile(new File("E:\\images\\ex5.png"));



    }
}
