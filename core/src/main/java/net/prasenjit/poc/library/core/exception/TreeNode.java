package net.prasenjit.poc.library.core.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RequiredArgsConstructor
public class TreeNode<T> {
    @Getter
    private final T data;
    @Getter
    private final List<TreeNode<T>> children = new ArrayList<>();
    @Getter
    private TreeNode<T> parent;

    public void addChild(T childData) {
        TreeNode<T> child = new TreeNode<>(childData, this);
        this.children.add(child);
    }

    public void removeChild(TreeNode<T> child) {
        child.parent = null;
        this.children.remove(child);
    }

    public boolean isRoot() {
        return this.parent == null;
    }

    public boolean isLeaf() {
        return this.children.isEmpty();
    }

    public int size() {
        int count = 1;
        for (TreeNode<T> child : children) {
            count += child.size();
        }
        return count;
    }

    public int height() {
        if (this.isLeaf()) {
            return 0;
        } else {
            int maxHeight = 0;
            for (TreeNode<T> child : children) {
                maxHeight = Math.max(maxHeight, child.height());
            }
            return maxHeight + 1;
        }
    }
}

