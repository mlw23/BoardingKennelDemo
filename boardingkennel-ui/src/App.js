import React from 'react';
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import { Navbar, Nav, Button } from 'react-bootstrap';
import { BrowserRouter as Router, Route } from 'react-router-dom';

function App() {
  return (
    <div className="App">
      <Router>
        <div className="App-header">
          <Navbar bg="dark" variant="dark" expanded="true" expand="lg" fixed="top">
            <Navbar.Brand href="/">Boarding Kennel</Navbar.Brand>
            <Nav className="mr-auto">
              <Nav.Link href="/checkin">Check-in Dog</Nav.Link>
            </Nav>
          </Navbar>
        </div>
      </Router>
    </div>
  );
}

export default App;
