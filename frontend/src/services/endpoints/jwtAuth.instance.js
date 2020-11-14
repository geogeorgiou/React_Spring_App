import axios from 'axios';
import authHeader from "../configuration/auth-header";

//should import config here and assign it
//also need to remove jwt on fail and redirect?

const jwtAuthInstance = axios.create(
    {
        baseURL: "http://localhost:8081/saadekef/eticket/api/",
    }
)

jwtAuthInstance.defaults.headers.common["Accept"] = "application/json";
jwtAuthInstance.defaults.headers.common["Authorization"] = authHeader().Authorization;

jwtAuthInstance.interceptors.request.use(
    request => {
        if (request.headers.common["Authorization"])
            return request;

        throw({message: "token not available"});

    }, error => {
        return Promise.reject(error);
    }
)

export default jwtAuthInstance;