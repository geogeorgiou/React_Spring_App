
//this is the config file
//we setup the environmental constants here
//THESE DO TAKE INTO ACCOUNT SERVER CONTEXT ROOT so please add it

//***************************************
// npm start
// process.env.NODE_ENV = 'development'

// npm test
// process.env.NODE_ENV = 'test'

// npm run build
// process.env.NODE_ENV = 'production
//***************************************


const dev = {
    url: {
        ROOT_BASE_URL: 'http://localhost:8081/saadekef',
    }
};

//TODO to be changed for prod environment

const prod = {
    url: {
        ROOT_BASE_URL: 'http://localhost:8081/saadekef',
    }
}

export const config = process.env.NODE_ENV === 'development' ? dev : prod;