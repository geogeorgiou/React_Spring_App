import {makeAuthRequestJSON, makeRequestJSON} from '../configuration/api';
import authHeader from "../configuration/auth-header";
import axios from 'axios';

//here define all kinds of endpoints to be used in the app
//e.g.
// index: () =>
//     get('/users')

//OR
// single: (id) =>
//     get(`/users/${id}`),

const API_URL = 'http://localhost:8081/api/jwt/';

export const employeeApi = {
    index: tableRequest => makeRequestJSON('GET', 'employee', {...tableRequest}),
    create: empData => makeRequestJSON('POST', 'employee', {...empData}),
    encodeJWT: jwtData => makeRequestJSON('POST', 'jwt/enc' ,{...jwtData}),  //TO BE CALLED WHEN USER LOGS INTO THE APP
    decodeJWT: jwtData => makeRequestJSON('POST', 'jwt/dec' ,{...jwtData}),
   // indexPageable: tableRequest => makeRequestJSON('POST', 'indexPageable', {...tableRequest})

    //replace this?
    // isUserAuth() {
    //     return axios.get(API_URL + 'userAuth', { headers: authHeader() });
    // }
    //with this ?
    isUserAuth: _ => makeAuthRequestJSON('POST', authHeader(), 'jwt/userAuth', {..._})


}