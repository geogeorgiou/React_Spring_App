import React, {Component} from 'react';

import {employeeApi} from '../services/endpoints/employeeApi';
// import axios from 'axios';
import axiosJwtInstance from '../services/endpoints/jwtAuth.instance';
// import authHeader from "/configuration/auth-header";
import authHeader from "../services/configuration/auth-header";
import {LocalGasStation} from "@material-ui/icons";

class AuthView extends Component {

    state = {
        isAuthorized: false,
        isLoading: false
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
        this.setState({isLoading: true});

        // axios.post('http://localhost:8081/saadekef/eticket/api/jwt/userAuth', {whatever: ''}, {headers: authHeader()})
        // axios.post('/jwt/userAuth', {whatever: ''}, {headers: authHeader()})
        axiosJwtInstance.post('/jwt/userAuth', {whatever: ''})
            .then(response => {
                // console.log(response.data.accessToken);
                this.setState({isAuthorized: true, isLoading: false});

                // localStorage.setItem("user", JSON.stringify({accessToken: response.data.accessToken}));
            })
            .catch(_ => {
                console.log("NOT AUTHORIZED");
                this.setState({isAuthorized: false, isLoading: false});

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

        let isLoading = this.state.isLoading;
        // if (!this.state.isLoading)
        //     isLoading = null

        //in unauthorized cases invalidate all user data in localstorage
        // and redirect him out? (redirect to logout of weblogic)
        return (
            <>
                {
                    isLoading
                        ? (<h1>Loading...</h1>)
                        : (
                            <div>
                                <p>user info:</p>
                                {isAuthText}
                            </div>
                        )
                }


            </>
        )
    }


}

export default AuthView;