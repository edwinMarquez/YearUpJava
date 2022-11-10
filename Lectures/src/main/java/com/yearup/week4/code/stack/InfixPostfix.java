{\rtf1\ansi\ansicpg1252\cocoartf2639
\cocoatextscaling0\cocoaplatform0{\fonttbl\f0\fmodern\fcharset0 Courier;\f1\fmodern\fcharset0 Courier-Oblique;}
{\colortbl;\red255\green255\blue255;\red0\green29\blue164;\red9\green9\blue9;\red10\green79\blue103;
\red17\green109\blue18;\red121\green121\blue121;\red18\green51\blue230;\red114\green0\blue130;}
{\*\expandedcolortbl;;\csgenericrgb\c0\c11373\c64314;\csgenericrgb\c3529\c3529\c3529;\csgenericrgb\c3922\c30980\c40392;
\csgenericrgb\c6667\c42745\c7059;\csgenericrgb\c47451\c47451\c47451;\csgenericrgb\c7059\c20000\c90196;\csgenericrgb\c44706\c0\c50980;}
\margl1440\margr1440\vieww11520\viewh8400\viewkind0
\pard\tx560\tx1120\tx1680\tx2240\tx2800\tx3360\tx3920\tx4480\tx5040\tx5600\tx6160\tx6720\pardirnatural\partightenfactor0

\f0\fs26 \cf2 import \cf0 java.util.Stack\cf3 ;\
\
\cf2 class \cf0 InfixPostfix \cf3 \{\
\
    \cf2 public static int \cf4 precedence\cf3 (\cf2 char \cf3 x)\{\
\
        \cf2 if\cf3 (x==\cf5 '^'\cf3 )\{   
\f1\i \cf6 // highest precedence\
            
\f0\i0 \cf2 return \cf7 2\cf3 ;\
        \}\
        \cf2 else if\cf3 (x==\cf5 '*' \cf3 || x==\cf5 '/'\cf3 )\{\
            \cf2 return \cf7 1\cf3 ;                        
\f1\i \cf6 // second-highest precedence\
        
\f0\i0 \cf3 \}\
        \cf2 else if\cf3 (x==\cf5 '+' \cf3 || x==\cf5 '-'\cf3 )\{\
            
\f1\i \cf6 // lowest precedence\
\
            
\f0\i0 \cf2 return \cf7 0\cf3 ;\
        \}\
        \cf2 return \cf3 -\cf7 1\cf3 ; 
\f1\i \cf6 // not an operator\
    
\f0\i0 \cf3 \}\
\
    \cf2 public static \cf0 String \cf4 InfixToPostfix\cf3 (\cf0 String \cf3 str)\{\
\
        \cf0 Stack\cf3 <\cf0 Character\cf3 > \cf0 stk\cf3 = \cf2 new \cf3 Stack<>();             
\f1\i \cf6 // used for converting infix to postfix\
\
        
\f0\i0 \cf0 String ans\cf3 =\cf5 ""\cf3 ;                
\f1\i \cf6 // string containing our final answer\
\
        
\f0\i0 \cf2 int \cf0 n\cf3 = str.length();\
\
        \cf2 for \cf3 (\cf2 int \cf0 i \cf3 = \cf7 0\cf3 ; \cf0 i \cf3 <\cf0 n \cf3 ; \cf0 i\cf3 ++) \{\
            \cf2 char \cf0 x\cf3 = str.charAt(\cf0 i\cf3 );\
\
            \cf2 if\cf3 (\cf0 x\cf3 >=\cf5 '0' \cf3 && \cf0 x\cf3 <=\cf5 '9'\cf3 )\{\
                \cf0 ans\cf3 +=\cf0 x\cf3 ;\
            \}\
\
            \cf2 else if\cf3 (\cf0 x\cf3 ==\cf5 '('\cf3 )\{     
\f1\i \cf6 // push directly in the stack\
                
\f0\i0 \cf0 stk\cf3 .push(\cf5 '('\cf3 );\
            \}\
            \cf2 else if\cf3 (\cf0 x\cf3 ==\cf5 ')'\cf3 )\{\
\
                \cf2 while\cf3 (!\cf0 stk\cf3 .isEmpty() && \cf0 stk\cf3 .peek()!=\cf5 '('\cf3 )\{          
\f1\i \cf6 // keep popping till opening bracket is found\
                    
\f0\i0 \cf0 ans\cf3 +=\cf0 stk\cf3 .pop();\
                \}\
                \cf2 if\cf3 (!\cf0 stk\cf3 .isEmpty())\{\
                    \cf0 stk\cf3 .pop();\
                \}\
\
            \}\
            \cf2 else\cf3 \{\
\
                \cf2 while\cf3 (!\cf0 stk\cf3 .isEmpty() && 
\f1\i precedence
\f0\i0 (\cf0 stk\cf3 .peek())>=
\f1\i precedence
\f0\i0 (\cf0 x\cf3 ))\{    
\f1\i \cf6 // remove all higher precedence values\
                    
\f0\i0 \cf0 ans\cf3 +=\cf0 stk\cf3 .pop();\
                \}\
                \cf0 stk\cf3 .push(\cf0 x\cf3 );\
\
            \}\
        \}\
        \cf2 while\cf3 (!\cf0 stk\cf3 .isEmpty())\{\
            \cf0 ans\cf3 +=\cf0 stk\cf3 .pop();\
        \}\
        \cf2 return \cf0 ans\cf3 ;\
    \}\
\
    \cf2 public static void \cf4 main\cf3 (\cf0 String\cf3 [] args) \{\
        \cf0 System\cf3 .
\f1\i \cf8 out
\f0\i0 \cf3 .println(\cf0 InfixPostfix\cf3 .
\f1\i InfixToPostfix
\f0\i0 (\cf5 "m*n+(p-q)+r"\cf3 ));\
\
    \}\
\}\
\
}