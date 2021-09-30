import React, { useState, useEffect } from 'react';
import { Column } from '@ant-design/charts';
import { Component } from 'react';

class AntColumnChart extends Component {
    constructor(props) {
        super(props)
        this.state = {
                config : {
                data: [
                    {
                    type: 'Team A',
                    sales: 38,
                    },
                    {
                    type: 'Team B',
                    sales: 52,
                    },
                    {
                    type: '生鲜水果',
                    sales: 61,
                    },
                    {
                    type: '美容洗护',
                    sales: 145,
                    },
                    {
                    type: '母婴用品',
                    sales: 48,
                    },
                    {
                    type: '进口食品',
                    sales: 38,
                    },
                    {
                    type: '食品饮料',
                    sales: 38,
                    },
                    {
                    type: '家庭清洁',
                    sales: 38,
                    },
                ],
                xField: 'type',
                yField: 'sales',
                label: {
                position: 'middle',
                style: {
                    fill: '#FFFFFF',
                    opacity: 0.6,
                },
                },
                xAxis: {
                label: {
                    autoHide: true,
                    autoRotate: false,
                },
                },
                meta: {
                type: { alias: 'Type' },
                sales: { alias: 'Sales' },
                },
            }
        }
    }
    render() {
        return (
        <Column {...this.state.config} />
        );
      }
}

export default AntColumnChart;