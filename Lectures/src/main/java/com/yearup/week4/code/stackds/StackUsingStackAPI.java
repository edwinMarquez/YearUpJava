{\rtf1\ansi\ansicpg1252\cocoartf2639
\cocoatextscaling0\cocoaplatform0{\fonttbl\f0\fmodern\fcharset0 Courier;\f1\fmodern\fcharset0 Courier-Oblique;}
{\colortbl;\red255\green255\blue255;\red0\green29\blue164;\red9\green9\blue9;\red10\green79\blue103;
\red121\green121\blue121;\red17\green109\blue18;\red114\green0\blue130;}
{\*\expandedcolortbl;;\csgenericrgb\c0\c11373\c64314;\csgenericrgb\c3529\c3529\c3529;\csgenericrgb\c3922\c30980\c40392;
\csgenericrgb\c47451\c47451\c47451;\csgenericrgb\c6667\c42745\c7059;\csgenericrgb\c44706\c0\c50980;}
\margl1440\margr1440\vieww11520\viewh8400\viewkind0
\pard\tx560\tx1120\tx1680\tx2240\tx2800\tx3360\tx3920\tx4480\tx5040\tx5600\tx6160\tx6720\pardirnatural\partightenfactor0

\f0\fs26 \cf2 import \cf0 java.util.Stack\cf3 ;\
\
\cf2 class \cf0 StackUsingStackAPI \cf3 \{\
    \cf2 public static void \cf4 main\cf3 (\cf0 String\cf3 [] args) \{\
\
        
\f1\i \cf5 // create an object of Stack class\
        
\f0\i0 \cf0 Stack\cf3 <\cf0 String\cf3 > \cf0 animals \cf3 = \cf2 new \cf3 Stack<>();\
\
        
\f1\i \cf5 // push elements to top of stack\
        
\f0\i0 \cf0 animals\cf3 .push(\cf6 "Dog"\cf3 );\
        \cf0 animals\cf3 .push(\cf6 "Horse"\cf3 );\
        \cf0 animals\cf3 .push(\cf6 "Cat"\cf3 );\
        \cf0 System\cf3 .
\f1\i \cf7 out
\f0\i0 \cf3 .println(\cf6 "Stack: " \cf3 + \cf0 animals\cf3 );\
\
        
\f1\i \cf5 // pop element from top of stack\
        
\f0\i0 \cf0 animals\cf3 .pop();\
        \cf0 System\cf3 .
\f1\i \cf7 out
\f0\i0 \cf3 .println(\cf6 "Stack after pop: " \cf3 + \cf0 animals\cf3 );\
    \}\
\}\
}