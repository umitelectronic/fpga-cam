// $ANTLR 3.4 /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g 2012-02-03 17:57:03

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class Systemc_basicLexer extends Lexer {
    public static final int EOF=-1;
    public static final int T__19=19;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__50=50;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__59=59;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__66=66;
    public static final int T__67=67;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int T__73=73;
    public static final int T__74=74;
    public static final int T__75=75;
    public static final int T__76=76;
    public static final int T__77=77;
    public static final int BIN=4;
    public static final int COMMENT=5;
    public static final int EQUAL=6;
    public static final int FLOAT=7;
    public static final int GT=8;
    public static final int HEX=9;
    public static final int ID=10;
    public static final int INT=11;
    public static final int LT=12;
    public static final int NOT=13;
    public static final int OP=14;
    public static final int SEMICOLON=15;
    public static final int SINGLE_LINE_COMMENT=16;
    public static final int STRING_LITERAL=17;
    public static final int WS=18;

    // delegates
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public Systemc_basicLexer() {} 
    public Systemc_basicLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public Systemc_basicLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "/home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g"; }

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:2:7: ( '#define ' )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:2:9: '#define '
            {
            match("#define "); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:3:7: ( '#endif ' )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:3:9: '#endif '
            {
            match("#endif "); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:4:7: ( '#endif' )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:4:9: '#endif'
            {
            match("#endif"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:5:7: ( '#ifndef ' )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:5:9: '#ifndef '
            {
            match("#ifndef "); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:6:7: ( '#include' )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:6:9: '#include'
            {
            match("#include"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:7:7: ( '&&' )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:7:9: '&&'
            {
            match("&&"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:8:7: ( '(' )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:8:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:9:7: ( ')' )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:9:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:10:7: ( '*' )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:10:9: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:11:7: ( ',' )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:11:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:12:7: ( '.' )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:12:9: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:13:7: ( '.write(' )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:13:9: '.write('
            {
            match(".write("); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:14:7: ( ':' )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:14:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:15:7: ( '::' )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:15:9: '::'
            {
            match("::"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:16:7: ( '<<' )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:16:9: '<<'
            {
            match("<<"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:17:7: ( 'SC_CTOR' )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:17:9: 'SC_CTOR'
            {
            match("SC_CTOR"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:18:7: ( 'SC_METHOD(' )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:18:9: 'SC_METHOD('
            {
            match("SC_METHOD("); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:19:7: ( 'SC_MODULE' )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:19:9: 'SC_MODULE'
            {
            match("SC_MODULE"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__36"

    // $ANTLR start "T__37"
    public final void mT__37() throws RecognitionException {
        try {
            int _type = T__37;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:20:7: ( '[' )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:20:9: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__37"

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:21:7: ( '[]' )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:21:9: '[]'
            {
            match("[]"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:22:7: ( ']' )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:22:9: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__39"

    // $ANTLR start "T__40"
    public final void mT__40() throws RecognitionException {
        try {
            int _type = T__40;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:23:7: ( '_rv' )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:23:9: '_rv'
            {
            match("_rv"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__40"

    // $ANTLR start "T__41"
    public final void mT__41() throws RecognitionException {
        try {
            int _type = T__41;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:24:7: ( 'bool' )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:24:9: 'bool'
            {
            match("bool"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__41"

    // $ANTLR start "T__42"
    public final void mT__42() throws RecognitionException {
        try {
            int _type = T__42;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:25:7: ( 'break' )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:25:9: 'break'
            {
            match("break"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__42"

    // $ANTLR start "T__43"
    public final void mT__43() throws RecognitionException {
        try {
            int _type = T__43;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:26:7: ( 'case' )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:26:9: 'case'
            {
            match("case"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__43"

    // $ANTLR start "T__44"
    public final void mT__44() throws RecognitionException {
        try {
            int _type = T__44;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:27:7: ( 'char' )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:27:9: 'char'
            {
            match("char"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__44"

    // $ANTLR start "T__45"
    public final void mT__45() throws RecognitionException {
        try {
            int _type = T__45;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:28:7: ( 'concat(' )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:28:9: 'concat('
            {
            match("concat("); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__45"

    // $ANTLR start "T__46"
    public final void mT__46() throws RecognitionException {
        try {
            int _type = T__46;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:29:7: ( 'default' )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:29:9: 'default'
            {
            match("default"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__46"

    // $ANTLR start "T__47"
    public final void mT__47() throws RecognitionException {
        try {
            int _type = T__47;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:30:7: ( 'else' )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:30:9: 'else'
            {
            match("else"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__47"

    // $ANTLR start "T__48"
    public final void mT__48() throws RecognitionException {
        try {
            int _type = T__48;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:31:7: ( 'enum' )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:31:9: 'enum'
            {
            match("enum"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__48"

    // $ANTLR start "T__49"
    public final void mT__49() throws RecognitionException {
        try {
            int _type = T__49;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:32:7: ( 'float' )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:32:9: 'float'
            {
            match("float"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__49"

    // $ANTLR start "T__50"
    public final void mT__50() throws RecognitionException {
        try {
            int _type = T__50;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:33:7: ( 'if' )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:33:9: 'if'
            {
            match("if"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__50"

    // $ANTLR start "T__51"
    public final void mT__51() throws RecognitionException {
        try {
            int _type = T__51;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:34:7: ( 'int' )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:34:9: 'int'
            {
            match("int"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__51"

    // $ANTLR start "T__52"
    public final void mT__52() throws RecognitionException {
        try {
            int _type = T__52;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:35:7: ( 'long' )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:35:9: 'long'
            {
            match("long"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__52"

    // $ANTLR start "T__53"
    public final void mT__53() throws RecognitionException {
        try {
            int _type = T__53;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:36:7: ( 'range(' )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:36:9: 'range('
            {
            match("range("); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__53"

    // $ANTLR start "T__54"
    public final void mT__54() throws RecognitionException {
        try {
            int _type = T__54;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:37:7: ( 'read()' )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:37:9: 'read()'
            {
            match("read()"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__54"

    // $ANTLR start "T__55"
    public final void mT__55() throws RecognitionException {
        try {
            int _type = T__55;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:38:7: ( 'sc_in' )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:38:9: 'sc_in'
            {
            match("sc_in"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__55"

    // $ANTLR start "T__56"
    public final void mT__56() throws RecognitionException {
        try {
            int _type = T__56;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:39:7: ( 'sc_in_clk' )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:39:9: 'sc_in_clk'
            {
            match("sc_in_clk"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__56"

    // $ANTLR start "T__57"
    public final void mT__57() throws RecognitionException {
        try {
            int _type = T__57;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:40:7: ( 'sc_in_resolved' )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:40:9: 'sc_in_resolved'
            {
            match("sc_in_resolved"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__57"

    // $ANTLR start "T__58"
    public final void mT__58() throws RecognitionException {
        try {
            int _type = T__58;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:41:7: ( 'sc_in_rv' )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:41:9: 'sc_in_rv'
            {
            match("sc_in_rv"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__58"

    // $ANTLR start "T__59"
    public final void mT__59() throws RecognitionException {
        try {
            int _type = T__59;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:42:7: ( 'sc_inout' )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:42:9: 'sc_inout'
            {
            match("sc_inout"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__59"

    // $ANTLR start "T__60"
    public final void mT__60() throws RecognitionException {
        try {
            int _type = T__60;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:43:7: ( 'sc_inout_resolved' )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:43:9: 'sc_inout_resolved'
            {
            match("sc_inout_resolved"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__60"

    // $ANTLR start "T__61"
    public final void mT__61() throws RecognitionException {
        try {
            int _type = T__61;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:44:7: ( 'sc_inout_rv' )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:44:9: 'sc_inout_rv'
            {
            match("sc_inout_rv"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__61"

    // $ANTLR start "T__62"
    public final void mT__62() throws RecognitionException {
        try {
            int _type = T__62;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:45:7: ( 'sc_logic' )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:45:9: 'sc_logic'
            {
            match("sc_logic"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__62"

    // $ANTLR start "T__63"
    public final void mT__63() throws RecognitionException {
        try {
            int _type = T__63;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:46:7: ( 'sc_lv' )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:46:9: 'sc_lv'
            {
            match("sc_lv"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__63"

    // $ANTLR start "T__64"
    public final void mT__64() throws RecognitionException {
        try {
            int _type = T__64;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:47:7: ( 'sc_out' )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:47:9: 'sc_out'
            {
            match("sc_out"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__64"

    // $ANTLR start "T__65"
    public final void mT__65() throws RecognitionException {
        try {
            int _type = T__65;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:48:7: ( 'sc_out_resolved' )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:48:9: 'sc_out_resolved'
            {
            match("sc_out_resolved"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__65"

    // $ANTLR start "T__66"
    public final void mT__66() throws RecognitionException {
        try {
            int _type = T__66;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:49:7: ( 'sc_out_rv' )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:49:9: 'sc_out_rv'
            {
            match("sc_out_rv"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__66"

    // $ANTLR start "T__67"
    public final void mT__67() throws RecognitionException {
        try {
            int _type = T__67;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:50:7: ( 'sc_signal' )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:50:9: 'sc_signal'
            {
            match("sc_signal"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__67"

    // $ANTLR start "T__68"
    public final void mT__68() throws RecognitionException {
        try {
            int _type = T__68;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:51:7: ( 'sc_uint' )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:51:9: 'sc_uint'
            {
            match("sc_uint"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__68"

    // $ANTLR start "T__69"
    public final void mT__69() throws RecognitionException {
        try {
            int _type = T__69;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:52:7: ( 'sensitive' )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:52:9: 'sensitive'
            {
            match("sensitive"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__69"

    // $ANTLR start "T__70"
    public final void mT__70() throws RecognitionException {
        try {
            int _type = T__70;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:53:7: ( 'short' )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:53:9: 'short'
            {
            match("short"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__70"

    // $ANTLR start "T__71"
    public final void mT__71() throws RecognitionException {
        try {
            int _type = T__71;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:54:7: ( 'struct' )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:54:9: 'struct'
            {
            match("struct"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__71"

    // $ANTLR start "T__72"
    public final void mT__72() throws RecognitionException {
        try {
            int _type = T__72;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:55:7: ( 'switch' )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:55:9: 'switch'
            {
            match("switch"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__72"

    // $ANTLR start "T__73"
    public final void mT__73() throws RecognitionException {
        try {
            int _type = T__73;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:56:7: ( 'unsigned' )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:56:9: 'unsigned'
            {
            match("unsigned"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__73"

    // $ANTLR start "T__74"
    public final void mT__74() throws RecognitionException {
        try {
            int _type = T__74;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:57:7: ( 'void' )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:57:9: 'void'
            {
            match("void"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__74"

    // $ANTLR start "T__75"
    public final void mT__75() throws RecognitionException {
        try {
            int _type = T__75;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:58:7: ( '{' )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:58:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__75"

    // $ANTLR start "T__76"
    public final void mT__76() throws RecognitionException {
        try {
            int _type = T__76;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:59:7: ( '||' )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:59:9: '||'
            {
            match("||"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__76"

    // $ANTLR start "T__77"
    public final void mT__77() throws RecognitionException {
        try {
            int _type = T__77;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:60:7: ( '}' )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:60:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__77"

    // $ANTLR start "ID"
    public final void mID() throws RecognitionException {
        try {
            int _type = ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:477:5: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:477:9: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:477:33: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0 >= '0' && LA1_0 <= '9')||(LA1_0 >= 'A' && LA1_0 <= 'Z')||LA1_0=='_'||(LA1_0 >= 'a' && LA1_0 <= 'z')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ID"

    // $ANTLR start "INT"
    public final void mINT() throws RecognitionException {
        try {
            int _type = INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:480:5: ( ( '0' .. '9' )+ )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:480:7: ( '0' .. '9' )+
            {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:480:7: ( '0' .. '9' )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0 >= '0' && LA2_0 <= '9')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


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

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "INT"

    // $ANTLR start "FLOAT"
    public final void mFLOAT() throws RecognitionException {
        try {
            int _type = FLOAT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:482:7: ( ( INT )+ ( '.' ) ( INT )+ )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:482:9: ( INT )+ ( '.' ) ( INT )+
            {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:482:9: ( INT )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0 >= '0' && LA3_0 <= '9')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:482:9: INT
            	    {
            	    mINT(); 


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


            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:482:13: ( '.' )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:482:14: '.'
            {
            match('.'); 

            }


            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:482:18: ( INT )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0 >= '0' && LA4_0 <= '9')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:482:18: INT
            	    {
            	    mINT(); 


            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FLOAT"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:485:5: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:485:9: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:485:9: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0 >= '\t' && LA5_0 <= '\n')||LA5_0=='\r'||LA5_0==' ') ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:
            	    {
            	    if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


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


            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WS"

    // $ANTLR start "STRING_LITERAL"
    public final void mSTRING_LITERAL() throws RecognitionException {
        try {
            int _type = STRING_LITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:488:16: ( '\"' (~ ( '\\\\' | '\"' ) )* '\"' )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:488:20: '\"' (~ ( '\\\\' | '\"' ) )* '\"'
            {
            match('\"'); 

            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:488:24: (~ ( '\\\\' | '\"' ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0 >= '\u0000' && LA6_0 <= '!')||(LA6_0 >= '#' && LA6_0 <= '[')||(LA6_0 >= ']' && LA6_0 <= '\uFFFF')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STRING_LITERAL"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:492:2: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:492:4: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 



            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:492:9: ( options {greedy=false; } : . )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0=='*') ) {
                    int LA7_1 = input.LA(2);

                    if ( (LA7_1=='/') ) {
                        alt7=2;
                    }
                    else if ( ((LA7_1 >= '\u0000' && LA7_1 <= '.')||(LA7_1 >= '0' && LA7_1 <= '\uFFFF')) ) {
                        alt7=1;
                    }


                }
                else if ( ((LA7_0 >= '\u0000' && LA7_0 <= ')')||(LA7_0 >= '+' && LA7_0 <= '\uFFFF')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:492:36: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);


            match("*/"); 



            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COMMENT"

    // $ANTLR start "SINGLE_LINE_COMMENT"
    public final void mSINGLE_LINE_COMMENT() throws RecognitionException {
        try {
            int _type = SINGLE_LINE_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:497:2: ( '//' (~ ( '\\n' | '\\r' ) )* )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:498:3: '//' (~ ( '\\n' | '\\r' ) )*
            {
            match("//"); 



            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:498:8: (~ ( '\\n' | '\\r' ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0 >= '\u0000' && LA8_0 <= '\t')||(LA8_0 >= '\u000B' && LA8_0 <= '\f')||(LA8_0 >= '\u000E' && LA8_0 <= '\uFFFF')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '\uFFFF') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


             _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SINGLE_LINE_COMMENT"

    // $ANTLR start "HEX"
    public final void mHEX() throws RecognitionException {
        try {
            int _type = HEX;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:501:5: ( '0x' ( ( '0' .. '9' ) | 'a' .. 'f' | 'A..F' )+ )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:502:2: '0x' ( ( '0' .. '9' ) | 'a' .. 'f' | 'A..F' )+
            {
            match("0x"); 



            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:502:6: ( ( '0' .. '9' ) | 'a' .. 'f' | 'A..F' )+
            int cnt9=0;
            loop9:
            do {
                int alt9=4;
                switch ( input.LA(1) ) {
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    {
                    alt9=1;
                    }
                    break;
                case 'a':
                case 'b':
                case 'c':
                case 'd':
                case 'e':
                case 'f':
                    {
                    alt9=2;
                    }
                    break;
                case 'A':
                    {
                    alt9=3;
                    }
                    break;

                }

                switch (alt9) {
            	case 1 :
            	    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:502:7: ( '0' .. '9' )
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;
            	case 2 :
            	    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:502:18: 'a' .. 'f'
            	    {
            	    matchRange('a','f'); 

            	    }
            	    break;
            	case 3 :
            	    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:502:28: 'A..F'
            	    {
            	    match("A..F"); 



            	    }
            	    break;

            	default :
            	    if ( cnt9 >= 1 ) break loop9;
                        EarlyExitException eee =
                            new EarlyExitException(9, input);
                        throw eee;
                }
                cnt9++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "HEX"

    // $ANTLR start "BIN"
    public final void mBIN() throws RecognitionException {
        try {
            int _type = BIN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:505:5: ( '0b' ( '0' | '1' )+ )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:506:2: '0b' ( '0' | '1' )+
            {
            match("0b"); 



            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:506:6: ( '0' | '1' )+
            int cnt10=0;
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0 >= '0' && LA10_0 <= '1')) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '1') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt10 >= 1 ) break loop10;
                        EarlyExitException eee =
                            new EarlyExitException(10, input);
                        throw eee;
                }
                cnt10++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "BIN"

    // $ANTLR start "OP"
    public final void mOP() throws RecognitionException {
        try {
            int _type = OP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:508:4: ( ( '+' | '-' | '*' | '/ ' | '%' ) )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:509:2: ( '+' | '-' | '*' | '/ ' | '%' )
            {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:509:2: ( '+' | '-' | '*' | '/ ' | '%' )
            int alt11=5;
            switch ( input.LA(1) ) {
            case '+':
                {
                alt11=1;
                }
                break;
            case '-':
                {
                alt11=2;
                }
                break;
            case '*':
                {
                alt11=3;
                }
                break;
            case '/':
                {
                alt11=4;
                }
                break;
            case '%':
                {
                alt11=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;

            }

            switch (alt11) {
                case 1 :
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:509:3: '+'
                    {
                    match('+'); 

                    }
                    break;
                case 2 :
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:509:9: '-'
                    {
                    match('-'); 

                    }
                    break;
                case 3 :
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:509:15: '*'
                    {
                    match('*'); 

                    }
                    break;
                case 4 :
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:509:21: '/ '
                    {
                    match("/ "); 



                    }
                    break;
                case 5 :
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:509:27: '%'
                    {
                    match('%'); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "OP"

    // $ANTLR start "GT"
    public final void mGT() throws RecognitionException {
        try {
            int _type = GT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:512:4: ( '>' )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:512:5: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "GT"

    // $ANTLR start "LT"
    public final void mLT() throws RecognitionException {
        try {
            int _type = LT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:515:4: ( '<' )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:515:5: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LT"

    // $ANTLR start "EQUAL"
    public final void mEQUAL() throws RecognitionException {
        try {
            int _type = EQUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:518:7: ( '=' )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:518:8: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "EQUAL"

    // $ANTLR start "SEMICOLON"
    public final void mSEMICOLON() throws RecognitionException {
        try {
            int _type = SEMICOLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:520:11: ( ';' )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:520:12: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SEMICOLON"

    // $ANTLR start "NOT"
    public final void mNOT() throws RecognitionException {
        try {
            int _type = NOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:522:5: ( '!' )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:522:6: '!'
            {
            match('!'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NOT"

    public void mTokens() throws RecognitionException {
        // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:1:8: ( T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | ID | INT | FLOAT | WS | STRING_LITERAL | COMMENT | SINGLE_LINE_COMMENT | HEX | BIN | OP | GT | LT | EQUAL | SEMICOLON | NOT )
        int alt12=74;
        alt12 = dfa12.predict(input);
        switch (alt12) {
            case 1 :
                // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:1:10: T__19
                {
                mT__19(); 


                }
                break;
            case 2 :
                // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:1:16: T__20
                {
                mT__20(); 


                }
                break;
            case 3 :
                // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:1:22: T__21
                {
                mT__21(); 


                }
                break;
            case 4 :
                // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:1:28: T__22
                {
                mT__22(); 


                }
                break;
            case 5 :
                // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:1:34: T__23
                {
                mT__23(); 


                }
                break;
            case 6 :
                // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:1:40: T__24
                {
                mT__24(); 


                }
                break;
            case 7 :
                // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:1:46: T__25
                {
                mT__25(); 


                }
                break;
            case 8 :
                // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:1:52: T__26
                {
                mT__26(); 


                }
                break;
            case 9 :
                // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:1:58: T__27
                {
                mT__27(); 


                }
                break;
            case 10 :
                // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:1:64: T__28
                {
                mT__28(); 


                }
                break;
            case 11 :
                // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:1:70: T__29
                {
                mT__29(); 


                }
                break;
            case 12 :
                // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:1:76: T__30
                {
                mT__30(); 


                }
                break;
            case 13 :
                // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:1:82: T__31
                {
                mT__31(); 


                }
                break;
            case 14 :
                // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:1:88: T__32
                {
                mT__32(); 


                }
                break;
            case 15 :
                // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:1:94: T__33
                {
                mT__33(); 


                }
                break;
            case 16 :
                // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:1:100: T__34
                {
                mT__34(); 


                }
                break;
            case 17 :
                // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:1:106: T__35
                {
                mT__35(); 


                }
                break;
            case 18 :
                // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:1:112: T__36
                {
                mT__36(); 


                }
                break;
            case 19 :
                // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:1:118: T__37
                {
                mT__37(); 


                }
                break;
            case 20 :
                // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:1:124: T__38
                {
                mT__38(); 


                }
                break;
            case 21 :
                // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:1:130: T__39
                {
                mT__39(); 


                }
                break;
            case 22 :
                // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:1:136: T__40
                {
                mT__40(); 


                }
                break;
            case 23 :
                // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:1:142: T__41
                {
                mT__41(); 


                }
                break;
            case 24 :
                // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:1:148: T__42
                {
                mT__42(); 


                }
                break;
            case 25 :
                // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:1:154: T__43
                {
                mT__43(); 


                }
                break;
            case 26 :
                // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:1:160: T__44
                {
                mT__44(); 


                }
                break;
            case 27 :
                // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:1:166: T__45
                {
                mT__45(); 


                }
                break;
            case 28 :
                // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:1:172: T__46
                {
                mT__46(); 


                }
                break;
            case 29 :
                // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:1:178: T__47
                {
                mT__47(); 


                }
                break;
            case 30 :
                // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:1:184: T__48
                {
                mT__48(); 


                }
                break;
            case 31 :
                // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:1:190: T__49
                {
                mT__49(); 


                }
                break;
            case 32 :
                // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:1:196: T__50
                {
                mT__50(); 


                }
                break;
            case 33 :
                // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:1:202: T__51
                {
                mT__51(); 


                }
                break;
            case 34 :
                // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:1:208: T__52
                {
                mT__52(); 


                }
                break;
            case 35 :
                // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:1:214: T__53
                {
                mT__53(); 


                }
                break;
            case 36 :
                // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:1:220: T__54
                {
                mT__54(); 


                }
                break;
            case 37 :
                // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:1:226: T__55
                {
                mT__55(); 


                }
                break;
            case 38 :
                // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:1:232: T__56
                {
                mT__56(); 


                }
                break;
            case 39 :
                // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:1:238: T__57
                {
                mT__57(); 


                }
                break;
            case 40 :
                // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:1:244: T__58
                {
                mT__58(); 


                }
                break;
            case 41 :
                // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:1:250: T__59
                {
                mT__59(); 


                }
                break;
            case 42 :
                // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:1:256: T__60
                {
                mT__60(); 


                }
                break;
            case 43 :
                // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:1:262: T__61
                {
                mT__61(); 


                }
                break;
            case 44 :
                // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:1:268: T__62
                {
                mT__62(); 


                }
                break;
            case 45 :
                // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:1:274: T__63
                {
                mT__63(); 


                }
                break;
            case 46 :
                // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:1:280: T__64
                {
                mT__64(); 


                }
                break;
            case 47 :
                // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:1:286: T__65
                {
                mT__65(); 


                }
                break;
            case 48 :
                // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:1:292: T__66
                {
                mT__66(); 


                }
                break;
            case 49 :
                // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:1:298: T__67
                {
                mT__67(); 


                }
                break;
            case 50 :
                // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:1:304: T__68
                {
                mT__68(); 


                }
                break;
            case 51 :
                // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:1:310: T__69
                {
                mT__69(); 


                }
                break;
            case 52 :
                // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:1:316: T__70
                {
                mT__70(); 


                }
                break;
            case 53 :
                // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:1:322: T__71
                {
                mT__71(); 


                }
                break;
            case 54 :
                // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:1:328: T__72
                {
                mT__72(); 


                }
                break;
            case 55 :
                // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:1:334: T__73
                {
                mT__73(); 


                }
                break;
            case 56 :
                // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:1:340: T__74
                {
                mT__74(); 


                }
                break;
            case 57 :
                // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:1:346: T__75
                {
                mT__75(); 


                }
                break;
            case 58 :
                // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:1:352: T__76
                {
                mT__76(); 


                }
                break;
            case 59 :
                // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:1:358: T__77
                {
                mT__77(); 


                }
                break;
            case 60 :
                // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:1:364: ID
                {
                mID(); 


                }
                break;
            case 61 :
                // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:1:367: INT
                {
                mINT(); 


                }
                break;
            case 62 :
                // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:1:371: FLOAT
                {
                mFLOAT(); 


                }
                break;
            case 63 :
                // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:1:377: WS
                {
                mWS(); 


                }
                break;
            case 64 :
                // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:1:380: STRING_LITERAL
                {
                mSTRING_LITERAL(); 


                }
                break;
            case 65 :
                // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:1:395: COMMENT
                {
                mCOMMENT(); 


                }
                break;
            case 66 :
                // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:1:403: SINGLE_LINE_COMMENT
                {
                mSINGLE_LINE_COMMENT(); 


                }
                break;
            case 67 :
                // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:1:423: HEX
                {
                mHEX(); 


                }
                break;
            case 68 :
                // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:1:427: BIN
                {
                mBIN(); 


                }
                break;
            case 69 :
                // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:1:431: OP
                {
                mOP(); 


                }
                break;
            case 70 :
                // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:1:434: GT
                {
                mGT(); 


                }
                break;
            case 71 :
                // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:1:437: LT
                {
                mLT(); 


                }
                break;
            case 72 :
                // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:1:440: EQUAL
                {
                mEQUAL(); 


                }
                break;
            case 73 :
                // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:1:446: SEMICOLON
                {
                mSEMICOLON(); 


                }
                break;
            case 74 :
                // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:1:456: NOT
                {
                mNOT(); 


                }
                break;

        }

    }


    protected DFA12 dfa12 = new DFA12(this);
    static final String DFA12_eotS =
        "\7\uffff\1\54\1\56\1\60\1\34\1\63\1\uffff\14\34\4\uffff\1\114\3"+
        "\uffff\1\114\17\uffff\1\34\2\uffff\12\34\1\136\13\34\11\uffff\1"+
        "\34\1\155\11\34\1\uffff\1\167\12\34\1\uffff\2\34\1\uffff\1\u008a"+
        "\1\34\1\u008c\1\u008d\2\34\1\u0090\1\u0091\1\34\1\uffff\1\u0093"+
        "\14\34\1\u00a1\1\uffff\3\34\1\uffff\1\u00a6\2\uffff\2\34\2\uffff"+
        "\1\u00a9\1\uffff\1\34\1\uffff\1\u00ad\1\34\1\u00af\4\34\1\u00b4"+
        "\3\34\1\uffff\1\u00b9\3\34\1\uffff\2\34\2\uffff\2\34\1\uffff\1\34"+
        "\1\uffff\1\u00c4\3\34\1\uffff\1\u00c8\1\u00c9\1\34\2\uffff\1\u00cb"+
        "\2\34\1\uffff\1\u00ce\5\34\1\uffff\1\34\1\u00d6\1\34\2\uffff\1\34"+
        "\1\uffff\2\34\1\uffff\2\34\1\u00dd\1\u00df\1\u00e0\2\34\1\uffff"+
        "\1\34\1\u00e5\1\34\1\u00e7\1\u00e8\1\34\1\uffff\1\34\2\uffff\1\34"+
        "\1\u00ec\1\u00ed\1\u00ee\4\uffff\3\34\3\uffff\2\34\1\u00f5\3\34"+
        "\1\uffff\4\34\1\u00fd\2\34\1\uffff\1\34\1\u0101\1\34\1\uffff\1\u0103"+
        "\1\uffff";
    static final String DFA12_eofS =
        "\u0104\uffff";
    static final String DFA12_minS =
        "\1\11\1\144\5\uffff\1\167\1\72\1\74\1\103\1\135\1\uffff\1\162\1"+
        "\157\1\141\1\145\2\154\1\146\1\157\1\141\1\143\1\156\1\157\4\uffff"+
        "\1\56\2\uffff\1\40\1\56\6\uffff\1\156\1\146\7\uffff\1\137\2\uffff"+
        "\1\166\1\157\1\145\1\163\1\141\1\156\1\146\1\163\1\165\1\157\1\60"+
        "\1\164\2\156\1\141\1\137\1\156\1\157\1\162\1\151\1\163\1\151\6\uffff"+
        "\1\144\2\uffff\1\103\1\60\1\154\1\141\1\145\1\162\1\143\1\141\1"+
        "\145\1\155\1\141\1\uffff\1\60\2\147\1\144\1\151\1\163\1\162\1\165"+
        "\1\164\1\151\1\144\1\151\1\124\1\105\1\uffff\1\60\1\153\2\60\1\141"+
        "\1\165\2\60\1\164\1\uffff\1\60\1\145\1\50\1\156\1\157\1\165\3\151"+
        "\1\164\2\143\1\147\1\60\1\146\1\117\1\124\1\104\1\uffff\1\60\2\uffff"+
        "\1\164\1\154\2\uffff\1\60\1\uffff\1\50\1\uffff\1\60\1\147\1\60\1"+
        "\164\1\147\1\156\1\164\1\60\1\164\1\150\1\156\1\uffff\1\40\1\122"+
        "\1\110\1\125\1\uffff\1\50\1\164\2\uffff\1\143\1\165\1\uffff\1\151"+
        "\1\uffff\1\60\1\156\1\164\1\151\1\uffff\2\60\1\145\2\uffff\1\60"+
        "\1\117\1\114\1\uffff\1\60\1\154\1\145\1\164\1\143\1\162\1\uffff"+
        "\1\141\1\60\1\166\2\uffff\1\144\1\uffff\1\104\1\105\1\uffff\1\153"+
        "\1\163\3\60\1\145\1\154\1\uffff\1\145\1\60\1\50\2\60\1\157\1\uffff"+
        "\1\162\2\uffff\1\163\3\60\4\uffff\1\154\1\145\1\157\3\uffff\1\166"+
        "\1\163\1\60\1\154\1\145\1\157\1\uffff\1\166\1\144\1\154\1\145\1"+
        "\60\1\166\1\144\1\uffff\1\145\1\60\1\144\1\uffff\1\60\1\uffff";
    static final String DFA12_maxS =
        "\1\175\1\151\5\uffff\1\167\1\72\1\74\1\103\1\135\1\uffff\2\162\1"+
        "\157\1\145\1\156\1\154\1\156\1\157\1\145\1\167\1\156\1\157\4\uffff"+
        "\1\170\2\uffff\1\57\1\71\6\uffff\2\156\7\uffff\1\137\2\uffff\1\166"+
        "\1\157\1\145\1\163\1\141\1\156\1\146\1\163\1\165\1\157\1\172\1\164"+
        "\2\156\1\141\1\137\1\156\1\157\1\162\1\151\1\163\1\151\6\uffff\1"+
        "\144\2\uffff\1\115\1\172\1\154\1\141\1\145\1\162\1\143\1\141\1\145"+
        "\1\155\1\141\1\uffff\1\172\2\147\1\144\1\165\1\163\1\162\1\165\1"+
        "\164\1\151\1\144\1\151\1\124\1\117\1\uffff\1\172\1\153\2\172\1\141"+
        "\1\165\2\172\1\164\1\uffff\1\172\1\145\1\50\1\156\1\166\1\165\3"+
        "\151\1\164\2\143\1\147\1\172\1\146\1\117\1\124\1\104\1\uffff\1\172"+
        "\2\uffff\1\164\1\154\2\uffff\1\172\1\uffff\1\50\1\uffff\1\172\1"+
        "\147\1\172\1\164\1\147\1\156\1\164\1\172\1\164\1\150\1\156\1\uffff"+
        "\1\40\1\122\1\110\1\125\1\uffff\1\50\1\164\2\uffff\1\162\1\165\1"+
        "\uffff\1\151\1\uffff\1\172\1\156\1\164\1\151\1\uffff\2\172\1\145"+
        "\2\uffff\1\172\1\117\1\114\1\uffff\1\172\1\154\1\166\1\164\1\143"+
        "\1\162\1\uffff\1\141\1\172\1\166\2\uffff\1\144\1\uffff\1\104\1\105"+
        "\1\uffff\1\153\1\163\3\172\1\166\1\154\1\uffff\1\145\1\172\1\50"+
        "\2\172\1\157\1\uffff\1\162\2\uffff\1\163\3\172\4\uffff\1\154\1\166"+
        "\1\157\3\uffff\1\166\1\163\1\172\1\154\1\145\1\157\1\uffff\1\166"+
        "\1\144\1\154\1\145\1\172\1\166\1\144\1\uffff\1\145\1\172\1\144\1"+
        "\uffff\1\172\1\uffff";
    static final String DFA12_acceptS =
        "\2\uffff\1\6\1\7\1\10\1\11\1\12\5\uffff\1\25\14\uffff\1\71\1\72"+
        "\1\73\1\74\1\uffff\1\77\1\100\2\uffff\1\105\1\106\1\110\1\111\1"+
        "\112\1\1\2\uffff\1\11\1\14\1\13\1\16\1\15\1\17\1\107\1\uffff\1\24"+
        "\1\23\26\uffff\1\103\1\104\1\75\1\76\1\101\1\102\1\uffff\1\4\1\5"+
        "\13\uffff\1\40\16\uffff\1\26\11\uffff\1\41\22\uffff\1\27\1\uffff"+
        "\1\31\1\32\2\uffff\1\35\1\36\1\uffff\1\42\1\uffff\1\44\13\uffff"+
        "\1\70\4\uffff\1\30\2\uffff\1\37\1\43\2\uffff\1\45\1\uffff\1\55\4"+
        "\uffff\1\64\3\uffff\1\2\1\3\3\uffff\1\33\6\uffff\1\56\3\uffff\1"+
        "\65\1\66\1\uffff\1\20\2\uffff\1\34\7\uffff\1\62\6\uffff\1\50\1\uffff"+
        "\1\51\1\54\4\uffff\1\67\1\21\1\22\1\46\3\uffff\1\60\1\61\1\63\6"+
        "\uffff\1\53\7\uffff\1\47\3\uffff\1\57\1\uffff\1\52";
    static final String DFA12_specialS =
        "\u0104\uffff}>";
    static final String[] DFA12_transitionS = {
            "\2\36\2\uffff\1\36\22\uffff\1\36\1\46\1\37\1\1\1\uffff\1\42"+
            "\1\2\1\uffff\1\3\1\4\1\5\1\42\1\6\1\42\1\7\1\40\1\35\11\41\1"+
            "\10\1\45\1\11\1\44\1\43\2\uffff\22\34\1\12\7\34\1\13\1\uffff"+
            "\1\14\1\uffff\1\15\1\uffff\1\34\1\16\1\17\1\20\1\21\1\22\2\34"+
            "\1\23\2\34\1\24\5\34\1\25\1\26\1\34\1\27\1\30\4\34\1\31\1\32"+
            "\1\33",
            "\1\47\1\50\3\uffff\1\51",
            "",
            "",
            "",
            "",
            "",
            "\1\53",
            "\1\55",
            "\1\57",
            "\1\61",
            "\1\62",
            "",
            "\1\64",
            "\1\65\2\uffff\1\66",
            "\1\67\6\uffff\1\70\6\uffff\1\71",
            "\1\72",
            "\1\73\1\uffff\1\74",
            "\1\75",
            "\1\76\7\uffff\1\77",
            "\1\100",
            "\1\101\3\uffff\1\102",
            "\1\103\1\uffff\1\104\2\uffff\1\105\13\uffff\1\106\2\uffff\1"+
            "\107",
            "\1\110",
            "\1\111",
            "",
            "",
            "",
            "",
            "\1\115\1\uffff\12\41\50\uffff\1\113\25\uffff\1\112",
            "",
            "",
            "\1\42\11\uffff\1\116\4\uffff\1\117",
            "\1\115\1\uffff\12\41",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\120",
            "\1\121\7\uffff\1\122",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\123",
            "",
            "",
            "\1\124",
            "\1\125",
            "\1\126",
            "\1\127",
            "\1\130",
            "\1\131",
            "\1\132",
            "\1\133",
            "\1\134",
            "\1\135",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\137",
            "\1\140",
            "\1\141",
            "\1\142",
            "\1\143",
            "\1\144",
            "\1\145",
            "\1\146",
            "\1\147",
            "\1\150",
            "\1\151",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\152",
            "",
            "",
            "\1\153\11\uffff\1\154",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\156",
            "\1\157",
            "\1\160",
            "\1\161",
            "\1\162",
            "\1\163",
            "\1\164",
            "\1\165",
            "\1\166",
            "",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\170",
            "\1\171",
            "\1\172",
            "\1\173\2\uffff\1\174\2\uffff\1\175\3\uffff\1\176\1\uffff\1"+
            "\177",
            "\1\u0080",
            "\1\u0081",
            "\1\u0082",
            "\1\u0083",
            "\1\u0084",
            "\1\u0085",
            "\1\u0086",
            "\1\u0087",
            "\1\u0088\11\uffff\1\u0089",
            "",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\u008b",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\u008e",
            "\1\u008f",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\u0092",
            "",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\u0094",
            "\1\u0095",
            "\1\u0096",
            "\1\u0097\6\uffff\1\u0098",
            "\1\u0099",
            "\1\u009a",
            "\1\u009b",
            "\1\u009c",
            "\1\u009d",
            "\1\u009e",
            "\1\u009f",
            "\1\u00a0",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\u00a2",
            "\1\u00a3",
            "\1\u00a4",
            "\1\u00a5",
            "",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "",
            "",
            "\1\u00a7",
            "\1\u00a8",
            "",
            "",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "",
            "\1\u00aa",
            "",
            "\12\34\7\uffff\32\34\4\uffff\1\u00ab\1\uffff\16\34\1\u00ac"+
            "\13\34",
            "\1\u00ae",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\u00b0",
            "\1\u00b1",
            "\1\u00b2",
            "\1\u00b3",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\u00b5",
            "\1\u00b6",
            "\1\u00b7",
            "",
            "\1\u00b8",
            "\1\u00ba",
            "\1\u00bb",
            "\1\u00bc",
            "",
            "\1\u00bd",
            "\1\u00be",
            "",
            "",
            "\1\u00bf\16\uffff\1\u00c0",
            "\1\u00c1",
            "",
            "\1\u00c2",
            "",
            "\12\34\7\uffff\32\34\4\uffff\1\u00c3\1\uffff\32\34",
            "\1\u00c5",
            "\1\u00c6",
            "\1\u00c7",
            "",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\u00ca",
            "",
            "",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\u00cc",
            "\1\u00cd",
            "",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\u00cf",
            "\1\u00d0\20\uffff\1\u00d1",
            "\1\u00d2",
            "\1\u00d3",
            "\1\u00d4",
            "",
            "\1\u00d5",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\u00d7",
            "",
            "",
            "\1\u00d8",
            "",
            "\1\u00d9",
            "\1\u00da",
            "",
            "\1\u00db",
            "\1\u00dc",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\12\34\7\uffff\32\34\4\uffff\1\u00de\1\uffff\32\34",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\u00e1\20\uffff\1\u00e2",
            "\1\u00e3",
            "",
            "\1\u00e4",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\u00e6",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\u00e9",
            "",
            "\1\u00ea",
            "",
            "",
            "\1\u00eb",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "",
            "",
            "",
            "",
            "\1\u00ef",
            "\1\u00f0\20\uffff\1\u00f1",
            "\1\u00f2",
            "",
            "",
            "",
            "\1\u00f3",
            "\1\u00f4",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\u00f6",
            "\1\u00f7",
            "\1\u00f8",
            "",
            "\1\u00f9",
            "\1\u00fa",
            "\1\u00fb",
            "\1\u00fc",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\u00fe",
            "\1\u00ff",
            "",
            "\1\u0100",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\u0102",
            "",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            ""
    };

    static final short[] DFA12_eot = DFA.unpackEncodedString(DFA12_eotS);
    static final short[] DFA12_eof = DFA.unpackEncodedString(DFA12_eofS);
    static final char[] DFA12_min = DFA.unpackEncodedStringToUnsignedChars(DFA12_minS);
    static final char[] DFA12_max = DFA.unpackEncodedStringToUnsignedChars(DFA12_maxS);
    static final short[] DFA12_accept = DFA.unpackEncodedString(DFA12_acceptS);
    static final short[] DFA12_special = DFA.unpackEncodedString(DFA12_specialS);
    static final short[][] DFA12_transition;

    static {
        int numStates = DFA12_transitionS.length;
        DFA12_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA12_transition[i] = DFA.unpackEncodedString(DFA12_transitionS[i]);
        }
    }

    class DFA12 extends DFA {

        public DFA12(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 12;
            this.eot = DFA12_eot;
            this.eof = DFA12_eof;
            this.min = DFA12_min;
            this.max = DFA12_max;
            this.accept = DFA12_accept;
            this.special = DFA12_special;
            this.transition = DFA12_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | ID | INT | FLOAT | WS | STRING_LITERAL | COMMENT | SINGLE_LINE_COMMENT | HEX | BIN | OP | GT | LT | EQUAL | SEMICOLON | NOT );";
        }
    }
 

}