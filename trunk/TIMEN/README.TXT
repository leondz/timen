TIMEN LIBRARY

LICENSE
	AGPL/Apache

AUTHORS
	Hector Llorens, Leon Derczynski, Robert Gaizauskas, Estela Saquete


USAGE

NEW, NO NEED FOR LOCAL COPY: Now timen is available in Maven central repositories (https://oss.sonatype.org).
LOCAL: Just include into your project the TIMEN.jar library and its dependences (either in lib/*.jar or in the classpath)

If you want to override the rulebases in cluded in TIMEN.jar, you have to put your own in rule-base for each language in res/rule-bases/*.db



DEVELOPMENT INFORMATION
------------------------------------------------------------------------------------------------------------

Building the library jar from source code:
-----------------------------------------
cd TIMEN; mvn package


Additional instructions for developers:
---------------------------------------

- Recompiling the grammar (TIMENruleGrammar.g):

	1) Include ANTLR in the CLASSPATH:
		export CLASSPATH=~/path2jar/antlr-3.4-complete-no-antlrv2.jar:$CLASSPATH

	2) Generate tokens, TIMENruleGrammarLexer.java, and TIMENruleGrammarParser.java
		cd path2timen/src/org/timen/grammar/
		java org.antlr.Tool TIMENruleGrammar.g

	3) If you generated these files in the java folder when you rebuild TIMEN (with ant or mvn) the new grammar will be included

optional graphical interface to edit the grammar: java -jar antlrworks-1.4.3.jar


Advanced debugging notes (Net Beans/Eclipse)
--------------------------------------------

If you are interested on run a debugging session step by step and you want to access (put break points) in TIMEN classes. You have to remove the TIMEN library from the project and add TIMEN as a project.
IMPORTANT: When you finish debugging you have to recompile TIMEN an relink it as a library instead of as a project in TIMEN_CONSUMER.



