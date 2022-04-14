import { AppBarComponent } from './components/AppBar';
import { AddressBookComponent } from './components/AddressBookComponent';
import './styles/App.css';

/*
 * Name: App.js
 *
 * Purpose: App Component is the main component in React JS
 *          Acts as a container for all other components.
 */

function App() {
  return (
    <div className="App">
      <AppBarComponent />
      <AddressBookComponent />
    </div>
  );
}

export default App;
