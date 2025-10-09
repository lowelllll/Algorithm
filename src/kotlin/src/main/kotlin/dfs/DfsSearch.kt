package dfs

private data class Node(
    val data: Long,
    var lt: Node? = null,
    var rt: Node? = null,
)

private class Tree(
    val root: Node,
    val strategy: String
) {
    fun dfs(node: Node?) {
        if (node == null) return

        when (strategy) {
            "pre" -> { // 전위
                print("${node.data} ")
                dfs(node.lt)
                dfs(node.rt)
            }
            "post" -> { // 후위
                dfs(node.lt)
                dfs(node.rt)
                print("${node.data} ")
            }
            else -> { // 중위
                dfs(node.lt)
                print("${node.data} ")
                dfs(node.rt)
            }
        }
        // 후위 순회

    }
}

fun main() {
    val tree = Tree(Node(1), "pre");
    tree.root.lt = Node(2);
    tree.root.lt?.lt = Node(4);
    tree.root.lt?.rt = Node(5);
    tree.root.rt = Node(3);
    tree.root.rt?.lt = Node(6);
    tree.root.rt?.rt = Node(7);

    tree.dfs(tree.root)
}