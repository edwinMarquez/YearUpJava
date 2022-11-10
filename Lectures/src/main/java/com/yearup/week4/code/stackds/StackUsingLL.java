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

\f0\i\fs26 \cf2 //https://www.javaguides.net/2018/09/stack-implementation-using-linked-list-in-java.html\
\

\f1\i0 \cf3 import \cf0 java.util.EmptyStackException\cf4 ;\
\
\cf3 public class \cf0 StackUsingLL \cf4 \{\
    \cf3 private int \cf5 length\cf4 ; 
\f0\i \cf2 // indicates the size of the linked list\
    
\f1\i0 \cf3 private \cf0 ListNode \cf5 top\cf4 ;\
\
    
\f0\i \cf2 // Constructor: Creates an empty stack.\
    
\f1\i0 \cf3 public \cf6 StackUsingLL\cf4 () \{\
        \cf5 length \cf4 = \cf7 0\cf4 ;\
        \cf5 top \cf4 = \cf3 null\cf4 ;\
    \}\
\
    
\f0\i \cf2 // Adds the specified data to the top of this stack.\
    
\f1\i0 \cf3 public void \cf6 push\cf4 (\cf3 int \cf4 data) \{\
        \cf0 ListNode temp \cf4 = \cf3 new \cf4 ListNode(data);\
        \cf0 temp\cf4 .setNext(\cf5 top\cf4 );\
        \cf5 top \cf4 = \cf0 temp\cf4 ;\
        \cf5 length\cf4 ++;\
    \}\
\
    
\f0\i \cf2 // Removes the data at the top of this stack and returns a\
    // reference to it. Throws an EmptyStackException if the stack\
    // is empty.\
    
\f1\i0 \cf3 public int \cf6 pop\cf4 () \cf3 throws \cf0 EmptyStackException \cf4 \{\
        \cf3 if \cf4 (isEmpty())\
            \cf3 throw new \cf4 EmptyStackException();\
        \cf3 int \cf0 result \cf4 = \cf5 top\cf4 .getData();\
        \cf5 top \cf4 = \cf5 top\cf4 .getNext();\
        \cf5 length\cf4 --;\
        \cf3 return \cf0 result\cf4 ;\
    \}\
\
    
\f0\i \cf2 // Returns a reference to the data at the top of this stack.\
    // The data is not removed from the stack. Throws an\
    // EmptyStackException if the stack is empty.\
    
\f1\i0 \cf3 public int \cf6 peek\cf4 () \cf3 throws \cf0 EmptyStackException \cf4 \{\
        \cf3 if \cf4 (isEmpty())\
            \cf3 throw new \cf4 EmptyStackException();\
\
        \cf3 return \cf5 top\cf4 .getData();\
    \}\
\
    
\f0\i \cf2 // Returns true if this stack is empty and false otherwise.\
    
\f1\i0 \cf3 public boolean \cf6 isEmpty\cf4 () \{\
        \cf3 return \cf4 (\cf5 length \cf4 == \cf7 0\cf4 );\
    \}\
\
    
\f0\i \cf2 // Returns the number of elements in the stack.\
    
\f1\i0 \cf3 public int \cf6 size\cf4 () \{\
        \cf3 return \cf5 length\cf4 ;\
    \}\
\
    
\f0\i \cf2 // Returns a string representation of this stack.\
    
\f1\i0 \cf3 public \cf0 String \cf6 toString\cf4 () \{\
        \cf0 String result \cf4 = \cf8 ""\cf4 ;\
        \cf0 ListNode current \cf4 = \cf5 top\cf4 ;\
        \cf3 while \cf4 (\cf0 current \cf4 != \cf3 null\cf4 ) \{\
            \cf0 result \cf4 = \cf0 result \cf4 + \cf0 current\cf4 .toString() + \cf8 "\cf9 \\n\cf8 "\cf4 ;\
            \cf0 current \cf4 = \cf0 current\cf4 .getNext();\
        \}\
\
        \cf3 return \cf0 result\cf4 ;\
    \}\
\
    \cf3 public static void \cf6 main\cf4 (\cf0 String\cf4 [] args) \{\
        \cf0 StackUsingLL stack \cf4 = \cf3 new \cf4 StackUsingLL();\
        \cf0 stack\cf4 .push(\cf7 1\cf4 );\
        \cf0 stack\cf4 .push(\cf7 2\cf4 );\
        \cf0 stack\cf4 .push(\cf7 3\cf4 );\
        \cf0 stack\cf4 .push(\cf7 4\cf4 );\
        \cf0 stack\cf4 .push(\cf7 5\cf4 );\
\
        \cf0 stack\cf4 .toString();\
\
        \cf0 System\cf4 .
\f0\i \cf5 out
\f1\i0 \cf4 .println(\cf8 "Size of stack is: " \cf4 + \cf0 stack\cf4 .size());\
\
        \cf0 stack\cf4 .pop();\
        \cf0 stack\cf4 .pop();\
\
        \cf0 System\cf4 .
\f0\i \cf5 out
\f1\i0 \cf4 .println(\cf8 "Top element of stack is: " \cf4 + \cf0 stack\cf4 .peek());\
    \}\
\
\
    \cf3 class \cf0 ListNode \cf4 \{\
        \cf3 public \cf0 ListNode \cf5 next\cf4 ;\
        \cf3 public int \cf5 data\cf4 ;\
\
        
\f0\i \cf2 // Creates an empty node.\
        
\f1\i0 \cf3 public \cf6 ListNode\cf4 () \{\
            \cf5 next \cf4 = \cf3 null\cf4 ;\
            \cf5 data \cf4 = \cf0 Integer\cf4 .
\f0\i \cf5 MIN_VALUE
\f1\i0 \cf4 ;\
        \}\
\
        
\f0\i \cf2 // Creates a node storing the specified data.\
        
\f1\i0 \cf3 public \cf6 ListNode\cf4 (\cf3 int \cf4 data) \{\
            \cf5 next \cf4 = \cf3 null\cf4 ;\
            \cf3 this\cf4 .\cf5 data \cf4 = data;\
        \}\
\
        
\f0\i \cf2 // Returns the node that follows this one.\
        
\f1\i0 \cf3 public \cf0 ListNode \cf6 getNext\cf4 () \{\
            \cf3 return \cf5 next\cf4 ;\
        \}\
\
        
\f0\i \cf2 // Sets the node that follows this one.\
        
\f1\i0 \cf3 public void \cf6 setNext\cf4 (\cf0 ListNode \cf4 node) \{\
            \cf5 next \cf4 = node;\
        \}\
\
        
\f0\i \cf2 // Returns the data stored in this node.\
        
\f1\i0 \cf3 public int \cf6 getData\cf4 () \{\
            \cf3 return \cf5 data\cf4 ;\
        \}\
\
        
\f0\i \cf2 // Sets the data stored in this node.\
        
\f1\i0 \cf3 public void \cf6 setdata\cf4 (\cf3 int \cf4 elem) \{\
            \cf5 data \cf4 = elem;\
        \}\
\
        
\f0\i \cf2 // Sets the data stored in this node.\
        
\f1\i0 \cf3 public \cf0 String \cf6 toString\cf4 () \{\
            \cf3 return \cf0 Integer\cf4 .
\f0\i toString
\f1\i0 (\cf5 data\cf4 );\
        \}\
    \}\
\}\
}