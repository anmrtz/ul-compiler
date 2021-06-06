package ast;

import type.Type.TypeID;

public class ExprLiteral<R> extends Expr {
    private Class<R> literalType;
    public R value;

    public ExprLiteral(Class<R> literalType, R value) {
        this.literalType = literalType;
        this.value = value;
    }

    public TypeID getType() {
        if (literalType.equals(Integer.class))
            return TypeID.TYPE_INT;
        else if (literalType.equals(Float.class))
            return TypeID.TYPE_FLOAT;
        else if (literalType.equals(Character.class))
            return TypeID.TYPE_CHAR;
        else if (literalType.equals(String.class))
            return TypeID.TYPE_STRING;
        else if (literalType.equals(Boolean.class))
            return TypeID.TYPE_BOOL;
        else if (literalType.equals(Void.class))
            return TypeID.TYPE_VOID;
        else
            return null;
    }

    @Override
    public <T> T accept(Visitor<T> v) {
        return v.visit(this);
    }    
}
