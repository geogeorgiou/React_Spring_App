import { makeRequestJSON } from '../configuration/api';

//here define all kinds of endpoints to be used in the app
//e.g.
// index: () =>
//     get('/users')

//OR
// single: (id) =>
//     get(`/users/${id}`),

export const employeeApi = {
    index: tableRequest => makeRequestJSON('GET', 'employee', {...tableRequest}),
    create: empData => makeRequestJSON('POST', 'employee', {...empData})
    // indexPageable: tableRequest => makeRequestJSON('POST', 'indexPageable', {...tableRequest})
}