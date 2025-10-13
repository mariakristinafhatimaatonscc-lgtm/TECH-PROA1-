# shopping_list.py
# Author: MARIA KRISTINA FHATIMA I. ATON
# Description: Python version of the Shopping List Program

print("Enter up to 5 items to buy:")
shopping_list = []

for i in range(5):
    item = input("> ").strip()
        if item == "":
                break
                    shopping_list.append(item)

                    print("\nYour shopping list:")
                    print(", ".join(shopping_list))

                    print(f"\nYou entered {len(shopping_list)} items.")

                    search = input("\nSearch for an item: ").strip()
                    if search.lower() in [i.lower() for i in shopping_list]:
                        print(f"✔ {search} is in your shopping list!")
                        else:
                            print(f"✘ {search} is not in your shopping list.")