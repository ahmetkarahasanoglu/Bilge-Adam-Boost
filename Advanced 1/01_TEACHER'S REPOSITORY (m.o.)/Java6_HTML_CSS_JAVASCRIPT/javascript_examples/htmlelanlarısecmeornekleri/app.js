let value;

value = document.getElementsByTagName("p");

console.log(value);
value = document.getElementsByTagName("div");
console.log(value);
value = document.getElementsByTagName("a");
console.log(value[0].href);
console.log(value[1].href);
value = document.getElementById("link");
console.log(value);
value = document.getElementsByClassName("kutu");
console.log(value);
value = document.querySelector(".kutu");
console.log(value);
value = document.querySelector("p"); // ilk buldugu degeri getirir
console.log(value.innerText);
value = document.querySelectorAll("p");
value.forEach((x) => console.log(x.innerText));
console.log(value.innerText);
value = document.querySelectorAll("a");
value[1].setAttribute("href", "htps://www.youtube.com");
console.log(value[1]);
value = document.querySelector("#link");

value = document.querySelector(".kutu");
value.textContent += "yeni değer";
//value.innerText = "en yeni değer";
console.log(value.innerHTML);
let dersno = 101;
value.innerHTML =
  "<ul><li> React" + dersno + "</li><li>Java</li><li>.Net</li></ul>";

value.innerHTML = `<ul>
                        <li>React ${dersno}</li>
                        <li>Java ${dersno + 1}</li>
                        <li>.Net ${dersno + 2} </li>
                </ul>     
`;

function elemanYarat() {
  //

  let kutu = document.querySelector(".kutu");
  let newlink = document.createElement("a");
  newlink.id = "newlink";
  newlink.className = "mylink";
  newlink.href = "https://www.instagram.com";
  newlink.target = "_blank";
  newlink.textContent = "instagram linki";
  newlink.setAttribute("style", "color:red;");
  newlink.classList.add("yeni_sınıf");
  newlink.classList.remove("myLink");
  //newlink.setAttribute("style", "display:none");
  console.log(newlink);
  kutu.appendChild(newlink);
}

function toplama() {
  console.log("sonuc= " + (5 + 7));
  return 5 + 7;
}
function toplama2(a, b) {
  a = a + 2;
  b = b + 5;
  return a + b;
}
console.log(toplama());
let sonuc = toplama2(5, 7);
console.log(sonuc);

const toplama3 = function () {
  return 5 + 10;
};

console.log(toplama3());

const toplama4 = (a, b) => {
  console.log(a + b);
  return a + b;
};
console.log(toplama4(25, 40));
