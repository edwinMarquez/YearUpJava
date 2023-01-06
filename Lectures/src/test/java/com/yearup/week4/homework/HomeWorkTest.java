package com.yearup.week4.homework;

import com.yearup.week4.code.linkedlist.SinglyLinkedList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HomeWorkTest {

    @Test
    public void reverseString_whenEmpty_returnsEmpty(){
        String input = "";
        char[] out = HomeWork.reverseString("");
        assertEquals(input, String.valueOf(out));
    }
    @Test
    public void reverseString_whenNonEmpty_returnsReversed(){
        String input = "Hello";
        char[] out = HomeWork.reverseString(input);
        assertEquals("olleH", String.valueOf(out));
    }

    @Test
    public void removeDuplicates_whenNoDuplicates_returnsSame(){
        int[] input = new int[]{1,2,3,4,5};
        int[] out = HomeWork.removeDuplicates(input);
        assertArrayEquals(input, out);
    }
    @Test
    public void removeDuplicates_whenDuplicates_returnsUnique(){
        int[] input = new int[]{5,4,4,7,8,7,5};
        int[] out = HomeWork.removeDuplicates(input);
        assertArrayEquals(new int[]{5,4,7,8}, out);
    }

    @Test
    public void reverseLinkedList_whenValidList_returnsReversed(){
        SinglyLinkedList<Integer> input = new SinglyLinkedList<>();
        input.addLast(1);
        input.addLast(2);
        input.addLast(3);
        input.addLast(4);
        SinglyLinkedList<Integer> out = HomeWork.reverseLinkedList(input);
        assertEquals(out, "[head -> 4 -> 3 -> 2 -> 1 <- tail]");
    }

    @Test
    public void TicTacToeWinner_whenXisWinninig_returnsX(){
        char[][] inp = new char[][]{{'X','X','O'},
                                    {'O','X','O'},
                                    {'O','O','X'}};
        char out = HomeWork.ticTacToeWinner(inp);
        assertEquals('X', out);
    }
    @Test
    public void TicTacToeWinner_whenOisWinninig_returnsO(){
        char[][] inp = new char[][]{{'X','X','O'},
                                    {'O','O','O'},
                                    {'X','O','X'}};
        char out = HomeWork.ticTacToeWinner(inp);
        assertEquals('O', out);
    }
    @Test
    public void TicTacToeWinner_whenDraw_returnsD(){
        char[][] inp = new char[][]{{'X','X','O'},
                                    {'O','O','X'},
                                    {'X','O','X'}};
        char out = HomeWork.ticTacToeWinner(inp);
        assertEquals('D', out);
    }
}