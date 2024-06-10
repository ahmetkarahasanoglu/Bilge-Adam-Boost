import Avatar from '@mui/material/Avatar';
import Button from '@mui/material/Button';
import CssBaseline from '@mui/material/CssBaseline';
import TextField from '@mui/material/TextField';
import FormControlLabel from '@mui/material/FormControlLabel';
import Checkbox from '@mui/material/Checkbox';
import Link from '@mui/material/Link';
import Grid from '@mui/material/Grid';
import Box from '@mui/material/Box';
import LockOutlinedIcon from '@mui/icons-material/LockOutlined';
import Typography from '@mui/material/Typography';
import Container from '@mui/material/Container';
import { createTheme, ThemeProvider } from '@mui/material/styles';
import React, { useState } from 'react';


// TODO remove, this demo shouldn't need to reset the theme.

const defaultTheme = createTheme();

export default function Musteri() {
    let token = localStorage.getItem('token');
    // Fetch denemesi ('getall' için deneyelim):
    fetch('http://localhost/api/v1/musteri/getall?token='+token)
    .then(data=>data.json())
    .then(result=>{
        console.log(result);
    }).catch((data)=>{
        // alert('sorun oluştu Token yanlış....: ' + data)
        localStorage.removeItem('token');
        setTimeout(()=>{
            window.location.href = "/login"
        },1000)
        
    })
    //------

    const handleSubmit = (event) => {
        event.preventDefault();
        const data = new FormData(event.currentTarget);

        console.log({
            ad: data.get('ad'),
            soyad: data.get('soyad'),
            email: data.get('email'),
            password: data.get('password'),
            telefon: data.get('telefon')
        });
        fetch('http://localhost/api/v1/musteri/save', {
            method: 'POST', // GET,POST,PUT,DELETE.... (hangisi kullanılmışsa java'daki Controller metodumuzda)
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                ad: data.get('ad'),       // Backend kodumuza işlemesi için veri gönderiyoruz (Controller'daki save metoduna gönderiyoruz burda)
                soyad: data.get('soyad'), // Bu alanların, backend kodumuzdaki ilgili dto'nun içinde tanımlanmış olması gerekir (MusteriSaveRequestDto)
                email: data.get('email'),
                password: data.get('password'),
                telefon: data.get('telefon')
            }) 
        }).then(()=>{
            alert("Kayıt Başarılı");
        })
    };

  return (
    <ThemeProvider theme={defaultTheme}>
      <Container component="main" maxWidth="xs">
        <CssBaseline />
        <Box
          sx={{
            marginTop: 8,
            display: 'flex',
            flexDirection: 'column',
            alignItems: 'center',
            padding: 2,
            boxShadow: 3,
            backgroundColor: 'white',
            borderRadius: 2,
          }}
        >
          <Box component="form" noValidate onSubmit={handleSubmit} sx={{ width: '100%' }}>
            <Grid container spacing={2}>
              <Grid item xs={12} sm={6}>
                <TextField
                  autoComplete="given-name"
                  name="ad"
                  required
                  fullWidth
                  id="ad"
                  label="Müşteri Adı"
                  autoFocus
                />
              </Grid>
              <Grid item xs={12} sm={6}>
                <TextField
                  required
                  fullWidth
                  id="soyad"
                  label="Müşteri Soyad"
                  name="soyad"
                  autoComplete="family-name"
                />
              </Grid>
              <Grid item xs={12}>
                <TextField
                  required
                  fullWidth
                  id="email"
                  label="Email Address"
                  name="email"
                  autoComplete="email"
                />
              </Grid>
              <Grid item xs={12}>
                <TextField
                  required
                  fullWidth
                  name="password"
                  label="Password"
                  type="password"
                  id="password"
                  autoComplete="new-password"
                />
              </Grid>
              <Grid item xs={12}>
                <TextField
                  required
                  fullWidth
                  name="telefon"
                  label="Telefon"
                  type="text"
                  id="telefon"
                  autoComplete="new-password"
                />
              </Grid>
            </Grid>
            <Button
              type="submit"
              fullWidth
              variant="contained"
              sx={{ mt: 3, mb: 2 }}
            >
              Müşteri Ekle
            </Button>
            <Grid container justifyContent="flex-end">
              <Grid item>
                <Link href="/login" variant="body2">
                  Already have an account? Sign in
                </Link>
              </Grid>
            </Grid>
          </Box>
        </Box>
      </Container>
    </ThemeProvider>
  );
}