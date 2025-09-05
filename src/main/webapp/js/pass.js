const login = document.getElementById("login");
const p = document.getElementById("p");
p.onmouseover = function(){
    p.style.border = "4px solid white";
}
p.onmouseout = function(){
    p.style.border = "3px solid white";
}
p.onmousedown = function(){
    p.style.border = "3px solid white";
}
p.onmouseup = function(){
    p.style.border = "4px solid white";
}
login.onmouseover = function(){
    login.style.border = "4px solid white";
}
login.onmouseout = function(){
    login.style.border = "";
}
login.onmousedown = function(){
    login.style.border = "2px solid white";
}
login.onmouseup = function(){
    login.style.border = "4px solid white";
}