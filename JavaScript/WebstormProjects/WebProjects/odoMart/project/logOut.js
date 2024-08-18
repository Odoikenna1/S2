const BASE_URL = 'http://localhost:8080/'
const LOG_OUT_URL =  `${BASE_URL}api/ododmart/exit`
const LogOut = document.getElementById('logOutBtn');
LogOut.addEventListener('click', (event)=>{
    alert("I've been clicked")
    logUserOut().then(r => console.log(r))
})
async function logUserOut(){
    const response = await fetch(LOG_OUT_URL, {
        method: 'Post',
        timeout: 10000,
    })
        .then(response => {
            if(response.ok){
                console.log("logOut successful.")
                sessionStorage.clear();
                window.location.href = 'home.html';
            } else{
                console.log("logOut failed.")
            }

    }).catch(error => {
            console.error('Error:', error)
        })
}