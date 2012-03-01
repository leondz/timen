grammar TIMENruleGrammar;

@lexer::header{package grammar;}
@parser::header{
    package grammar;
    import TIMEN.*;
}

/*------------------------------------------------------------------
 * PARSER RULES
 *------------------------------------------------------------------*/

run[TIMEN timen, TIMEX_Instance timex_object] returns [String value]:
	rules[$timen, $timex_object] (SEPARATOR)? EOF {$value=$rules.value;};

rules[TIMEN timen, TIMEX_Instance timex_object] returns [String value] :
	e=rule[$timen, $timex_object] {$value=$e.value;} (SEPARATOR e=rule[$timen, $timex_object] {$value+=$e.value;})*   ;

rule[TIMEN timen, TIMEX_Instance timex_object] returns [String value] :
	(e=print {$value = $e.value;}
	|e=pat[$timex_object] {$value = $e.value;}
	|e=dct_year[$timex_object] {$value = $e.value;}
	|e=dct_month[$timex_object] {$value = $e.value;}
	|e=dct_day[$timex_object] {$value = $e.value;}
	|e=to_year[$timex_object] {$value = $e.value;}
	|e=to_month[$timen,$timex_object] {$value = $e.value;}
	|e=to_day[$timen,$timex_object] {$value = $e.value;}
	|e=add[$timen, $timex_object] {$value = $e.value;}
	|e=date_weekday[$timen, $timex_object] {$value = $e.value;}
	|e=date_month[$timen, $timex_object] {$value = $e.value;}
	|e=date_month_day[$timen, $timex_object] {$value = $e.value;}
	|e=to_period[$timen, $timex_object] {$value = $e.value;}
	|e=get_tod[$timen, timex_object] {$value = $e.value;}
	);

to_period[TIMEN timen, TIMEX_Instance timex_object] returns [String value]:
	'TO_PERIOD' '(' num=pat[$timex_object] ',' tunit=pat[$timex_object] ')' {$value = $timen.to_period($num.value,$tunit.value);}
        | 'TO_PERIOD' '(' INT ',' tunit=pat[$timex_object] ')' {$value = $timen.to_period($INT.text,$tunit.value);}
        | 'TO_PERIOD' '(' STRING ',' tunit=pat[$timex_object] ')' {$value = $timen.to_period($STRING.text,$tunit.value);}
        ;


get_tod[TIMEN timen, TIMEX_Instance timex_object] returns [String value]:
	'GET_TOD' '(' e=pat[$timex_object] ')' {$value = $timen.getTOD($e.value);};


dct_year[TIMEX_Instance timex_object] returns [String value]:
	'DCTYEAR'  {$value = $timex_object.dct.getYear();};

dct_month[TIMEX_Instance timex_object] returns [String value]:
	'DCTMONTH'  {$value = $timex_object.dct.getMonth();};

dct_day[TIMEX_Instance timex_object] returns [String value]:
	'DCTDAY'  {$value = $timex_object.dct.getDay();};

to_year[TIMEX_Instance timex_object] returns [String value]:
	'TO_YEAR' '(' e=pat[$timex_object] ')' {$value = TIMEN.to_year($e.value,$timex_object);};

to_month[TIMEN timen, TIMEX_Instance timex_object] returns [String value]:
	'TO_MONTH' '(' e=pat[$timex_object] ')' {$value = $timen.to_month($e.value);};

to_day[TIMEN timen, TIMEX_Instance timex_object] returns [String value]:
	'TO_DAY' '(' e=pat[$timex_object] ')' {$value = $timen.to_day($e.value);};


add[TIMEN timen, TIMEX_Instance timex_object] returns [String value]:	
         'ADD' '(' r=REFERENCE       ',' GRANULARITY           ',' i=intnumber ')' {$value = $timen.add($REFERENCE.text,$GRANULARITY.text,$i.value, $timex_object);}
        | 'ADD' '(' r=REFERENCE       ',' e=pat[$timex_object] ',' i=intnumber ')' {$value = $timen.add($REFERENCE.text,$e.value,$i.value, $timex_object);}
        | 'ADD' '(' r=REFERENCE       ',' e=pat[$timex_object] ',' i=toint[$timex_object] ')' {$value = $timen.add($REFERENCE.text,$e.value,$i.value, $timex_object);}
        | 'ADD' '(' r=REFERENCE       ',' e=pat[$timex_object] ',' i=tonegativeint[$timex_object] ')' {$value = $timen.add($REFERENCE.text,$e.value,$i.value, $timex_object);}
        | 'ADD_WEEKDAY' '(' r=REFERENCE       ',' e=pat[$timex_object] ',' i=intnumber ')' {$value = $timen.add_weekday($REFERENCE.text,$e.value,$i.value, $timex_object);}
        ;




date_weekday[TIMEN timen, TIMEX_Instance timex_object] returns [String value]:
         'DATE_WEEKDAY' '(' r=REFERENCE       ',' e=pat[$timex_object] ')' {$value = $timen.date_weekday($REFERENCE.text,$e.value, $timex_object);};


date_month[TIMEN timen, TIMEX_Instance timex_object] returns [String value]:
         'DATE_MONTH' '(' r=REFERENCE       ',' e=pat[$timex_object] ')' {$value = $timen.date_month($REFERENCE.text,$e.value, $timex_object);};

date_month_day[TIMEN timen, TIMEX_Instance timex_object] returns [String value]:
         'DATE_MONTH_DAY' '(' r=REFERENCE       ',' e=pat[$timex_object] ',' d=pat[$timex_object] ')' {$value = $timen.date_month_day($REFERENCE.text,$e.value,$d.value, $timex_object);};


pat[TIMEX_Instance timex_object] returns [String value]:
	'PAT' '(' e=intnumber ')' {$value = $timex_object.getNormTextArr()[$e.value];};

tonegativeint[TIMEX_Instance timex_object] returns [int value]:
    'NEGATIVEINT(' e=pat[$timex_object] ')' {$value = Integer.parseInt("-"+$e.value);};

toint[TIMEX_Instance timex_object] returns [int value]:
    'INT(' e=pat[$timex_object] ')' {$value = Integer.parseInt($e.value);};


print returns [String value]:
    STRING {$value = $STRING.text;};
    /*STRING {$value = $STRING.substring(1,$STRING.lenght()-1);};*/

intnumber returns [int value]:
	INT {$value = Integer.parseInt($INT.text);};




/*------------------------------------------------------------------
 * LEXER RULES
 *------------------------------------------------------------------*/

REFERENCE: ('DCT'|'REFTIME');

GRANULARITY: ('millennium'|'century'|'decade'|'year'|'semester'|'quarter'|'month'|'week'|'day'|'hour'|'minute'|'second');
        /*'milenio'|'siglo'|'década'|'año'|'semestre'|'trimestre'|'mes'|'semana'|'día'|'hora'|'minuto'|'segundo'*/

/*TAG: '<' (~'>')+ '>' {state.text = $text.substring(1, $text.length()-1);};*/

STRING: '"' (~'"')+ '"' {state.text = $text.substring(1, $text.length()-1);};  //( '-'|'P' | 'PRESENT_REF' | 'PAST_REF' | 'FUTURE_REF' | 'TNI'); //('a'..'z'|'A'..'Z'|'-')+; // we prefer controlling strings

INT		: ('+'|'-')? '0'..'9'+;

SEPARATOR : 	';';

COMMENT:   	'//' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;}| '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;};

WHITESPACE : 	( '\t' | ' ' | '\r' | '\n'| '\u000C' )+ 	{ $channel = HIDDEN; } ;

