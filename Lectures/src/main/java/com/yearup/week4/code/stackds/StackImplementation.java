{\rtf1\ansi\ansicpg1252\cocoartf2639
\cocoatextscaling0\cocoaplatform0{\fonttbl\f0\fmodern\fcharset0 Courier-Oblique;\f1\fmodern\fcharset0 Courier;}
{\colortbl;\red255\green255\blue255;\red121\green121\blue121;\red0\green29\blue164;\red9\green9\blue9;
\red114\green0\blue130;\red10\green79\blue103;\red18\green51\blue230;\red17\green109\blue18;\red2\green34\blue149;
}
{\*\expandedcolortbl;;\csgenericrgb\c47451\c47451\c47451;\csgenericrgb\c0\c11373\c64314;\csgenericrgb\c3529\c3529\c3529;
\csgenericrgb\c44706\c0\c50980;\csgenericrgb\c3922\c30980\c40392;\csgenericrgb\c7059\c20000\c90196;\csgenericrgb\c6667\c42745\c7059;\csgenericrgb\c784\c13333\c58431;
}
\margl1440\margr1440\vieww11520\viewh8400\viewkind0
\pard\tx560\tx1120\tx1680\tx2240\tx2800\tx3360\tx3920\tx4480\tx5040\tx5600\tx6160\tx6720\pardirnatural\partightenfactor0

\f0\i\fs26 \cf2 //https://www.programiz.com/java-programming/examples/stack-implementation\
\

\f1\i0 \cf3 class \cf0 StackImplementation \cf4 \{\
\
    
\f0\i \cf2 // store elements of stack\
    
\f1\i0 \cf3 private int \cf5 arr\cf4 [];\
    
\f0\i \cf2 // represent top of stack\
    
\f1\i0 \cf3 private int \cf5 top\cf4 ;\
    
\f0\i \cf2 // total capacity of the stack\
    
\f1\i0 \cf3 private int \cf5 capacity\cf4 ;\
\
\
    
\f0\i \cf2 // Creating a stack\
    
\f1\i0 \cf6 StackImplementation\cf4 (\cf3 int \cf4 size) \{\
        
\f0\i \cf2 // initialize the array\
        // initialize the stack variables\
        
\f1\i0 \cf5 arr \cf4 = \cf3 new int\cf4 [size];\
        \cf5 capacity \cf4 = size;\
        \cf5 top \cf4 = -\cf7 1\cf4 ;\
    \}\
\
\
    
\f0\i \cf2 // push elements to the top of stack\
    
\f1\i0 \cf3 public void \cf6 push\cf4 (\cf3 int \cf4 x) \{\
        \cf3 if \cf4 (isFull()) \{\
            \cf0 System\cf4 .
\f0\i \cf5 out
\f1\i0 \cf4 .println(\cf8 "Stack OverFlow"\cf4 );\
\
            
\f0\i \cf2 // terminates the program\
            
\f1\i0 \cf0 System\cf4 .
\f0\i exit
\f1\i0 (\cf7 1\cf4 );\
        \}\
\
        
\f0\i \cf2 // insert element on top of stack\
        
\f1\i0 \cf0 System\cf4 .
\f0\i \cf5 out
\f1\i0 \cf4 .println(\cf8 "Inserting " \cf4 + x);\
        \cf5 arr\cf4 [++\cf5 top\cf4 ] = x;\
    \}\
\
    
\f0\i \cf2 // pop elements from top of stack\
    
\f1\i0 \cf3 public int \cf6 pop\cf4 () \{\
\
        
\f0\i \cf2 // if stack is empty\
        // no element to pop\
        
\f1\i0 \cf3 if \cf4 (isEmpty()) \{\
            \cf0 System\cf4 .
\f0\i \cf5 out
\f1\i0 \cf4 .println(\cf8 "STACK EMPTY"\cf4 );\
            
\f0\i \cf2 // terminates the program\
            
\f1\i0 \cf0 System\cf4 .
\f0\i exit
\f1\i0 (\cf7 1\cf4 );\
        \}\
\
        
\f0\i \cf2 // pop element from top of stack\
        
\f1\i0 \cf3 return \cf5 arr\cf4 [\cf5 top\cf4 --];\
    \}\
\
    
\f0\i \cf2 // return size of the stack\
    
\f1\i0 \cf3 public int \cf6 getSize\cf4 () \{\
        \cf3 return \cf5 top \cf4 + \cf7 1\cf4 ;\
    \}\
\
\
    
\f0\i \cf2 // check if the stack is empty\
    
\f1\i0 \cf3 public \cf0 Boolean \cf6 isEmpty\cf4 () \{\
        \cf3 return \cf5 top \cf4 == -\cf7 1\cf4 ;\
    \}\
\
\
    
\f0\i \cf2 // check if the stack is full\
    
\f1\i0 \cf3 public \cf0 Boolean \cf6 isFull\cf4 () \{\
        \cf3 return \cf5 top \cf4 == \cf5 capacity \cf4 - \cf7 1\cf4 ;\
    \}\
\
\
    
\f0\i \cf2 // display elements of stack\
    
\f1\i0 \cf3 public void \cf6 printStack\cf4 () \{\
        \cf3 for \cf4 (\cf3 int \cf0 i \cf4 = \cf7 0\cf4 ; \cf0 i \cf4 <= \cf5 top\cf4 ; \cf0 i\cf4 ++) \{\
            \cf0 System\cf4 .
\f0\i \cf5 out
\f1\i0 \cf4 .print(\cf5 arr\cf4 [\cf0 i\cf4 ] + \cf8 ", "\cf4 );\
        \}\
    \}\
\
    \cf3 public static void \cf6 main\cf4 (\cf0 String\cf4 [] args) \{\
        \cf0 StackImplementation stack \cf4 = \cf3 new \cf4 StackImplementation(\cf7 5\cf4 );\
\
        \cf0 stack\cf4 .push(\cf7 1\cf4 );\
        \cf0 stack\cf4 .push(\cf7 2\cf4 );\
        \cf0 stack\cf4 .push(\cf7 3\cf4 );\
\
        \cf0 System\cf4 .
\f0\i \cf5 out
\f1\i0 \cf4 .print(\cf8 "Stack: "\cf4 );\
        \cf0 stack\cf4 .printStack();\
\
        
\f0\i \cf2 // remove element from stack\
        
\f1\i0 \cf0 stack\cf4 .pop();\
        \cf0 System\cf4 .
\f0\i \cf5 out
\f1\i0 \cf4 .println(\cf8 "\cf9 \\n\cf8 After popping out"\cf4 );\
        \cf0 stack\cf4 .printStack();\
    \}\
\}\
}