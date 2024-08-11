// const API_KEY = "\"api/v1/post\"";
// const titleField = document.querySelector('.formTitleField');
// const contentField = document.querySelector('.formContentField');

// const addBtn = document.querySelector('.submitBtn');
//
// const postContainer = document.querySelector('.postContainer');

const form = document.querySelector('.childContainer form');
const addPostBtn = document.querySelector('.submitBtn');
let postObject ={
    "title": "",
    "content": ""
}
const titleValue =  document.querySelector('.titleInputField');
const contentValue = document.querySelector('.contentInputField');
form.addEventListener('keyup', (event) => {
    event.preventDefault();
    const titleValue =  document.querySelector('.titleInputField').value;
    const contentValue = document.querySelector('.contentInputField').value;

     postObject ={
        "title": titleValue,
        "content": contentValue
    }
    console.log(postObject)
})
addPostBtn.addEventListener('click', (event) => {
    event.preventDefault();
    if(titleValue.value !== ""){
        postRequest(postObject)
    }
})

function postRequest(postObject){
    const titleValue= postObject.title
    const contentValue = postObject.content
    axios.post('http://localhost:8080/api/v1/post', {title: titleValue, content: contentValue})
         .then(response => console.log(response))
         .catch(error => console.log(error))
}





