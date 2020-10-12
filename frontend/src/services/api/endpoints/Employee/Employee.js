import { makeRequestJSON } from '../../configuration/api';

//here define all kinds of endpoints to be used in the app
//e.g.
// index: () =>
//     get('/users')

//OR
// single: (id) =>
//     get(`/users/${id}`),

export const EmployeeApi = {
    indexPageable: tableRequest => makeRequestJSON('POST', 'indexPageable', {...tableRequest}),
}