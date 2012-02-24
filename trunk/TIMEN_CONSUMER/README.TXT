LICENSE
	AGPL Apache

AUTHORS
	Hector Llorens, Leon Derczynski, Robert Gaizauskas, Estela Saquete

Prerequisites:
-------------
  Only if you want to use the NLP version you need to:
	1) copy the Treetagger program-data/Tretagger/script in the Treetagger folder
	2) specify the Treetagger path in the program-data/confing.properties


Installation/Building:
---------------------
cd TIMEN_CONSUMER; ant

Usage:
-----
java -jar "/path2jar/TIMEN_CONSUMER.jar" [options]


Examples:
--------

java -jar "/path2jar/TIMEN_CONSUMER.jar" "yesterday"
java -jar "/path2jar/TIMEN_CONSUMER.jar" "yesterday" -ap dct=1999-12-04
java -jar "/path2jar/TIMEN_CONSUMER.jar" -a normalize_tml examples/example.tml
java -jar "/path2jar/TIMEN_CONSUMER.jar" -a normalize_tml examples/example.tml -ap use_nlp=true



Additional instructions for developers:
---------------------------------------

COMPILING TIMEN GRAMMAR (REMOVE ALREADY INCLUDED IN TIMEN README)
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

Advanced debugging notes (Net Beans/Eclipse)
--------------------------------------------

If you are interested on run a debugging session step by step and you want to access (put break points) in TIMEN classes. You have to remove the TIMEN library from the project and add TIMEN as a project.
IMPORTANT: When you finish debugging you have to recompile TIMEN an relink it as a library instead of as a project in TIMEN_CONSUMER.


