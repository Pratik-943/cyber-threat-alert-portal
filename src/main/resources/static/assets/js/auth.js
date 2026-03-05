async function login(){

const username=document.getElementById("username").value
const password=document.getElementById("password").value

const res=await fetch("/api/auth/login",{

method:"POST",

headers:{
"Content-Type":"application/json"
},

body:JSON.stringify({
username:username,
password:password
})

})

if(res.ok){

const data=await res.json()

localStorage.setItem("user",JSON.stringify(data))

if(data.role==="ROLE_ADMIN"){
window.location="/admin.html"
}else{
window.location="/dashboard.html"
}

}else{

alert("Invalid credentials")

}

}



async function register(){

const username=document.getElementById("username").value
const password=document.getElementById("password").value

const res=await fetch("/api/auth/register",{

method:"POST",

headers:{
"Content-Type":"application/json"
},

body:JSON.stringify({
username:username,
password:password
})

})

if(res.ok){

alert("User created")

window.location="/login.html"

}else{

alert("Register failed")

}

}