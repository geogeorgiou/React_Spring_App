import React from 'react';
import { Input, Label} from 'reactstrap';

const input = (props) => {

    let inputElement = null;
    let inputType = props.elementConfig.type;

    switch (props.elementType) {
        case ('input'):
            inputElement = <Input type={inputType} {...props}/>;
            break;
        case('textarea'):
            inputElement = <textarea {...props}/>;
            break;
        //dropdown? checkbox
        default:
            inputElement = <Input type="text" {...props}/>

    }


    return(
        <div>
            <Label>{props.label}</Label>
            {inputElement}
        </div>
    );



};

export default input;