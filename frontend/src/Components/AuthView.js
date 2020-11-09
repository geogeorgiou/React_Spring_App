import React, {Component} from 'react';

import {employeeApi} from '../services/endpoints/employeeApi';
import axios from 'axios';
// import authHeader from "/configuration/auth-header";
import authHeader from "../services/configuration/auth-header";
import {LocalGasStation} from "@material-ui/icons";

class AuthView extends Component {

    state = {
        isAuthorized: false
    }

    handleIsAuthorized = (isAuth) => {
        this.setState({isAuthorized: isAuth})
    }

    logout() {
        localStorage.removeItem("user");
    }

    componentDidMount() {
        // employeeApi.isUserAuth({whatever: 'asd'})
        //     .then(response => {
        //         // console.log(response.data.accessToken);
        //         this.setState({isAuthorized: true})
        //
        //         localStorage.setItem("user", JSON.stringify({accessToken: response.data.accessToken}));
        //     })
        //     .catch(err => {
        //         console.log("NOT AUTHORIZED");
        //         this.setState({isAuthorized: false})
        //
        //         //invalidate user data
        //         // localStorage.setItem("user", JSON.stringify({accessToken: ''}));
        //         localStorage.removeItem("user");
        //         //redirect here???
        //     })

        axios.post('http://localhost:8081/saadekef/eticket/api/jwt/userAuth', {whatever: ''}, {headers: authHeader()})
            .then(response => {
                console.log(response.data.accessToken);
                this.setState({isAuthorized: true});

                localStorage.setItem("user", JSON.stringify({accessToken: response.data.accessToken}));
            })
            .catch(_ => {
                console.log("NOT AUTHORIZED");
                this.setState({isAuthorized: false});

                //invalidate user data
                // localStorage.setItem("user", JSON.stringify({accessToken: ''}));
                // localStorage.removeItem("user");
            })
    }

    shouldComponentUpdate(prevProps, prevState, nextContext) {
        return prevState.isAuthorized !== this.state.isAuthorized;
    }


    // componentDidUpdate(prevProps, prevState, snapshot) {
    //
    //     if (prevState.isAuthorized !== this.state.isAuthorized) {
    //         return true;
    //     }
    //
    // }


    render() {

        let isAuthText = <h1>NOT AUTHORIZED!</h1>
        if (this.state.isAuthorized)
            isAuthText = <h1>I am authorized!</h1>

        //in unauthorized cases invalidate all user data in localstorage
        // and redirect him out? (redirect to logout of weblogic)
        return (
            <>
                <p>user info:</p>
                {isAuthText}
            </>
        )
    }


}

export default AuthView;