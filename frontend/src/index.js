//IE11 polyfill dependencies
import "react-app-polyfill/ie11";
import "react-app-polyfill/stable";

import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import './styles/css/custom-btsp.scss'
import App from './App';
import * as serviceWorker from './serviceWorker';
import axios from 'axios';
import { config } from './constants';


//setting up HTTP requests baseURL for axios (according to development environment)
axios.defaults.baseURL = config.url.ROOT_BASE_URL;

ReactDOM.render(<App/>, document.getElementById('root'));

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();
