// useState kullanımı yapalım bu sayfada.

import React, { useState } from 'react';

function Musteri() {
    const[ad, setAd] = useState('');
    const[soyad, setSoyad] = useState('');
    const[telefon, setTelefon] = useState('');
    const[email, setEmail] = useState('');
    const[password, setPassword] = useState('');
    const[loading, setLoading] = useState(false);

    const handleSubmit = (event) => {
        event.preventDefault();
        setLoading(true);
        console.log("datalar:", {
            ad, soyad, telefon, email, password
        })
        fetch('http://localhost/api/v1/musteri/save', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                ad: ad,       
                soyad: soyad, 
                email: email,
                password: password,
                telefon: telefon
            })
        }).then(()=>{
            setLoading(false);
            alert("Kayıt Başarılı");
        })
    }

    return (
        <div> 
            <form onSubmit={handleSubmit}>
                <label>ad........: </label><input id="txtad" name="ad" value={ad} onChange={(e) => setAd(e.target.value)} /><br />
                <label>soyad.....: </label><input id="txtsoyad" name="soyad" value={soyad} onChange={(e) => setSoyad(e.target.value)} /><br />
                <label>telefon...: </label><input id="txttelefon" name="telefon" value={telefon} onChange={(e) => setTelefon(e.target.value)} /><br />
                <label>email.....: </label><input id="txtemail" name="email" value={email} onChange={(e) => setEmail(e.target.value)} /><br />
                <label>password..: </label><input id="txtpassword" name="password" value={password} onChange={(e) => setPassword(e.target.value)} /><br />
                <br></br>
                <button type="submit">Kaydet</button>
            </form>
            {
                loading ? <iframe src="https://embed.lottiefiles.com/animation/97892"></iframe> : null
            } 
        </div>
    )
}

export default Musteri;