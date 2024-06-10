import * as React from 'react';
import Link from '@mui/material/Link';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Title from './Title';
import { useNavigate } from 'react-router-dom';

// Generate Order Data
function createData(id, date, name, shipTo, paymentMethod, amount) {
  return { id, date, name, shipTo, paymentMethod, amount };
}

const rows = [
  createData(
    0,
    '16 Mar, 2019',
    'Elvis Presley',
    'Tupelo, MS',
    'VISA ⠀•••• 3719',
    312.44,
  ),
  createData(
    1,
    '16 Mar, 2019',
    'Paul McCartney',
    'London, UK',
    'VISA ⠀•••• 2574',
    866.99,
  ),
  createData(2, '16 Mar, 2019', 'Tom Scholz', 'Boston, MA', 'MC ⠀•••• 1253', 100.81),
  createData(
    3,
    '16 Mar, 2019',
    'Michael Jackson',
    'Gary, IN',
    'AMEX ⠀•••• 2000',
    654.39,
  ),
  createData(
    4,
    '15 Mar, 2019',
    'Bruce Springsteen',
    'Long Branch, NJ',
    'VISA ⠀•••• 5919',
    212.79,
  ),
];

function preventDefault(event) {
  event.preventDefault();
}

export default function Orders() {
    const navigate = useNavigate();

    const [mlist, setMlist] = React.useState([]); // burayı yazdık. MARK

    React.useEffect(()=>{ // mark
        let token = localStorage.getItem('token');
        fetch('http://localhost/api/v1/musteri/getall?token=' + (token==null ? '' : token))
        .then(data=>data.json())
        .then(data=>{
            setMlist(data);
        })
        .catch(()=>{
            navigate('/login');
        })
    },[]);

  return (
    <React.Fragment>
      <Title>Recent Orders</Title>
      <Table size="small">
        <TableHead>
          <TableRow>
            <TableCell>Email</TableCell> {/* mark */}
            <TableCell>Ad Soyad</TableCell>
            <TableCell>Telefon</TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {mlist.map((row) => (  // mark
            <TableRow key={row.id}>
              <TableCell>{row.email}</TableCell>  {/* mark */}
              <TableCell>{row.ad}</TableCell>
              <TableCell>{row.telefon}</TableCell>
            </TableRow>
          ))}
        </TableBody>
      </Table>
      <Link color="primary" href="#" onClick={preventDefault} sx={{ mt: 3 }}>
        See more orders
      </Link>
    </React.Fragment>
  );
}