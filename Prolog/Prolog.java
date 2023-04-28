// Output created by jacc on Fri Apr 28 22:27:44 EAT 2023


class Prolog implements PrologTokens {
    private int yyss = 100;
    private int yytok;
    private int yysp = 0;
    private int[] yyst;
    protected int yyerrno = (-1);
    private char[] yysv;
    private char yyrv;

    public boolean parse() {
        int yyn = 0;
        yysp = 0;
        yyst = new int[yyss];
        yysv = new char[yyss];
        yytok = (token
                 );
    loop:
        for (;;) {
            switch (yyn) {
                case 0:
                    yyst[yysp] = 0;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 33:
                    switch (yytok) {
                        case identifier:
                            yyn = 7;
                            continue;
                    }
                    yyn = 69;
                    continue;

                case 1:
                    yyst[yysp] = 1;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 34:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = 66;
                            continue;
                        case '.':
                            yyn = 8;
                            continue;
                    }
                    yyn = 69;
                    continue;

                case 2:
                    yyst[yysp] = 2;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 35:
                    switch (yytok) {
                        case ENDINPUT:
                        case '.':
                            yyn = yyr2();
                            continue;
                    }
                    yyn = 69;
                    continue;

                case 3:
                    yyst[yysp] = 3;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 36:
                    switch (yytok) {
                        case ENDINPUT:
                        case '.':
                            yyn = yyr3();
                            continue;
                    }
                    yyn = 69;
                    continue;

                case 4:
                    yyst[yysp] = 4;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 37:
                    switch (yytok) {
                        case ':':
                            yyn = 9;
                            continue;
                        case ENDINPUT:
                        case '.':
                            yyn = yyr5();
                            continue;
                    }
                    yyn = 69;
                    continue;

                case 5:
                    yyst[yysp] = 5;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 38:
                    yyn = yys5();
                    continue;

                case 6:
                    yyst[yysp] = 6;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 39:
                    switch (yytok) {
                        case ENDINPUT:
                        case '.':
                            yyn = yyr4();
                            continue;
                    }
                    yyn = 69;
                    continue;

                case 7:
                    yyst[yysp] = 7;
                    yysv[yysp] = (yylval
                                 );
                    yytok = (yylex()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 40:
                    yyn = yys7();
                    continue;

                case 8:
                    yyst[yysp] = 8;
                    yysv[yysp] = (yylval
                                 );
                    yytok = (yylex()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 41:
                    switch (yytok) {
                        case identifier:
                            yyn = 7;
                            continue;
                    }
                    yyn = 69;
                    continue;

                case 9:
                    yyst[yysp] = 9;
                    yysv[yysp] = (yylval
                                 );
                    yytok = (yylex()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 42:
                    switch (yytok) {
                        case '-':
                            yyn = 15;
                            continue;
                    }
                    yyn = 69;
                    continue;

                case 10:
                    yyst[yysp] = 10;
                    yysv[yysp] = (yylval
                                 );
                    yytok = (yylex()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 43:
                    yyn = yys10();
                    continue;

                case 11:
                    yyst[yysp] = 11;
                    yysv[yysp] = (yylval
                                 );
                    yytok = (yylex()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 44:
                    switch (yytok) {
                        case identifier:
                            yyn = 7;
                            continue;
                        case variable:
                            yyn = 13;
                            continue;
                        case ',':
                        case ')':
                            yyn = yyr16();
                            continue;
                    }
                    yyn = 69;
                    continue;

                case 12:
                    yyst[yysp] = 12;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 45:
                    yyn = yys12();
                    continue;

                case 13:
                    yyst[yysp] = 13;
                    yysv[yysp] = (yylval
                                 );
                    yytok = (yylex()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 46:
                    yyn = yys13();
                    continue;

                case 14:
                    yyst[yysp] = 14;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 47:
                    switch (yytok) {
                        case ENDINPUT:
                        case '.':
                            yyn = yyr1();
                            continue;
                    }
                    yyn = 69;
                    continue;

                case 15:
                    yyst[yysp] = 15;
                    yysv[yysp] = (yylval
                                 );
                    yytok = (yylex()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 48:
                    switch (yytok) {
                        case identifier:
                            yyn = 7;
                            continue;
                        case '(':
                            yyn = 23;
                            continue;
                    }
                    yyn = 69;
                    continue;

                case 16:
                    yyst[yysp] = 16;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 49:
                    switch (yytok) {
                        case identifier:
                            yyn = 7;
                            continue;
                        case ',':
                        case ')':
                            yyn = yyr17();
                            continue;
                    }
                    yyn = 69;
                    continue;

                case 17:
                    yyst[yysp] = 17;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 50:
                    switch (yytok) {
                        case ',':
                        case ')':
                            yyn = yyr14();
                            continue;
                    }
                    yyn = 69;
                    continue;

                case 18:
                    yyst[yysp] = 18;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 51:
                    switch (yytok) {
                        case ')':
                            yyn = 24;
                            continue;
                        case ',':
                            yyn = 25;
                            continue;
                    }
                    yyn = 69;
                    continue;

                case 19:
                    yyst[yysp] = 19;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 52:
                    switch (yytok) {
                        case ',':
                        case ')':
                            yyn = yyr18();
                            continue;
                    }
                    yyn = 69;
                    continue;

                case 20:
                    yyst[yysp] = 20;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 53:
                    yyn = yys20();
                    continue;

                case 21:
                    yyst[yysp] = 21;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 54:
                    switch (yytok) {
                        case ',':
                            yyn = 27;
                            continue;
                        case ';':
                            yyn = 28;
                            continue;
                        case ENDINPUT:
                        case '.':
                            yyn = yyr6();
                            continue;
                    }
                    yyn = 69;
                    continue;

                case 22:
                    yyst[yysp] = 22;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 55:
                    switch (yytok) {
                        case ENDINPUT:
                        case ',':
                        case ';':
                        case ')':
                        case '.':
                            yyn = yyr7();
                            continue;
                    }
                    yyn = 69;
                    continue;

                case 23:
                    yyst[yysp] = 23;
                    yysv[yysp] = (yylval
                                 );
                    yytok = (yylex()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 56:
                    switch (yytok) {
                        case identifier:
                            yyn = 7;
                            continue;
                        case '(':
                            yyn = 23;
                            continue;
                    }
                    yyn = 69;
                    continue;

                case 24:
                    yyst[yysp] = 24;
                    yysv[yysp] = (yylval
                                 );
                    yytok = (yylex()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 57:
                    yyn = yys24();
                    continue;

                case 25:
                    yyst[yysp] = 25;
                    yysv[yysp] = (yylval
                                 );
                    yytok = (yylex()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 58:
                    switch (yytok) {
                        case identifier:
                            yyn = 7;
                            continue;
                        case variable:
                            yyn = 13;
                            continue;
                    }
                    yyn = 69;
                    continue;

                case 26:
                    yyst[yysp] = 26;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 59:
                    switch (yytok) {
                        case identifier:
                            yyn = 7;
                            continue;
                        case '(':
                            yyn = 23;
                            continue;
                    }
                    yyn = 69;
                    continue;

                case 27:
                    yyst[yysp] = 27;
                    yysv[yysp] = (yylval
                                 );
                    yytok = (yylex()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 60:
                    switch (yytok) {
                        case '(':
                        case identifier:
                            yyn = yyr10();
                            continue;
                    }
                    yyn = 69;
                    continue;

                case 28:
                    yyst[yysp] = 28;
                    yysv[yysp] = (yylval
                                 );
                    yytok = (yylex()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 61:
                    switch (yytok) {
                        case '(':
                        case identifier:
                            yyn = yyr11();
                            continue;
                    }
                    yyn = 69;
                    continue;

                case 29:
                    yyst[yysp] = 29;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 62:
                    switch (yytok) {
                        case ',':
                            yyn = 27;
                            continue;
                        case ';':
                            yyn = 28;
                            continue;
                        case ')':
                            yyn = 32;
                            continue;
                    }
                    yyn = 69;
                    continue;

                case 30:
                    yyst[yysp] = 30;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 63:
                    switch (yytok) {
                        case ',':
                        case ')':
                            yyn = yyr15();
                            continue;
                    }
                    yyn = 69;
                    continue;

                case 31:
                    yyst[yysp] = 31;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 64:
                    switch (yytok) {
                        case ',':
                            yyn = 27;
                            continue;
                        case ';':
                            yyn = 28;
                            continue;
                        case ENDINPUT:
                        case ')':
                        case '.':
                            yyn = yyr8();
                            continue;
                    }
                    yyn = 69;
                    continue;

                case 32:
                    yyst[yysp] = 32;
                    yysv[yysp] = (yylval
                                 );
                    yytok = (yylex()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 65:
                    switch (yytok) {
                        case ENDINPUT:
                        case ',':
                        case ';':
                        case ')':
                        case '.':
                            yyn = yyr9();
                            continue;
                    }
                    yyn = 69;
                    continue;

                case 66:
                    return true;
                case 67:
                    yyerror("stack overflow");
                case 68:
                    return false;
                case 69:
                    yyerror("syntax error");
                    return false;
            }
        }
    }

    protected void yyexpand() {
        int[] newyyst = new int[2*yyst.length];
        char[] newyysv = new char[2*yyst.length];
        for (int i=0; i<yyst.length; i++) {
            newyyst[i] = yyst[i];
            newyysv[i] = yysv[i];
        }
        yyst = newyyst;
        yysv = newyysv;
    }

    private int yys5() {
        switch (yytok) {
            case identifier:
                return 10;
            case '(':
                return 11;
            case ENDINPUT:
            case ',':
            case ';':
            case ')':
            case ':':
            case '.':
                return yyr12();
        }
        return 69;
    }

    private int yys7() {
        switch (yytok) {
            case variable:
                return 13;
            case ENDINPUT:
            case ',':
            case ';':
            case ')':
            case ':':
            case '.':
            case '(':
            case identifier:
                return yyr21();
        }
        return 69;
    }

    private int yys10() {
        switch (yytok) {
            case ENDINPUT:
            case ',':
            case ';':
            case ')':
            case ':':
            case '.':
            case '(':
            case identifier:
                return yyr22();
        }
        return 69;
    }

    private int yys12() {
        switch (yytok) {
            case identifier:
                return 7;
            case ENDINPUT:
            case ',':
            case ';':
            case ')':
            case ':':
            case '.':
            case '(':
                return yyr23();
        }
        return 69;
    }

    private int yys13() {
        switch (yytok) {
            case ENDINPUT:
            case ',':
            case ';':
            case ')':
            case ':':
            case '.':
            case '(':
            case identifier:
                return yyr19();
        }
        return 69;
    }

    private int yys20() {
        switch (yytok) {
            case identifier:
                return 10;
            case ENDINPUT:
            case ',':
            case ';':
            case ')':
            case ':':
            case '.':
            case '(':
                return yyr20();
        }
        return 69;
    }

    private int yys24() {
        switch (yytok) {
            case ENDINPUT:
            case ',':
            case ';':
            case ')':
            case ':':
            case '.':
                return yyr13();
        }
        return 69;
    }

    private int yyr1() { // program : program '.' clause
        { System.out.println("Accepted"); }
        yysv[yysp-=3] = yyrv;
        return 1;
    }

    private int yyr2() { // program : clause
        { System.out.println("Accepted"); }
        yysv[yysp-=1] = yyrv;
        return 1;
    }

    private int yyr19() { // VARIABLE : variable
        yysp -= 1;
        return yypVARIABLE();
    }

    private int yyr20() { // VARIABLE : VARIABLE IDENTIFIER
        yysp -= 2;
        return yypVARIABLE();
    }

    private int yypVARIABLE() {
        switch (yyst[yysp-1]) {
            case 7: return 12;
            default: return 16;
        }
    }

    private int yyr17() { // arguement : VARIABLE
        yysp -= 1;
        return yyparguement();
    }

    private int yyr18() { // arguement : predicate
        yysp -= 1;
        return yyparguement();
    }

    private int yyparguement() {
        switch (yyst[yysp-1]) {
            case 11: return 17;
            default: return 30;
        }
    }

    private int yyr14() { // arguements : arguement
        yysp -= 1;
        return 18;
    }

    private int yyr15() { // arguements : arguements ',' arguement
        yysp -= 3;
        return 18;
    }

    private int yyr16() { // arguements : /* empty */
        return 18;
    }

    private int yyr7() { // body : predicate
        yysp -= 1;
        return yypbody();
    }

    private int yyr8() { // body : body separator body
        yysp -= 3;
        return yypbody();
    }

    private int yyr9() { // body : '(' body ')'
        yysp -= 3;
        return yypbody();
    }

    private int yypbody() {
        switch (yyst[yysp-1]) {
            case 23: return 29;
            case 15: return 21;
            default: return 31;
        }
    }

    private int yyr3() { // clause : fact
        yysp -= 1;
        return yypclause();
    }

    private int yyr4() { // clause : rule
        yysp -= 1;
        return yypclause();
    }

    private int yypclause() {
        switch (yyst[yysp-1]) {
            case 0: return 2;
            default: return 14;
        }
    }

    private int yyr5() { // fact : predicate
        yysp -= 1;
        return 3;
    }

    private int yyr12() { // predicate : IDENTIFIER
        yysp -= 1;
        return yyppredicate();
    }

    private int yyr13() { // predicate : IDENTIFIER '(' arguements ')'
        yysp -= 4;
        return yyppredicate();
    }

    private int yyppredicate() {
        switch (yyst[yysp-1]) {
            case 25: return 19;
            case 11: return 19;
            case 8: return 4;
            case 0: return 4;
            default: return 22;
        }
    }

    private int yyr21() { // IDENTIFIER : identifier
        yysp -= 1;
        return yypIDENTIFIER();
    }

    private int yyr22() { // IDENTIFIER : IDENTIFIER identifier
        yysp -= 2;
        return yypIDENTIFIER();
    }

    private int yyr23() { // IDENTIFIER : identifier VARIABLE
        yysp -= 2;
        return yypIDENTIFIER();
    }

    private int yypIDENTIFIER() {
        switch (yyst[yysp-1]) {
            case 16: return 20;
            case 12: return 20;
            default: return 5;
        }
    }

    private int yyr6() { // rule : predicate ':' '-' body
        yysp -= 4;
        return 6;
    }

    private int yyr10() { // separator : ','
        yysp -= 1;
        return 26;
    }

    private int yyr11() { // separator : ';'
        yysp -= 1;
        return 26;
    }

    protected String[] yyerrmsgs = {
    };


  private void yyerror(String msg) {
    System.out.println("ERROR: " + msg);
    System.exit(1);
  }

  private int c;

  /** Read a single input character from standard input.
   */
  private void nextChar() {
    try {
      c = System.in.read();
    } catch (Exception e) {
      c = (-1);
    }
  }

  int token;
  char yylval;

  /** Read the next token and return the
   *  corresponding integer code.
   */
  int yylex() {
    for (;;){
      // Skipping whitespace
      while ( c==' ' || c=='\n' || c=='\t' || c=='\r' ){
        nextChar();
      }
      if (c<0){
        return (token=ENDINPUT);
      }
      switch(c){
        case ',' :
          nextChar();
          return token=',';
        case ':' :
          nextChar();
          return token=':';
        case '-' :
          nextChar();
          return token='-';
        case '(' :
          nextChar();
          return token='(';
        case ')' :
          nextChar();
          return token=')';
        case '?' :
          nextChar();
          return token='?';
        case '"' :
          nextChar();
          return token='"';
        case '.' :
          nextChar();
          return token='.';
        case ';' :
          nextChar();
          return token=';';
        default: 
          if (Character.isUpperCase((char)c)) {
              nextChar();
              return token=(char)variable;
          } else if (Character.isLowerCase((char)c)){
              nextChar();
              return token=(char)identifier;
          } else {
            yyerror("Illegal character " + (char)c);
            nextChar();
          }
      }
    }
  }

  public static void main(String[] args) {
    Prolog prolog = new Prolog();
    prolog.nextChar(); // prime the character input stream
    prolog.yylex();    // prime the token input stream
    prolog.parse();    // parse the input
  }

}
