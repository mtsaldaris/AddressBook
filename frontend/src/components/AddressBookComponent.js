import {useState, useEffect} from "react";
import * as React from 'react';
import axios from "axios"
import List from '@mui/material/List';
import ListItem from '@mui/material/ListItem';
import Divider from '@mui/material/Divider';
import ListItemText from '@mui/material/ListItemText';
import ListItemAvatar from '@mui/material/ListItemAvatar';
import Avatar from '@mui/material/Avatar';
import Typography from '@mui/material/Typography';
import Stack from '@mui/material/Stack';

function stringToColor(string) {
  let hash = 0;
  let i;

  /* eslint-disable no-bitwise */
  for (i = 0; i < string.length; i += 1) {
    hash = string.charCodeAt(i) + ((hash << 5) - hash);
  }

  let color = '#';

  for (i = 0; i < 3; i += 1) {
    const value = (hash >> (i * 8)) & 0xff;
    color += `00${value.toString(16)}`.slice(-2);
  }
  /* eslint-enable no-bitwise */

  return color;
}

function stringAvatar(name) {
  return {
    sx: {
      bgcolor: stringToColor(name),
    },
    children: `${name.split(' ')[0][0]}${name.split(' ')[1][0]}`,
  };
}


export const AddressBookComponent = () => {

  const [contacts, setContacts] = useState([]);


  // Fetch contacts from db
  const fetchContacts = () => {
    axios.get("http://localhost:8080/api/v1/contact/getAll").then( res => {
      console.log(res);
      setContacts(res.data);
    });
  }
  useEffect(() => {
    fetchContacts();
  }, [])

  return (
    <div>
      {contacts.map((contact, index) => (
        <List key={index} sx={{ width: '100%', maxWidth: 500, bgcolor: 'background.paper' }}>
          <ListItem alignItems="center">
            <ListItemAvatar>
            <Avatar {...stringAvatar(contact.name)} />
            </ListItemAvatar>
            <ListItemText
              primary={contact.name}
              secondary={
                <React.Fragment>
                  <Typography
                    sx={{ display: 'inline' }}
                    component="span"
                    variant="body2"
                    color="text.primary"
                  >
                    {contact.phoneNumber}
                  </Typography>
                </React.Fragment>
              }
            />
          </ListItem>
          <Divider variant="inset" component="li" />
        </List>
        )
      )};
      



    </div>
  )
}
