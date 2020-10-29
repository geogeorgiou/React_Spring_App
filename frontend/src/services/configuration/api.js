import axios from 'axios';
import isObject from 'lodash/isObject';

import {config} from '../../constants';

const JSON = true;

const HTTP = axios.create({
    baseURL: config.url.API_BASE_URL,
    timeout: 30000,
    responseType: 'json',
    validateStatus: status => status >= 200 && status<=401
})

const getHeaders = jsonHeaders => {
    const headers = {
        Accept: '*/*'
    };

    if (jsonHeaders) {
        headers['Accept'] = 'application/json';
    }

    return headers;
};



const cleanNonTruthyParameters = obj => {
    const cleanedObject = {};
    Object.keys(obj).forEach(key => {
        if (obj[key] !== undefined) {
            cleanedObject[key] = obj[key];
        }
    });
    return cleanedObject;
};

const convertObjectToFormData = obj => {
    const form = new FormData();
    Object.keys(obj).forEach(key => {
        if (isObject(obj[key])) {
            form.append(key, JSON.stringify(obj[key]));
        } else {
            form.append(key, obj[key]);
        }
    });
    return form;
};

// This uses FormData https://developer.mozilla.org/en-US/docs/Web/API/FormData
const makeRequest = (method, path, params) => {
    const finalParams = cleanNonTruthyParameters(params || {});

    return HTTP({
        method,
        headers: getHeaders(),
        url: path,
        data:
            method !== 'GET' ? convertObjectToFormData(finalParams) : undefined,
        params: method === 'GET' ? finalParams : undefined
    });
};

// This uses JSON https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/JSON
const makeRequestJSON = (method, path, params) =>
    HTTP({
        method,
        headers: getHeaders(JSON),
        url: path,
        data: params
    });

export { makeRequest, makeRequestJSON };