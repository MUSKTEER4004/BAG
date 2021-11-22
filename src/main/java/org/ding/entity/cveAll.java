package org.ding.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class cveAll {
    private String ID;
    private double exploitabilityScore;
    private double impactScore;
    private double baseScore;
}
