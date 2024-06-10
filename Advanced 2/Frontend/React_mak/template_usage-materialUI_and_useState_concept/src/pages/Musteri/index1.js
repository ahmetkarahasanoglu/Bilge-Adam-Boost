// Bu sayfada basit bir şekilde fetch işlemini anlayacağız (useState kullanmadan).

function Musteri() {

    const handleSubmit = (event) => {
        event.preventDefault();
        const data = new FormData(event.currentTarget); 
        fetch('http://localhost/api/v1/musteri/save', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                ad: data.get('ad'),       
                soyad: data.get('soyad'), 
                email: data.get('email'),
                password: data.get('password'),
                telefon: data.get('telefon')
            })
        }).then(()=>{
            alert("Kayıt Başarılı");
        })
    }

    return (
        <div>
            <form onSubmit={handleSubmit}>
                <label>ad........: </label><input id="txtad" name="ad" /><br />
                <label>soyad.....: </label><input id="txtsoyad" name="soyad" /><br />
                <label>telefon...: </label><input id="txttelefon" name="telefon" /><br />
                <label>email.....: </label><input id="txtemail" name="email" /><br />
                <label>password..: </label><input id="txtpassword" name="password" /><br />
                <br></br>
                <button type="submit">Kaydet</button>
            </form>
        </div>
    )
}

export default Musteri;