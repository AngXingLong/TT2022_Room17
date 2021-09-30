import React from 'react';

import 'antd/dist/antd.css';
import {useState} from 'react';
import { Card,Row,Button,Col } from 'antd';

const { Meta } = Card;
export const ShoppingCard =({imageSource,ProductTitle,ProductPrice,ProductQty}) => {
    const [count, setCount] = useState(ProductQty);

    const addCountHandler = () => {
        setCount(count + 1);
      };
      const removeCountHandler = () => {
        if(count === 0){
          return;  
        }
        setCount(count - 1);
      };
    return (<Row type="flex">
        <Col span={4}>
            <img  width="40%" height="70%" alt="example" src={imageSource} />
        </Col>
        <Col span={4}>
            <p>{ProductTitle}</p>
        </Col>
        <Col span={4}>
          <p>${ProductPrice}</p>
        </Col>
        <Col span={2}>
          <Button onClick={addCountHandler} htmlType="submit">
              +
          </Button>
        
        </Col> 
        <Col span={2}>
          <p>{count}</p>
        </Col>  
        <Col span={2}>
          <Button onClick={removeCountHandler} htmlType="submit">
              -
          </Button>
        </Col>  
    </Row>);
};
