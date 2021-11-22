package org.ding.entity;

import lombok.Data;

@Data
public class GraphNode {
    String id;
    String statement;
    String metric;
    String type;
}
