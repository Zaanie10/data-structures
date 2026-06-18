public class TestHeapSort {
   /**
    * A test method
    */
   public static void main(String[] args) {

      Integer[] list = {-44, -5, -3, 3, 3, 1, -4, 0, 1, 2, 4, 5, 53};

      System.out.print("Original List:\t");  //print original list
      for (int i = 0; i < list.length; i++)
         System.out.print(list[i] + " ");

      HeapSort.heapSort(list);  //sort the list

      System.out.print("\n\nSorted List:\t");  //print original list
      for (int i = 0; i < list.length; i++)
         System.out.print(list[i] + " ");

      // Test Case: Character array
      Character[] list2 = {'w', 'f', 'A', 'X', 'T', 'Q', 'k', 's', '8', 'L', '3', 'b', 'A', 'w', 's', 'H', 'j', 'K', 'L'};

      // Print the original unsorted list of characters
      System.out.print("\n\nOriginal List2:\t");
      for (Character c : list2)
         System.out.print(c + " ");

      // Call generic heapSort method on the character array
      HeapSort.heapSort(list2);

      // Print the sorted list to verify correctness
      System.out.print("\nSorted List2:\t");
      for (Character c : list2)
         System.out.print(c + " ");

      // Test Case: String array
      String[] list3 = {"Data", "Structure", "Is", "Hard", "Computing", "Class", "To Pass"};

      // Print the original unsorted list of strings
      System.out.print("\n\nOriginal List3:\t");
      for (String s : list3)
         System.out.print(s + " ");

      // Sort the string array using the generic heap sort
      HeapSort.heapSort(list3);

      // Print the sorted result of the string array
      System.out.print("\nSorted List3:\t");
      for (String s : list3)
         System.out.print(s + " ");

   }
}
