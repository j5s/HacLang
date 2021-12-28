package org.hac.ast;

import org.hac.core.Environment;

import java.util.List;

import static org.hac.core.Environment.FALSE;

public class IfStmt extends ASTList {
    public IfStmt(List<ASTree> c) {
        super(c);
    }

    public ASTree condition() {
        return child(0);
    }

    public ASTree thenBlock() {
        return child(1);
    }

    public ASTree elseBlock() {
        return numChildren() > 2 ? child(2) : null;
    }

    @Override
    public String toString() {
        return "(if " + condition() + " " + thenBlock()
                + " else " + elseBlock() + ")";
    }

    @Override
    public Object eval(Environment env) {
        Object c = condition().eval(env);
        if (c instanceof Integer && (Integer) c != FALSE) {
            return thenBlock().eval(env);
        } else {
            ASTree b = elseBlock();
            if (b == null) {
                return 0;
            } else {
                return b.eval(env);
            }
        }
    }
}
