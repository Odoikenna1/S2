// const API_KEY = "\"api/v1/post\"";
// const titleField = document.querySelector('.formTitleField');
// const contentField = document.querySelector('.formContentField');

// const addBtn = document.querySelector('.submitBtn');
//
// const postContainer = document.querySelector('.postContainer');

const form = document.querySelector('.blogForm');
console.log(form)
let postObject ={
    "title": "",
    "content": ""
}
// const titleValue =  document.querySelector('.titleInputField');
// const contentValue = document.querySelector('.contentInputField');
form.addEventListener('submit', (event) => {
    event.preventDefault();
    const titleValue =  document.querySelector('.titleInputField');
    const contentValue = document.querySelector('.contentInputField');
    console.log(titleValue);
    console.log(contentValue);

     postObject ={
        "title": titleValue,
        "content": contentValue
    }
    console.log(postObject);
    postRequest(postObject);
})

function postRequest(postObject){
    axios.post('http://localhost:8080/api/v1/post', {data: postObject})
         .then(response => console.log(response))
         .catch(error => console.log(error))
}





