import React, { Component } from 'react';
import Table from 'react-bootstrap/Table';
import Utils from './Utils';

class Availability extends Component {

    defaultState = {
        numOfSmallDogs: 0,
        smallKennelsAvailable: 0,
        totalNumSmallKennels: 0,
        numOfMedDogs: 0,
        mediumKennelsAvailable: 0,
        totalNumMedKennels: 0,
        numOfLargeDogs: 0,
        largeKennelsAvailable: 0,
        totalNumLargeKennels: 0
    }

    constructor(props) {
        super(props);
        this.state = this.defaultState;
    }

    componentDidMount() {
        Utils.get("availability")
            .then(data => {
                this.setState(data);
            });
    }

    render() {
        return (
            <div>
                <h1 className="page-title">Current Availability</h1>
                <Table striped bordered hover variant="dark">
                    <thead>
                        <tr>
                            <th>Kennel Size</th>
                            <th>Number of Dogs Boarding</th>
                            <th>Number of Available Kennels</th>
                            <th>Total Number of Kennels</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <th>Small Kennel</th>
                            <td>{this.state.numOfSmallDogs}</td>
                            <td>{this.state.smallKennelsAvailable}</td>
                            <td>{this.state.totalNumSmallKennels}</td>
                        </tr>
                        <tr>
                            <th>Medium Kennel</th>
                            <td>{this.state.numOfMedDogs}</td>
                            <td>{this.state.mediumKennelsAvailable}</td>
                            <td>{this.state.totalNumMedKennels}</td>
                        </tr>
                        <tr>
                            <th>Large Kennel</th>
                            <td>{this.state.numOfLargeDogs}</td>
                            <td>{this.state.largeKennelsAvailable}</td>
                            <td>{this.state.totalNumLargeKennels}</td>
                        </tr>
                    </tbody>
                </Table>
            </div>
        );
    }
}

export default Availability;