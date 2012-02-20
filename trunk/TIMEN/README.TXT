TIMEN LIBRARY

LICENSE
	AGPL Apache

AUTHORS
	Hector Llorens, Leon Derczynski, Robert Gaizauskas, Estela Saquete


Building the library jar:
------------------------
cd TIMEN; ant




Additional instructions for developers:
---------------------------------------

- Recompiling the grammar (TIMENruleGrammar.g):

	1) Include ANTLR in the CLASSPATH:
		export CLASSPATH=~/path2jar/antlr-3.4-complete-no-antlrv2.jar:$CLASSPATH

	2) Generate tokens, TIMENruleGrammarLexer.java, and TIMENruleGrammarParser.java
		java org.antlr.Tool TIMENruleGrammar.g

	3) If you generated these files in the java folder when you rebuild TIMEN (with ant) the new grammar will be included



To edit the grammar you can use the visual editor "ANTLR-works":
	java -jar antlrworks-1.4.3.jar

