```
package Stack;

import java.util.LinkedList;

public class WebPage {
    public static void main (String[] args) {

    }

    public Boolean isIllegal (String input) {
        TagStack tags = new TagStack();
        char[] html = input.toCharArray();
        String tag = "";
        Boolean isOneTag = false;
        for (int i=0; i<html.length; i++) {
            if(html[i] == '<') {
                tag += html[i];
            } else if(html[i] == '>') {
                tag += html[i];
                tags.push(tag);
                tag = "";
            }
        }
    }
}


class TagStack {
    LinkedList<String> stack = new LinkedList<>();

    public int size() {
        return stack.size();
    }

    public int empty() {
        return size()>0?0:1;
    }
    public void push (String data) {
        stack.addLast(data);
    }

    public String pop() {
        if (empty()==1) return "0";
        String data = stack.getLast();
        stack.removeLast();
        return data;
    }

    public String top() {
        if (empty()==1) return "0";
        return stack.getLast();
    }
}
```

