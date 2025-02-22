package edu.kit.kastel.sdq.case4lang.refactorlizar.architecture_evaluation.size;

import com.google.common.graph.Graph;
import edu.kit.kastel.sdq.case4lang.refactorlizar.architecture_evaluation.CalculationMode;
import edu.kit.kastel.sdq.case4lang.refactorlizar.architecture_evaluation.graphs.Node;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HyperGraphSizeCalculator<T> {

    private CalculationMode mode;

    public HyperGraphSizeCalculator() {
        mode = CalculationMode.MARTIN;
    }

    public HyperGraphSizeCalculator(CalculationMode mode) {
        this.mode = mode;
    }

    public double calculate(Graph<Node<T>> systemGraph) {
        /*
        Schau für jeden Knoten an zu welcher HyperEdge er verbunden ist.
        Das gibt ein Pattern.
        Für jeden Knoten schauen wie oft sein Pattern ist.
        Durch |HyperEdges| teilen
        Darüber -log_2
        das alles summieren.
        */
        Map<BitSet, Integer> patterns = new HashMap<>();
        PatternGenerator<T> generator = new PatternGenerator<>();
        Set<Node<T>> nodes = systemGraph.nodes();
        for (Node<T> node : nodes) {
            BitSet pattern = generator.createPattern(new ArrayList<>(systemGraph.edges()), node);
            if (patterns.get(pattern) == null) {
                patterns.put(pattern, 1);
            } else {
                patterns.merge(pattern, 1, (a, b) -> a + b);
            }
        }
        double size = 0;
        for (Node<T> node : nodes) {
            BitSet pattern = generator.createPattern(new ArrayList<>(systemGraph.edges()), node);
            double prob = patterns.get(pattern);
            size += log2(prob / getSystemSize(nodes));
        }
        return size;
    }

    private int getSystemSize(Set<Node<T>> nodes) {
        return mode == CalculationMode.REINER ? nodes.size() + 1 : nodes.size();
    }

    private double log2(double value) {
        return -Math.log(value) / Math.log(2);
    }
}
