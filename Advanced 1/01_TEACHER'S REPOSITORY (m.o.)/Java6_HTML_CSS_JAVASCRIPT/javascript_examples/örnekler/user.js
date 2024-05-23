/*
user nesnesi yaratalım json obje 

user==>
name
surName
username
age
password
interest => 1den falz ilgi alanı olacak
expenses ==> 1den fazla harcaması olacak
address==> isiminde bir nesne içerecek 
country
city

*/

let user = {
  name: "Mustafa",
  surName: "Ozturk",
  age: 35,
  username: "musti",
  password: "123",
  interest: ["Müzik", "Seyahat", "Spor"],
  expenses: [100, 60, 25, 850, 158],
  address: {
    country: "U.S.A",
    city: "New York",
  },
};

console.log(user.address.city);
//user.username = "musty";
console.log(user);

// 1- harcamalr toplamını getiren fonksiyonu yazalım

function getExpenses() {
  let sum = 0;
  user.expenses.forEach((x) => {
    sum += x;
  });
  return sum;
}
const sumExpenses = () => {
  let sum = user.expenses.reduce((x, y) => x + y);
  return sum;
};
console.log(getExpenses());
console.log(sumExpenses());

const sumExpenses2 = (array) => {
  let sum = array.reduce((x, y) => x + y);
  return sum;
};
console.log(sumExpenses2(user.expenses));

function getLastTwoExp() {
  let index = user.expenses.length - 2;
  return user.expenses.slice(index);
}
function getLastTwoExp2() {
  return user.expenses.slice(-2);
}

function getLastTwoExp3() {
  return user.expenses.reverse().slice(0, 2);
}

console.log(getLastTwoExp());
console.log(getLastTwoExp2());
console.log(getLastTwoExp3());
console.log(user.expenses);
// interest listesine 1.elamandan itibaren dışarıdan girdiğim 2 ilgi alnını eklemek istiyorum

function addIntersts(interest1, interest2) {
  user.interest.splice(1, 0, interest1, interest2);
}

addIntersts("Sinema", "Dans");

console.log(user.interest);

function login() {
  let username = document.getElementById("myusername").value;
  let pasword = document.getElementById("mypassword").value;
  if (username === user.username && pasword === user.password) {
    setTimeout(getHomePage, 3000);
    // setTimeout(()=>{
    //   window.location.href = "/javascript_examples/%C3%B6rnekler/home.html";
    // }, 3000);
  } else {
    alert("giriş basarısız");
  }
}

const getHomePage = () => {
  window.location.href = "/javascript_examples/%C3%B6rnekler/home.html";
};

function login2() {
  let form = document.querySelector("form");

  console.log(form);
  if (
    form.username.value === user.username &&
    form.password.value === user.password
  ) {
    alert("giriş başarılı");
    // setTimeout(getHomePage, 2000);
    // setTimeout(()=>{
    //   window.location.href = "/javascript_examples/%C3%B6rnekler/home.html";
    // }, 3000);
  } else {
    alert("giriş basarısız");
  }
}
let form = document.querySelector("form");
function login3(e) {
  console.log(e.target);
  e.preventDefault();
  console.log(form);
  if (
    e.target.username.value === user.username &&
    form.password.value === user.password
  ) {
    alert("giriş başarılı");
    // setTimeout(getHomePage, 2000);
    // setTimeout(()=>{
    //   window.location.href = "/javascript_examples/%C3%B6rnekler/home.html";
    // }, 3000);
  } else {
    alert("giriş basarısız");
  }
}

let button = document.querySelector(".loginbutton");

form.addEventListener("submit", login3);

//button.addEventListener("click", login2);
