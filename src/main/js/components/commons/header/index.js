import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import PropTypes from 'prop-types';



const Header = ({title, text=null, icon}) => {
    return (
        <div className="card">
            <div className="card-body">
                <div className="row">
                    <div className="col-md-1">
                        {icon}
                    </div>

                    <div className="col-md-9">
                        <h4 className="card-title">{title}</h4>
                        <p className="card-text">{text}</p>
                    </div>
                </div>
            </div>
        </div>

    );
};

export default Header;