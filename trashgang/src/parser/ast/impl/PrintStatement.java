package parser.ast.impl;

import parser.ast.interf.Expression;
import parser.ast.interf.Statement;

public class PrintStatement implements Statement {

    private final Expression expression;

    public PrintStatement(Expression expression) {
        this.expression = expression;
    }

    @Override
    public void execute() {
        System.out.print(expression.eval().asString());
    }

    @Override
    public String toString() {
        return "ПРИНТУХА " + expression;
    }
}
