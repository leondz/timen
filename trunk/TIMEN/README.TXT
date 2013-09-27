TIMEN LIBRARY

LICENSE
	AGPL/Apache

AUTHORS
	Hector Llorens, Leon Derczynski, Robert Gaizauskas, Estela Saquete


USAGE
---------

Timen is available in Maven central repositories (https://oss.sonatype.org). So if you don't need to modify TIMEN just include it as dependence and it and its dependences will be downloaded automatically from Maven central repository.

If you need to modify TIMEN, do it and then include into the final project your timen-<version>.jar library and its dependences (either in lib/*.jar or in the classpath),

Before building TIMEN. You can modify the {rule,knowledge}-bases in res/ folder.

After building TIMEN. If you want to override the {rule,knowledge}-bases included in TIMEN.jar, you have to put your own in rule-base for each language in path2jar/{rule,knowledge}-bases.

java -jar "/path2jar/timen-<version>.jar" -a GET_PATTERN "yesterday"
java -jar "/path2jar/timen-<version>.jar" -a NORMALIZE "yesterday" -ap dct=1999-12-04



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
		e.g., export CLASSPATH=~/timen/TIMEN/lib-for-offline-use-only/antlr-3.4-complete-no-antlrv2.jar:$CLASSPATH

	2) Generate tokens, TIMENruleGrammarLexer.java, and TIMENruleGrammarParser.java
		cd path2timen/src/org/timen/grammar/ (e.g., cd ~/timen/TIMEN/src/main/java/org/timen/timen/grammar)
		java org.antlr.Tool TIMENruleGrammar.g

	3) If you generated these files in the java folder when you rebuild TIMEN (with ant or mvn) the new grammar will be included

optional graphical interface to edit the grammar: java -jar antlrworks-1.4.3.jar


Advanced debugging notes (Net Beans/Eclipse)
--------------------------------------------

If you are interested on run a debugging session step by step and you want to access (put break points) in TIMEN classes. You have to remove the TIMEN library from the project and add TIMEN as a project.
IMPORTANT: When you finish debugging you have to recompile TIMEN an relink it as a library instead of as a project in TIMEN_CONSUMER.



