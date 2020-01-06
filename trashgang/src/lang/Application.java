package lang;

import lib.Variables;
import parser.Lexer;
import parser.Parser;
import parser.Token;
import parser.ast.interf.Expression;
import parser.ast.interf.Statement;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Application {

    public static void main(String[] args) throws IOException {
        final String input = new String(Files.readAllBytes(Paths.get("source.txt")), StandardCharsets.UTF_8);
        final List<Token> tokens = new Lexer(input).tokenize();

        for (Token token : tokens) {
            System.out.println(token.toString());
        }

        final Statement st = new Parser(tokens).parse();
        System.out.println(st.toString());
        st.execute();
    }
}
