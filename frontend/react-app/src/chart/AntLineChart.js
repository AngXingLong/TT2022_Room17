import React, { useState, useEffect } from 'react';
import { Line } from '@ant-design/charts';
import { Component } from 'react';
import axios from "axios";

class AntLineChart extends Component {
  constructor(props) {
    super(props);

    this.state = {
      config : {
        data: [],
        padding: 'auto',
        xField: 'Date',
        yField: 'scales',
        label: {},
        point: {
          size: 5,
          shape: 'diamond',
          style: {
            fill: 'white',
            stroke: '#5B8FF9',
            lineWidth: 2,
          },
        },
        tooltip: { showMarkers: false },
        state: {
          active: {
            style: {
              shadowBlur: 4,
              stroke: '#000',
              fill: 'red',
            },
          },
        },
        interactions: [{ type: 'marker-active' }],
      }
    }
  }

  componentDidMount() {
    this.asyncFetch()
  }

  asyncFetch = () => {


    axios.get("https://gw.alipayobjects.com/os/bmw-prod/1d565782-dde4-4bb6-8946-ea6a38ccf184.json",{withCredentials: false}).then(response => { 
        this.setState({ config: { ...this.state.config, data: response.data} })
    });

    /*

    fetch('https://gw.alipayobjects.com/os/bmw-prod/1d565782-dde4-4bb6-8946-ea6a38ccf184.json')
      .then((response) => response.json())
      .then((json) =>  {
          
          this.setState({ config: { ...this.state.config, data: json} })
          console.log(this.state.config.data)
        }
         
      ) 
      .catch((error) => {
        console.log('fetch data failed', error);
      });
      */
  };

  render() {
    return (
    <Line {...this.state.config} />
    );
  }


}



export default AntLineChart;