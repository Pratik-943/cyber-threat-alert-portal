const form = document.getElementById("loginForm");

if (form) {

form.addEventListener("submit", async function(e){

e.preventDefault();

const username = document.getElementById("username").value;
const password = document.getElementById("password").value;

const response = await fetch("/api/auth/login", {

method: "POST",

headers:{
"Content-Type":"application/json"
},

body: JSON.stringify({
username: username,
password: password
})

});

if(response.ok){

const data = await response.json();

localStorage.setItem("user", JSON.stringify(data));

const role = data.role.name || data.role;

if(role === "ROLE_ADMIN"){
window.location = "/admin.html";
}else{
window.location = "/dashboard.html";
}

}else{

alert("Invalid credentials");

}

});

}