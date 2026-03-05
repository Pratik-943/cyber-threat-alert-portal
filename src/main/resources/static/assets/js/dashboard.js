const user=JSON.parse(localStorage.getItem("user"))

if(!user){

window.location="/login.html"

}

document.getElementById("welcome").innerText="Welcome "+user.username

function logout(){

localStorage.removeItem("user")

window.location="/login.html"

}