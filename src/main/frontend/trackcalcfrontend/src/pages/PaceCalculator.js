import React, {Component} from 'react';
import axios from "axios";
import {Button, Col, Form, Row} from "react-bootstrap";



class PaceCalculator extends Component {
    constructor(props) {
        super(props);
        this.state = {
            distance: 0,
            hours: 0,
            minutes: 0,
            seconds: 0,
            distanceUnit: 'miles',
            paceResult: null
        };
    }

    handleInputChange = (event) => {
        const { name, value } = event.target;
        this.setState({ [name]: value });
    }


    handleSubmit = async (event) => {
        event.preventDefault();
        try {

            this.setState({
                errorMessage: '',
                paceResult: null
            });


            // Perform calculations or further actions with the captured data
            const {distance, hours, minutes, seconds, distanceUnit} = this.state;

            //fix for Nan when they get deleted

            // Create the DTO object with the captured data
            const params = {
                distance: (distance !== null)? parseFloat(distance) : 0,
                hours: hours !== null ? parseInt(hours) : 0,
                minutes: minutes !== null ? parseInt(minutes) : 0,
                seconds: seconds !== null ? parseFloat(seconds) : 0,
                distanceUnit
            };

            if(isNaN(params.distance)){
                params.distance = 0;
            }

            if(isNaN(params.hours)){
                params.hours = 0;
            }

            if(isNaN(params.minutes)){
                params.minutes = 0;
            }

            if(isNaN(params.seconds)){
                params.seconds = 0;
            }





            // Validate the captured data
            if (
                params.distance < 0 ||
                params.hours < 0 ||
                params.minutes < 0 ||
                params.seconds < 0
            ) {
                // Throw an error or handle the validation failure accordingly
                throw new Error('Invalid input: distance, hours, minutes, or seconds cannot be negative');
            }

            if (
                params.hours === 0  &&
                params.minutes === 0 &&
                params.seconds === 0
            ) {
                // Throw an error or handle the validation failure accordingly
                throw new Error('Invalid input: time cannot be zero');
            }

            if (
                params.distance === 0 || isNaN(params.distance)
            ) {
                // Throw an error or handle the validation failure accordingly
                throw new Error('Invalid input: distance cannot be zero');
            }





            const response = await axios.get('/paceCalculator', { params: params });

            // Update the paceResult in the component's state with the API response
            const { milePace, kilometerPace } = response.data;
            this.setState({ paceResult: { milePace, kilometerPace } });
        } catch (error) {
            console.error(error);
            this.setState({ errorMessage: error});
        }
    }






    render() {

        const { paceResult, errorMessage} = this.state;

        const divStyle = {
            padding: '1%',
        };

        return (
             <div style={divStyle}>
                <h1 style={{
                    marginBottom: '30px', /* Default spacing */
                    marginTop: '18px',

                    /* Adjust spacing for smaller screens */
                    '@media (maxWidth: 767px)': {
                        marginBottom: '10px', /* Reduced spacing for mobile */
                        marginTop: '10px'
                    }
                }}>Pace Calculator </h1>

                <Form onSubmit={this.handleSubmit}>
                    <Row className="mb-3">
                        <Form.Group as={Col} controlId="formDistance">
                            <div style={{ display: 'flex', flexDirection: 'column', alignItems: 'flex-end' }}>
                                <div style={{ alignSelf: 'right', width: '200px' }}>
                                    <Form.Label style={{ fontSize: '20px' }}>Distance</Form.Label>
                                </div>
                                <Form.Control
                                    style = {{width: '200px'}}
                                    type="number"
                                    placeholder="Enter Distance"
                                    value={this.state.distance || ''}
                                    onChange={(e) => this.setState({ distance: e.target.value })}
                                />
                            </div>
                        </Form.Group>

                        <Form.Group as={Col} controlId="formGridDistnaceUnit">

                            <div style={{ display: 'flex', flexDirection: 'column', alignItems: 'flex-start' }}>
                                <Form.Label style={{fontSize: '20px'}}>Distance Unit</Form.Label>
                                <Form.Check
                                    type="radio"
                                    label="miles"
                                    name="formHorizontalRadios"
                                    id="formHorizontalRadios1"
                                    style={{ marginRight: '10px' }}
                                    defaultChecked
                                    checked={this.state.distanceUnit === 'miles'}
                                    onChange={() => this.setState({ distanceUnit: 'miles' })}
                                />
                                <Form.Check
                                    type="radio"
                                    label="kilometers"
                                    name="formHorizontalRadios"
                                    id="formHorizontalRadios2"
                                    style={{ marginRight: '10px' }}
                                    checked={this.state.distanceUnit === 'kilometers'}
                                    onChange={() => this.setState({ distanceUnit: 'kilometers' })}
                                />
                            </div>
                        </Form.Group>
                    </Row>

                    <Row className="mb-3">
                        <div>
                            <Form.Label style={{ fontSize: '20px' }}>Time</Form.Label>
                        </div>
                        <Form.Group as={Col} controlId="formGridCity">
                            <Form.Control
                                type="text"
                                pattern="[0-9]*"
                                inputMode="numeric"
                                placeholder="Hours"
                                value={this.state.hours || ''}
                                onChange={(e) => {
                                    const inputValue = e.target.value;
                                    const numericValue = inputValue.replace(/\D/g, ''); // Remove non-numeric characters
                                    this.setState({ hours: numericValue });
                                }}
                            />
                        </Form.Group>

                        <Form.Group as={Col} controlId="formGridMinutes">
                            <Form.Control
                                type="text"
                                pattern="[0-9]*"
                                inputMode="numeric"
                                placeholder="Minutes"
                                value={this.state.minutes || ''}
                                onChange={(e) => {
                                    const inputValue = e.target.value;
                                    const numericValue = inputValue.replace(/\D/g, ''); // Remove non-numeric characters
                                    this.setState({ minutes: numericValue });
                                }}
                            />
                        </Form.Group>

                        <Form.Group as={Col} controlId="formGridSeconds">
                            <Form.Control
                                type="text"
                                pattern="[0-9]*(\.[0-9]*)?"
                                inputMode="decimal"
                                placeholder="Seconds"
                                value={this.state.seconds || ''}
                                onChange={(e) => {
                                    const inputValue = e.target.value;
                                    const numericValue = inputValue.replace(/[^\d.]/g, ''); // Remove non-numeric and non-decimal characters
                                    this.setState({ seconds: numericValue });
                                }}
                            />
                        </Form.Group>
                    </Row>

                    <Button variant="primary" type="submit">
                        Calculate
                    </Button>
                </Form>


                {errorMessage && <p className="error-message" style={{fontSize: '20px', marginTop: '50px' }}>{errorMessage.toString()}</p>}

                {/* Display the paceResult at the bottom of the webpage */}
                {paceResult && (
                    <div style={{fontSize: '20px', marginTop: '50px' }}>
                        <h2>Pace Result:</h2>
                        <p>Mile Pace: {paceResult.milePace}</p>
                        <p>Kilometer Pace: {paceResult.kilometerPace}</p>
                    </div>
                )}


            </div>
        );
    }
}

export default PaceCalculator;