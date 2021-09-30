import React from "react";
import {
  BrowserRouter as Router,
  Switch,
  Route,
  Link,
  withRouter
} from "react-router-dom";
import axios from "axios";

function ProtectedRouteTest(){
    return <div>test</div>;
}

export default withRouter(ProtectedRouteTest);