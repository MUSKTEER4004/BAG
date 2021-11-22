package org.ding.entity;

import lombok.Data;

import java.util.List;
@Data
public class GraphBAG {
    List<GraphNode> graphNodeList;
    List<GraphEdge> graphEdgeList;
}
