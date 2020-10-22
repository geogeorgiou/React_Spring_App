import React from 'react';
import {Col, Container, FormGroup, Label, Row} from "reactstrap";
import CustomInput from '../Input/CustomInput'

const customForm = (props) => {

    return (
        <React.Fragment>
            <Row form>
                <Col md={6}>
                    <FormGroup>
                        <Label for="exampleEmail">Email</Label>
                        <CustomInput type="email" name="email" placeholder="with a placeholder"/>
                    </FormGroup>
                </Col>
                <Col md={6}>
                    <FormGroup>
                        <Label for="examplePassword">Password</Label>
                        <CustomInput type="password" name="password" placeholder="password placeholder"/>
                    </FormGroup>
                </Col>
            </Row>
            <FormGroup>
                <Label for="exampleAddress">Address</Label>
                <CustomInput type="text" name="address" placeholder="1234 Main St"/>
            </FormGroup>
            <FormGroup>
                <Label for="exampleAddress2">Address 2</Label>
                <CustomInput type="text" name="address2" placeholder="Apartment, studio, or floor"/>
            </FormGroup>
            <Row form>
                <Col md={6}>
                    <FormGroup>
                        <Label for="exampleCity">City</Label>
                        <CustomInput type="text" name="city"/>
                    </FormGroup>
                </Col>
                <Col md={4}>
                    <FormGroup>
                        <Label for="exampleState">State</Label>
                        <CustomInput type="text" name="state" />
                    </FormGroup>
                </Col>
                <Col md={2}>
                    <FormGroup>
                        <Label for="exampleZip">Zip</Label>
                        <CustomInput type="text" name="zip" />
                    </FormGroup>
                </Col>
            </Row>
            {/*<FormGroup check>*/}
            {/*    <CustomInput type="checkbox" name="check" id="exampleCheck"/>*/}
            {/*    <Label for="exampleCheck" check>Check me out</Label>*/}
            {/*</FormGroup>*/}
        </React.Fragment>
    )

}

export default customForm;