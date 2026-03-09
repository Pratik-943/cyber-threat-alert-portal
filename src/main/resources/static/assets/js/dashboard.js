document.addEventListener("DOMContentLoaded", function(){

const map = L.map('map').setView([20.2961,85.8245],4)

L.tileLayer(
'https://{s}.basemaps.cartocdn.com/dark_all/{z}/{x}/{y}{r}.png'
).addTo(map)

fetch("/api/threats")
.then(res=>res.json())
.then(data=>{

data.forEach(t=>{

if(t.latitude && t.longitude){

L.circleMarker(
[t.latitude,t.longitude],
{
radius:8,
color:"orange",
fillColor:"orange",
fillOpacity:0.8
}
).addTo(map)

}

})

})

})