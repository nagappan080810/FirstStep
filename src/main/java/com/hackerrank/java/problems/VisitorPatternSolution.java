package com.hackerrank.java.problems;
import java.util.ArrayList;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

import java.util.ArrayList;
import java.util.Scanner;

enum Color {
    RED, GREEN
}

abstract class Tree {

    private int value;
    private Color color;
    private int depth;

    public Tree(int value, Color color, int depth) {
        this.value = value;
        this.color = color;
        this.depth = depth;
    }

    public int getValue() {
        return value;
    }

    public Color getColor() {
        return color;
    }

    public int getDepth() {
        return depth;
    }

    public abstract void accept(TreeVis visitor);
}

class TreeNode extends Tree {

    private ArrayList<Tree> children = new ArrayList<>();

    public TreeNode(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitNode(this);

        for (Tree child : children) {
            child.accept(visitor);
        }
    }

    public void addChild(Tree child) {
        children.add(child);
    }
}

class TreeLeaf extends Tree {

    public TreeLeaf(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitLeaf(this);
    }
}

abstract class TreeVis
{
    public abstract int getResult();
    public abstract void visitNode(TreeNode node);
    public abstract void visitLeaf(TreeLeaf leaf);

}

class SumInLeavesVisitor extends TreeVis {
    int result=0;
    public int getResult() {
        //implement this
        return result;
    }

    public void visitNode(TreeNode node) {
        //implement this
    }

    public void visitLeaf(TreeLeaf leaf) {
        //sum of leaf node values
        System.out.println("noOfLeaves" + leaf.getValue());
        result += leaf.getValue();
    }
}

class ProductOfRedNodesVisitor extends TreeVis {
    int result = 1;
    public int getResult() {
        //implement this
        return result;
    }

    public void visitNode(TreeNode node) {
        //product of non leaf red nodes
        if (node.getColor()==Color.RED) {
            result *= node.getValue();
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        //product of red leaf nodes
        if (leaf.getColor()==Color.RED) {
            result *= leaf.getValue();
        }
    }
}

class FancyVisitor extends TreeVis {
    int firstResult, secondResult;
    public int getResult() {
        //absolute value of even non leaf nodes - green leaf nodes
        return Math.abs(firstResult-secondResult);
    }

    public void visitNode(TreeNode node) {
        //sum of even non leaf nodes values.
        if (node.getDepth()%2==0) {
            firstResult += node.getValue();
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        //sum of green leaf nodes values.
        if (leaf.getColor()==Color.GREEN) {
            secondResult += leaf.getValue();
        }
    }
}

public class VisitorPatternSolution {

    public static Tree solve() {
        //read the tree from STDIN and return its root as a return value of this function
        Scanner scan = new Scanner(System.in);
        int noOfNodes = scan.nextInt();
        int values[] = new int[noOfNodes];
        for (int i = 0; i < noOfNodes; i++) {
            values[i] = scan.nextInt();
        }
        int isGreen[] = new int[noOfNodes];
        for (int i = 0; i < noOfNodes; i++) {
            isGreen[i] = scan.nextInt();
        }
        int depth[] = new int[noOfNodes];
        List<Integer> treeParentNodes[]= new ArrayList[noOfNodes];
        Set<Integer> isParent = new HashSet<>();
        //intialize root node as 0..
        depth[0] = 0;
        //create edges and start
        for (int i = 0; i < noOfNodes - 1; i++) {
            int start = scan.nextInt();
            int end = scan.nextInt();
            isParent.add(start);
            //add parentNodes to each node while fetching the edges.
            List<Integer> parentNodes = treeParentNodes[end-1];
            if (parentNodes==null) {
                parentNodes = new ArrayList<>();
            }
            parentNodes.add(start);
            treeParentNodes[end-1] = parentNodes;
            depth[end-1] = depth[start-1]+1;
        }

        List<Tree> nodes = new ArrayList<>();
        Tree node = null;
        TreeNode parentNode = null;
        for (int i = 0; i < noOfNodes; i++) {
            Color nodeColor = isGreen[i] == 1 ? Color.GREEN : Color.RED;

            //tree node is created.
            //if node is in value part then it will not be leaf node
            if (isParent.contains(i+1)) {
                node = new TreeNode(values[i], nodeColor, depth[i]);
            } else {
                node = new TreeLeaf(values[i], nodeColor, depth[i]);
            }
            System.out.println("Parent Nodes -:"+isParent);
            //tree linkage is created..
            if (treeParentNodes[i] !=null) {
                for (Integer parentNumber : treeParentNodes[i]) {
                    System.out.println(treeParentNodes[i]+" "+i);
                    ((TreeNode) nodes.get(parentNumber-1)).addChild(node);
                }
            }

            nodes.add(node);
        }
        return nodes.get(0);
    }

    public static void main(String args[]) {
            Tree root = solve();
            SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
            ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
            FancyVisitor vis3 = new FancyVisitor();

            root.accept(vis1);
            root.accept(vis2);
            root.accept(vis3);

            int res1 = vis1.getResult();
            int res2 = vis2.getResult();
            int res3 = vis3.getResult();

            System.out.println(res1);
            System.out.println(res2);
            System.out.println(res3);
    }
}