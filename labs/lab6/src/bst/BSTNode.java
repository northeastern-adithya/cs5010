package bst;

import java.util.function.Consumer;

/**
 * This represents the operations on all nodes of a binary search tree.
 */
public interface BSTNode<T extends Comparable<T>> {
  /**
   * Inserts new data into the tree rooted at this node, and return the
   * resulting tree.
   *
   * @param data the data to be inserted
   * @return the tree after inserting the data.
   */
  BSTNode<T> insert(T data);

  /**
   * Determine and return the minimum element in the tree rooted at this node.
   *
   * @return the minimum element in the tree
   * @throws NothingThereException if the tree does not have any data
   */
  T minimum() throws NothingThereException;

  /**
   * Determine and return the maximum element in the tree rooted at this node.
   *
   * @return the maximum element in the tree.
   * @throws NothingThereException if the tree does not have any data
   */
  T maximum() throws NothingThereException;

  /**
   * Search to see if the specific data is present in the tree rooted at this
   * node.
   *
   * @param data data to be searched
   * @return true if data is present in the tree, false otherwise
   */
  boolean contains(T data);

  /**
   * Returns a string containing all the data in the tree rooted at this node.
   * The string is formatted as d1 d2 ... dn.
   *
   * @return the string representation of the tree
   */
  String toString();

  /**
   * Traverse the tree rooted at this node in preorder and
   * apply the consumer at each piece of data.
   *
   * @param consumer the function object to be applied at each piece of data
   */
  void preorder(Consumer<T> consumer);

  /**
   * Traverse the tree rooted at this node in postorder
   * and apply the consumer at each piece of data.
   *
   * @param consumer the function object to be applied at each piece of data
   */
  void postorder(Consumer<T> consumer);

  /**
   * Create an exact copy (in terms of data and structure) of the tree rooted at this node.
   *
   * @return the copy of the tree rooted here
   */
  BSTNode<T> copy();

  /**
   * Determine whether the tree rooted at this node is the same
   * (content and structure wise) as the tree rooted
   * at the given node.
   *
   * @param other the root of the other tree
   * @return true if the two trees are the same, false otherwise
   */
  boolean same(BSTNode<T> other);


}
