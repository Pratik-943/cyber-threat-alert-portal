document.addEventListener("DOMContentLoaded", function(){

const map = L.map('map').setView([20.2961,85.8245],4)

L.tileLayer(
'https://{s}.basemaps.cartocdn.com/dark_all/{z}/{x}/{y}{r}.png'
).addTo(map)

loadThreats()

function loadThreats(){

fetch("/api/threats")
.then(res=>res.json())
.then(data=>{

const table=document.getElementById("threatList")
table.innerHTML=""

data.forEach(t=>{

const row=document.createElement("tr")

row.innerHTML=`
<td>${t.id}</td>
<td>${t.title}</td>
<td>${t.severity}</td>
<td>${t.city || "Unknown"}</td>
<td>
<button onclick="deleteThreat(${t.id})">Delete</button>
</td>
`

table.appendChild(row)

if(t.latitude && t.longitude){

L.circleMarker(
[t.latitude,t.longitude],
{
radius:8,
color:"red",
fillColor:"red",
fillOpacity:0.8
}
).addTo(map)

}

})

})

}

window.addThreat=function(){

const threat={

title:document.getElementById("title").value,
description:document.getElementById("description").value,
severity:document.getElementById("severity").value,
latitude:document.getElementById("latitude").value,
longitude:document.getElementById("longitude").value,
city:document.getElementById("city").value,
country:document.getElementById("country").value

}

fetch("/api/admin/threats",{
method:"POST",
headers:{'Content-Type':'application/json'},
body:JSON.stringify(threat)
})
.then(()=>location.reload())

}

window.deleteThreat=function(id){

fetch("/api/admin/threats/"+id,{
method:"DELETE"
})
.then(()=>location.reload())

}

})