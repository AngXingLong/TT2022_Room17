import React, { Component } from 'react'
import axios from "axios";
import { Table, Tag, Space } from 'antd';
import {
  Form,
  Input,
  Button,
  Radio,
  Cascader,
  DatePicker,
  InputNumber,
  TreeSelect,
  Switch,
  Alert,
  Checkbox,
  Select,
  Rate
} from 'antd';

import { render } from '@testing-library/react';
const { Option } = Select;
class AntForm extends Component {
     
  constructor(props) {
       super(props) 
       this.state = {
        visible: false,
        value: ''
      };
  
   }

   onFinish = (values) => {
    console.log('Success:', values);
  
    axios.post("http://localhost:5000/user", values
    ).then(response => { 
        console.log(response.data);
        this.setState({popup: <Alert  
          message="Register Success"
          type="success"
          showIcon
          closable
        />})
    });
    
  };

  
  onFinishFailed = (errorInfo) => {
    console.log('Failed:', errorInfo);
  };

  render() {

    
    return (
      <div>
      <h1>Ant Form Example</h1>
      <br></br>

      {this.state.popup}

      <Form 
        layout="vertical" //vertical or horizontal
        name="basic"
        labelCol={{ span: 2 }}
        wrapperCol={{ span: 14 }}
        initialValues={{remember: true}}
        onFinish={this.onFinish}                    
        onFinishFailed={this.onFinishFailed}
      >

        <Form.Item
          label="Text Field"
          name="text"
          rules={[
            {
              required: true,
              message: 'Your required message goes here',
            },
          ]}
        >
          <Input />
        </Form.Item>      

        <Form.Item
          name="dropDown"
          label="Drop Down Field"
          >
          <Select defaultValue="Option 1" >
            <Option value="Option 1">Option 1</Option>
            <Option value="Option 2">Option 2</Option>
            <Option value="Option 3" disabled>Option 3</Option>
          </Select>
        </Form.Item>

        <Form.Item label="DatePicker">
          <DatePicker />
        </Form.Item>

        <Form.Item name="number" label="Number Field" rules={[{ type: 'number', min: 0, max: 99 }]}>
          <InputNumber />
        </Form.Item>

        <Form.Item
          name="rating"
          label="Rating"
        >
          <Rate />
        </Form.Item>

        <Form.Item
          name="checkBox"
          valuePropName="checked"
        >
          <Checkbox>Check Box Field</Checkbox>
        </Form.Item>

        <Form.Item>
          <Button type="primary" htmlType="submit">
            Submit
          </Button>
        </Form.Item>

      </Form>
      </div>
    );
  }
}

export default AntForm;