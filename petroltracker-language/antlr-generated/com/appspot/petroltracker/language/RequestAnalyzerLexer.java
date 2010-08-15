// $ANTLR 3.1.1 /home/saidimu/workspace/petroltracker-language/src/com/appspot/petroltracker/language/RequestAnalyzer.g 2010-08-15 03:45:03

	package com.appspot.petroltracker.language;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class RequestAnalyzerLexer extends Lexer {
    public static final int INTEGER=7;
    public static final int WS=9;
    public static final int T__11=11;
    public static final int T__10=10;
    public static final int NUMBER=6;
    public static final int IDENT=5;
    public static final int FLOAT=8;
    public static final int EOF=-1;
    public static final int DELIMITER=4;

    // delegates
    // delegators

    public RequestAnalyzerLexer() {;} 
    public RequestAnalyzerLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public RequestAnalyzerLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "/home/saidimu/workspace/petroltracker-language/src/com/appspot/petroltracker/language/RequestAnalyzer.g"; }

    // $ANTLR start "T__10"
    public final void mT__10() throws RecognitionException {
        try {
            int _type = T__10;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/saidimu/workspace/petroltracker-language/src/com/appspot/petroltracker/language/RequestAnalyzer.g:11:7: ( 'petrol' )
            // /home/saidimu/workspace/petroltracker-language/src/com/appspot/petroltracker/language/RequestAnalyzer.g:11:9: 'petrol'
            {
            match("petrol"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__10"

    // $ANTLR start "T__11"
    public final void mT__11() throws RecognitionException {
        try {
            int _type = T__11;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/saidimu/workspace/petroltracker-language/src/com/appspot/petroltracker/language/RequestAnalyzer.g:12:7: ( 'diesel' )
            // /home/saidimu/workspace/petroltracker-language/src/com/appspot/petroltracker/language/RequestAnalyzer.g:12:9: 'diesel'
            {
            match("diesel"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__11"

    // $ANTLR start "NUMBER"
    public final void mNUMBER() throws RecognitionException {
        try {
            int _type = NUMBER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/saidimu/workspace/petroltracker-language/src/com/appspot/petroltracker/language/RequestAnalyzer.g:46:7: ( INTEGER | FLOAT )
            int alt1=2;
            alt1 = dfa1.predict(input);
            switch (alt1) {
                case 1 :
                    // /home/saidimu/workspace/petroltracker-language/src/com/appspot/petroltracker/language/RequestAnalyzer.g:46:9: INTEGER
                    {
                    mINTEGER(); 

                    }
                    break;
                case 2 :
                    // /home/saidimu/workspace/petroltracker-language/src/com/appspot/petroltracker/language/RequestAnalyzer.g:46:19: FLOAT
                    {
                    mFLOAT(); 

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NUMBER"

    // $ANTLR start "FLOAT"
    public final void mFLOAT() throws RecognitionException {
        try {
            // /home/saidimu/workspace/petroltracker-language/src/com/appspot/petroltracker/language/RequestAnalyzer.g:47:15: ( INTEGER '.' ( INTEGER )+ )
            // /home/saidimu/workspace/petroltracker-language/src/com/appspot/petroltracker/language/RequestAnalyzer.g:47:17: INTEGER '.' ( INTEGER )+
            {
            mINTEGER(); 
            match('.'); 
            // /home/saidimu/workspace/petroltracker-language/src/com/appspot/petroltracker/language/RequestAnalyzer.g:47:29: ( INTEGER )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /home/saidimu/workspace/petroltracker-language/src/com/appspot/petroltracker/language/RequestAnalyzer.g:47:29: INTEGER
            	    {
            	    mINTEGER(); 

            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end "FLOAT"

    // $ANTLR start "INTEGER"
    public final void mINTEGER() throws RecognitionException {
        try {
            // /home/saidimu/workspace/petroltracker-language/src/com/appspot/petroltracker/language/RequestAnalyzer.g:48:17: ( ( '0' .. '9' )+ )
            // /home/saidimu/workspace/petroltracker-language/src/com/appspot/petroltracker/language/RequestAnalyzer.g:48:19: ( '0' .. '9' )+
            {
            // /home/saidimu/workspace/petroltracker-language/src/com/appspot/petroltracker/language/RequestAnalyzer.g:48:19: ( '0' .. '9' )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='0' && LA3_0<='9')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /home/saidimu/workspace/petroltracker-language/src/com/appspot/petroltracker/language/RequestAnalyzer.g:48:19: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end "INTEGER"

    // $ANTLR start "IDENT"
    public final void mIDENT() throws RecognitionException {
        try {
            int _type = IDENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/saidimu/workspace/petroltracker-language/src/com/appspot/petroltracker/language/RequestAnalyzer.g:49:7: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )* )
            // /home/saidimu/workspace/petroltracker-language/src/com/appspot/petroltracker/language/RequestAnalyzer.g:49:9: ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )*
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // /home/saidimu/workspace/petroltracker-language/src/com/appspot/petroltracker/language/RequestAnalyzer.g:49:31: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='0' && LA4_0<='9')||(LA4_0>='A' && LA4_0<='Z')||(LA4_0>='a' && LA4_0<='z')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /home/saidimu/workspace/petroltracker-language/src/com/appspot/petroltracker/language/RequestAnalyzer.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IDENT"

    // $ANTLR start "DELIMITER"
    public final void mDELIMITER() throws RecognitionException {
        try {
            int _type = DELIMITER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/saidimu/workspace/petroltracker-language/src/com/appspot/petroltracker/language/RequestAnalyzer.g:50:10: ( ',' )
            // /home/saidimu/workspace/petroltracker-language/src/com/appspot/petroltracker/language/RequestAnalyzer.g:50:12: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DELIMITER"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/saidimu/workspace/petroltracker-language/src/com/appspot/petroltracker/language/RequestAnalyzer.g:51:4: ( ( ' ' | '\\t' | '\\n' | '\\r' | '\\f' )+ )
            // /home/saidimu/workspace/petroltracker-language/src/com/appspot/petroltracker/language/RequestAnalyzer.g:51:6: ( ' ' | '\\t' | '\\n' | '\\r' | '\\f' )+
            {
            // /home/saidimu/workspace/petroltracker-language/src/com/appspot/petroltracker/language/RequestAnalyzer.g:51:6: ( ' ' | '\\t' | '\\n' | '\\r' | '\\f' )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>='\t' && LA5_0<='\n')||(LA5_0>='\f' && LA5_0<='\r')||LA5_0==' ') ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // /home/saidimu/workspace/petroltracker-language/src/com/appspot/petroltracker/language/RequestAnalyzer.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||(input.LA(1)>='\f' && input.LA(1)<='\r')||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);

            _channel = HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WS"

    public void mTokens() throws RecognitionException {
        // /home/saidimu/workspace/petroltracker-language/src/com/appspot/petroltracker/language/RequestAnalyzer.g:1:8: ( T__10 | T__11 | NUMBER | IDENT | DELIMITER | WS )
        int alt6=6;
        alt6 = dfa6.predict(input);
        switch (alt6) {
            case 1 :
                // /home/saidimu/workspace/petroltracker-language/src/com/appspot/petroltracker/language/RequestAnalyzer.g:1:10: T__10
                {
                mT__10(); 

                }
                break;
            case 2 :
                // /home/saidimu/workspace/petroltracker-language/src/com/appspot/petroltracker/language/RequestAnalyzer.g:1:16: T__11
                {
                mT__11(); 

                }
                break;
            case 3 :
                // /home/saidimu/workspace/petroltracker-language/src/com/appspot/petroltracker/language/RequestAnalyzer.g:1:22: NUMBER
                {
                mNUMBER(); 

                }
                break;
            case 4 :
                // /home/saidimu/workspace/petroltracker-language/src/com/appspot/petroltracker/language/RequestAnalyzer.g:1:29: IDENT
                {
                mIDENT(); 

                }
                break;
            case 5 :
                // /home/saidimu/workspace/petroltracker-language/src/com/appspot/petroltracker/language/RequestAnalyzer.g:1:35: DELIMITER
                {
                mDELIMITER(); 

                }
                break;
            case 6 :
                // /home/saidimu/workspace/petroltracker-language/src/com/appspot/petroltracker/language/RequestAnalyzer.g:1:45: WS
                {
                mWS(); 

                }
                break;

        }

    }


    protected DFA1 dfa1 = new DFA1(this);
    protected DFA6 dfa6 = new DFA6(this);
    static final String DFA1_eotS =
        "\1\uffff\1\2\2\uffff";
    static final String DFA1_eofS =
        "\4\uffff";
    static final String DFA1_minS =
        "\1\60\1\56\2\uffff";
    static final String DFA1_maxS =
        "\2\71\2\uffff";
    static final String DFA1_acceptS =
        "\2\uffff\1\1\1\2";
    static final String DFA1_specialS =
        "\4\uffff}>";
    static final String[] DFA1_transitionS = {
            "\12\1",
            "\1\3\1\uffff\12\1",
            "",
            ""
    };

    static final short[] DFA1_eot = DFA.unpackEncodedString(DFA1_eotS);
    static final short[] DFA1_eof = DFA.unpackEncodedString(DFA1_eofS);
    static final char[] DFA1_min = DFA.unpackEncodedStringToUnsignedChars(DFA1_minS);
    static final char[] DFA1_max = DFA.unpackEncodedStringToUnsignedChars(DFA1_maxS);
    static final short[] DFA1_accept = DFA.unpackEncodedString(DFA1_acceptS);
    static final short[] DFA1_special = DFA.unpackEncodedString(DFA1_specialS);
    static final short[][] DFA1_transition;

    static {
        int numStates = DFA1_transitionS.length;
        DFA1_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA1_transition[i] = DFA.unpackEncodedString(DFA1_transitionS[i]);
        }
    }

    class DFA1 extends DFA {

        public DFA1(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 1;
            this.eot = DFA1_eot;
            this.eof = DFA1_eof;
            this.min = DFA1_min;
            this.max = DFA1_max;
            this.accept = DFA1_accept;
            this.special = DFA1_special;
            this.transition = DFA1_transition;
        }
        public String getDescription() {
            return "46:1: NUMBER : ( INTEGER | FLOAT );";
        }
    }
    static final String DFA6_eotS =
        "\1\uffff\2\4\4\uffff\10\4\1\21\1\22\2\uffff";
    static final String DFA6_eofS =
        "\23\uffff";
    static final String DFA6_minS =
        "\1\11\1\145\1\151\4\uffff\1\164\1\145\1\162\1\163\1\157\1\145\2"+
        "\154\2\60\2\uffff";
    static final String DFA6_maxS =
        "\1\172\1\145\1\151\4\uffff\1\164\1\145\1\162\1\163\1\157\1\145\2"+
        "\154\2\172\2\uffff";
    static final String DFA6_acceptS =
        "\3\uffff\1\3\1\4\1\5\1\6\12\uffff\1\1\1\2";
    static final String DFA6_specialS =
        "\23\uffff}>";
    static final String[] DFA6_transitionS = {
            "\2\6\1\uffff\2\6\22\uffff\1\6\13\uffff\1\5\3\uffff\12\3\7\uffff"+
            "\32\4\6\uffff\3\4\1\2\13\4\1\1\12\4",
            "\1\7",
            "\1\10",
            "",
            "",
            "",
            "",
            "\1\11",
            "\1\12",
            "\1\13",
            "\1\14",
            "\1\15",
            "\1\16",
            "\1\17",
            "\1\20",
            "\12\4\7\uffff\32\4\6\uffff\32\4",
            "\12\4\7\uffff\32\4\6\uffff\32\4",
            "",
            ""
    };

    static final short[] DFA6_eot = DFA.unpackEncodedString(DFA6_eotS);
    static final short[] DFA6_eof = DFA.unpackEncodedString(DFA6_eofS);
    static final char[] DFA6_min = DFA.unpackEncodedStringToUnsignedChars(DFA6_minS);
    static final char[] DFA6_max = DFA.unpackEncodedStringToUnsignedChars(DFA6_maxS);
    static final short[] DFA6_accept = DFA.unpackEncodedString(DFA6_acceptS);
    static final short[] DFA6_special = DFA.unpackEncodedString(DFA6_specialS);
    static final short[][] DFA6_transition;

    static {
        int numStates = DFA6_transitionS.length;
        DFA6_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA6_transition[i] = DFA.unpackEncodedString(DFA6_transitionS[i]);
        }
    }

    class DFA6 extends DFA {

        public DFA6(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 6;
            this.eot = DFA6_eot;
            this.eof = DFA6_eof;
            this.min = DFA6_min;
            this.max = DFA6_max;
            this.accept = DFA6_accept;
            this.special = DFA6_special;
            this.transition = DFA6_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__10 | T__11 | NUMBER | IDENT | DELIMITER | WS );";
        }
    }
 

}