import React, { Component } from "react";
import AddEmployee from "./Components/AddEmployee";
import AuthView from "./Components/AuthView";
import { Route, Switch } from "react-router-dom";
import Table from "./Components/Table";



class App extends Component {
  render() {
    return (
        <Switch>
            <Route path="/isAuth" component={AuthView} />
            <Route path="/view" component={Table} />
            <Route path="/" component={AddEmployee} />
        </Switch>
    );
  }
}

export default App;
