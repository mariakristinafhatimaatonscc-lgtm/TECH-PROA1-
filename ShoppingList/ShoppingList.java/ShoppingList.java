// shopping_list.java
// Author: MARIA KRISTINA FHATIMA I. ATON
// Program Title: Shopping List Program
// Description: A simple Java program that stores and searches shopping list items.

import java.util.Scanner;

public class shopping_list {
  public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
        String[] shoppingList = new String[5];
          int count = 0;

         System.out.println("Enter up to 5 items to buy:")for (int i = 0; i < 5; i++) {
                                                        System.out.print("> ");
                                                                    String item = input.nextLine().trim();
                                                                                if (item.isEmpty()) {
                                                                                                break;
                                                                                                            }
                                                                                                                        shoppingList[count] = item;
                                                                                                                                    count++;
                                                                                                                                            }

                                                                                                                                                    System.out.println("\nYour shopping list:");
                                                                                                                                                            for (int i = 0; i < count; i++) {
                                                                                                                                                                        System.out.print(shoppingList[i]);
                                                                                                                                                                                    if (i < count - 1) System.out.print(", ");
                                                                                                                                                                                            }

                                                                                                                                                                                                    System.out.println("\n\nYou entered " + count + " items.");

                                                                                                                                                                                                            System.out.print("\nSearch for an item: ");
                                                                                                                                                                                                                    String search = input.nextLine().trim();
                                                                                                                                                                                                                            boolean found = false;

                                                                                                                                                                                                                                    for (int i = 0; i < count; i++) {
                                                                                                                                                                                                                                                if (shoppingList[i].equalsIgnoreCase(search)) {
                                                                                                                                                                                                                                                                found = true;
                                                                                                                                                                                                                                                                                break;
                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                    }

                                                                                                                                                                                                                                                                                                            if (found) {
                                                                                                                                                                                                                                                                                                                        System.out.println("✔ " + search + " is in your shopping list!");
                                                                                                                                                                                                                                                                                                                                } else {
                                                                                                                                                                                                                                                                                                                                            System.out.println("✘ " + search + " is not in your shopping list.");
                                                                                                                                                                                                                                                                                                                                                    }

                                                                                                                                                                                                                                                                                                                                                            input.close();
                                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                                }

