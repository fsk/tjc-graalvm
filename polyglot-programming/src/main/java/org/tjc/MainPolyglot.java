package org.tjc;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Value;


public class MainPolyglot {
    private static final String PYTHON = "python";
    private static final String JAVASCRIPT = "js";

    public static void main(String[] args) {
        try (Context context = Context.create()) {
            // Python: Create an array
            String createArrayWithPython = """
                    def createAndReturnArray():
                        array = [52, 35, 23, 41, 17]
                        return array
                    """;
            context.eval(PYTHON, createArrayWithPython);

            // Get Python array
            Value pyArray = context
                    .getBindings(PYTHON)
                    .getMember("createAndReturnArray")
                    .execute();

            // Pass the Python array to JavaScript
            context.getBindings(JAVASCRIPT).putMember("arr", pyArray);

            // JavaScript: Bubble sort implementation
            String jsBubbleSort = """
                    function bubbleSort(arr) {
                        let len = arr.length;
                        for (let i = 0; i < len; i++) {
                            for (let j = 0; j < len - i - 1; j++) {
                                if (arr[j] > arr[j + 1]) {
                                    let temp = arr[j];
                                    arr[j] = arr[j + 1];
                                    arr[j + 1] = temp;
                                }
                            }
                        }
                        return arr;
                    }
                    bubbleSort(arr);
                    """;
            Value sortedArray = context.eval(JAVASCRIPT, jsBubbleSort);


            context.getBindings(PYTHON).putMember("sortedArray", sortedArray);

            context.eval(PYTHON, """
                    print(sortedArray)
                    """);
        }
    }
}