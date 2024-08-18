const BASE_URL = 'http://localhost:8080/';
const ODOMART_SEARCH_URL = `${BASE_URL}"api/odomart/productsearch"`
const searchButton = document.querySelector('.inputContainer span')
searchButton.addEventListener('click', event => {
    event.preventDefault();
    let inputValue = document.querySelector('.inputContainer input').value;
    console.log(inputValue)
    searchProducts().then(r => console.log(r));
    // redirectToProductListings();
});

function redirectToProductListings(){
    window.location.href = 'productsListings.html';
}
 async function searchProducts(){
    try{
        const response = await fetch(`${ODOMART_SEARCH_URL}`,{
            headers: {'Content-Type': 'application/json'}
        });
        if(!response.ok){
            throw new Error(`Response status: ${response.status}`);
        }
        const json = await response.json();
        console.log(json);
    } catch (error){
        console.log(error);
    }

 }
const displayProducts = (product) => {
     const {title, price} = product;
     console.log(product)
    const divTag = document.createElement('div');
     divTag.classList.add('displayRow');
     divTag.innerHTML = `
     <div class="productShowGlass">
                    <img src="./assets/categoryImages/4.png" alt="">
                    <div class="productDescriptionArea">
                        <div class="description">
                            <span>Brown suede boots</span>
                        </div>
                        <div class="price">
                            <span>$15.35</span>
                        </div>
                        <div class="ratingStars">
                            <span class="fa fa-star checked"></span>
                            <span class="fa fa-star checked"></span>
                            <span class="fa fa-star checked"></span>
                            <span class="fa fa-star"></span>
                            <span class="fa fa-star"></span>
                        </div>
                        <div class="addToCartBtn">
                            <a href="#"><span>Add To Cart</span></a>
                        </div>
                    </div>
                </div>
     `
}
const ADD_TO_CART = document.querySelector('.addToCartBtn');
ADD_TO_CART.addEventListener('click', (event) => {
    
})