package org.tjc;

import org.graalvm.polyglot.Context;

public class Main {
    public static void main(String[] args) {

        Context polyglot = Context.create();
        polyglot.eval("python", """
                def create_and_return_array():
                    array = [1, 2, 3, 4, 5]
                    Returning the array
                    return array
                """);

    }
}