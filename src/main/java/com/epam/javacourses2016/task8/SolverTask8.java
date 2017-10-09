package com.epam.javacourses2016.task8;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Задана строка, возможно содержащая символы '(', ')', '[', ']', '{', '}'.
 * Проверить правильность расстановки скобок.
 * При реализации использовать стек.
 */
public class SolverTask8 {

    /**
     * Проверяет правильность расстановки скобок.
     * Правильная расстановка:
     * 1) Каждой открывающей скобке соответствует закрывающая того же типа.
     * 2) Нет пересечения областей, обрамленных скобками.
     *
     * @param string Анализируемая строка.
     * @return true - скобки расставлены верно, иначе - false.
     */
    public boolean isNormalBrackets(String string) {
        PriorityQueue<Character> stack = new PriorityQueue<>();
        char[] chars = string.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (isBracket(chars[i])) {
                if (isOpeningBracket(chars[i])) {
                    stack.add(chars[i]);
                } else {
                    if (stack.size() == 0) {
                        return false;
                    }
                    if (!matchBrackets(stack.peek(), chars[i])) {
                        return false;
                    }
                    stack.poll();
                }
            }
        }
        return true;
    }

    private boolean isBracket(char c) {
        return (isClosingBracket(c) || isOpeningBracket(c));
    }

    private boolean isClosingBracket(char c) {
        switch (c) {
            case ')':
                return true;
            case ']':
                return true;
            case '}':
                return true;
        }
        return false;
    }

    private boolean isOpeningBracket(char c) {
        switch (c) {
            case '(':
                return true;
            case '[':
                return true;
            case '{':
                return true;
        }
        return false;
    }

    private boolean matchBrackets(char opening, char closing) {
        if ((opening == '(' && closing == ')')
                || (opening == '[' && closing == ']')
                || (opening == '{' && closing == '}')) {
            return true;
        }
        return false;
    }
}
