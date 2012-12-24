LICENSE
	AGPL/Apache

AUTHORS
	Original Code:	Hector Llorens, Leon Derczynski
	Original paper: Hector Llorens, Leon Derczynski, Robert Gaizauskas, Estela Saquete
	Current code:	Hector Llorens, Leon Derczynski, Steven Bethard

Prerequisites (ONLY IF YOU WANT TO USE THE NLP OPTION):
------------------------------------------------------
	1) copy the Treetagger program-data/Tretagger/script in the Treetagger folder
	2) specify the Treetagger path in the program-data/confing.properties
	3) Remove from Treetagger/lib/english-abberviations     "days."

Usage:
-----
	Copy the jar distribution to a folder of your choice.	

	java -jar "/path2jar/TIMEN_CONSUMER.jar" [options]

	If you want to override the rulebases in cluded in TIMEN.jar, you have to put your own in rule-base for each language in res/rule-bases/*.db



Examples:
--------
	Normalize a single expression: this outputs the normalized value
	java -jar "/path2jar/TIMEN_CONSUMER.jar" "yesterday"
	java -jar "/path2jar/TIMEN_CONSUMER.jar" "yesterday" -ap dct=1999-12-04
	java -jar "/path2jar/TIMEN_CONSUMER.jar" "Monday" -ap dct=1999-12-04,tense=past

	Normalize file/s: this outputs file/s in the same path in TIMEN-output/ folder with added/updated normalized values
	java -jar "/path2jar/TIMEN_CONSUMER.jar" -a normalize_tml examples/example.tml
	java -jar "/path2jar/TIMEN_CONSUMER.jar" -a normalize_tml examples/example.tml -ap use_nlp=true


	For evaluation just  put TimeBank or TBAQ files in a folder and run 
	java -jar "/path2jar/TIMEN_CONSUMER.jar" -a normalize_tml folder/*.tml
	Then use the evaluation scripts to evaluate KEY-files against TIMEN-output files




Additional instructions for developers:
---------------------------------------

Installation/Building:
---------------------
cd TIMEN_CONSUMER; ant


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


