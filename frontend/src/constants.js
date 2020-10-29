
//this is the config file
//we setup the environmental constants here
//THESE DO TAKE INTO ACCOUNT SERVER CONTEXT ROOT so please add it in the .env.XXX (XXX is the environment)

//***************************************
// npm start-front
// ENV = 'frontend'

// npm start-dev
// ENV = 'development'

// npm build-prod
// ENV = 'production'
//***************************************

//environmental config json

const env = {
    url: {
        ROOT_BASE_URL: process.env.REACT_APP_ROOT_BASE_URL,
        API_BASE_URL: process.env.REACT_APP_API_BASE_URL
    }
}

export const config = env;

