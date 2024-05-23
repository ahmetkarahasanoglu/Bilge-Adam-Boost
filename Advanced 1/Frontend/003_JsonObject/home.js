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

function filterExpenses() { // brings the expenses which are higher than the input value.
    let input = document.querySelector("input").value;
    let filteredArr = user.expenses.filter(x => x>input); // that are greater than the input value
    let ul = document.querySelector("ul");
    ul.innerHTML = '';
    for(let el of filteredArr) {
        let li = document.createElement("li");
        li.innerHTML += el;
        ul.append(li);
    }
    let temizleButton = document.querySelector("#temizleButton"); 
    temizleButton.classList.remove("disabled");             // enabling temizleButton
    let filterButton = document.querySelector("#filterButton");  
    filterButton.classList.add("disabled");                 // disabling filterButton
    // Hocanın Kullandığı 'button disable' Yöntemi:
    filterButton.classList.add("disabled");
    temizleButton.classList.remove("disabled");
    // or:
    filterButton.setAttribute("class", "btn btn-primary disabled");
    temizleButton.setAttribute("class", "btn btn-primary");
}

function temizle() {
    let ul = document.querySelector(".expenses ul");
    ul.innerHTML = ''; // clears ul's content.
    let input = document.querySelector("#myInput"); // this is for the below line.
    input.value = ''; // clears the input field's value

    let temizleButton = document.querySelector("#temizleButton");
    temizleButton.classList.add("disabled");               // disabling temizleButton
    let filterButton = document.querySelector("#filterButton");
    filterButton.classList.remove("disabled");              // enabling filterButton
}

// Hocanın Kullandığı 'elemanYarat()' Metotları:
function elemanYarat(value) {
    let li = document.createElement("li");
    li.textContent = value;
    ul.appendChild(li);
}
function elemanYarat2(value) {
    ul.innerHTML += `<li>${value}</li>`;
}
// --------------------------
let currentRowNumber = 2;

function addInputValuesToTable(event) {
    event.preventDefault();
    let name = document.querySelector("#name").value;
    let surname = document.querySelector("#surname").value;
    let username = document.querySelector("#username").value;
    let age = document.querySelector("#age").value;
    let password = document.querySelector("#password").value;
    
    let table = document.querySelector("table");
    let tbody = table.querySelector("tbody"); // selecting the 'tbody' which is under the 'table'

    let tr = document.createElement("tr"); // creating a new 'table row' (tr) element
    let th = document.createElement("th"); // creating th element for each cell

    th.setAttribute("scope", "row"); // ??
    th.textContent = `${currentRowNumber}`;
    currentRowNumber++;

    let tdName = document.createElement("td"); // creating new td element for each cell [below].
    tdName.textContent = name;

    let tdSurname = document.createElement("td");
    tdSurname.textContent = surname;

    let tdUsername = document.createElement("td");
    tdUsername.textContent = username;

    let tdAge = document.createElement("td");
    tdAge.textContent = age;

    let tdPassword = document.createElement("td");
    tdPassword.textContent = password;

    tr.appendChild(th);
    tr.appendChild(tdName);
    tr.appendChild(tdSurname);
    tr.appendChild(tdUsername);
    tr.appendChild(tdAge);
    tr.appendChild(tdPassword);

    tbody.appendChild(tr);
}
form = document.querySelector("form");
form.addEventListener("submit", addInputValuesToTable2);

// Başka Bir Yöntem - Yukardaki addInputValuesToTable() metodu için
let rowNum = 1;
function addInputValuesToTable2(event) {
    event.preventDefault();
    let tbody = document.querySelector("table tbody");
    let name = document.querySelector("#name").value;
    let surname = document.querySelector("#surname").value;
    let username = document.querySelector("#username").value;
    let age = document.querySelector("#age").value;
    let password = document.querySelector("#password").value;
    rowNum++;
    tbody.innerHTML += `<tr>
                            <th scope="row">${rowNum}</th>
                            <td>${name}</td>
                            <td>${surname}</td>
                            <td>${username}</td>
                            <td>${age}</td>
                            <td>${password}</td>
                        </tr>`;
}
// ----

function deleteMyRowsFromTable(event) {
    let tbody = document.querySelector("table tbody");
    tbody.innerHTML = '';
    rowNum = 0;
}
form.addEventListener("reset", deleteMyRowsFromTable);