package Calculator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.function.Function;

import static Calculator.Calculator.Op.*;

public class Calculator {

    interface InfixEvalFunction {
        int eval(int arg1, int arg2);
    }

    @AllArgsConstructor
    enum Op {
        ADD("+", (a1, a2) -> a1 + a2),
        SUBTRACT("-", (a1, a2) -> a1 - a2),
        MULTIPLY("*", (a1, a2) -> a1 * a2),
        DIVIDE("/", (a1, a2) -> a1 / a2);

        private String operator;
        private InfixEvalFunction operation;

        public String getOp() {
            return this.operator;
        }

        public int eval(int arg1, int arg2) {
            return this.operation.eval(arg1, arg2);
        }

        public static Op parse(String token) {
            for (Op op : Op.values()) {
                if (op.getOp().equals(token)) {
                    return op;
                }
            }
            return null;
        }

        public static ExprVal toExprVal(String token) {
            Op parsed = parse(token);
            if (parsed != null) {
                return ExprVal.builder().op(parsed).build();
            } else {
                throw new IllegalArgumentException("Cannot parse token: " + token);
            }
        }
    }

    static List<Op> ORDER_OF_OPS = Arrays.asList(MULTIPLY, DIVIDE, ADD, SUBTRACT);

    static class OpComparator implements Comparator<Op> {
        @Override
        public int compare(Op o1, Op o2) {
            return -1 * Integer.compare(ORDER_OF_OPS.indexOf(o1), ORDER_OF_OPS.indexOf(o2));
        }
    }

    @Builder
    static class ExprVal {
        private Op op;
        private Integer val;

        boolean isOp() {
            return val == null;
        }

        public Op getOp() {
            return op;
        }

        public void setOp(Op op) {
            this.op = op;
        }

        public Integer getVal() {
            return val;
        }

        public void setVal(Integer val) {
            this.val = val;
        }
    }

    static class IntNode extends ExprNode {
        private ExprVal val;

        public IntNode(ExprVal val) {
            super();
            this.val = val;
        }

        public ExprVal getVal() {
            return this.val;
        }

        @Override
        public boolean isLeaf() {
            return true;
        }
    }

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    static class ExprNode {
        private ExprNode left = null;
        private ExprNode right = null;
        ExprVal val;

        public ExprNode getLeft() {
            return left;
        }

        public void setLeft(ExprNode left) {
            this.left = left;
        }

        public ExprNode getRight() {
            return right;
        }

        public void setRight(ExprNode right) {
            this.right = right;
        }

        public ExprVal getVal() {
            return val;
        }

        public void setVal(ExprVal val) {
            this.val = val;
        }

        public boolean isLeaf() {
            return false;
        }

        private int evaluate() {
            if (!this.getVal().isOp()) {
                return this.getVal().getVal();
            } else {
                return this.getVal().getOp().eval(this.getLeft().evaluate(), this.getRight().evaluate());
            }
        }

        private String toStringHelper(int padding) {
            String padString = StringUtils.leftPad("", padding, ' ');
            String valAsString = getVal().isOp() ? getVal().getOp().getOp() : getVal().getVal().toString();
            String leftAsString = getLeft() != null ? getLeft().toStringHelper(padding + 1) : "";
            String rightAsString = getRight() != null ? getRight().toStringHelper(padding + 1) : "";
            String tree = (new StringBuilder()).append(padString).append(valAsString).append("\n").append(leftAsString).append(rightAsString).toString();
            return StringUtils.leftPad(tree, padding, '-');
        }

        @Override
        public String toString() {
            return this.toStringHelper(0);
        }
    }

    public static void main(String...args) {
        System.out.println(calculate("3 + 5 - 5"));
    }

    private static String[] tokenize(String expr) {
        String[] tokens =  expr.trim().split("\\s+");
        System.out.println(Arrays.toString(tokens));
        return tokens;
    }

    private static boolean isInt(String val) {
        return val.matches("\\d+");
    }

    private static ExprNode parseTree(String[] tokenized) {
        Stack<ExprNode> nodeStack = new Stack<>();
        for (String token : tokenized) {
            ExprNode node = !nodeStack.empty() ? nodeStack.pop() : null;
            if (isInt(token)) {
                ExprNode resultNode = new IntNode(
                        ExprVal
                                .builder()
                                .val(Integer.parseInt(token))
                                .build()
                );
                if (node == null) {
                    nodeStack.push(resultNode);
                } else {
                    if (node.getRight() == null) {
                        node.setRight(resultNode);
                        nodeStack.push(node);
                    } else {
                        nodeStack.push(node);
                        nodeStack.push(resultNode);
                    }
                }
            } else {
                ExprNode opNode = new ExprNode();
                opNode.setVal(toExprVal(token));
                if (node.isLeaf()) {
                    opNode.setLeft(node);
                    nodeStack.push(opNode);
                } else {
                    Op op = node.getVal().getOp();
                    OpComparator comparator = new OpComparator();
                    if (comparator.compare(opNode.getVal().getOp(), op) > 0) {
                        opNode.setLeft(node.getRight());
                        nodeStack.push(node);
                        nodeStack.push(opNode);
                    } else {
                        opNode.setLeft(node);
                        nodeStack.push(opNode);
                    }
                }
            }
        }

        ExprNode fullTree = null;
        while(!nodeStack.isEmpty()) {
            ExprNode expression = nodeStack.pop();
            if (fullTree != null) {
                expression.setLeft(fullTree);
            }
            fullTree = expression;
        }
        return fullTree;
    }

    static int calculate(String expr) {
        String[] tokenized = tokenize(expr);
        ExprNode root = parseTree(tokenized);
        System.out.println(root.toString());

        return root.evaluate();
    }
}
