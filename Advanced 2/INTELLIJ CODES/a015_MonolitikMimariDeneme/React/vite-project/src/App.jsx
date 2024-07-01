import React, { useState } from 'react'
import './App.css'

function App() {
    const [username, setUsername] = useState('');
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [repassword, setRepassword] = useState('');

    const handleSubmit = async(e) => {
        e.preventDefault();

        const userData = {
            username: username,
            email: email,
            password: password,
            repassword: repassword
        }
        try {
            const response = await fetch('http://localhost/api/v1/musteri/save', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(userData),
            })

            if(response.ok) {
                const data = await response.json();
                console.log('Success:', data);
            } else {
                console.error('Error:', response.statusText);
            }
        }catch(error) {
            console.error('Error:', error);
        }

    }

    return (
        <>
            <h1>WELCOME</h1>
            <h3>- Register Page -</h3>
            <form onSubmit = {handleSubmit}>
                <div>
                    <label htmlFor="username">Username:</label>
                    <input 
                        type="text"
                        id="username"
                        value={username}
                        onChange={(e) => setUsername(e.target.value)}
                    />
                </div>
                <div>
                    <label htmlFor="email">Email:</label>
                    <input 
                        type="email"
                        id="email"
                        value={email}
                        onChange={(e) => setEmail(e.target.value)}
                    />
                </div>
                <div>
                    <label htmlFor="password">Password:</label>
                    <input 
                        type="password" 
                        id="password"
                        value={password}
                        onChange={(e) => setPassword(e.target.value)}
                    />
                </div>
                <div>
                    <label htmlFor="repassword">Password:</label>
                    <input 
                        type="password" 
                        id="repassword"
                        value={repassword}
                        onChange={(e) => setRepassword(e.target.value)}
                    />
                </div>
                <button type="submit">Submit</button>
            </form>
        </>
    )
}
export default App
