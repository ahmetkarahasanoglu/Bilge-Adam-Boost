import * as React from 'react';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Home from './pages/Home/index.js';
import Login from './pages/Login/index.js';
import Register from './pages/Register/index.js';
import Musteri1 from './pages/Musteri/index1.js';
import Musteri2 from './pages/Musteri/index2.js';
import MusteriComponent from './components/Musteri.js'
// import { styled, createTheme, ThemeProvider } from '@mui/material/styles';
// import CssBaseline from '@mui/material/CssBaseline';
// import MuiDrawer from '@mui/material/Drawer';
// import Box from '@mui/material/Box';
// import MuiAppBar from '@mui/material/AppBar';
// import Toolbar from '@mui/material/Toolbar';
// import List from '@mui/material/List';
// import Typography from '@mui/material/Typography';
// import Divider from '@mui/material/Divider';
// import IconButton from '@mui/material/IconButton';
// import Badge from '@mui/material/Badge';
// import Container from '@mui/material/Container';
// import Grid from '@mui/material/Grid';
// import Paper from '@mui/material/Paper';
// import Link from '@mui/material/Link';
// import MenuIcon from '@mui/icons-material/Menu';
// import ChevronLeftIcon from '@mui/icons-material/ChevronLeft';
// import NotificationsIcon from '@mui/icons-material/Notifications';
// import { mainListItems, secondaryListItems } from './components/listItems';
// import Chart from './components/Chart';
// import Deposits from './components/Deposits';
// import Orders from './components/Orders';

function App() {

    const[isLogin, setIsLogin] = React.useState(false);

    React.useEffect(()=> { // sondaki dizi '[]' içeriği değişir ise sayfa render olur tekrar yüklenir. Boş dizi koyarsanız dizinin içi hiçbir zaman değişmeyeceği için sayfa yüklenirken bir kez çalışır ve tekrar çalışmaz.
        let token = localStorage.getItem("token");
        console.log('token var mı.......: ', token?token:"token yok"); // (if there is token, leave here the token. If there is no token, leave here "token yok" [show on console])
        if(token) 
            setIsLogin(true);
        else
            setIsLogin(false);
    }, [])

    return (
        <>  
            <BrowserRouter>
                <Routes>
                    <Route path='/' element={isLogin ? <Home /> : <Login />} />  {/* React Router kullanıyoruz buralarda (hangi path girildiğinde hangi sayfaya gidileceği). (örneğin bir anchor tag'i bu path'e yönlendirebiliriz) (react-router-dom paketini import ettik yukarda) */}
                    <Route path='/login' element={<Login />}/>
                    <Route path='/register' element={<Register />}/>
                    <Route path='/home' element={<Home />}/>
                    <Route path='/musteri1' element={<Musteri1 />}/>
                    <Route path='/musteri2' element={<Musteri2 />}/>
                    <Route path='/musteriComponent' element={<MusteriComponent />}/>
                </Routes>
            </BrowserRouter>
        </>
    );
}

export default App;