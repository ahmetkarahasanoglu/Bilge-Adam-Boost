/* Bir Json objesi olarak user nesnesi oluşturalım.

user ==>

name
surname
age
password
intereset -> (1'den fazla ilgi alanı olacak)
expenses -> (1'den fazla harcaması olacak)
address -> (nesne olarak)
country
city

 */

user = {
    "username": "ahm",
    "name": "Ahmet",
    "surname": "Kara",
    "age": 30,
    "password": "123",
    "interest": ["cycling", "swimming", "running"],
    "expenses": [250, 400, 500, 700, 900, 1000],
    "address": {
        "country": "Türkiye",
        "city": "İstanbul",
        "avenue": "Meşe Cd.",
        "street": "Kozalak Sk.",
        "doorNumber": 15
    }
}

console.log(user.address.city);
user.address.city = "Ankara"; // we're changing the value
console.log(user.address.city);

// 1- Harcamalar toplamını getiren fonksiyonu yazalım.
function sumExpenses() {
    let total = 0;
    // for(let el of user.expenses) {
    //     total += el;
    // }
    // --- Or:
    // user.expenses.forEach((x) => total+=x);
    // --- Or:
    total = user.expenses.reduce((total, acc) => total + acc);
    return total;
}
console.log("Toplam harcamalar: " + sumExpenses());

// 2- Son iki harcamayı getiren fonksiyonu yazalım:
function getLastTwoExpense2() {
    let expArr = user.expenses;
    return expArr.slice(expArr.length-2, expArr.length);
}
console.log(getLastTwoExpense2());

// 3- interest listesine 1. index'ten itibaren dışarıdan girdiğim 2 ilgi alanını eklemek istiyorum:
function addToInterests(a, b) {
    user.interest.splice(1,0, a, b);    
}
addToInterests("camping", "movies");
console.log(user.interest);

// ***Using an array as a parameter in the declaration of a funciton.
//    '--> Javascript has a dynamic structure, we don't specify the argument as an array in the paranthesis in the declaration of a function.
// function addToInterests2(arr) {
//     for(let i=arr.length-1; i>=0; i--) {
//         user.interest.unshift(arr[i]);
//     }
// }
// let myArr = ["music", "reading"];
// addToInterests(myArr);
// console.log(user.interest);

function login(event) { // login.html'de "button -> onclick" için yazdık.
    event.preventDefault();
    const username = document.querySelector("#myusername").value;
    const password = document.querySelector("#mypassword").value;
    setTimeout(()=>{
        if(username===user.username && password==user.password) {
            // alert("Giriş başarılı.");
            window.location.href = "home.html";
        }else{
            alert("Giriş başarısız.");
        }
    }, 1500);
}

const getHomePage = () => {
    window.location.href = "home.html";
}

function login2(event) { // login.html'de "button -> onclick" için yazdık.
    event.preventDefault();
    let form = document.querySelector("form");
    if(form.username.value===user.username && form.password.value===user.password) {
        // alert("Giriş başarılı.");
        setTimeout(getHomePage, 1000)
    }else{
        alert("Giriş başarısız.");
    }    
}


let form = document.querySelector("form");

function login3(event) { 
    event.preventDefault();
    console.log(event.target);
    if(form.username.value===user.username && form.password.value===user.password) { // 'form' yerine 'event.target' da yazılabilir.
        // alert("Giriş başarılı.");
        setTimeout(getHomePage, 1000)
    }else{
        alert("Giriş başarısız.");
    }    
}
form.addEventListener("submit", login3);

// let button = document.querySelector("button");
// button.addEventListener("click", login2);




