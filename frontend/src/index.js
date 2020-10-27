import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import {BrowserRouter as Router, Route} from 'react-router-dom'
import * as serviceWorker from './serviceWorker';

import axios from 'axios';

import { config } from './constants';

import { createBrowserHistory } from 'history';

export const browserHistory = createBrowserHistory({
    basename: process.env.PUBLIC_URL
});

axios.defaults.baseURL = config.url.ROOT_BASE_URL;


ReactDOM.render(
    // <Router history={browserHistory} basename={'/saadekef/'}>
    <Router history={browserHistory} basename={process.env.PUBLIC_URL}>
        <App/>
    </Router>
    , document.getElementById('root'));

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();
