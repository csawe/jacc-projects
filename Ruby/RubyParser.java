// Output created by jacc on Fri Apr 28 22:28:34 EAT 2023


  import java.util.HashMap;
  import java.util.Stack;

  class SemanticWrapper {
    public Object val;
    public HashMap<String, Object> map; 
    public SemanticWrapper(Object val) {
        this.val = val;
    }
  }

  class RubyLexer implements RubyTokens {
          private int lastChar = 32;
    private int token;
    private SemanticWrapper yylval;
    private boolean inLiteral = false;
    private boolean inComment = false;
    private String s;
  
    /** Read a single input character from standard input.
     */
    private int nextChar() {
        try {
          int c = System.in.read();
                  return c;
        } catch (Exception e) {
          return -1;
        }
    }

    /** Read the next token and return the
     *  corresponding integer code.
     */
    int nextToken() {
            int c = lastChar;
        s="";
        
        lastChar = 32;
        
        if (inComment) {
            while (c!='\n') {
                c = nextChar();
            }
            inComment = false;
            lastChar = '\n';
            nextToken();
        }
        
        if (inLiteral) {
            while (c!='"') {
                s += Character.toString((char)c);
                c = nextChar();
            }
            inLiteral = false;
            yylval = new SemanticWrapper(s.substring(1,s.length()));
            return token=STRING_LITERAL;
        }
        
                while (c==32 || c==11 || c==13) {
                        c=nextChar();
                }
        
            
                if (c<0) return (token=ENDINPUT);
                
        String newline = "\n";
        
        if (c == newline.charAt(0)) {
            return token=';';
        }
        
                //Take care of all the special one-character tokens
                switch (c) {
          case '+' : 
                     return token='+';
          case '-' : 
                     return token='-';
          case '*' : 
                     return token='*';
          case '/' : 
                     return token='/';
          case '%' : 
                     return token='%';
          case '^' : 
                     return token='^';
                      case '(' : 
                     return token='(';
          case ')' : 
                     return token=')';
                      case '=' : 
                     return token='=';
          case '>' : 
                     return token='>';
                      case '<' : 
                     return token='<';
          case ',' : 
                     return token=',';
                      case '.' : 
                     return token='.';
                      case '!' : 
                     return token='!';
                      case '&' : 
                     return token='&';
          case '|' : 
                  return token='|';
        case '"' :
                    {inLiteral = true; return nextToken();}
        case '#' :
                    {inComment = true; return nextToken();}
      }
        
                while ((c>=65 && c<=90) || (c>=97 && c<=122) || (c>=48 && c<=57) || (c==34) || (s.matches("[0-9]+") && c=='.')) {
                        if (c<0) break;
                        s+=Character.toString((char)c);
                        c=nextChar();
                }
        
        lastChar = c;
        
                if (s.matches("([+-]?[0-9]*\\.[0-9]+)|([+-]?[0-9]+)")) {
            yylval = new SemanticWrapper(Double.parseDouble(s));
                        return token=NUMBER;
                } else if (s.equals("puts")) {
                        return token=PUTS;
                } else if (s.equals("undef")) {
                        return token=UNDEF;
                } else if (s.equals("alias")) {
                        return token=ALIAS;
                } else if (s.equals("include")) {
                        return token=INCLUDE;
                } else if (s.equals("def")) {
                        return token=DEF;
                } else if (s.equals("if")) {
                        return token=IF;
                } else if (s.equals("then")) {
                        return token=THEN;
                }else if (s.equals("else")) {
                        return token=ELSE;
                } else if (s.equals("elsif")) {
                        return token=ELSIF;
                } else if (s.equals("unless")) {
                        return token=UNLESS;
                } else if (s.equals("until")) {
                        return token=UNTIL;
                } else if (s.equals("while")) {
                        return token=WHILE;
                } else if (s.equals("next")) {
                        return token=NEXT;
                } else if (s.equals("last")) {
                        return token=LAST;
                } else if (s.equals("end")) {
                        return token=END;
                } else if (s.equals("exit")) {
                        return token=EXIT;
                } else if (s.equals("return")) {
                        return token=RETURN;
                } else if (s.matches("[a-zA-Z_][a-zA-Z0-9_]*")) {
      yylval = new SemanticWrapper(s);
                        return token=ID;
    }
                
                return -1;
    }

    /** Return the token code for the current lexeme.
     */
    int getToken() {
      return token;
    }
        
        SemanticWrapper getSemantic() {
                return yylval;
        }
  }

  class Main {
    public static void main(String[] args) {
      RubyLexer  lexer  = new RubyLexer();
      lexer.nextToken();
      RubyParser parser = new RubyParser(lexer);
      parser.parse();
    }

    static void error(String msg) {
      System.out.println("ERROR: " + msg);
      System.exit(1);
    }
  }

class RubyParser implements RubyTokens {
    private int yyss = 100;
    private int yytok;
    private int yysp = 0;
    private int[] yyst;
    protected int yyerrno = (-1);
    private SemanticWrapper[] yysv;
    private SemanticWrapper yyrv;

