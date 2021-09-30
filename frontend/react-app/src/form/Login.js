import React from 'react'
import axios from "axios";
import {Form,Input,Button,Modal} from 'antd';
import {useSelector, useDispatch} from 'react-redux';
import  { Redirect } from 'react-router-dom'
import { baseUrl } from '../const';
function Login(){
     
    const user = useSelector (state => state.user);
    const dispatch = useDispatch();
    axios.defaults.withCredentials = true;

    function onFinish(values) {

        const params = new URLSearchParams();
        params.append('username', values.username);
        params.append('password', values.password);
        axios.defaults.withCredentials = true
        
        axios(`${baseUrl}/login`, {
          method: "post",
          data: params,
          crossDomain: true,
          withCredentials: true
        }).then(response => {
        //axios.post(`${baseUrl}/login`, params).then(response => {
          
            if (typeof response.data !== 'string'){
                dispatch({type:"setUserLogin", data: response.data});
                localStorage.setItem('user', JSON.stringify(response.data));
            }
            else{
              Modal.error({
                title: 'Error',
                content: (
                  <div>
                    <p>Username or password is invalid </p>
                  </div>
                ),
                onOk() {},
              });
            }
        });
    };

    
    function onFinishFailed(errorInfo) {
        console.log('Failed:', errorInfo);
    };

    if (user.isAuth) {
      return <Redirect to = {{ pathname: "/" }} />;
    }

    return (
      
      <div>
      <h1>Login</h1>
      <br></br>
      <Form 
        layout="vertical" //vertical or horizontal
        name="basic"
        labelCol={{ span: 2 }}
        wrapperCol={{ span: 14 }}
        initialValues={{remember: true}}
        onFinish={onFinish}                    
        onFinishFailed={onFinishFailed}
      >

        <Form.Item
          label="User name"
          name="username"
          rules={[
            {
              required: true,
            },
          ]}
        >
          <Input />
        </Form.Item>   

        <Form.Item
          label="Password"
          name="password"
          rules={[
            {
              required: true,
              message: 'Your required message goes here',
            },
          ]}
        >
          <Input.Password  />
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

export default Login;