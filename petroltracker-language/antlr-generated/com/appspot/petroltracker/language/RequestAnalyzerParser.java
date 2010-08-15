// $ANTLR 3.1.1 /home/saidimu/workspace/petroltracker-language/src/com/appspot/petroltracker/language/RequestAnalyzer.g 2010-08-15 03:45:03

	package com.appspot.petroltracker.language;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class RequestAnalyzerParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "DELIMITER", "IDENT", "NUMBER", "INTEGER", "FLOAT", "WS", "'petrol'", "'diesel'"
    };
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


        public RequestAnalyzerParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public RequestAnalyzerParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return RequestAnalyzerParser.tokenNames; }
    public String getGrammarFileName() { return "/home/saidimu/workspace/petroltracker-language/src/com/appspot/petroltracker/language/RequestAnalyzer.g"; }



    // $ANTLR start "request"
    // /home/saidimu/workspace/petroltracker-language/src/com/appspot/petroltracker/language/RequestAnalyzer.g:16:1: request : ( query | update );
    public final void request() throws RecognitionException {
        try {
            // /home/saidimu/workspace/petroltracker-language/src/com/appspot/petroltracker/language/RequestAnalyzer.g:17:2: ( query | update )
            int alt1=2;
            alt1 = dfa1.predict(input);
            switch (alt1) {
                case 1 :
                    // /home/saidimu/workspace/petroltracker-language/src/com/appspot/petroltracker/language/RequestAnalyzer.g:17:4: query
                    {
                    pushFollow(FOLLOW_query_in_request41);
                    query();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // /home/saidimu/workspace/petroltracker-language/src/com/appspot/petroltracker/language/RequestAnalyzer.g:17:12: update
                    {
                    pushFollow(FOLLOW_update_in_request45);
                    update();

                    state._fsp--;


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "request"


    // $ANTLR start "query"
    // /home/saidimu/workspace/petroltracker-language/src/com/appspot/petroltracker/language/RequestAnalyzer.g:21:1: query : location ( DELIMITER fueltype )? ;
    public final void query() throws RecognitionException {
        try {
            // /home/saidimu/workspace/petroltracker-language/src/com/appspot/petroltracker/language/RequestAnalyzer.g:22:2: ( location ( DELIMITER fueltype )? )
            // /home/saidimu/workspace/petroltracker-language/src/com/appspot/petroltracker/language/RequestAnalyzer.g:22:4: location ( DELIMITER fueltype )?
            {
            pushFollow(FOLLOW_location_in_query57);
            location();

            state._fsp--;

            // /home/saidimu/workspace/petroltracker-language/src/com/appspot/petroltracker/language/RequestAnalyzer.g:22:13: ( DELIMITER fueltype )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==DELIMITER) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // /home/saidimu/workspace/petroltracker-language/src/com/appspot/petroltracker/language/RequestAnalyzer.g:22:14: DELIMITER fueltype
                    {
                    match(input,DELIMITER,FOLLOW_DELIMITER_in_query60); 
                    pushFollow(FOLLOW_fueltype_in_query62);
                    fueltype();

                    state._fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "query"


    // $ANTLR start "update"
    // /home/saidimu/workspace/petroltracker-language/src/com/appspot/petroltracker/language/RequestAnalyzer.g:26:1: update : location DELIMITER petrolstation ( DELIMITER fueltype )? DELIMITER price ;
    public final void update() throws RecognitionException {
        try {
            // /home/saidimu/workspace/petroltracker-language/src/com/appspot/petroltracker/language/RequestAnalyzer.g:27:2: ( location DELIMITER petrolstation ( DELIMITER fueltype )? DELIMITER price )
            // /home/saidimu/workspace/petroltracker-language/src/com/appspot/petroltracker/language/RequestAnalyzer.g:27:4: location DELIMITER petrolstation ( DELIMITER fueltype )? DELIMITER price
            {
            pushFollow(FOLLOW_location_in_update76);
            location();

            state._fsp--;

            match(input,DELIMITER,FOLLOW_DELIMITER_in_update78); 
            pushFollow(FOLLOW_petrolstation_in_update80);
            petrolstation();

            state._fsp--;

            // /home/saidimu/workspace/petroltracker-language/src/com/appspot/petroltracker/language/RequestAnalyzer.g:27:37: ( DELIMITER fueltype )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==DELIMITER) ) {
                int LA3_1 = input.LA(2);

                if ( ((LA3_1>=10 && LA3_1<=11)) ) {
                    alt3=1;
                }
            }
            switch (alt3) {
                case 1 :
                    // /home/saidimu/workspace/petroltracker-language/src/com/appspot/petroltracker/language/RequestAnalyzer.g:27:38: DELIMITER fueltype
                    {
                    match(input,DELIMITER,FOLLOW_DELIMITER_in_update83); 
                    pushFollow(FOLLOW_fueltype_in_update85);
                    fueltype();

                    state._fsp--;


                    }
                    break;

            }

            match(input,DELIMITER,FOLLOW_DELIMITER_in_update89); 
            pushFollow(FOLLOW_price_in_update91);
            price();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "update"


    // $ANTLR start "location"
    // /home/saidimu/workspace/petroltracker-language/src/com/appspot/petroltracker/language/RequestAnalyzer.g:30:1: location : ( IDENT )* ;
    public final void location() throws RecognitionException {
        try {
            // /home/saidimu/workspace/petroltracker-language/src/com/appspot/petroltracker/language/RequestAnalyzer.g:31:2: ( ( IDENT )* )
            // /home/saidimu/workspace/petroltracker-language/src/com/appspot/petroltracker/language/RequestAnalyzer.g:31:4: ( IDENT )*
            {
            // /home/saidimu/workspace/petroltracker-language/src/com/appspot/petroltracker/language/RequestAnalyzer.g:31:4: ( IDENT )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==IDENT) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /home/saidimu/workspace/petroltracker-language/src/com/appspot/petroltracker/language/RequestAnalyzer.g:31:4: IDENT
            	    {
            	    match(input,IDENT,FOLLOW_IDENT_in_location103); 

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "location"


    // $ANTLR start "fueltype"
    // /home/saidimu/workspace/petroltracker-language/src/com/appspot/petroltracker/language/RequestAnalyzer.g:34:1: fueltype : ( 'petrol' | 'diesel' ) ;
    public final void fueltype() throws RecognitionException {
        try {
            // /home/saidimu/workspace/petroltracker-language/src/com/appspot/petroltracker/language/RequestAnalyzer.g:35:2: ( ( 'petrol' | 'diesel' ) )
            // /home/saidimu/workspace/petroltracker-language/src/com/appspot/petroltracker/language/RequestAnalyzer.g:35:4: ( 'petrol' | 'diesel' )
            {
            if ( (input.LA(1)>=10 && input.LA(1)<=11) ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "fueltype"


    // $ANTLR start "petrolstation"
    // /home/saidimu/workspace/petroltracker-language/src/com/appspot/petroltracker/language/RequestAnalyzer.g:38:1: petrolstation : ( IDENT )* ;
    public final void petrolstation() throws RecognitionException {
        try {
            // /home/saidimu/workspace/petroltracker-language/src/com/appspot/petroltracker/language/RequestAnalyzer.g:39:2: ( ( IDENT )* )
            // /home/saidimu/workspace/petroltracker-language/src/com/appspot/petroltracker/language/RequestAnalyzer.g:39:4: ( IDENT )*
            {
            // /home/saidimu/workspace/petroltracker-language/src/com/appspot/petroltracker/language/RequestAnalyzer.g:39:4: ( IDENT )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==IDENT) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // /home/saidimu/workspace/petroltracker-language/src/com/appspot/petroltracker/language/RequestAnalyzer.g:39:4: IDENT
            	    {
            	    match(input,IDENT,FOLLOW_IDENT_in_petrolstation133); 

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "petrolstation"


    // $ANTLR start "price"
    // /home/saidimu/workspace/petroltracker-language/src/com/appspot/petroltracker/language/RequestAnalyzer.g:42:1: price : NUMBER ;
    public final void price() throws RecognitionException {
        try {
            // /home/saidimu/workspace/petroltracker-language/src/com/appspot/petroltracker/language/RequestAnalyzer.g:43:2: ( NUMBER )
            // /home/saidimu/workspace/petroltracker-language/src/com/appspot/petroltracker/language/RequestAnalyzer.g:43:4: NUMBER
            {
            match(input,NUMBER,FOLLOW_NUMBER_in_price145); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "price"

    // Delegated rules


    protected DFA1 dfa1 = new DFA1(this);
    static final String DFA1_eotS =
        "\5\uffff";
    static final String DFA1_eofS =
        "\2\3\3\uffff";
    static final String DFA1_minS =
        "\3\4\2\uffff";
    static final String DFA1_maxS =
        "\2\5\1\13\2\uffff";
    static final String DFA1_acceptS =
        "\3\uffff\1\1\1\2";
    static final String DFA1_specialS =
        "\5\uffff}>";
    static final String[] DFA1_transitionS = {
            "\1\2\1\1",
            "\1\2\1\1",
            "\2\4\4\uffff\2\3",
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
            return "16:1: request : ( query | update );";
        }
    }
 

    public static final BitSet FOLLOW_query_in_request41 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_update_in_request45 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_location_in_query57 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_DELIMITER_in_query60 = new BitSet(new long[]{0x0000000000000C00L});
    public static final BitSet FOLLOW_fueltype_in_query62 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_location_in_update76 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DELIMITER_in_update78 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_petrolstation_in_update80 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DELIMITER_in_update83 = new BitSet(new long[]{0x0000000000000C00L});
    public static final BitSet FOLLOW_fueltype_in_update85 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DELIMITER_in_update89 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_price_in_update91 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_location103 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_set_in_fueltype116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_petrolstation133 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_NUMBER_in_price145 = new BitSet(new long[]{0x0000000000000002L});

}