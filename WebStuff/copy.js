
var date = new Date();
var year = date.getFullYear();
var month = date.getMonth() + 1;
var day = date.getDate();
document.getElementById("copy").innerText= ("copyright" + (month) + "-" + (day) + "-" + (year));