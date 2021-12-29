package org.hac.ast;

import org.hac.env.Environment;

import java.util.List;

public class BlockStmt extends ASTList {
    public BlockStmt(List<ASTree> c) {
        super(c);
    }

    @Override
    public Object eval(Environment env) {
        Object result = 0;
        for (ASTree t : this) {
            if(t instanceof ReturnStmt){
                return t.eval(env);
            }
            if (!(t instanceof NullStmt)) {
                result = t.eval(env);
            }
        }
        return result;
    }
}
