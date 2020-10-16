const createForm = document.getElementById("createForm");

createForm.addEventListener("submit", function(event) {
    event.preventDefault();
    console.log(this.name);
    const data = {
        name: this.name.value,
        flavour: this.flavour.value,
        type: this.type.value
    }

   const req =  fetch("http://localhost:8082/createRecipe", {
       method: "POST",
       body: JSON.stringify(data),
       headers: {
       'Content-Type': "application/json"
}
   }).then(response =>{
       return response.json();
   }).then(data => {
           getAll();
           this.reset();
       }).catch(error => console.log(error));
});
function getAll() {
    fetch ("http://localhost:8082/getAll")
    .then(repsonse => response.json())
    .then(recipes => {
        console.log("Recipes: ", recipes);
        readDiv.innerHtml = '';
        recipes.forEach(function(recipes){
            console.log(recipes);

            const card = document.createElement('div');
            card.className = "card";
            readDiv.appendChild(card);
    
            const cardBody = document.createElement('div');
            cardBody.className = "card-body";
            card.appendChild(cardBody);

        const title = document.createElement("h5");
        title.className = "card-title";
        title.innerText = "Name: " + recipes.name;
        cardbody.appendChild(title);

        const flavour = document.createElement("p");
        flavour.className = "card-body";
        flavour.innerText = "flavour: " + recipes.flavour;
        cardbody.appendChild(flavour);

        const type = document.createElement("p");
        type.className = "card-body";
        type.innerText = "Type: " + recipes.type;
        cardbody.appendChild(type);
        
        const deleteButton = document.createElement("a");
        deleteButton.className = 'card-link';
        deleteButton.innerText = "Delete";
        deleteButton.addEventListener("click", function(){
            deleteRecipe(recipe.id);

        })
        cardBody.appendChild(deleteButton);
        })
        
    }).catch(error => console.log(error));
}
getAll();

function deleteRecipe(id){
    fetch  ("http://localhost:8082/recipe/deleteRecipe/" + id,{
        method:"DELETE"
}).then (response => {
    console.log(response);
    getAll
    }).catch (error => console.error(error));

}
