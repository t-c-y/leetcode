package com.leetcode.code.problemset;

import com.leetcode.code.pojo.NestedInteger;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Leetcode341 {
    /**
     *
     * 给你一个嵌套的整型列表。请你设计一个迭代器，使其能够遍历这个整型列表中的所有整数。
     * 列表中的每一项或者为一个整数，或者是另一个列表。其中列表的元素也可能是整数或是其他列表。
     *
     * 示例 1:
     * 输入: [[1,1],2,[1,1]]
     * 输出: [1,1,2,1,1]
     * 解释: 通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,1,2,1,1]。
     *
     * 示例 2:
     * 输入: [1,[4,[6]]]
     * 输出: [1,4,6]
     * 解释: 通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,4,6]。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/flatten-nested-list-iterator
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * 解题思路：https://blog.csdn.net/tcy1429920627/article/details/114269022
     *
     */


    public class NestedIterator implements Iterator<Integer> {

        private LinkedList<NestedInteger> list;

        public NestedIterator(List<NestedInteger> nestedList) {
            if(nestedList != null && nestedList.size() > 0) {
                list = new LinkedList<>(nestedList);
            }
        }

        @Override
        public Integer next() {
            return list.remove(0).getInteger();
        }

        @Override
        public boolean hasNext() {
            //这个位置要注意空数组的情况
            while(list != null && !list.isEmpty() && !list.get(0).isInteger()) {
                List<NestedInteger> l = list.remove(0).getList();
                for(int i = l.size()-1; i >=0; i--) {
                    list.addFirst(l.get(i));
                }
            }
            return (list != null && !list.isEmpty());
        }

    }


}
