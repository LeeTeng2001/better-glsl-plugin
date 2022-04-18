/* The following code was generated by JFlex 1.7.0 tweaked for IntelliJ platform */

package glsl.language;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.TokenType;
import glsl.language.psi.GlslTypes;  // contain token we'll use


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.7.0
 * from the specification file <tt>glsl.flex</tt>
 */
class GlslLexer implements FlexLexer {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;
  public static final int WAITING_VALUE = 2;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0,  0,  1, 1
  };

  /** 
   * Translates characters to character classes
   * Chosen bits are [12, 6, 3]
   * Total runtime size is 17488 bytes
   */
  public static int ZZ_CMAP(int ch) {
    return ZZ_CMAP_A[(ZZ_CMAP_Y[(ZZ_CMAP_Z[ch>>9]<<6)|((ch>>3)&0x3f)]<<3)|(ch&0x7)];
  }

  /* The ZZ_CMAP_Z table has 2176 entries */
  static final char ZZ_CMAP_Z[] = zzUnpackCMap(
    "\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1"+
    "\20\5\21\1\22\1\23\1\24\1\21\14\25\1\26\50\25\1\27\2\25\1\30\1\31\1\32\1\33"+
    "\25\25\1\34\20\21\1\35\1\36\1\37\1\40\1\41\1\42\1\43\1\44\1\45\1\46\1\47\1"+
    "\21\1\50\1\51\1\52\1\53\1\54\1\55\1\56\1\21\1\25\1\57\1\60\5\21\2\25\1\61"+
    "\7\21\1\25\1\62\20\21\1\25\1\63\1\21\1\64\13\25\1\65\1\25\1\66\22\21\1\67"+
    "\1\70\4\21\1\71\11\21\1\72\1\73\1\74\1\75\1\21\1\76\2\21\1\77\3\21\1\100\2"+
    "\21\1\101\10\21\123\25\1\102\7\25\1\103\1\104\12\25\1\105\15\25\1\106\6\21"+
    "\1\25\1\107\u0582\21\1\110\u017f\21");

  /* The ZZ_CMAP_Y table has 4672 entries */
  static final char ZZ_CMAP_Y[] = zzUnpackCMap(
    "\1\0\1\1\1\0\1\2\1\3\1\4\1\5\1\6\1\7\2\10\1\11\1\12\1\13\1\14\1\15\1\16\3"+
    "\0\1\17\1\20\1\21\1\22\2\10\1\23\3\10\1\23\71\10\1\24\1\10\1\25\1\26\1\27"+
    "\1\30\2\26\16\0\1\31\1\32\1\33\1\34\2\10\1\35\11\10\1\36\21\10\1\37\1\40\24"+
    "\10\1\7\3\10\1\23\1\41\1\7\4\10\1\42\1\43\4\0\1\44\1\45\1\26\3\10\2\46\1\26"+
    "\1\47\1\50\1\0\1\51\5\10\1\52\2\0\1\5\1\53\1\54\13\10\1\55\1\44\1\56\1\57"+
    "\1\5\1\60\1\26\1\61\1\62\3\10\3\0\1\63\12\10\1\64\1\0\1\65\1\26\1\5\1\66\3"+
    "\10\1\52\1\67\1\22\2\10\1\64\1\70\1\71\1\72\2\26\3\10\1\73\1\10\1\46\6\26"+
    "\2\10\1\31\1\74\2\26\1\75\5\0\1\76\6\10\1\77\2\0\1\100\1\10\1\101\1\5\1\7"+
    "\1\10\1\102\1\103\1\104\2\10\1\105\1\106\1\107\1\110\1\111\1\61\1\112\1\101"+
    "\1\5\1\113\1\114\1\115\1\116\1\104\2\10\1\105\1\117\1\120\1\121\1\122\1\123"+
    "\1\124\1\125\1\5\1\126\1\26\1\115\1\36\1\35\2\10\1\105\1\127\1\107\1\44\1"+
    "\130\1\131\1\26\1\101\1\5\1\41\1\132\1\115\1\103\1\104\2\10\1\105\1\127\1"+
    "\107\1\110\1\122\1\133\1\112\1\101\1\5\1\41\1\26\1\134\1\135\1\136\1\137\1"+
    "\114\1\135\1\10\1\140\1\141\1\142\1\143\1\26\1\125\1\5\1\26\1\41\1\144\1\31"+
    "\1\105\2\10\1\105\1\10\1\145\1\146\1\142\1\147\1\46\1\101\1\5\2\26\1\102\1"+
    "\31\1\105\2\10\1\105\1\150\1\107\1\146\1\142\1\147\1\33\1\101\1\5\1\151\1"+
    "\26\1\144\1\31\1\105\4\10\1\152\1\146\1\153\1\154\1\42\1\101\1\5\1\26\1\40"+
    "\1\155\1\10\1\23\1\40\2\10\1\35\1\156\1\23\1\157\1\160\1\0\1\125\1\5\1\161"+
    "\1\26\1\7\5\10\1\162\1\163\1\164\1\165\1\5\1\166\4\26\1\167\1\170\1\171\1"+
    "\7\1\172\1\173\1\162\1\174\1\175\1\47\1\5\1\176\4\26\1\131\2\26\1\177\1\5"+
    "\1\166\1\200\1\201\1\10\1\7\3\10\1\27\1\43\1\0\1\146\1\202\1\0\1\43\3\0\1"+
    "\203\1\204\7\26\5\10\1\52\1\0\1\205\1\5\1\166\1\64\1\206\1\207\1\210\1\211"+
    "\1\10\1\212\1\213\1\5\1\214\4\10\1\36\1\21\5\10\1\215\51\10\1\136\1\23\1\136"+
    "\5\10\1\136\4\10\1\136\1\23\1\136\1\10\1\23\7\10\1\136\10\10\1\216\4\26\2"+
    "\10\2\26\12\10\2\74\1\7\114\10\1\103\2\10\1\7\2\10\1\46\11\10\1\135\1\10\1"+
    "\131\1\10\1\31\1\217\1\26\2\10\1\217\1\26\2\10\1\220\1\26\1\10\1\31\1\221"+
    "\1\26\6\10\1\222\3\0\1\223\1\224\1\5\1\166\3\26\1\225\1\5\1\166\13\10\1\26"+
    "\1\226\4\10\1\227\10\10\1\74\1\26\3\10\1\23\1\0\1\2\1\0\1\2\1\125\1\5\3\10"+
    "\1\74\1\27\1\26\5\10\1\113\3\10\1\25\1\5\1\166\4\26\2\10\1\164\1\2\6\10\1"+
    "\202\1\165\3\0\1\110\1\5\1\166\1\5\1\166\1\42\1\26\1\0\1\47\10\26\1\230\5"+
    "\10\1\222\1\0\1\230\1\113\1\5\1\166\1\26\1\231\1\2\1\26\1\232\3\10\1\100\1"+
    "\210\1\5\1\66\4\10\1\64\1\0\1\2\1\26\4\10\1\222\2\0\1\26\1\5\1\233\1\5\1\66"+
    "\3\10\1\74\1\10\1\131\10\26\1\234\2\0\1\235\1\236\1\177\30\10\7\0\1\237\42"+
    "\10\2\74\4\10\2\74\1\10\1\240\3\10\1\74\6\10\1\31\1\175\1\241\1\27\1\242\1"+
    "\113\1\10\1\27\1\241\1\27\1\26\1\231\3\26\1\243\1\26\1\42\1\131\1\26\1\244"+
    "\1\26\1\146\1\0\1\41\1\42\2\26\1\10\1\27\4\10\2\26\1\0\1\203\1\245\1\0\1\246"+
    "\1\26\1\247\1\40\1\156\1\250\1\30\1\251\1\10\1\252\1\253\1\254\2\26\5\10\1"+
    "\131\116\26\5\10\1\23\5\10\1\23\20\10\1\27\1\255\1\256\1\26\4\10\1\36\1\21"+
    "\7\10\1\42\1\26\1\61\2\10\1\23\1\26\10\23\4\0\5\26\1\42\72\26\1\253\3\26\1"+
    "\7\1\212\1\250\1\27\1\7\11\10\1\23\1\257\1\7\12\10\1\215\1\253\4\10\1\23\1"+
    "\7\12\10\1\23\2\26\3\10\1\46\6\26\170\10\1\74\11\26\75\10\1\46\2\26\21\10"+
    "\1\27\10\26\5\10\1\74\41\10\1\27\2\10\1\5\1\260\2\26\5\10\1\164\1\75\1\261"+
    "\3\10\1\64\12\10\1\177\3\26\1\42\1\10\1\40\14\10\1\104\3\10\1\23\1\10\7\26"+
    "\1\42\1\10\1\262\1\263\2\10\1\52\2\26\1\131\6\10\1\113\1\26\1\264\5\10\1\222"+
    "\1\0\1\47\1\26\1\5\1\166\2\0\1\264\1\265\1\5\1\66\2\10\1\64\1\47\2\10\1\164"+
    "\1\0\1\2\1\26\3\10\1\27\1\76\5\10\1\52\1\0\1\246\1\42\1\5\1\166\1\266\1\10"+
    "\1\5\1\267\5\10\1\100\1\165\1\26\1\263\1\270\1\5\1\166\2\10\1\23\1\271\6\10"+
    "\1\207\1\272\1\227\2\26\1\273\1\10\1\52\1\274\1\26\3\275\1\26\2\23\5\10\1"+
    "\215\1\74\1\26\16\10\1\52\1\276\1\5\1\166\64\10\1\113\1\26\2\10\1\23\1\277"+
    "\5\10\1\113\40\26\55\10\1\74\15\10\1\25\4\26\1\23\1\26\1\277\1\300\1\10\1"+
    "\105\1\23\1\175\1\301\15\10\1\25\3\26\1\277\54\10\1\74\2\26\10\10\1\40\6\10"+
    "\5\26\1\10\1\27\2\0\2\26\2\0\1\114\2\26\1\253\3\26\1\41\1\31\20\10\1\302\1"+
    "\244\1\26\1\5\1\166\1\7\2\10\1\116\1\7\2\10\1\46\1\303\12\10\1\23\3\40\1\304"+
    "\1\305\2\26\1\306\1\10\1\150\2\10\1\23\2\10\1\307\1\10\1\74\1\10\1\74\4\26"+
    "\17\10\1\46\10\26\6\10\1\27\20\26\1\310\20\26\3\10\1\27\6\10\1\131\1\26\1"+
    "\246\3\26\4\10\1\26\1\253\3\10\1\46\4\10\1\64\1\311\3\10\1\74\4\10\1\113\1"+
    "\10\1\250\5\26\23\10\1\74\1\5\1\166\4\10\1\113\4\10\1\113\5\10\1\26\6\10\1"+
    "\113\23\26\46\10\1\23\1\26\2\10\1\74\1\26\1\10\23\26\1\74\1\105\4\10\1\36"+
    "\1\312\2\10\1\74\1\26\2\10\1\23\1\26\3\10\1\23\10\26\2\10\1\313\1\26\2\10"+
    "\1\74\1\26\3\10\1\25\10\26\7\10\1\303\10\26\1\314\1\75\1\150\1\7\2\10\1\113"+
    "\1\121\4\26\3\10\1\27\3\10\1\27\4\26\1\10\1\7\2\10\1\315\3\26\6\10\1\74\1"+
    "\26\2\10\1\74\1\26\2\10\1\46\1\26\2\10\1\25\15\26\11\10\1\131\6\26\6\10\1"+
    "\46\1\26\6\10\1\46\41\26\1\232\6\10\1\0\1\165\3\26\1\125\1\5\1\26\1\61\1\232"+
    "\5\10\1\0\1\316\2\26\3\10\1\131\1\5\1\166\1\232\3\10\1\164\1\0\1\317\1\5\2"+
    "\26\4\10\1\320\1\26\1\232\5\10\1\52\1\0\1\321\1\322\1\5\1\323\4\26\2\10\1"+
    "\35\2\10\1\222\1\0\1\204\10\26\1\23\1\251\1\10\1\36\1\10\1\131\5\10\1\164"+
    "\1\0\1\311\1\5\1\166\1\144\1\103\1\104\2\10\1\105\1\127\1\107\1\110\1\122"+
    "\1\143\1\253\1\324\2\203\21\26\6\10\1\202\1\0\1\205\1\46\1\5\1\166\4\26\6"+
    "\10\2\0\1\325\1\26\1\5\1\166\24\26\5\10\1\164\1\47\1\0\1\246\2\26\1\270\4"+
    "\26\6\10\2\0\1\326\1\26\1\5\1\166\4\26\5\10\1\52\1\0\1\26\1\5\1\166\6\26\3"+
    "\10\1\327\1\0\1\2\1\5\1\166\54\26\10\10\1\5\1\166\1\26\1\42\40\26\1\100\1"+
    "\232\4\10\1\52\1\330\1\61\1\26\1\100\1\76\4\10\1\242\1\212\1\0\1\177\4\26"+
    "\7\10\1\131\40\26\1\10\1\105\3\10\1\164\1\165\1\0\1\131\1\26\1\5\1\166\2\26"+
    "\1\40\3\10\1\331\2\0\1\43\1\165\11\26\1\23\1\35\4\10\1\332\1\333\1\213\1\26"+
    "\1\0\1\177\24\26\63\10\1\25\14\26\15\10\1\23\2\26\30\10\1\113\27\26\5\10\1"+
    "\23\72\26\10\10\1\23\67\26\7\10\1\131\3\10\1\23\1\5\1\166\14\26\3\10\1\74"+
    "\1\203\1\26\6\10\1\165\1\26\1\113\1\26\1\5\1\166\1\277\2\10\1\253\2\10\56"+
    "\26\10\10\1\27\1\26\1\100\4\0\1\165\1\26\1\61\1\232\1\10\10\26\1\25\3\26\75"+
    "\10\1\27\2\26\36\10\1\46\41\26\43\10\1\23\12\26\61\10\1\113\40\26\15\10\1"+
    "\46\1\10\1\27\1\10\1\131\1\10\1\334\1\2\127\26\1\335\1\336\2\0\1\337\1\2\3"+
    "\26\1\340\22\26\1\322\67\26\12\10\1\31\10\10\1\31\1\341\1\342\1\10\1\343\1"+
    "\150\7\10\1\36\1\344\2\31\3\10\1\345\1\175\1\40\1\105\51\10\1\74\3\10\1\105"+
    "\2\10\1\215\3\10\1\215\2\10\1\31\3\10\1\31\2\10\1\23\3\10\1\23\3\10\1\105"+
    "\3\10\1\105\2\10\1\215\1\346\6\5\6\0\1\165\1\231\5\0\1\203\1\310\1\26\1\347"+
    "\2\26\1\231\1\43\1\0\52\26\1\165\2\0\1\350\1\351\1\311\72\26\30\10\1\27\1"+
    "\26\1\165\5\26\10\10\1\222\1\311\1\5\1\166\24\26\1\150\3\10\1\167\1\7\1\215"+
    "\1\352\1\247\1\353\1\167\1\240\1\167\2\215\1\124\1\10\1\35\1\10\1\113\1\354"+
    "\1\35\1\10\1\113\50\26\32\10\1\23\5\26\106\10\1\27\1\26\33\10\1\74\120\10"+
    "\1\25\1\26\146\10\1\131\3\26\3\10\1\74\74\26\1\123\3\26\14\0\20\26\36\0\2"+
    "\26");

  /* The ZZ_CMAP_A table has 1896 entries */
  static final char ZZ_CMAP_A[] = zzUnpackCMap(
    "\11\12\1\4\1\2\1\1\1\5\1\3\6\12\4\0\1\4\1\53\2\0\1\11\1\45\1\50\1\0\1\36\1"+
    "\37\1\42\1\43\1\40\1\44\1\10\1\6\12\7\1\0\1\33\1\46\1\41\1\47\2\0\22\11\3"+
    "\0\1\51\1\11\1\0\1\25\1\26\1\32\1\17\1\27\1\23\1\56\1\57\1\16\2\11\1\24\1"+
    "\54\1\20\1\15\2\11\1\31\1\30\1\21\1\22\1\14\2\11\1\55\1\11\1\34\1\52\1\35"+
    "\1\0\6\12\1\13\2\12\2\0\4\11\4\0\1\11\2\0\1\12\7\0\1\11\4\0\1\11\5\0\7\11"+
    "\1\0\2\11\4\0\4\11\16\0\5\11\7\0\1\11\1\0\1\11\1\0\5\11\1\0\2\11\2\0\4\11"+
    "\1\0\1\11\6\0\1\11\1\0\3\11\1\0\1\11\1\0\4\11\1\0\13\11\1\0\3\11\1\0\5\12"+
    "\2\0\6\11\1\0\1\11\15\0\1\11\1\0\15\12\1\0\1\12\1\0\2\12\1\0\2\12\1\0\1\12"+
    "\3\11\5\0\6\12\5\0\1\11\4\0\3\12\1\0\1\12\3\0\3\11\5\12\2\7\4\0\2\11\1\12"+
    "\13\11\1\0\1\11\7\12\2\11\2\12\1\0\4\12\2\11\2\7\3\11\2\0\1\11\7\0\1\12\1"+
    "\11\1\12\6\11\3\12\2\0\11\11\3\12\1\11\6\0\2\7\6\11\4\12\2\11\2\0\2\12\1\11"+
    "\11\12\1\11\3\12\1\11\5\12\2\0\1\11\3\12\4\0\6\11\6\0\10\12\6\11\3\12\1\11"+
    "\2\12\1\11\7\12\2\11\2\12\2\0\2\7\1\11\3\12\1\0\10\11\2\0\2\11\2\0\6\11\1"+
    "\0\7\11\1\0\1\11\3\0\4\11\2\0\1\12\1\11\7\12\2\0\2\12\2\0\3\12\1\11\5\0\2"+
    "\11\1\0\5\11\7\0\2\11\4\0\3\12\1\0\6\11\4\0\2\11\1\0\2\11\1\0\2\11\1\0\2\11"+
    "\2\0\1\12\1\0\5\12\4\0\2\12\2\0\3\12\3\0\1\12\7\0\4\11\1\0\1\11\7\0\2\7\2"+
    "\12\3\11\1\12\2\0\1\11\1\0\2\11\1\0\3\11\2\12\1\0\3\12\2\0\1\11\10\0\1\11"+
    "\6\12\6\0\2\12\2\0\1\12\1\11\1\0\6\11\3\0\3\11\1\0\4\11\3\0\2\11\1\0\1\11"+
    "\1\0\4\11\4\0\5\12\3\0\3\12\1\0\4\12\2\0\1\11\6\0\5\12\1\0\5\11\3\0\1\11\7"+
    "\12\1\0\2\12\5\0\2\12\1\0\4\11\1\0\3\11\1\0\2\11\5\0\3\11\2\12\1\11\3\12\1"+
    "\0\4\12\1\11\5\0\3\11\1\12\2\0\2\12\1\0\7\11\1\0\1\11\4\0\1\12\4\0\6\12\1"+
    "\0\1\12\3\0\2\12\4\0\1\11\1\12\2\11\7\12\4\0\10\11\10\12\1\0\2\7\7\0\2\11"+
    "\1\0\1\11\2\0\2\11\1\0\1\11\2\0\1\11\6\0\4\11\1\0\3\11\1\0\1\11\1\0\1\11\2"+
    "\0\2\11\1\0\3\11\2\12\1\0\2\12\1\11\2\0\5\11\1\0\1\11\1\0\2\7\2\0\4\11\2\12"+
    "\13\0\1\12\1\0\1\12\1\0\1\12\4\0\2\12\5\11\10\12\11\0\1\12\1\0\7\12\1\11\2"+
    "\12\4\11\3\12\1\11\3\12\2\11\7\12\3\11\4\12\5\11\14\12\1\11\1\12\2\7\4\12"+
    "\2\0\3\11\1\0\7\11\2\0\3\12\2\11\3\12\3\0\2\11\2\12\4\0\1\11\1\0\2\12\4\0"+
    "\4\11\10\12\3\0\1\11\3\0\2\11\1\12\5\0\4\12\1\0\5\11\2\12\2\11\1\12\1\11\5"+
    "\0\5\12\3\11\3\0\10\12\5\11\2\7\3\0\3\11\3\12\1\0\5\12\4\11\1\12\4\11\3\12"+
    "\2\11\3\12\1\0\5\12\1\0\1\11\1\0\1\11\1\0\1\11\1\0\1\11\2\0\3\11\1\0\6\11"+
    "\2\0\2\11\2\1\5\12\5\0\1\11\4\0\1\12\3\0\4\12\11\0\1\11\4\0\1\11\1\0\5\11"+
    "\2\0\1\11\1\0\4\11\1\0\3\11\2\0\4\11\5\0\5\11\4\0\1\11\4\0\4\11\3\12\2\11"+
    "\5\0\2\12\2\0\3\11\2\7\2\11\4\0\6\12\1\0\3\11\1\12\3\11\1\12\4\11\1\12\4\11"+
    "\2\12\6\11\3\0\1\11\1\0\1\11\2\0\5\11\1\12\2\11\2\7\5\11\1\0\4\11\2\12\4\0"+
    "\1\11\3\12\2\11\1\12\5\11\2\12\3\0\3\11\4\0\3\11\2\12\2\0\6\11\1\0\3\12\1"+
    "\0\2\12\5\0\5\11\5\0\1\11\1\12\3\11\1\0\2\11\1\0\7\11\2\0\1\12\6\0\2\11\2"+
    "\0\3\11\3\0\2\11\3\0\2\11\2\0\3\12\4\0\3\11\1\0\2\11\1\0\1\11\5\0\1\12\2\0"+
    "\3\12\5\0\1\11\3\0\1\11\2\0\4\11\1\0\2\11\2\0\1\11\3\12\1\0\2\12\1\0\5\11"+
    "\2\12\1\0\3\12\2\0\1\12\2\0\5\12\1\0\2\7\3\11\1\12\2\0\1\11\1\0\1\12\4\11"+
    "\5\0\3\12\3\0\2\7\1\11\1\0\1\11\3\0\2\11\2\12\2\0\6\12\2\11\1\0\1\11\1\12"+
    "\3\0\1\11\3\0\2\11\3\0\5\12\1\11\4\12\3\0\6\12\1\11\6\12\3\0\1\12\1\0\2\12"+
    "\1\0\1\12\2\11\3\0\2\12\6\0\5\12\3\0\6\12\2\0\3\12\2\0\4\12\4\0\1\11\2\0\2"+
    "\11\2\0\4\11\1\0\4\11\1\0\1\11\1\0\6\11\2\0\5\11\1\0\4\11\1\0\4\11\2\0\2\7"+
    "\4\0\1\12\3\0\1\12\2\0\7\12\1\0\2\12\1\0\2\12\1\0\1\11\1\0\1\11\5\0\1\11\1"+
    "\0\1\11\1\0\3\11\1\0\3\11\1\0\3\11");

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\2\0\1\1\1\2\1\3\1\4\13\5\1\6\1\7"+
    "\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17"+
    "\1\20\1\21\1\22\1\23\1\24\1\25\1\1\2\26"+
    "\1\3\12\1\1\27\1\30\1\0\3\5\1\31\12\5"+
    "\1\32\1\33\1\34\1\35\1\36\1\37\1\40\1\41"+
    "\1\42\1\43\1\44\1\45\1\46\1\47\1\50\1\51"+
    "\3\0\1\31\12\0\1\52\2\5\1\53\1\54\12\5"+
    "\1\55\1\56\2\0\1\53\1\54\12\0\1\57\2\5"+
    "\1\60\3\5\1\61\4\5\1\57\2\0\1\60\3\0"+
    "\1\61\4\0\3\5\1\62\4\5\1\63\3\0\1\62"+
    "\4\0\1\63\1\5\1\64\2\5\1\65\1\66\1\67"+
    "\1\0\1\64\2\0\1\65\1\66\1\67\1\70\1\71"+
    "\1\5\1\70\1\71\1\0\1\5\1\0\2\72";

  private static int [] zzUnpackAction() {
    int [] result = new int[191];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\60\0\140\0\220\0\300\0\360\0\u0120\0\u0150"+
    "\0\u0180\0\u01b0\0\u01e0\0\u0210\0\u0240\0\u0270\0\u02a0\0\u02d0"+
    "\0\u0300\0\140\0\140\0\140\0\140\0\140\0\140\0\u0330"+
    "\0\u0360\0\u0390\0\u03c0\0\u03f0\0\u0420\0\u0450\0\u0480\0\u04b0"+
    "\0\u04e0\0\u0510\0\220\0\u0540\0\u0570\0\u05a0\0\u05d0\0\u0600"+
    "\0\u0630\0\u0660\0\u0690\0\u06c0\0\u06f0\0\u0720\0\u0750\0\u0780"+
    "\0\140\0\u07b0\0\u07e0\0\u0810\0\u0840\0\u0870\0\u08a0\0\u08d0"+
    "\0\u0900\0\u0930\0\u0960\0\u0990\0\u09c0\0\u09f0\0\u0a20\0\u0a50"+
    "\0\140\0\140\0\140\0\140\0\140\0\140\0\u0a80\0\140"+
    "\0\u0ab0\0\140\0\140\0\140\0\140\0\140\0\140\0\140"+
    "\0\u0ae0\0\u0b10\0\u0b40\0\u0b70\0\u0ba0\0\u0bd0\0\u0c00\0\u0c30"+
    "\0\u0c60\0\u0c90\0\u0cc0\0\u0cf0\0\u0d20\0\u0d50\0\u07b0\0\u0d80"+
    "\0\u0db0\0\u0120\0\u0120\0\u0de0\0\u0e10\0\u0e40\0\u0e70\0\u0ea0"+
    "\0\u0ed0\0\u0f00\0\u0f30\0\u0f60\0\u0f90\0\140\0\140\0\u0fc0"+
    "\0\u0ff0\0\140\0\140\0\u1020\0\u1050\0\u1080\0\u10b0\0\u10e0"+
    "\0\u1110\0\u1140\0\u1170\0\u11a0\0\u11d0\0\u0120\0\u1200\0\u1230"+
    "\0\u0120\0\u1260\0\u1290\0\u12c0\0\u0120\0\u12f0\0\u1320\0\u1350"+
    "\0\u1380\0\140\0\u13b0\0\u13e0\0\140\0\u1410\0\u1440\0\u1470"+
    "\0\140\0\u14a0\0\u14d0\0\u1500\0\u1530\0\u1560\0\u1590\0\u15c0"+
    "\0\u0120\0\u15f0\0\u1620\0\u1650\0\u1680\0\u0120\0\u16b0\0\u16e0"+
    "\0\u1710\0\140\0\u1740\0\u1770\0\u17a0\0\u17d0\0\140\0\u1800"+
    "\0\u0120\0\u1830\0\u1860\0\u0120\0\u0120\0\u0120\0\u1890\0\140"+
    "\0\u18c0\0\u18f0\0\140\0\140\0\140\0\u0120\0\u0120\0\u1920"+
    "\0\140\0\140\0\u1950\0\u1980\0\u19b0\0\u0120\0\140";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[191];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\3\5\4\1\5\1\6\1\3\1\7\1\3\1\4"+
    "\1\10\1\11\1\12\1\13\2\7\1\14\1\15\1\7"+
    "\1\16\1\17\1\7\1\20\1\7\1\21\1\22\1\23"+
    "\1\24\1\25\1\26\1\27\1\30\1\31\1\32\1\33"+
    "\1\34\1\35\1\36\1\37\1\40\1\41\1\42\4\7"+
    "\1\3\1\4\1\43\1\4\1\44\1\43\1\45\4\3"+
    "\1\4\1\46\1\47\1\50\1\51\2\3\1\52\1\53"+
    "\1\3\1\54\1\55\1\3\1\56\1\3\1\57\1\22"+
    "\1\23\1\24\1\25\1\26\1\27\1\30\1\31\1\32"+
    "\1\33\1\34\1\35\1\36\1\37\1\40\1\41\1\42"+
    "\4\3\61\0\5\4\5\0\1\4\52\0\1\60\32\0"+
    "\1\61\25\0\1\6\1\62\56\0\1\7\1\0\22\7"+
    "\21\0\4\7\7\0\1\7\1\0\4\7\1\63\7\7"+
    "\1\64\5\7\21\0\4\7\7\0\1\7\1\0\11\7"+
    "\1\65\10\7\21\0\4\7\7\0\1\7\1\0\7\7"+
    "\1\66\12\7\21\0\4\7\7\0\1\7\1\0\4\7"+
    "\1\67\15\7\21\0\4\7\7\0\1\7\1\0\5\7"+
    "\1\70\1\7\1\71\12\7\21\0\4\7\7\0\1\7"+
    "\1\0\13\7\1\72\6\7\21\0\4\7\7\0\1\7"+
    "\1\0\10\7\1\73\11\7\21\0\4\7\7\0\1\7"+
    "\1\0\4\7\1\74\4\7\1\75\10\7\21\0\4\7"+
    "\7\0\1\7\1\0\10\7\1\76\11\7\21\0\3\7"+
    "\1\77\7\0\1\7\1\0\4\7\1\100\15\7\21\0"+
    "\4\7\41\0\1\101\57\0\1\102\57\0\1\103\57\0"+
    "\1\104\57\0\1\105\57\0\1\106\4\0\1\107\52\0"+
    "\1\110\5\0\1\111\51\0\1\112\6\0\1\113\50\0"+
    "\1\114\7\0\1\115\47\0\1\116\10\0\1\117\46\0"+
    "\1\120\17\0\1\4\1\44\1\4\2\44\5\0\1\4"+
    "\105\0\1\61\33\0\1\121\7\0\1\122\54\0\1\123"+
    "\55\0\1\124\54\0\1\125\60\0\1\126\1\0\1\127"+
    "\63\0\1\130\54\0\1\131\53\0\1\132\4\0\1\133"+
    "\56\0\1\134\35\0\1\135\15\0\1\136\42\0\2\60"+
    "\2\0\54\60\7\0\1\137\57\0\1\7\1\0\5\7"+
    "\1\140\14\7\21\0\4\7\7\0\1\7\1\0\20\7"+
    "\1\141\1\7\21\0\4\7\7\0\1\7\1\0\10\7"+
    "\1\142\11\7\21\0\4\7\7\0\1\7\1\0\10\7"+
    "\1\143\11\7\21\0\4\7\7\0\1\7\1\0\11\7"+
    "\1\144\10\7\21\0\4\7\7\0\1\7\1\0\7\7"+
    "\1\145\12\7\21\0\4\7\7\0\1\7\1\0\5\7"+
    "\1\146\14\7\21\0\4\7\7\0\1\7\1\0\4\7"+
    "\1\147\15\7\21\0\4\7\7\0\1\7\1\0\10\7"+
    "\1\150\11\7\21\0\4\7\7\0\1\7\1\0\4\7"+
    "\1\151\15\7\21\0\4\7\7\0\1\7\1\0\12\7"+
    "\1\152\7\7\21\0\4\7\7\0\1\7\1\0\20\7"+
    "\1\153\1\7\21\0\4\7\7\0\1\7\1\0\14\7"+
    "\1\154\5\7\21\0\4\7\7\0\1\7\1\0\7\7"+
    "\1\155\12\7\21\0\4\7\41\0\1\156\57\0\1\157"+
    "\34\0\1\160\72\0\1\161\47\0\1\162\57\0\1\163"+
    "\60\0\1\164\55\0\1\165\55\0\1\166\56\0\1\167"+
    "\63\0\1\170\53\0\1\171\65\0\1\172\65\0\1\173"+
    "\53\0\1\174\52\0\1\175\46\0\1\7\1\0\6\7"+
    "\1\176\13\7\21\0\4\7\7\0\1\7\1\0\22\7"+
    "\21\0\1\7\1\177\2\7\7\0\1\7\1\0\15\7"+
    "\1\200\4\7\21\0\4\7\7\0\1\7\1\0\10\7"+
    "\1\201\11\7\21\0\4\7\7\0\1\7\1\0\12\7"+
    "\1\202\7\7\21\0\4\7\7\0\1\7\1\0\14\7"+
    "\1\203\5\7\21\0\4\7\7\0\1\7\1\0\20\7"+
    "\1\204\1\7\21\0\4\7\7\0\1\7\1\0\13\7"+
    "\1\205\6\7\21\0\4\7\7\0\1\7\1\0\12\7"+
    "\1\206\7\7\21\0\4\7\7\0\1\7\1\0\11\7"+
    "\1\207\10\7\21\0\4\7\7\0\1\7\1\0\20\7"+
    "\1\210\1\7\21\0\4\7\7\0\1\7\1\0\17\7"+
    "\1\211\2\7\21\0\4\7\17\0\1\212\115\0\1\213"+
    "\30\0\1\214\52\0\1\215\61\0\1\216\61\0\1\217"+
    "\63\0\1\220\52\0\1\221\56\0\1\222\56\0\1\223"+
    "\66\0\1\224\56\0\1\225\36\0\1\7\1\0\5\7"+
    "\1\226\14\7\21\0\4\7\7\0\1\7\1\0\13\7"+
    "\1\227\6\7\21\0\4\7\7\0\1\7\1\0\4\7"+
    "\1\230\15\7\21\0\4\7\7\0\1\7\1\0\10\7"+
    "\1\231\11\7\21\0\4\7\7\0\1\7\1\0\5\7"+
    "\1\232\14\7\21\0\4\7\7\0\1\7\1\0\16\7"+
    "\1\233\3\7\21\0\4\7\7\0\1\7\1\0\21\7"+
    "\1\234\21\0\4\7\7\0\1\7\1\0\16\7\1\235"+
    "\3\7\21\0\4\7\7\0\1\7\1\0\10\7\1\236"+
    "\11\7\21\0\4\7\16\0\1\237\65\0\1\240\50\0"+
    "\1\241\63\0\1\242\54\0\1\243\70\0\1\244\62\0"+
    "\1\245\54\0\1\246\51\0\1\247\45\0\1\7\1\0"+
    "\7\7\1\250\12\7\21\0\4\7\7\0\1\7\1\0"+
    "\16\7\1\251\3\7\21\0\4\7\7\0\1\7\1\0"+
    "\20\7\1\252\1\7\21\0\4\7\7\0\1\7\1\0"+
    "\15\7\1\253\4\7\21\0\4\7\7\0\1\7\1\0"+
    "\20\7\1\254\1\7\21\0\4\7\7\0\1\7\1\0"+
    "\10\7\1\255\11\7\21\0\4\7\7\0\1\7\1\0"+
    "\6\7\1\256\13\7\21\0\4\7\20\0\1\257\66\0"+
    "\1\260\61\0\1\261\54\0\1\262\62\0\1\263\47\0"+
    "\1\264\55\0\1\265\47\0\1\7\1\0\22\7\21\0"+
    "\2\7\1\266\1\7\7\0\1\7\1\0\22\7\21\0"+
    "\1\267\3\7\7\0\1\7\1\0\11\7\1\270\10\7"+
    "\21\0\4\7\56\0\1\271\55\0\1\272\25\0\1\273"+
    "\44\0\1\7\1\0\10\7\1\274\11\7\21\0\4\7"+
    "\21\0\1\275\45\0\1\7\1\0\16\7\1\276\3\7"+
    "\21\0\4\7\27\0\1\277\30\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[6624];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String[] ZZ_ERROR_MSG = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\2\0\1\11\16\1\6\11\31\1\1\11\1\0\16\1"+
    "\6\11\1\1\1\11\1\1\7\11\3\0\1\1\12\0"+
    "\17\1\2\11\2\0\2\11\12\0\14\1\1\11\2\0"+
    "\1\11\3\0\1\11\4\0\11\1\3\0\1\11\4\0"+
    "\1\11\7\1\1\0\1\11\2\0\3\11\3\1\2\11"+
    "\1\0\1\1\1\0\1\1\1\11";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[191];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private CharSequence zzBuffer = "";

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /**
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  GlslLexer(java.io.Reader in) {
    this.zzReader = in;
  }


  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    int size = 0;
    for (int i = 0, length = packed.length(); i < length; i += 2) {
      size += packed.charAt(i);
    }
    char[] map = new char[size];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < packed.length()) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }

  public final int getTokenStart() {
    return zzStartRead;
  }

  public final int getTokenEnd() {
    return getTokenStart() + yylength();
  }

  public void reset(CharSequence buffer, int start, int end, int initialState) {
    zzBuffer = buffer;
    zzCurrentPos = zzMarkedPos = zzStartRead = start;
    zzAtEOF  = false;
    zzAtBOL = true;
    zzEndRead = end;
    yybegin(initialState);
  }

  /**
   * Refills the input buffer.
   *
   * @return      {@code false}, iff there was new input.
   *
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {
    return true;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final CharSequence yytext() {
    return zzBuffer.subSequence(zzStartRead, zzMarkedPos);
  }


  /**
   * Returns the character at position {@code pos} from the
   * matched text.
   *
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch.
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer.charAt(zzStartRead+pos);
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occurred while scanning.
   *
   * In a wellformed scanner (no or only correct usage of
   * yypushback(int) and a match-all fallback rule) this method
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() {
    if (!zzEOFDone) {
      zzEOFDone = true;
    
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public IElementType advance() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    CharSequence zzBufferL = zzBuffer;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL/*, zzEndReadL*/);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL/*, zzEndReadL*/);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + ZZ_CMAP(zzInput) ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
        zzDoEOF();
        return null;
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1: 
            { return TokenType.BAD_CHARACTER;
            } 
            // fall through
          case 59: break;
          case 2: 
            { yybegin(YYINITIAL); return TokenType.WHITE_SPACE;
            } 
            // fall through
          case 60: break;
          case 3: 
            { return GlslTypes.SLASH;
            } 
            // fall through
          case 61: break;
          case 4: 
            { return GlslTypes.INTEGER_CONSTANT;
            } 
            // fall through
          case 62: break;
          case 5: 
            { return GlslTypes.IDENTIFIER;
            } 
            // fall through
          case 63: break;
          case 6: 
            { return GlslTypes.SEMICOLON;
            } 
            // fall through
          case 64: break;
          case 7: 
            { return GlslTypes.C_BRACKET_L;
            } 
            // fall through
          case 65: break;
          case 8: 
            { return GlslTypes.C_BRACKET_R;
            } 
            // fall through
          case 66: break;
          case 9: 
            { return GlslTypes.PAREN_L;
            } 
            // fall through
          case 67: break;
          case 10: 
            { return GlslTypes.PAREN_R;
            } 
            // fall through
          case 68: break;
          case 11: 
            { return GlslTypes.COMMA;
            } 
            // fall through
          case 69: break;
          case 12: 
            { return GlslTypes.EQUAL;
            } 
            // fall through
          case 70: break;
          case 13: 
            { return GlslTypes.STAR;
            } 
            // fall through
          case 71: break;
          case 14: 
            { return GlslTypes.PLUS;
            } 
            // fall through
          case 72: break;
          case 15: 
            { return GlslTypes.DASH;
            } 
            // fall through
          case 73: break;
          case 16: 
            { return GlslTypes.PERCENT;
            } 
            // fall through
          case 74: break;
          case 17: 
            { return GlslTypes.ANGLE_L;
            } 
            // fall through
          case 75: break;
          case 18: 
            { return GlslTypes.ANGLE_R;
            } 
            // fall through
          case 76: break;
          case 19: 
            { return GlslTypes.AMPERSAND;
            } 
            // fall through
          case 77: break;
          case 20: 
            { return GlslTypes.CARET;
            } 
            // fall through
          case 78: break;
          case 21: 
            { return GlslTypes.VERTICAL_BAR;
            } 
            // fall through
          case 79: break;
          case 22: 
            { yybegin(WAITING_VALUE); return TokenType.WHITE_SPACE;
            } 
            // fall through
          case 80: break;
          case 23: 
            { return GlslTypes.COMMENT;
            } 
            // fall through
          case 81: break;
          case 24: 
            { return GlslTypes.DIV_ASSIGN;
            } 
            // fall through
          case 82: break;
          case 25: 
            { return GlslTypes.IN;
            } 
            // fall through
          case 83: break;
          case 26: 
            { return GlslTypes.EQ_OP;
            } 
            // fall through
          case 84: break;
          case 27: 
            { return GlslTypes.MUL_ASSIGN;
            } 
            // fall through
          case 85: break;
          case 28: 
            { return GlslTypes.ADD_ASSIGN;
            } 
            // fall through
          case 86: break;
          case 29: 
            { return GlslTypes.SUB_ASSIGN;
            } 
            // fall through
          case 87: break;
          case 30: 
            { return GlslTypes.MOD_ASSIGN;
            } 
            // fall through
          case 88: break;
          case 31: 
            { return GlslTypes.LE_OP;
            } 
            // fall through
          case 89: break;
          case 32: 
            { return GlslTypes.LEFT_OP;
            } 
            // fall through
          case 90: break;
          case 33: 
            { return GlslTypes.GE_OP;
            } 
            // fall through
          case 91: break;
          case 34: 
            { return GlslTypes.RIGHT_OP;
            } 
            // fall through
          case 92: break;
          case 35: 
            { return GlslTypes.AND_ASSIGN;
            } 
            // fall through
          case 93: break;
          case 36: 
            { return GlslTypes.AND_OP;
            } 
            // fall through
          case 94: break;
          case 37: 
            { return GlslTypes.XOR_ASSIGN;
            } 
            // fall through
          case 95: break;
          case 38: 
            { return GlslTypes.XOR_OP;
            } 
            // fall through
          case 96: break;
          case 39: 
            { return GlslTypes.OR_ASSIGN;
            } 
            // fall through
          case 97: break;
          case 40: 
            { return GlslTypes.OR_OP;
            } 
            // fall through
          case 98: break;
          case 41: 
            { return GlslTypes.NE_OP;
            } 
            // fall through
          case 99: break;
          case 42: 
            { return GlslTypes.FLOAT_CONSTANT;
            } 
            // fall through
          case 100: break;
          case 43: 
            { return GlslTypes.OUT;
            } 
            // fall through
          case 101: break;
          case 44: 
            { return GlslTypes.INT;
            } 
            // fall through
          case 102: break;
          case 45: 
            { return GlslTypes.LEFT_ASSIGN;
            } 
            // fall through
          case 103: break;
          case 46: 
            { return GlslTypes.RIGHT_ASSIGN;
            } 
            // fall through
          case 104: break;
          case 47: 
            { return GlslTypes.VOID;
            } 
            // fall through
          case 105: break;
          case 48: 
            { return GlslTypes.UINT;
            } 
            // fall through
          case 106: break;
          case 49: 
            { return GlslTypes.BOOL;
            } 
            // fall through
          case 107: break;
          case 50: 
            { return GlslTypes.FLOAT;
            } 
            // fall through
          case 108: break;
          case 51: 
            { return GlslTypes.CONST;
            } 
            // fall through
          case 109: break;
          case 52: 
            { return GlslTypes.DOUBLE;
            } 
            // fall through
          case 110: break;
          case 53: 
            { return GlslTypes.BUFFER;
            } 
            // fall through
          case 111: break;
          case 54: 
            { return GlslTypes.STRUCT;
            } 
            // fall through
          case 112: break;
          case 55: 
            { return GlslTypes.SHARED;
            } 
            // fall through
          case 113: break;
          case 56: 
            { return GlslTypes.VARYING;
            } 
            // fall through
          case 114: break;
          case 57: 
            { return GlslTypes.UNIFORM;
            } 
            // fall through
          case 115: break;
          case 58: 
            { return GlslTypes.ATTRIBUTE;
            } 
            // fall through
          case 116: break;
          default:
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
