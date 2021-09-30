import React, { Component } from 'react'
import axios from "axios";
import { Table, Input, Tag, Space, Button} from 'antd';
import {
  BrowserRouter as Router,
  Switch,
  Route,
  Link
} from "react-router-dom";

const { Search } = Input;
class AntTable extends Component {
     
  constructor(props) {
       super(props) //since we are extending class Table so we have to use super in order to override Component class constructor
       this.state = {
           columns : [
               {
                 title: 'Name',
                 dataIndex: 'comment',
                 key: 'comment',
                 render: text => <a>{text}</a>,
               },
               {
                 title: 'postId',
                 dataIndex: 'postId',
                 key: 'postId',
               }
           ],

           data : [],
           data2 : [],
       }
  
   }

  getData(page){
    axios.get(`http://localhost:5000/comments`).then(response => {
      this.setState({data:response.data})
      this.setState({data2:response.data})
    } );
  }
  componentDidMount() {
    this.getData()
  }
  
  onSearch = (value) => {
    this.setState({data:this.state.data2.filter(o => o.comment.includes(value))})
  }

  
  
  getResult(){

    axios.defaults.withCredentials = true;
  

    axios.get(`http://localhost:8080/admin`).then(response => {
      console.log(response.data);
    });
    
  }


  render() {
   return (
        <div>
          <h1>Table Example</h1>
          <Search placeholder="input search text"  onSearch={this.onSearch} style={{ width: 200 }} />
          <Table columns={this.state.columns} dataSource={this.state.data}  pagination={{ defaultPageSize: 10, showSizeChanger: true, pageSizeOptions: ['10', '20', '30']}}/>
        </div>
     )
  }
}

export default AntTable //exporting a component make it reusable and this is the beauty of react