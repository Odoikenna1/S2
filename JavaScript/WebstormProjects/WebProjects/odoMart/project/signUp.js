const BASE_URL = 'http://localhost:8080/';
const CREATE_USER_URL = `${BASE_URL}api/odomart/signup`;

const FORM_EL = document.querySelector('.form');
const SIGN_UP_BUTTON = document.querySelector('.createAccountElementBtn');
SIGN_UP_BUTTON.addEventListener('click', (event)=>{
    event.preventDefault();

    const firstName = document.querySelector('.firstName').value;
    const lastName = document.querySelector('.lastName').value;
    const email = document.querySelector('.email').value;
    const password = document.querySelector('.password').value;
    const SIGN_UP_REQUEST = {
        "firstName" : firstName,
        "lastName" : lastName,
        "email": email,
        "password": password,
    }
    console.log(SIGN_UP_REQUEST);
    createNewUser(SIGN_UP_REQUEST).then(response => redirectUserToHomePage(response))
});

async function createNewUser(SIGN_UP_REQUEST){
    const { firstName, lastName, email, password} = SIGN_UP_REQUEST;
    try{
        const response = await fetch(CREATE_USER_URL, {
            method: "POST",
            headers: {"Content-Type" : "application/json"},
            timeout: 10000,
            body: JSON.stringify({
                "firstName": firstName,
                "lastName": lastName,
                "email": email,
                "password": password
            })
        });

        if(!response.ok){
            throw new Error(`Response status: ${response.status}`);
        }
        const responseInJson = await response.json();
        console.log(responseInJson);
        return responseInJson;
    }catch(error){
        console.log(error);
    }
}

function redirectUserToHomePage(response){
    console.log({ response });
    const { userId: id } = response.response;
    console.log({ id });
    if (id) {
        console.log({id})
        window.location.href = `homeinsession.html?userId=${id}`;
    } else {
        console.log("UserId not found in the response.")
    }
}
