const user=JSON.parse(localStorage.getItem("user"))

if(!user || user.role!=="ROLE_ADMIN"){

window.location="/login.html"

}

function logout(){

localStorage.removeItem("user")

window.location="/login.html"

}