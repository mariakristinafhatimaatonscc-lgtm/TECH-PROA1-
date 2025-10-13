// shopping_list.js
// Author: MARIA KRISTINA FHATIMA I. ATON
// Description: JavaScript version of the Shopping List Program

const prompt = require("prompt-sync")();

let shoppingList = [];
console.log("Enter up to 5 items to buy:");

for (let i = 0; i < 5; i++) {
    let item = prompt("> ").trim();
        if (item === "") break;
            shoppingList.push(item);
            }

            console.log("\nYour shopping list:");
            console.log(shoppingList.join(", "));

            console.log(`\nYou entered ${shoppingList.length} items.`);

            let search = prompt("\nSearch for an item: ").trim();
            if (shoppingList.map(i => i.toLowerCase()).includes(search.toLowerCase())) {
                console.log(`✔ ${search} is in your shopping list!`);
                } else {
                    console.log(`✘ ${search} is not in your shopping list.`);
                    }