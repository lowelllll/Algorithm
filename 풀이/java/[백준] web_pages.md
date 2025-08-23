## [backjoon] 5076 web pages

### 문제

You probably know about HTML, the mark up language used to create Web pages. HTML code contains a number of tags which are expected to follow certain rules.

In this problem we will be concerned with two of these rules:

1. Every opening tag has to have a corresponding closing tag
2. All tags must be properly nested.

Tags are marked by angled brackets which contain a keyword, such as `<body>` or `<strong>`. These are opening tags, the corresponding closing tags having `/` before the keyword, ie `</body>` and `</strong>`. It is possible for a tag to be both opening and closing, such as `<br />`, which complies with rule 1.

To be properly nested, if a tag is opened inside another tag, it must be closed before the other tag closes. For example

- `<body> <strong> </strong> </body>` is properly nested
- `<body> <strong> </body> </strong>` is not, and breaks rule 2.

If there are no tags present, the text complies with both rules.

Attributes may be present within an opening tag, such as

`<a href="http://www.nzprogcontest.org.nz">This is a link</a>`

The closing tag has only to match the keyword, not the attributes.

#### 입력

Input will consist of a number of lines of HTML code, each line containing from 0 to 255 characters. The last line will contain a single # character – do not process this line. Within the text of each line will be zero or more tags. No angle bracket will be present unless it is part of a properly formed tag.

Determine whether or not the HTML meets the rules specified above.

#### 출력

Output will consist of a single line for each line of input. The line will contain either the word legal, or the word illegal.

#### 예제 입력

```
<body> <strong>Oops, this is</body> naughty </strong>
<body> <strong>Hello</strong> <br /> </body>
Just text, no tags.
<p> Oh dear, we are missing something.
<a href="http://www.nzprogcontest.org.nz">This is a link</a>
#
```

#### 예제 출력

```
illegal
legal
legal
illegal
legal
```

### 내 풀이

```java
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String html = sc.nextLine();
            if (html.equals("#")) break;
            System.out.println(isIllegal(html)?"legal":"illegal");
        }
        ;
    }

    public static Boolean isIllegal (String input) {
        TagStack tags = new TagStack();
        char[] html = input.toCharArray();
        boolean result = true;

        String tag = "";
        boolean isOpenTag = false; // 열린 태그
        boolean isCloseTag = false; // 닫힌 태그
        boolean isTagName = false; // 태그면 true, 속성이면 false

        for (int i=0; i<html.length; i++) {
            if(isCloseTag || isOpenTag) { // 태그 안
                if (html[i] == '>') {
                    // pop, push, 무시,
                    if (html[i-1] == '/') {
                        tag = "";
                        isOpenTag = false;
                        isCloseTag = false;
                        isTagName = false;
                    } else if (isOpenTag) {
                        tags.push(tag);
                        tag = "";
                        isOpenTag = false;
                        isTagName = false;
                        continue;
                    } else if (isCloseTag) {
                        if (tags.top().equals(tag)) {
                            tags.pop();
                            tag = "";
                            isCloseTag = false;
                            isTagName = false;
                            continue;
                        } else {
                            result = false;
                            return result;
                        }
                    }
                } else {
                    if (html[i] == ' ') isTagName = false;
                    if (isTagName && html[i] != '/') {
                        tag += html[i];
                    }
                }
            } else {
                if (html[i] == '<') {
                    if (html[i+1] == '/') isCloseTag = true;
                    else isOpenTag = true;

                    isTagName = true;
                }
            }
        }

        if (tags.empty()!=1) result = false;
        return result;
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

### 풀이 방법

스택 활용보단.. 문자열 다루기 or 조건문 연습? 귀찮은 문제였당 

## refer

[web pages](https://www.acmicpc.net/problem/5076)

