import React, { useEffect, useState, useCallback, useMemo } from 'react';
import Aux from './hoc/Auxiliary/Auxiliary'
import DashboardNavbar from "./components/Dashboard/Navbar/DashboardNavbar";
import DashboardFilterNavbar from  './components/Dashboard/Navbar/DashboardFilterNavbar'
import { Container } from 'reactstrap';
import TableContainer from './TableContainer';
import axios from 'axios';

import clsx from "clsx";
import {EmployeeApi} from './services/api/endpoints/Employee/Employee'
import {messages} from "./messages/messages";
// import makeData from "./makeData";

// Let's simulate a large dataset on the server (outside of our component)
// const serverData = makeData(10000)

const App = () => {
    const [data, setData] = useState([]);
    const [loading,setLoading] = useState(false);
    const [error, setError] = useState(false);
    const [pageCount, setPageCount] = useState(1);  //TO be changed to set initial number of pages

    // const fetchIdRef = React.useRef(0);

    // const doFetch = async () => {
    //     // const response = await axios.get('https://randomuser.me/api/?results=100');
    //     const response = await axios.get('https://randomuser.me/api/?results=5');
    //     const body = await response.data;
    //     const contacts = body.results;
    //     // console.log(contacts);
    //     // setData(contacts);
    // }

    // const fetchDataRequest = {
    //     pageCount: 1,
    //     pageSize: 5
    // }

    const fetchData = useCallback(({ pageSize, pageIndex }) => {
        // This will get called when the table needs new data
        // You could fetch your data from literally anywhere,
        // even a server. But for this example, we'll just fake it.

        // Give this fetch an ID
        // const fetchId = ++fetchIdRef.current

        // Set the loading state
        setLoading(true);

        // We'll even set a delay to simulate a server here
        // setTimeout(() => {
        //     // Only update the data if this is the latest fetch
        //     if (fetchId === fetchIdRef.current) {
        //         const startRow = pageSize * pageIndex
        //         const endRow = startRow + pageSize
        //         setData(serverData.slice(startRow, endRow))
        //
        //         // Your server could send back total page count.
        //         // For now we'll just fake it, too
        //         setPageCount(Math.ceil(serverData.length / pageSize))
        //
        //         setLoading(false)
        //     }
        // }, 1000)

        // axios.post('/api/fetchData',{ pageSize, pageIndex })
        EmployeeApi.indexPageable({ pageSize, pageIndex })
            .then(response => {

                //get the data from response
                const body = response.data;

                //access the JSON data from body
                // setData(body.employeeModels);
                setData(body.entityModels);
                //setting the Page Count
                setPageCount(body.pageCount);

                setLoading(false);
                setError(false);

            })
            .catch(() => {
                setData([]);
                setPageCount(0)
                setLoading(false);
                setError(false);
            });

    }, [])

    const columns = useMemo(
        () => [
            {
                Header: messages.title,
                accessor: 'id',
                // disableSortBy: true,
                // Filter: SelectColumnFilter,
                // filter: 'equals',
                // Cell: ({ cell }) => {
                //     const { value } = cell;
                //
                //     const getTitleStyles = (value) => {
                //
                //         let titleStyles;
                //         if (value === 'Mr'){
                //             titleStyles = 'alert-primary';
                //         }
                //         else{
                //             titleStyles = 'alert-danger';
                //         }
                //         return titleStyles;
                //     }
                //
                //     return (
                //         <div className={clsx('alert', getTitleStyles(value))} style={{ textAlign: 'center'}}>
                //             { value }
                //         </div>
                //     );
                // }
            },
            {
                Header: messages.firstName,
                accessor: 'name',
            },
            {
                Header: messages.lastName,
                accessor: 'department',
            },
            {
                Header: 'Email',
                accessor: 'dob',
            },
            {
                Header: messages.city,
                accessor: 'gender',
            }
        ],
        []
    );

    return (
        <Aux>
            <DashboardNavbar/>
            <DashboardFilterNavbar/>
            <Container style={{ marginTop: '1rem' }}>
                <TableContainer
                    columns={columns}
                    data={data}
                    fetchData={fetchData}
                    pageCount={pageCount}
                    isLoading={loading}
                    isError={error}
                    noDataText={messages.dashboard.noDataText}
                    noFilteredDataText={messages.dashboard.noFilteredDataText}
                    // renderRowSubComponent={renderRowSubComponent}
                />
            </Container>
        </Aux>

    );
};

export default App;