    public boolean parse() {
        int yyn = 0;
        yysp = 0;
        yyst = new int[yyss];
        yysv = new SemanticWrapper[yyss];
        yytok = (lexer.getToken()
                 );
    loop:
        for (;;) {
            switch (yyn) {
                case 0:
                    yyst[yysp] = 0;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 134:
                    yyn = yys0();
                    continue;

                case 1:
                    yyst[yysp] = 1;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 135:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = 268;
                            continue;
                        case ';':
                            yyn = 26;
                            continue;
                    }
                    yyn = 271;
                    continue;

                case 2:
                    yyst[yysp] = 2;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 136:
                    switch (yytok) {
                        case ENDINPUT:
                        case ';':
                            yyn = yyr4();
                            continue;
                    }
                    yyn = 271;
                    continue;

                case 3:
                    yyst[yysp] = 3;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 137:
                    switch (yytok) {
                        case ENDINPUT:
                        case ';':
                            yyn = yyr22();
                            continue;
                    }
                    yyn = 271;
                    continue;

                case 4:
                    yyst[yysp] = 4;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 138:
                    switch (yytok) {
                        case ENDINPUT:
                        case ';':
                            yyn = yyr2();
                            continue;
                    }
                    yyn = 271;
                    continue;

                case 5:
                    yyst[yysp] = 5;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 139:
                    switch (yytok) {
                        case ENDINPUT:
                        case ';':
                            yyn = yyr21();
                            continue;
                    }
                    yyn = 271;
                    continue;

                case 6:
                    yyst[yysp] = 6;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 140:
                    switch (yytok) {
                        case ENDINPUT:
                        case ';':
                            yyn = yyr5();
                            continue;
                    }
                    yyn = 271;
                    continue;

                case 7:
                    yyst[yysp] = 7;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 141:
                    switch (yytok) {
                        case ENDINPUT:
                        case ';':
                            yyn = yyr23();
                            continue;
                    }
                    yyn = 271;
                    continue;

                case 8:
                    yyst[yysp] = 8;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 142:
                    yyn = yys8();
                    continue;

                case 9:
                    yyst[yysp] = 9;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 143:
                    yyn = yys9();
                    continue;

                case 10:
                    yyst[yysp] = 10;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 144:
                    switch (yytok) {
                        case ID:
                            yyn = 33;
                            continue;
                    }
                    yyn = 271;
                    continue;

                case 11:
                    yyst[yysp] = 11;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 145:
                    switch (yytok) {
                        case ID:
                            yyn = 34;
                            continue;
                    }
                    yyn = 271;
                    continue;

                case 12:
                    yyst[yysp] = 12;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 146:
                    switch (yytok) {
                        case ENDINPUT:
                        case ';':
                            yyn = yyr20();
                            continue;
                    }
                    yyn = 271;
                    continue;

                case 13:
                    yyst[yysp] = 13;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 147:
                    yyn = yys13();
                    continue;

                case 14:
                    yyst[yysp] = 14;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 148:
                    yyn = yys14();
                    continue;

                case 15:
                    yyst[yysp] = 15;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 149:
                    switch (yytok) {
                        case ID:
                            yyn = 44;
                            continue;
                    }
                    yyn = 271;
                    continue;

                case 16:
                    yyst[yysp] = 16;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 150:
                    yyn = yys16();
                    continue;

                case 17:
                    yyst[yysp] = 17;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 151:
                    switch (yytok) {
                        case NUMBER:
                            yyn = 16;
                            continue;
                        case STRING_LITERAL:
                            yyn = 19;
                            continue;
                        case '(':
                            yyn = 24;
                            continue;
                        case ID:
                            yyn = 41;
                            continue;
                    }
                    yyn = 271;
                    continue;

                case 18:
                    yyst[yysp] = 18;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 152:
                    yyn = yys18();
                    continue;

                case 19:
                    yyst[yysp] = 19;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 153:
                    yyn = yys19();
                    continue;

                case 20:
                    yyst[yysp] = 20;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 154:
                    switch (yytok) {
                        case ID:
                            yyn = 47;
                            continue;
                    }
                    yyn = 271;
                    continue;

                case 21:
                    yyst[yysp] = 21;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 155:
                    yyn = yys21();
                    continue;

                case 22:
                    yyst[yysp] = 22;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 156:
                    yyn = yys22();
                    continue;

                case 23:
                    yyst[yysp] = 23;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 157:
                    yyn = yys23();
                    continue;

                case 24:
                    yyst[yysp] = 24;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 158:
                    switch (yytok) {
                        case NUMBER:
                            yyn = 16;
                            continue;
                        case STRING_LITERAL:
                            yyn = 19;
                            continue;
                        case '(':
                            yyn = 24;
                            continue;
                        case ID:
                            yyn = 52;
                            continue;
                    }
                    yyn = 271;
                    continue;

                case 25:
                    yyst[yysp] = 25;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 159:
                    yyn = yys25();
                    continue;

                case 26:
                    yyst[yysp] = 26;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 160:
                    yyn = yys26();
                    continue;

                case 27:
                    yyst[yysp] = 27;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 161:
                    switch (yytok) {
                        case NUMBER:
                            yyn = 16;
                            continue;
                        case STRING_LITERAL:
                            yyn = 19;
                            continue;
                        case '(':
                            yyn = 24;
                            continue;
                        case ID:
                            yyn = 52;
                            continue;
                    }
                    yyn = 271;
                    continue;

                case 28:
                    yyst[yysp] = 28;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 162:
                    switch (yytok) {
                        case NUMBER:
                            yyn = 16;
                            continue;
                        case STRING_LITERAL:
                            yyn = 19;
                            continue;
                        case '(':
                            yyn = 24;
                            continue;
                        case ID:
                            yyn = 52;
                            continue;
                    }
                    yyn = 271;
                    continue;

                case 29:
                    yyst[yysp] = 29;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 163:
                    switch (yytok) {
                        case NUMBER:
                            yyn = 16;
                            continue;
                        case STRING_LITERAL:
                            yyn = 19;
                            continue;
                        case '(':
                            yyn = 24;
                            continue;
                        case ID:
                            yyn = 52;
                            continue;
                    }
                    yyn = 271;
                    continue;

                case 30:
                    yyst[yysp] = 30;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 164:
                    switch (yytok) {
                        case NUMBER:
                            yyn = 16;
                            continue;
                        case STRING_LITERAL:
                            yyn = 19;
                            continue;
                        case '(':
                            yyn = 24;
                            continue;
                        case ID:
                            yyn = 52;
                            continue;
                    }
                    yyn = 271;
                    continue;

                case 31:
                    yyst[yysp] = 31;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 165:
                    switch (yytok) {
                        case NUMBER:
                            yyn = 16;
                            continue;
                        case STRING_LITERAL:
                            yyn = 19;
                            continue;
                        case '(':
                            yyn = 24;
                            continue;
                        case ID:
                            yyn = 52;
                            continue;
                    }
                    yyn = 271;
                    continue;

                case 32:
                    yyst[yysp] = 32;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 166:
                    switch (yytok) {
                        case NUMBER:
                            yyn = 16;
                            continue;
                        case STRING_LITERAL:
                            yyn = 19;
                            continue;
                        case '(':
                            yyn = 24;
                            continue;
                        case ID:
                            yyn = 52;
                            continue;
                    }
                    yyn = 271;
                    continue;

                case 33:
                    yyst[yysp] = 33;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 167:
                    switch (yytok) {
                        case ID:
                            yyn = 60;
                            continue;
                    }
                    yyn = 271;
                    continue;

                case 34:
                    yyst[yysp] = 34;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 168:
                    switch (yytok) {
                        case '(':
                            yyn = 62;
                            continue;
                        case ';':
                            yyn = yyr43();
                            continue;
                    }
                    yyn = 271;
                    continue;

                case 35:
                    yyst[yysp] = 35;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 169:
                    switch (yytok) {
                        case NUMBER:
                            yyn = 16;
                            continue;
                        case STRING_LITERAL:
                            yyn = 19;
                            continue;
                        case '(':
                            yyn = 24;
                            continue;
                        case ID:
                            yyn = 41;
                            continue;
                        case ')':
                            yyn = yyr47();
                            continue;
                    }
                    yyn = 271;
                    continue;

                case 36:
                    yyst[yysp] = 36;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 170:
                    switch (yytok) {
                        case ID:
                            yyn = 66;
                            continue;
                    }
                    yyn = 271;
                    continue;

                case 37:
                    yyst[yysp] = 37;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 171:
                    switch (yytok) {
                        case NUMBER:
                            yyn = 16;
                            continue;
                        case STRING_LITERAL:
                            yyn = 19;
                            continue;
                        case '(':
                            yyn = 24;
                            continue;
                        case ID:
                            yyn = 41;
                            continue;
                    }
                    yyn = 271;
                    continue;

                case 38:
                    yyst[yysp] = 38;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 172:
                    switch (yytok) {
                        case THEN:
                            yyn = 69;
                            continue;
                        case ';':
                            yyn = yyr9();
                            continue;
                    }
                    yyn = 271;
                    continue;

                case 39:
                    yyst[yysp] = 39;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 173:
                    switch (yytok) {
                        case '!':
                            yyn = 71;
                            continue;
                        case '<':
                            yyn = 72;
                            continue;
                        case '=':
                            yyn = 73;
                            continue;
                        case '>':
                            yyn = 74;
                            continue;
                    }
                    yyn = 271;
                    continue;

                case 40:
                    yyst[yysp] = 40;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 174:
                    yyn = yys40();
                    continue;

                case 41:
                    yyst[yysp] = 41;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 175:
                    yyn = yys41();
                    continue;

                case 42:
                    yyst[yysp] = 42;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 176:
                    yyn = yys42();
                    continue;

                case 43:
                    yyst[yysp] = 43;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 177:
                    yyn = yys43();
                    continue;

                case 44:
                    yyst[yysp] = 44;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 178:
                    switch (yytok) {
                        case ENDINPUT:
                        case ';':
                            yyn = yyr16();
                            continue;
                    }
                    yyn = 271;
                    continue;

                case 45:
                    yyst[yysp] = 45;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 179:
                    switch (yytok) {
                        case ENDINPUT:
                        case ';':
                            yyn = yyr17();
                            continue;
                    }
                    yyn = 271;
                    continue;

                case 46:
                    yyst[yysp] = 46;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 180:
                    switch (yytok) {
                        case ENDINPUT:
                        case ';':
                            yyn = yyr18();
                            continue;
                    }
                    yyn = 271;
                    continue;

                case 47:
                    yyst[yysp] = 47;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 181:
                    switch (yytok) {
                        case ENDINPUT:
                        case ';':
                            yyn = yyr50();
                            continue;
                    }
                    yyn = 271;
                    continue;

                case 48:
                    yyst[yysp] = 48;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 182:
                    switch (yytok) {
                        case ';':
                            yyn = 26;
                            continue;
                    }
                    yyn = 271;
                    continue;

                case 49:
                    yyst[yysp] = 49;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 183:
                    switch (yytok) {
                        case ';':
                            yyn = 26;
                            continue;
                    }
                    yyn = 271;
                    continue;

                case 50:
                    yyst[yysp] = 50;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 184:
                    switch (yytok) {
                        case ';':
                            yyn = 26;
                            continue;
                    }
                    yyn = 271;
                    continue;

                case 51:
                    yyst[yysp] = 51;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 185:
                    yyn = yys51();
                    continue;

                case 52:
                    yyst[yysp] = 52;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 186:
                    yyn = yys52();
                    continue;

                case 53:
                    yyst[yysp] = 53;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 187:
                    switch (yytok) {
                        case ENDINPUT:
                        case ';':
                            yyn = yyr1();
                            continue;
                    }
                    yyn = 271;
                    continue;

                case 54:
                    yyst[yysp] = 54;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 188:
                    yyn = yys54();
                    continue;

                case 55:
                    yyst[yysp] = 55;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 189:
                    yyn = yys55();
                    continue;

                case 56:
                    yyst[yysp] = 56;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 190:
                    yyn = yys56();
                    continue;

                case 57:
                    yyst[yysp] = 57;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 191:
                    yyn = yys57();
                    continue;

                case 58:
                    yyst[yysp] = 58;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 192:
                    yyn = yys58();
                    continue;

                case 59:
                    yyst[yysp] = 59;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 193:
                    yyn = yys59();
                    continue;

                case 60:
                    yyst[yysp] = 60;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 194:
                    switch (yytok) {
                        case ENDINPUT:
                        case ';':
                            yyn = yyr51();
                            continue;
                    }
                    yyn = 271;
                    continue;

                case 61:
                    yyst[yysp] = 61;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 195:
                    switch (yytok) {
                        case ';':
                            yyn = 26;
                            continue;
                    }
                    yyn = 271;
                    continue;

                case 62:
                    yyst[yysp] = 62;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 196:
                    switch (yytok) {
                        case ID:
                            yyn = 85;
                            continue;
                    }
                    yyn = 271;
                    continue;

                case 63:
                    yyst[yysp] = 63;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 197:
                    switch (yytok) {
                        case ')':
                            yyn = yyr46();
                            continue;
                    }
                    yyn = 271;
                    continue;

                case 64:
                    yyst[yysp] = 64;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 198:
                    switch (yytok) {
                        case ')':
                            yyn = 86;
                            continue;
                    }
                    yyn = 271;
                    continue;

                case 65:
                    yyst[yysp] = 65;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 199:
                    switch (yytok) {
                        case ',':
                            yyn = 87;
                            continue;
                        case ')':
                            yyn = yyr45();
                            continue;
                    }
                    yyn = 271;
                    continue;

                case 66:
                    yyst[yysp] = 66;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 200:
                    switch (yytok) {
                        case '(':
                            yyn = 88;
                            continue;
                    }
                    yyn = 271;
                    continue;

                case 67:
                    yyst[yysp] = 67;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 201:
                    switch (yytok) {
                        case ENDINPUT:
                        case ';':
                            yyn = yyr48();
                            continue;
                    }
                    yyn = 271;
                    continue;

                case 68:
                    yyst[yysp] = 68;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 202:
                    switch (yytok) {
                        case ';':
                            yyn = 26;
                            continue;
                    }
                    yyn = 271;
                    continue;

                case 69:
                    yyst[yysp] = 69;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 203:
                    switch (yytok) {
                        case ';':
                            yyn = yyr8();
                            continue;
                    }
                    yyn = 271;
                    continue;

                case 70:
                    yyst[yysp] = 70;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 204:
                    switch (yytok) {
                        case NUMBER:
                            yyn = 16;
                            continue;
                        case STRING_LITERAL:
                            yyn = 19;
                            continue;
                        case '(':
                            yyn = 24;
                            continue;
                        case ID:
                            yyn = 41;
                            continue;
                    }
                    yyn = 271;
                    continue;

                case 71:
                    yyst[yysp] = 71;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 205:
                    switch (yytok) {
                        case '=':
                            yyn = 91;
                            continue;
                    }
                    yyn = 271;
                    continue;

                case 72:
                    yyst[yysp] = 72;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 206:
                    switch (yytok) {
                        case '=':
                            yyn = 92;
                            continue;
                        case '(':
                        case NUMBER:
                        case STRING_LITERAL:
                        case ID:
                            yyn = yyr35();
                            continue;
                    }
                    yyn = 271;
                    continue;

                case 73:
                    yyst[yysp] = 73;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 207:
                    switch (yytok) {
                        case '=':
                            yyn = 93;
                            continue;
                    }
                    yyn = 271;
                    continue;

                case 74:
                    yyst[yysp] = 74;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 208:
                    switch (yytok) {
                        case '=':
                            yyn = 94;
                            continue;
                        case '(':
                        case NUMBER:
                        case STRING_LITERAL:
                        case ID:
                            yyn = yyr37();
                            continue;
                    }
                    yyn = 271;
                    continue;

                case 75:
                    yyst[yysp] = 75;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 209:
                    switch (yytok) {
                        case '&':
                            yyn = 95;
                            continue;
                    }
                    yyn = 271;
                    continue;

                case 76:
                    yyst[yysp] = 76;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 210:
                    switch (yytok) {
                        case '|':
                            yyn = 96;
                            continue;
                    }
                    yyn = 271;
                    continue;

                case 77:
                    yyst[yysp] = 77;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 211:
                    switch (yytok) {
                        case ']':
                        case ';':
                        case THEN:
                            yyn = yyr30();
                            continue;
                    }
                    yyn = 271;
                    continue;

                case 78:
                    yyst[yysp] = 78;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 212:
                    switch (yytok) {
                        case ']':
                            yyn = 97;
                            continue;
                    }
                    yyn = 271;
                    continue;

                case 79:
                    yyst[yysp] = 79;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 213:
                    yyn = yys79();
                    continue;

                case 80:
                    yyst[yysp] = 80;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 214:
                    yyn = yys80();
                    continue;

                case 81:
                    yyst[yysp] = 81;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 215:
                    yyn = yys81();
                    continue;

                case 82:
                    yyst[yysp] = 82;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 216:
                    yyn = yys82();
                    continue;

                case 83:
                    yyst[yysp] = 83;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 217:
                    yyn = yys83();
                    continue;

                case 84:
                    yyst[yysp] = 84;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 218:
                    switch (yytok) {
                        case ')':
                            yyn = 103;
                            continue;
                    }
                    yyn = 271;
                    continue;

                case 85:
                    yyst[yysp] = 85;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 219:
                    switch (yytok) {
                        case ',':
                        case ')':
                            yyn = yyr41();
                            continue;
                    }
                    yyn = 271;
                    continue;

                case 86:
                    yyst[yysp] = 86;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 220:
                    yyn = yys86();
                    continue;

                case 87:
                    yyst[yysp] = 87;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 221:
                    switch (yytok) {
                        case NUMBER:
                            yyn = 16;
                            continue;
                        case STRING_LITERAL:
                            yyn = 19;
                            continue;
                        case '(':
                            yyn = 24;
                            continue;
                        case ID:
                            yyn = 41;
                            continue;
                    }
                    yyn = 271;
                    continue;

                case 88:
                    yyst[yysp] = 88;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 222:
                    switch (yytok) {
                        case NUMBER:
                            yyn = 16;
                            continue;
                        case STRING_LITERAL:
                            yyn = 19;
                            continue;
                        case '(':
                            yyn = 24;
                            continue;
                        case ID:
                            yyn = 41;
                            continue;
                        case ')':
                            yyn = yyr47();
                            continue;
                    }
                    yyn = 271;
                    continue;

                case 89:
                    yyst[yysp] = 89;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 223:
                    yyn = yys89();
                    continue;

                case 90:
                    yyst[yysp] = 90;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 224:
                    switch (yytok) {
                        case ']':
                        case ';':
                        case THEN:
                            yyn = yyr27();
                            continue;
                    }
                    yyn = 271;
                    continue;

                case 91:
                    yyst[yysp] = 91;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 225:
                    switch (yytok) {
                        case '(':
                        case NUMBER:
                        case STRING_LITERAL:
                        case ID:
                            yyn = yyr34();
                            continue;
                    }
                    yyn = 271;
                    continue;

                case 92:
                    yyst[yysp] = 92;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 226:
                    switch (yytok) {
                        case '(':
                        case NUMBER:
                        case STRING_LITERAL:
                        case ID:
                            yyn = yyr36();
                            continue;
                    }
                    yyn = 271;
                    continue;

                case 93:
                    yyst[yysp] = 93;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 227:
                    switch (yytok) {
                        case '(':
                        case NUMBER:
                        case STRING_LITERAL:
                        case ID:
                            yyn = yyr33();
                            continue;
                    }
                    yyn = 271;
                    continue;

                case 94:
                    yyst[yysp] = 94;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 228:
                    switch (yytok) {
                        case '(':
                        case NUMBER:
                        case STRING_LITERAL:
                        case ID:
                            yyn = yyr38();
                            continue;
                    }
                    yyn = 271;
                    continue;

                case 95:
                    yyst[yysp] = 95;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 229:
                    yyn = yys95();
                    continue;

                case 96:
                    yyst[yysp] = 96;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 230:
                    yyn = yys96();
                    continue;

                case 97:
                    yyst[yysp] = 97;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 231:
                    switch (yytok) {
                        case ']':
                        case ';':
                        case THEN:
                            yyn = yyr31();
                            continue;
                    }
                    yyn = 271;
                    continue;

                case 98:
                    yyst[yysp] = 98;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 232:
                    switch (yytok) {
                        case ';':
                            yyn = yyr11();
                            continue;
                    }
                    yyn = 271;
                    continue;

                case 99:
                    yyst[yysp] = 99;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 233:
                    switch (yytok) {
                        case ';':
                            yyn = 26;
                            continue;
                    }
                    yyn = 271;
                    continue;

                case 100:
                    yyst[yysp] = 100;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 234:
                    switch (yytok) {
                        case ';':
                            yyn = 26;
                            continue;
                    }
                    yyn = 271;
                    continue;

                case 101:
                    yyst[yysp] = 101;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 235:
                    switch (yytok) {
                        case ';':
                            yyn = 26;
                            continue;
                    }
                    yyn = 271;
                    continue;

                case 102:
                    yyst[yysp] = 102;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 236:
                    switch (yytok) {
                        case ';':
                            yyn = 26;
                            continue;
                    }
                    yyn = 271;
                    continue;

                case 103:
                    yyst[yysp] = 103;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 237:
                    switch (yytok) {
                        case ';':
                            yyn = yyr42();
                            continue;
                    }
                    yyn = 271;
                    continue;

                case 104:
                    yyst[yysp] = 104;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 238:
                    switch (yytok) {
                        case ',':
                            yyn = 114;
                            continue;
                        case ')':
                            yyn = yyr39();
                            continue;
                    }
                    yyn = 271;
                    continue;

                case 105:
                    yyst[yysp] = 105;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 239:
                    switch (yytok) {
                        case ')':
                            yyn = yyr44();
                            continue;
                    }
                    yyn = 271;
                    continue;

                case 106:
                    yyst[yysp] = 106;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 240:
                    switch (yytok) {
                        case ')':
                            yyn = 115;
                            continue;
                    }
                    yyn = 271;
                    continue;

                case 107:
                    yyst[yysp] = 107;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 241:
                    switch (yytok) {
                        case ';':
                            yyn = 26;
                            continue;
                    }
                    yyn = 271;
                    continue;

                case 108:
                    yyst[yysp] = 108;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 242:
                    switch (yytok) {
                        case ']':
                        case ';':
                        case THEN:
                            yyn = yyr28();
                            continue;
                    }
                    yyn = 271;
                    continue;

                case 109:
                    yyst[yysp] = 109;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 243:
                    switch (yytok) {
                        case ']':
                        case ';':
                        case THEN:
                            yyn = yyr29();
                            continue;
                    }
                    yyn = 271;
                    continue;

                case 110:
                    yyst[yysp] = 110;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 244:
                    yyn = yys110();
                    continue;

                case 111:
                    yyst[yysp] = 111;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 245:
                    yyn = yys111();
                    continue;

                case 112:
                    yyst[yysp] = 112;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 246:
                    yyn = yys112();
                    continue;

                case 113:
                    yyst[yysp] = 113;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 247:
                    switch (yytok) {
                        case END:
                            yyn = 121;
                            continue;
                    }
                    yyn = 271;
                    continue;

                case 114:
                    yyst[yysp] = 114;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 248:
                    switch (yytok) {
                        case ID:
                            yyn = 85;
                            continue;
                    }
                    yyn = 271;
                    continue;

                case 115:
                    yyst[yysp] = 115;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 249:
                    yyn = yys115();
                    continue;

                case 116:
                    yyst[yysp] = 116;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 250:
                    yyn = yys116();
                    continue;

                case 117:
                    yyst[yysp] = 117;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 251:
                    switch (yytok) {
                        case ';':
                            yyn = yyr10();
                            continue;
                    }
                    yyn = 271;
                    continue;

                case 118:
                    yyst[yysp] = 118;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 252:
                    switch (yytok) {
                        case ENDINPUT:
                        case ';':
                            yyn = yyr14();
                            continue;
                    }
                    yyn = 271;
                    continue;

                case 119:
                    yyst[yysp] = 119;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 253:
                    switch (yytok) {
                        case ENDINPUT:
                        case ';':
                            yyn = yyr15();
                            continue;
                    }
                    yyn = 271;
                    continue;

                case 120:
                    yyst[yysp] = 120;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 254:
                    switch (yytok) {
                        case ENDINPUT:
                        case ';':
                            yyn = yyr13();
                            continue;
                    }
                    yyn = 271;
                    continue;

                case 121:
                    yyst[yysp] = 121;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 255:
                    switch (yytok) {
                        case ENDINPUT:
                        case ';':
                            yyn = yyr7();
                            continue;
                    }
                    yyn = 271;
                    continue;

                case 122:
                    yyst[yysp] = 122;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 256:
                    switch (yytok) {
                        case ',':
                        case ')':
                            yyn = yyr40();
                            continue;
                    }
                    yyn = 271;
                    continue;

                case 123:
                    yyst[yysp] = 123;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 257:
                    switch (yytok) {
                        case END:
                            yyn = 126;
                            continue;
                    }
                    yyn = 271;
                    continue;

                case 124:
                    yyst[yysp] = 124;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 258:
                    yyn = yys124();
                    continue;

                case 125:
                    yyst[yysp] = 125;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 259:
                    yyn = yys125();
                    continue;

                case 126:
                    yyst[yysp] = 126;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 260:
                    switch (yytok) {
                        case ENDINPUT:
                        case ';':
                            yyn = yyr12();
                            continue;
                    }
                    yyn = 271;
                    continue;

                case 127:
                    yyst[yysp] = 127;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 261:
                    switch (yytok) {
                        case ';':
                            yyn = 26;
                            continue;
                    }
                    yyn = 271;
                    continue;

                case 128:
                    yyst[yysp] = 128;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 262:
                    switch (yytok) {
                        case ';':
                            yyn = 26;
                            continue;
                    }
                    yyn = 271;
                    continue;

                case 129:
                    yyst[yysp] = 129;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 263:
                    yyn = yys129();
                    continue;

                case 130:
                    yyst[yysp] = 130;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 264:
                    yyn = yys130();
                    continue;

                case 131:
                    yyst[yysp] = 131;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 265:
                    switch (yytok) {
                        case ';':
                            yyn = 26;
                            continue;
                    }
                    yyn = 271;
                    continue;

                case 132:
                    yyst[yysp] = 132;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 266:
                    yyn = yys132();
                    continue;

                case 133:
                    yyst[yysp] = 133;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 267:
                    switch (yytok) {
                        case END:
                            yyn = yyr25();
                            continue;
                    }
                    yyn = 271;
                    continue;

                case 268:
                    return true;
                case 269:
                    yyerror("stack overflow");
                case 270:
                    return false;
                case 271:
                    yyerror("syntax error");
                    return false;
            }
        }
    }

    protected void yyexpand() {
        int[] newyyst = new int[2*yyst.length];
        SemanticWrapper[] newyysv = new SemanticWrapper[2*yyst.length];
        for (int i=0; i<yyst.length; i++) {
            newyyst[i] = yyst[i];
            newyysv[i] = yysv[i];
        }
        yyst = newyyst;
        yysv = newyysv;
    }

    private int yys0() {
        switch (yytok) {
            case ALIAS:
                return 10;
            case DEF:
                return 11;
            case EXIT:
                return 12;
            case ID:
                return 13;
            case IF:
                return 14;
            case INCLUDE:
                return 15;
            case NUMBER:
                return 16;
            case PUTS:
                return 17;
            case RETURN:
                return 18;
            case STRING_LITERAL:
                return 19;
            case UNDEF:
                return 20;
            case UNLESS:
                return 21;
            case UNTIL:
                return 22;
            case WHILE:
                return 23;
            case '(':
                return 24;
            case ENDINPUT:
            case ';':
                return yyr6();
        }
        return 271;
    }

    private int yys8() {
        switch (yytok) {
            case ',':
            case '+':
            case '*':
            case '-':
            case ')':
            case '%':
            case '!':
            case ENDINPUT:
            case '^':
            case ']':
            case '>':
            case '=':
            case '<':
            case ';':
            case THEN:
            case '/':
                return yyr63();
        }
        return 271;
    }

    private int yys9() {
        switch (yytok) {
            case '%':
                return 27;
            case '*':
                return 28;
            case '+':
                return 29;
            case '-':
                return 30;
            case '/':
                return 31;
            case '^':
                return 32;
            case ',':
            case ')':
            case '!':
            case ENDINPUT:
            case ']':
            case '>':
            case '=':
            case '<':
            case ';':
            case THEN:
                return yyr55();
        }
        return 271;
    }

    private int yys13() {
        switch (yytok) {
            case '(':
                return 35;
            case '.':
                return 36;
            case '=':
                return 37;
            case ENDINPUT:
            case ';':
                return yyr49();
            case '-':
            case '+':
            case '*':
            case '%':
            case '^':
            case '/':
                return yyr64();
        }
        return 271;
    }

    private int yys14() {
        switch (yytok) {
            case NUMBER:
                return 16;
            case STRING_LITERAL:
                return 19;
            case '(':
                return 24;
            case ID:
                return 41;
            case '!':
                return 42;
            case '[':
                return 43;
        }
        return 271;
    }

    private int yys16() {
        switch (yytok) {
            case ',':
            case '+':
            case '*':
            case ')':
            case '&':
            case '-':
            case '%':
            case '!':
            case ENDINPUT:
            case '|':
            case '^':
            case ']':
            case '>':
            case '=':
            case '<':
            case ';':
            case THEN:
            case '/':
                return yyr65();
        }
        return 271;
    }

    private int yys18() {
        switch (yytok) {
            case NUMBER:
                return 16;
            case STRING_LITERAL:
                return 19;
            case '(':
                return 24;
            case ID:
                return 41;
            case ENDINPUT:
            case ';':
                return yyr19();
        }
        return 271;
    }

    private int yys19() {
        switch (yytok) {
            case ',':
            case '+':
            case '*':
            case ')':
            case '&':
            case '-':
            case '%':
            case '!':
            case ENDINPUT:
            case '|':
            case '^':
            case ']':
            case '>':
            case '=':
            case '<':
            case ';':
            case THEN:
            case '/':
                return yyr66();
        }
        return 271;
    }

    private int yys21() {
        switch (yytok) {
            case NUMBER:
                return 16;
            case STRING_LITERAL:
                return 19;
            case '(':
                return 24;
            case ID:
                return 41;
            case '!':
                return 42;
            case '[':
                return 43;
        }
        return 271;
    }

    private int yys22() {
        switch (yytok) {
            case NUMBER:
                return 16;
            case STRING_LITERAL:
                return 19;
            case '(':
                return 24;
            case ID:
                return 41;
            case '!':
                return 42;
            case '[':
                return 43;
        }
        return 271;
    }

    private int yys23() {
        switch (yytok) {
            case NUMBER:
                return 16;
            case STRING_LITERAL:
                return 19;
            case '(':
                return 24;
            case ID:
                return 41;
            case '!':
                return 42;
            case '[':
                return 43;
        }
        return 271;
    }

    private int yys25() {
        switch (yytok) {
            case ALIAS:
                return 10;
            case DEF:
                return 11;
            case EXIT:
                return 12;
            case ID:
                return 13;
            case IF:
                return 14;
            case INCLUDE:
                return 15;
            case NUMBER:
                return 16;
            case PUTS:
                return 17;
            case RETURN:
                return 18;
            case STRING_LITERAL:
                return 19;
            case UNDEF:
                return 20;
            case UNLESS:
                return 21;
            case UNTIL:
                return 22;
            case WHILE:
                return 23;
            case '(':
                return 24;
            case ENDINPUT:
            case ';':
                return yyr6();
        }
        return 271;
    }

    private int yys26() {
        switch (yytok) {
            case RETURN:
            case PUTS:
            case EXIT:
            case '(':
            case NUMBER:
            case ELSE:
            case WHILE:
            case UNTIL:
            case INCLUDE:
            case END:
            case UNLESS:
            case UNDEF:
            case IF:
            case ';':
            case STRING_LITERAL:
            case ID:
            case ELSIF:
            case DEF:
            case ENDINPUT:
            case ALIAS:
                return yyr3();
        }
        return 271;
    }

    private int yys40() {
        switch (yytok) {
            case '&':
                return 75;
            case '|':
                return 76;
            case ']':
            case THEN:
            case ';':
                return yyr32();
            case '-':
            case '+':
            case '*':
            case '%':
            case '!':
            case '^':
            case '>':
            case '=':
            case '<':
            case '/':
                return yyr63();
        }
        return 271;
    }

    private int yys41() {
        switch (yytok) {
            case '(':
                return 35;
            case '.':
                return 36;
            case ',':
            case '+':
            case '*':
            case ')':
            case '&':
            case '-':
            case '%':
            case '!':
            case ENDINPUT:
            case '|':
            case '^':
            case ']':
            case '>':
            case '=':
            case '<':
            case ';':
            case THEN:
            case '/':
                return yyr64();
        }
        return 271;
    }

    private int yys42() {
        switch (yytok) {
            case NUMBER:
                return 16;
            case STRING_LITERAL:
                return 19;
            case '(':
                return 24;
            case ID:
                return 41;
            case '!':
                return 42;
            case '[':
                return 43;
        }
        return 271;
    }

    private int yys43() {
        switch (yytok) {
            case NUMBER:
                return 16;
            case STRING_LITERAL:
                return 19;
            case '(':
                return 24;
            case ID:
                return 41;
            case '!':
                return 42;
            case '[':
                return 43;
        }
        return 271;
    }

    private int yys51() {
        switch (yytok) {
            case '%':
                return 27;
            case '*':
                return 28;
            case '+':
                return 29;
            case '-':
                return 30;
            case '/':
                return 31;
            case '^':
                return 32;
            case ')':
                return 82;
        }
        return 271;
    }

    private int yys52() {
        switch (yytok) {
            case ',':
            case '+':
            case '*':
            case '-':
            case ')':
            case '%':
            case '!':
            case ENDINPUT:
            case '^':
            case ']':
            case '>':
            case '=':
            case '<':
            case ';':
            case THEN:
            case '/':
                return yyr64();
        }
        return 271;
    }

    private int yys54() {
        switch (yytok) {
            case '^':
                return 32;
            case '-':
            case ',':
            case '+':
            case '*':
            case ')':
            case '%':
            case '!':
            case ENDINPUT:
            case ']':
            case '>':
            case '=':
            case '<':
            case ';':
            case THEN:
            case '/':
                return yyr61();
        }
        return 271;
    }

    private int yys55() {
        switch (yytok) {
            case '^':
                return 32;
            case '-':
            case ',':
            case '+':
            case '*':
            case ')':
            case '%':
            case '!':
            case ENDINPUT:
            case ']':
            case '>':
            case '=':
            case '<':
            case ';':
            case THEN:
            case '/':
                return yyr58();
        }
        return 271;
    }

    private int yys56() {
        switch (yytok) {
            case '%':
                return 27;
            case '*':
                return 28;
            case '/':
                return 31;
            case '^':
                return 32;
            case '-':
            case ',':
            case '+':
            case ')':
            case '!':
            case ENDINPUT:
            case ']':
            case '>':
            case '=':
            case '<':
            case ';':
            case THEN:
                return yyr56();
        }
        return 271;
    }

    private int yys57() {
        switch (yytok) {
            case '%':
                return 27;
            case '*':
                return 28;
            case '/':
                return 31;
            case '^':
                return 32;
            case '-':
            case ',':
            case '+':
            case ')':
            case '!':
            case ENDINPUT:
            case ']':
            case '>':
            case '=':
            case '<':
            case ';':
            case THEN:
                return yyr57();
        }
        return 271;
    }

    private int yys58() {
        switch (yytok) {
            case '^':
                return 32;
            case '-':
            case ',':
            case '+':
            case '*':
            case ')':
            case '%':
            case '!':
            case ENDINPUT:
            case ']':
            case '>':
            case '=':
            case '<':
            case ';':
            case THEN:
            case '/':
                return yyr59();
        }
        return 271;
    }

    private int yys59() {
        switch (yytok) {
            case '^':
                return 32;
            case '-':
            case ',':
            case '+':
            case '*':
            case ')':
            case '%':
            case '!':
            case ENDINPUT:
            case ']':
            case '>':
            case '=':
            case '<':
            case ';':
            case THEN:
            case '/':
                return yyr60();
        }
        return 271;
    }

    private int yys79() {
        switch (yytok) {
            case ALIAS:
                return 10;
            case EXIT:
                return 12;
            case ID:
                return 13;
            case IF:
                return 14;
            case INCLUDE:
                return 15;
            case NUMBER:
                return 16;
            case PUTS:
                return 17;
            case RETURN:
                return 18;
            case STRING_LITERAL:
                return 19;
            case UNDEF:
                return 20;
            case UNLESS:
                return 21;
            case UNTIL:
                return 22;
            case WHILE:
                return 23;
            case '(':
                return 24;
        }
        return 271;
    }

    private int yys80() {
        switch (yytok) {
            case ALIAS:
                return 10;
            case EXIT:
                return 12;
            case ID:
                return 13;
            case IF:
                return 14;
            case INCLUDE:
                return 15;
            case NUMBER:
                return 16;
            case PUTS:
                return 17;
            case RETURN:
                return 18;
            case STRING_LITERAL:
                return 19;
            case UNDEF:
                return 20;
            case UNLESS:
                return 21;
            case UNTIL:
                return 22;
            case WHILE:
                return 23;
            case '(':
                return 24;
        }
        return 271;
    }

    private int yys81() {
        switch (yytok) {
            case ALIAS:
                return 10;
            case EXIT:
                return 12;
            case ID:
                return 13;
            case IF:
                return 14;
            case INCLUDE:
                return 15;
            case NUMBER:
                return 16;
            case PUTS:
                return 17;
            case RETURN:
                return 18;
            case STRING_LITERAL:
                return 19;
            case UNDEF:
                return 20;
            case UNLESS:
                return 21;
            case UNTIL:
                return 22;
            case WHILE:
                return 23;
            case '(':
                return 24;
        }
        return 271;
    }

    private int yys82() {
        switch (yytok) {
            case ',':
            case '+':
            case '*':
            case '-':
            case ')':
            case '%':
            case '!':
            case ENDINPUT:
            case '^':
            case ']':
            case '>':
            case '=':
            case '<':
            case ';':
            case THEN:
            case '/':
                return yyr62();
        }
        return 271;
    }

    private int yys83() {
        switch (yytok) {
            case ALIAS:
                return 10;
            case EXIT:
                return 12;
            case ID:
                return 13;
            case IF:
                return 14;
            case INCLUDE:
                return 15;
            case NUMBER:
                return 16;
            case PUTS:
                return 17;
            case RETURN:
                return 18;
            case STRING_LITERAL:
                return 19;
            case UNDEF:
                return 20;
            case UNLESS:
                return 21;
            case UNTIL:
                return 22;
            case WHILE:
                return 23;
            case '(':
                return 24;
        }
        return 271;
    }

    private int yys86() {
        switch (yytok) {
            case ',':
            case ')':
            case '!':
            case ENDINPUT:
            case ']':
            case '>':
            case '=':
            case '<':
            case ';':
            case THEN:
                return yyr54();
        }
        return 271;
    }

    private int yys89() {
        switch (yytok) {
            case ALIAS:
                return 10;
            case EXIT:
                return 12;
            case ID:
                return 13;
            case IF:
                return 14;
            case INCLUDE:
                return 15;
            case NUMBER:
                return 16;
            case PUTS:
                return 17;
            case RETURN:
                return 18;
            case STRING_LITERAL:
                return 19;
            case UNDEF:
                return 20;
            case UNLESS:
                return 21;
            case UNTIL:
                return 22;
            case WHILE:
                return 23;
            case '(':
                return 24;
        }
        return 271;
    }

    private int yys95() {
        switch (yytok) {
            case NUMBER:
                return 16;
            case STRING_LITERAL:
                return 19;
            case '(':
                return 24;
            case ID:
                return 41;
            case '!':
                return 42;
            case '[':
                return 43;
        }
        return 271;
    }

    private int yys96() {
        switch (yytok) {
            case NUMBER:
                return 16;
            case STRING_LITERAL:
                return 19;
            case '(':
                return 24;
            case ID:
                return 41;
            case '!':
                return 42;
            case '[':
                return 43;
        }
        return 271;
    }

    private int yys110() {
        switch (yytok) {
            case ALIAS:
                return 10;
            case EXIT:
                return 12;
            case ID:
                return 13;
            case IF:
                return 14;
            case INCLUDE:
                return 15;
            case NUMBER:
                return 16;
            case PUTS:
                return 17;
            case RETURN:
                return 18;
            case STRING_LITERAL:
                return 19;
            case UNDEF:
                return 20;
            case UNLESS:
                return 21;
            case UNTIL:
                return 22;
            case WHILE:
                return 23;
            case '(':
                return 24;
            case END:
                return 118;
        }
        return 271;
    }

    private int yys111() {
        switch (yytok) {
            case ALIAS:
                return 10;
            case EXIT:
                return 12;
            case ID:
                return 13;
            case IF:
                return 14;
            case INCLUDE:
                return 15;
            case NUMBER:
                return 16;
            case PUTS:
                return 17;
            case RETURN:
                return 18;
            case STRING_LITERAL:
                return 19;
            case UNDEF:
                return 20;
            case UNLESS:
                return 21;
            case UNTIL:
                return 22;
            case WHILE:
                return 23;
            case '(':
                return 24;
            case END:
                return 119;
        }
        return 271;
    }

    private int yys112() {
        switch (yytok) {
            case ALIAS:
                return 10;
            case EXIT:
                return 12;
            case ID:
                return 13;
            case IF:
                return 14;
            case INCLUDE:
                return 15;
            case NUMBER:
                return 16;
            case PUTS:
                return 17;
            case RETURN:
                return 18;
            case STRING_LITERAL:
                return 19;
            case UNDEF:
                return 20;
            case UNLESS:
                return 21;
            case UNTIL:
                return 22;
            case WHILE:
                return 23;
            case '(':
                return 24;
            case END:
                return 120;
        }
        return 271;
    }

    private int yys115() {
        switch (yytok) {
            case ',':
            case ')':
            case '!':
            case ENDINPUT:
            case ']':
            case '>':
            case '=':
            case '<':
            case ';':
            case THEN:
                return yyr53();
        }
        return 271;
    }

    private int yys116() {
        switch (yytok) {
            case ALIAS:
                return 10;
            case EXIT:
                return 12;
            case ID:
                return 13;
            case IF:
                return 14;
            case INCLUDE:
                return 15;
            case NUMBER:
                return 16;
            case PUTS:
                return 17;
            case RETURN:
                return 18;
            case STRING_LITERAL:
                return 19;
            case UNDEF:
                return 20;
            case UNLESS:
                return 21;
            case UNTIL:
                return 22;
            case WHILE:
                return 23;
            case '(':
                return 24;
            case ELSE:
                return 124;
            case ELSIF:
                return 125;
            case END:
                return yyr26();
        }
        return 271;
    }

    private int yys124() {
        switch (yytok) {
            case ALIAS:
                return 10;
            case EXIT:
                return 12;
            case ID:
                return 13;
            case IF:
                return 14;
            case INCLUDE:
                return 15;
            case NUMBER:
                return 16;
            case PUTS:
                return 17;
            case RETURN:
                return 18;
            case STRING_LITERAL:
                return 19;
            case UNDEF:
                return 20;
            case UNLESS:
                return 21;
            case UNTIL:
                return 22;
            case WHILE:
                return 23;
            case '(':
                return 24;
        }
        return 271;
    }

    private int yys125() {
        switch (yytok) {
            case NUMBER:
                return 16;
            case STRING_LITERAL:
                return 19;
            case '(':
                return 24;
            case ID:
                return 41;
            case '!':
                return 42;
            case '[':
                return 43;
        }
        return 271;
    }

    private int yys129() {
        switch (yytok) {
            case ALIAS:
                return 10;
            case EXIT:
                return 12;
            case ID:
                return 13;
            case IF:
                return 14;
            case INCLUDE:
                return 15;
            case NUMBER:
                return 16;
            case PUTS:
                return 17;
            case RETURN:
                return 18;
            case STRING_LITERAL:
                return 19;
            case UNDEF:
                return 20;
            case UNLESS:
                return 21;
            case UNTIL:
                return 22;
            case WHILE:
                return 23;
            case '(':
                return 24;
            case END:
                return yyr24();
        }
        return 271;
    }

    private int yys130() {
        switch (yytok) {
            case ALIAS:
                return 10;
            case EXIT:
                return 12;
            case ID:
                return 13;
            case IF:
                return 14;
            case INCLUDE:
                return 15;
            case NUMBER:
                return 16;
            case PUTS:
                return 17;
            case RETURN:
                return 18;
            case STRING_LITERAL:
                return 19;
            case UNDEF:
                return 20;
            case UNLESS:
                return 21;
            case UNTIL:
                return 22;
            case WHILE:
                return 23;
            case '(':
                return 24;
        }
        return 271;
    }

    private int yys132() {
        switch (yytok) {
            case ALIAS:
                return 10;
            case EXIT:
                return 12;
            case ID:
                return 13;
            case IF:
                return 14;
            case INCLUDE:
                return 15;
            case NUMBER:
                return 16;
            case PUTS:
                return 17;
            case RETURN:
                return 18;
            case STRING_LITERAL:
                return 19;
            case UNDEF:
                return 20;
            case UNLESS:
                return 21;
            case UNTIL:
                return 22;
            case WHILE:
                return 23;
            case '(':
                return 24;
            case ELSE:
                return 124;
            case ELSIF:
                return 125;
            case END:
                return yyr26();
        }
        return 271;
    }

    private int yyr1() { // start : start NL block
        yysp -= 3;
        return 1;
    }

    private int yyr2() { // start : block
        yysp -= 1;
        return 1;
    }

    private int yyr12() { // action : IF boolexp then NL loop_action NL elsec END
        yysp -= 8;
        return yypaction();
    }

    private int yyr13() { // action : WHILE boolexp NL loop_action NL END
        yysp -= 6;
        return yypaction();
    }

    private int yyr14() { // action : UNLESS boolexp NL loop_action NL END
        yysp -= 6;
        return yypaction();
    }

    private int yyr15() { // action : UNTIL boolexp NL loop_action NL END
        yysp -= 6;
        return yypaction();
    }

    private int yyr16() { // action : INCLUDE ID
        yysp -= 2;
        return yypaction();
    }

    private int yyr17() { // action : PUTS expr
        {System.out.println(yysv[yysp-1].val);}
        yysv[yysp-=2] = yyrv;
        return yypaction();
    }

    private int yyr18() { // action : RETURN expr
        yysp -= 2;
        return yypaction();
    }

    private int yyr19() { // action : RETURN
        yysp -= 1;
        return yypaction();
    }

    private int yyr20() { // action : EXIT
        {System.exit(0);}
        yysv[yysp-=1] = yyrv;
        return yypaction();
    }

    private int yyr21() { // action : declaration
        yysp -= 1;
        return yypaction();
    }

    private int yyr22() { // action : assignment
        yysp -= 1;
        return yypaction();
    }

    private int yyr23() { // action : expr
        yysp -= 1;
        return yypaction();
    }

    private int yypaction() {
        switch (yyst[yysp-1]) {
            case 130: return 98;
            case 124: return 98;
            case 89: return 98;
            case 83: return 102;
            case 81: return 98;
            case 80: return 98;
            case 79: return 98;
            case 25: return 2;
            case 0: return 2;
            default: return 117;
        }
    }

    private int yyr44() { // args : expr ',' args
        yysp -= 3;
        return yypargs();
    }

    private int yyr45() { // args : expr
        yysp -= 1;
        return yypargs();
    }

    private int yypargs() {
        switch (yyst[yysp-1]) {
            case 87: return 105;
            default: return 63;
        }
    }

    private int yyr46() { // argswrapper : args
        yysp -= 1;
        return yypargswrapper();
    }

    private int yyr47() { // argswrapper : /* empty */
        return yypargswrapper();
    }

    private int yypargswrapper() {
        switch (yyst[yysp-1]) {
            case 35: return 64;
            default: return 106;
        }
    }

    private int yyr52() { // assignment : ID '=' expr
        {modify((String)yysv[yysp-3].val, yysv[yysp-1].val);}
        yysv[yysp-=3] = yyrv;
        return 3;
    }

    private int yyr4() { // block : action
        yysp -= 1;
        return yypblock();
    }

    private int yyr5() { // block : defun
        yysp -= 1;
        return yypblock();
    }

    private int yyr6() { // block : /* empty */
        return yypblock();
    }

    private int yypblock() {
        switch (yyst[yysp-1]) {
            case 0: return 4;
            default: return 53;
        }
    }

    private int yyr27() { // boolexp : expr cpop expr
        yysp -= 3;
        return yypboolexp();
    }

    private int yyr28() { // boolexp : symbol '&' '&' boolexp
        yysp -= 4;
        return yypboolexp();
    }

    private int yyr29() { // boolexp : symbol '|' '|' boolexp
        yysp -= 4;
        return yypboolexp();
    }

    private int yyr30() { // boolexp : '!' boolexp
        yysp -= 2;
        return yypboolexp();
    }

    private int yyr31() { // boolexp : '[' boolexp ']'
        yysp -= 3;
        return yypboolexp();
    }

    private int yyr32() { // boolexp : symbol
        yysp -= 1;
        return yypboolexp();
    }

    private int yypboolexp() {
        switch (yyst[yysp-1]) {
            case 96: return 109;
            case 95: return 108;
            case 43: return 78;
            case 42: return 77;
            case 23: return 50;
            case 22: return 49;
            case 21: return 48;
            case 14: return 38;
            default: return 128;
        }
    }

    private int yyr33() { // cpop : '=' '='
        yysp -= 2;
        return 70;
    }

    private int yyr34() { // cpop : '!' '='
        yysp -= 2;
        return 70;
    }

    private int yyr35() { // cpop : '<'
        yysp -= 1;
        return 70;
    }

    private int yyr36() { // cpop : '<' '='
        yysp -= 2;
        return 70;
    }

    private int yyr37() { // cpop : '>'
        yysp -= 1;
        return 70;
    }

    private int yyr38() { // cpop : '>' '='
        yysp -= 2;
        return 70;
    }

    private int yyr48() { // declaration : ID '=' expr
        {declare((String)yysv[yysp-3].val,yysv[yysp-1].val);}
        yysv[yysp-=3] = yyrv;
        return 5;
    }

    private int yyr49() { // declaration : ID
        {declare((String)yysv[yysp-1].val,null);}
        yysv[yysp-=1] = yyrv;
        return 5;
    }

    private int yyr50() { // declaration : UNDEF ID
        {undefine((String)yysv[yysp-1].val);}
        yysv[yysp-=2] = yyrv;
        return 5;
    }

    private int yyr51() { // declaration : ALIAS ID ID
        {alias((String)yysv[yysp-2].val, (String)yysv[yysp-1].val);}
        yysv[yysp-=3] = yyrv;
        return 5;
    }

    private int yyr39() { // defargs : ID defargs_long
        yysp -= 2;
        switch (yyst[yysp-1]) {
            case 62: return 84;
            default: return 122;
        }
    }

    private int yyr40() { // defargs_long : defargs_long ',' defargs
        yysp -= 3;
        return 104;
    }

    private int yyr41() { // defargs_long : /* empty */
        return 104;
    }

    private int yyr42() { // defargswrapper : '(' defargs ')'
        yysp -= 3;
        return 61;
    }

    private int yyr43() { // defargswrapper : /* empty */
        return 61;
    }

    private int yyr7() { // defun : DEF ID defargswrapper NL action NL END
        { System.out.println("Function definition accepted.");}
        yysv[yysp-=7] = yyrv;
        return 6;
    }

    private int yyr24() { // elsec : ELSE loop_action NL
        yysp -= 3;
        return yypelsec();
    }

    private int yyr25() { // elsec : ELSIF boolexp NL loop_action NL elsec
        yysp -= 6;
        return yypelsec();
    }

    private int yyr26() { // elsec : /* empty */
        return yypelsec();
    }

    private int yypelsec() {
        switch (yyst[yysp-1]) {
            case 116: return 123;
            default: return 133;
        }
    }

    private int yyr53() { // expr : ID '.' ID '(' argswrapper ')'
        yysp -= 6;
        return yypexpr();
    }

    private int yyr54() { // expr : ID '(' argswrapper ')'
        yysp -= 4;
        return yypexpr();
    }

    private int yyr55() { // expr : valexpr
        {yyrv.val = yysv[yysp-1].val;}
        yysv[yysp-=1] = yyrv;
        return yypexpr();
    }

    private int yypexpr() {
        switch (yyst[yysp-1]) {
            case 125: return 39;
            case 96: return 39;
            case 95: return 39;
            case 88: return 65;
            case 87: return 65;
            case 70: return 90;
            case 43: return 39;
            case 42: return 39;
            case 37: return 67;
            case 35: return 65;
            case 23: return 39;
            case 22: return 39;
            case 21: return 39;
            case 18: return 46;
            case 17: return 45;
            case 14: return 39;
            default: return 7;
        }
    }

    private int yyr10() { // loop_action : loop_action NL action
        yysp -= 3;
        return yyploop_action();
    }

    private int yyr11() { // loop_action : action
        yysp -= 1;
        return yyploop_action();
    }

    private int yyploop_action() {
        switch (yyst[yysp-1]) {
            case 124: return 127;
            case 89: return 107;
            case 81: return 101;
            case 80: return 100;
            case 79: return 99;
            default: return 131;
        }
    }

    private int yyr3() { // NL : ';'
        yysp -= 1;
        switch (yyst[yysp-1]) {
            case 128: return 130;
            case 127: return 129;
            case 107: return 116;
            case 102: return 113;
            case 101: return 112;
            case 100: return 111;
            case 99: return 110;
            case 68: return 89;
            case 61: return 83;
            case 50: return 81;
            case 49: return 80;
            case 48: return 79;
            case 1: return 25;
            default: return 132;
        }
    }

    private int yyr64() { // symbol : ID
        {yyrv = new SemanticWrapper(lookup((String)yysv[yysp-1].val));}
        yysv[yysp-=1] = yyrv;
        return yypsymbol();
    }

    private int yyr65() { // symbol : NUMBER
        {yyrv = new SemanticWrapper(yysv[yysp-1].val);}
        yysv[yysp-=1] = yyrv;
        return yypsymbol();
    }

    private int yyr66() { // symbol : STRING_LITERAL
        yysp -= 1;
        return yypsymbol();
    }

    private int yypsymbol() {
        switch (yyst[yysp-1]) {
            case 125: return 40;
            case 96: return 40;
            case 95: return 40;
            case 43: return 40;
            case 42: return 40;
            case 23: return 40;
            case 22: return 40;
            case 21: return 40;
            case 14: return 40;
            default: return 8;
        }
    }

    private int yyr8() { // then : THEN
        yysp -= 1;
        return 68;
    }

    private int yyr9() { // then : /* empty */
        return 68;
    }

    private int yyr56() { // valexpr : valexpr '+' valexpr
        {yyrv = new SemanticWrapper((Double)(yysv[yysp-3].val)+(Double)(yysv[yysp-1].val));}
        yysv[yysp-=3] = yyrv;
        return yypvalexpr();
    }

    private int yyr57() { // valexpr : valexpr '-' valexpr
        {yyrv = new SemanticWrapper((Double)(yysv[yysp-3].val)-(Double)(yysv[yysp-1].val));}
        yysv[yysp-=3] = yyrv;
        return yypvalexpr();
    }

    private int yyr58() { // valexpr : valexpr '*' valexpr
        {yyrv = new SemanticWrapper((Double)(yysv[yysp-3].val)*(Double)(yysv[yysp-1].val));}
        yysv[yysp-=3] = yyrv;
        return yypvalexpr();
    }

    private int yyr59() { // valexpr : valexpr '/' valexpr
        {yyrv = new SemanticWrapper((Double)(yysv[yysp-3].val)/(Double)(yysv[yysp-1].val));}
        yysv[yysp-=3] = yyrv;
        return yypvalexpr();
    }

    private int yyr60() { // valexpr : valexpr '^' valexpr
        {yyrv = new SemanticWrapper(Math.pow((Double)(yysv[yysp-3].val),(Double)(yysv[yysp-1].val)));}
        yysv[yysp-=3] = yyrv;
        return yypvalexpr();
    }

    private int yyr61() { // valexpr : valexpr '%' valexpr
        {yyrv = new SemanticWrapper((Double)(yysv[yysp-3].val)%(Double)(yysv[yysp-1].val));}
        yysv[yysp-=3] = yyrv;
        return yypvalexpr();
    }

    private int yyr62() { // valexpr : '(' valexpr ')'
        {yyrv = new SemanticWrapper(yysv[yysp-2].val);}
        yysv[yysp-=3] = yyrv;
        return yypvalexpr();
    }

    private int yyr63() { // valexpr : symbol
        {yyrv = new SemanticWrapper(yysv[yysp-1].val);}
        yysv[yysp-=1] = yyrv;
        return yypvalexpr();
    }

    private int yypvalexpr() {
        switch (yyst[yysp-1]) {
            case 32: return 59;
            case 31: return 58;
            case 30: return 57;
            case 29: return 56;
            case 28: return 55;
            case 27: return 54;
            case 24: return 51;
            default: return 9;
        }
    }

    protected String[] yyerrmsgs = {
    };

  private RubyLexer lexer;
  
  private HashMap<String, Object> symbolTable = new HashMap<String, Object>();

  public RubyParser(RubyLexer lexer) { this.lexer = lexer; }

  private void yyerror(String msg) {
    Main.error(yyerrno<0 ? msg : yyerrmsgs[yyerrno]);
  }
  
  private Object lookup(String name) {
    return symbolTable.get(name);
  }
  
  private void modify(String name, Object val) {
    symbolTable.put(name, val);
  }

  private void undefine(String name) {
    symbolTable.remove(name);
  }

  private void alias(String name1, String name2) {
    Object value = symbolTable.remove(name1);
    symbolTable.put(name2, value);
  }
  
  private void declare(String name, Object val) {
    if (val instanceof Number) {
        symbolTable.put(name, (Double)val);
    }
  }

}
