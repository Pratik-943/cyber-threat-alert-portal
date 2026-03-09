const map = L.map('map').setView([20.2961,85.8245],4)

L.tileLayer(
'https://{s}.basemaps.cartocdn.com/dark_all/{z}/{x}/{y}{r}.png'
).addTo(map)

fetch("/api/public/threats")
.then(res=>res.json())
.then(data=>{

const recentContainer=document.getElementById("recentThreats")
const topContainer=document.getElementById("topThreats")

recentContainer.innerHTML=""
topContainer.innerHTML=""

data.slice(0,6).forEach(threat=>{

const card=document.createElement("div")

card.className="threat-card"

card.innerHTML=`
<h3>${threat.title}</h3>
<p>${threat.description}</p>
<p>Severity: ${threat.severity}</p>
`

recentContainer.appendChild(card)

})


data.slice(0,10).forEach(threat=>{

const card=document.createElement("div")

card.className="threat-card"

card.innerHTML=`
<h4>${threat.title}</h4>
<p>${threat.severity}</p>
`

topContainer.appendChild(card)

})


data.forEach(threat=>{

if(threat.latitude && threat.longitude){

let color="green"

if(threat.severity==="MEDIUM") color="yellow"
if(threat.severity==="HIGH") color="orange"
if(threat.severity==="CRITICAL") color="red"

L.circleMarker(
[threat.latitude,threat.longitude],
{
radius:8,
color:color,
fillColor:color,
fillOpacity:0.8
}
).addTo(map)

}

})

})