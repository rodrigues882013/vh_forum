import React from 'react';
import { NavLink } from 'react-router-dom';
import PropTypes from 'prop-types';



const Thread = ({topic}) => {
    return (
        <NavLink to={`/topic/${topic.id}`} className="list-group-item list-group-item-action flex-column align-items-start">
            <div className="d-flex w-100 justify-content-between">
                <h5 className="mb-1">{topic.title}</h5>
                <small>
                    <img src="#" alt="..." className="img-thumbnail thumb"/>
                </small>
            </div>
            <p className="mb-1">{topic.text}</p>
            <small>Criado por {topic.user.username}  {topic.created} </small>
        </NavLink>
    )
};

Thread.propTypes = {
    topic: PropTypes.object.isRequired
};

export default Thread;