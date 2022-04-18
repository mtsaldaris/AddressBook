import {useState} from "react";
import Modal  from "@mui/material/Modal";
import TextField from '@mui/material/TextField';
import styled from 'styled-components';

// Styled componenet declarations
const Container = styled.div`
  display: flex;
`;
const Text = styled.div`
  font-size: 28px;
  margin-top: 20px;
`;
const FormContainer = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  width: 450px;
  height 500px;
  background-color: #F3F4F7;
  border-radius: 2px;
  position: absolute;
  top: 0;
  bottom: 0;
  left: 0;
  right 0;
  margin auto;
`;
const Form = styled.form`
  display: flex;
  flex-direction: column;
  justify-content: flex-start;
  align-items: center;
  padding: 20px;
`;
const FormItem = styled.div`
  display: flex;
  flex-direction: column;
  min-width: 250px;
  margin: 10px 0px;
`;
const FormButtons = styled.div`
  margin: 20px 0px;
`;
const Button = styled.button`
  padding: 7px;
  margin-right: 5px;
  border: filled;
  border-radius: 5px;
  font-size: 15px;
  border-color: ${(props) => props.borderColor};
  background-color: ${(props) => props.backgroundColor};
  color: ${(props) => props.textColor};
  cursor: pointer;
  &:hover {
    border-color: ${(props) => props.hoverColor};
    background-color: ${(props) => props.hoverColor};
  }
`;
const ErrorMessage = styled.span`
  color: red;
  font-size: 14px;
  max-width: 250px;
  margin: 5px 0px;
`;

// Default values for newContact object
const defaultValues = {
  firstName: "",
  lastName: "",
  phoneNumber: ""
};

export const AddContact = () => {

  const [newContact, setNewContact] = useState(defaultValues);

  // Variable to control modal open/close
  const [open, setOpen] = useState(false);

  // Set error messages from Http response
  const [firstNameError, setFirstNameError] = useState([]);
  const [lastNameError, setLastNameError] = useState([]);
  const [phoneNumberError, setPhoneNumberError] = useState([]);
  
  // Handle changes to input fields and assign values to newContact object
  const handleChange = (e) => {
    const {name, value} = e.target;
    setNewContact({
      ...newContact,
      [name]: value
    });
  };

  // Handle close of modal - onClick event of Cancel button
  const handleClose = () => {
    setOpen(false);
    setNewContact(defaultValues);
    setFirstNameError("");
    setLastNameError("");
    setPhoneNumberError("");
  }

  // Executes a POST request to add new contact to db
  // Catch any validation errors and display them on form
  const handleSubmit = (e) => {
    e.preventDefault();

    const url = "http://localhost:8080/api/v1/contact";
    
    const requestOptions = {
      method: "POST",
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json",
    },
      body: JSON.stringify(newContact)
    };

    fetch(url, requestOptions)
    .then((res) => res.json())
    .then((data) => {
      if(data.fieldErrors) {  // If any field errors exist - set field error values
        data.fieldErrors.forEach(error => {
          if(error.field === "firstName"){
            setFirstNameError(error.message);
          }
          if(error.field === "lastName"){
            setLastNameError(error.message);
          }
          if(error.field === "phoneNumber"){
            setPhoneNumberError(error.message);
          }
        });
      } else {
        // On successful POST close modal & display alert to user
        setOpen(false);
        alert(`${data.firstName} ${data.lastName} Added To Contacts!`)
      };
    }).catch((err) => err);
  };

  // Clear any displayed errors onFocus
  const onFirstNameFocus = (e) => {
    e.preventDefault();
    setFirstNameError("");
  }
  const onLastNameFocus = (e) => {
    e.preventDefault();
    setLastNameError("");
  }
  const onPhoneNumberFocus = (e) => {
    e.preventDefault();
    setPhoneNumberError("");
  }

  return (
    <Container>
      <Button 
        borderColor="#3e885b"
        backgroundColor="#3e885b"
        textColor="#f8f7ff"
        hoverColor="#4DA871"
        onClick={() => setOpen(true)}
      >
        Add New Contact
      </Button>
      <Modal open={open}>
        <FormContainer>
          <Text>
            Enter Contact Details
          </Text>
          <Form method="POST" autoComplete="off" onSubmit={handleSubmit}>
            <FormItem>
              <TextField
                variant="outlined"
                className="formInput"
                id="firstName"
                name="firstName"
                label="First Name *"
                type="text"
                value={newContact.firstName}
                onFocus={onFirstNameFocus}
                onChange={handleChange}
              />
              {
                firstNameError ? <ErrorMessage>{firstNameError}</ErrorMessage> : ""
              }
            </FormItem>
            <FormItem>
              <TextField
                variant="outlined"
                id="lastName"
                name="lastName"
                label="Last Name *"
                type="text"
                value={newContact.lastName}
                onFocus={onLastNameFocus}
                onChange={handleChange}
              />
              {
                lastNameError ? <ErrorMessage>{lastNameError}</ErrorMessage> : ""
              }
            </FormItem>
            <FormItem>
              <TextField
                variant="outlined"
                id="phoneNumber"
                name="phoneNumber"
                label="Phone Number *"
                type="text"
                value={newContact.phoneNumber}
                onFocus={onPhoneNumberFocus}
                onChange={handleChange}
              />
              {
                phoneNumberError ? <ErrorMessage>{phoneNumberError}</ErrorMessage> : ""
              }
            </FormItem>
            <FormButtons>
              <Button
                type = "submit"
                name = "submit" 
                borderColor="#3e885b"
                backgroundColor="#3e885b"
                textColor="#f8f7ff"
                hoverColor="#4DA871"
              >
                Save Contact
              </Button>
              <Button 
                borderColor="#A53C27"
                backgroundColor="#A53C27"
                textColor="#f8f7ff"
                hoverColor="#B6422B"
                onClick={handleClose}
              >
                Cancel
              </Button>
            </FormButtons>
          </Form>
        </FormContainer>
      </Modal>
    </Container>
  )
}
