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

let ul = document.querySelector(".expenses_ul");
let filterButton = document.querySelector("#filterButton");
let clearButton = document.querySelector("#clearButton");

function filter() {
  let value = document.querySelector(".myinput").value;

  let list = user.expenses.filter((x) => x > value);

  list.forEach((y) => elemanYarat2(y));

  //   filterButton.setAttribute("class", "btn btn-primary disabled");
  filterButton.classList.add("disabled");
  clearButton.classList.remove("disabled");
}

function elemanYarat(value) {
  let li = document.createElement("li");
  li.textContent = value;
  ul.appendChild(li);
}

function elemanYarat2(value) {
  ul.innerHTML += `<li>${value}</li>`;
}
function clearUl() {
  ul.innerHTML = "";
  filterButton.classList.remove("disabled");
  clearButton.classList.add("disabled");
}

let sayi = 0;
let tablo = document.querySelector("#tablo");
function addTable() {
  let name = document.getElementById("name").value;
  let surname = document.getElementById("surname").value;
  let age = document.getElementById("age").value;
  let password = document.getElementById("password").value;
  let username = document.getElementById("username").value;
  sayi++;
  tablo.innerHTML += `<tr>
  <th scope="row">${sayi}</th>
  <td>${name}</td>
  <td>${surname}</td>
  <td>${username}</td>
  <td>${age}</td>
  <td>${password}</td>
</tr> `;
}

let form = document.querySelector(".userform");

function addTable2() {
  let name = form.name.value;
  let surname = form.surname.value;
  let age = form.age.value;
  let password = form.password.value;
  let username = form.username.value;
  sayi++;
  tablo.innerHTML += `<tr>
  <th scope="row">${sayi}</th>
  <td>${name}</td>
  <td>${surname}</td>
  <td>${username}</td>
  <td>${age}</td>
  <td>${password}</td>
</tr> `;
}

function removeTable() {
  tablo.innerHTML = "";
  sayi = 0;
}
