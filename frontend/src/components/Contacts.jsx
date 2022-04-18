import {useState, useEffect} from "react";
import * as React from 'react';
import axios from "axios"
import List from '@mui/material/List';
import ListItem from '@mui/material/ListItem';
import Divider from '@mui/material/Divider';
import ListItemText from '@mui/material/ListItemText';
import ListItemAvatar from '@mui/material/ListItemAvatar';
import Avatar from '@mui/material/Avatar';
import styled from 'styled-components';

// Styled componenet declarations
const Container = styled.div`
  width: 100%;
`;

// Function to choose a random colour for the each contact avatar based on string value
function stringToColor(string) {
  let hash = 0;
  let i;

  for (i = 0; i < string.length; i += 1) {
    hash = string.charCodeAt(i) + ((hash << 5) - hash);
  }

  let color = '#';

  for (i = 0; i < 3; i += 1) {
    const value = (hash >> (i * 8)) & 0xff;
    color += `00${value.toString(16)}`.slice(-2);
  }

  return color;
}

// Function to extract initials of first name & last name from contact
function stringAvatar(contact) {
  return {
    sx: {
      bgcolor: stringToColor(contact.firstName),
    },
    children: `${contact.firstName[0][0]}${contact.lastName[0][0]}`,
  };
}


export const Contacts = () => {

  const [contacts, setContacts] = useState([]);


  // Fetch contacts from db
  const fetchContacts = () => {
    const url = "http://localhost:8080/api/v1/contact";
    axios.get(url).then( res => {
      console.log(res);
      setContacts(res.data);
    }).catch((err) => 
      console.log(err));
  }
  
  useEffect(() => {
    fetchContacts();
  }, [])

  return (
    <Container>
      {contacts.map((contact, index) => (
        <List key={index}>
          <ListItem>
            <ListItemAvatar>
              <Avatar {...stringAvatar(contact)} />
            </ListItemAvatar>
            <ListItemText
              primary={contact.firstName + " " + contact.lastName}
              secondary={contact.phoneNumber}
            /> 
          </ListItem>
          <Divider variant="middle" />
        </List>
        )
      )}
    </Container>
  )
}
