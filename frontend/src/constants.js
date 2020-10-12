
//this is the config file
//we setup the environmental constants here

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
        ROOT_BASE_URL: 'http://localhost:8081'
    }
};

const prod = {
    url: {
        ROOT_BASE_URL: 'http://localhost:8081'    //TODO to be changed for prod environment
    }
}

export const config = process.env.NODE_ENV === 'development' ? dev : prod;