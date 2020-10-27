import React, { Component } from "react";
import AddEmployee from "./Components/AddEmployee";
import { Route, Switch } from "react-router-dom";
import Table from "./Components/Table";



class App extends Component {
  render() {
    return (
        <Switch>
            <Route path="/view" component={Table} />
            <Route path="/" component={AddEmployee} />
        </Switch>
    );
  }
}

export default App;
