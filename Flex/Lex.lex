/* scanner for Example Solution 

Usage : 
1 - lex Lex.lex
2- gcc lex.yy.c
3- ./a.out

*/

%{
/* need this for the call to atof() below */
#include <math.h>
%}

DIGIT    [0-9]
ID       [a-zA-z][a-zA-Z0-9]*

%%


{DIGIT}+    {
            printf( "An integer: %s (%d)\n", yytext,
                    atoi( yytext ) );
            }


{DIGIT}+"."{DIGIT}*        {
            printf( "A float: %s (%g)\n", yytext,
                    atof( yytext ) );
            }


{DIGIT}++{ID}  printf( "An Error Happened: %s\n", yytext );



if|then|start|finish|repeat|var|int|float|do|read|print|void|return|dummy|program        {
            printf( "T_%s : %s\n",yytext,yytext);
            }


{ID}        printf( "An identifier: %s\n", yytext );



"="  printf( "T_Assign : %s\n", yytext );

"=="  printf( "T_Equal : %s\n", yytext );

"=!="  printf( "T_StrangeNotEqual : %s\n", yytext );

"=>"  printf( "T_LesserEqual : %s\n", yytext );


%%


int yywrap(){} 

int main(int argc, char **argv) 
{  
// Explanation: 
// yywrap() - wraps the above rule section 
/* yyin - takes the file pointer  
          which contains the input*/
/* yylex() - this is the main flex function 
          which runs the Rule Section*/
// yytext is the text in the buffer 
  
// Uncomment the lines below  
// to take input from file 
// FILE *fp; 
// char filename[50]; 
// printf("Enter the filename: \n"); 
// scanf("%s",filename); 
// fp = fopen(filename,"r"); 
// yyin = fp; 
  
yylex(); 
return 0; 
}