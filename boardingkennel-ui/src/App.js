import React from 'react';
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import { Navbar } from 'react-bootstrap';
import { BrowserRouter as Router, Route } from 'react-router-dom';
import Home from './components/Home';

function App() {
  return (
    <div className="App">
      <Router>
        <div className="App-header">
          <Navbar bg="dark" variant="dark" expanded="true" expand="lg" fixed="top">
            <Navbar.Brand href="/">Boarding Kennel</Navbar.Brand>
          </Navbar>
          <div className="component">
            <Route path="/" exact component={Home} />
          </div>
        </div>
      </Router>
    </div>
  );
}

export default App;
