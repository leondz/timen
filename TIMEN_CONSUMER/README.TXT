LICENSE

AUTHORS





To get the TIMEN input features such as POS, LEMMA, ... we need a PoS tagger... e.g., TreeTagger.
It has to be installed and the path has to be specified in a conf file.
or we can just omit PoS and lemma (e.g., use always lower case and make rules to guess ambiguous cases).

Best thing to do is use or implement a basic tokenizer (such as the one in TreeTagger based on MUC-TreeBank) (simple perl script...)
For the moment we can forget about this and make the systems implementing a TIMEN consumer be in-charged of generating TIMEN input from TimeML.

stanford parser (english) or freeling (spanish) support is not needed for now
we can focus on TIMEN rules & syntax and the camera-ready



COMPILING THE GRAMMAR
---------------------
java org.antlr.Tool Expr.g
	This generates: tokens, lexer, and parser java files.

javac Test.java ExprLexer.java ExprParser.java
	This compiles the lexer the parser and a simple main program in Test

the usage is:
	echo -e "x=1\ny=2\n3*(x+y)" | java Test

If you build a NetBeans project you can place the generated tokens, lexer and parser in a grammar folder in src.
You need to add the ANTLR3 as library!
Then the test will be on main, and you can run all as:
echo -e "x=1\ny=2\n3*(x+y)" | java -jar "/home/hector/Dropbox/JApplications/SimpleCalc/dist/SimpleCalc.jar"

---------------------------------------

The answer by Dr. Manning is the most appropriate if you are considering the JAVA (and Ruby too in hard way ;)). It is here-

    There is a sentence splitter: edu.stanford.nlp.process.DocumentPreprocessor . Try the command: java edu.stanford.nlp.process.DocumentPreprocessor /u/nlp/data/lexparser/textDocument.txt

        oneTokenizedSentencePerLine.txt . (This is done via a (good but heuristic) FSM, so it's fast; you're not running the probabilistic parser.)

But a little suggestion if we modify the command java edu.stanford.nlp.process.DocumentPreprocessor /u/nlp/data/lexparser/textDocument.txt > oneTokenizedSentencePerLine.txt TO java edu.stanford.nlp.process.DocumentPreprocessor -file /u/nlp/data/lexparser/textDocument.txt > oneTokenizedSentencePerLine.txt . It will work fine as you need to specify what kind of file is being presented as input. So -file for Text file, -html for HTML, etc.

