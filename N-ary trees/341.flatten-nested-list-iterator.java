import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @lc app=leetcode id=341 lang=java
 *
 * [341] Flatten Nested List Iterator
 */

// @lc code=start
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 * // @return true if this NestedInteger holds a single integer, rather than a
 * nested list.
 * public boolean isInteger();
 *
 * // @return the single integer that this NestedInteger holds, if it holds a
 * single integer
 * // Return null if this NestedInteger holds a nested list
 * public Integer getInteger();
 *
 * // @return the nested list that this NestedInteger holds, if it holds a
 * nested list
 * // Return empty list if this NestedInteger holds a single integer
 * public List<NestedInteger> getList();
 * }
 */

// Method 1: DFS + Queue
// public class NestedIterator implements Iterator<Integer> {
// Deque<Integer> queue = new ArrayDeque<>();

// public NestedIterator(List<NestedInteger> nestedList) {
// dfs(nestedList);
// }

// @Override
// public Integer next() {
// if (hasNext()) {
// return queue.poll();
// }
// return -1;
// }

// @Override
// public boolean hasNext() {
// return !queue.isEmpty();
// }

// private void dfs(List<NestedInteger> nestedList) {
// for (NestedInteger item : nestedList) {
// if (item.isInteger()) {
// queue.offer(item.getInteger());
// } else {
// dfs(item.getList());
// }
// }
// }
// }

// Method 2: Stack, unfold the list if necessary (in the function hasNext())
public class NestedIterator implements Iterator<Integer> {
    Deque<NestedInteger> stack = new ArrayDeque<>();

    public NestedIterator(List<NestedInteger> nestedList) {
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        if (hasNext()) {
            return stack.pop().getInteger();
        }
        return -1;
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            NestedInteger cur = stack.peek();
            if (cur.isInteger()) {
                return true;
            }
            stack.pop();
            for (int i = cur.getList().size() - 1; i >= 0; i--) {
                stack.push(cur.getList().get(i));
            }
        }
        return false;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
// @lc code=end
