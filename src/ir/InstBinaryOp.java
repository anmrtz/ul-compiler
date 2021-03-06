package ir;

import ast.ExprBinaryOp;
import ast.ExprBinaryOp.OpType;
import codegen.JVisitor;

public class InstBinaryOp extends Instruction {
    public TempVar dest, left, right;
    public OpType opType;


    public InstBinaryOp(TempVar dest, TempVar left, TempVar right, OpType opType) {
        this.dest = dest;
        this.left = left;
        this.right = right;
        this.opType = opType;
    }

    @Override
    public String toString() {
        return dest.toString() + " := " + left.toString() + " " + left.varType.toIRString() + ExprBinaryOp.getOpString(opType) + " " + right.toString();
    }

    @Override
    public void accept(JVisitor j) {
        j.visit(this);
    }
}
