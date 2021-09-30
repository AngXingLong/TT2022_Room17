import React from 'react';

import 'antd/dist/antd.css';
import {useState} from 'react';
import { Card,Row,Button } from 'antd';

const { Meta } = Card;
export const ProductCard =({imageSource,ProductTitle,ProductPrice}) => {
    const [count, setCount] = useState(0);
    const addCountHandler = () => {
        setCount(count + 1);
      };
      const removeCountHandler = () => {
        if(count === 0){
          return;  
        }
        setCount(count - 1);
      };
    return (<Card
        hoverable
        style={{ width: 240 }}
        cover={<img alt="example" src={imageSource} />}
      >
        <Meta title={ProductTitle}/>
        <div className="additional">
            <p className="price">${ProductPrice}</p>
            
        </div>
        <Row>
        <header>Qty:</header>
        <Button onClick={addCountHandler} htmlType="submit">
            +
          </Button>
          <p>  {count}  </p>
          <Button  onClick={removeCountHandler} htmlType="submit">
            -
          </Button>
        </Row>
        <Row>
        <Button type="primary" htmlType="submit" >
            Add To Cart
        </Button>
        </Row>
      </Card>);
};
