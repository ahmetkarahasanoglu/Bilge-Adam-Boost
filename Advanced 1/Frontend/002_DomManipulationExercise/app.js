const vizeInput = document.querySelector("#vize");
const finalInput = document.querySelector("#final");

function hesapla() {
    const averageValue = vizeInput.value*0.4 + finalInput.value*0.6;
    let resultText;
    if(averageValue > 80) {
        resultText = 'Sonuç ===> Başarılı. Ortalama: ' + averageValue;
    }else if(averageValue > 60) {
        resultText = 'Sonuç ===> Geçtiniz. Ortalama: ' + averageValue;
    }else if(averageValue > 50) {
        resultText = 'Ortalama ile geçtiniz. Ortalama: ' + averageValue;
    }
    document.querySelector(".result").innerHTML = resultText;
}
