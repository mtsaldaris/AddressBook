import { NavBar } from './components/NavBar';
import { Contacts } from './components/Contacts';
import { AddContact } from './components/AddContact';
import styled from 'styled-components';

// Styled componenet declarations
const Container = styled.div`
  display: flex;
  flex-direction: column;
`;
const AddressBook = styled.div`
  display: flex;
  flex-direction: column;
  align-self: center;
  padding: 10px;
  margin: 20px;
  -webkit-box-shadow: 2px 4px 10px 1px rgba(0, 0, 0, 0.47);
  box-shadow: 2px 4px 10px 1px rgba(201, 201, 201, 0.47);
  border-radius: 5px;
  width: 25vw
`;
const Top = styled.div`
  padding: 5px;
  display: flex;
  border-bottom: 1.5px solid black;
  justify-content: space-between;
`;
const Bottom = styled.div`
  margin: 5px 0px;
  min-height: 400px;
  max-height: 600px;
  overflow-y:auto
`;
const Title = styled.span`
  margin: 5px;
  font-size: 22px;
`;

function App() {
  return (
    <Container>
      <NavBar />
      <AddressBook>
        <Top>
          <Title>
            My Address Book
          </Title>
          <AddContact />
        </Top>
        <Bottom>
          <Contacts />
        </Bottom>   
      </AddressBook>
    </Container>
  );
}

export default App;
